package com.example.demo.practiceproject.Controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.practiceproject.Models.Model2;
import com.example.demo.practiceproject.Repositories1.Repository2;

@RestController
@CrossOrigin("http://localhost:3000/")
@RequestMapping("/hostaa")
public class ControlerP {
	@Autowired
	Repository2 repo;
	
	@PostMapping("/postdataaa")
	public String mthd(@RequestBody Model2 d)
	{
	String user=d.getUsername();
	Model2 m=repo.findByUsername(user);
	if(m==null)
	{
	repo.save(d);
	return "added";
	}
	else
	{
	return "user alredy exist";
	}
	}
	@PostMapping("/login/{mname}/{pass}")
	public String login(@PathVariable String
	mname,@PathVariable String pass)
	{
	Model2 ll=repo.findByUsername(mname);
	if(ll == null)
	{
	return "invalid username";
	}
	else {

	if(ll.getPassword().equals(pass))
	{
	return "success";
	}
	else
	{
	return "invalidpassword";
	}

	}}

	@GetMapping("/getdata/")
	List<Model2> getdata(){
		return repo.findAll();
	}
	

}