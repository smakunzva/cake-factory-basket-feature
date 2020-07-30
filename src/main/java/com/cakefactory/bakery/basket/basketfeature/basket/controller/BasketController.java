package com.cakefactory.bakery.basket.basketfeature.basket.controller;

import com.cakefactory.bakery.basket.basketfeature.basket.service.Basket;
import com.cakefactory.bakery.basket.basketfeature.basket.service.Pastry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Map;

@RestController
@RequestMapping("/basket")
public class BasketController {

    private Basket basketService;

    @Autowired
    public BasketController(Basket basketService) {
        this.basketService = basketService;
    }

    @PostMapping("/add/item")
    public ResponseEntity addItem(@RequestBody Pastry pastry, @RequestHeader String sessionId) {
        Map items = this.basketService.addItem(pastry, sessionId);
        HttpStatus status = items.size() == 0 ? HttpStatus.BAD_REQUEST : HttpStatus.OK;
        return new ResponseEntity(items, status);
    }

    @PostMapping("/add/items")
    public ResponseEntity addItems(@Validated @RequestBody HashSet<Pastry> pastries, @RequestHeader String sessionId) {
        Map items = this.basketService.addItems(pastries, sessionId);
        HttpStatus status = items.size() == 0 ? HttpStatus.BAD_REQUEST : HttpStatus.OK;
        return new ResponseEntity(items, status);
    }

    @DeleteMapping("/remove/item")
    public ResponseEntity removeItem(@RequestBody Pastry pastry, @RequestHeader String sessionId) {
        return null;
    }

    @DeleteMapping("/remove/items")
    public ResponseEntity removeItems(@RequestHeader String sessionId) {
        return null;
    }
}
