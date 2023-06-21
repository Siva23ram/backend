package com.example.demo.practiceproject.Controllers1;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.web.bind.annotation.CrossOrigin;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

	import com.example.demo.practiceproject.Models.Model2;
	import com.example.demo.practiceproject.Repositorys1.Repository2;

	@RestController
	@CrossOrigin("http://localhost:3000/")
	@RequestMapping("/hostaa")
	public class Controller2 {
		@Autowired
		Repository2 repo;
		
		@PostMapping("/postdataaa")
		public String mthd(@RequestBody Model2 d)
		{
		int user=d.getRoomno();
		Model2 m=repo.findByRoomno(user);
		if(m==null)
		{
		repo.save(d);
		return "Booked";
		}
		else
		{
		return "please select other number";
		}
		}
	@PutMapping("/edit/{roomno}")
		public String editdata(@PathVariable int roomno,@RequestBody Model2 da)
		{
		Model2 mn=repo.findById(roomno).get();
		if(mn!=null) {

		mn.setRoomno(da.getRoomno());
		mn.setFullname(da.getFullname());
		mn.setPhonenumber(da.getPhonenumber());
		mn.setAge(da.getAge());
		mn.setGender(da.getGender());
		mn.setRoomtype(da.getRoomtype());
		repo.save(mn);
		return "Updated";
		}
		else {

		return "no update";

		}
		}
		@DeleteMapping("/delete/{roomno}")
		public String deletedata(@PathVariable int roomno)
		{
		repo.deleteById(roomno);

		return "Deleted";
		}

		@GetMapping("/getdata")
		List<Model2> getdata(){
		return repo.findAll();
		}}