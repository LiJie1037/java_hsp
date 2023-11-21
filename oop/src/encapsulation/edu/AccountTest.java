package encapsulation.edu;

public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account("hhh", 15, "1234567");
        account.info();

    }
}

class Account {
    private String name;
    private double balance;
    private String password;

    public Account() {
    }

    public Account(String name, double balance, String password) {
//        this.name = name;
//        this.balance = balance;
//        this.password = password;
        setName(name);
        setBalance(balance);
        setPassword(password);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() >= 2 && name.length() <= 4) {
            this.name = name;
        } else {
            this.name = "ABC";
            System.out.println("name.length() 需要再2-4之间");
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance > 20) {
            this.balance = balance;
        } else {
            this.balance = 20;
            System.out.println("balance should > 20");
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password.length() == 6) {
            this.password = password;
        } else {
            this.password = "123456";
            System.out.println("password should be set to 6 digits.");
        }
    }

    public void info() {
        System.out.printf("name=%s, balance=%.2f, password=%s\n", name, balance, password);
    }
}