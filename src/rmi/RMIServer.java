/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/**
 *
 * @author Thắng
 */
public class RMIServer extends UnicastRemoteObject implements RMIInterface  {

    int thisPort = 3232;
    String thisAddress;
    Registry registry;

    public RMIServer() throws RemoteException {
        try {
            registry = LocateRegistry.createRegistry(thisPort);
            registry.rebind("rmiServer", this);
        } catch (RemoteException e) {
            throw e;
        }
    }

    public ArrayList<Student> getListStudent() {
        ArrayList<Student> list = new ArrayList<Student>();

        try {
            FileReader fr = new FileReader("C:\\Users\\haimr\\Documents\\NetBeansProjects\\RMI\\src\\rmi\\Student.txt");
            BufferedReader br = new BufferedReader(fr);
            String str = "";
            while ((str = br.readLine()) != null) {
                String s[] = str.split("\\$");
                //Student(String fullName, String code, String spec, float gpa)
                Student student = new Student(s[0], s[1], s[2], Float.parseFloat(s[3]));
                list.add(student);
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public String search(String str) throws RemoteException {
        String results = "";
        for (int i = 0; i < getListStudent().size(); i++) {
            if (str.equalsIgnoreCase(getListStudent().get(i).getFullName())) {
                System.out.println();
                results += getListStudent().get(i);
            }
        }

        return results;
    }

    @Override
    public String certificate() throws RemoteException {
        String results = "";
        for (int i = 0; i < getListStudent().size(); i++) {
            if ((getListStudent().get(i).getGpa()) >= 3.0) {
                results += getListStudent().get(i);
            }
        }

        return results;
    }

    @Override
    public String show() throws RemoteException {

        return "Danh sách tìm thấy \n" + (getListStudent());

    }

    public void stop(String str) throws Exception {
        System.out.println("Stopping rmi server.");
        UnicastRemoteObject.unexportObject(registry, true);
        System.exit(0);
    }

    public static void main(String args[]) throws RemoteException, Exception {
        new RMIServer();
    }

    @Override
    public void end() throws RemoteException {
        System.out.println("Stopping rmi server.");
        UnicastRemoteObject.unexportObject(registry, true);
        System.exit(0);
    }

}
