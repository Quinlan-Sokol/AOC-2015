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
public class Day2 {
    public static void main(String args[]) throws FileNotFoundException{
        Scanner s = new Scanner(new File("src/input2.txt"));
        ArrayList<String> list = new ArrayList();
        
        while(s.hasNextLine()){
            list.add(s.nextLine());
        }
        s.close();
        
        int paper = 0;
        int ribbon = 0;
        
        for(String str : list){
            String[] parts = str.split("x");
            int l = Integer.parseInt(parts[0]);
            int w = Integer.parseInt(parts[1]);
            int h = Integer.parseInt(parts[2]);
            
            int side1 = 2*l+2*w;
            int side2 = 2*w+2*h;
            int side3 = 2*h+2*l;
            ribbon += l*w*h;
            
            if(Integer.compare(side1, side2) <= 0){
                if(Integer.compare(side1, side3) <= 0){
                    ribbon += side1;
                }else{
                    ribbon += side3;
                }
            }else{
                if(Integer.compare(side2, side3) <= 0){
                    ribbon += side2;
                }else{
                    ribbon += side3;
                }
            }
        }
        System.out.println(ribbon);
        
        /*for(String str : list){
            String[] parts = str.split("x");
            int l = Integer.parseInt(parts[0]);
            int w = Integer.parseInt(parts[1]);
            int h = Integer.parseInt(parts[2]);
            int total = 0;
            
            int side1 = l*w;
            int side2 = w*h;
            int side3 = h*l;
            
            total += side1*2;
            total += side2*2;
            total += side3*2;
            
            if(Integer.compare(side1, side2) <= 0){
                if(Integer.compare(side1, side3) <= 0){
                    total += side1;
                }else{
                    total += side3;
                }
            }else{
                if(Integer.compare(side2, side3) <= 0){
                    total += side2;
                }else{
                    total += side3;
                }
            }
            paper += total;
        }
        System.out.println(paper);*/
    }
}
