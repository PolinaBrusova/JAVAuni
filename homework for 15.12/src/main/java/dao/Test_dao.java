package dao;

import Hibernate.HibernateSessionFactoryUtil;
import models.Test;

import java.util.List;

public class Test_dao extends Main_dao<Test>{
    public Test findById(int id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Test.class, id);
    }

    public List<Test> findAll(){
        return (List<Test>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Test").list();
    }
}
