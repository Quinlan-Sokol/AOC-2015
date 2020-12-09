/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adventofcode2015;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author QDS
 */
public class Day4 {
    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        int i = 0;
        byte[] array;
        while(true) {
            array = md.digest("iwrupvqb".concat(Integer.toString(i++)).getBytes()); // Put input here
            if(array[0] == 0 && array[1] == 0 && (array[2]>> 4 & 0xf) == 0) {
                if(array[2] == 0) // Comment out to do part 1.
                    break;
            }
        }
        System.out.println("Lowest value needed: " + (i-1));
    }
}

