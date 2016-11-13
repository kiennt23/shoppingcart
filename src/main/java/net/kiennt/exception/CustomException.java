package net.kiennt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by KienNT25 on 11/2/2016.
 */
@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Test Exception")
public class CustomException extends RuntimeException {
    public CustomException(String msg) {
        super(msg);
    }
}
