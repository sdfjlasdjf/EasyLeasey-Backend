package com.EL.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Furniture {

    private Long id;                // Unique identifier for the furniture item
    private Long userId;             // ID of the user who posted the furniture item
    private String title;            // Title of the furniture post
    private String description;      // Description of the furniture item
    private Double price;            // Price of the furniture item
    private String condition;        // Condition of the item (e.g., "new", "used")
    private String location;         // Location where the furniture is available
    private LocalDateTime createTime; // Timestamp when the furniture post was created
    private LocalDateTime updateTime; // Timestamp when the furniture post was last updated
}
