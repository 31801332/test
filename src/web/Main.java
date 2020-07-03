package web;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Collection;
import java.util.Iterator;


class Servicer implements Runnable {
	Socket s;

	public Servicer(Socket s) {
		this.s = s;
	}

	public void run() {
		try {
			InputStream ips = s.getInputStream();
			OutputStream ops = s.getOutputStream();

			BufferedReader br = new BufferedReader(new InputStreamReader(ips));
			DataOutputStream dos = new DataOutputStream(ops);
			while (true) {
				String strWord = br.readLine();
				System.out.println(strWord + ":" + strWord.length());
				if (strWord.equalsIgnoreCase("quit"))
					break;
				String strEcho = (new StringBuffer(strWord).reverse()).toString();
				//dos.writeBytes (strWord+"----->"+strEcho+"\r\n");
				dos.writeBytes(strWord + "----->" + strEcho + System.getProperty("line.separator"));
			}
			br.close();
			dos.close();
			s.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class Tcp_Server {
	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(8001);
			while (true) {
				Socket s = ss.accept();
				new Thread(new Servicer(s)).start();
			}
			//ss.close () ;
		} catch (Exception e) {
			e.printStackTrace();
		}

		Collection t = new Collection() {
			@Override
			public int size() {
				return 0;
			}

			@Override
			public boolean isEmpty() {
				return false;
			}

			@Override
			public boolean contains(Object o) {
				return false;
			}

			@Override
			public Iterator iterator() {
				return null;
			}

			@Override
			public Object[] toArray() {
				return new Object[0];
			}

			@Override
			public Object[] toArray(Object[] a) {
				return new Object[0];
			}

			@Override
			public boolean add(Object o) {
				return false;
			}

			@Override
			public boolean remove(Object o) {
				return false;
			}

			@Override
			public boolean containsAll(Collection c) {
				return false;
			}

			@Override
			public boolean addAll(Collection c) {
				return false;
			}

			@Override
			public boolean removeAll(Collection c) {
				return false;
			}

			@Override
			public boolean retainAll(Collection c) {
				return false;
			}

			@Override
			public void clear() {

			}
		}

		t.iterator();
	}
}