package net.kiennt.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by kiennguyen on 11/5/16.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "request")
public class Request {
    @XmlElement(name = "txcode")
    private String txCode;
    @XmlElement(name = "msisdn")
    private String msisdn;
    @XmlElement(name = "hubid")
    private String hubId;
    @XmlElement(name = "hubid_lite")
    private String hubIdLite;
    @XmlElement(name = "ssoid")
    private String ssoId;
    @XmlElement(name = "taxable_amt")
    private String taxableAmt;
    @XmlElement(name = "tax_amt")
    private String taxAmt;
    @XmlElement(name = "ntaxable_amt")
    private String nTaxableAmt;
}
