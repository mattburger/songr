package com.bjmbjm.code401d56day12.firstSpringDemo;

import org.springframework.data.repository.CrudRepository;

//Spring to database interaction is setup here
public interface AlbumRepository extends CrudRepository<Album, Long> {
}
