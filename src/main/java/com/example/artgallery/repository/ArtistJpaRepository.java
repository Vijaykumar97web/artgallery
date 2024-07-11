package com.example.artgallery.repository;

import com.example.artgallery.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistJpaRepository extends JpaRepository<Artist, Integer> {

}