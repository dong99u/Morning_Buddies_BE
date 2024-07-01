package com.morningbuddies.morningbuddies.apiPayload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.morningbuddies.morningbuddies.apiPayload.code.BaseCode;
import com.morningbuddies.morningbuddies.apiPayload.code.status.SuccessStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonPropertyOrder({"isSuccess", "code", "message", "data"})
public class ApiResponse<T> {

    @JsonProperty("isSuccess")
    private final Boolean isSuccess;

    @JsonProperty("code")
    private final String code;

    @JsonProperty("message")
    private final String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T result;

    /*
    * API 요청 성공한 경우
    * */

    public static <T> ApiResponse<T> onSuccess(T data){
        return new ApiResponse<>(true, SuccessStatus.OK.getCode() , SuccessStatus.OK.getMessage(), data);
    }

    public static <T> ApiResponse<T> of(BaseCode code, T data){
                return new ApiResponse<>(true, code.getReasonHttpStatus().getCode() , code.getReasonHttpStatus().getMessage(), data);
    }

    /*
    * API 요청 실패한 경우
    * */

    // 실패한 경우 응답 생성
    public static <T> ApiResponse<T> onFailure(String code, String message, T data){
        return new ApiResponse<>(true, code, message, data);
    }
}
