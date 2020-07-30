package com.cakefactory.bakery.basket.basketfeature.basket.service;

import java.util.Map;
import java.util.Set;

public interface IBasket {

    Map addItem(Pastry pastry, String session);
    Map addItems(Set<Pastry> pastries, String session);
    Map removeItem(Pastry pastry, String session);
    Map removeItems(String session);
    Map getOrderItems();
}
