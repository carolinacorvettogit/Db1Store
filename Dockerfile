# Usar a imagem base do OpenJDK 11
FROM openjdk:11

# Instalar o Maven
RUN apt-get update && \
    apt-get install -y maven

# Definir o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copiar o arquivo pom.xml e o código-fonte para o diretório de trabalho
COPY pom.xml .
COPY src ./src

# Executar o comando "mvn package" para construir o projeto
RUN mvn package

# Definir o comando de inicialização do projeto]
CMD ["java", "-jar", "target/maven-wrapper.jar"]