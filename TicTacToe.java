import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {

        int turn = 0;

        char[][] gameBoard = {{' ', '|', ' ', '|', ' '}, {'-', '+', '-', '+', '-'}
                                ,{' ', '|', ' ', '|', ' '}, {'-', '+', '-', '+', '-'}
                                    ,{' ', '|', ' ', '|', ' '}};
                                    
        printGameBoard(gameBoard);   
        
        while (turn < 9) {
            playGame(gameBoard, turn);
            ++turn;
            printGameBoard(gameBoard);
            System.out.println();
            if (turn > 4) {
                checkWinCondition(gameBoard);
                checkLoseCondition(gameBoard);
            }
        }//while
    }//main

    public static void printGameBoard(char[][] gameBoard) {
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }//for
            System.out.println();
        }//for                 
    }//printGameBoard

    public static void playGame(char[][] gameBoard, int turn) {
        int pos = 0;
        char symbol = '\0';

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        if (turn % 2 == 0){
            System.out.println("Enter Position (1-9):");
            System.out.print(">> ");
            symbol = 'X';
            pos = sc.nextInt();
        }//if
        else {
            symbol = 'O';
            pos = rand.nextInt(9) + 1;
        }//else

        if (isFilled(gameBoard, pos) == true) {
            if (turn % 2 == 0) {
            System.out.println("Try again.");
            printGameBoard(gameBoard);
            System.out.println();
            }
            pos = 0; //kept saving old value until i set var pos to 0 to reset it's old value
            playGame(gameBoard, turn);
        }//if isFilled()

        switch(pos) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
            case 0:
                break;
            default:
                System.out.println("Try again.");
                break;
        }//switch
    }//playGame

    public static boolean isFilled(char[][] gameBoard, int pos) {
        switch(pos) {
            case 1:
                if (gameBoard[0][0] == 'X' || gameBoard[0][0] == 'O') {
                    return true;
                }//1
                break;
            case 2:
                if (gameBoard[0][2] == 'X' || gameBoard[0][2] == 'O') {
                    return true;
                }//2
                break;
            case 3:
                if (gameBoard[0][4] == 'X' || gameBoard[0][4] == 'O') {
                    return true;
                }//3
                break;
            case 4:
                if (gameBoard[2][0] == 'X' || gameBoard[2][0] == 'O') {
                    return true;
                }//4
                break;
            case 5:
                if (gameBoard[2][2] == 'X' || gameBoard[2][2] == 'O') {
                    return true;
                }//5
                break;
            case 6:
                if (gameBoard[2][4] == 'X' || gameBoard[2][4] == 'O') {
                    return true;
                }//6
                break;
            case 7:
                if (gameBoard[4][0] == 'X' || gameBoard[4][0] == 'O') {
                    return true;
                }//7
                break;
            case 8:
                if (gameBoard[4][2] == 'X' || gameBoard[4][2] == 'O') {
                    return true;
                }//8
                break;
            case 9:
                if (gameBoard[4][4] == 'X' || gameBoard[4][4] == 'O') {
                    return true;
                }//9
                break;               
        }//switch
        return false;
    }//isFilled

    public static void checkWinCondition(char[][] gameBoard) {
        boolean win = false;
        if (gameBoard[0][0] == 'X' && gameBoard[0][2] == 'X' && gameBoard[0][4] == 'X') {
            win = true;
        }//1st row
        if (gameBoard[2][0] == 'X' && gameBoard[2][2] == 'X' && gameBoard[2][4] == 'X') {
            win = true;
        }//2nd row
        if (gameBoard[4][0] == 'X' && gameBoard[4][2] == 'X' && gameBoard[4][4] == 'X') {
            win = true;
        }//3rd row
        if (gameBoard[0][0] == 'X' && gameBoard[2][0] == 'X' && gameBoard[4][0] == 'X') {
            win = true;
        }//1st column
        if (gameBoard[0][2] == 'X' && gameBoard[2][2] == 'X' && gameBoard[4][2] == 'X') {
            win = true;
        }//2nd column
        if (gameBoard[0][4] == 'X' && gameBoard[2][4] == 'X' && gameBoard[4][4] == 'X') {
            win = true;
        }//3rd column
        if (gameBoard[0][0] == 'X' && gameBoard[2][2] == 'X' && gameBoard[4][4] == 'X') {
            win = true;
        }//-diagonal
        if (gameBoard[0][4] == 'X' && gameBoard[2][2] == 'X' && gameBoard[4][0] == 'X') {
            win = true;
        }//diagonal
        if (win == true) {
            System.out.println("You win!");
            System.exit(0);
        }//if win
    }//checkWinCondition

    public static void checkLoseCondition(char[][] gameBoard) {
        boolean lose = false;
        if (gameBoard[0][0] == 'O' && gameBoard[0][2] == 'O' && gameBoard[0][4] == 'O') {
            lose = true;
        }//1st row
        if (gameBoard[2][0] == 'O' && gameBoard[2][2] == 'O' && gameBoard[2][4] == 'O') {
            lose = true;
        }//2nd row
        if (gameBoard[4][0] == 'O' && gameBoard[4][2] == 'O' && gameBoard[4][4] == 'O') {
            lose = true;
        }//3rd row
        if (gameBoard[0][0] == 'O' && gameBoard[2][0] == 'O' && gameBoard[4][0] == 'O') {
            lose = true;
        }//1st column
        if (gameBoard[0][2] == 'O' && gameBoard[2][2] == 'O' && gameBoard[4][2] == 'O') {
            lose = true;
        }//2nd column
        if (gameBoard[0][4] == 'O' && gameBoard[2][4] == 'O' && gameBoard[4][4] == 'O') {
            lose = true;
        }//3rd column
        if (gameBoard[0][0] == 'O' && gameBoard[2][2] == 'O' && gameBoard[4][4] == 'O') {
            lose = true;
        }//-diagonal
        if (gameBoard[0][4] == 'O' && gameBoard[2][2] == 'O' && gameBoard[4][0] == 'O') {
            lose = true;
        }//diagonal
        if (lose == true) {
            System.out.println("You lose...");
            System.exit(0);
        }//if lose
    }//checkLoseCondition
    

}//class TicTacToe