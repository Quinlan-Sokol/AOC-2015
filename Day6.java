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
public class Day6 {
    public static void main(String args[]) throws FileNotFoundException{
        Scanner s = new Scanner(new File("src/input6.txt"));
        ArrayList<String> list = new ArrayList();
        
        while(s.hasNextLine()){
            list.add(s.nextLine());
        }
        s.close();
        
        int[][] grid = new int[1000][1000];
        
        for(String str : list){
            String[] parts = str.split(" ");
            
            if(str.contains("toggle")){
                int x1 = Integer.parseInt(parts[1].split(",")[0]);
                int y1 = Integer.parseInt(parts[1].split(",")[1]);
                int x2 = Integer.parseInt(parts[3].split(",")[0]);
                int y2 = Integer.parseInt(parts[3].split(",")[1]);
                for(int i = x1; i <= x2; i++){
                    for(int j = y1; j <= y2; j++){
                        grid[i][j] += 2;
                    }
                }
            }
            else if(str.contains("turn"))
            {
                int x1 = Integer.parseInt(parts[2].split(",")[0]);
                int y1 = Integer.parseInt(parts[2].split(",")[1]);
                int x2 = Integer.parseInt(parts[4].split(",")[0]);
                int y2 = Integer.parseInt(parts[4].split(",")[1]);
                if(parts[1].equals("on")){
                    for(int i = x1; i <= x2; i++){
                        for(int j = y1; j <= y2; j++){
                            grid[i][j] += 1;
                        }
                    }
                }
                else if(parts[1].equals("off")){
                    for(int i = x1; i <= x2; i++){
                        for(int j = y1; j <= y2; j++){
                            if(grid[i][j] > 0)
                                grid[i][j] -= 1;
                        }
                    }
                }
            }
        }
        int total = 0;
        for(int i = 0; i < 1000; i++){
            for(int j = 0; j < 1000; j++){
                total += grid[i][j];
            }
        }
        System.out.println(total);
    }
}
