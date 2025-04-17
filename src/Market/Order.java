package Market;

/* File: Order.java
 * Author: André-Ignace Ghonda Lukoki
 * 
 * Program: Class file for a market order.
 */

import java.time.LocalDateTime;

public class Order {
    private LocalDateTime time;
    private int id;
    private double price;
    private boolean isMatched;
    private Order match;

    public Order(double price){
        this.time = LocalDateTime.now();
        this.id = -1;
        this.price = price;
        this.isMatched = false;
        this.match = null;
    }

    public Order(int id, double price){
        this.time = LocalDateTime.now();
        this.id = id;
        this.price = price;
        this.isMatched = false;
        this.match = null;
    }

    // Setters

    public void setID(int id){
        this.id = id;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public void match(Order order){

        if(!this.isMatched()){
            this.match = order;
            this.isMatched = true;
            order.match(this);
        }
    }

    // Getters

    public LocalDateTime getTime(){
        return this.time;
    }

    public int getID(){
        return this.id;
    }

    public double getPrice(){
        return this.price;
    }

    public boolean isMatched(){
        return this.isMatched;
    }

    public Order getMatch(){
        return this.match;
    }

    // Comparator
    public int compareTo(Order order){
        int output = 0;
        if(this.getPrice() < order.getPrice()){
            output = - 1;
        } else if(this.getPrice() > order.getPrice()){
            output = 1;
        }
        return output;
    }

    // System Out
    public String toString(){
        return new String(this.getPrice() + "");
    }
}