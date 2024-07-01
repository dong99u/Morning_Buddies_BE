package com.morningbuddies.morningbuddies.apiPayload.exception.handler;

import com.morningbuddies.morningbuddies.apiPayload.code.BaseErrorCode;
import com.morningbuddies.morningbuddies.apiPayload.exception.GeneralException;

public class HealthHandler extends GeneralException {
    public HealthHandler(BaseErrorCode message) {
        super(message);
    }
}
