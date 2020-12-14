package services;

import dao.Student_answer_dao;
import models.Student_answer;
import models.Test_list;

import java.util.List;

public class Student_answer_service {
    private Student_answer_dao student_answerDao = new Student_answer_dao();

    public Student_answer_service(){}

    public void saveStudent_answer(Student_answer student_answer){
        student_answerDao.save(student_answer);
    }

    public Student_answer findStudent_answer(int id){
        return student_answerDao.findById(id);
    }

    public List<Test_list> getTestsByStudentId(int id) {
        return student_answerDao.getTestsByStudentId(id);
    }
}
