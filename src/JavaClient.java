import org.apache.xmlrpc.XmlRpcClient;
import java.util.Vector;

public class JavaClient {
	public static void main(String[] args) {
		try {
			XmlRpcClient server = new XmlRpcClient("http://localhost:8080");
			Vector<Integer> params = new Vector<>();
			params.add(5);
			params.add(10);
			int result = (Integer) server.execute("sample.sum", params);
			System.out.println("The sum is: " + result);
		} catch (Exception e) {
			System.err.println("JavaClient: " + e);
		}
	}
}
