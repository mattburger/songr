package com.bjmbjm.code401d56day12.firstSpringDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Iterator;

@Controller
public class AlbumController {

    @Autowired
    AlbumRepository albumRepository;
    SongRepository songRepository;

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

    @GetMapping("/songs")
    public String getAllSongs(Model m) {
        Iterable<Song> songs = songRepository.findAll();
        m.addAttribute("songs", songs);
        return "allSongs";
    }
    @PostMapping("/albums/add")
    public RedirectView addAlbumSubmit(@ModelAttribute Album album) {

        albumRepository.save(album);

        return new RedirectView("/albums");
    }
}