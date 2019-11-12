package helpers;

import java.util.HashSet;
import java.util.Set;

public class Game {

    private char[][] board;
    public boolean gameOver;
    private Set<Character> identity;

    public Game(){
        this.board = new char[][]{{'*', '*', '*'}, {'*', '*', '*'}, {'*', '*', '*'}};
        this.gameOver = false;
        this.identity = new HashSet<>();
    }

    public char[][] getBoard(){
        return this.board;
    }

    public boolean isGameOver(){ return this.gameOver; }

    public void setGameOver(boolean gameOver){ this.gameOver = gameOver;}

    public boolean checkWinning(){

        for(int i = 0 ; i < board.length ; i ++){
            identity.add(board[i][i]);
        }
        if(identity.size() == 1 && !identity.contains(Move.BLANK))
            return true;

        identity = new HashSet<>();

        for(int i = 0; i < board.length; i ++){
           identity.add(board[i][board.length -1 - i]);
        }
        if(identity.size() == 1 && !identity.contains(Move.BLANK))
           return true;
        identity = new HashSet<>();

        for(int i = 0 ; i < board.length ; i ++){
            for(int j = 0; j < board.length; j ++){
                identity.add(board[i][j]);
            }
            if(identity.size() == 1 && !identity.contains(Move.BLANK))
                return true;
            identity = new HashSet<>();
        }

        for(int i = 0; i < board.length; i ++){
            for(int j = 0 ; j < board.length; j ++){
                identity.add(board[j][i]);
            }
            if(identity.size() == 1 && !identity.contains(Move.BLANK))
                return true;
            identity = new HashSet<>();
        }
        return false;
    }

    public void playerSelection(int turn){
        if(turn % 2 == 0){
            System.out.println("X -player choose position");
        }else{
            System.out.println("0 -player choose position");
        }
    }

    public void printStartup(){
        System.out.println("Input should be 1->3,1->3");
        System.out.println("Example 2,1");
        System.out.println("Good luck");
    }

    public void printBoard(){
        for(int i = 0 ; i < this.board.length; i ++){
            for (int j = 0 ; j < this.board.length ; j ++){
                System.out.print(this.board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
