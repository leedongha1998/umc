package com.example.demo.src.member.model;

import lombok.*;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member implements Serializable {
    private long id;
    private String password;
    private String email;
    private String status;
    private float temp;
    private String phone;
    private LocalDateTime createdAt;
}
