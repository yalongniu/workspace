package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.SelectBeforeUpdate;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import table.StudentsEntity;

import java.sql.Date;

/**
 * @author niuyalong
 * @version v1.0
 * @date 2019/6/17 21:58
 * @description 测试类
 */
public class StuentsTest {
    private SessionFactory sessionFactoryl;

    private Session session;

    private Transaction transaction;

    @Before
    public void init(){
        //创建配置对象
        Configuration configure = new Configuration().configure();

        //创建服务注册对象
        StandardServiceRegistry serviceRegistry  = new StandardServiceRegistryBuilder().configure().build();

        sessionFactoryl = configure.buildSessionFactory();

       session = sessionFactoryl.openSession();

       transaction = session.beginTransaction();


    }

    @Test
    public void testSaveStudents() {

        StudentsEntity student = new StudentsEntity();

        student.setSid(2);

        student.setSname("张三丰");

        student.setGender("男" );

        student.setBirthday(new Date(1));

        student.setAddress("大昌南路18号");

        session.save(student);
    }




    @After
    public void destory(){
        transaction.commit();

        session.close();

        sessionFactoryl.close();
    }



}
