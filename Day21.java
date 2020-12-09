/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventofcode2015;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author QDS
 */
public class Day21 {
    static ArrayList<Integer> gold = new ArrayList();
    public static void main(String args[]){
        String[] weapons = new String[]{"Dagger 8 4","Shortsword 10 5","Warhammer 25 6","Longsword 40 7", "Greataxe 74 8"};
        String[] armor = new String[]{"Leather 13 1","Chainmail 31 2","Splintmail 53 3","Bandedmail 75 4", "Platemail 102 5", "Nothing 0 0"};
        String[] rings = new String[]{"Damage+1 25 1","Damage+2 50 2","Damage+3 100 3","Defense+1 20 1", "Defense+2 40 2", "Defense+3 80 3"};
        
        for(String w : weapons){
            for(String a : armor){
                //0 rings
                fight(w, a, null, null);
                //1 ring
                for(String r : rings){
                    fight(w, a, r, null);
                }
                //2 rings
                for(int r1 = 0; r1 < rings.length - 1; r1++){
                    for(int r2 = r1+1; r2 < rings.length; r2++){
                        fight(w, a, rings[r1], rings[r2]);
                    }
                }
            }
        }
        //System.out.println(Collections.min(gold));
        System.out.println(Collections.max(gold));
    }
    public static void fight(String weapon, String armor, String ring1, String ring2){
        int pHP = 100;
        int pDamage = 0;
        int pArmor = 0;
        
        pDamage += Integer.parseInt(weapon.split(" ")[2]);
        pArmor += Integer.parseInt(armor.split(" ")[2]);
        if(ring1 != null){
            if(ring1.contains("Damage")){
                pDamage += Integer.parseInt(ring1.split(" ")[2]);
            }else if(ring1.contains("Defense")){
                pArmor += Integer.parseInt(ring1.split(" ")[2]);
            }
            if(ring2 != null){
                if(ring2.contains("Damage")){
                    pDamage += Integer.parseInt(ring2.split(" ")[2]);
                }else if(ring2.contains("Defense")){
                    pArmor += Integer.parseInt(ring2.split(" ")[2]);
                }
            }
        }
        
        int bHP = 109;
        int bDamage = 8;
        int bArmor = 2;
        
        int pAttack = pDamage - bArmor > 0 ? pDamage - bArmor : 1;
        int bAttack = bDamage - pArmor > 0 ? bDamage - pArmor : 1;
        int pTurns;
        int bTurns;
        
        if(bHP % pAttack > 0){
            pTurns = (bHP / pAttack) + 1;
        }else{
            pTurns = bHP / pAttack;
        }
        
        if(pHP % bAttack > 0){
            bTurns = (pHP / bAttack) + 1;
        }else{
            bTurns = pHP / bAttack;
        }
        
        //if(pTurns == bTurns || pTurns < bTurns){//wins
        if(pTurns > bTurns){//loses
            gold.add(getTotalGold(weapon, armor, ring1, ring2));
        }
    }
    public static int getTotalGold(String weapon, String armor, String ring1, String ring2){
        int total = 0;
        
        total += Integer.parseInt(weapon.split(" ")[1]);
        total += Integer.parseInt(armor.split(" ")[1]);
        if(ring1 != null)
            total += Integer.parseInt(ring1.split(" ")[1]);
        if(ring2 != null)
            total += Integer.parseInt(ring2.split(" ")[1]);
        return total;
    }
}
