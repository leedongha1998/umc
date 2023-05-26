package com.example.demo.src.member.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetMemberBadgeRes {

    private long id; // badgeId

    private String badgeName;
    private String badgeContent;


}
