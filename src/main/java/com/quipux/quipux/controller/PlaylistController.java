
package com.quipux.quipux.controller;

import com.quipux.quipux.model.Playlist;
import com.quipux.quipux.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/lists")
public class PlaylistController {

    @Autowired
    private PlaylistService service;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Playlist playlist) {
        try {
            Playlist saved = service.createPlaylist(playlist);
            URI location = URI.create("/lists/" + saved.getNombre());
            return ResponseEntity.created(location).body(saved);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Nombre inválido");
        }
    }
}
