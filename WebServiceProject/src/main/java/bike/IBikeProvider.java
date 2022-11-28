package bike;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.UUID;

public interface IBikeProvider extends Remote {

    String RMI_BIND_NAME = "BikeProvider";

    void registerBike(IBike bike) throws RemoteException;

    void unregisterBike(UUID bikeId) throws RemoteException;

    IBike getBike(UUID id) throws RemoteException;

    //    List<IBike> getAllBikes() throws RemoteException;
    String getAllBikes() throws RemoteException;

    void sellBike(UUID bikeId) throws RemoteException;

    void rentBike(UUID bikeId) throws RemoteException;

    void returnBike(UUID bikeId) throws RemoteException;

    void loadFromDB() throws RemoteException;

}
