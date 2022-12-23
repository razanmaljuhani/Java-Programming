/* Hi teatcher , I hope you'r alawys happy >> Here The solving of assignment5 in Java language . 
The Date of sending :  Tuseday , December 5th , 2018 */
// My personal info. >> Name(Razan Muhammed Dakheel Aljohani), ID(1806065), Section(BAR), Email(Raljohani0084@stu.kau.edu.sa) .
package bar1806065p5;

import java.util.Scanner;

public class Bar1806065p5 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] game_stat = new int[2];
        //Start of loop
        while (true) {
            String secret_word = getSecretWord();
            char[] secret_letter = new char[secret_word.length()];
            for (int i = 0; i < secret_letter.length; i++) {
                secret_letter[i] = '_';
            }
            boolean winorLoss = playOneGame(secret_word, secret_letter);
            if (winorLoss) {
                System.out.println("You did it right :) , The word is:  " + secret_word);
                System.out.println("");
                game_stat[0]++;
            } else {
                System.out.println("Wrong :( ,The word was..." + secret_word);
                System.out.println("");
                game_stat[1]++;
            }
            System.out.println("Do you want to play again (y / n):");
            char choice = input.next().charAt(0);
            if (choice == 'n') {
                getStat(game_stat, 1);
                break;
            }
        }
    }

//*****************
//Method 1 void intro . 
    public static void intro() {
        System.out.println("Hangman Game!");
        System.out.println("I will think of a random word.");
        System.out.println("You'll try to guess its letters.");
        System.out.println("Try guess correctly to avoid loses!");
    }

//*****************
//Method 2 String getSecretWord .   
    public static String getSecretWord() {
        String[] words = {"ruby", "python", "java", "fortran", "html", "php"};
        int indexNumber = (int) (Math.random() * words.length);
        return words[indexNumber];
    }

//*****************
//Method 3 boolean playOneGame .      
    public static boolean playOneGame(String secret_word, char[] secret_letter) {
        intro();
        int numT = 5;
        int correctSelect = 0;
        int wrongSelect = 0;
        String misses = "";
        while (numT > 0 && winningState(secret_letter) != secret_word.length()) {
            System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.println("You have " + numT + " trials left.");
            System.out.print("Word:	");
            for (int i = 0; i < secret_letter.length; i++) {
                System.out.print(secret_letter[i] + " ");
            }
            System.out.println("");
            System.out.print("Enter your Guess Letter: ");
            Scanner input = new Scanner(System.in);
            char guessL = input.next().charAt(0);
            guessL = Character.toLowerCase(guessL);
            boolean guess = correctGuess(secret_word, secret_letter, guessL);
            if (guess) {
                correctSelect++;
            } else {
                wrongSelect++;
                numT--;
                misses += guessL + " ";
            }
            if (misses.length() > 0) {
                System.out.println("Misses:  " + misses);
            }
        }
        System.out.println("************************************");
        System.out.println("Your Attempt Status: ");
        System.out.println("_____________________");
        System.out.println("number of wrong guess is = " + wrongSelect);
        System.out.println("number of correct guesses is = " + correctSelect);
        System.out.println("************************************");
        if (numT > 0) {
            return true;
        } else {
            return false;
        }
    }

//*****************
//Method 4  boolean correctGuess .     
    public static boolean correctGuess(String secret_word, char[] secret_letter, char guessLetter) {
        boolean findingLetter = false;
        for (int i = 0; i < secret_word.length(); i++) {
            if (guessLetter == secret_word.charAt(i)) {
                findingLetter = true;
                secret_letter[i] = guessLetter;
            }
        }
        return findingLetter;
    }

//*****************
//Method 5  int winningState .    
    public static int winningState(char[] secret_letter) {
        int letterCount = 0;
        for (int i = 0; i < secret_letter.length; i++) {
            if (Character.isLetter(secret_letter[i])) {
                letterCount++;
            }
        }
        return letterCount;
    }

//*****************
//Method 6 void  void getStat .   
    public static void getStat(int[] game_stat, int index) {
        System.out.println("----------------------------------------------------------");
        System.out.println("Your final Profile status:");
        System.out.println("____________________________");
        int total_hangman = (game_stat[0] + game_stat[1]);
        System.out.println("total number of Hangman games played  = " + total_hangman);
        int total_won = game_stat[0];
        System.out.println("total number of won games  = " + total_won);
        int total_loss = game_stat[1];
        System.out.println("total number of loss games  = " + total_loss);
    }
}
