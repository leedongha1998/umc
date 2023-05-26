package com.example.demo.src.product.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
public class GetProductRes {
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private int price;
    private int likes;
    private int chats;
    private String url;
    private String areaName;
}

