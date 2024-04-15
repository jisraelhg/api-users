# Introduction
El proyecto contiene un API para la alta y consulta de usuarios

# Build and Deploy
La aplicación se construye a traves de maven por lo que se debe se situar en el directorio de aplicación.
Ejecutar el comando:

<code>$ ./mvnw install</code>

Una vez construido el jar de la aplicación se puede arrancar con el siguiente comando

<code>$ java -jar target/users-0.0.1-SNAPSHOT.jar</code>

Cuando la aplicación se encuentra ejecutandose es posible acceder a la documentación del API en swagger a traves de la liga:

<code>http://localhost:8080/swagger-ui/index.html </code>

Para Ingresar a la consola de la BD H2 se puede usar la liga

<code>http://localhost:8080/h2-console </code>

<strong>JDBC URL:</strong>jdbc:h2:mem:users-db

<strong>User Name:</strong>sa

<strong>Password:</strong>

## Scripts de creacion de BD

La base de datos se construye de forma automática tomando el script de creacion en el directorio `/src/main/java/resources/schema.sql`

## Payload de creación de usuarios

```json
{
  "name": "Israel",
  "email": "myemail3@emnail.com",
  "password": "H@rdPassword2",
  "phones": [
    {
      "number": "57894",
      "citycode": "1",
      "countrycode": "57"
    }
  ]
}
```
## Diagramas de solución

![create_users](https://github.com/jisraelhg/api-users/blob/main/src/main/resources/Usuarios_ds_01CrearUsuario.png?raw=true)

![get_users](https://github.com/jisraelhg/api-users/blob/main/src/main/resources/Usuarios_ds_02ConsultarUsuarios.png?raw=true)

