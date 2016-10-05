package application;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class client {
	
	public static void main(String[] args) {
	Pizza pizza=new Pizza();	
		try {
			Socket client=new Socket("localhost",9000);
			
			OutputStream out=client.getOutputStream();
			DataOutputStream data=new DataOutputStream(out);
			System.out.println("Am efectuat o comanda");
			data.writeUTF("Comanda este:\n ");
			
			InputStream in=client.getInputStream();
			DataInputStream dis=new DataInputStream(in);
			System.out.println("Serverul a zis: "+dis.readUTF());
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
