package com.bjmbjm.code401d56day12.firstSpringDemo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

    // Song model
    @Entity
    public class Song {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        long id;
        String title;
        String album;
        int length;
        int trackNumber;


        public Song(){}

        public Song(String title, int length, String album ,int trackNumber) {
            this.title = title;
            this.length = length;
            this.album = album;
            this.trackNumber = trackNumber;
        }

        public String getTitle() {
            return this.title;
        }

        public int getLength() {
            return this.length;
        }

        public String getAlbum() {
            return this.album;
        }
        public int getTrackNumber() {
            return this.trackNumber;
        }


}
