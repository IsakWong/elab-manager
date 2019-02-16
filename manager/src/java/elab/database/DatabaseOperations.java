package elab.database;

import elab.serialization.beans.member.LoginMessage;
import elab.serialization.beans.member.Member;
import elab.serialization.beans.new_person.NewPerson;
import elab.serialization.beans.school_opening_information.SchoolOpeningInformation;
import elab.serialization.beans.student.Student;
import javafx.collections.ObservableList;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;
import java.util.List;

public class DatabaseOperations {

    private static SqlSessionFactory studentSqlSessionFactory = null;
    private static SqlSessionFactory classSqlSessionFactory = null;
    private static SqlSessionFactory recruitNewSqlSessionFactory = null;

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
                Reader elabRecruitNew = Resources.getResourceAsReader("database/mybatis-config.xml");
                recruitNewSqlSessionFactory = new SqlSessionFactoryBuilder().build(elabRecruitNew, "recruitNew");

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
            return session.selectOne("member.selectLoginMessage", number);
        } finally {
            session.close();
        }
    }

    public List selectMemberByName(String name) {
        SqlSession session = studentSqlSessionFactory.openSession();
        try {
            return session.selectList("member.selectMemberByName", name);
        } finally {
            session.close();
        }
    }

    public List selectMemberByNumber(String number) {
        SqlSession session = studentSqlSessionFactory.openSession();
        try {
            return session.selectList("member.selectMemberByNumber", number);
        } finally {
            session.close();
        }
    }

    public List selectMemberByCollege(String college) {
        SqlSession session = studentSqlSessionFactory.openSession();
        try {
            return session.selectList("member.selectMemberByCollege", college);
        } finally {
            session.close();
        }
    }

    public List selectAllMembers() {
        SqlSession session = studentSqlSessionFactory.openSession();
        try {
            return session.selectList("member.selectAllMembers");
        } finally {
            session.close();
        }
    }

    public List selectInSchoolMembers() {
        SqlSession session = studentSqlSessionFactory.openSession();
        try {
            return session.selectList("member.selectInSchoolMembers");
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
            return session.selectList("student.selectStudentByName", name);
        } finally {
            session.close();
        }
    }

    public List selectStudentByNumber(String number) {
        SqlSession session = classSqlSessionFactory.openSession();
        try {
            return session.selectList("student.selectStudentByNumber", number);
        } finally {
            session.close();
        }
    }

    public List selectStudentByCollege(String college) {
        SqlSession session = classSqlSessionFactory.openSession();
        try {
            return session.selectList("student.selectStudentByCollege", college);
        } finally {
            session.close();
        }
    }

    public List selectAllStudents() {
        SqlSession session = classSqlSessionFactory.openSession();
        try {
            return session.selectList("student.selectAllStudents");
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

    public List selectRota() {
        SqlSession session = studentSqlSessionFactory.openSession();
        try {
            return session.selectList("student.selectRota");
        } finally {
            session.close();
        }
    }

    public List selectAllLogs() {
        SqlSession session = studentSqlSessionFactory.openSession();
        try {
            return session.selectList("student.selectAllLogs");
        } finally {
            session.close();
        }
    }

    public void setDuty(String name) {
        SqlSession session = studentSqlSessionFactory.openSession();
        try {
            session.update("member.setDuty", name);
            session.commit();
        } finally {
            session.close();
        }
    }

    public void removeDuty(String name) {
        SqlSession session = studentSqlSessionFactory.openSession();
        try {
            session.update("member.removeDuty", name);
            session.commit();
        } finally {
            session.close();
        }
    }

    public List selectNewPeople() {
        SqlSession session = recruitNewSqlSessionFactory.openSession();
        try {
             return session.selectList("recruitNew.selectNewPeople");
        } finally {
            session.close();
        }
    }

    public void insertNewPerson(NewPerson newPerson) {
        SqlSession session = recruitNewSqlSessionFactory.openSession();
        try {
            session.insert("recruitNew.insertNewPerson", newPerson);
            session.commit();
        } finally {
            session.close();
        }
    }

    public void updateNewPerson(NewPerson newPerson) {
        SqlSession session = recruitNewSqlSessionFactory.openSession();
        try {
            session.update("recruitNew.updateNewPerson", newPerson);
            session.commit();
        } finally {
            session.close();
        }
    }

    public void deleteNewPerson(String number) {
        SqlSession session = recruitNewSqlSessionFactory.openSession();
        try {
            session.delete("recruitNew.deleteNewPerson", number);
            session.commit();
        } finally {
            session.close();
        }
    }

    public void deleteNewPeople(ObservableList<NewPerson> newPeople) {
        SqlSession session = recruitNewSqlSessionFactory.openSession();
        try {
            for(NewPerson newPerson : newPeople)
                session.delete("recruitNew.deleteNewPerson", newPerson.getNumber());
            session.commit();
        } finally {
            session.close();
        }
    }
}
