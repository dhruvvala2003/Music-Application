package com.musicWebApp.musicfyApp.dao;

import com.musicWebApp.musicfyApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAuthenticationDao extends JpaRepository<User,Integer> {
}
