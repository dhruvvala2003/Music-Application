package com.musicWebApp.musicfyApp.controller;

import com.musicWebApp.musicfyApp.entity.User;
import com.musicWebApp.musicfyApp.service.UserAuthentication;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
public class MyController {

    @Autowired
    UserAuthentication uauth;

    @Value("${project.image}")
    String path;



    @GetMapping("/home")
    String sendMdg()
    {
        return "Hello Musify User";
    }

    @GetMapping("/logIn")
    List<User> getUser()
    {
        return this.uauth.getDetails();
    }

    @PostMapping("/signUp")
    void saveUser(@RequestBody User u)
    {
        this.uauth.savDetails(u);
    }


    @PostMapping("/uploadSong/{songName}")
    ResponseEntity<String> saveSong(@RequestParam("file") MultipartFile file, @PathVariable("songName")String sName) throws IOException {
        String fileName = file.getOriginalFilename();
        long fileSize = file.getSize();

        System.out.println("============================================================");
        System.out.println(fileName);
        System.out.println(fileSize);
        System.out.println("============================================================");

        uauth.saveFile(path,file,sName);


        return new ResponseEntity<>("uplode sucessfully",HttpStatus.OK);


    }

    @GetMapping(value = "/getImage/{imageName}" ,produces = "audio/mpeg")

    void getImage(@PathVariable("imageName") String imageName, HttpServletResponse res) throws IOException
    {
        InputStream resource=uauth.getResource(path,imageName);
        res.setContentType("audio/mpeg");
        StreamUtils.copy(resource,res.getOutputStream());

    }

    @GetMapping("/getAllSongs")
    ResponseEntity<List<String >>getAllSongs()
    {
        List<String> songList=uauth.getAllSong();
        return new ResponseEntity<>(songList,HttpStatus.OK);

    }
}
