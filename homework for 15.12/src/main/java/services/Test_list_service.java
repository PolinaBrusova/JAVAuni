package services;

import dao.Test_list_dao;
import models.Test_list;

public class Test_list_service {
    private Test_list_dao test_listDao = new Test_list_dao();

    public Test_list_service(){}

    public void saveTest_list(Test_list test_list){
        test_listDao.save(test_list);
    }

    public Test_list findTest_list(int id){
        return test_listDao.findById(id);
    }
}
