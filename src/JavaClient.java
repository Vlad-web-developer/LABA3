import org.apache.xmlrpc.XmlRpcClient;
import java.util.Scanner;
import java.util.Vector;

public class JavaClient {
    public static void main(String[] args) {
        try {
            XmlRpcClient server = new XmlRpcClient("http://localhost:8080");
            
            // Отримання переліку послуг від сервера
            Vector<Vector<Object>> services = (Vector<Vector<Object>>) server.execute("sample.getServices", new Vector<>());
            System.out.println("Доступні послуги:");
            for (int i = 0; i < services.size(); i++) {
                System.out.println((i + 1) + ". " + services.get(i).get(0) + " - " + services.get(i).get(1) + " грн");
            }

            // Вибір послуги
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введіть номер послуги:");
            String serviceNumber = scanner.nextLine().trim(); 

            // Надсилання вибору на сервер
            Vector<String> params = new Vector<>();
            params.add(serviceNumber);
            String result = (String) server.execute("sample.chooseService", params);
            System.out.println(result);
        } catch (Exception e) {
            System.err.println("JavaClient: " + e);
        }
    }
}
