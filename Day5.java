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
public class Day5 {
    public static void main(String args[]) throws FileNotFoundException{
        Scanner s = new Scanner(new File("src/input5.txt"));
        ArrayList<String> list = new ArrayList();
        int niceNum = 0;
        
        while(s.hasNextLine()){
            list.add(s.nextLine());
        }
        s.close();
        
        for(String str : list){
            boolean req1 = false;
            boolean req2 = false;
            
            int index = 0;
            for(char c : str.toCharArray()){
                if(index + 2 < str.length()){
                    if(str.toCharArray()[index + 2] == c){
                        req2 = true;
                    }
                }
                if(index + 2 < str.length()){
                    String pair = Character.toString(c) + str.toCharArray()[index + 1];
                    String sub = str.substring(index + 2);
                    if(sub.contains(pair)){
                        req1 = true;
                    }
                }
                index++;
            }
            if(req1 && req2){
                niceNum++;
            }
        }
        System.out.println(niceNum);
    }
}
