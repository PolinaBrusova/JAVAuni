package services;

import dao.Question_dao;
import models.Question;

public class Question_service {
    private Question_dao questionDao = new Question_dao();

    public Question_service(){}

    public void saveQuestion(Question Question){
        questionDao.save(Question);
    }

    public Question findQuestion(int id){
        return questionDao.findById(id);
    }
}
