import java.util.ArrayList;
import java.util.Comparator;
import edu.princeton.cs.algs4.StdOut;

public class DataSongBase {

   // hola ricadito! Te quiero mucho negro de mierda :3
   // kenji te amo!!!
   private ArrayList<Song> songs;

   public DataSongBase() {

      this.songs = new ArrayList<>();

   }

   public void ordenarPorAlgoritmo(String algoritmo, String atributo) 
   {

   

      if (algoritmo.equals("insertionSort") ) 
      {

         if (atributo.equals("id")) 
         {

            Insertion.sort(songs, Comparator.comparing(x->x.getId()));
         }

         else if (atributo.equals("year")){
            Insertion.sort(songs, Comparator.comparing(x->x.getYear()));
         }

         else if (atributo.equals("artist"))
         {
            Insertion.sort(songs, Comparator.comparing(x->x.getArtist()));
         }
         else if (atributo.equals("genre")) 
         {
            //Comparator<Song> comparator = (s1, s2) -> s1.getGenre().compareTo(s2.getGenre());
            // Comparator<Song> comparator = (s1, s2) -> s1.getGenre().compareTo(s2.getGenre());
            //Insertion.sort(songs, comparator);
            Insertion.sort(songs, Comparator.comparing(x->x.getGenre()));
         }

         else if (atributo.equals("title")) 
         {
            Insertion.sort(songs, Comparator.comparing(x->x.getTitle()));
         }
         else
         {
           Insertion.sort(songs, Comparator.comparing(x->x.getPlays()));
         }
      }

      //------------------------------------------------------------------------------------------------ <--- para no confundirme 
      // ESTE ES EL IF DE SELECRION SORT


       if (algoritmo.equals("selectionSort") ) 
      {

         if (atributo.equals("id")) 
         {

            Comparator<Song> comparator = (s1, s2) -> s1.getId() - s2.getId();
            Selection.sort(songs, comparator);
         }

         else if (atributo.equals("year")){
            Comparator<Song> comparator = (s1, s2) -> s1.getYear() - s2.getYear();
            Selection.sort(songs, comparator);
         }

         else if (atributo.equals("artist"))
         {
            Comparator<Song> comparator = (s1, s2) -> s1.getArtist().compareTo(s2.getArtist());
            Selection.sort(songs, comparator);
         }
         else if (atributo.equals("genre")) 
         {
            Comparator<Song> comparator = (s1, s2) -> s1.getGenre().compareTo(s2.getGenre());
            Selection.sort(songs, comparator);
         }

         else if (atributo.equals("title")) 
         {
            Comparator<Song> comparator = (s1, s2) -> s1.getTitle().compareTo(s2.getTitle());
            Selection.sort(songs, comparator);
         }
         else
         {
            Comparator<Song> comparator = (s1, s2) -> (s1.getPlays() < s2.getPlays()) ? -1 : ((s1.getPlays() == s2.getPlays()) ? 0 : 1);
            Selection.sort(songs, comparator);
         }
      }


       //------------------------------------------------------------------------------------------------ <--- para no confundirme 
      // ESTE ES EL IF DE MERGE SORT


      
       //------------------------------------------------------------------------------------------------ <--- para no confundirme 
      // ESTE ES EL IF DE QUICK SORT

   }






   public static void main(String[] args) 
   {

      DataSongBase c = new DataSongBase();

      c.songs.add(new Song(3, "Beat it", "michael jackson", "Pop", 2019, 2000));
      c.songs.add(new Song(1, "Maps", "maroon 5", "Pop", 2020, 1000));
      c.songs.add(new Song(9, "Mao", "Doja cat", "Electronic", 2025, 500));

      int tam = c.songs.size();

      for (int i = 0; i < tam; i++) 
      {
         Song s = c.songs.get(i);
         StdOut.println("ID: " + s.getId() + ", Title: " + s.getTitle() + ", Artist: " + s.getArtist() + ", Genre: "
               + s.getGenre() + ", Year: " + s.getYear() + ", Plays: " + s.getPlays());
      }

      StdOut.println();
      StdOut.println();
      StdOut.println("---------------------------------------------");
      StdOut.println("ORDENAMIENTO POR CON INSERTION SORT por ID: ");

      c.ordenarPorAlgoritmo("insertionSort", "year");

      for (int i = 0; i < tam; i++) 
         {
         Song s = c.songs.get(i);
         StdOut.println("ID: " + s.getId() + ", Title: " + s.getTitle() + ", Artist: " + s.getArtist() + ", Genre: "
               + s.getGenre() + ", Year: " + s.getYear() + ", Plays: " + s.getPlays());
         }

      StdOut.println();
      StdOut.println();
      StdOut.println("---------------------------------------------");
      StdOut.println("ORDENAMIENTO POR CON BinarySearch: ");
      
      
     c.rank(c, "maroon 5");
      
    
   }
}
