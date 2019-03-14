package elab.database.mappers;

import elab.serialization.beans.Rota;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RotaOperations {

    void createRota(@Param("rotaName")String rotaName);
    void insertRota(@Param("rotas")List<Rota> rotas, @Param("tableName")String tableName);
}
