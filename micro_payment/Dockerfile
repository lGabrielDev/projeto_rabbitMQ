# container temporario apenas para criar o .jar
FROM maven:3.9.9-eclipse-temurin-17 AS container_temporario

WORKDIR /app

COPY  . .

RUN mvn clean package -Dmaven.test.skip
#Nesse ponto o container já vai possuir a pastinha /target e o arquivo  .jar


FROM eclipse-temurin:17-jdk-alpine

# criamos um diretorio e vamos utilizar ele como padrao para os outros comandos
WORKDIR /app

# copiamos o jar local para o container
COPY  --from=container_temporario  /app/target/micro_payment.jar micro_payment.jar

#  Expõe a porta que o microservice vai usar
EXPOSE 8080

#  Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "micro_payment.jar"]