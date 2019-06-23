package com.bjmbjm.code401d56day12.firstSpringDemo.album;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

//Spring to database interaction is setup here
public interface AlbumRepository extends CrudRepository<Album, Long> {
    // match exactly (method name and parameter name) with the title property in the Album class
    public List<Album> findByTitle(String title);
}
