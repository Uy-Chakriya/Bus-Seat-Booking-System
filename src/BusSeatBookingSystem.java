import java.util.Scanner;
public class BusSeatBookingSystem {

    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";

    public static final String RESET = "\u001B[0m";
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        boolean[] seats = new boolean[25];
        for (int i = 0; i < seats.length; i++) {
            seats[i] = true;
        }

        String choice = "yes";

        // ==>> this is for the
        while (choice.equalsIgnoreCase("yes")) {
            System.out.println("\n---------------------------------------------------------");

            for (int i = 0; i < 25; i++) {

                if (seats[i]) {
                    System.out.print("|  " + GREEN + "(+)" + RESET + " " + String.format("%02d", (i + 1)) + "  ");
                } else {
                    System.out.print("|  " + RED + "(-)" + RESET + " " + String.format("%02d", (i + 1)) + "  ");
                }

                if ((i + 1) % 5 == 0) {
                    System.out.println("|");
                    System.out.println("---------------------------------------------------------");
                }
            }

            // available seat and unavailabel seat

            int available = 0;
            int unavailable = 0;

            for (boolean s : seats) {
                if (s) available++;
                else unavailable++;
            }

            System.out.println();
            System.out.println(RED + "( - )" + RESET + " : Unavailable ( " + unavailable + " )"
                    + "        " +
                    GREEN + "( + )" + RESET + " : Available ( " + available + " )");

            String seatInput;
            int seatNumber;

            while (true) {
                System.out.print("\nEnter seat number to book (1–25): ");
                seatInput = input.next();

                if (seatInput.matches("([1-9]|1[0-9]|2[0-5])")) {
                    seatNumber = Integer.parseInt(seatInput);
                    break;
                } else {
                    System.out.println(RED + "Please enter only numbers 1–25." + RESET);
                }
            }

            if (!seats[seatNumber - 1]) {
                System.out.println(RED + "Seat already booked!" + RESET);
            } else {
                seats[seatNumber - 1] = false;
                System.out.println(GREEN + "Seat " + seatNumber + " successfully booked!" + RESET);
            }

            while (true) {
                System.out.print("\nDo you want to continue booking? (yes/no): ");
                choice = input.next();

                if (choice.matches("(?i)yes|no")) break;

                System.out.println(RED + "Type yes or no only." + RESET);
            }
        }
// this is just for the testing and explore
        System.out.println("\nThank you for your booking. Good luck!🙏😍");
        input.close();
    }
}
