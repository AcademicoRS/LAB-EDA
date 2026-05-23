
import java.util.ArrayList;

import edu.princeton.cs.algs4.StdRandom;

public class DataGenerator {


    public static ArrayList <Song> generateDataBase(int n , long seed )
    {

       ArrayList<Song> sintetico = new ArrayList<>();
    StdRandom.setSeed(seed);
        String[] tamArtista = new String[n/50];
        int tamAr = tamArtista.length-1;
        String[] genero = {"Pop", "Rock", "Hip-Hop", "Electronic", "Hip-Hop"};
        
        for (int i = 0; i < n; i++) {
            
            int id = i+1;
            String title = "Song_" + id;
            String artist = "Artist_" + StdRandom.uniform(tamAr);
            String genre = genero[StdRandom.uniform(genero.length)];
            int year = StdRandom.uniform(1970, 2027); 
            long plays = StdRandom.uniform(0, 10000001); 

            sintetico.add(new Song(id, title, artist, genre, year, plays));
        }
          return sintetico;
        }


    }
