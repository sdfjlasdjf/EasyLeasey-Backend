package com.EL.dto;

import lombok.Data;

@Data
public class GetFurnitureDTO {

    private String location;  // Location to filter furniture posts by
    private String name;      // Name of the furniture item to filter by
}
