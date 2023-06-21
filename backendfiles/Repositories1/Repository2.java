package com.example.demo.practiceproject.Repositories1;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.practiceproject.Models.Model2;

public interface Repository2 extends JpaRepository<Model2,String>
{

	Model2 findByUsername(String user);

	


	


}
 