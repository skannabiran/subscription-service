package com.maveric.techhub.subscription.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExceptionResponse {
    private Date timestamp;
    private Integer errorCode;
    private String errorMessage;
    private Object details;

}
