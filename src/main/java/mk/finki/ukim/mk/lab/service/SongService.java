package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Album;
import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.model.Song;

import java.util.List;
import java.util.Optional;

public interface SongService {
    List<Song> listSongs();
    Artist addArtistToSong(Artist artist, Song song);
    Optional<Song> findByTrackId(String trackId);
    void addSong(Song song);
    boolean editSong(Long id, String trackId, String title, String genre, Integer releaseYear, Album album);
    void deleteSong(Long id);
    Optional<Song> findById(Long id);
    public boolean trackIdExists(String trackId);
}
