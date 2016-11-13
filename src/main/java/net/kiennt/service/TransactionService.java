package net.kiennt.service;

import net.kiennt.exception.InternalServerErrorException;
import net.kiennt.dto.Transaction;
import net.kiennt.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by KienNT25 on 11/2/2016.
 */
@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    public Transaction initialiseTransaction(String txCode, String msisdn, String hubId, String hubIdLite, String ssoId, String taxableAmtStr, String taxAmtStr, String nTaxableAmtStr) {
        Double taxableAmt = null;
        Double taxAmt = null;
        Double nTaxableAmt = null;
        if (taxableAmtStr != null) taxableAmt = Double.parseDouble(taxableAmtStr);
        if (taxAmtStr != null) taxAmt = Double.parseDouble(taxAmtStr);
        if (nTaxableAmtStr != null) nTaxableAmt = Double.parseDouble(nTaxableAmtStr);
        Transaction transaction = new Transaction();
        transaction.setTxnCode(txCode);
        transaction.setMsisdn(msisdn);
        transaction.setHubId(hubId);
        transaction.setHubIdLite(hubIdLite);
        transaction.setSsoId(ssoId);
        transaction.setTaxableAmt(taxableAmt);
        transaction.setTaxAmt(taxAmt);
        transaction.setNTaxableAmt(nTaxableAmt);

        Transaction returnTxn = null;
        if (transactionRepository.exists(transaction.getTxnCode())) {
            throw new InternalServerErrorException("Transaction txnCode: " + txCode + " already exists");
        } else {
            returnTxn = transactionRepository.save(transaction);
        }

        return returnTxn;
    }
}
