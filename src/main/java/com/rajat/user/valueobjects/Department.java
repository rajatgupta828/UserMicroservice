package com.rajat.user.valueobjects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    private int departmentID;
    private String departmentName;
    private String deparmentAddress;
    private String departmentCode;
}
