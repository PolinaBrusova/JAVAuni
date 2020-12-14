package Hibernate;

import models.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil(){}

    public static SessionFactory getSessionFactory(){
        if(sessionFactory == null){
            try{
                StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder()
                        .configure()
                        .build();
                MetadataSources metadataSources = new MetadataSources(standardServiceRegistry);
                metadataSources.addAnnotatedClass(Answer.class);
                metadataSources.addAnnotatedClass(Question.class);
                metadataSources.addAnnotatedClass(Group.class);
                metadataSources.addAnnotatedClass(Role.class);
                metadataSources.addAnnotatedClass(Schedule.class);
                metadataSources.addAnnotatedClass(Student_answer.class);
                metadataSources.addAnnotatedClass(Subject.class);
                metadataSources.addAnnotatedClass(Test.class);
                metadataSources.addAnnotatedClass(Test_list.class);
                metadataSources.addAnnotatedClass(User.class);
                Metadata metadata = metadataSources.getMetadataBuilder().build();
                sessionFactory = metadata.getSessionFactoryBuilder().build();

            }catch (Exception e){
                e.printStackTrace();
            }
        }
        System.out.println(sessionFactory);
        return sessionFactory;

    }
}
