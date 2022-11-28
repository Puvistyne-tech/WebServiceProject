package app;

import bike.*;
import users.IUserProvider;
import users.Student;
import users.UserProvider;
import utils.Utils;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebService
public class GustaveBikeService {

    private final List<IBike> basket ;
    private final IBikeProvider bikeProvider;
    private final IUserProvider userProvider;

    public GustaveBikeService() throws RemoteException, MalformedURLException, NotBoundException {
        basket = new ArrayList<>();
        this.bikeProvider = (IBikeProvider) Naming.lookup(IBikeProvider.RMI_BIND_NAME);
        this.userProvider = (IUserProvider) Naming.lookup(IUserProvider.RMI_BIND_NAME);
    }


    //4 services
    //consulter les prix des vélos,
    // de vérifier leur disponibilité, de
    //les ajouter à un panier et
    // de les acheter

    //1. consulter les prix des vélos
    public String displayAllBikes() throws RemoteException {
        return bikeProvider.getAllBikes();
    }

    private String listToString(List<String> list) throws RemoteException {
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s).append(".  \t\n");
        }
        return sb.toString();
    }


    //2. vérifier leur disponibilité
    public String getBikeDisponibility(String bikeId) throws RemoteException {

        IBike b = bikeProvider.getBike(UUID.fromString(bikeId));
        if (b == null) {
            return "Bike not found";
        }
        System.out.println(basket);

        return b.getSellState().toString();
    }

    //3. les ajouter à un panier
    public String addBikeToCart(String bikeId) throws RemoteException {
        IBike b = bikeProvider.getBike(UUID.fromString(bikeId));

        if (b == null) {
            return "Bike not found";
        }
        System.out.println(basket);

        SALE_STATUS status = b.getSellState();
        if (status == SALE_STATUS.SOLD) {
            return "Bike already sold";
        } else if (status == SALE_STATUS.RESERVED) {
            return "Bike already reserved";
        } else {
            basket.add(b);
            b.setSellState(SALE_STATUS.RESERVED);
            return "Bike added to cart";
        }

    }

    //4. les acheter
    public String buyBike(String bikeId) throws RemoteException {
        IBike b = bikeProvider.getBike(UUID.fromString(bikeId));
        if (b == null) {
            return "Bike not found";
        }
        SALE_STATUS status = b.getSellState();
        System.out.println(basket);
        if (status == SALE_STATUS.SOLD) {
            return "Bike already sold";
        } else if (status == SALE_STATUS.RESERVED && basket.contains(b)) {
            b.setSellState(SALE_STATUS.SOLD);
            basket.remove(b);
            return " Bike bought successfully !";
        } else {
            return "Bike can not bought. Please add it to your cart first\n" +
                    " or it is already reserved by another user\n" +
                    " or it is already sold\n" +
                    "Status : " + status;
        }
    }

}
