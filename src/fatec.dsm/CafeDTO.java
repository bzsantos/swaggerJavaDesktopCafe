package fatec.dsm;

public class CafeDTO {
    
    private String nome;
    private String origem;
    private int intensidade; // Escala de 1 a 10, por exemplo

    // Construtor padrão
    public CafeDTO() {
    }

    // Construtor cheio para facilitar a criação dos objetos
    public CafeDTO(String nome, String origem, int intensidade) {
        this.nome = nome;
        this.origem = origem;
        this.intensidade = intensidade;
    }

    // Getters e Setters (Necessários para o Spring converter para JSON automaticamente)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public int getIntensidade() {
        return intensidade;
    }

    public void setIntensidade(int intensidade) {
        this.intensidade = intensidade;
    }
}