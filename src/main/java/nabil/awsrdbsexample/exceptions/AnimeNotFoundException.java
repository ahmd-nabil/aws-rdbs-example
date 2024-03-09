package nabil.awsrdbsexample.exceptions;

public class AnimeNotFoundException extends RuntimeException {
    public AnimeNotFoundException() {
        super("Anime not found");
    }
}
