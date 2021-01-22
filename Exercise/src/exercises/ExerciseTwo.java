package exercises;

import exercises.models.Album;
import exercises.models.Track;
import java.util.*;

public class ExerciseTwo {
    
    public static void main(String args[]) {
        List<Album> albums = Album.generateAlbums();
        
        //Convert the following code into a new implementation that uses lambda expressions and aggregate operations instead of nested for loops. 
        //Hint: Make a pipeline that invokes the filter, sorted, and collect operations, in that order.
        List<Album> favs = new ArrayList<>();
        for (Album a : albums) {
            boolean hasFavorite = false;
            for (Track t : a.tracks) {
                if (t.rating >= 4) {
                    hasFavorite = true;
                    break;
                }
            }
            if (hasFavorite) {
                favs.add(a);
            }
        }
        Collections.sort(favs, new Comparator<Album>() {
            public int compare(Album a1, Album a2) {
                return a1.name.compareTo(a2.name);
            }
        });
        
        //**Do not include this in exercise**
        for(Album f : favs){
            System.out.println(f.name);
        }
    }
}
