package com.example.artgallery.service;


import com.example.artgallery.model.*;
import com.example.artgallery.repository.ArtistJpaRepository;
import com.example.artgallery.repository.ArtJpaRepository;
import com.example.artgallery.repository.ArtistRepository;
import com.example.artgallery.repository.GalleryJpaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service

public class ArtistJpaService implements ArtistRepository {
    @Autowired
    private ArtistJpaRepository artistJpaRepository;
    @Autowired
    private GalleryJpaRepository galleryJpaRepository;
    @Autowired
    private ArtJpaRepository artJpaRepository;

    @Override
    public ArrayList<Artist> getArtists() {
        List<Artist> artistLists = artistJpaRepository.findAll();
        ArrayList<Artist> artists = new ArrayList<>(artistLists);
        return artists;
    }

    @Override
    public Artist getArtistById(int artistId) {
        try {
            Artist artist = artistJpaRepository.findById(artistId).get();
            return artist;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Artist addArtist(Artist artist) {
        List<Integer> galleryIds = new ArrayList<>();
        for (Gallery gallery : artist.getGallerys()) {
            galleryIds.add(gallery.getGalleryId());
        }
        List<Gallery> galleries = galleryJpaRepository.findAllById(galleryIds);
        if (galleries.size() != galleryIds.size()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        artist.setGallerys(galleries);
        return artistJpaRepository.save(artist);
    }

    @Override
    public Artist updateArtist(int artistId, Artist artist) {
        try {
            Artist newArtist = artistJpaRepository.findById(artistId).get();
            if (artist.getArtistName() != null) {
                newArtist.setArtistName(artist.getArtistName());
            }
            if (artist.getGenre() != null) {
                newArtist.setGenre(artist.getGenre());
            }
            if (artist.getGallerys() != null) {
                List<Integer> galleryIds = new ArrayList<>();
                for (Gallery gallery : artist.getGallerys()) {
                    galleryIds.add(gallery.getGalleryId());
                }
                List<Gallery> galleries = galleryJpaRepository.findAllById(galleryIds);
                if (galleries.size() != galleryIds.size()) {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
                }
                newArtist.setGallerys(galleries);
            }
            return artistJpaRepository.save(newArtist);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteArtist(int artistId) {
        try {
            artistJpaRepository.deleteById(artistId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

    @Override
    public List<Art> getArtistArts(int artistId) {
        try {
            Artist artist = artistJpaRepository.findById(artistId).get();
            return artJpaRepository.findByArtist(artist);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public List<Gallery> getArtistGallerys(int artistId) {
        try {
            Artist artist = artistJpaRepository.findById(artistId).get();
            return artist.getGallerys();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}