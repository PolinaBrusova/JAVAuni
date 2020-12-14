package dao;

import Hibernate.HibernateSessionFactoryUtil;
import models.Schedule;

import java.util.List;

public class Schedule_dao extends Main_dao<Schedule>{
    public Schedule findById(int id){
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Schedule.class, id);
    }

    public List<Schedule> findAll(){
        return (List<Schedule>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Schedule").list();
    }
}
