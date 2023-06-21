package com.example.demo.practiceproject.Repositorys1;

	import org.springframework.data.jpa.repository.JpaRepository;

	import com.example.demo.practiceproject.Models1.Model2;

	public interface Repository2  extends JpaRepository<Model2,Integer>{
		Model2 findByRoomno(int user);	}