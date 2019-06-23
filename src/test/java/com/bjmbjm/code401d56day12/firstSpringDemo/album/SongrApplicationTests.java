package com.bjmbjm.code401d56day12.firstSpringDemo.album;

import com.bjmbjm.code401d56day12.firstSpringDemo.FirstSpringDemoApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SongrApplicationTests {


    @Autowired
    AlbumController albumController;

    @Autowired
    SongController songController;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testControllerIsAutowired() {
        assertNotNull(albumController);
    }
    @Test
    public void testControllerIsAutowired2() {
        assertNotNull(songController);
    }
    @Test
    public void testRequestToAlbums() throws Exception {
        mockMvc.perform(get("/albums")).andExpect(status().isOk());
    }

    @Test
    public void testRequestToSongs() throws Exception {
        mockMvc.perform(get("/songs")).andExpect(status().isOk());

    }

    @Test
    public void testRequestToSingleAlbum() throws Exception {
        mockMvc.perform(get("/albums/{albumName}","test", "The Wall")).andExpect(status().isOk());
    }

    @Test
    public void testRequestToAddAlbum() throws Exception {
        mockMvc.perform(get("/albums/add")).andExpect(status().isOk());
    }
    
}