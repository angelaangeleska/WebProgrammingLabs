package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Album;
import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.model.Song;
import mk.finki.ukim.mk.lab.repository.SongRepository;
import mk.finki.ukim.mk.lab.service.SongService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongServiceImpl implements SongService {

    private final SongRepository songRepository;

    public SongServiceImpl(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public List<Song> listSongs() {
        return songRepository.findAll();
    }

    @Override
    public Artist addArtistToSong(Artist artist, Song song) {
        return songRepository.addArtistToSong(artist, song);
    }

    @Override
    public Optional<Song> findByTrackId(String trackId) {
        return songRepository.findByTrackId(trackId);
    }

    @Override
    public void addSong(Song song) {
        songRepository.addSong(song);
    }

    @Override
    public boolean editSong(Long id, String trackId, String title, String genre, Integer releaseYear, Album album) {
        Song song = songRepository.findById(id).orElse(null);
        return songRepository.editSong(song, trackId, title, genre, releaseYear, album);
    }

    @Override
    public void deleteSong(Long id) {
        songRepository.deleteSong(id);
    }

    @Override
    public Optional<Song> findById(Long id) {
        return songRepository.findById(id);
    }

    @Override
    public boolean trackIdExists(String trackId) {
        return songRepository.findByTrackId(trackId).isPresent();    }
}