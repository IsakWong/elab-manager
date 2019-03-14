package elab.database.mappers;

import org.apache.ibatis.annotations.Param;

public interface TableOperations {

    void deleteTable(@Param("tableName")String tableName);
}
