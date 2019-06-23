package com.bjmbjm.code401d56day12.firstSpringDemo.album;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class AlbumController {

    @Autowired
    AlbumRepository albumRepository;
    @Autowired
    SongRepository songRepository;

    @GetMapping("/albums")
    public String getAllAlbums(Model m) {
        Iterable<Album> albums = albumRepository.findAll();
        m.addAttribute("albums", albums );
        return "allAlbums";
    }

    @GetMapping("/albums/{albumName}")
    public String getAlbum(@PathVariable String albumName, Model m) {
        Album album  = albumRepository.findByTitle(albumName);
        List<Song>albumSongs = album.songs;
        m.addAttribute("album", album);
        m.addAttribute("albumSongs", albumSongs);
        return "singleAlbum";
    }

    @PostMapping("albums/addSong/{albumName}")
    public RedirectView addSongToAlbum(@PathVariable String albumName, String title, int length, int trackNumber) {
        Album album = albumRepository.findByTitle(albumName);
        songRepository.save(new Song(title, length, albumName, trackNumber, album));

        return new RedirectView("/albums/"+albumName);
    }

    @GetMapping("/albums/add")
    public String addAlbum() {
        return "addAlbum";
    }


    @PostMapping("/albums/add")
    public RedirectView addAlbumSubmit(String title, String artist, int songCount, int length, String imageUrl) {    //(@ModelAttribute Album album) {

        albumRepository.save(new Album(title, artist,songCount, length, imageUrl));

        return new RedirectView("/albums");
    }
}