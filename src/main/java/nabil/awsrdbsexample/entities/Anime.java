package nabil.awsrdbsexample.entities;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

@Entity
public class Anime {
    public enum Genre { ACTION, COMEDY };

    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    private int rating;

    @ElementCollection
    @CollectionTable(name = "genres", joinColumns = @JoinColumn(name = "anime_id"))
    @Enumerated(EnumType.STRING)
    private Set<Genre> genres;

    public Anime() {
    }

    public Anime(Integer id, String title, int rating, EnumSet<Genre> genres) {
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.genres = genres;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Set<Genre> getGenres() {
        return genres;
    }

    public void setGenres(EnumSet<Genre> genres) {
        this.genres = genres;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Anime anime = (Anime) o;
        if(id == null) return false;
        return id.equals(anime.id) && rating == anime.rating && Objects.equals(title, anime.title);
    }

    @Override
    public int hashCode() {
        return Anime.class.hashCode();
    }

    @Override
    public String toString() {
        return "Anime{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                '}';
    }
}
