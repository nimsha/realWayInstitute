package lk.realWayInstitute.asset.student.service;


import lk.realWayInstitute.asset.student.dao.StudentDao;
import lk.realWayInstitute.asset.student.entity.Student;
import lk.realWayInstitute.util.interfaces.AbstractService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements AbstractService< Student, Integer > {
    private final StudentDao studentDao;

    public StudentService(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public List< Student > findAll() {
        return studentDao.findAll();
    }

    public Student findById(Integer id) {
        return studentDao.getOne(id);
    }

    public Student persist(Student student) {
        return studentDao.save(student);
    }

    public boolean delete(Integer id) {
        studentDao.deleteById(id);
        return false;
    }

    public List< Student > search(Student student) {
        return null;
    }

    public Student lastStudentOnDB() {
        return studentDao.findFirstByOrderByIdDesc();
    }

}
