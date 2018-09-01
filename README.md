# ARC

## Ambiente de Desenvolvimento

São pré-requisitos deste projeto:

* **Maven 3**
* **Java 8**
* **[Lombok](https://projectlombok.org/)** Habilitado na sua IDE

### Dados técnicos

- SpringBoot 2
- H2 Database
- Swagger2

### Lista de serviços da api

Execute a api localmente e acesse o seguinte link:
`http://localhost:8080/arc/swagger-ui.html`

### Setup inicial
```
git clone https://github.com/alencarrh/AcademiaABC-Dev3.git
cd AcademiaABC-Dev3/back
```

```
mvn compile
```

#### Executar Testes
```
mvn test
```

#### Build executando Testes
```
mvn install
```

#### Build sem executar Testes
```
mvn install -DskipTests
```

#### Executar
```
mvn spring-boot:run
```