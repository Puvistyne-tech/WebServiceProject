package users;

public class UserApp {
    public static void main(String[] args) {
        try{
            java.rmi.registry.LocateRegistry.createRegistry(1098);
            IUserProvider userProvider = new UserProvider();
            userProvider.loadFromDB();
            java.rmi.Naming.rebind(IUserProvider.RMI_BIND_NAME, userProvider);
            System.out.println("UserProvider is ready");

            System.out.println("RMI registry ready.");
        } catch (Exception e) {
            System.out.println("RMI registry already running.");
        }
    }
}
