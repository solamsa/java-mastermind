package za.co.wethinkcode.mastermind;

import java.io.InputStream;
import java.util.Scanner;

public class Player {
    private final Scanner inputScanner;

    public Player() {
        this.inputScanner = new Scanner(System.in);
    }

    public Player(InputStream inputStream) {
        this.inputScanner = new Scanner(inputStream);
    }

    /**
     * Gets a guess from user via text console.
     * This must prompt the user to re-enter a guess until a valid 4-digit string is entered, or until the user enters `exit` or `quit`.
     *
     * @return the value entered by the user
     */
    public String getGuess() {
        boolean status = true;
        String incorrectMessage = "Please enter exactly 4 digits (each from 1 to 8).";
        String code ;

        do {
            System.out.println("Input 4 digit code:");
            code = inputScanner.nextLine();
//            System.out.println();
            if(code.length() != 4 || code.isBlank()){
                System.out.println(incorrectMessage);
                status = false;
                continue;
            }else {
                status = true;
            }
            for (int i = 0; i < 4; i ++){
                if (code.charAt(i) < '1' || code.charAt(i) > '8') {
                    System.out.println(incorrectMessage);
                    status = false;
                    break;
                }else {
                    status = true;
                    }
            }
        } while (status == false);
        return code;
    }
}
