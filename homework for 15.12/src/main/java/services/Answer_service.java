package services;

import dao.Answer_dao;
import models.Answer;

public class Answer_service {
    private Answer_dao answerDao = new Answer_dao();

    public Answer_service(){}

    public void saveAnswer(Answer answer){
        answerDao.save(answer);
    }

    public Answer findAnswer(int id){
        return answerDao.findById(id);
    }
}
