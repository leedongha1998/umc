package com.example.demo.src.member.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BadgeEntity {
    private long id;
    private long memberId;
    private String badgeName;
    private String badgeContent;
    private String status;
    private LocalDateTime createdAt;
}
