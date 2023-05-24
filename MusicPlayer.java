import java.util.ArrayList;
import java.util.List;

class Song {
    private String title;
    private String artist;
    private int duration;

    public Song(String title, String artist, int duration) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public int getDuration() {
        return duration;
    }

    public void play() {
        System.out.println("Playing: " + title + " - " + artist);
    }
}

class MusicPlayer {
    private List<Song> playlist;
    private int currentSongIndex;

    public MusicPlayer() {
        playlist = new ArrayList<>();
        currentSongIndex = 0;
    }

    public void addSong(Song song) {
        playlist.add(song);
    }

    public void removeSong(Song song) {
        playlist.remove(song);
    }

    public void displayPlaylist() {
        System.out.println("Playlist:");
        for (int i = 0; i < playlist.size(); i++) {
            System.out.println((i + 1) + ". " + playlist.get(i).getTitle() + " - " + playlist.get(i).getArtist());
        }
        System.out.println();
    }

    public void play() {
        if (playlist.isEmpty()) {
            System.out.println("Playlist is empty.");
        } else {
            Song currentSong = playlist.get(currentSongIndex);
            currentSong.play();
        }
    }

    public void next() {
        if (playlist.isEmpty()) {
            System.out.println("Playlist is empty.");
        } else {
            currentSongIndex = (currentSongIndex + 1) % playlist.size();
            play();
        }
    }

    public void previous() {
        if (playlist.isEmpty()) {
            System.out.println("Playlist is empty.");
        } else {
            currentSongIndex = (currentSongIndex - 1 + playlist.size()) % playlist.size();
            play();
        }
    }
}

public class MusicPlayerDemo {
    public static void main(String[] args) {
        MusicPlayer musicPlayer = new MusicPlayer();

        Song song1 = new Song("Song 1", "Artist 1", 240);
        musicPlayer.addSong(song1);

        Song song2 = new Song("Song 2", "Artist 2", 180);
        musicPlayer.addSong(song2);

        Song song3 = new Song("Song 3", "Artist 3", 320);
        musicPlayer.addSong(song3);

        musicPlayer.displayPlaylist();

        musicPlayer.play();

        musicPlayer.next();

        musicPlayer.previous();
    }
}
