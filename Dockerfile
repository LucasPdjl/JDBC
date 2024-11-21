FROM openjdk:17

WORKDIR /app

COPY . .

RUN mkdir -p bin && javac -d bin $(find . -name "*.java")

CMD ["java", "-cp", "bin", "Main"]
