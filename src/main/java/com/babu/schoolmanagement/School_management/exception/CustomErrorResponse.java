package com.babu.schoolmanagement.School_management.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomErrorResponse {
    private int status;
    private String message;
    private long timeStamp;
}
