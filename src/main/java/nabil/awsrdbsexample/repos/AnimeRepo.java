package nabil.awsrdbsexample.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import nabil.awsrdbsexample.entities.Anime;

@Repository
public interface AnimeRepo extends JpaRepository<Anime, Integer> {

    @Query("select a from Anime a where a.title like %:title%")
    List<Anime> findByTitle(String title);
}
