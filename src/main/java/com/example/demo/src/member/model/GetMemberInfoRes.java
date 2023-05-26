package com.example.demo.src.member.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GetMemberInfoRes {
    private long id;

    private float temp;

    private int badgeCnt;

    private  int productCnt;

}
