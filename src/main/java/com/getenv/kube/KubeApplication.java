package com.getenv.kube;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class KubeApplication {

	public static void main(String[] args) {
		SpringApplication.run(KubeApplication.class, args);
		System.out.println("###########################Environment Vars###########################");
	    Map<String, String> envv  = System.getenv();
	    envv.entrySet().forEach(System.out::println);
	}
	
	   @GetMapping("/")
       public String rootpath() {
		   Map<String, String> enviorntmentVars  = System.getenv();
		   enviorntmentVars.entrySet().forEach(System.out::println);
		   return String.format("<h1>/ <br>/getone <br>/getall</h1>");
       }
	   
	   @GetMapping("/getall")
       public String getall() {
		   Map<String, String> envvar  = System.getenv();
		   envvar.entrySet().forEach(System.out::println);
	       return String.format("This env => %s", envvar);
       }
	   
	   @GetMapping("/getone")
       public String getone() {
	       String env  = System.getenv("PATH");
//	       System.out.println(System.getenv("JAVA_HOME"));
           return String.format("This env PATH => %s", env);
       }
	   
	   
}
