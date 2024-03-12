package com.musicWebApp.musicfyApp.service;



import com.musicWebApp.musicfyApp.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface UserAuthentication {

    // fro login sign up details..
    public List<User> getDetails();
    public void savDetails(User u);

    public void saveFile(String path, MultipartFile mpf,String sName) throws IOException;
    InputStream getResource(String path,String fileName) throws FileNotFoundException;

    List<String>getAllSong();

}
