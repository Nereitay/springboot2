package es.kiwi.controller;

import es.kiwi.MyDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Rest模式
@RestController
@RequestMapping("books")
public class BookController {

    /*读取yaml数据中的单一数据*/
    @Value("${country}") //spEL表达式
    private String pais;

    @Value("${user.name1}")
    private String nombre;

    @Value("${hobbies[1]}")
    private String hobbies1;

    @Value("${users[0].name}")
    private String username;

    @Value("${server.port}")
    private String port;

    @Value("${tempDir}")
    private String tempDir;

    @Value("${tempDir1}")
    private String tempDir1;

    //读取yaml全部属性数据,封装全部数据到Environment对象
    @Autowired
    private Environment env;

    @Autowired
    private MyDataSource myDataSource;


    @GetMapping
    public String getById() {
        System.out.println("Springboot is running...");
        System.out.println("pais ==> " + pais);
        System.out.println("nombre ==> " + nombre);
        System.out.println("hobbies1 ==> " + hobbies1);
        System.out.println("username ==> " + username);
        System.out.println("port ==> " + port);
        System.out.println("tempDir ==> " + tempDir);
        System.out.println("tempDir1 ==> " + tempDir1);
        System.out.println("--------------------------");
        System.out.println(env.getProperty("server.port"));
        System.out.println(env.getProperty("user.name1"));
        System.out.println("--------------------------");
        System.out.println(myDataSource);

        return "springboot is running....";
    }
}
