package bike;

import users.IUser;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class Bike extends UnicastRemoteObject implements Serializable, IBike {


    private SALE_STATUS state;
    private CONDITION_STATUS condition;
    private final IUser owner;
    private final UUID id;

    private int price;

    public void setPrice(int price) throws RemoteException {
        this.price = price;
    }

    private final List<IUser> waitingList;
    private final Map<IUser, String> comments;
    private final Map<IUser, Integer> ratings;

    //TODO: add a list of users who have used the bike
    private final Set<IUser> history;

    public Bike(CONDITION_STATUS condition, IUser owner, int price) throws RemoteException {
        super();
        this.price = price;
        this.state = Objects.requireNonNull(SALE_STATUS.AVAILABLE);
        this.condition = Objects.requireNonNull(condition);
        this.owner = Objects.requireNonNull(owner);
        this.id = UUID.randomUUID();
        this.waitingList = new ArrayList<>();
        this.comments = new HashMap<>();
        this.ratings = new HashMap<>();
        this.history = new HashSet<>();
    }


    @Override
    public SALE_STATUS getSellState() throws RemoteException {
        return state;
    }

    @Override
    public void setSellState(SALE_STATUS state) throws RemoteException {this.state = state;}

    @Override
    public IUser getOwner() throws RemoteException {
        return owner;
    }

    @Override
    public List<IUser> getWaitingList() throws RemoteException {
        return waitingList;
    }

    @Override
    public Map<IUser, String> getComments() throws RemoteException {
        return comments;
    }

    @Override
    public Map<IUser, Integer> getRatings() throws RemoteException {
        return ratings;
    }


    @Override
    public void addComment(IUser user, String comment) throws RemoteException {
        comments.put(user, comment);
    }

    @Override
    public void addRating(IUser user, int rating) throws RemoteException {
        ratings.put(user, rating);
    }

    @Override
    public void addHistory(IUser user) throws RemoteException {
        history.add(user);
    }

    @Override
    public void addToWaitingList(IUser user) throws RemoteException {
        waitingList.add(user);
    }

    @Override
    public void removeFromWaitingList(IUser user) throws RemoteException {
        waitingList.remove(user);
    }

    @Override
    public UUID getId() throws RemoteException {
        return id;
    }

    @Override
    public String display() throws RemoteException {
        return "Bike [id=" + id + ", state=" + state + ", owner=" + owner.getName() + ", price=" + price + "]";
    }


    @Override
    public CONDITION_STATUS getBikeCondition() throws RemoteException {
        return condition;
    }

    @Override
    public void setBikeCondition(CONDITION_STATUS condition) throws RemoteException {
        this.condition = condition;
    }

    @Override
    public Integer getPrice() throws RemoteException {
        return price;
    }
}
