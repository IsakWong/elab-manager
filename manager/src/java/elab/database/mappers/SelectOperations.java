package elab.database.mappers;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SelectOperations {

    List selectAllStudents(@Param("tableName")String tableName);
}
