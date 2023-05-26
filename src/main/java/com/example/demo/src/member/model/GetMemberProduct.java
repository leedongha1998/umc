package com.example.demo.src.member.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class GetMemberProduct{
    private String title;
    private String content;
    private int price;
    private String url;
}
