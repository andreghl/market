/* File: Simulate.java
 * Author: André-Ignace Ghonda Lukoki
 *
 * Program: Implement a matching algorithm
 */

import Order.*;
import Match.*;

public class Simulate {

    public static void main(String[] args){

        int nSimulations = 10000;
        int nOrders = 1000;

        System.out.println("Simulation of Market matching");
        System.out.println("Proportion of matches: " + simulate(nOrders, nSimulations));

    }

    public static double simulate(int nOrders, int nSimulations){

        double matches = 0;
        double bids = 0;

        for(int t = 0; t < nSimulations; t++){

            Book book = new Book();

            for(int i = 0; i < nOrders; i++){
                book.addBid(new Order(Math.random() * 15 + 1));
                book.addAsk(new Order(Math.random() * 15 + 1));
            }

            Sorted market = new Sorted(book.getBids(), book.getAsks());
            book.addMatches(market.match());

            matches += book.matchSize();
            bids += book.bidSize();
        }

        return matches / bids;
    }
}
