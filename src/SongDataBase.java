
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import edu.princeton.cs.algs4.StdOut;

public class SongDataBase {

   // hola ricadito! Te quiero mucho negritoo :3
   // kenji te amo!!!

   private ArrayList<Song> songs;

   public SongDataBase(ArrayList<Song> arreglodeCanciones) {

      this.songs = arreglodeCanciones;

   }



// SEPARO PARA NO CONFUNDIRME AAAAA

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

          Selection.sort(songs, Comparator.comparing(x->x.getPlays()));
           

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

      if (algoritmo.equals("mergeSort") ) 
      {

         if (atributo.equals("id")) 
         {

            Merge.sort(songs, Comparator.comparing(x->x.getId()));
         }

         else if (atributo.equals("year")){
            Merge.sort(songs, Comparator.comparing(x->x.getYear()));
         }

         else if (atributo.equals("artist"))
         {
            Merge.sort(songs, Comparator.comparing(x->x.getArtist()));
            
         }
         
         else if (atributo.equals("genre")) 
         {
            
            Merge.sort(songs, Comparator.comparing(x->x.getGenre()));
         }

         else if (atributo.equals("title")) 
         {
            Merge.sort(songs, Comparator.comparing(x->x.getTitle()));
         }
         else
         {

           Merge.sort(songs, Comparator.comparing(x->x.getPlays()));

         }
      }
       

      
       //------------------------------------------------------------------------------------------------ <--- para no confundirme 
      // ESTE ES EL IF DE QUICK SORT
         if (algoritmo.equals("quickSort") ) 
         {
   
            if (atributo.equals("id")) 
            {
   
               Quick.sort(songs, Comparator.comparing(x->x.getId()));
            }
   
            else if (atributo.equals("year")){
               Quick.sort(songs, Comparator.comparing(x->x.getYear()));
            }
   
            else if (atributo.equals("artist"))
            {
               Quick.sort(songs, Comparator.comparing(x->x.getArtist()));
               
            }
            
            else if (atributo.equals("genre")) 
            {
               
               Quick.sort(songs, Comparator.comparing(x->x.getGenre()));
            }
   
            else if (atributo.equals("title")) 
            {
               Quick.sort(songs, Comparator.comparing(x->x.getTitle()));
            }
            else
            {
   
            Quick.sort(songs, Comparator.comparing(x->x.getPlays()));
   
            }
         }


      //este es el caso de que no reonozca ningun sortttt
          
     else {

    if (atributo.equals("id")) {
       
        Collections.sort(songs, Comparator.comparingInt(Song::getId));
    }

    else if (atributo.equals("year")) {
        Collections.sort(songs, Comparator.comparingInt(Song::getYear));
    }

    else if (atributo.equals("artist")) {
        Collections.sort(songs, Comparator.comparing(Song::getArtist));
    }

    else if (atributo.equals("genre")) {
        Collections.sort(songs, Comparator.comparing(Song::getGenre));
    }

    else if (atributo.equals("title")) {
        Collections.sort(songs, Comparator.comparing(Song::getTitle));
    }
    
    else {
        
        Collections.sort(songs, Comparator.comparingLong(Song::getPlays));
    }
}
    

   }

   //soy muy prooo sixseven te amo mucho kenji <3`
     // sequential search  (para no olvidarmeeee)
     public ArrayList<Song> sequentialSearch(String artist)
    {

        ArrayList<Song> coincidencias = new ArrayList<Song>();

           int t= songs.size();
           for(int i=0; i<t; i++){
               if(songs.get(i).getArtist().equals(artist))
               {
                   coincidencias.add(songs.get(i));
               }
           }

        return coincidencias;
    }

     public ArrayList<Song> binarySearch(String artist) { 
      
      int lo = 0;
      int hi = songs.size();
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (songs.get(mid).getArtist().compareTo(artist) < 0) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        ArrayList<Song> coincidencias = new ArrayList<>();

        while (lo < songs.size() && songs.get(lo).getArtist().equals(artist)) {
            coincidencias.add(songs.get(lo));
            lo++; 
            if(!songs.get(lo).getArtist().equals(artist)) {
               lo++;
            }
        }

        return coincidencias; // cambiaremos esto mi amorcito
    }

   public static void main(String[] args) 
   {

     /*  DataSongBase c = new DataSongBase();


     c.songs.add(new Song(3, "Beat it", "michael jackson", "Pop", 1998, 10000));
      c.songs.add(new Song(10, "Bad", "michael jackson", "Pop", 2019, 2000));
      c.songs.add(new Song(1, "Maps", "maroon 5", "Pop", 2020, 1000));
      c.songs.add(new Song(9, "Mao", "Doja cat", "Electronic", 2025, 500));
       c.songs.add(new Song(20, "Los mal aventurados no lloran", "pXNDX", "Rock", 2000, 10));
       c.songs.add(new Song(19, "terceros", "pXNDX", "Rock", 2000, 200));

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
      StdOut.println("Busqueda CON SequentialSearch: ");

       ArrayList<Song> resultados = c.sequentialSearch("michael jackson");

       for (int i = 0; i < resultados.size(); i++) {
           StdOut.println("ID: " + resultados.get(i).getId() + ", TITULO: " + resultados.get(i).getTitle() + ", ARTISTa: " + resultados.get(i).getArtist() + ", : "
                 + resultados.get(i).getGenre() + ", year: " + resultados.get(i).getYear() + ", Plays: " + resultados.get(i).getPlays());
       }

     StdOut.println();
      StdOut.println();
      StdOut.println("---------------------------------------------");
      StdOut.println("ORDENAMIENTO POR QuickSort por Artista: ");

       c.ordenarPorAlgoritmo("mergeSort", "artist");

      for (int i = 0; i < tam; i++) 
         {
         Song s = c.songs.get(i);
         StdOut.println("ID: " + s.getId() + ", TITULO: " + s.getTitle() + ", ARTISTa: " + s.getArtist() + ", : "
               + s.getGenre() + ", year: " + s.getYear() + ", Plays: " + s.getPlays());
         }

        StdOut.println();
      StdOut.println();
      StdOut.println("---------------------------------------------");
      StdOut.println("ORDENAMIENTO POR CON BinarySearch: ");

       ArrayList<Song> s = c.binarySearch("PXNDX");

       for (int i = 0; i < s.size(); i++) {
           StdOut.println("ID: " + s.get(i).getId() + ", TITULO: " + s.get(i).getTitle() + ", ARTISTa: " + s.get(i).getArtist() + ", : "
                 + s.get(i).getGenre() + ", year: " + s.get(i).getYear() + ", Plays: " + s.get(i).getPlays());
      } 



   /*      StdOut.println();
      StdOut.println();
      StdOut.println("---------------------------------------------");
      StdOut.println("Generacion de datos sinteticos: ");
      ArrayList<Song> pa = DataGenerator.generateDataBase(1024, 6767);

      c.setSongs(pa);

      c.ordenarPorAlgoritmo("insertionSort", "artist");

         for (int i = 0; i < pa.size(); i++) {
            StdOut.println("ID: " + pa.get(i).getId() + ", TITULO: " + pa.get(i).getTitle() + ", ARTISTa: " + pa.get(i).getArtist() + ", : "
                  + pa.get(i).getGenre() + ", year: " + pa.get(i).getYear() + ", Plays: " + pa.get(i).getPlays());
         }

   }*/
}
}
