package net.kiennt.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by KienNT25 on 11/1/2016.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Transaction {
    @Id
    private String txnCode;
    private String msisdn;
    private String hubId;
    private String hubIdLite;
    private String ssoId;
    private Double taxableAmt;
    private Double taxAmt;
    private Double nTaxableAmt;
}
