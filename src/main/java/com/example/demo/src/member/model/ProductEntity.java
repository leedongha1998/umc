package com.example.demo.src.member.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ProductEntity {
    private long id;
    private long sellerId;
    private long categoryId;
    private String title;
    private String content;
    private int price;
    private String status;
    private LocalDateTime createdAt;
    private int likes;
    private int chats;
}
