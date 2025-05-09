package com.quipux.quipux.service;

import com.quipux.quipux.model.Playlist;
import com.quipux.quipux.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
