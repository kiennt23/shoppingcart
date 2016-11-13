package net.kiennt.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by KienNT25 on 11/1/2016.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "response")
public class Response {
    public static final int ERR_CODE_BAD_REQUEST = 400;
    public static final int ERR_CODE_FORBIDDEN = 403;
    public static final int ERR_CODE_UNSUPPORTED_OPERATION = 405;
    public static final int ERR_CODE_INTERNAL_SERVER_ERROR = 500;
    public static final int ERR_CODE_SUCCESS = 0;
    public static final String ERR_MSG_BAD_REQUEST = "Bad Request";
    public static final String ERR_MSG_FORBIDDEN = "Forbidden";
    public static final String ERR_MSG_UNSUPPORTED_OPERATION = "Unsupported Operation";
    public static final String ERR_MSG_SUCCESS = "Success";

    private Integer code;
    private String message;
    private String transactionRef;
    private String paymentUrl;
}
