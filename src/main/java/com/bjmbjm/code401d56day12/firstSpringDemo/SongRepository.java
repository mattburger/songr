package com.bjmbjm.code401d56day12.firstSpringDemo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SongRepository extends CrudRepository<Song, Long> {
    // match exactly (method name and parameter name) with the album property in the Song class
    public List<Song> findByTitle(String album);
}