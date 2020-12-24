package lk.realWayInstitute.asset.payment.entity;


import com.fasterxml.jackson.annotation.JsonFilter;
import lk.realWayInstitute.asset.discount.entity.Discount;
import lk.realWayInstitute.util.audit.AuditEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonFilter( "Payment" )
public class Payment extends AuditEntity {

    private String tranId;
    private String discountStatus;
    private String amount;
    private String createdTime;
    private String createdDate;
    private String createdBy;




    @ManyToOne
    private Discount discount;

}