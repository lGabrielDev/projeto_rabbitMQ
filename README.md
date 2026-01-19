<!-- title -->
<h1 align="center">
    <span>Projeto ViaCEP</span>
</h1>

<br>

<!-- badges -->
<div align="left">
    <img src="https://img.shields.io/badge/license-MIT-yellow" alt="badge icon"></img>
    <img src="https://img.shields.io/badge/version-1.0-green" alt="badge icon"></img>
    <img src="https://img.shields.io/badge/repo size-229 KB-orange" alt="badge icon"></img>
</div>

<br>

<!-- About -->
## <img src="https://cdn2.iconfinder.com/data/icons/flat-pack-1/64/Computer-512.png" alt="todo list image icon" width="40px" align="center"> Sobre o Projeto

Este projeto simula um fluxo de processamento de pedidos utilizando microserviços e RabbitMQ. O objetivo é demonstrar a comunicação assíncrona entre serviços via mensagens, seguindo o padrão de arquitetura de eventos.

<hr>
<br>


<!-- Diagrama microserviços -->
## <img src="./imgs/diagram_icon.png" alt="todo list image icon" width="40px" align="center"> Diagrama dos microserviços

![diagram image example](./imgs/diagram_microservices.png)	

<br>

Fluxo Resumido do Projeto:

1. Usuário cria um pedido via rota POST no Orders Service.

2. Orders envia o pedido para a fila de análise de pagamento.

3. Payment Service consome a mensagem da fila, processa o pagamento e envia o resultado para:

     1. Fila de notificação para pagamentos aprovados (para notificar o usuário)

     1. Fila de envio para pagamentos aprovados (se aprovado, para despachar o pedido)

4. Notification Service envia a notificação ao usuário sobre o status do pedido.

5. Shipping Service simula o envio do pedido.

<hr>
<br>

<!-- Technologies -->
## <img src="https://cdn4.iconfinder.com/data/icons/general-office/91/General_Office_48-256.png" alt="todo list image icon" width="40px" align="center"> Tecnologias
- Java 17
- Spring Boot 4.0.1
- Spring Web
- Spring Boot DevTools
- lombok
- OpenAPI (Swagger)
- Docker 27.0.3
- RabbitMQ

<hr>
<br>

## <img src="https://cdn1.iconfinder.com/data/icons/internet-45/64/http-link-internet-domain-1024.png" alt ="image icon" width="40px" align="center"> Endpoints


| Método Http | URI | Descrição | Status Code esperado |                  
| :---:       | :--- |  :---    | :---:                |
| POST   | `http://localhost:8080/orders`      |         Criação de pedidos via microserviço Orders        | 200 |



<hr>
<br>

## Documentação no Swagger

![swagger image example](src/main/resources/static/img/swagger_image.png)	

<br>

<hr>
<br>

<!-- Build and run -->
## <img src="https://cdn3.iconfinder.com/data/icons/start-up-4/44/rocket-256.png" alt="todo list image icon" width="40px" align="center"> Rodando a aplicação

### Requisitos
- [git](https://git-scm.com/downloads)
- [Docker](https://docs.docker.com/desktop/wsl/)

<br>

### Passo a passo

1. Clone esse repositório
    ```bash
    git clone https://github.com/lGabrielDev/projeto_viaCEP
    ```
<br>

2. Vá ao diretorio

    ```bash
    cd projeto_viaCEP
    ```

<br>

3. Atribua os valores nas variáveis de ambiente

    <img alt="environment variables image example" src="src/main/resources/static/img/env_image.png" width="350px">

<br>

4.  Rode os comandos de execução:

    ```bash
     mvn clean package -DskipTests;  # Compila o código Java e gera o arquivo .jar
     docker pull openjdk:17-ea-10-jdk;  # Baixa a imagem base do OpenJDK 17.
     docker compose up --build; # Constrói as imagens Docker e sobe os containers
    ```

<br>

5. Acesse o swagger: `http://localhost:8080/swagger.html`

<hr>
<br>

<!-- Credits -->
<h2>
    <img src="https://cdn4.iconfinder.com/data/icons/thank-you/256/Artboard_4_copy-512.png" alt="thumbs up icon image" width="40px" align="center">
    <span>Créditos</span>
</h2>

<p>As imagens usadas nesse projeto foram retiradas dos seguintes sites:</p>

- [viaCEP](https://viacep.com.br/)
- [shields.io](https://shields.io/)
- [iconfinder](https://www.iconfinder.com/)
- [storyset](https://storyset.com/)
- [vecteezy](https://www.vecteezy.com)



<span>Thanks!</span>

<hr>
<br>


<!-- License -->
## <img src="https://cdn4.iconfinder.com/data/icons/jetflat-2-multimedia-vol-3/60/0042_049_license_agreement_file_document_paper_page_sheet-512.png" alt="todo list image icon" width="40px" align="center"> Licença --> MIT

O projeto está sob a licença do [MIT](LICENSE).

<hr>
<br>

<!-- Author -->
## <img src="https://cdn1.iconfinder.com/data/icons/office-work-3/200/copywriting-512.png" alt="todo list image icon" width="40px" align="center"> Autor

<br>

<div align="center">
    <img src="src/main/resources/static/img/avatar_circular.png" alt="profile avatar" width="150px">
    <p> <a href="https://github.com/lGabrielDev">Gabriel Freitas</a> 😎 </p>
</div>