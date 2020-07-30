package com.cakefactory.bakery.basket.basketfeature.service;

public interface IOrder {

    void createOrder(IBasket basket);
    void cancelOrder(IBasket basket);
}
