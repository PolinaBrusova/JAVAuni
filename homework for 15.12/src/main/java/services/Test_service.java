package services;

import dao.Test_dao;
import models.Test;

public class Test_service {
    private Test_dao testDao = new Test_dao();

    public Test_service(){}

    public void saveTest(Test test){
        testDao.save(test);
    }

    public Test findTest(int id){
        return testDao.findById(id);
    }
}
