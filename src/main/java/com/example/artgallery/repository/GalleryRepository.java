package com.example.artgallery.repository;

import com.example.artgallery.model.Gallery;
import com.example.artgallery.model.Artist;

import java.util.ArrayList;
import java.util.List;

public interface GalleryRepository {
    ArrayList<Gallery> getGalleries();

    Gallery getGalleryById(int galleryId);

    Gallery addGallery(Gallery gallery);

    Gallery updateGallery(int galleryId, Gallery gallery);

    void deleteGallery(int galleryId);

    List<Artist> getGalleryArtists(int galleryId);
}