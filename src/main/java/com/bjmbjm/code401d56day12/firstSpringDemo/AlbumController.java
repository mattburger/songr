package com.bjmbjm.code401d56day12.firstSpringDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Iterator;

@Controller
public class AlbumController {

    @Autowired
    AlbumRepository albumRepository;

    @GetMapping("/albums")
    public String getAllAlbums(Model m) {
        Iterable<Album> albums = albumRepository.findAll();
        m.addAttribute("albums", albums );
        return "allAlbums";
    }

    @GetMapping("/albums/add")
    public String addAlbum(Model m) {
        m.addAttribute("albums", new Album());
        return "addAlbum";
    }
    @PostMapping("/albums/add")
    public String addAlbumSubmit(@ModelAttribute Album album) {
//        String sqlInsert = String.format("INSERT INTO albums (title, artist, song_count, length, image_url)" +
//                " VALUES (%s, %s, $d, %d, %s)", album.title, album.artist, album.songCount, album.length, album.imageUrl );
        albumRepository.save(album);

        return "allAlbums";
    }
}