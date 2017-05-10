import com.fzy.modules.student.entity.Students;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * Created by fuzhongyu on 2017/5/10.
 */
public class StudentsTest {

    private SessionFactory sessionFactory;
    private Session session;
    private Session session1;
    private Transaction transaction;

    @Before
    public void init(){
        StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure().build();
        Metadata metadata = new MetadataSources(standardRegistry).getMetadataBuilder().applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE).build();
        sessionFactory = metadata.getSessionFactoryBuilder().build();

        /**
         * getCurrentSession 在事务提交或者回滚之后会自动关闭，而openSession需要你手动关闭，如果使用openSession而没有手动关闭则会导致连接池溢出；
         *
         * openSession每次创建新的session对象，getCurrentSession使用现有的session对象(相当于单例)
         */
        // 会话对象
        session = sessionFactory.openSession();
        //这种session方式需要在hibernate.cfg.xml中配置 <property name="hibernate.current_session_context_class">thread</property>
        session1=sessionFactory.getCurrentSession();
        // 开启事务
        transaction = session.beginTransaction();
    }

    @After
    public void destory(){
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    @Test
    public void test1(){
//        Students students1=new Students(1,"fzy","0",new Date(),"hz");
//        session.save(students1);

//        Students students4=new Students(2,"fzy2","0",new Date(),"zj");
//        session.save(students4);

//        Students students5=session.get(Students.class,1);
//        System.out.println(students5.getName());

//        Students students2=new Students(1,"fzy2","0",new Date(),"sx");
//        session.update(students2);

//        Students students3=new Students();
//        students3.setId(2);
//        session.delete(students3);

        /**
         * hql查询
         */
//        String hql="from Students";
//        Query query=session.createQuery(hql);
//        List<Students> list=query.list();
//        System.out.println(list.get(0).toString());

        /**
         * 自定义list类型查询
         */
//        String hql="select new list(id,name,gender) from Students";
//        Query query3=session.createQuery(hql);
//        List<List<Object>> list3=query3.list();
//        for(List l:list3){
//            System.out.println(l.get(1));
//        }

        /**
         * 自定义map类型查询
         */
//        String hql="select new map(id,name,gender) from Students";
//        Query query4=session.createQuery(hql);
//        List<Map> list4=query4.list();
//        for(Map m:list4){
//            System.out.println(m.get("1"));
//        }
//
//        String hql1="select new map(id as id,name as nam) from Students";
//        Query query5=session.createQuery(hql1);
//        List<Map> list5=query5.list();
//        for(Map m:list5){
//            System.out.println(m.get("nam"));
//        }


        /**
         * 自定义对象类型查询
         */
//        //需要这样的构造器（要保留无参构造器mapping中会用到）
//        String hql="select new Students(id,name) from Students";
//        Query query2=session.createQuery(hql);
//        List<Students> list2=query2.list();
//        System.out.println(list2.get(0).getName());

        /**
         * hql查询，传入参数
         */
        String hql="from Students where name=:name";
        Query query6=session.createQuery(hql);
        query6.setParameter("name","fzy1");
       Students stu= (Students) query6.uniqueResult();
        System.out.println(stu.getName());



        /**
         * sql查询
         */
//        String sql="select name from students where id=1";
//        Query query1=session.createNativeQuery(sql);
////        List<String> list1=query1.list();
//        String name= (String) query1.uniqueResult();
//        System.out.println(name);


    }
}
