import java.util.ArrayList;
import java.util.Comparator;

public class Merge {

    // This class should not be instantiated.
    private Merge() { }

    // stably merge a[lo .. mid] with a[mid+1 ..hi] using aux[lo .. hi]
    private static void merge(ArrayList<Song> a, ArrayList<Song> aux, int lo, int mid, int hi, Comparator<Song> comparator) {

        // copy to aux[]
        for (int k = lo; k <= hi; k++) {
            aux.set(k, a.get(k));
        }

        // merge back to a[]
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)                                           a.set(k, aux.get(j++));
            else if (j > hi)                                            a.set(k, aux.get(i++));
            else if (less(aux.get(j), aux.get(i), comparator))          a.set(k, aux.get(j++));
            else                                                        a.set(k, aux.get(i++));
        }
    }

    // mergesort a[lo..hi] using auxiliary array aux[lo..hi]
    private static void sort(ArrayList<Song> a, ArrayList<Song> aux, int lo, int hi, Comparator<Song> comparator) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid, comparator);
        sort(a, aux, mid + 1, hi, comparator);
        merge(a, aux, lo, mid, hi, comparator);
    }


    public static void sort(ArrayList<Song> songs, Comparator<Song> comparator) {
	    //"IndexOutOfBounds"  <--- Oye Rick, man por alguna razon me da este error y VsCode me decia que lo pusiera como nota ya que Java no puede leerlo.
        ArrayList<Song> aux = new ArrayList<>(songs);

        sort(songs, aux, 0, songs.size() - 1, comparator);
    }


    /***************************************************************************
    * Helper sorting functions.
    ***************************************************************************/


  // is v < w ?
  private static boolean less(Song v, Song w, Comparator<Song> comparator) {
      return comparator.compare(v, w) < 0;}
}



// ESTE MERGE ES EL PRIMER PROTOTYPE, ASI QUE CUALQUIER MODIFICACION, SUMALE 1 A ESTE CONTADOR DE EDICIONES          EDICIONES : 2