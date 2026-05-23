import java.util.ArrayList;
import java.util.Comparator;

public class Quick {

    // This class should not be instantiated.
    private Quick() { }


    public static void sort(ArrayList<Song> songs, Comparator<Song> comparator) {
        sort(songs, 0, songs.size() - 1, comparator);   // <--- Antes de esta linea había un Shuffle Rick, pero investigando un poco me di cuenta que no funciona con Arreglos Dinamicos (arraylist) mi solución bruta fue borrarlo... 
    }

    // quicksort the subarray from a[lo] to a[hi]
    private static void sort(ArrayList<Song> a, int lo, int hi, Comparator<Song> comparator) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi, comparator);
        sort(a, lo, j - 1, comparator);
        sort(a, j + 1, hi, comparator);
    }

    // partition the subarray a[lo..hi] so that a[lo..j-1] <= a[j] <= a[j+1..hi] and return the index j.
    private static int partition(ArrayList<Song> a, int lo, int hi, Comparator<Song> comparator) {
        int i = lo;
        int j = hi + 1;
        Song v = a.get(lo); 
        
        while (true) {
            // find item on lo to swap
            while (less(a.get(++i), v, comparator)) {
                if (i == hi) break;
            }

            // find item on lo to swap
            while (less(v, a.get(--j), comparator)) {
                if (j == lo) break;     
            }

            // check if pointers cross
            if (i >= j) break;

            exch(a, i, j);
        }

        // put partitioning item v at a[j]
        exch(a, lo, j);

        // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return j;
    }

   /***************************************************************************
    * Helper sorting functions.
    ***************************************************************************/

    // is v < w ?
    private static boolean less(Song v, Song w, Comparator<Song> comparator) {
        if (v == w) return false; 
        return comparator.compare(v, w) < 0;
    }

    // exchange a[i] and a[j]
    private static void exch(ArrayList<Song> a, int i, int j) {
        Song swap = a.get(i);
        a.set(i, a.get(j));
        a.set(j, swap);
    }
}