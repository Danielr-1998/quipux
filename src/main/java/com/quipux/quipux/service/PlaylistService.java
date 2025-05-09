package com.quipux.quipux.service;
import com.quipux.quipux.model.Playlist;

import java.util.List;
import java.util.Optional;

public interface PlaylistService {
    Playlist createPlaylist(Playlist playlist);
    List<Playlist> getAllPlaylists();
    Optional<Playlist> getPlaylistByName(String nombre);

    void deletePlaylistByName(String nombre);
}
