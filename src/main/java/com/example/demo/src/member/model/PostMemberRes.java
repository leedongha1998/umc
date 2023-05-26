package com.example.demo.src.member.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostMemberRes {
    private long id;
    private String password;
    private String email;
    private String status;
    private float temp;
    private String phone;

}
