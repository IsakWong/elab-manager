package elab.database.mappers;

import elab.serialization.beans.student.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentNameListOperations {

    void createStudentNameList(@Param("studentNameListName")String studentNameListName);
    void insertStudentNameList(@Param("students") List<Student> students, @Param("tableName")String tableName);
}
