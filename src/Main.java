import helpers.Game;
import helpers.Move;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static final int FINAL_TURN = 8;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Move playerMove;
        Game game;
        boolean gameOn = true;

    while(gameOn){
        game = new Game();
        game.printStartup();
        int turn = 0;
        game.printBoard();
        while (!game.isGameOver() && turn <= FINAL_TURN){
            System.out.println(game.isGameOver());
            game.playerSelection(turn);
            String move = scanner.nextLine();
            String[] position = move.split(",");

            try{
                playerMove = new Move(Integer.parseInt(position[0]),Integer.parseInt(position[1]));

                if(playerMove.isValidMove(game.getBoard())){
                    playerMove.makeMove(game.getBoard(),turn,playerMove.getI(),playerMove.getJ());
                    game.printBoard();
                    game.gameOver = game.checkWinning();

                }else{
                    System.out.println("Not a valid move! Try again");
                    turn -= 1;
                }

            }catch (Exception e){
                System.out.println("Not a vlaid move! Try again");
                turn -= 1;
            }
            turn += 1;
            System.out.println(game.isGameOver());
            System.out.println(turn);
        }
        if(game.isGameOver()){
            if((turn - 1) % 2 == 0){
                System.out.println("X -> WON ");
            }else{
                System.out.println("0 -> WON");
            }
        }else{
            System.out.println("Equality");
        }

        System.out.println("Replay? Y/N");
        String continueGame = scanner.nextLine();
        if(!continueGame.toUpperCase().equals("Y")){
            gameOn = false;
           }
        }
    }
}
