# swaggerJavaDesktopCafe
Arquitetura Java Café Swagger

# Teste com api cep

> mkdir -p out
> javac -d out src/fatec.dsm.api/Main.java src/fatec.dsm.api/ApiClient.java
> java -cp out fatec.dsm.api.Main


# Testar API café

> mvn spring-boot:run

### Deve testar o caminho da api que está no controller

exemplo: 

> https://curly-space-guide-jj65w5qrj9737w-8080.app.github.dev/api/dados/cafes

### Está no codespace, se for local depois da porta 8080/

## Para testar um post direto sem ferramenta

curl -X POST http://localhost:8080/api/dados/cafes \
  -H "Content-Type: application/json" \
  -d '{"nome":"Catuaí","origem":"Brasil","intensidade":7}'


## Abrir swaggger

http://localhost:8080/swagger-ui/index.html.

<br>

> Adaptar para o codespace

> https://curly-space-guide-jj65w5qrj9737w-8080.app.github.dev/swagger-ui/index.html


<br>

### Verificando se o servidor está ativo

> curl -sS -o /dev/null -w 'HTTP %{http_code}\n' http://localhost:8080/api/dados; ss -ltnp 'sport = :8080'

### Parando o servidor

> ss -ltnp 'sport = :8080'