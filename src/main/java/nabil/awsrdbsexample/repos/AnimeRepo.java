package nabil.awsrdbsexample.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nabil.awsrdbsexample.entities.Anime;

@Repository
public interface AnimeRepo extends JpaRepository<Anime, Integer> {
    Optional<Anime> findByTitle(String title);
}
