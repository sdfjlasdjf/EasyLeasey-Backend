package com.EL.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class PostPageQueryDTO implements Serializable {

    private String title;

    //page#
    private int page;

    //# of records on each page
    private int pageSize;

}
