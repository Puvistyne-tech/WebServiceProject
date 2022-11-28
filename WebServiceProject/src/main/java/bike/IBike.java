package bike;

import users.IUser;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface IBike extends Remote {

    UUID getId() throws RemoteException;

    IUser getOwner() throws RemoteException;

    SALE_STATUS getSellState() throws RemoteException;

    void setSellState(SALE_STATUS state) throws RemoteException;

    CONDITION_STATUS getBikeCondition() throws RemoteException;

    void setBikeCondition(CONDITION_STATUS condition) throws RemoteException;

    Integer getPrice() throws RemoteException;

    List<IUser> getWaitingList() throws RemoteException;

    Map<IUser, String> getComments() throws RemoteException;

    Map<IUser, Integer> getRatings() throws RemoteException;

    String display() throws RemoteException;

    void addComment(IUser user, String comment) throws RemoteException;

    void addRating(IUser user, int rating) throws RemoteException;

    void addHistory(IUser user) throws RemoteException;

    void addToWaitingList(IUser user) throws RemoteException;

    void removeFromWaitingList(IUser user) throws RemoteException;


}
