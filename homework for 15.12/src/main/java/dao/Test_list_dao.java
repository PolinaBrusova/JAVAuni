package dao;

import Hibernate.HibernateSessionFactoryUtil;
import models.Test_list;

import java.util.List;

public class Test_list_dao extends Main_dao<Test_list> {
    public Test_list findById(int id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Test_list.class, id);
    }

    public List<Test_list> findAll(){
        return (List<Test_list>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Test_list").list();
    }
}
