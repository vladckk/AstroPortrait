package parser;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {

	private static Socket clientSocket;
	private static Socket clientSocket2;
	private static ServerSocket server;
	private static ObjectInputStream inObj;
	private static ObjectOutputStream outObj;
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		server = new ServerSocket (4004);
		clientSocket = server.accept();
		clientSocket2 = new Socket("localhost", 4005);
		inObj = new ObjectInputStream(clientSocket.getInputStream());
		outObj = new ObjectOutputStream(clientSocket2.getOutputStream());
		String url;
		File json;
		while ((url = (String) inObj.readObject()) != null) {
			List<String> signsText = new ArrayList<>();
			signsText = Parsing.parsingResults(url);
			json = Parsing.toJSON(new Links(signsText.get(0), signsText.get(1), signsText.get(2)));
			outObj.writeObject(json);
		}
	}
	
}
