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
public class Day15 {
    public static void main(String args[]){
        ArrayList<String> list = new ArrayList();
        list.add("Sprinkles: capacity 2, durability 0, flavor -2, texture 0, calories 3");
        list.add("Butterscotch: capacity 0, durability 5, flavor -3, texture 0, calories 3");
        list.add("Chocolate: capacity 0, durability 0, flavor 5, texture -1, calories 8");
        list.add("Candy: capacity 0, durability -1, flavor 0, texture 5, calories 8");
        int bestScore = 0;
        
        for(int a = 0; a < 100; a++){
            for(int b = 0; b < 100; b++){
                for(int c= 0; c < 100; c++){
                    for(int d = 0; d < 100; d++){
                        if(a + b + c + d == 100){
                            int score = 0;
                            int capacity = 0;
                            int durability = 0;
                            int flavor = 0;
                            int texture = 0;
                            int calories = 0;
                            
                            capacity += Integer.parseInt(list.get(0).split(" ")[2].replace(",", "")) * a;
                            durability += Integer.parseInt(list.get(0).split(" ")[4].replace(",", "")) * a;
                            flavor += Integer.parseInt(list.get(0).split(" ")[6].replace(",", "")) * a;
                            texture += Integer.parseInt(list.get(0).split(" ")[8].replace(",", "")) * a;
                            calories += Integer.parseInt(list.get(0).split(" ")[10].replace(",", "")) * a;
                            
                            capacity += Integer.parseInt(list.get(1).split(" ")[2].replace(",", "")) * b;
                            durability += Integer.parseInt(list.get(1).split(" ")[4].replace(",", "")) * b;
                            flavor += Integer.parseInt(list.get(1).split(" ")[6].replace(",", "")) * b;
                            texture += Integer.parseInt(list.get(1).split(" ")[8].replace(",", "")) * b;
                            calories += Integer.parseInt(list.get(1).split(" ")[10].replace(",", "")) * b;
                            
                            capacity += Integer.parseInt(list.get(2).split(" ")[2].replace(",", "")) * c;
                            durability += Integer.parseInt(list.get(2).split(" ")[4].replace(",", "")) * c;
                            flavor += Integer.parseInt(list.get(2).split(" ")[6].replace(",", "")) * c;
                            texture += Integer.parseInt(list.get(2).split(" ")[8].replace(",", "")) * c;
                            calories += Integer.parseInt(list.get(2).split(" ")[10].replace(",", "")) * c;
                            
                            capacity += Integer.parseInt(list.get(3).split(" ")[2].replace(",", "")) * d;
                            durability += Integer.parseInt(list.get(3).split(" ")[4].replace(",", "")) * d;
                            flavor += Integer.parseInt(list.get(3).split(" ")[6].replace(",", "")) * d;
                            texture += Integer.parseInt(list.get(3).split(" ")[8].replace(",", "")) * d;
                            calories += Integer.parseInt(list.get(3).split(" ")[10].replace(",", "")) * d;
                                
                            if(capacity < 0)    capacity = 0;
                            if(durability < 0)    durability = 0;
                            if(flavor < 0)    flavor = 0;
                            if(texture < 0)    texture = 0;
                            
                            score = capacity * durability * flavor * texture;
                            if(score > bestScore && calories == 500){
                                bestScore = score;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(bestScore);
    }
}
