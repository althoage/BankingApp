import java.text.NumberFormat;
class BankAccount extends Customer {
    private double balance;
    private double previousTransaction;
    NumberFormat formatter = NumberFormat.getCurrencyInstance();

    BankAccount() {
        super();
        balance = 0;

    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setPreviousTransaction(double previousTransaction) {
        this.previousTransaction = previousTransaction;
    }

    void withdraw(double amount) {
        if (balance > amount) {
            setBalance((balance -= amount));
            setPreviousTransaction(-(amount));
        } else {
            System.out.println("Not enough funds!");
            getBalance();
        }
    }
    void deposit(double amount) {
            setBalance(balance+=amount);
           setPreviousTransaction(amount);
    }

    public void getPreviousTransaction() {
        String transactionString = formatter.format(previousTransaction);
        if(previousTransaction > 0) {
            System.out.println("Deposited: " + transactionString);
        } else if (previousTransaction < 0) {
            String transactionStringWithdraw = formatter.format(Math.abs(previousTransaction));
            System.out.println("Withdrawn: " + transactionStringWithdraw);
        } else {
            System.out.println("No previous transactions.");
        }


    }
    String getBalance() {
        String balanceString = formatter.format(balance);
        return "Account Balance: " + balanceString;
    }
    public void writeOutput() {
        super.writeOutput();
        System.out.println(getBalance());
    }

    @Override
    public String toString() {
        return
                "***Bank Account for: " + name + " " + lastName + "***"+ '\n' + "Account Number: " + IDNumber + "\nInitial Balance: "
                        + getBalance() ;
    }

    void display() {
        writeOutput();
        System.out.println("\n");
        System.out.println("1. Check Balance");
        System.out.println("2. Make a Deposit");
        System.out.println("3. Make a withdrawal");
        System.out.println("4. See previous transaction");
        System.out.println("0. Exit");
    }

    }



