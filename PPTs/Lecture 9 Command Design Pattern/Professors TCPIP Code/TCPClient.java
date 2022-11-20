package org.dgp.command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 * 
 * @author Airbrake Blog 
 * https://airbrake.io/blog/java-exception-handling/sockettimeoutexception#:~:text=As%20you%20may%20suspect%20based,the%20overall%20Java%20Exception%20Hierarchy.
 *
 */
public class TCPClient {
	private final static String DefaultHost = "localhost";
    private final static int DefaultPort = 24601;
    private final static int DefaultTimeout = 2000;
    private final static boolean DefaultShouldSleep = false;

    private String Message = "Hello World!";

    public TCPClient() {
        // Default connection.
        Connect();

        // Attempt to connect using 1 millisecond timeout.
        Connect(DefaultHost, DefaultPort, 1, DefaultShouldSleep);

        // Attempt to connect using 1 millisecond timeout, with artificial sleep to simulate connection delay.
        Connect(DefaultHost, DefaultPort, 1, true);
    }

    public TCPClient(String message) {
    	ConnectOnce(DefaultHost, DefaultPort, DefaultTimeout, DefaultShouldSleep);
    }
    
    private void Connect() {
        Connect(DefaultHost, DefaultPort, DefaultTimeout, DefaultShouldSleep);
    }

    private void Connect(String host) {
        Connect(host, DefaultPort, DefaultTimeout, DefaultShouldSleep);
    }

    private void Connect(int port) {
        Connect(DefaultHost, port, DefaultTimeout, DefaultShouldSleep);
    }

    private void Connect(boolean shouldSleep) {
        Connect(DefaultHost, DefaultPort, DefaultTimeout, shouldSleep);
    }

    /**
     * Connect to passed host and port as client.
     *
     * @param host Host to connect to.
     * @param port Port to connect to.
     * @param timeout Timeout (in milliseconds) to allow for socket connection.
     * @param shouldSleep Indicates if thread should be artificially slept.
     */
    private void Connect(String host, int port, int timeout, boolean shouldSleep) {
    	try {
    		Logging.lineSeparator(
    				String.format(
    						"CONNECTING TO %s:%d WITH %d MS TIMEOUT%s",
    						host,
    						port,
    						timeout,
    						shouldSleep ? " AND 500 MS SLEEP" : ""
    						),
    				80
    				);
    		
    		while (true) {
    			Socket socket = new Socket();
    			// Connect to socket by host, port, and with specified timeout.
    			socket.connect(new InetSocketAddress(InetAddress.getByName(host), port), timeout);
    			
    			// Read input stream from server and output said message.
    			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    			
    			// Check if artificial sleep should occur, to simulate connection delay.
    			if (shouldSleep) {
    				// Sleep for half a second.
    				Thread.sleep(500);
    			}
    			
    			PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
    			
    			Logging.log("[FROM Server] " + reader.readLine());
    			
    			// Await user input via System.in (standard input stream).
    			BufferedReader userInputBR = new BufferedReader(new InputStreamReader(System.in));
    			// Save input message.
    			Message = userInputBR.readLine();
    			
    			// Send message to server via output stream.
    			writer.println(Message);
    			
    			// If message is 'quit' or 'exit', intentionally disconnect.
    			if ("quit".equalsIgnoreCase(Message) || "exit".equalsIgnoreCase(Message)) {
    				Logging.lineSeparator("DISCONNECTING");
    				socket.close();
    				break;
    			}
    			
    			Logging.log("[TO Server] " + reader.readLine());
    		}
    	} catch (SocketTimeoutException exception) {
    		// Output expected SocketTimeoutExceptions.
    		Logging.log(exception);
    	} catch (InterruptedException | IOException exception) {
    		// Output unexpected InterruptedExceptions and IOExceptions.
    		Logging.log(exception, false);
    	}
    }
    
    /**
     * ConnectOnce to passed host and port as client.
     *
     * @param host Host to connect to.
     * @param port Port to connect to.
     * @param timeout Timeout (in milliseconds) to allow for socket connection.
     * @param shouldSleep Indicates if thread should be artificially slept.
     */
    private void ConnectOnce(String host, int port, int timeout, boolean shouldSleep) {
        try {
            Logging.lineSeparator(
                String.format(
                        "CONNECTING TO %s:%d WITH %d MS TIMEOUT%s",
                        host,
                        port,
                        timeout,
                        shouldSleep ? " AND 500 MS SLEEP" : ""
                ),
                80
            );

			Socket socket = new Socket();
			// Connect to socket by host, port, and with specified timeout.
			socket.connect(new InetSocketAddress(InetAddress.getByName(host), port), timeout);

			// Read input stream from server and output said message.
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

			// Check if artificial sleep should occur, to simulate connection delay.
			if (shouldSleep) {
				// Sleep for half a second.
				Thread.sleep(500);
			}

			PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

			Logging.log("[FROM Server] " + reader.readLine());

//			// Await user input via System.in (standard input stream).
//			BufferedReader userInputBR = new BufferedReader(new InputStreamReader(System.in));
//			// Save input message.
//			Message = userInputBR.readLine();

			// Send message to server via output stream.
			writer.println(Message);
//			Logging.log("[TO Server] " + reader.readLine()); // dgp

			// If message is 'quit' or 'exit', intentionally disconnect.
			if ("quit".equalsIgnoreCase(Message) || "exit".equalsIgnoreCase(Message)) {
				Logging.lineSeparator("DISCONNECTING");
				socket.close();
			} else {
				// dgp: this is a one shot only ALWAYS
				Logging.lineSeparator("DISCONNECTING");
				socket.close();
			}
			

			Logging.log("[TO Server] " + reader.readLine());
        } catch (SocketTimeoutException exception) {
            // Output expected SocketTimeoutExceptions.
            Logging.log(exception);
        } catch (InterruptedException | IOException exception) {
            // Output unexpected InterruptedExceptions and IOExceptions.
            Logging.log(exception, false);
        }
    }

    /**
     * Demonstrate the use of this class
     */
    public static void demo() {
    	System.out.println(TCPClient.class.getName() + ".demo()...");
    	
    	/**
    	 * Start the TCP Server FIRST
    	 */
    	Thread t1 = new Thread( () -> TCPServer.demo() );
    	t1.start();
    	
    	/**
    	 * Prompts for user input, typically:
    	 * 1. Hello
    	 * 2. quit
    	 * 
    	 * or
    	 * 1. Hi, again.
    	 * 2. quit
    	 */
    	new TCPClient();
//    	new TCPClient("Hello TCP Server, gota go now, Bye-EE!");	// connect once
    	
    	try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	
    	
    	System.out.println(TCPClient.class.getName() + ".demo()... done!");
    }
}
