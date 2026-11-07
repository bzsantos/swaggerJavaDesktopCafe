package fatec.dsm;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/dados")
@Tag(name = "Dados do Desktop", description = "Endpoints para interagir com o app local")
public class AppController {

    // Criamos uma lista estática na memória para simular o banco de dados.
    // Assim, o que você cadastrar no POST vai persistir enquanto o app estiver aberto!
    private static final List<CafeDTO> listaCafes = new ArrayList<>();

    // Bloco estático para já iniciar a lista com alguns cafés de exemplo
    static {
        listaCafes.add(new CafeDTO("Espresso Blend", "Brasil (Minas Gerais)", 8));
        listaCafes.add(new CafeDTO("Bourbon Amarelo", "Brasil (Alta Mogiana)", 6));
    }

    @GetMapping
    @Operation(summary = "Busca o status atual da aplicação desktop")
    public String getStatus() {
        return "{\"status\": \"Rodando perfeitamente!\"}";
    }

    @GetMapping("/cafes")
    @Operation(summary = "Lista os cafés disponíveis e suas características")
    public List<CafeDTO> getCafes() {
        return listaCafes; // Retorna a lista da memória
    }

    @PostMapping("/cafes")
    @Operation(summary = "Cadastra um novo café na lista")
    public String salvarCafe(@RequestBody CafeDTO novoCafe) {
        // Adiciona o café enviado pelo usuário na nossa lista da memória
        listaCafes.add(novoCafe);
        
        // Retorna uma mensagem simples de sucesso em formato JSON
        return "{\"mensagem\": \"Café '" + novoCafe.getNome() + "' cadastrado com sucesso!\"}";
    }
}