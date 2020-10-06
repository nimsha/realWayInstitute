package lk.realWayInstitute.asset.student.dao;


import lk.realWayInstitute.asset.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDao extends JpaRepository< Student, Integer > {

    Student findFirstByOrderByIdDesc();

}