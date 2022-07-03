## EJEMPLO PARA UN PROYECTO LLAMADO "Project" Y UNA TABLA EN LA BASE DE DATOS LLAMADA "User"


### /src/main/[...]/controllers/
- **UserController.java**: recibe los HTTP request para modificar la base de datos
### /src/main/[...]/dao/
- **UserDao.java (interface)**: declara los métodos que se utilizan para modificar la base de datos
- **UserDaoImp.java**: implementa dichos métodos
### /src/main/[...]/models/
- **User.java**: define los nombres y tipo que tiene cada columna de la tabla User en la base de datos, getters y setters
### /src/main/[...]/
- **ProjectApplication.java**: incluye la función main() que inicia el servidor
### /src/main/resources/
- **application.properties**: propiedades de la aplicación (por ejemplo, datos para conectarse con la db)
### /src/main/resources/static/
- **img/**: carpeta con imágenes que pueden ser accedidas por el cliente
- **scripts/**: carpeta con scripts que pueden ser accedidos por el cliente
- **styles/**: carpeta con estilos css que pueden ser accedidos por el cliente
- **index.html**: archivo html que puede ser accedido por el cliente
- **favicon.ico**: ícono de la página
### /
- **pom.xml**: contiene las dependencias


#### UserController.java:
```java
package [...].controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import [...].dao.UserDao;
import [...].models.User;
import java.util.List;
@RestController
public class UserController implements UserDao{
    @Autowired
    private UserDao userDao;
    @RequestMapping(value = "users", method = RequestMethod.GET)
    public List<User> getUsers() {
        return userDao.getUsers();
    }
    @RequestMapping(value = "users/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Integer id) {
        userDao.deleteUser(id);
    }
    @RequestMapping(value = "users", method = RequestMethod.POST)
    public void addUser(@RequestBody User user) {
        userDao.addUser(user);
    }
}
```


#### UserDao.java:
```java
package [...].dao;
import [...].models.User;
import java.util.List;
public interface UserDao {
    List<User> getUsers();
    void deleteUser(Integer id);
    void addUser(User user);
}
```


#### UserDaoImp.java:
```java
package [...].dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import [...].models.User;
@Repository
@Transactional
public class UserDaoImp implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<User> getUsers() {
        String query = "from User";
        return entityManager.createQuery(query).getResultList();
    }
    @Override
    public void deleteUser(Integer id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }
    @Override
    public void addUser(User user) {
        entityManager.merge(user);
    }
}
```


#### User.java:
```java
package [...].models;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id",unique=true, nullable = false)
    private Integer id;
    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;
    @Column(name = "description")
    private String description;
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return this.id;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return this.username;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return this.email;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return this.description;
    }
}
```


#### application.properties:
```yml
spring.datasource.url=jdbc:postgresql://localhost:5432/leonel_db
spring.datasource.username=leonel
spring.datasource.password=19990829
```


#### pom.xml (principales dependencias):
```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-tomcat</artifactId>
        <scope>provided</scope>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <version>1.18.24</version>
        <scope>provided</scope>
    </dependency>
</dependencies>
```
