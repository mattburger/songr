package com.bjmbjm.code401d56day12.firstSpringDemo.album;

import javax.persistence.*;

// Song model
    @Entity
    public class Song {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        long id;
        String title;
        String albumName;
        int length;
        int trackNumber;



        @ManyToOne
        Album album;



        public Song(){}

        public Song(String title, int length, String albumName ,int trackNumber, Album album) {
            this.title = title;
            this.length = length;
            this.albumName = albumName;
            this.trackNumber = trackNumber;
            this.album = album;
        }

        public long getId() {
            return this.id;
        }

        public String getTitle() {
            return this.title;
        }

        public String getAlbumName() {
        return this.albumName;
    }

        public int getLength() {
            return this.length;
        }

        public int getTrackNumber() {
            return this.trackNumber;
        }

        public Album getAlbum() {
            return this.album;
        }


}
