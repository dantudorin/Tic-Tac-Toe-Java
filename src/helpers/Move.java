package helpers;

public class Move {

    private int i;
    private int j;
    public static final char BLANK = '*';

    public Move(int i, int j){
        this.i = i;
        this.j = j;
    }

    public boolean isValidMove(char[][] board){

        if(board[this.i - 1][this.j -1] == BLANK){
            return true;
        }
        return false;
    }

    public void makeMove(char[][] board, int turn, int i, int j){
        if(turn % 2 == 0){
            board[this.i - 1][this.j - 1] = 'X';
        }else{
            board[this.i - 1][this.j - 1] = '0';
        }
    }

    public int getI(){ return this.i;}
    public int getJ(){ return this.j;}
}
