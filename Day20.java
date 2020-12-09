/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventofcode2015;

import java.util.ArrayList;

/**
 *
 * @author QDS
 */
public class Day20 {
    public static void main(String args[]){
        int houseNum = 1;
        
        while(true){
            int total = 0;
            
            for(int i : findFactors(houseNum)){
                total += i;
            }
            total *= 10;
            
            if(total >= 34000000){
                break;
            }
            
            houseNum++;
        }
        System.out.println(houseNum);
    }
    public static ArrayList<Integer> findFactors(int num) {        
        ArrayList<Integer> factors = new ArrayList<Integer>();

        // Skip two if the number is odd
        int incrementer = num % 2 == 0 ? 1 : 2;

        for (int i = 1; i <= Math.sqrt(num); i += incrementer) {

            // If there is no remainder, then the number is a factor.
            if (num % i == 0) {
                if(num / i <= 50){
                    factors.add(i);
                }
                
                // Skip duplicates
                if (i != num / i) {
                    factors.add(num / i);
                }

            }
        }
        return factors;
    }
}
