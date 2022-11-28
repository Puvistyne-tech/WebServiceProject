package bank;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class BankAccountService {
    private final HashMap<UUID, BankAccount> accounts;

    public BankAccountService() {
        this.accounts = new HashMap<>();
    }

    public void registerAccount(BankAccount account) {
        this.accounts.put(account.getAccountNumber(), account);
    }

    public BankAccount getAccount(UUID accountNumber) {
        return this.accounts.get(accountNumber);
    }

    public List<BankAccount> getAllAccounts() {
        return (List<BankAccount>) this.accounts.values();
    }

    public void buy(UUID accountNumber, double amount) {
        BankAccount account = this.accounts.get(accountNumber);
        if (account == null) {
            throw new IllegalArgumentException("Account does not exist");
        }
        if (account.hasEnoughBalance(amount)) {
            account.withdraw(amount);
        } else {
            throw new IllegalArgumentException("Not enough balance");
        }
    }
}
