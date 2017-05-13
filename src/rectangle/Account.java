package rectangle;

import java.util.Date;
import java.util.Scanner;

public class Account {
    
    private int id = 0;
    private double balance = 0;
    private double annualInterestRate = 0;
    private Date dateCreated;
    
    public Account() {
        //this is default constractor of the Accountant Class
    }
    
    Account(int id, double initialBalance) {
        this.id = id;
        this.balance = initialBalance;
        
    }
    
    public double getMonthlyInterestRate() {
        return ((annualInterestRate / 100) / 12);
    }
    
    public double getMonthlyInterest() {
        return balance * getMonthlyInterestRate();
    }
    
    public void withdraw(int id, double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Succsusful the balance is now : "+balance);
        } else {
            System.out.println("Insuffiecient Balance");
        }
    }
    
    public void deposit(int id, double amount) {
        balance += amount;
                System.out.println("Succsusful the balance is now : "+balance);
    
    }
    

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * @return the annualInterestRate
     */
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    /**
     * @param annualInterestRate the annualInterestRate to set
     */
    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    /**
     * @return the dateCreated
     */
    public Date getDateCreated() {
        return dateCreated;
    }
    
    public static void main(String... a) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the Amount of Accounts You wana to create");
        int am = scan.nextInt();
        Account[] acc = new Account[am];
        int[] id = new int[am];
        double[] bal = new double[am];
        double[] inter = new double[am];
        for (int i = 0; i < am; i++) {
            System.out.println("Enter the ID of " + (i + 1) + "th Account");
            id[i] = scan.nextInt();
            System.out.println("Enter the Balance of " + (i + 1) + "th Account");
            bal[i] = scan.nextDouble();
            System.out.println("Enter the Annual Interest of " + (i + 1) + "th Account");
            inter[i] = scan.nextDouble();
            acc[i] = new Account(id[i], bal[i]);
            acc[i].setAnnualInterestRate(inter[i]);
        }
        
        int choice;//this is to hold the service choice of the user
        System.out.println("_________________________________________");
        System.out.println("     CHOOSE THE SERVICE ");
        System.out.println("PRESS 1 TO DEPOSIT");
        System.out.println("PRESS 2 TO WITHDRAEW");
        System.out.println("PRESS 3 TO TRANSFER");
        choice = scan.nextInt();
        Account ac = new Account();
        switch (choice) {
            case 1:
                System.out.println("Enter the Id of the Accont");
                int id2 = scan.nextInt();
                System.out.println("Enter the amont you wana to deposit");
                double ba = scan.nextDouble();
                for (int i = 0; i < am; i++) {
                    if (id2 == id[i]) {
                        acc[i].deposit(id[i], ba);
                    }
                }
                break;
            
            case 2:
                System.out.println("Enter the Id of the Accont");
                id2 = scan.nextInt();
                System.out.println("Enter the amont you wana to withdraw");
                ba = scan.nextDouble();
                for (int i = 0; i < am; i++) {
                    if (id2 == id[i]) {
                        acc[i].withdraw(id[i], ba);
                    }
                }
                break;
            case 3:
                System.out.println("Enter the Id of the Sender Accont");
                int idSender = scan.nextInt();
                System.out.println("Enter the Id of the Receiver Accont");
                int idReceiver = scan.nextInt();
                System.out.println("Enter the amont you wana to Transfer");
                ba = scan.nextDouble();
                for (int i = 0; i < am; i++) {
                    if (idSender == id[i]) {
                        for (int j = 0; j < am; j++) {
                            if (idReceiver == id[j]) {
                                if (acc[i].balance >= ba) {
                                    acc[j].deposit(idReceiver, ba);//add the balance to the destination account
                                    acc[i].withdraw(idSender, ba);//subtracting the balance from the sender account
                                }
                                
                            }
                        }
                    }
                }
                break;
            default:
                System.out.println("Invalid Input");
        }
        
    }
}
