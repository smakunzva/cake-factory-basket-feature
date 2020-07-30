package com.cakefactory.bakery.basket.basketfeature.basket.service;

public class Pastry implements Comparable<Pastry>{

    public String name;
    public Double costs;


    @Override
    public int compareTo(Pastry o) {
        if (this != null) {
            return this.name.compareTo(o.name);
        }
        return -1;
    }
}
