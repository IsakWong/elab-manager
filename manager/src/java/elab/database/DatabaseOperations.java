package elab.database;

import elab.serialization.sqlmap.member;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

public class DatabaseOperations {
    private SqlSessionFactory sqlSessionFactory;

    private SqlSession session;

    public void build() {
        try {
            //读取mybatis-config.xml文件
            Reader resourceAsStream = Resources.getResourceAsReader("mybatis-config.xml");
            //初始化mybatis,创建SqlSessionFactory类的实例
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            //创建Session实例
            session = sqlSessionFactory.openSession();

            member member = session.selectOne("test.findMemberByUserName", "asd");

            System.out.println(member);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
