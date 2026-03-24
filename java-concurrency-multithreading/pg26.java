import java.util.Scanner;

class Account {
    int balance;
    static Scanner sc = new Scanner(System.in);

    synchronized void deposit() throws InterruptedException {
        System.out.print("Amount : ");
        int amount = sc.nextInt();
        balance += amount;
        System.out.println("New balance: " + balance);
       
    }

    synchronized void withdraw() throws InterruptedException {
        System.out.print("Withdrawal Amount : ");
        int amount = sc.nextInt();
        if (balance < amount) { 
            System.out.println("Insufficient Balance, waiting...");
            return;
        }
        balance -= amount;
        System.out.println("Withdrawn: " + amount);
       
    }
}

class pg26 {
    public static void main(String args[]) {
        Account a = new Account();

        Thread user1 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                try {
                    a.withdraw();
                    Thread.sleep(100); // sleep outside synchronized
                } catch (InterruptedException e) {}
            }
        });

        Thread user2 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                try {
                    a.deposit();
                    Thread.sleep(100); // sleep outside synchronized
                } catch (InterruptedException e) {}
            }
        });

        user1.start();
        user2.start();
    }
}
