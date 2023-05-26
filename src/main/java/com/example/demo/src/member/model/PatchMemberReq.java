package com.example.demo.src.member.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PatchMemberReq {
    private long id;
    private String password;
    private String email;
    private String status;
    private float temp;
    private String phone;

}
