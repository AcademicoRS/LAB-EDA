import java.util.ArrayList;
import java.util.Comparator;

public class Insertion {

    private Insertion() { }

    public static void sort(ArrayList<Song> songs, Comparator<Song> comparator) {
        int n = songs.size();
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && less(comparator, songs.get(j), songs.get(j-1)); j--) {
                exch(songs, j, j-1);
            }
            assert isSorted(songs, comparator, 0, i);
        }
        assert isSorted(songs, comparator);
    }

    /***************************************************************************
     * Helper sorting functions.
     ***************************************************************************/

    // ¿is v < w?
    private static boolean less(Comparator<Song> comparator, Song v, Song w) {
        return comparator.compare(v, w) < 0;
    }

    private static void exch(ArrayList<Song> songs, int i, int j) {
        Song swap = songs.get(i);
        songs.set(i, songs.get(j));
        songs.set(j, swap);
    }

    /***************************************************************************
     * Check if array is sorted - useful for debugging.
     ***************************************************************************/

    // is the array sorted?
    private static boolean isSorted(ArrayList<Song> songs, Comparator<Song> comparator) {
        return isSorted(songs, comparator, 0, songs.size());
    }

    private static boolean isSorted(ArrayList<Song> songs, Comparator<Song> comparator, int lo, int hi) {
        for (int i = lo + 1; i < hi; i++)
            if (less(comparator, songs.get(i), songs.get(i-1))) return false;
        return true;
    }
}


// Este fue el prototype asi demosle una vuelta mas cuando podamos.