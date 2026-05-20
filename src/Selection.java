
import java.util.Comparator;
import java.util.ArrayList;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;



public class Selection 
{

    // This class should not be instantiated.
    private Selection() { }


    public static void sort(ArrayList<Song> songs, Comparator<Song> comparator) {
        int n = songs.size();
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i+1; j < n; j++) {
                if (less(comparator, songs.get(j), songs.get(min))) min = j;
            }
            exch(songs, i, min);
            assert isSorted(songs, comparator, 0, i);
        }
        assert isSorted(songs, comparator);
    }


   /***************************************************************************
    *  Helper sorting functions.
    ***************************************************************************/

    // is v < w ?
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    // is v < w ?
    private static boolean less(Comparator comparator, Song v, Song w) {
        return comparator.compare(v, w) < 0;
    }


    // exchange a[i] and a[j]
    private static void exch(ArrayList<Song> a, int i, int j) {
        Song swap = a.get(i);
        a.set(i, a.get(j));
        a.set(j, swap);
    }


   /***************************************************************************
    *  Check if array is sorted - useful for debugging. <-- Ricky... imagino que aqui vamos comprobando que el sorting funciona no?!
    ***************************************************************************/

    // is the array a[] sorted?
     private static boolean isSorted(Comparable<Song> a) 
    {
        return isSorted(a, 0, a.size() - 1);
    }

    // is the array sorted from a[lo] to a[hi]
    private static boolean isSorted(Comparable<Song> a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a.get(i), a.get(i-1))) return false;
        return true;
    }

    // is the array a[] sorted?
    private static boolean isSorted(ArrayList<Song> a, Comparator comparator) {
        return isSorted(a, comparator, 0, a.size() - 1);
    }

    // is the array sorted from a[lo] to a[hi]
    private static boolean isSorted(ArrayList<Song> a, Comparator comparator, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(comparator, a.get(i), a.get(i-1))) return false;
        return true;
    }



    // print array to standard output
    private static void show(ArrayList<Song> a) {
        for (int i = 0; i < a.size(); i++) {
            StdOut.println(a.get(i));
        }
    }

    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        Selection.sort(a);
        show(a);
    }
}