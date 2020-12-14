package services;

import dao.Group_dao;
import models.Group;

public class Group_service {
    private Group_dao groupDao = new Group_dao();

    public Group_service(){}

    public void saveGroup(Group group){
        groupDao.save(group);
    }

    public Group findGroup(int id){
        return groupDao.findById(id);
    }
}
