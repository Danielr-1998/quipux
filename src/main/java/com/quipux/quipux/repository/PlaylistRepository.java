package com.quipux.quipux.repository;

import com.quipux.quipux.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
    boolean existsByNombre(String nombre);
}
