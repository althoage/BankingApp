import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.Scanner;


public class BankingMain {
    public static void main(String[] args) {

        NumberFormat formatter = NumberFormat.getCurrencyInstance();

        int option;
        Scanner scan = new Scanner(System.in);
        String fileName = "transactions.txt";
        PrintWriter outputStream = null;
        try {
            outputStream = new PrintWriter(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("Error opening file " + fileName);
            System.exit(0);
        }

        BankAccount A = new BankAccount();
        System.out.println("------------------------------");
        System.out.println("Please enter Customer name.");
        System.out.println("First Name: ");
        String newName = scan.nextLine();
        A.setName(newName);
        System.out.println("Last Name: ");
        String newLastName = scan.nextLine();
        A.setLastName(newLastName);
        A.setIDNumber();
        System.out.println("------------------------------");
        System.out.print("New account for: ");
        System.out.println(A.getName() + " " + A.getLastName());
        System.out.println("Customer ID: " + A.getIDNumber());
        System.out.println("Please enter initial deposit for new account : " + A.getIDNumber() + ".");
        try {
            double newDeposit = scan.nextDouble();
            if (!(newDeposit > 25))
                throw new InsufficientDepositException();
            A.setBalance(newDeposit);
        } catch (InsufficientDepositException e) {
            System.out.println(e.getMessage());
            System.exit(0);
        }
        outputStream.println(A);
        outputStream.println("------------------------------");


        do {

            System.out.println("------------------------------");
            A.display();
            System.out.println("Please choose an option between 1-4: ");
            System.out.println("------------------------------");
            option = scan.nextInt();
            System.out.println("\n");

            switch(option) {
                case 1:
                    System.out.println("------------------------------");
                    A.getBalance();
                    System.out.println("------------------------------");
                    System.out.println("\n");
                    break;

                case 2:
                    System.out.println("------------------------------");
                    System.out.println("Enter amount to deposit: ");
                    System.out.println("------------------------------");
                    double depositAmount = scan.nextDouble();
                    A.deposit(depositAmount);
                    String depositString = formatter.format(depositAmount);
                    outputStream.println("\tDeposit: +" + depositString);
                    System.out.println("\n");
                    break;

                case 3:
                    System.out.println("------------------------------");
                    System.out.println("Enter amount to withdraw: ");
                    System.out.println("------------------------------");
                    double withdrawAmount = scan.nextDouble();
                    A.withdraw(withdrawAmount);
                    String withdrawString = formatter.format(withdrawAmount);
                    outputStream.println("\tWithdrawal: -" + withdrawString);
                    System.out.println("\n");
                    break;

                case 4:
                    System.out.println("------------------------------");
                    A.getPreviousTransaction();
                    System.out.println("------------------------------");
                    break;

                case 0:
                    System.out.println("------------------------------");
                    outputStream.println("current balance: " + A.getBalance());
                    outputStream.println("------------------------------");
                    outputStream.println("End of user transaction history.");
                    break;
                default:
                    System.out.println("Error: Enter integer value 1-4. Enter 0 to exit program.");
                    break;

            }
        } while (option != 0);

        outputStream.close();
        System.out.println("You have now finished entering transaction data for account " + A.getIDNumber());

    }
}
