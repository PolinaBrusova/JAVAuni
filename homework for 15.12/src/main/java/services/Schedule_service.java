package services;

import dao.Schedule_dao;
import models.Schedule;

public class Schedule_service {
    private Schedule_dao scheduleDao = new Schedule_dao();

    public Schedule_service(){}

    public void saveSchedule(Schedule Schedule){
        scheduleDao.save(Schedule);
    }

    public Schedule findSchedule(int id){
        return scheduleDao.findById(id);
    }
}
