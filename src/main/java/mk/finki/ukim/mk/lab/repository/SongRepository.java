package mk.finki.ukim.mk.lab.repository;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Album;
import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.model.Song;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class SongRepository {

    public List<Song> findAll() {
        return DataHolder.songs;
    }

    public Optional<Song> findByTrackId(String trackId) {
        return DataHolder.songs.stream().filter(song -> song.getTrackId().equals(trackId)).findFirst();
    }

    public Artist addArtistToSong(Artist artist, Song song) {
        song.getPerformers().add(artist);
        return artist;
    }

    public void addSong(Song song) {
        DataHolder.songs.add(song);
    }

    public Optional<Song> findById(Long id) {
        return DataHolder.songs.stream()
                .filter(song -> song.getId().equals(id))
                .findFirst();
    }

    public boolean editSong(Song song, String trackId, String title, String genre, Integer releaseYear, Album album) {
        if (song == null) {
            return false;
        }

        if (trackId != null && !trackId.isEmpty()) song.setTrackId(trackId);
        if (title != null && !title.isEmpty()) song.setTitle(title);
        if (genre != null && !genre.isEmpty()) song.setGenre(genre);
        if (releaseYear != null && releaseYear > 0) song.setReleaseYear(releaseYear);
        if (album != null) song.setAlbum(album);

        return true;
    }

    public void deleteSong(Long id) {
        Optional<Song> songce = findById(id);
        songce.ifPresent(song -> DataHolder.songs.remove(song));
    }
}
