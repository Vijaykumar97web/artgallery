package com.example.artgallery.repository;

import com.example.artgallery.model.*;
import java.util.ArrayList;
import java.util.List;

public interface ArtistRepository {
    ArrayList<Artist> getArtists();

    Artist getArtistById(int artistId);

    Artist addArtist(Artist artist);

    Artist updateArtist(int arttistId, Artist artist);

    void deleteArtist(int artistId);

    List<Art> getArtistArts(int artistId);

    List<Gallery> getArtistGallerys(int artistId);
}