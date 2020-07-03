package web;

import java.net.*;

class UDPsend {
	public static void main(String[] args) throws Exception {
		DatagramSocket ds = new DatagramSocket();
		String str = "Hello World";
		DatagramPacket dp = new DatagramPacket(str.getBytes(), str.length(), InetAddress.getByName("10.64.66.208"), 9000);
		ds.send(dp);
		ds.close();
	}
}