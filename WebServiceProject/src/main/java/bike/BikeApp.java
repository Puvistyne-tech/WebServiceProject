package bike;

import java.rmi.registry.LocateRegistry;

public class BikeApp {
    public static void main(String[] args) {
        try{
            LocateRegistry.createRegistry(1099);
            IBikeProvider bikeProvider = new BikeProvider();
            bikeProvider.loadFromDB();
            java.rmi.Naming.rebind(IBikeProvider.RMI_BIND_NAME, bikeProvider);
            System.out.println("BikeProvider is ready");

            System.out.println("RMI registry ready.");
        } catch (Exception e) {
            System.out.println("RMI registry already running.");
        }
    }
}
