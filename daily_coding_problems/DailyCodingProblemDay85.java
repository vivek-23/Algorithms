/*

Good morning! Here's your coding interview problem for today.

This problem was asked by Facebook.

Given three 32-bit integers x, y, and b, return x if b is 1 and y if b is 0, using only mathematical or bit operations. You can assume b can only be 1 or 0.

*/

 public int solve(int x, int y , int b){
    return (b ^ 1) == 0 ? x : y;    
 }
