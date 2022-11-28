package bike;

import users.Student;
import users.UserProvider;
import utils.Utils;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class BikeProvider extends UnicastRemoteObject implements IBikeProvider{

    private static final long serialVersionUID = 1L;
	private final HashMap<UUID, IBike> bikes = new HashMap<>();

    public BikeProvider() throws RemoteException {
        //loadFromDB();
        super();
    }

    @Override
    public void registerBike(IBike bike) throws RemoteException {
        BikeTest(bike);
        if (getBike(bike.getId()) != null) {
            throw new RemoteException("Bike already exists");
        }
        bikes.put(bike.getId(), bike);
    }

    private void BikeTest(IBike bike) throws RemoteException {
        if (bike == null) {
            throw new IllegalArgumentException("Bike cannot be null");
        }
    }

    @Override
    public void unregisterBike(UUID bikeId) throws RemoteException {
        if (bikeId == null) {
            throw new RemoteException("BikeId cannot be null");
        }
        if (!bikes.containsKey(bikeId)) {
            throw new RemoteException("Bike does not exist");
        }
        bikes.remove(bikeId);
    }

    @Override
    public IBike getBike(UUID id) throws RemoteException {
        if (id == null) {
            throw new RemoteException("Id cannot be null");
        }
        return bikes.get(id);
    }

//    @Override
//    public List<IBike> getAllBikes() throws RemoteException {
//        return new ArrayList<>(bikes.values());
//    }

    @Override
    public String getAllBikes() throws RemoteException {
        StringBuilder sb = new StringBuilder();
        for (IBike bike : bikes.values()) {
            sb.append(bike.display());
            sb.append(" \n");
        }
        return sb.toString();
    }


    @Override
    public void sellBike(UUID bikeId) throws RemoteException {
        if (bikeId == null) {
            throw new RemoteException("BikeId cannot be null");
        }
        if (!bikes.containsKey(bikeId)) {
            throw new RemoteException("Bike does not exist");
        }
        bikes.get(bikeId).setSellState(SALE_STATUS.SOLD);
    }

    @Override
    public void rentBike(UUID bikeId) throws RemoteException {
        if (bikeId == null) {
            throw new RemoteException("BikeId cannot be null");
        }
        if (!bikes.containsKey(bikeId)) {
            throw new RemoteException("Bike does not exist");
        }
        bikes.get(bikeId).setSellState(SALE_STATUS.RENTED);
    }


    @Override
    public void returnBike(UUID bikeId) throws RemoteException {
        if (bikeId == null) {
            throw new RemoteException("BikeId cannot be null");
        }
        if (!bikes.containsKey(bikeId)) {
            throw new RemoteException("Bike does not exist");
        }
        bikes.get(bikeId).setSellState(SALE_STATUS.AVAILABLE);
    }

    public void loadFromDB() throws RemoteException {
        Student student = new Student("name", "surname", "email@ofei.com", "passwrod", 123456789, 2983d);
        Student student2 = new Student("name2", "surname2", "email2@ofei.com", "passwrod", 123456789, 3000d);
        UserProvider up= new UserProvider();
        up.registerUser(student);
        up.registerUser(student2);

        IBike b1=new Bike(CONDITION_STATUS.NEW, student, 274);
        IBike b2=new Bike(CONDITION_STATUS.USED, student2, 100);
        IBike b3=new Bike(CONDITION_STATUS.DAMAGED, student2, 20);

        registerBike(b1);
        registerBike(b2);
        registerBike(b3);

    }
}
