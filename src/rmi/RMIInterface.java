/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Thắng
 */


public interface RMIInterface extends Remote {
    public String search(String str) throws RemoteException;
    public String certificate() throws RemoteException;
    public String show() throws RemoteException;
    public void end() throws RemoteException;
}
