package elab.database;

import com.sun.org.apache.xpath.internal.operations.Bool;
import elab.database.mappers.RotaOperations;
import elab.database.mappers.SelectExistTable;
import elab.database.mappers.SelectOperations;
import elab.database.mappers.TableOperations;
import elab.serialization.beans.free_time.FreeTime;
import elab.serialization.beans.rota.Rota;
import elab.serialization.beans.log.Log;
import elab.serialization.beans.member.LoginMessage;
import elab.serialization.beans.member.Member;
import elab.serialization.beans.new_person.NewPerson;
import elab.serialization.beans.school_opening_information.SchoolOpeningInformation;
import elab.serialization.beans.student.Student;
import javafx.collections.ObservableList;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.swing.text.html.ListView;
import java.io.Reader;
import java.util.List;
import java.util.Map;

public class DatabaseOperations {

    private static SqlSessionFactory studentSqlSessionFactory = null;
    private static SqlSessionFactory classSqlSessionFactory = null;
    private static SqlSessionFactory recruitNewSqlSessionFactory = null;
    private static SqlSessionFactory informationSchemaFactory = null;

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
            Reader informationSchemaReader = Resources.getResourceAsReader("database/mybatis-config.xml");
            informationSchemaFactory = new SqlSessionFactoryBuilder().build(informationSchemaReader, "informationSchema");
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

    public SchoolOpeningInformation selectSchoolOpeningDateInformation() {
        SqlSession session = studentSqlSessionFactory.openSession();
        try {
            return session.selectOne("student.selectSchoolOpeningDate");
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

    public List selectAllLogs(String term) {
        SqlSession session = studentSqlSessionFactory.openSession();
        try {
            return session.selectList("student.selectAllLogs", term);
        } finally {
            session.close();
        }
    }

    public List selectLoader(String date) {
        SqlSession session = studentSqlSessionFactory.openSession();
        try {
            return session.selectList("student.selectLoader", date);
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

    public List selectAllFreeTime(String term) {
        SqlSession session = studentSqlSessionFactory.openSession();
        try {
            return session.selectList("student.selectAllFreeTime", term);
        } finally {
            session.close();
        }
    }

    public FreeTime selectFreeTime(FreeTime freeTime) {
        SqlSession session = studentSqlSessionFactory.openSession();
        try {
            return session.selectOne("member.selectFreeTime", freeTime);
        } finally {
            session.close();
        }
    }

    public List selectAllStudents(String tableName) {
        SqlSession session = classSqlSessionFactory.openSession();
        SqlSession session1 = informationSchemaFactory.openSession();
        SelectExistTable selectExistTable = session1.getMapper(SelectExistTable.class);
        try {
            Integer count =selectExistTable.checkTableExistsWithSchema("class", tableName);
            if(count != 0) {
                SelectOperations selectOperations = session.getMapper(SelectOperations.class);
                return selectOperations.selectAllStudents(tableName);
            } else {
                return null;
            }

            /* 使用show tables检查表是否存在

            Map<String, String> list = selectExistTable.checkTableExistsWithShow(tableName);
            if(!list.isEmpty()) {
                SelectOperations selectOperations = session.getMapper(SelectOperations.class);
                return selectOperations.selectAllStudents(tableName);
            } else {
                return null;
            }

            */
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
            session1.close();
        }
    }

    public Boolean insertMember(Member member) {
        SqlSession session = studentSqlSessionFactory.openSession();
        try {
            session.insert("member.insertMember", member);
            session.commit();
            return true;
        } finally {
            session.close();
        }
    }

    public Boolean insertNewPerson(NewPerson newPerson) {
        SqlSession session = recruitNewSqlSessionFactory.openSession();
        try {
            session.insert("recruitNew.insertNewPerson", newPerson);
            session.commit();
            return true;
        } finally {
            session.close();
        }
    }

    public Boolean writeLog(Log log) {
        SqlSession session = studentSqlSessionFactory.openSession();
        try {
            session.insert("student.writeLog", log);
            session.commit();
            return true;
        } finally {
            session.close();
        }
    }

    public Boolean insertFreeTime(FreeTime freeTime) {
        SqlSession session = studentSqlSessionFactory.openSession();
        try {
            session.insert("student.insertFreeTime", freeTime);
            session.commit();
            return true;
        } finally {
            session.close();
        }
    }

    public Boolean leadingInRota(List<Rota> rotas) {
        SqlSession session = studentSqlSessionFactory.openSession();
        try {
            TableOperations tableOperations = session.getMapper(TableOperations.class);
            tableOperations.deleteTable("duty");
            RotaOperations rotaOperations = session.getMapper(RotaOperations.class);
            rotaOperations.createRota("duty");
            rotaOperations.insertRota(rotas, "duty");
            session.commit();
            return true;
        } finally {
            session.close();
        }
    }

    public Boolean updateGrade() {
        SqlSession session = studentSqlSessionFactory.openSession();
        try {
            session.update("member.updateGrade");
            session.commit();
            return true;
        } finally {
            session.close();
        }
    }

    public Boolean updateMember(LoginMessage loginMessage) {
        SqlSession session = studentSqlSessionFactory.openSession();
        try {
            session.update("member.updateMember", loginMessage);
            session.commit();
            return true;
        } finally {
            session.close();
        }
    }

    public Boolean setSchoolOpeningDateInformation(SchoolOpeningInformation schoolOpeningInformation) {
        SqlSession session = studentSqlSessionFactory.openSession();
        try {
            session.update("member.setSchoolOpeningDateInformation", schoolOpeningInformation);
            session.commit();
            return true;
        } finally {
            session.close();
        }
    }

    public Boolean updateScore(Student student) {
        SqlSession session = classSqlSessionFactory.openSession();
        try {
            session.update("student.updateScore", student);
            session.commit();
            return true;
        } finally {
            session.close();
        }
    }

    public Boolean updateNewPerson(NewPerson newPerson) {
        SqlSession session = recruitNewSqlSessionFactory.openSession();
        try {
            session.update("recruitNew.updateNewPerson", newPerson);
            session.commit();
            return true;
        } finally {
            session.close();
        }
    }

    public Boolean removeDuty(String name) {
        SqlSession session = studentSqlSessionFactory.openSession();
        try {
            session.update("member.removeDuty", name);
            session.commit();
            return true;
        } finally {
            session.close();
        }
    }

    public Boolean setDuty(String name) {
        SqlSession session = studentSqlSessionFactory.openSession();
        try {
            session.update("member.setDuty", name);
            session.commit();
            return true;
        } finally {
            session.close();
        }
    }

    public Boolean updateFreeTime(FreeTime freeTime) {
        SqlSession session = studentSqlSessionFactory.openSession();
        try {
            session.update("member.updateFreeTime", freeTime);
            session.commit();
            return true;
        } finally {
            session.close();
        }
    }

    public Boolean deleteNewPerson(String number) {
        SqlSession session = recruitNewSqlSessionFactory.openSession();
        try {
            session.delete("recruitNew.deleteNewPerson", number);
            session.commit();
            return true;
        } finally {
            session.close();
        }
    }

    public Boolean deleteNewPeople(ObservableList<NewPerson> newPeople) {
        SqlSession session = recruitNewSqlSessionFactory.openSession();
        try {
            for(NewPerson newPerson : newPeople)
                session.delete("recruitNew.deleteNewPerson", newPerson.getNumber());
            session.commit();
            return true;
        } finally {
            session.close();
        }
    }
}
