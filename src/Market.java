/* File: Market.java
 * Author: André-Ignace Ghonda Lukoki
 *
 * Program: A program to simulate the behavior of a market
 * in which n players trade one good.
 */

import Order.*;
import Match.*;

public class Market {
    public static void main(String[] args) {

        Book orderbook = new Book();
        int n = (int) (Math.random() * 100 + 5);

        for(int i = 0; i < n; i++){
            orderbook.addBid(new Order(Math.random() * 7 + 1));
            orderbook.addAsk(new Order(Math.random() * 7 + 1));
        }

        System.out.println(orderbook.getBids().getFirst().getTime());
        System.out.println("The Bid prices are: " + orderbook.getBids());
        System.out.println("The Ask prices are: " + orderbook.getAsks());

        orderbook.sort();
        System.out.println(orderbook.getBids().getFirst().getTime());
        System.out.println("The Bid prices are: " + orderbook.getBids());
        System.out.println("The Ask prices are: " + orderbook.getAsks());

        Sorted matching = new Sorted(orderbook.getBids(), orderbook.getAsks());

        orderbook.addMatches(matching.match());
        System.out.println("Bid size: " + orderbook.bidSize());
        System.out.println("Ask size: " + orderbook.askSize());
        System.out.println("Match size: " + orderbook.matchSize());

    }
}