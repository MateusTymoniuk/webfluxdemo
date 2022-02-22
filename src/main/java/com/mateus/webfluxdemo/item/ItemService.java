package com.mateus.webfluxdemo.item;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;

@Service
public class ItemService {

    public List<Item> getItemsSynchronously() {
        return IntStream.rangeClosed(1, 10)
                .peek(ItemService::sleep)
                .peek(i -> System.out.println("Generating item sync: " + i))
                .mapToObj(i -> new Item(i, "item" + i))
                .collect(Collectors.toList());
    }

    public static void sleep(int i) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public Flux<Item> getItemsAsynchronously() {
        return Flux.range(1, 10)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i -> System.out.println("Generating item async: " + i))
                .map(i -> new Item(i, "item" + i));
    }
}
