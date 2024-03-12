package com.musicWebApp.musicfyApp.dao;

import com.musicWebApp.musicfyApp.entity.Mp3Files;
import org.springframework.data.jpa.repository.JpaRepository;


public interface Mp3FilesDao extends JpaRepository<Mp3Files,Integer> {

}
