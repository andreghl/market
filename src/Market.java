/* File: Market.java
 * Author: André-Ignace Ghonda Lukoki
 *
 * Program: A program to simulate the behavior of a market
 * in which n players trade one good.
 */

import Market.*;

public class Market {

    public Book book;

    private int nOrders;
    private int nPeriod;
    private int meanPrice;
    public boolean isOpen;

    public Market(){

        this.nOrders = 100;
        this.meanPrice = 10;
    }

    public Market(int nOrders, int meanPrice){

        this.nOrders = nOrders;
        this.meanPrice = meanPrice;
        this.book = new Book();
        this.isOpen = true;
    }

    private void trade(){

        double order = Math.random() + meanPrice + 1;
        order = Math.round(order * 100.0) / 100.0;

        if(Math.random() > 0.5){
            book.bid(new Order(order));
        } else {
            book.ask(new Order(order));
        }
    }

    public void run(){

        while (isOpen) {
            trade();
            book.sort();

            int a = 0; int b = 0;
            
            while(a < book.askSize() && b < book.bidSize()){
                while(book.getAsks().get(a).isMatched()){
                    a++;
                }

                while(book.getBids().get(b).isMatched()){
                    b++;
                }

                Order ask = book.getAsks().get(a);
                Order bid = book.getBids().get(b);

                if(bid.getPrice() > ask.getPrice()){
                    bid.match(ask);
                    ask.match(bid);
                    a++; b++;
                } else if(a < b){
                    a++;
                } else {
                    b++;
                }
            }

            if(book.size() > nOrders){
                isOpen = false;
            }

            
        }

    }
}