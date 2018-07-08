import java.io.*;
import java.util.Arrays;
import static java.lang.System.out;

class StarPattern {
    public static void main(String[] args) throws IOException{
        // read inputs from keyboard        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // enter the number of rows for a single triangle
        int rows = Integer.parseInt(br.readLine());
        // calculate down surface (means the top surface of the inverted triangle)        
        int dwn_surface = rows/4;
        // make the variable to have odd difference from  bottom surface of the straight triangle to have uniformity in the pattern
        if((rows-dwn_surface) % 2 == 0) dwn_surface++;
        
        // calculate height and total width for the 2-D array to contain the pattern
        int height = rows + dwn_surface,width = 3 + (rows-2) * 2;// the width formula follows a arithmetic progression for spaces
        
        // create the 2-D array
        char[][] star_pattern = new char[height][width];
        
        // at first, fill the entire 2-D array with space
        for(int i=0;i<height;++i) Arrays.fill(star_pattern[i],' ');
        
        // straight/upper triangle first        
        buildUpperTriangle(star_pattern,rows,width);                        
        // now build inverted/reversed triangle
        buildInvertedTriangle(star_pattern,dwn_surface,height,width);        
        // print pattern
        printStarPattern(star_pattern);
    }
    
    private static void buildUpperTriangle(char[][] star_pattern,int rows,int width){        
        for(int i=0;i<rows;++i){
            if(i == rows-1){
                for(int j=0;j<width;++j) star_pattern[i][j] = '*';
            }else if(i == 0){
                star_pattern[0][width/2] = '*';
                star_pattern[1][width/2-1] = '*';
                star_pattern[1][width/2+1] = '*';
            }else{
                int left = 0,right = width-1;
                while(star_pattern[i][left] == ' ' && star_pattern[i][right] == ' '){
                    left++;
                    right--;
                }
                
                star_pattern[i+1][left-1] = '*';                
                star_pattern[i+1][right+1] = '*';
            }
        }
    }
    
    private static void buildInvertedTriangle(char[][] star_pattern,int dwn_surface,int height,int width){       
        for(int i=dwn_surface;i<height;++i){
            if(i == dwn_surface){
                for(int j=0;j<width;++j) star_pattern[i][j] = '*';
                star_pattern[i][0] = 'd';
                star_pattern[i][width-1] = 'd';
            }else if(i == height-1){
                star_pattern[i-1][width/2-1] = '*';
                star_pattern[i-1][width/2+1] = '*';
                star_pattern[i][width/2] = '*';
            }else{
                int left = 0,right = width-1;
                while(star_pattern[i-1][left] != 'd' && star_pattern[i-1][right] != 'd'){
                    left++;
                    right--;
                }
                
                star_pattern[i-1][left] = '*';                
                star_pattern[i-1][right] = '*';
                
                // these columns are temporarily assigned value 'd' to not confuse with upper triangle stars.
                star_pattern[i][left+1] = 'd';                
                star_pattern[i][right-1] = 'd';
            }
        }        
    }

    private static void printStarPattern(char[][] star_pattern){
        for(int i=0;i<star_pattern.length;++i) out.println(star_pattern[i]);
    }
}
