package dao;

import Hibernate.HibernateSessionFactoryUtil;
import models.Group;

import java.util.List;

public class Group_dao extends Main_dao<Group>{
    public Group findById(int id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Group.class, id);
    }

    public List<Group> findAll(){
        return (List<Group>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Group").list();
    }
}
