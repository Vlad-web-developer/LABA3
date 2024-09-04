import org.apache.xmlrpc.WebServer;

public class JavaWebService {
	public int sum(int x, int y) {
		return x * y;
	}	

	public static void main(String[] args) {
		try {
			System.out.println("Starting the XML-RPC Web Service...");
			WebServer server = new WebServer(8080);
			server.addHandler("sample", new JavaWebService());
			server.start();
			System.out.println("Service started successfully.");
		} catch (Exception e) {
			System.err.println("Java Web Service: " + e);
		}
	}
}
