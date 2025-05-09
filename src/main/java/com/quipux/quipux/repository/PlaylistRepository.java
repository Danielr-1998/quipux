package com.quipux.quipux.repository;

import com.quipux.quipux.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
    boolean existsByNombre(String nombre);
    Optional<Playlist> findByNombre(String nombre);

    void deleteByNombre(String name);

}
