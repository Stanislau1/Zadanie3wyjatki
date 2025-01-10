class NotEnoughMoneyException extends Exception {
    public NotEnoughMoneyException(String message) {
        super(message);
    }
}

class Account {
    private String owner;
    private int balance;
    private String accountNumber;

    public Account(String owner, int balance, String accountNumber) {
        this.owner = owner;
        this.balance = balance;
        this.accountNumber = accountNumber;
    }
    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void transfer(int amount) throws NotEnoughMoneyException {
        if (amount > balance) {
            throw new NotEnoughMoneyException("Na koncie brak wystarczających środków do wykonania przelewu.");
        }
        balance -= amount;
        System.out.println("Przelew został pomyślnie zrealizowany! Kwota przelewu: " + amount);
    }
}

public class Main {
    public static void main(String[] args) {
        Account myAccount = new Account("Donald Trump", 1000, "123-456-789");

        try {
            System.out.println("Próba przelewu 1500...");
            myAccount.transfer(1500);
        } catch (NotEnoughMoneyException e) {
            System.out.println("Błąd: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Wystąpił nieoczekiwany błąd: " + e);
        } finally {
            System.out.println("Aktualny stan konta: " + myAccount.getBalance());
        }
    }
}
