package mk.finki.ukim.mk.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.model.Album;
import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.model.Song;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Artist> artistList = new ArrayList<>();
    public static List<Song> songs = new ArrayList<>();
    public static List<Album> albumList = new ArrayList<>();

    @PostConstruct
    public void init() {
        artistList.add(new Artist(1L, "Ariana", "Grande", "Arian Grande Bio"));
        artistList.add(new Artist(2L, "Ed", "Sheeran", "Ed Sheeran Bio"));
        artistList.add(new Artist(3L, "Taylor", "Swift", "Taylor Swift Bio"));
        artistList.add(new Artist(4L, "Bruno", "Mars", "Bruno Mars Bio"));
        artistList.add(new Artist(5L, "Billie", "Eilish", "Billie Eilish Bio"));

        Song song1 = new Song("001", "7 rings", "Pop", 2019, new ArrayList<>());
        Song song2 = new Song("002", "Shape of You", "Pop", 2017, new ArrayList<>());
        Song song3 = new Song("003", "Blank Space", "Pop", 2014, new ArrayList<>());
        Song song4 = new Song("004", "Uptown Funk", "Funk", 2014, new ArrayList<>());
        Song song5 = new Song("005", "Bad Guy", "Pop", 2019, new ArrayList<>());

        songs.add(song1);
        songs.add(song2);
        songs.add(song3);
        songs.add(song4);
        songs.add(song5);

        Album album1 = new Album("Thank U, Next", "Pop", String.valueOf(2019));
        Album album2 = new Album("Divide", "Pop", String.valueOf(2017));
        Album album3 = new Album("1989", "Pop", String.valueOf(2014));
        Album album4 = new Album("24K Magic", "Funk", String.valueOf(2016));
        Album album5 = new Album("When We All Fall Asleep, Where Do We Go?", "Pop", String.valueOf(2019));

        albumList.add(album1);
        albumList.add(album2);
        albumList.add(album3);
        albumList.add(album4);
        albumList.add(album5);

        song1.setAlbum(album1); // "7 rings" -> "Thank U, Next"
        song2.setAlbum(album2); // "Shape of You" -> "Divide"
        song3.setAlbum(album3); // "Blank Space" -> "1989"
        song4.setAlbum(album4); // "Uptown Funk" -> "24K Magic"
        song5.setAlbum(album5); // "Bad Guy" -> "When We All Fall Asleep, Where Do We Go?"

        song1.addPerformer(artistList.get(0)); // Ariana
        song2.addPerformer(artistList.get(1)); // Ed
        song3.addPerformer(artistList.get(2)); // Taylor
        song4.addPerformer(artistList.get(3)); // Bruno
        song5.addPerformer(artistList.get(4)); // Billie
    }
}
