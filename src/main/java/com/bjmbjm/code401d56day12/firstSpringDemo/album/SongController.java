package com.bjmbjm.code401d56day12.firstSpringDemo.album;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Iterator;
import java.util.List;

@Controller
public class SongController {

    @Autowired
    AlbumRepository albumRepository;
    @Autowired
    SongRepository songRepository;


    @GetMapping("/songs")
    public String getAllSongs(Model m) {
        Iterable<Song> songs = songRepository.findAll();
        m.addAttribute("songs", songs);
        return "allSongs";
    }
    @GetMapping("/songs/add")
    public String addSong(Model m) {
        m.addAttribute("songs", new Song());
        return "addSong";
    }

    @GetMapping("/songs/{id}")
    public String getSongsByAlbum(@PathVariable Iterable<Long> id, Model m) {
        Iterable<Song> songs  = songRepository.findAllById(id);
        m.addAttribute("songs", songs);
        return "allSongs";
    }

    @GetMapping("songs/{album}/add")
    public String addSongToAlbum(@PathVariable String album, Model m) {
        m.addAttribute("songs", new Song());
        return "addSongToAlbum";
    }

    @PostMapping("/songs/add")
    public RedirectView addSongSubmit(String title, int length, String albumName ,int trackNumber, Album album) {    //(@ModelAttribute Song song {

        songRepository.save(new Song(title, length, albumName, trackNumber, album));

        return new RedirectView("/songs");

    }

}