package services;

import dao.Role_dao;
import models.Role;

public class Role_service {
    private Role_dao roleDao = new Role_dao();

    public Role_service(){}

    public void saveRole(Role Role){
        roleDao.save(Role);
    }

    public Role findRole(int id){
        return roleDao.findById(id);
    }
}
