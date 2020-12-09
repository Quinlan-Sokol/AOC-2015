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
public class Day23 {
    public static void main(String args[]) throws FileNotFoundException{
        Scanner s = new Scanner(new File("src/input23.txt"));
        ArrayList<String> input = new ArrayList();
        
        while(s.hasNextLine()){
            input.add(s.nextLine());
        }
        s.close();
        
        int index = 0;
        int a = 1;
        int b = 0;
        while(index >= 0 && index < input.size()){
            switch(input.get(index).split(" ")[0]){
                case "hlf":
                    if(input.get(index).contains("a")){
                        a /= 2;
                    }else{
                        b /= 2;
                    }
                    index++;
                    break;
                case "tpl":
                    if(input.get(index).contains("a")){
                        a *= 3;
                    }else{
                        b *= 3;
                    }
                    index++;
                    break;
                case "inc":
                    if(input.get(index).contains("a")){
                        a += 1;
                    }else{
                        b += 1;
                    }
                    index++;
                    break;
                case "jmp":
                    index += Integer.parseInt(input.get(index).split(" ")[1].replace("+", ""));
                    break;
                case "jie":
                    if(input.get(index).contains("a")){
                        if(a % 2 == 0){
                            index += Integer.parseInt(input.get(index).split(" ")[2].replace("+", ""));
                        }else{
                            index += 1;
                        }
                    }else{
                        if(b % 2 == 0){
                            index += Integer.parseInt(input.get(index).split(" ")[2].replace("+", ""));
                        }else{
                            index += 1;
                        }
                    }
                    break;
                case "jio":
                    if(input.get(index).contains("a")){
                        if(a == 1){
                            index += Integer.parseInt(input.get(index).split(" ")[2].replace("+", ""));
                        }else{
                            index += 1;
                        }
                    }else{
                        if(b == 1){
                            index += Integer.parseInt(input.get(index).split(" ")[2].replace("+", ""));
                        }else{
                            index += 1;
                        }
                    }
                    break;
            }
        }
        System.out.println(b);
    }
}
