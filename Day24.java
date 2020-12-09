/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventofcode2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author QDS
 */
public class Day24 {
    static double minE;
    static int minA = 100;
    static ArrayList<String> comb = new ArrayList();
    public static void populateSubset(final int[] data, int fromIndex, final int[] stack, final int stacklen,final int target) {
        if (target == 0) {
            double num = 1;
            int[] list = Arrays.copyOf(stack, stacklen);
            //System.out.println(Arrays.toString(list));
            for(int i : list){
                num *= i;
            }
            if(list.length < minA){
                minE = num;
                minA = list.length;
                if(!comb.contains(Long.toString(Double.doubleToLongBits(minE))))
                    comb.add(Long.toString(Double.doubleToLongBits(minE)));
            }else if(list.length == minA && num < minE){
                minE = num;
                minA = list.length;
                if(!comb.contains(Long.toString(Double.doubleToLongBits(minE))))
                    comb.add(Long.toString(Double.doubleToLongBits(minE)));
            }
            
            return;
        }

        while (fromIndex < data.length && data[fromIndex] > target) {
            // take advantage of sorted data.
            // we can skip all values that are too large.
            fromIndex++;
        }

        while (fromIndex < data.length && data[fromIndex] <= target) {
            // stop looping when we run out of data, or when we overflow our target.
            stack[stacklen] = data[fromIndex];
            populateSubset(data, fromIndex + 1, stack, stacklen + 1, target - data[fromIndex]);
            fromIndex++;
        }
    }
    public static void main(String args[]) throws FileNotFoundException{
        Scanner s = new Scanner(new File("src/input24.txt"));
        int[] data = new int[29];
        
        int total = 0;
        int index = 0;
        while(s.hasNextLine()){
            data[index] = (Integer.parseInt(s.nextLine()));
            total += data[index];
            index++;
        }
        s.close();
        
        Arrays.sort(data); 
        populateSubset(data, 0, new int[data.length], 0, total / 3);
    }
}
