package com.example.RESTAPI.exception;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
public class ErrorResponse {
    private int status;
    private String message;
    private LocalDateTime timestamp;

    public ErrorResponse(int status, String message, LocalDateTime timestamp){
        this.message=message;
        this.status=status;
        this.timestamp=timestamp;
    }
}
