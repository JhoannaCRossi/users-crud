# users-crud-springboot-project

## Uso
Aplicación simple de gestión de usuarios, se puede registrar nuevos usuarios, eliminar usuarios, listado de usuarios, con inicio de sesión.

## Tecnologías utilizadas
Este proyecto utiliza las siguientes tecnologías:

- Java
- Spring Boot
- Hibernate
- JWT
- API REST
- Docker
- MySQL
- Lombook
- Argon2

## IDE usado
- IntelliJ IDEA
- DataGrip

## API firmas
He ejecutado la app en el puerto 8080
->
### localhost:8080/api/users METHOD GET 
    - listado de los usuarios registrados en base de datos.
### localhost:8080/api/users/{id} METHOD DELETE 
    - elimina un usuario a partir de su identificador.
### localhost:8080/api/users METHOD POST 
    - grabara un usuario.


# Instalación y configuración
Para utilizar esta aplicación, sigue estos pasos:

1. Clona el repositorio en tu máquina local.
2. Configura una instancia de MySQL y asegúrate de que esté ejecutándose en el puerto 3306.
3. Abre una terminal en la carpeta del proyecto y ejecuta el siguiente comando para construir la imagen de Docker:

```console
foo@bar:~$ docker build -t user-management .
```

4.Ejecuta el siguiente comando para iniciar el contenedor de Docker:

```console
foo@bar:~$ docker run -p 8080:8080 -t user-management`
```

5. Accede a la aplicación en tu navegador en la siguiente dirección: http://localhost:8080/.

# Contribución
Si deseas contribuir a este proyecto, sigue estos pasos:

* Haz un fork del repositorio.
* Crea una rama para tus cambios (git checkout -b feature/MyFeature).
* Haz tus cambios y haz commit de tus cambios (git commit -am 'Agregué una nueva funcionalidad').
* Haz push a la rama (git push origin feature/MyFeature).
* Crea un Pull Request.
