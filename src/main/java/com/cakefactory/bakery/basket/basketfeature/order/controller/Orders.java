package com.cakefactory.bakery.basket.basketfeature.order.controller;

import com.cakefactory.bakery.basket.basketfeature.basket.service.Basket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class Orders {

    private Basket basket;

    @Autowired
    public Orders(Basket basket) {
        this.basket = basket;
    }

    @PostMapping("/complete/order")
    public ResponseEntity completeOrder() {

        int orderSize = basket.getOrderItems().size();
        String orderStatus = orderSize == 0 ? "Order incomplete" : "Order completed";

        return new ResponseEntity(orderStatus, HttpStatus.OK);
    }
}
