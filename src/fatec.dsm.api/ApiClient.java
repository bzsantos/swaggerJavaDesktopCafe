package fatec.dsm.api;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class ApiClient {
    
    public void chamarApi() {
        HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://viacep.com.br/ws/01001000/json/"))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        try {
            // O Java usa HttpResponse.BodyHandlers.ofString() para ler o corpo como texto
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            
            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Resposta: " + response.body());
        } catch (Exception e) {
            System.out.println("Erro ao chamar a API: ");
            e.printStackTrace();
        }
    }
}
    /*
    
    public void chamarApi() {
        HttpClient client = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .build();

        HttpRequest request = HttpRequest.newBuilder()
               // .uri(URI.create("http://localhost:8080/api/seu-endpoint")) 
                .uri(URI.create("https://viacep.com.br/ws/01001000/json/"))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Resposta: " + response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
*/