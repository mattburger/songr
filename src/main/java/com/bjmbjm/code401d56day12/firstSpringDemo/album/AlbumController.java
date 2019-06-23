package com.bjmbjm.code401d56day12.firstSpringDemo.album;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

    @PostMapping("/albums/add")
    public RedirectView addAlbumSubmit(String title, String artist, int songCount, int length, String imageUrl) {    //(@ModelAttribute Album album) {

        albumRepository.save(new Album(title, artist,songCount, length, imageUrl));

        return new RedirectView("/albums");
    }

    @PostMapping("/songs/add")
    public RedirectView addSongSubmit(String title, int length, String albumName ,int trackNumber, Album album) {    //(@ModelAttribute Song song {

        songRepository.save(new Song(title, length, albumName, trackNumber, album));

        return new RedirectView("/songs");

    }

    @PostMapping("songs/{albumName}/add")
    public RedirectView addSongToAlbumSubmit (String title, int length, @PathVariable String albumName, int trackNumber) {
        List<Album> songsInAlbum = albumRepository.findByTitle(albumName);
        if(songsInAlbum.size() > 0) {
            Song song = new Song(title, length, albumName, trackNumber, songsInAlbum.get(0) );
            songRepository.save(song);
            return new RedirectView("/songs/" + albumName);

        } else {
            Song song = new Song(title, length, albumName, trackNumber, songsInAlbum.get(0));
            songRepository.save(song);
            return  new RedirectView("/songs/" + albumName);

        }
    }
}