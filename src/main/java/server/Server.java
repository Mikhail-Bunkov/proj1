package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	DBHandler DBHandler;
	private ServerSocket server;
	private Socket socket;
	private DataInputStream in;
	private DataOutputStream out;
	private final int PORT = 8189;
	private final String IP_ADDRESS = "localhost";
	//private List<ClientHandler> clients;
	private AuthServise authServise;


	public Server() {
		if (!DBHandler.connect()) {
			throw new RuntimeException("Не удалось подключиться к БД");
		}
		authServise = new DBAuthServise();

		try {
			server = new ServerSocket(PORT);
			System.out.println("Server started");

			while (true) {
				socket = server.accept();
				System.out.println("Client connected");
				System.out.println("client: " + socket.getRemoteSocketAddress());
				//new ClientHandler(this, socket);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			DBHandler.disconnect();
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				server.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public void connect(){

	}
}
