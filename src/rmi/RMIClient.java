/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rmi;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

/**
 *
 * @author Thắng
 */
public class RMIClient {

    RMIInterface rmiServer;
    Registry registry;

    public RMIClient(String address, int port) {
        try {
            registry = LocateRegistry.getRegistry(address, port);
            rmiServer = (RMIInterface) (registry.lookup("rmiServer"));
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }

    public String searchByName(String str) {
        try {
            return rmiServer.search(str);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return "Không có dữ liệu";
    }

    public String showCertificate() {
        try {
            return rmiServer.certificate();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return "Không có dữ liệu";
    }

    public String showAll() {
        try {
            return rmiServer.show();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return "Không có dữ liệu";
    }

    public void theEnd() {
        try {
            rmiServer.end();
        } catch (RemoteException e) {
            //e.printStackTrace();
        }
        
    }

    public static void main(String args[]) {
        RMIClient client = new RMIClient("localhost", 3232);

        try {
            Scanner scan = new Scanner(System.in);
            int c = 0;
            while (c != 4) {
                System.out.println("----------------MENU----------------");
                System.out.println("1. Tìm kiếm sinh viên theo tên.");
                System.out.println("2. Hiển thị danh sách sinh viên Khá");
                System.out.println("3. Hiển thị toàn bộ sinh viên.");
                System.out.println("4. Kết thúc");
                System.out.print("Bạn chọn: ");
                c = Integer.parseInt(scan.nextLine());
                switch (c) {
                    case 1:
                        System.out.print("Nhập tên sinh viên cần tìm: ");
                        String name = scan.nextLine();
                        System.out.println(client.searchByName(name));
                        break;
                    case 2:
                        System.out.println(client.showCertificate());
                        break;
                    case 3:
                        System.out.println(client.showAll());
                        break;
                    case 4:
                        client.theEnd();
                        System.out.println("Cảm ơn bạn đã sử dụng chương trình!");
                        break;
                    default:
                        System.out.println("Bạn nhập chưa đúng");
                }
            }
        } catch (Exception e) {
            e.fillInStackTrace();
        }
    }
}
