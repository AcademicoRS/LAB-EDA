import java.util.ArrayList;


public class BinarySearch {


public static int rank( ArrayList<Song> data , String key ) {
 int lo = 0;
 int hi = data . size ();
 while ( lo < hi ) {
int mid = lo + ( hi - lo ) / 2;
if ( data.get(mid).getArtist().compareTo( key ) < 0) {
 lo = mid + 1;
 } else {
hi = mid ;
 }
 }
 return lo ;
 }
}
