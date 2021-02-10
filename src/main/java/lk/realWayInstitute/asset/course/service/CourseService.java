package lk.realWayInstitute.asset.course.service;


import lk.realWayInstitute.asset.course.dao.CourseDao;
import lk.realWayInstitute.asset.course.entity.Course;
import lk.realWayInstitute.util.interfaces.AbstractService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService implements AbstractService<Course, Integer> {
    private final CourseDao courseDao;

    public CourseService(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    public List<Course> findAll() {
        return courseDao.findAll();
    }

    public Course findById(Integer id) {
        return courseDao.getOne(id);
    }

    public Course persist(Course course) {
        return courseDao.save(course);
    }

    public boolean delete(Integer id) {
        courseDao.deleteById(id);
        return false;
    }

    public List<Course> search(Course course) {
        return null;
    }



}
