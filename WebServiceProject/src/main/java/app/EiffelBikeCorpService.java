package app;

import users.Employer;
import users.Student;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.rmi.RemoteException;

@WebService
public class EiffelBikeCorpService {

    @WebMethod
    public String createStudent(String name, String surname, String email, String password, Integer phoneNumber) throws RemoteException {
        return new Student(name, surname, email, password, phoneNumber,1000d,"EUR").display();
    }

    public String createEmployer(String name, String surname, String email, String password, Integer phoneNumber) throws RemoteException {
        return new Employer(name, surname, email, password, phoneNumber,1613d,"LKR").display();
    }





}
