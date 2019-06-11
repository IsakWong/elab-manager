package elab.database.mappers;

import org.apache.ibatis.annotations.Param;

import java.util.Map;

public interface SelectExistTable {

    /**
     * 使用information_schema检查表是否存在
     * @param tableSchema
     * @param tableName
     * @return
     */
    Integer checkTableExistsWithSchema(@Param("tableSchema")String tableSchema, @Param("tableName")String tableName);

    /**
     * 使用show tables检查表是否存在
     * @param tableName
     * @return
     */
    Map<String, String> checkTableExistsWithShow(@Param("tableName")String tableName);
}
