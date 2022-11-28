package bank;

import java.util.Currency;
import java.util.Objects;
import java.util.UUID;

public class BankAccount {

    private final UUID accountNumber;
    private double balance;
    private Currency currency;

    public BankAccount(Double balance) {
        this.accountNumber = UUID.randomUUID();
        this.balance = balance;
        this.currency = Currency.getInstance("EUR");
    }

    public BankAccount(Double balance,String currencyCode) {
        this.accountNumber = UUID.randomUUID();
        this.balance = 0;
        this.currency = Currency.getInstance(Objects.requireNonNull(currencyCode));
    }

    public void setCurrency(String currencyCode) {
        this.currency = Currency.getInstance(currencyCode);
    }

    public UUID getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {
        this.balance -= amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    boolean hasEnoughBalance(double amount) {
        return this.balance >= amount;
    }
}
