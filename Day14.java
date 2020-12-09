/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventofcode2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author QDS
 */
public class Day14 {
    public static void main(String args[]) throws FileNotFoundException{
        Scanner s = new Scanner(new File("src/input14.txt"));
        ArrayList<String> list = new ArrayList();
        
        while(s.hasNextLine()){
            list.add(s.nextLine());
        }
        s.close();
        
        ArrayList<Reindeer> racers = new ArrayList();
        for(int i = 0; i < list.size(); i++){
            racers.add(new Reindeer(Integer.parseInt(list.get(i).split(" ")[3]), Integer.parseInt(list.get(i).split(" ")[6]), Integer.parseInt(list.get(i).split(" ")[13])));
        }
        
        for(int i = 0; i < 2503; i++){
            ArrayList<Integer> l = new ArrayList();
            for(Reindeer r : racers){
                r.move();
                l.add(r.distance);
            }
            int num = Collections.max(l);
            for(int k = 0; k < racers.size(); k++){
                if(racers.get(k).distance == num){
                    racers.get(k).points++;
                }
            }
        }
        
        ArrayList<Integer> points = new ArrayList();
            for(Reindeer r : racers){
                points.add(r.points);
            }
        System.out.println(Collections.max(points));
    }
}
class Reindeer{
    int speed;
    int rest;
    int time;
    int distance = 0;
    int points = 0;
    
    int timecounter = 0;
    int restcounter = 0;
    public Reindeer(int speed, int time, int rest){
        this.speed = speed;
        this.rest = rest;
        this.time = time;
    }
    public void move(){
        if(restcounter == 0){
            if(timecounter < time){
                distance += speed;
                timecounter++;
            }else{
                restcounter = rest-1;
                timecounter = 0;
            }
        }else{
            restcounter--;
        }
    }
}
