package com.FaysalBinHasan;


import java.net.*;


class server implements Runnable
{
	DatagramPacket pack;
	DatagramSocket sock;
	
	server()
	{
		new Thread(this).start();
	}
	
	public void run() 
	{
		while(true)
		{
			try
			{
				send();
			}catch(Exception e)
			{
				System.out.println(e);
			}
		}
			
	}
	
	public void send() throws Exception
	{
		
		byte data[]="This is a datagram packet".getBytes();
		pack=new DatagramPacket(data,data.length);
		InetAddress add=InetAddress.getByName("127.0.0.1");
		pack.setAddress(add);
		pack.setPort(8000);
		sock=new DatagramSocket();
		sock.send(pack);
		sock.close();
	}
}


public class DatagramServer
{
	public static void main(String args[])
	{
		new server();
	}
}

		 	
		
	
		
	