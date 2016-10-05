
//SERVERUL MEU
package application;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server implements Runnable{

	
	Pizza pizza=new Pizza();
	private static ServerSocket ss;
	private String mesaj="";
	
	public static void main(String[] args) {
		try {
			ss=new ServerSocket(9000);
			server serv=new server();
			Thread t=new Thread(serv);
			t.start();
			System.out.println("Bine ati venit!");
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void run() {
		while(true){
			try {
				Socket socket=ss.accept();
				InputStream in=socket.getInputStream();
				DataInputStream dis=new DataInputStream(in);
				
				
				
			OutputStream out=socket.getOutputStream();
			DataOutputStream data=new DataOutputStream(out);
			data.writeUTF("Va preluam comanda imediat!Va multumim!");
		}
		
		 catch (IOException e) {
			e.printStackTrace();
		}
		}
	}
}

