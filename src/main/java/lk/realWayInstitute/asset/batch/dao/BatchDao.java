package lk.realWayInstitute.asset.batch.dao;


import lk.realWayInstitute.asset.batch.entity.Batch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BatchDao extends JpaRepository< Batch, Integer> {

}
