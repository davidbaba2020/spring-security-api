package com.davacom.springsecurity1.Models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
public class Student  {
    private final Integer studentId;
    private final String studentName;
}
