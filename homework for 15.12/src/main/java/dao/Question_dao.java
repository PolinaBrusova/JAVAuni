package dao;

import Hibernate.HibernateSessionFactoryUtil;
import models.Question;

import java.util.List;

public class Question_dao extends Main_dao<Question> {
    public Question findById(int id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Question.class, id);
    }

    public List findAll(){
        System.out.println(HibernateSessionFactoryUtil.getSessionFactory().openSession());
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Question").getResultList();
    }
}
