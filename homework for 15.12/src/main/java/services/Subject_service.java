package services;

import dao.Subject_dao;
import models.Subject;

public class Subject_service {
    private Subject_dao subjectDao = new Subject_dao();

    public Subject_service(){}

    public void saveSubject(Subject subject){
        subjectDao.save(subject);
    }

    public Subject findSubject(int id){
        return subjectDao.findById(id);
    }
}
