package com.EL.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FurnitureVO {
    private Long id;
    private String title;
    private String description;
    private Double price;
    private String condition;
    private String location;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
