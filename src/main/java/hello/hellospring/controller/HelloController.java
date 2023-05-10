package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello") // request hello가 들어올시 선언한 hello메소드 호출해준다.
    public String hello(Model model){ // model : mvc
        model.addAttribute("data", "hello!!");
        return "hello"; // resources/templates/hello.html을 스프링을 찾아서
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name",name); // model
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // View가 없이 그대로 데이터를 전달
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello; // @ResponseBody - 객체반환 : json으로 반환
    }

    static class Hello { // static class
        private String name;

        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name = name;
        }
    }
}
