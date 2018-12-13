package elab.database;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class DatabaseOperations {
    private SqlSessionFactory sqlSessionFactory;

    private SqlSession session;

    public void build() {
        try {
            //读取mybatis-config.xml文件
            InputStream resourceAsStream = Resources.getResourceAsStream("/mybatis-config.xml");
            //初始化mybatis,创建SqlSessionFactory类的实例
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //创建Session实例
            session = sqlSessionFactory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
