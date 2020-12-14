package dao;

import Hibernate.HibernateSessionFactoryUtil;
import models.Subject;

import java.util.List;

public class Subject_dao extends Main_dao<Subject>{
    public Subject findById(int id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Subject.class, id);
    }

    public List<Subject> findAll(){
        return (List<Subject>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Subject").list();
    }
}
