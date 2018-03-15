package net.kiennt.controller;

import net.kiennt.exception.BadRequestException;
import net.kiennt.exception.InternalServerErrorException;
import net.kiennt.exception.InvalidSignatureException;
import net.kiennt.model.Response;
import net.kiennt.dto.Transaction;
import net.kiennt.service.AuthenticationService;
import net.kiennt.service.TransactionService;
import net.kiennt.util.ParameterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by KienNT25 on 11/1/2016.
 */
@RestController
@RequestMapping(value = "transaction")
public class ShoppingCartController {

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    TransactionService transactionService;

    // TODO: Wrap all request parameters in Request object for future changes
    /**
     * @param authorization
     * @param txCode
     * @param msisdn
     * @param hubId
     * @param hubIdLite
     * @param ssoId
     * @param taxableAmtStr
     * @param taxAmtStr
     * @param nTaxableAmtStr
     * @return
     */
    @RequestMapping(value = "initialise", method = RequestMethod.POST, produces = MediaType.APPLICATION_XML_VALUE)
    public Response initialisePayment(@RequestHeader(name = "Authorization", required = false) String authorization,
                                      @RequestParam(name = "txcode", required = false) String txCode,
                                      @RequestParam(name = "msisdn", required = false) String msisdn,
                                      @RequestParam(name = "hubid", required = false) String hubId,
                                      @RequestParam(name = "hubid_lite", required = false) String hubIdLite,
                                      @RequestParam(name = "ssoid", required = false) String ssoId,
                                      @RequestParam(name = "taxable_amt", required = false) String taxableAmtStr,
                                      @RequestParam(name = "tax_amt", required = false) String taxAmtStr,
                                      @RequestParam(name = "ntaxable_amt", required = false) String nTaxableAmtStr) {

        //TODO: should we move to AOP code?
        if (!authenticationService.authenticate(authorization)) {
            throw new InvalidSignatureException("Signature not found.");
        }

        ParameterUtil.ValidateResult validateResult = ParameterUtil.validate(txCode, msisdn, hubId, hubIdLite, taxableAmtStr, taxAmtStr, nTaxableAmtStr);
        if (!validateResult.isValid()) {
            throw new BadRequestException(validateResult.getReason());
        }

        Response response = new Response();
        Transaction newTxn = transactionService.initialiseTransaction(txCode, msisdn, hubId, hubIdLite, ssoId, taxableAmtStr, taxAmtStr, nTaxableAmtStr);
        if (newTxn != null) {
            response.setCode(Response.ERR_CODE_SUCCESS);
            response.setMessage(Response.ERR_MSG_SUCCESS);
            response.setTransactionRef(txCode);
            //TODO: paymentUrl should be configurable in config.properties or database. TBD
            response.setPaymentUrl("http://google.com.vn");
        } else {
            throw new InternalServerErrorException("Failed to initialise transaction: " + txCode);
        }
        return response;
    }

}
