package lk.realWayInstitute.asset.teacher.dao;

import lk.realWayInstitute.asset.teacher.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherDao extends JpaRepository< Teacher, Integer> {
    Teacher findFirstByOrderByIdDesc();
}
