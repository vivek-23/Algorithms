/*

The question is: there exists an array A of n elements, either being RED, WHITE, or BLUE. 
Rearrange the array such that all WHITE elements come before all BLUE elements, and all BLUE 
elements come before all RED elements. Construct an algorithm in O(n) time and O(1) space.

*/

import java.util.Arrays;
import java.util.Random;
import static java.lang.System.out;

class Color{
    char c;
    Color(char c){
        this.c = c;
    }
}

public class Solution {

    private static void rearrangeColors(Color[] collection){
        int ptr = 0;   

        // move all whites to the left

        for(int i=0;i<collection.length;++i){
            if(collection[i].c == 'W'){
                swap(collection,ptr,i);
                ptr++;
            }
        }

        // move all blacks to the left after white       

        for(int i=ptr;i<collection.length;++i){
            if(collection[i].c == 'B'){
                swap(collection,ptr,i);
                ptr++;
            }
        }
    }

    private static void swap(Color[] collection,int ptr1,int ptr2){
        Color temp = collection[ptr1];
        collection[ptr1] = collection[ptr2];
        collection[ptr2] = temp;
    }

    private static void printColors(Color[] collection){
        for(int i=0;i<collection.length;++i){
            out.print(collection[i].c + ( i != collection.length - 1 ? "," : ""));
        }
        out.println();
    }

    public static void main(String[] args) {
        // generate a random collection of 'Color' objects
        Random r = new Random();
        int array_length = r.nextInt(20) + 1;// to add 1 if in case 0 gets generated 
        Color[] collection = new Color[array_length];
        char[] colors_domain = {'B','W','R'};

        for(int i=0;i<collection.length;++i){
            collection[i] = new Color(colors_domain[r.nextInt(3)]);
        }

        // print initial state
        printColors(collection);
        // rearrange them according to the criteria
        rearrangeColors(collection);
        // print final state
        printColors(collection);        
    }

}
