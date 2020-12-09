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
public class Day8 {
    public static void main(String args[]) throws FileNotFoundException{
        Scanner s = new Scanner(new File("src/input8.txt"));
        ArrayList<String> list = new ArrayList();
        
        while(s.hasNextLine()){
            list.add(s.nextLine());
        }
        s.close();
        
        int total = 0;
        
        for(String str : list){
            int codeNum = str.length();
            int newNum = 2;
            for(char c : str.toCharArray()){
                if(c == '\\' || c == '"'){
                    newNum += 2;
                }else{
                    newNum++;
                }
            }
            total += newNum - codeNum;
        }
        System.out.println(total);
    }
}
