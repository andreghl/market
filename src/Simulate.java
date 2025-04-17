/* File: Simulate.java
 * Author: André-Ignace Ghonda Lukoki
 *
 * Program: Implement a simple market (double auction) simulation.
 */

public class Simulate {

    public static void main(String[] args){

        Market market = new Market(10, 10);
        market.run();
    }
}