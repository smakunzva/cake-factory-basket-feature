package com.cakefactory.bakery.basket.basketfeature.order.service;

import com.cakefactory.bakery.basket.basketfeature.basket.service.IBasket;

public interface IOrder {

    void createOrder(IBasket basket);
    void cancelOrder(IBasket basket);
}
