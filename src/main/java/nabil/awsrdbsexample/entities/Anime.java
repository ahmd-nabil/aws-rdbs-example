package nabil.awsrdbsexample.entities;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Anime {

    @Id
    @GeneratedValue
    private Integer id;
    private String title;
    private int rating;

    public Anime() {
    }

    public Anime(Integer id, String title, int rating) {
        this.id = id;
        this.title = title;
        this.rating = rating;
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
