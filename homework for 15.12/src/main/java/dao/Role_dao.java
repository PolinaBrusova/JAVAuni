package dao;

import Hibernate.HibernateSessionFactoryUtil;
import models.Role;

import java.util.List;

public class Role_dao extends Main_dao<Role>{
    public Role findById(int id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Role.class, id);
    }

    public List<Role> findAll(){
        return (List<Role>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Role").list();
    }
}
