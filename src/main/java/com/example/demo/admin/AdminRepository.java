package com.example.demo.admin;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    public Admin findByLogin(String login);
    public Admin findByLoginAndPassword(String login, String password);
}
