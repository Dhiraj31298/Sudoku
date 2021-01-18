import java.util.*;
public class Sudoku
{
    public static void display(int [][] board){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }
    
    public static void sudokuSolver(int [][] board,int i,int j){
        if(i==board.length){
            display(board);
            return;
        }
        int ni=0;
        int nj=0;
        if(j== board[0].length-1){
            ni=i+1;
            nj=0;
        }else{
            nj=j+1;
            ni=0;
        }
        if(board[i][j] !=0){
            sudokuSolver(board,nj,ni);
        }
        else{
            for(int p=0;p<9;p++){
                if(isValid(board,i,j,p)== true){
                    board[i][j]=p;
                    sudokuSolver(board,ni,nj);
                    board[i][j]=0;
                }
            }
        }
        
    }
    public static boolean isValid(int [][] board,int row,int col,int k){
                 for (int i = 0; i < 9; i++) {
        double  m = 3 * Math.floor(row / 3) + Math.floor(i / 3);
        double  n = 3 * Math.floor(col / 3) + i % 3;
        if (board[row][i] == k || board[i][col] == k || board[(int)m][(int)n] == k) {
          return false;
        }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int [][] arr =new int[9][9];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        sudokuSolver(arr,0,0);
    }
}
