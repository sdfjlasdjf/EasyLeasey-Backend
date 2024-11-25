package com.EL.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Likes implements Serializable {
    private Long userId;
    private Long postId;
    private LocalDateTime updateTime;

}
