package com.EL.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class GetPostDTO implements Serializable {
    private String location;
    private String category;
}
