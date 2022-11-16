package com.example.demo;

import com.example.demo.admin.Admin;
import com.example.demo.admin.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiNoteApplication implements CommandLineRunner {

	@Autowired
	AdminRepository adminRepository;
	public static void main(String[] args) {
		SpringApplication.run(ApiNoteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Admin admin = adminRepository.findByLogin("aminatamagassouba32@gmail.com");
		if (admin == null){
			Admin melou = new Admin();
			melou.setNom("Aminata Magassouba");
			melou.setLogin("aminatamagassouba32@gmail.com");
			melou.setPassword("azerty");
			adminRepository.save(melou);
		}

	}
}
