package elab.database;

import elab.serialization.beans.member.LoginMessage;
import elab.serialization.beans.member.Member;
import elab.serialization.beans.school_opening_information.SchoolOpeningInformation;
import elab.serialization.beans.student.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.List;

public class DatabaseOperations {

    private static SqlSessionFactory studentSqlSessionFactory = null;
    private static SqlSessionFactory classSqlSessionFactory = null;

    private static DatabaseOperations instance = null;

    public static DatabaseOperations getInstance() {
        return instance == null ? instance = new DatabaseOperations() : instance;
    }

    protected DatabaseOperations() {
        try {
                //读取mybatis-config.xml文件
                Reader studentReader = Resources.getResourceAsReader("database/mybatis-config.xml");
                //初始化mybatis,创建SqlSessionFactory类的实例
                studentSqlSessionFactory = new SqlSessionFactoryBuilder().build(studentReader, "student");
                Reader classReader = Resources.getResourceAsReader("database/mybatis-config.xml");
                classSqlSessionFactory = new SqlSessionFactoryBuilder().build(classReader, "class");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public SqlSession getSession() {
        return studentSqlSessionFactory.openSession();
    }

    public LoginMessage selectLoginMessage(String number) {
        SqlSession session = studentSqlSessionFactory.openSession();
        try {
            LoginMessage loginMessage = session.selectOne("member.selectLoginMessage", number);
            return loginMessage;
        } finally {
            session.close();
        }
    }

    public List selectMemberByName(String name) {
        SqlSession session = studentSqlSessionFactory.openSession();
        try {
            List member = session.selectList("member.selectMemberByName", name);
            return member;
        } finally {
            session.close();
        }
    }

    public List selectMemberByNumber(String number) {
        SqlSession session = studentSqlSessionFactory.openSession();
        try {
            List member = session.selectList("member.selectMemberByNumber", number);
            return member;
        } finally {
            session.close();
        }
    }

    public List selectMemberByCollege(String college) {
        SqlSession session = studentSqlSessionFactory.openSession();
        try {
            List member = session.selectList("member.selectMemberByCollege", college);
            return member;
        } finally {
            session.close();
        }
    }

    public List selectAllMembers() {
        SqlSession session = studentSqlSessionFactory.openSession();
        try {
            List members = session.selectList("member.selectAllMembers");
            return members;
        } finally {
            session.close();
        }
    }

    public void insertMember(Member member) {
        SqlSession session = studentSqlSessionFactory.openSession();
        try {
            session.insert("member.insertMember", member);
            session.commit();
        } finally {
            session.close();
        }
    }

    public void updateMember(LoginMessage loginMessage) {
        SqlSession session = studentSqlSessionFactory.openSession();
        try {
            session.update("member.updateMember", loginMessage);
            session.commit();
        } finally {
            session.close();
        }
    }

    public void deleteMember(){
        SqlSession session = studentSqlSessionFactory.openSession();
        try {
            session.commit();
        } finally {
            session.close();
        }
    }

    public List selectStudentByName(String name) {
        SqlSession session = classSqlSessionFactory.openSession();
        try {
            List student = session.selectList("student.selectStudentByName", name);
            return student;
        } finally {
            session.close();
        }
    }

    public List selectStudentByNumber(String number) {
        SqlSession session = classSqlSessionFactory.openSession();
        try {
            List student = session.selectList("student.selectStudentByNumber", number);
            return student;
        } finally {
            session.close();
        }
    }

    public List selectStudentByCollege(String college) {
        SqlSession session = classSqlSessionFactory.openSession();
        try {
            List student = session.selectList("student.selectStudentByCollege", college);
            return student;
        } finally {
            session.close();
        }
    }

    public List selectAllStudents() {
        SqlSession session = classSqlSessionFactory.openSession();
        try {
            List students = session.selectList("student.selectAllStudents");
            return students;
        } finally {
            session.close();
        }
    }

    public void updateScore(Student student) {
        SqlSession session = classSqlSessionFactory.openSession();
        try {
            session.update("student.updateScore", student);
            session.commit();
        } finally {
            session.close();
        }
    }

    public SchoolOpeningInformation selectSchoolOpeningDateInformation() {
        SqlSession session = studentSqlSessionFactory.openSession();
        try {
            SchoolOpeningInformation schoolOpeningInformation = session.selectOne("student.selectSchoolOpeningDate");
            return schoolOpeningInformation;
        } finally {
            session.close();
        }
    }
}
