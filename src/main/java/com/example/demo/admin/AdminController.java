package com.example.demo.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("api/admin/")
public class AdminController {
    @Autowired
    AdminRepository adminRepository;

    @GetMapping("{pseudo}/{pass}")
    public Admin Login(@PathVariable String pseudo, @PathVariable String pass){
        return adminRepository.findByLoginAndPassword(pseudo, pass);
    }
}
