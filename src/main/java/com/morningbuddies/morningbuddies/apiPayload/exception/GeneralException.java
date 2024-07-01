package com.morningbuddies.morningbuddies.apiPayload.exception;

import lombok.Getter;
import lombok.AllArgsConstructor;

import com.morningbuddies.morningbuddies.apiPayload.code.BaseErrorCode;
import com.morningbuddies.morningbuddies.apiPayload.code.ErrorReasonDTO;


@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {

    private final BaseErrorCode code;

    public ErrorReasonDTO getErrorReason() {
        return this.code.getReason();
    }

    public ErrorReasonDTO getErrorReasonHttpStatus(){
        return this.code.getReasonHttpStatus();
    }
}