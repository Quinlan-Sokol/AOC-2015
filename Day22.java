/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventofcode2015;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author QDS
 */
public class Day22 {
    static ArrayList<Integer> list = new ArrayList();
    public static void main(String args[]){
        //EFFECTS: 1 = shield  2 = poison  3 = recharge
        ArrayList<Point> ef = new ArrayList();
        doTurn(50, 55, 500, "Missile", ef, 0);
        doTurn(50, 55, 500, "Drain", ef, 0);
        doTurn(50, 55, 500, "Shield", ef, 0);
        doTurn(50, 55, 500, "Poison", ef, 0);
        doTurn(50, 55, 500, "Recharge", ef, 0);
        System.out.println(Collections.min(list));
    }
    public static void doTurn(int pHP, int bHP, int mana, String spell, ArrayList<Point> effects, int manaUsed){
        //players turn
        boolean lose = false;
        
        pHP -= 1;
        if(pHP <= 0){//player dies
            lose = true;
            mana = 0;
        }
        
        for(int p = 0; p < effects.size(); p++){
            if(effects.get(p).x == 2){//poison
                bHP -= 3;
            }else if(effects.get(p).x == 3){//recharge
                mana += 101;
            }
            effects.set(p, new Point(effects.get(p).x, effects.get(p).y - 1));
            if(effects.get(p).y == 0){
                effects.remove(p);
            }
        }
        
        if(bHP <= 0 && !lose){//boss dies from effect
            list.add(manaUsed);
            lose = true;
        }
        
        switch(spell){
            case "Missile":
                if(mana >= 53){
                    bHP -= 4;
                    mana -= 53;
                    manaUsed += 53;
                }else{
                    lose = true;}
                break;
            case "Drain":
                if(mana >= 73){
                    bHP -= 2;
                    pHP += 2;
                    mana -= 73;
                    manaUsed += 73;
                }else{
                    lose = true;}
                break;
            case "Shield":
                if(mana >= 113 && !usingEffect(1, effects)){
                    effects.add(new Point(1, 6));
                    mana -= 113;
                    manaUsed += 113;
                }else{
                    lose = true;}
                break;
            case "Poison":
                if(mana >= 173 && !usingEffect(2, effects)){
                    effects.add(new Point(2, 6));
                    mana -= 173;
                    manaUsed += 173;
                }else{
                    lose = true;}
                break;
            case "Recharge":
                if(mana >= 229 && !usingEffect(3, effects)){
                    effects.add(new Point(3, 5));
                    mana -= 229;
                    manaUsed += 229;
                }else{
                    lose = true;}
                break;
        }
        
        if(bHP <= 0 && !lose){//boss dies from spell
            list.add(manaUsed);
            lose = true;
        }
        
        //boss turn
        boolean shield = false;
        
        for(int p = 0; p < effects.size(); p++){
            if(effects.get(p).x == 1){//shield
                shield = true;
            }else if(effects.get(p).x == 2){//poison
                bHP -= 3;
            }else if(effects.get(p).x == 3){//recharge
                mana += 101;
            }
            effects.set(p, new Point(effects.get(p).x, effects.get(p).y - 1));
            if(effects.get(p).y == 0){
                effects.remove(p);
            }
        }
        
        if(bHP <= 0 && !lose){//boss dies from effect
            list.add(manaUsed);
            lose = true;
        }
        
        int bAttack;
        if(shield){
            bAttack = 1;
        }else{
            bAttack = 8;
        }
        
        pHP -= bAttack;
        if(pHP <= 0){//player dies
            lose = true;
        }
        
        //starting next possible turns
        if(!lose){
            doTurn(pHP, bHP, mana, "Missile", effects, manaUsed);
            doTurn(pHP, bHP, mana, "Drain", effects, manaUsed);
            doTurn(pHP, bHP, mana, "Shield", effects, manaUsed);
            doTurn(pHP, bHP, mana, "Poison", effects, manaUsed);
            doTurn(pHP, bHP, mana, "Recharge", effects, manaUsed);
        }
    }
    public static boolean usingEffect(int e, ArrayList<Point> effects){
        for(Point p : effects){
            if(p.x == e){
                return true;
            }
        }
        return false;
    }
}
