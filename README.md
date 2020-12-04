# SpringBoot15: Subidas de imagenes

Cómo guardar imágenes en el disco duro y el nombre de esta en la base de datos con Spring. Luego recuperarlas a través de una vista con thymeleaf y bootstrap

- spring.datasource.url = jdbc:mysql://localhost:3306/usuario?serverTimezone=America/Lima
- spring.datasource.username = root
- spring.datasource.password = root
- spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
- spring.jpa.show-sql = true
- spring.jpa.hibernate.ddl-auto = update
- spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL8Dialect
- limitacion en la subida de ficheros
- spring.servlet.multipart.max-file-size = 10MB
- spring.servlet.multipart.max-request-size = 10MB


![](https://raw.githubusercontent.com/ctec105/SpringBoot15/master/image01.png)
![](https://raw.githubusercontent.com/ctec105/SpringBoot15/master/image02.png)
![](https://raw.githubusercontent.com/ctec105/SpringBoot15/master/image03.png)



# Herramientas:
- Spring Tool Suite 4
- Spring Boot 2.3.5
- Spring Web 
- Thymeleaf
- JPA-Hibernate
- DevTools

