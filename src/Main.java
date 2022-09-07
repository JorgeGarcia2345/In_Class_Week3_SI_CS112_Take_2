
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        /**
         * What are a lot of people having issues with??
         * Exceptions week: Build an exceptions class where if someone is hard on themselves, throw an error out
         *
         *
         *
         * Exception - erroneous or unexpected event, that if unhandled will crash the code
         *
         * Handle exceptions with a try/catch block
         *              {
         *
         *           }
         *
         * Types of exceptions: Categories!
         * //// Unchecked (RunTime) Exceptions, in the users hands
         *  - input mismatch exception: expecting 1 data type then getting another (incompatible)
         *  - char but got double, int or String
         *
         *
         *  //// Checked Exceptions
         *  - Compile Tile, code won't run
         *  Anything I/O related input/output w/ files
         *
         *  Custom Exceptions
         *
         * //// NullPointerException (NPE)
         *  - call a method on a null object
         *
         *
         * //// ArrayIndexOutOfBoundsException
         *  - looking for an index that is not there
         *
         *
         * SQL Drop
         *
         *
         * Let's create an exceptions class and build it together!
         */
        /*
        int rating = 0, min = 1, max = 5;
        Scanner keyboard = new Scanner(System.in);
        boolean error = false;
        do {
            try {
                System.out.print("Please enter a rating between " + min + " and " + max + ": ");
                //rating = keyboard.nextInt();
                //         keyboard.nextLine();
                rating = Integer.parseInt(keyboard.nextLine());
                error = (rating < min || rating > max);

            } catch (InputMismatchException | NumberFormatException e) {
                //System.out.println("Please enter an integer between " + min + " and " + max); // Informs the user what is wrong and how to fix/correct it
                error = true;
            }
            if(error)
                System.out.println("Whoops, try again!");
        }
        while(error);
        System.out.println("\nThe rating you entered is: " + rating);
        keyboard.close();

         */

        Scanner keyboard = new Scanner(System.in);
        String name;
        int time, count = 0;
        String[] appointments = new String[6];
        do{
            try{
            System.out.println("Please enter the time slot you would like to choose? ");
            time = Integer.parseInt(keyboard.nextLine()) - 1;
            if(time < 0 || time >= appointments.length)
                throw new InvalidTimeException();
            if (appointments[time] != null)
                throw new TimeInUseException();
            System.out.print("Please enter the name: ");
            name = keyboard.nextLine();
            appointments[time] = name;
            count++;
            System.out.println("Here are the current appointments");
                for (int i = 0; i < appointments.length; i++) {
                    System.out.print((i + 1) + ":00 PM ");
                    if(appointments[i] == null)
                        System.out.println("[Empty]");
                    else
                        System.out.println(appointments[i]);
                }
            } catch (TimeInUseException | InvalidTimeException | InputMismatchException | NumberFormatException e) {
            System.out.println(e.getMessage());
            }
        }while(count < appointments.length);
        System.out.println("All appointments have been booked!");
        keyboard.close();
    }

}
