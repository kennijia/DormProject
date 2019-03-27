package edu.wbu.dorm.service.impl;

import edu.wbu.dorm.model.Student;
import edu.wbu.dorm.service.StudentService;
import edu.wbu.dorm.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StudentServiceImpl extends BaseServiceImpl<Student> implements StudentService {

    public Student login(String id, String password) {
        Student s = new Student();
        s.setId(id);
        s.setPassword(password);
        return stuMapper.findByIdAndPassword(s);
    }

    public Student findById(String id) {
        return stuMapper.findById(id);

    }

    public Student findById(int id) {
        return null;
    }
}
