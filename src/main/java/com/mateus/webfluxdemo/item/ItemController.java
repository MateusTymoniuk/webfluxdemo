package com.mateus.webfluxdemo.item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService service;

    @GetMapping("/sync")
    public List<Item> getItemsSynchronously() {
        System.out.println("Sync");
        return service.getItemsSynchronously();
    }

    @GetMapping(value = "/async", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Item> getItemsAsynchronously() {
        System.out.println("Async");
        return service.getItemsAsynchronously();
    }
}
