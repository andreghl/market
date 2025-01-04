/* File: Market.java
 * Author: André-Ignace Ghonda Lukoki
 *
 * Program: A program to simulate the behavior of a market
 * in which n players trade one good.
 */

import Order.*;
import Match.*;
import java.util.ArrayList;

public class Market {

    public Book book;

    private int nOrders;
    private int nPeriod;
    private int meanPrice;

    private int matchSize;
    private ArrayList<Double> matchRates;
    private double matchRate;

    private ArrayList<Double> prices;
    private double price;

    private ArrayList<Double> matchedPrices;
    private double matchedPrice;


    public static void main(String[] args){

        Market market = new Market();
        market.run();
        market.stats();
    }

    public Market(){

        this.nOrders = 100;
        this.nPeriod = 10;
        this.meanPrice = 7;
        this.matchSize = 0;
        this.matchRate = 0;

        this.prices = new ArrayList<Double>();
        this.matchedPrices = new ArrayList<Double>();
        this.matchRates = new ArrayList<Double>();
    }

    public Market(int nOrders, int nPeriod, int meanPrice){

        this.nOrders = nOrders;
        this.nPeriod = nPeriod;
        this.meanPrice = meanPrice;

        this.prices = new ArrayList<Double>();
        this.matchedPrices = new ArrayList<Double>();
        this.matchRates = new ArrayList<Double>();
    }

    public void run(){

        for(int n = 0; n < this.nPeriod; n++){
            this.book = new Book();

            for(int i = 0; i < this.nOrders; i++){

                book.addBid(new Order(Math.random() * meanPrice + 1));
                book.getBids().get(i).setID(i);
                book.addAsk(new Order(Math.random() * meanPrice + 1));
                book.getAsks().get(i).setID(i);
            }

            Structure matching = new Structure(book.getBids(), book.getAsks());
            book.addMatches(matching.match());

            this.matchSize += book.matchSize();

            book.sort();
            this.price = (book.getAsks().getFirst().getPrice() + book.getBids().getLast().getPrice()) / 2;
            this.prices.add(price);

            for(int i = 0; i < this.nOrders; i++){

                if(book.getAsks().get(i).isMatched()){
                    this.matchedPrice += book.getAsks().get(i).getPrice() / 2;
                    break;
                }
            }

            for(int i = this.nOrders - 1; i >= 0; i--){
                
                if(book.getBids().get(i).isMatched()){
                    this.matchedPrice += book.getBids().get(i).getPrice() / 2;
                    break;
                }
            }

            this.matchedPrices.add(this.matchedPrice);
            this.matchedPrice = 0;
            this.matchRates.add((double) book.matchSize() / this.nOrders);
        }

        this.matchRate =  (double) this.matchSize / (this.nOrders * this.nPeriod);
    }

    public void stats(){

        System.out.println("The market was run for " + this.nPeriod + " periods.");
        System.out.println("The mean market price is " + this.meanPrice + " and the maximum number of bids is " + nOrders + ".");
        System.out.println("The match rate is " + this.matchRate + ".");
        System.out.println(this.matchRates + "\n");
        System.out.println("The prices for this market were: ");
        System.out.println(this.prices + "\n");
        System.out.println("The prices for the matches in the market were: ");
        System.out.println(this.matchedPrices + "\n");
    }
}