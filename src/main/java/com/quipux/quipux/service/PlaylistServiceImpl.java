package com.quipux.quipux.service;

import com.quipux.quipux.model.Playlist;
import com.quipux.quipux.repository.PlaylistRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PlaylistServiceImpl implements PlaylistService {

    @Autowired
    private PlaylistRepository repository;

    @Override
    public Playlist createPlaylist(Playlist playlist) {
        if (playlist.getNombre() == null || playlist.getNombre().isEmpty()) {
            throw new IllegalArgumentException("Nombre inválido");
        }
        return repository.save(playlist);
    }


    @Override
    @Transactional
    public void deletePlaylistByName(String name) {
        if (!repository.existsByNombre(name)) {
            throw new NoSuchElementException("Lista no encontrada");
        }
        repository.deleteByNombre(name);
    }
    @Override
    public List<Playlist> getAllPlaylists() {
        return repository.findAll();
    }

    @Override
    public Optional<Playlist> getPlaylistByName(String nombre) {
        return repository.findByNombre(nombre);
    }
}
