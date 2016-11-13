package net.kiennt.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by KienNT25 on 11/1/2016.
 */
public class ParameterUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(ParameterUtil.class);

    public static ValidateResult validate(String txCode, String msisdn, String hubId, String hubIdLite, String taxableAmtStr, String taxAmtStr, String nTaxableAmtStr) {
        if (txCode == null) {
            LOGGER.info("txCode is null");
            return new ValidateResult(false, "txCode is null");
        } else if (msisdn == null && hubId == null && hubIdLite == null) {
            LOGGER.info("Missing msisdn/hubid/hubid_lite");
            return new ValidateResult(false, "Missing msisdn/hubid/hubid_lite");
        }

        try {
            if (taxableAmtStr != null) Double.parseDouble(taxableAmtStr);
            if (taxAmtStr != null) Double.parseDouble(taxAmtStr);
            if (nTaxableAmtStr != null) Double.parseDouble(nTaxableAmtStr);
        } catch (NumberFormatException e) {
            LOGGER.info("Invalid amount: taxable_amt " + taxableAmtStr + ", tax_amt " + taxAmtStr + ", ntaxable_amt " + nTaxableAmtStr);
            return new ValidateResult(false, "Invalid amount: taxable_amt " + taxableAmtStr + ", tax_amt " + taxAmtStr + ", ntaxable_amt " + nTaxableAmtStr);
        }
        return new ValidateResult(true, null);
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ValidateResult {
        private boolean valid;
        private String  reason;
    }
}
