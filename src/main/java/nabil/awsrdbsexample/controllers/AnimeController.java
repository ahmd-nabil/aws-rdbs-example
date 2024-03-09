package nabil.awsrdbsexample.controllers;

import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nabil.awsrdbsexample.entities.Anime;
import nabil.awsrdbsexample.exceptions.AnimeNotFoundException;
import nabil.awsrdbsexample.repos.AnimeRepo;

@RestController
@RequestMapping("/anime")
public class AnimeController {
    private final AnimeRepo animeRepo;

    public AnimeController(AnimeRepo animeRepo) {
        this.animeRepo = animeRepo;
    }

    @GetMapping
    public ResponseEntity<Collection<Anime>> getAllAnime(@RequestParam(required = false) String title) {
        if(title != null) {
            return ResponseEntity.ok(this.animeRepo.findByTitle(title));
        }
        return ResponseEntity.ok(this.animeRepo.findAll());
    }

    @GetMapping("/{animeId}")
    public ResponseEntity<Anime> getAnime(@PathVariable Integer animeId) {
        return ResponseEntity.ok(animeRepo.findById(animeId).orElseThrow(AnimeNotFoundException::new));
    }

    @PostMapping
    public ResponseEntity<Void> addAnime(@RequestBody Anime anime) {
        this.animeRepo.save(anime);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{animeId}")
    public ResponseEntity<Void> updateAnime(@PathVariable Integer animeId, @RequestBody Anime anime) {
        anime.setId(animeId);
        this.animeRepo.save(anime);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{animeId}")
    public ResponseEntity<Void> deleteAnime(@PathVariable Integer animeId) {
        this.animeRepo.deleteById(animeId);
        return ResponseEntity.noContent().build();
    }
}
