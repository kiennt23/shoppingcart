package net.kiennt.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by kiennguyen on 11/1/16.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Payment {
    @Id
    private String transactionRef;
    private String currency;
    private Double debitAmt;
    private String paymentType;
    private String status;
    private String errorCode;
    private String errorMsg;
    private String approvalCode;
    private String bankRespCode;
    private String trnType;
    private String subTrnType;
    private Short CCLast4Digit;
    private String expiryDate;
    private String CCNum;
    private String recurrentId;
    private Long subSequenceMCode;
    private String userField1;
    private String userField2;
    private String userField3;
    private String userField4;
    private String userField5;
    private Double IPPFirstPayment;
    private Double IPPLastPayment;
    private Double IPPMonthlyPayment;
    private Short IPPTransTenure;
    private Double IPPTotalInterest;
    private Double IPPDownPayment;
    private Double IPPMonthlyInterest;
    private String tokenId;
    //Security field
    private Short APIVersion;
    //Security field
    private String signature;
    private String ECI;
    private String CAVV;
    private String XID;
    private String originTransactionRef;
    private String originPayType;
}
