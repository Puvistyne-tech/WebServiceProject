package utils;

import java.rmi.RemoteException;
import java.util.List;

public class Utils {
    public static String listToString(List<String> list) throws RemoteException {
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s).append(".  \t\n");
        }
        return sb.toString();
    }
}
