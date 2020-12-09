/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventofcode2015;

import java.util.ArrayList;

/**
 *
 * @author QDS
 */
public class Day11 {
    public static void main(String args[]){
        String password = "hepxxyzz";
        ArrayList<Integer> list = new ArrayList();
        String[] pairs = {"aa","bb","cc","dd","ee","ff","gg","hh","jj","kk","mm","nn","pp","qq","rr","ss","tt","uu","vv","ww","xx","yy","zz"};
        for(char c : password.toCharArray()){
            list.add((int)c);
        }
        
        while(true){
            list.set(7, list.get(7) + 1);
            for(int k = 0; k < 8; k++){
                for(int i = list.size()-1; i > 0; i--){
                    if(list.get(i) > 122){
                        list.set(i, 97);
                        list.set(i-1, list.get(i-1) + 1);
                    }
                    
                    if(list.get(i) == 105 || list.get(i) == 108 || list.get(i) == 111){
                        list.set(i, list.get(i) + 1);
                        for(int j = i+1; j < 7; j++){
                            list.set(j, 97);
                        }
                    }
                }
            }
            
            boolean req1 = false;
            boolean req2 = false;
            
            for(int i = 1; i < 6; i++){
                int num1 = list.get(i-1);
                int num2 = list.get(i);
                int num3 = list.get(i+1);
                if(num2 - num1 == 1 && num3 - num2 == 1){
                    req1 = true;
                }
            }
            
            int count = 0;
            for(String p : pairs){
                if(toString(list).contains(p)){
                    count++;
                }
            }
            if(count >= 2){
                req2 = true;
            }
            
            if(req1 && req2){
                break;
            }
        }
        System.out.println(toString(list));
    }
    public static String toString(ArrayList<Integer> list){
        String str = "";
        for(int i : list){
            str += (char)i;
        }
        return str;
    }
}
