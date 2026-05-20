package src;
import java.util.ArrayList;



public class SongDataBase extends Song{

    private ArrayList<Song> songs;

    public SongDataBase(String tittle, String artist, String genre, int id, int year, long plays, ArrayList<Song> songs) {
        super(tittle, artist, genre, id, year, plays);
        this.songs = songs;
    }


    public static void main(String[] args) 
    {

        SongDataBase songDataBase = new SongDataBase("Tittle", "Artist", "Genre", 1, 2020, 1000, new ArrayList<Song>());
        
    }
 
    
}