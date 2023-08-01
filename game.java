class Solution {
  
     /**
     * @param board
     * @param row
     * @param col
     * @param i
     * @return
     */
    private static boolean isValid(char[][] board,int row,int col,int i){
         for(int j=0;j<board.length;j++){
            if(board[row][j]==(char)(i+'0')){
                return false;
            }
            if(board[j][col]==(char)(i+'0')){
                return false;
            }
           
        }
         int sr=(row/3)*3;
         int sc=(col/3)*3;

          for(int r=sr;r<sr+3;r++){
            for(int c=sc;c<sc+3;c++){
                if(board[r][c]==(char)(i+'0')){
                return false;
                }
            }
        }
        return true;

     }
  
    public static boolean help(char[][] board,int row,int col){
        if(row==board.length){
            return true;
        }
        int new_row=0;
        int new_col=0;
        if(col!=board.length-1){
            new_row=row;
            new_col=col+1;
        }else{
             new_row=row+1;
            new_col=0;
        }

        if(board[row][col]!='.'){
            if(help(board,new_row,new_col)) return true;
        }
        else{
            for(int i=1;i<=9;i++){
                if(isValid(board,row,col,i)){
                     board[row][col]=(char)(i+'0');
                     if( help(board,new_row,new_col)){
                         return true;
                     }
                     else{
                         board[row][col]='.';

                     }

                }
                   
                
               
            }
            
        }
        return false;
    }
    public static void solveSudoku(char[][] board) {
        help(board,0,0);
        
    }
     public static void main(String[] args) {
       
         char[][] board = {
    {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
    {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
    {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
    {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
    {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
    {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
    {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
    {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
    {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
};
System.out.println("Unsolved Suduko:");
for(int i=0;i<board.length;i++){
    for(int j=0;j<board.length;j++){
        
        System.out.print(board[i][j]+" ");

    }
    System.out.println();
}
solveSudoku( board);
System.out.println("Solved Suduko:");
for(int i=0;i<board.length;i++){
    for(int j=0;j<board.length;j++){
        
        System.out.print(board[i][j]+" ");

    }
    System.out.println();
}


        
    }
}