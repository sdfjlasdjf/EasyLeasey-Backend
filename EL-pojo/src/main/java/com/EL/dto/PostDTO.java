package com.EL.dto;

import lombok.Data;
import java.io.Serializable;

@Data
public class PostDTO implements Serializable {

    private Long id;

    private String category;

    private String title;

    private Integer price;

    private String content;

    private String image;

    private String location;

}
