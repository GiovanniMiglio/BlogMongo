# Blog MongoDB con Spring Boot
Una piccola applicazione backend per gestire post, autori e commenti usando MongoDB.

## Tecnologie
- Java 25
- Spring Boot
- Spring Data MongoDB
- MongoDB
- JUnit e AssertJ

## Come funziona
Un post può contenere i dati dell’autore e i commenti come documenti annidati, in MongoDB questo permette di salvare in un unico documento i dati che appartengono al post. Il repository usa query derivate: Spring Data ricava la ricerca dal nome del metodo, può anche cercare nei campi annidati dell’autore e per ricerche più specifiche si usa la @Query
## Come avviarlo
- MongoDB acceso
- i test si lanciano con ./mvnw.cmd test
## Cosa ho imparato
1. La differenza tra  Spring Data JPA con MySQL e Spring Data con MongoDB.
2. Come modellare documenti MongoDB con dati annidati, come autore e commenti.
3. Come scrivere query derivate, anche sui campi annidati, e filtri con @Query.
4. Come testare i repository con JUnit e AssertJ.
5. I test dovrebbero usare un database separato da quello di sviluppo.
6. Spring Data interpreta i nomi dei metodi del repository: se fanno riferimento a proprietà inesistenti, può segnalare l’errore all’avvio dell’applicazione.