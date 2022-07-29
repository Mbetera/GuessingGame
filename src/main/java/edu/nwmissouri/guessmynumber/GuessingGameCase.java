package edu.nwmissouri.guessmynumber;

import javax.swing.*;

/**
 * “Guess a Number” game that allows user to guess a random number. Uses Swing
 * to make a nice graphical user interface.
 *


 * .showInputDialog() .showMessageDialog()
 *
 * @author Deogratias Mbetera
 */
public class GuessingGameCase {

    public static void main(String[] args) {
        int secretNumber = (int) (Math.random() * 100 + 1);
        int userAnswer = 0;
        System.out.println("The correct guess would be " + secretNumber);
        int count = 1;

        while (userAnswer != secretNumber) {
            // TODO: create 3 local variables for the arguments so we know what they mean
            // showInputDialog - the first argument is always null (no parent)
            
            String message = "Enter a guess between 1 and 100";  // what type?
            String title = "Guessing Game"; // what type?
            int messageType = JOptionPane.INFORMATION_MESSAGE;
                     
            String response = JOptionPane.showInputDialog(null,message, title, messageType);
            userAnswer = Integer.parseInt(response);

            JOptionPane.showMessageDialog(null, "" + calculateMessage(userAnswer, secretNumber, count));
            count++;
        }
    }

    public static String calculateMessage(int userAnswer, int computerNumber, int count) {
        // TODO: Instead of "Try Number" which sounds like we should try that as a guess...
        // Say "You've used " + count + guesses.
        // If count is one, use "guess", else use "guesses" HINT: Ternary operator
        
        String s = (count == 1) ? " guess." :  " guesses.";
        if (userAnswer <= 0 || userAnswer > 100) {
            return "Your guess is invalid";
        } else if (userAnswer == computerNumber) {
            return "Correct!\nTotal Guesses: " + count;
        } else if (userAnswer > computerNumber) {
            return "Your guess is too high, try again.\nYou've used " + count + s;
        } else if (userAnswer < computerNumber) {
            return "Your guess is too low, try again.\nYou've used " + count + s;
        } else {
            return "Your guess is incorrect\nTry Number: " + count;
        }
    }
}
