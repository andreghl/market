package Match;

import java.util.ArrayList;
import Order.*;

public class Structure {
    private ArrayList<Order> bids;
    private ArrayList<Order> asks;

    public Structure(){
        this.bids = new ArrayList<Order>();
        this.asks = new ArrayList<Order>();
    }

    public Structure(ArrayList<Order> bids, ArrayList<Order> asks){
        this.bids = bids;
        this.asks = asks;
    }

    public ArrayList<Match> match(){

        sort(this.asks); sort(this.bids);

        int nBids = this.bids.size(); int nAsks = this.asks.size();
        int n; Order bid; Order ask;
        ArrayList<Match> matches = new ArrayList<Match>();

        if(nBids <= nAsks){
            n = nBids;
            for(int i = 0; i < n; i++){
                bid = this.bids.get(i);
                ask = this.asks.get(i);
                if(ask.getPrice() <= bid.getPrice()){
                    matches.add(new Match(bid, ask));
                }
            }
        } else {
            n = nAsks;
            for(int i = 0; i < n; i++){
                bid = this.bids.get(i);
                ask = this.asks.get(i);
                if(ask.getPrice() <= bid.getPrice()){
                    matches.add(new Match(bid, ask));
                }
            }
        }
        return matches;
    }

    public void sort(ArrayList<Order> orders){
        int n = orders.size();
        Order current;
        Order before;
        for(int i = 1; i < n; i++){
            current = orders.get(i);
            before = orders.get(i - 1);
            if(before.getPrice() > current.getPrice()){
                orders.set(i, before);
            }

            for(int j = i - 1; j >= 0; j--){
                current = orders.get(j + 1);
                before = orders.get(j);

                if(before.getPrice() > current.getPrice()){
                    orders.set(j + 1, before);
                }
            }
        }
    }

    // TODO: Find a better name for this algorithm
}
