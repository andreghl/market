package Order;

/* File: Book.java
 * Author: André-Ignace Ghonda Lukoki
 *
 * Program: Methods for Order- and Fillbooks
 */

import java.util.ArrayList;
import Match.*;

public class Book {
    private ArrayList<Order> bids;
    private ArrayList<Order> asks;
    private ArrayList<Match> matches;

    public Book(){
        this.bids = new ArrayList<Order>();
        this.asks = new ArrayList<Order>();
        this.matches = new ArrayList<Match>();
    }

    public boolean isEmpty(){
        return this.bids.isEmpty() || this.asks.isEmpty() || this.matches.isEmpty();
    }

    public int bidSize(){
        return this.bids.size();
    }

    public int askSize(){
        return this.asks.size();
    }

    public int matchSize() { return this.matches.size();}

    // Getters, setters, and removers

    public void addBid(Order bid){
        this.bids.add(bid);
    }

    public void addAsk(Order ask){
        this.asks.add(ask);
    }

    public void addMatch(Match match){ this.matches.add(match); }

    public void addMatches(ArrayList<Match> matches) { this.matches.addAll(matches); }

    public void removeBid(Order bid){
        this.bids.remove(bid);
    }

    public void removeAsk(Order ask){
        this.asks.remove(ask);
    }

    public void removeMatch(Match match){ this.matches.remove(match); }

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

    public ArrayList<Match> getMatches(){
        if(!this.matches.isEmpty()){
            return this.matches;
        } else { return null; }
    }



    private void sortBids(){
        int n = this.bidSize();
        Order order;

        for(int i = 1; i < n; i++){
            order = this.bids.get(i);
            if(this.bids.get(i - 1).getPrice() > order.getPrice()){
                this.bids.set(i, this.bids.get(i - 1));
                this.bids.set(i - 1, order);
            }

            int j = i - 1;
            while(j >= 0){
                order = this.bids.get(j + 1);
                if(this.bids.get(j).getPrice() > order.getPrice()){
                    this.bids.set(j + 1, this.bids.get(j));
                    this.bids.set(j, order);
                }
                j--;
            }
        }
    }

    private void sortAsks(){
        int n = this.askSize();
        Order order;

        for(int i = 1; i < n; i++){
            order = this.asks.get(i);
            if(this.asks.get(i - 1).getPrice() > order.getPrice()){
                this.asks.set(i, this.asks.get(i - 1));
                this.asks.set(i - 1, order);
            }

            int j = i - 1;
            while(j >= 0){
                order = this.asks.get(j + 1);
                if(this.asks.get(j).getPrice() > order.getPrice()){
                    this.asks.set(j + 1, this.asks.get(j));
                    this.asks.set(j, order);
                }
                j--;
            }
        }
    }

    public void sort(){
        this.sortBids();
        this.sortAsks();
    }
}