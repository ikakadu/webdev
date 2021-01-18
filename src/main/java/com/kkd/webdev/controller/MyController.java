package com.kkd.webdev.controller;


import com.kkd.webdev.dto.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Controller
public class MyController {

    /**
     * 访问 http://127.0.0.1:8080/ff  即可访问resources/templates/first.html文件
     * 此时，不能用@RestController，只能用@Controller注解
     * @returnresources/templates
     */
    @RequestMapping("/ff")
    public String first(){
        return "/first";
    }

    /**
     * resources/static目录下的html文件可以直接访问
     * http://127.0.0.1:8080/index.html
     * @param person
     * @param response
     * @return
     */
    /*@RequestMapping("/index")
    public String index(){
        return "index";
    }*/

    @PostMapping(value = "/demo")
    @ResponseBody
    public String newStu(@RequestBody Person person, HttpServletResponse response) {
        System.out.println("newStu方法进入,"+person);
//        Person p = (Person)JSON.parse(userName);
        System.out.println(":::  "+person.toString());


//        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1:8080");

// 允许前端带认证cookie：启用此项后，上面的域名不能为'*'，必须指定具体的域名，否则浏览器会提示
        response.setHeader("Access-Control-Allow-Credentials", "true");

// 提示OPTIONS预检时，后端需要设置的两个常用自定义头
        response.setHeader("Access-Control-Allow-Headers", "Content-Type,X-Requested-With");

//        response.addHeader("Access-Control-Allow-Origin", "*");
//        response.addHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");

        return person.toString();
    }


}
