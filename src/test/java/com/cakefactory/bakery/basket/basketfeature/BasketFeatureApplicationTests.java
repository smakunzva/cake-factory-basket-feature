package com.cakefactory.bakery.basket.basketfeature;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@SpringBootTest
class BasketFeatureApplicationTests {

    private Basket basket;
    private Set set;
    private String sessionId = UUID.randomUUID().toString();

    @BeforeEach
    public void Init() {
        basket = new Basket();
    }
    @Test
    public void givenInsertItemWhenSelectedThenReturnSize() {
        Pastry pastry = new Pastry();
        pastry.name = "doug";
        pastry.costs = 34.79;

        Assert.isTrue(basket.addItem(pastry, sessionId).size() == 1, "Item added to basket");
        Assert.isTrue(basket.addItem(pastry, sessionId).size() == 1, "Item added to basket");
    }

    @Test
    public void givenInsertItemsWhenSelectedThenReturnSize() {
        Pastry pastry1 = new Pastry();
        pastry1.name = "doug";
        pastry1.costs = 34.79;

        Pastry pastry2 = new Pastry();
        pastry2.name = "doug";
        pastry2.costs = 34.79;

        set = new HashSet<Pastry>();
        set.add(pastry1);
        set.add(pastry2);

        Assert.isTrue(basket.addItems(set, sessionId).size() == 1, "Items added");
    }

    @Test
    public void givenItemWhenRemovedThenReturnSize() {
        Pastry pastry1 = new Pastry();
        pastry1.name = "doug1";
        pastry1.costs = 34.78;

        Pastry pastry2 = new Pastry();
        pastry2.name = "doug2";
        pastry2.costs = 34.79;

        basket.addItem(pastry1, sessionId);
        basket.addItem(pastry2, sessionId);

        Assert.isTrue(basket.removeItem(pastry1, sessionId).size() == 1, "Item removed");
    }

    @Test
    public void givenItemsWhenUserSessionProvidedThenStoreItemsUnderSession() {
        Pastry pastry = new Pastry();
        pastry.name = "doug";
        pastry.costs = 34.79;

        Assert.isTrue(basket.addItem(pastry, sessionId).size() == 1, "Item added to basket under session");
        Assert.isTrue(basket.addItem(pastry, sessionId).size() == 1, "Item added to basket");
    }

    @Test
    public void givenAnotherSessionWhenDifferentDeviceThenStoreAnotherBasket() {
        Pastry pastry = new Pastry();
        pastry.name = "doug";
        pastry.costs = 34.79;

        Assert.isTrue(basket.addItem(pastry, sessionId).size() == 1, "Item added to basket under session");
        Assert.isTrue(basket.addItem(pastry, UUID.randomUUID().toString()).size() == 2, "Item added to basket under different session");
    }

    @Test
    public void givenItemsWhenSelectedThenRemoveAll() {
        Pastry pastry1 = new Pastry();
        pastry1.name = "doug1";
        pastry1.costs = 34.78;

        Pastry pastry2 = new Pastry();
        pastry2.name = "doug2";
        pastry2.costs = 34.79;

        basket.addItem(pastry1, sessionId);
        basket.addItem(pastry2, sessionId);

        Assert.isTrue(basket.removeItems(sessionId).size() == 0, "Items removed");
    }

}
