package users;

import bank.BankAccount;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Objects;
import java.util.UUID;

public abstract class User extends UnicastRemoteObject implements IUser {

    private final String name;
    private final String surname;
    private final String email;
    private final String password;
    private final UUID id;

    private final BankAccount bankAccount;

    private final Integer phoneNumber;

    /**
     * @param name        The name of the user
     * @param surname     The surname of the user
     * @param email       The email of the user
     * @param password    The password of the user
     * @param phoneNumber The phone number of the user
     */
    public User(String name, String surname, String email, String password, Integer phoneNumber, Double balance) throws RemoteException {
        super();
        this.name = Objects.requireNonNull(name);
        this.surname = Objects.requireNonNull(surname);
        this.email = verifyEmailAddress(email);
        this.password = Objects.requireNonNull(password);
        this.id = UUID.randomUUID();
        this.bankAccount = new BankAccount(balance);
        this.phoneNumber = verifyPhoneNumber(phoneNumber);
    }


    /**
     * @param email The email address to be verified
     *              The email address must be in the format:
     *              <name>@<domain>.<extension>
     *              where:
     *              <name> is a string of alphanumeric characters
     *              <domain> is a string of alphanumeric characters
     *              <extension> is a string of alphanumeric characters
     *              The email address must not be null
     *              The email address must not be empty
     *              The email address must contain a single @ character
     * @return The verified email address
     */
    private String verifyEmailAddress(String email) {
//        if (email == null) {
//            throw new IllegalArgumentException("Email cannot be null");
//        }
//        if (email.contains("@")&&email.contains(".")) {
        return email;
//        } else {
//            throw new IllegalArgumentException("Email address is not valid");
//        }
    }

    /**
     * @param phoneNumber The phone number to be verified
     *                    The phone number must be in the format:
     *                    <country code><area code><number>
     *                    where:
     *                    <country code> is a string of 3 digits
     *                    <area code> is a string of 3 digits
     *                    <number> is a string of 7 digits
     *                    The phone number must not be null
     *                    The phone number must not be empty
     *                    The phone number must contain a single @ character
     * @return The verified phone number
     */
    private Integer verifyPhoneNumber(Integer phoneNumber) {
        if (phoneNumber == null) {
            return null;
        }
        if (phoneNumber.toString().length() != 9) {
            throw new IllegalArgumentException("Phone number must be 9 digits long");
        }
        return phoneNumber;
    }


    /**
     * @param name         The name of the user
     * @param surname      The surname of the user
     * @param email        The email of the user
     * @param password     The password of the user
     * @param phoneNumber  The phone number of the user
     * @param currencyCode The currency code of the bank account
     */
    public User(String name, String surname, String email, String password, Integer phoneNumber, Double balance, String currencyCode) throws RemoteException {
        super();
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.id = UUID.randomUUID();
        this.phoneNumber = phoneNumber;
        this.bankAccount = new BankAccount(balance, currencyCode);
    }


    @Override
    public void SetBankAccountCurrency(String currencyCode) throws RemoteException {
        bankAccount.setCurrency(currencyCode);
    }


    @Override
    public String getName() throws RemoteException {
        return name;
    }

    @Override
    public String getSurname() throws RemoteException {
        return surname;
    }

    @Override
    public String getEmail() throws RemoteException {
        return email;
    }

    @Override
    public String getPassword() throws RemoteException {
        return password;
    }

    @Override
    public UUID getId() throws RemoteException {
        return id;
    }

    @Override
    public BankAccount getBankAccount() throws RemoteException {
        return bankAccount;
    }

    @Override
    public String display() throws RemoteException {
        return " [name=" + name + ", surname=" + surname + ", email=" + email + ", password=" + password + ", id=" + id + "]";
    }

    @Override
    public Integer getPhoneNumber() throws RemoteException {
        return phoneNumber;
    }
}
