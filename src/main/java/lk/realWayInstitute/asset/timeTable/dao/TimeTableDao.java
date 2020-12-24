package lk.realWayInstitute.asset.timeTable.dao;


import lk.realWayInstitute.asset.timeTable.entity.TimeTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeTableDao extends JpaRepository< TimeTable, Integer> {

}
