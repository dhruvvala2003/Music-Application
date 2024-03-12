package com.musicWebApp.musicfyApp.service;

import com.musicWebApp.musicfyApp.dao.Mp3FilesDao;
import com.musicWebApp.musicfyApp.dao.UserAuthenticationDao;
import com.musicWebApp.musicfyApp.entity.Mp3Files;
import com.musicWebApp.musicfyApp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserAuthenticationImpl implements UserAuthentication {

    @Autowired
    UserAuthenticationDao uado;

    @Autowired
    Mp3FilesDao mp3FilesDao;

    @Override
    public List<User> getDetails() {
        return this.uado.findAll();
    }

    @Override
    public void savDetails(User u) {
        this.uado.save(u);
    }

    //save file in db
    @Override
    public void saveFile(String path,MultipartFile mp,String sName) throws IOException {

        Mp3Files mf=new Mp3Files();

        mf.setName(sName);//mp.getOriginalFilename()
    mf.setPathh("http://localhost:8080/getImage/"+sName);//mp.getOriginalFilename()
        String fullPath=path+ File.separator+sName;//mp.getOriginalFilename()

        //create folder
        File f=new File(path);

        if(!f.exists())
        {
            f.mkdir();
        }

        //file copy
        Files.copy(mp.getInputStream(), Paths.get(fullPath));


        mp3FilesDao.save(mf);



    }

    @Override
    public InputStream getResource(String path, String fileName) throws FileNotFoundException {
        String fullPath=path+File.separator+fileName;
        InputStream i=new FileInputStream(fullPath);

        return i;

    }

    @Override
    public List<String> getAllSong() {

        List<Mp3Files >objSongList=mp3FilesDao.findAll();

       List<String >songList= objSongList.stream().map((o)->o.getPathh()).collect(Collectors.toList());
        System.out.println(songList);

        return songList;
    }
}
