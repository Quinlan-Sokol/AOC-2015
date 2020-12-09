/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventofcode2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author QDS
 */
public class Day7 {
    public static void main(String args[]) throws FileNotFoundException{
        Scanner s = new Scanner(new File("src/input7.txt"));
        ArrayList<String> list = new ArrayList();
        
        while(s.hasNextLine()){
            list.add(s.nextLine());
        }
        s.close();
        Map<String, Integer> wires = new HashMap();
        
        for(String str : list){
            if(str.contains("AND")){
                if(wires.containsKey(str.split(" ")[0]) && wires.containsKey(str.split(" ")[2])){
                    int val1 = wires.get(str.split(" ")[0]);
                    int val2 = wires.get(str.split(" ")[2]);
                    int ans = val1 & val2;
                    wires.put(str.split("->")[1].trim() , ans);
                }
            }
            else if(str.contains("OR")){
                if(wires.containsKey(str.split(" ")[0]) && wires.containsKey(str.split(" ")[2])){
                    int val1 = wires.get(str.split(" ")[0]);
                    int val2 = wires.get(str.split(" ")[2]);
                    int ans = val1 | val2;
                    wires.put(str.split("->")[1].trim() , ans);
                }
            }
            else if(str.contains("NOT")){
                if(wires.containsKey(str.split(" ")[1])){
                    int val = wires.get(str.split(" ")[1]);
                    char ans = (char) ~(val);
                    wires.put(str.split("->")[1].trim(), (int)ans);
                }
            }
            else if(str.contains("LSHIFT")){
                if(wires.containsKey(str.split(" ")[0]) && wires.containsKey(str.split(" ")[2])){
                    int val1 = wires.get(str.split(" ")[0]);
                    int val2 = Integer.parseInt(str.split(" ")[2]);
                    int ans = val1 << val2;
                    wires.put(str.split("->")[1].trim(), ans);
                }
            }
            else if(str.contains("RSHIFT")){
                if(wires.containsKey(str.split(" ")[0]) && wires.containsKey(str.split(" ")[2])){
                    int val1 = wires.get(str.split(" ")[0]);
                    int val2 = Integer.parseInt(str.split(" ")[2]);
                    int ans = val1 >> val2;
                    wires.put(str.split("->")[1].trim(), ans);
                }
            }
            else{
                if(wires.containsKey(str.split(" ")[0]) || Character.isDigit(str.split(" ")[0].charAt(0))){
                    wires.put(str.split("->")[1].trim(), Integer.parseInt(str.split("->")[0].trim()));
                }
            }
        }
        System.out.println(wires);
    }
}
