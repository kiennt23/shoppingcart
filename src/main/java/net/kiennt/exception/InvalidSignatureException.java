package net.kiennt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by KienNT25 on 11/2/2016.
 */
@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "Invalid signature. Forbidden.")
public class InvalidSignatureException extends RuntimeException {
    public InvalidSignatureException(String msg) {
        super(msg);
    }
}
