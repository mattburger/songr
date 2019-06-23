package com.bjmbjm.code401d56day12.firstSpringDemo.album;

import org.springframework.data.repository.CrudRepository;


public interface SongRepository extends CrudRepository<Song, Long> {
}