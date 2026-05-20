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

            Selection.sort(songs, Comparator.comparing(x->x.getId()));
         }

         else if (atributo.equals("year")){
            Selection.sort(songs, Comparator.comparing(x->x.getYear()));
         }

         else if (atributo.equals("artist"))
         {
            Selection.sort(songs, Comparator.comparing(x->x.getArtist()));
            
         }
         else if (atributo.equals("genre")) 
         {
            Selection.sort(songs, Comparator.comparing(x->x.getGenre()));
         }

         else if (atributo.equals("title")) 
         {
            Selection.sort(songs, Comparator.comparing(x->x.getTitle()));
         }
         else
         {
            Selection.sort(songs, Comparator.comparing(x->x.getPlays()));
            
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
      c.songs.add(new Song(2, "Bad", "Michael Jackson", "Electronic", 1997, 10));
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
   }
}
