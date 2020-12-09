/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventofcode2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author QDS
 */
public class Day16 {
    public static void main(String args[]) throws FileNotFoundException{
        Scanner s = new Scanner(new File("src/input16.txt"));
        ArrayList<String> list = new ArrayList();
        
        while(s.hasNextLine()){
            list.add(s.nextLine());
        }
        s.close();
        
        int children = 3;
        int cats = 7;
        int samoyeds = 2;
        int pomeranians = 3;
        int akitas = 0;
        int vizslas = 0;
        int goldfish = 5;
        int trees = 3;
        int cars = 2;
        int perfumes = 1;
        
        for(String str : list){
            int numCorrect = 0;
            String[] parts = str.substring(9).split(",");
            
            for(String p : parts){
                String type = p.split(":")[0].trim();
                switch(type){
                    case "children":
                        if(Integer.parseInt(p.split(":")[1].trim()) == children){
                            numCorrect++;
                        }
                        break;
                    case "cats":
                        if(Integer.parseInt(p.split(":")[1].trim()) > cats){
                            numCorrect++;
                        }
                        break;
                    case "samoyeds":
                        if(Integer.parseInt(p.split(":")[1].trim()) == samoyeds){
                            numCorrect++;
                        }
                        break;
                    case "pomeranians":
                        if(Integer.parseInt(p.split(":")[1].trim()) < pomeranians){
                            numCorrect++;
                        }
                        break;
                    case "akitas":
                        if(Integer.parseInt(p.split(":")[1].trim()) == akitas){
                            numCorrect++;
                        }
                        break;
                    case "vizslas":
                        if(Integer.parseInt(p.split(":")[1].trim()) == vizslas){
                            numCorrect++;
                        }
                        break;
                    case "goldfish":
                        if(Integer.parseInt(p.split(":")[1].trim()) < goldfish){
                            numCorrect++;
                        }
                        break;
                    case "trees":
                        if(Integer.parseInt(p.split(":")[1].trim()) > trees){
                            numCorrect++;
                        }
                        break;
                    case "cars":
                        if(Integer.parseInt(p.split(":")[1].trim()) == cars){
                            numCorrect++;
                        }
                        break;
                    case "perfumes":
                        if(Integer.parseInt(p.split(":")[1].trim()) == perfumes){
                            numCorrect++;
                        }
                        break;
                }
            }
            if(numCorrect == 3){
                System.out.println(str.substring(0, 9));
                break;
            }
        }
    }
}
