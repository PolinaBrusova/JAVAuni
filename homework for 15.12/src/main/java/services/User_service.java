package services;

import dao.User_dao;
import models.User;

import java.util.List;

public class User_service {
    private User_dao userDao = new User_dao();

    public User_service(){}

    public void saveUser(User user){
        userDao.save(user);
    }

    public User findUser(int id){
        return userDao.findById(id);
    }
    public List<User> getTeachers() { return userDao.getTeachers(); }
    public List<User> getStudents() { return userDao.getStudents(); }
}
