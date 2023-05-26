package com.example.demo.src.activity.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetActivityRes {
    private String title;
    private String content;
    private String areaName;
    private String categoryName;

}
