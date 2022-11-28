package users;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.UUID;

public interface IUserProvider extends Remote {

    String RMI_BIND_NAME = "UserProvider";

    void registerUser(IUser user) throws RemoteException;
    void unregisterUser(IUser user) throws RemoteException;
    IUser getUser(String name) throws RemoteException;
    IUser getUser(UUID id) throws RemoteException;
    List<IUser> getAllUsers() throws RemoteException;

    void loadFromDB() throws RemoteException;
}
