package com.cakefactory.bakery.basket.basketfeature.basket.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class Basket implements IBasket{
    Set pastryList = new TreeSet<Pastry>();
    Map basket = new LinkedHashMap<String, Set<Pastry>>();
    @Override
    public Map addItem(Pastry pastry, String sessionId) {
        pastryList.add(pastry);
        basket.put(sessionId,pastryList);
        return basket;
    }

    @Override
    public Map addItems(Set<Pastry> pastries, String sessionId) {
        basket.put(sessionId, pastries);
        return basket;
    }

    @Override
    public Map removeItem(Pastry pastry, String session) {
        Set pastries = (Set<Pastry>) basket.get(session);
        pastries.remove(pastry);
        return basket;
    }

    @Override
    public Map removeItems(String session) {
        basket.remove(session);
        return basket;
    }

    @Override
    public Map getOrderItems() {
        return basket;
    }
}
