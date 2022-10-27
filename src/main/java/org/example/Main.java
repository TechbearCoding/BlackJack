package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int dealerScore = 0;
        int playerScore = 0;
        while(true){
            System.out.println("Draw card or finish the game? 1- draw, 2- finish");
            System.out.println("Current score- " + playerScore);
            Scanner sc = new Scanner(System.in);
            String choice = sc.nextLine();
            if(dealerScore <= 17)
                dealerScore += drawCard();

            if(choice.equals("1")){
                playerScore += drawCard();
                if(playerScore > 21){
                    checkWin(playerScore, dealerScore);
                    System.out.println("Game over, you lose");
                    return;
                }
            }else if(choice.equals("2")){
                checkWin(playerScore, dealerScore);
                return;
            }else{
                System.out.println("You have to choose 1 or 2");
            }

        }
    }

    private static void checkWin(int playerScore, int dealerScore){
        if(playerScore > dealerScore){
            System.out.println("Player wins!");
        }else if(dealerScore > playerScore){
            System.out.println("Table wins!");
        }else{
            System.out.println("Same score, table wins!");
        }

        System.out.println("Table score- " + dealerScore);
        System.out.println("Player score- " + playerScore);
    }

    private static int drawCard(){
        return (int)(Math.random()*(11-1+1)+1);
    }
}

