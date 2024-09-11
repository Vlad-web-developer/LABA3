import org.apache.xmlrpc.WebServer;
import java.util.Vector;

public class JavaWebService {
    // Метод для отримання списку послуг
    public Vector<Vector<Object>> getServices() {
        Vector<Vector<Object>> services = new Vector<>();
        
        Vector<Object> service1 = new Vector<>();
        service1.add("Послуга 1");
        service1.add(100);
        services.add(service1);
        
        Vector<Object> service2 = new Vector<>();
        service2.add("Послуга 2");
        service2.add(200);
        services.add(service2);
        
        Vector<Object> service3 = new Vector<>();
        service3.add("Послуга 3");
        service3.add(300);
        services.add(service3);
        
        return services;
    }

// Метод для вибору клієнта
public String chooseService(String serviceName) {
    serviceName = serviceName.trim(); // Очищення рядка від зайвих пробілів
    System.out.println("Клієнт обрав: " + "Послугу " + serviceName);
    
    switch (serviceName) {
        case "1":
        case "Послуга 1":
            return "Ви обрали: Послуга 1. Вартість: 100 грн";
        case "2":
        case "Послуга 2":
            return "Ви обрали: Послуга 2. Вартість: 200 грн";
        case "3":
        case "Послуга 3":
            return "Ви обрали: Послуга 3. Вартість: 300 грн";
        default:
            return "Невірна послуга";
    }
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

