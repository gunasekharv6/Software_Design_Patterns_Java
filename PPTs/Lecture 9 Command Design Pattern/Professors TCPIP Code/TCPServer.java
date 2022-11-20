package org.dgp.command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class TCPServer {

	private final static int MaxMessages = 3;
    private final static int DefaultPort = 24601;

    private static void CreateServer() {
        CreateServer(DefaultPort);
    }

    /**
     * Create a socket server at passed port.
     *
     * @param port Port onto which server is socketed.
     */
    private static void CreateServer(int port) {
        try {
            Logging.lineSeparator(String.format("CREATING SERVER: localhost:%d", port));
            // Established server socket at port.
            ServerSocket serverSocket = new ServerSocket(port);

            int n = 0;		// dgp limit to three message exchanges
//            while (n++ < MaxMessages) {
            while (true) {
                // Listen for connection.
                Socket socket = serverSocket.accept();
                // Once client has connected, use socket stream to send a prompt message to client.
                PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
                // Prompt for client.
                printWriter.println("Enter a message for the server.");

                // Get input stream produced by client (to read sent message).
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String output = bufferedReader.readLine();

                // Output sent message from client.
                printWriter.println("#" + n + " '" + output + "'");
                
                // output closing remark
//                if (MaxMessages == n) {
//                	printWriter.println("That's All Folks!");
//                }

                // Close writer and socket.
                printWriter.close();
                socket.close();

                // Output message from client.
                Logging.log(String.format("[FROM Client] %s", output));

                // Loop back, awaiting a new client connection.
            }
        } catch (SocketTimeoutException exception) {
            // Output expected SocketTimeoutExceptions.
            Logging.log(exception);
        } catch (IOException exception) {
            // Output unexpected IOExceptions.
            Logging.log(exception, false);
        }
    }

    public static void acceptTCPConnection(int port) {
    	System.out.println("\n\t" + TCPServer.class.getName() + ".acceptTCPConnection()...");
        try {
			Logging.lineSeparator(String.format("CREATING SERVER: localhost:%d", port));
			// Established server socket at port.
			ServerSocket serverSocket = new ServerSocket(port);

			// Listen for connection.
			Socket socket = serverSocket.accept();
			// Once client has connected, use socket stream to send a prompt message to
			// client.
			PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
			// Prompt for client.
			printWriter.println("Enter a message for the server.");

			// Get input stream produced by client (to read sent message).
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String output = bufferedReader.readLine();

			// Output sent message from client.
			printWriter.println(" '" + output + "'");
//			printWriter.println("#" + n + " '" + output + "'");
			printWriter.println("That's All Folks!");

			// output closing remark
//                if (MaxMessages == n) {
//                	printWriter.println("That's All Folks!");
//                }

			// Close writer and socket.
			printWriter.close();
			socket.close();

			// Output message from client.
			Logging.log(String.format("[FROM Client] %s", output));
        } catch (SocketTimeoutException exception) {
            // Output expected SocketTimeoutExceptions.
            Logging.log(exception);
        } catch (IOException exception) {
            // Output unexpected IOExceptions.
            Logging.log(exception, false);
        }
    	System.out.println("\n\t" + TCPServer.class.getName() + ".acceptTCPConnection()... done!");    	
    }
    /**
     * Demonstrate the use of this class
     */
    public static void demo() {
    	System.out.println("\n\t" + TCPServer.class.getName() + ".demo()...");
    	
    	CreateServer();

//    	TCPServer obj = new TCPServer();
//    	obj.acceptTCPConnection(DefaultPort);
//    	TCPServer.acceptTCPConnection(DefaultPort); // exception bug
    	
    	System.out.println("\n\t" + TCPServer.class.getName() + ".demo()... done!");
    }
}
