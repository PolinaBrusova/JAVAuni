package dao;

import Hibernate.HibernateSessionFactoryUtil;
import models.Answer;
import java.util.List;
public class Answer_dao extends Main_dao<Answer>{
    public Answer findById(int id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Answer.class, id);
    }

    public List<Answer> findAll(){
        return (List<Answer>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Answer").list();
    }
}
