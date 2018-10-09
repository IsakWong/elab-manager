package elab.database;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class DatabaseHelper {
    private static DatabaseHelper instance = null;

    private SqlSessionFactory factory;

    public DatabaseHelper getInstance()
    {
        return instance == null ? instance = new DatabaseHelper() : instance;
    }

    protected DatabaseHelper()
    {
        InputStream inputStream = getClass().getResourceAsStream("/maria_db.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        factory = builder.build(inputStream);
    }

}

