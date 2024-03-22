//package com.wanzi.service.handle;
//
//import com.wanzi.service.exception.RemoteBusinessException;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.slf4j.MDC;
//import org.springframework.http.HttpStatus;
//import org.springframework.validation.BindException;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.FieldError;
//import org.springframework.web.ErrorResponse;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//import java.util.Iterator;
//import java.util.List;
//
///**
// * 功能描述:
// *
// * @author: qiu wanzi
// * @date: 2024年3月22日 0022
// * @version: 1.0
// */
//
//@RestControllerAdvice
//public class GlobalBizExceptionHandler {
//    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalBizExceptionHandler.class);
//
//    public GlobalBizExceptionHandler() {
//    }
//
//    @ExceptionHandler
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    @ResponseBody
//    public ErrorResponse error(Throwable e) {
//        String traceId = MDC.get("traceId");
//        LOGGER.error(" [{}] error: ", traceId, e);
//        return ErrorResponseBuilder.createErrorResponseWithTraceId(e, traceId);
//    }
//
//    @ExceptionHandler({ResourceNotFoundException.class})
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    @ResponseBody
//    public ErrorResponse notFound(ResourceNotFoundException e) {
//        String traceId = MDC.get("traceId");
//        LOGGER.error(" [{}] notFound: ", traceId, e);
//        return ErrorResponseBuilder.createErrorResponseWithTraceId(e, traceId);
//    }
//
//    @ExceptionHandler({UserAuthorizationException.class})
//    @ResponseStatus(HttpStatus.FORBIDDEN)
//    @ResponseBody
//    public ErrorResponse unauthorized(UserAuthorizationException e) {
//        String traceId = MDC.get("traceId");
//        LOGGER.error(" [{}] unauthorized: ", traceId, e);
//        return ErrorResponseBuilder.createErrorResponseWithTraceId(e, traceId);
//    }
//
//    @ExceptionHandler({InvalidRequestException.class})
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ResponseBody
//    public ErrorResponse validationError(InvalidRequestException e) {
//        String traceId = MDC.get("traceId");
//        LOGGER.error(" [{}] validationError: ", traceId, e);
//        return ErrorResponseBuilder.createErrorResponseWithTraceId(e, traceId);
//    }
//
//    @ExceptionHandler({BindException.class})
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ResponseBody
//    public ValidationErrorResponse validationError(BindException e) {
//        String traceId = MDC.get("traceId");
//        LOGGER.error(" [{}] validationError: ", traceId, e);
//        return this.createValidationResponse(e.getBindingResult(), traceId);
//    }
//
//    @ExceptionHandler({MethodArgumentNotValidException.class})
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ResponseBody
//    public ValidationErrorResponse validationError(MethodArgumentNotValidException e) {
//        String traceId = MDC.get("traceId");
//        LOGGER.error(" [{}] validationError: ", traceId, e);
//        return this.createValidationResponse(e.getBindingResult(), traceId);
//    }
//
//    @ExceptionHandler({RemoteBusinessException.class})
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ResponseBody
//    public ErrorResponse nsyRemoteBusinessException(RemoteBusinessException e) {
//        String traceId = MDC.get("traceId");
//        LOGGER.info(" [{}] RemoteBusinessException: ", traceId, e);
//        return ErrorResponseBuilder.createErrorResponseWithTraceId(e, traceId);
//    }
//
//    @ExceptionHandler({RemoteBusinessException.class})
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ResponseBody
//    public ErrorResponse RemoteBusinessException(RemoteBusinessException e) {
//        String traceId = MDC.get("traceId");
//        LOGGER.info(" [{}] RemoteBusinessException: ", traceId, e);
//        return ErrorResponseBuilder.createErrorResponseWithTraceId(e, traceId, String.valueOf(e.getBusinessCode()));
//    }
//
//    @ExceptionHandler({NsyRuntimeException.class})
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ResponseBody
//    public ErrorResponse nsyRuntimeException(NsyRuntimeException e) {
//        String traceId = MDC.get("traceId");
//        LOGGER.error(" [{}] nsyRuntimeException: ", traceId, e);
//        return ErrorResponseBuilder.createErrorResponseWithTraceId(e, traceId, String.valueOf(e.getErrCode()));
//    }
//
//    @ExceptionHandler({NsySerializationException.class})
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ResponseBody
//    public ErrorResponse nsySerializationException(NsySerializationException e) {
//        String traceId = MDC.get("traceId");
//        LOGGER.error(" [{}] nsySerializationException: ", traceId, e);
//        return ErrorResponseBuilder.createErrorResponseWithTraceId(e, traceId, String.valueOf(e.getErrCode()));
//    }
//
//    private ValidationErrorResponse createValidationResponse(BindingResult bindingResult, String traceId) {
//        ValidationErrorResponse response = new ValidationErrorResponse();
//        response.setTraceId(traceId);
//        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
//        Iterator var5 = fieldErrors.iterator();
//
//        while(var5.hasNext()) {
//            FieldError fieldError = (FieldError)var5.next();
//            com.nsy.api.core.apicore.exception.response.FieldError error = new com.nsy.api.core.apicore.exception.response.FieldError();
//            error.setField(fieldError.getField());
//            error.setMessage(fieldError.getDefaultMessage());
//            response.getFieldErrors().add(error);
//        }
//
//        return response;
//    }
//}
//
