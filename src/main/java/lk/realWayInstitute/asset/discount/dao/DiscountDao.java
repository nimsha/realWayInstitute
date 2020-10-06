package lk.realWayInstitute.asset.discount.dao;

import lk.realWayInstitute.asset.discount.entity.Discount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountDao extends JpaRepository< Discount, Integer> {
}
