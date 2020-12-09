/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventofcode2015;

import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author QDS
 */
public class Day18 {
    public static void main(String args[]) throws FileNotFoundException{
        Scanner s = new Scanner(new File("src/input18.txt"));
        boolean[][] grid = new boolean[100][100];
        
        int x = 0;
        int y = 0;
        while(s.hasNextLine()){
            String nl = s.nextLine();
            x = 0;
            for(char c : nl.toCharArray()){
                if(c == '.'){
                    grid[x][y] = false;
                }else if(c == '#'){
                    grid[x][y] = true;
                }
                x++;
            }
            y++;
        }
        s.close();
        
        for(int k = 0; k < 100; k++){
            boolean[][] newGrid = new boolean[100][100];
            
            for(int i = 0; i < 100; i++){
                for(int j = 0; j < 100; j++){
                    if(new Point(0,0).equals(new Point(i,j)) || new Point(0,99).equals(new Point(i,j)) || new Point(99,99).equals(new Point(i,j)) || new Point(99,0).equals(new Point(i,j))){
                        newGrid[i][j] = true;
                    }else{
                        int numOn = 0;

                        if(i+1 <= 99 && j+1 <= 99)    if(grid[i+1][j+1])    numOn++;
                        if(i+1 <= 99)    if(grid[i+1][j])    numOn++;
                        if(i+1 <= 99 && j-1 >= 0)    if(grid[i+1][j-1])    numOn++;
                        if(i-1 >= 0 && j+1 <= 99)    if(grid[i-1][j+1])    numOn++;
                        if(i-1 >= 0)    if(grid[i-1][j])    numOn++;
                        if(i-1 >= 0 && j-1 >= 0)    if(grid[i-1][j-1])    numOn++;
                        if(j+1 <= 99)    if(grid[i][j+1])    numOn++;
                        if(j-1 >= 0)    if(grid[i][j-1])    numOn++;

                        if(grid[i][j] == true){
                            if(numOn == 2 || numOn == 3){
                                newGrid[i][j] = true;
                            }else{
                                newGrid[i][j] = false;
                            }
                        }
                        else if(grid[i][j] == false){
                            if(numOn == 3){
                                newGrid[i][j] = true;
                            }else{
                                newGrid[i][j] = false;
                            }
                        }
                    }
                }
            }
            grid = newGrid;
        }
        
        
        int total = 0;
        for(int i = 0; i < 100; i++){
            for(int j = 0; j < 100; j++){
                if(grid[i][j])
                    total++;
            }
        }
        System.out.println(total);
    }
}
