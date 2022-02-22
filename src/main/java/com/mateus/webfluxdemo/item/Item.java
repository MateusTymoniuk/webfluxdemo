package com.mateus.webfluxdemo.item;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Item {
    
    private Integer id;
    private String name;
}
