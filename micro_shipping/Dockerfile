FROM eclipse-temurin:17-jdk-alpine

# criamos um diretorio e vamos utilizar ele como padrao para os outros comandos
WORKDIR /app

# copiamos o jar local para o container
COPY target/micro_shipping.jar micro_shipping.jar

#  Expõe a porta que o microservice vai usar
EXPOSE 8080

#  Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "micro_shipping.jar"]