
package fatec.dsm;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.EventQueue;


@SpringBootApplication
public class Principal {

    public static void main(String[] args) {
        
// 1. Inicia o servidor da API em segundo plano
        new SpringApplicationBuilder(Principal.class)
                .headless(false) // Permite que o Spring conviva com interfaces gráficas
                .run(args);

        // 2. Abre a sua tela de forma assíncrona (Exemplo usando Swing)
        EventQueue.invokeLater(() -> {
            JFrame frame = new JFrame("Minha Aplicação Desktop com API");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 200);
            frame.add(new JLabel("A API está rodando na porta 8080!", JLabel.CENTER));
            frame.setVisible(true);
        });      
        
    }   
    
}  
    /*
    
    
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
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            
            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Resposta: " + response.body());
        } catch (Exception e) {
            System.out.println("Erro ao chamar a API: ");
            e.printStackTrace();
        }
    }
}

*/