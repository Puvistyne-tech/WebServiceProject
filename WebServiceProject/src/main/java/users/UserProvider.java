package users;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class UserProvider extends UnicastRemoteObject implements IUserProvider {

    private static final long serialVersionUID = 1L;
    private final HashMap<UUID, IUser> users = new HashMap<>();

    public UserProvider() throws RemoteException {
        super();
    }

    /**
     * @param user The user to be registered
     *             The user must not be null
     *             The user must not be already registered
     * @throws RemoteException    If the user is null
     */
    @Override
    public void registerUser(IUser user) throws RemoteException {
        UserTest(user);
        if (getUser(user.getName()) != null) {
            throw new RemoteException("User already exists");
        }
        users.put(user.getId(), user);
    }

    /**
     * @param user The user to be unregistered
     * @throws RemoteException if the user does not exist
     */
    @Override
    public void unregisterUser(IUser user) throws RemoteException {
        UserTest(user);
        if (getUser(user.getName()) == null) {
            throw new RemoteException("User does not exist");
        }
        users.remove(user.getId());
    }

    /**
     * @param name The name of the user to be retrieved
     * @return The user with the given name
     * @throws RemoteException if the user does not exist
     */
    @Override
    public IUser getUser(String name) throws RemoteException {
        if (name == null) {
            throw new RemoteException("Name cannot be null");
        }
        for (IUser user : users.values()) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    /**
     * @param id The id of the user to be retrieved
     * @return The user with the given id
     * @throws RemoteException if the user does not exist
     */
    @Override
    public IUser getUser(UUID id) throws RemoteException {
        if (id == null) {
            throw new RemoteException("Id cannot be null");
        }
        return users.get(id);
    }

    /**
     * @return A list of all users
     */
    @Override
    public List<IUser> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    @Override
    public void loadFromDB() throws RemoteException {
        Student student = new Student("name", "surname", "email@ofei.com", "passwrod", 123456789, 2983d);
        Student student2 = new Student("name2", "surname2", "email2@ofei.com", "passwrod", 123456789, 3000d);
        registerUser(student);
        registerUser(student2);
    }

    /**
     * @param user The user to be tested
     * @throws RemoteException if the user is null
     */
    private void UserTest(IUser user) throws RemoteException {
        if (user == null) {
            throw new RemoteException("User is null");
        }
//        if (user.getName() == null || user.getName().isEmpty()) {
//            throw new RemoteException("Username is null or empty");
//        }
//        if (user.getSurname() == null || user.getSurname().isEmpty()) {
//            throw new RemoteException("User surname is null or empty");
//        }
//        if (user.getEmail() == null || user.getEmail().isEmpty()) {
//            throw new RemoteException("User email is null or empty");
//        }
//        if (user.getPassword() == null || user.getPassword().isEmpty()) {
//            throw new RemoteException("User password is null or empty");
//        }
//        if (user.getPhoneNumber() == null) {
//            throw new RemoteException("User phone number is null");
//        }
    }
}
