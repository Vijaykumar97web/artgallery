package com.example.artgallery.controller;

import com.example.artgallery.model.*;
import com.example.artgallery.service.GalleryJpaService;
import com.example.artgallery.repository.GalleryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class GalleryController implements GalleryRepository {
    @Autowired
    private GalleryJpaService galleryJpaService;

    @GetMapping("/galleries")
    public ArrayList<Gallery> getGalleries() {
        return galleryJpaService.getGalleries();
    }

    @GetMapping("/galleries/{galleryId}")
    public Gallery getGalleryById(@PathVariable("galleryId") int galleryId) {
        return galleryJpaService.getGalleryById(galleryId);
    }

    @PostMapping("/galleries")
    public Gallery addGallery(@RequestBody Gallery gallery) {
        return galleryJpaService.addGallery(gallery);
    }

    @PutMapping("/galleries/{galleryId}")
    public Gallery updateGallery(@PathVariable("galleryId") int galleryId, @RequestBody Gallery gallery) {
        return galleryJpaService.updateGallery(galleryId, gallery);
    }

    @DeleteMapping("/galleries/{galleryId}")
    public void deleteGallery(@PathVariable("galleryId") int galleryId) {
        galleryJpaService.deleteGallery(galleryId);
    }

    @GetMapping("/galleries/{galleryId}/artists")
    public List<Artist> getGalleryArtists(@PathVariable("galleryId") int galleryId) {
        return galleryJpaService.getGalleryArtists(galleryId);
    }
}