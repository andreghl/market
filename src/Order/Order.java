package Order;

/* File: Order.java
 * Author: André-Ignace Ghonda Lukoki
 *
 * Program:
 */

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Order {
    private LocalDateTime time;
    private Double price;
    private Order match;
    private boolean matched;

    public Order(){
        this.time = LocalDateTime.now();
        this.price = 0.0;
        this.match = null;
        this.matched = false;
    }

    public Order(double price){
        this.time = LocalDateTime.now();
        this.price = price;
    }

    public void changeOrder(double price){
        this.price = price;
    }

    public void setMatch(Order match){
        this.match = match;
        this.matched = true;
    }

    public boolean isMatched(){
        return this.matched;
    }

    public LocalDateTime getTime(){
        return this.time;
    }

    public double getPrice(){
        return this.price;
    }

    public String toString(){
        return new String(this.getPrice() + "");
    }
}
