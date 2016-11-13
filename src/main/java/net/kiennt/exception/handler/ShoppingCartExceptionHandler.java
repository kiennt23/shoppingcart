package net.kiennt.exception.handler;

import net.kiennt.controller.ShoppingCartController;
import net.kiennt.model.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.core.annotation.AnnotatedElementUtils.findMergedAnnotation;

/**
 * Handle all exception throw by ShoppingCartController.
 * Return client readable Response object.
 * <p>
 * Created by KienNT25 on 11/1/2016.
 */
@ControllerAdvice(basePackageClasses = ShoppingCartController.class)
public class ShoppingCartExceptionHandler extends ResponseEntityExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(ShoppingCartExceptionHandler.class);

    /**
     * Get the status code and reason for a specific error from exception.
     *
     * @param request The HttpServletRequest, can be used to get parameters and headers. Hasn't been used yet.
     * @param ex The exception annotated with ResponseStatus annotation. HTTP error code and reason for error get from
     *           annotation.
     * @return Message to return to client in a readable Response object dto.
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    ResponseEntity<?> handleControllerException(HttpServletRequest request, Throwable ex) {
        LOGGER.error(ex.getMessage());
        Response errResponse = new Response();
        errResponse.setCode(getStatus(ex).value());
        errResponse.setMessage(getReason(ex));

        return new ResponseEntity<>(errResponse, getStatus(ex));
    }

    private HttpStatus getStatus(Throwable ex) {
        ResponseStatus annotation = findMergedAnnotation(ex.getClass(), ResponseStatus.class);
        if (annotation != null) {
            return annotation.value();
        }
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }

    private String getReason(Throwable ex) {
        ResponseStatus annotation = findMergedAnnotation(ex.getClass(), ResponseStatus.class);
        if (annotation != null) {
            return annotation.reason();
        }
        return HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();
    }
}
