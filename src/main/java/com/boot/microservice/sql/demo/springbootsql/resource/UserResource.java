package com.boot.microservice.sql.demo.springbootsql.resource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boot.microservice.sql.demo.springbootsql.model.User;
import com.boot.microservice.sql.demo.springbootsql.repository.UserRepository;

@RefreshScope
@RestController
@RequestMapping("/rest/users")
public class UserResource {
	
	@Autowired
	UserRepository userRepository;
	
	@Value("${msg}")
    private String msg;
	
	@RequestMapping(method=RequestMethod.GET,value="/hello")
	public String hello(){ 
		
		return msg;
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/all")
	public List<User> getAll(){ 
		List<User> user = new ArrayList<>();
		userRepository.findAll().forEach(user::add);
		return user;
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/user")
	@Consumes({MediaType.APPLICATION_XML})
	public User getUser(@RequestBody User user){ 
		System.out.println("welcome"+user.getId());
		return userRepository.findOne(user.getId());
	}
	
	/*@PostMapping(value="/load")
	public List<User> persist(@RequestBody User user){
		userRepository.save(user);
		List<User> userData = new ArrayList<>();
		userRepository.findAll().forEach(userData::add);
		
		return userData;
	}*/
	
	@RequestMapping(method=RequestMethod.POST,value="/save")
	public void save(@RequestBody User user){
		userRepository.save(user);
		
	}

}
