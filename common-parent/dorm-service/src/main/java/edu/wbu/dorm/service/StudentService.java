package edu.wbu.dorm.service;

import edu.wbu.dorm.model.Student;
import edu.wbu.dorm.service.base.BaseService;

public interface StudentService extends BaseService<Student> {
    //特有方法
    public Student login(String id,String password);
}
