package com.quipux.quipux.controller;

import com.quipux.quipux.model.Playlist;
import com.quipux.quipux.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.NoSuchElementException;

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

    @GetMapping
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(service.getAllPlaylists());
    }

    @GetMapping("/{nombre}")
    public ResponseEntity<?> getByName(@PathVariable String nombre) {
        return service.getPlaylistByName(nombre)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());  // ❌ sin cuerpo
    }

    @DeleteMapping("/{nombre}")
    public ResponseEntity<?> deleteByName(@PathVariable String nombre) {
        try {
            service.deletePlaylistByName(nombre);
            return ResponseEntity.noContent().build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Lista no encontrada");
        }
    }
}
