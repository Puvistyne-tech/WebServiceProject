package users;

import bank.BankAccount;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.UUID;

public interface IUser extends Remote {
    String getName()throws RemoteException;
    String getSurname()throws RemoteException;
    String getEmail()throws RemoteException;
    String getPassword()throws RemoteException;
    Integer getPhoneNumber()throws RemoteException;

    void SetBankAccountCurrency(String currencyCode) throws RemoteException;


    BankAccount getBankAccount()throws RemoteException;
    String display() throws RemoteException;

    UUID getId()throws RemoteException;

}
