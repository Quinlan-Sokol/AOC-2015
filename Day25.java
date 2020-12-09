/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventofcode2015;

/**
 *
 * @author QDS
 */
public class Day25 {
    public static void main(String args[]){
        long code = 20151125L;
        int row = 1;
        int column = 1;
        int startRow = 1;
        
        while(true){
            if(row == 1){
                startRow++;
                row = startRow;
                column = 1;
            }else{
                row--;
                column++;
            }
            
            code *= 252533;
            code %= 33554393;
            if(row == 2978 && column == 3083) break;
        }
        System.out.println(code);
    }
}
