package Match;

/* File: Match.java
 * Author: André-Ignace Ghonda Lukoki
 * 
 * Program: Implement a matching algorithm
*/

import Order.*;

public class Match {
    private Order bid;
    private Order ask;

    public Match(Order bid, Order ask){
        this.bid = bid;
        this.ask = ask;
        this.bid.setMatch(ask);
        this.ask.setMatch(bid);
    }

    // Getters
    public Order getBid(){
        return this.bid;
    }

    public Order getAsk(){
        return this.ask;
    }

    public String toString(){
        return new String("{" + this.bid + ", " + this.ask + "}");
    }
}
