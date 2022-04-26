package annotations.controller;

import annotations.DBConfig;
import annotations.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

//@Controller
//@ResponseBody

@RestController
public class MyController {
    @Autowired
    private Student student;
    @Value("${my.greeting}")
    private String greeting;

    @Value("${my.list.values}")
    private List<String> list;
    @Value("#{${dbValues}}")
    private HashMap<String,String> connection;

    @Autowired
    private DBConfig dbConfig;

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public Student home( @RequestBody Student st){
        System.out.println(st.getName());
        System.out.println("THis is home controller");
        return this.student;
    }
    @RequestMapping(value = "/user/{userId}",method = RequestMethod.GET)
    public String user(@PathVariable("userId") Integer userId){
        return String.valueOf(userId);
    }
    @GetMapping("/greeting")
    public String greeting(){
        return "Message:"+greeting+" List "+list + "Connection key value :"+connection +" DB config:" +dbConfig.getConnectionString()+dbConfig.getUsername()+dbConfig.getPassword()+dbConfig.getPort();

    }
}
