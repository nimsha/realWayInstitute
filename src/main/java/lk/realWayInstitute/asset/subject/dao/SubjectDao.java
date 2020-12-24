package lk.realWayInstitute.asset.subject.dao;


import lk.realWayInstitute.asset.subject.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectDao extends JpaRepository< Subject, Integer> {

}
