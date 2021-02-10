package lk.realWayInstitute.asset.course.dao;


import lk.realWayInstitute.asset.course.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseDao extends JpaRepository<Course, Integer> {

}
