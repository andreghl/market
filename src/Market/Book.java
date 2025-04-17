package Market;

/* File: Book.java
 * Author: André-Ignace Ghonda Lukoki
 * 
 * Program: Class file for orderbooks
 */

import java.util.ArrayList;

public class Book {
    private ArrayList<Order> bids;
    private ArrayList<Order> asks;

    public Book(){
        this.bids = new ArrayList<Order>();
        this.asks = new ArrayList<Order>();
    }

    // Size
    public int bidSize(){
        return this.bids.size();
    }

    public int askSize(){
        return this.asks.size();
    }

    public int size(){
        return bidSize() + askSize();
    }

    // Adders
    public void bid(Order bid){
        if(!this.bids.isEmpty()){
            int id = this.bids.getLast().getID();
            bid.setID(id + 1);
            this.bids.add(bid);
        } else {
            bid.setID(0);
            this.bids.add(bid);
        }
    }

    public void ask(Order ask){
        if(!this.asks.isEmpty()){
            int id = this.asks.getLast().getID();
            ask.setID(id + 1);
            this.asks.add(ask);
        } else {
            ask.setID(0);
            this.asks.add(ask);
        }
    }

    // Getters
    public ArrayList<Order> getBids(){
        if(!this.bids.isEmpty()){
            return this.bids;
        } else { return null; }
    }

    public ArrayList<Order> getAsks(){
        if(!this.asks.isEmpty()){
            return this.asks;
        } else { return null; }
    }

    // Sort
    public void sort(){
        this.bids.sort((a, b) -> a.compareTo(b));
        this.asks.sort((a, b) -> a.compareTo(b));
    }
}