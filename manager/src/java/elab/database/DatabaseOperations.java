package elab.database;

import elab.serialization.member.LoginMessage;
import elab.serialization.member.Member;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class DatabaseOperations {

    private static SqlSessionFactory sqlSessionFactory = null;

    private static DatabaseOperations instance = null;

    public static DatabaseOperations getInstance() {
        return instance == null ? instance = new DatabaseOperations() : instance;
    }

    protected DatabaseOperations() {
        try {
                //读取mybatis-config.xml文件
                Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
                //初始化mybatis,创建SqlSessionFactory类的实例
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public SqlSession getSession() {
        return sqlSessionFactory.openSession();
    }

    public LoginMessage selectLoginMessage(int number) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            LoginMessage loginMessage = session.selectOne("member.selectLoginMessage", number);
            return loginMessage;
        } finally {
            session.close();
        }
    }

    public Member selectMember(int number) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            Member member = session.selectOne("member.selectMember", number);
            System.out.println(member);
            return member;
        } finally {
            session.close();
        }
    }

    public List selectAllMembers() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            List members = session.selectList("member.selectAllMembers");
            return members;
        } finally {
            session.close();
        }
    }

    public void insertMember(Member member) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.insert("member.insertMember", member);
            session.commit();
        } finally {
            session.close();
        }
    }

    public void updateMember(LoginMessage loginMessage) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.update("member.updateMember", loginMessage);
            session.commit();
        } finally {
            session.close();
        }
    }

    public void updateRemark(LoginMessage loginMessage) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.update("member.updateRemark", loginMessage);
            session.commit();
        } finally {
            session.close();
        }
    }

    public void delete(){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.commit();
        } finally {
            session.close();
        }
    }
}
