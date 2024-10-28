package com.server.priend.common.payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Response {
    private String statusCode;
    private String message;
    private Object data;

    private static final String OK_STATUS_CODE = "200";
    private static final String OK_MESSAGE = "OK";

    public static Response ok(String message, Object data) {
        return Response.builder()
                .statusCode(OK_STATUS_CODE)
                .message(message != null ? message : OK_MESSAGE)
                .data(data)
                .build();
    }

    public static Response ok(Object data) {
        return ok(OK_MESSAGE, data);
    }

    public static Response ok() {
        return ok(OK_MESSAGE, null);
    }
}
