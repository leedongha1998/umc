package com.example.demo.src.product.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostProductRes {
    private long id;
    private String url;
    private String title;
    private String content;
    private int price;
    private String areaName;


}
