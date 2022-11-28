package users;

import java.rmi.RemoteException;

public class Employer extends User {

    public Employer(String name, String surname, String email, String password, Integer phoneNumber, Double bankBalance) throws RemoteException {
        super(name, surname, email, password, phoneNumber, bankBalance);
    }

    public Employer(String name, String surname, String email, String password, Integer phoneNumber, Double bankBalance,String currencyCode) throws RemoteException {
        super(name, surname, email, password, phoneNumber, bankBalance,currencyCode);
    }

    @Override
    public String display() throws RemoteException {
        return "Employer "+super.display();
    }

}
