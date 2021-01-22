/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author jasretan
 */
public class Album {
    public String name;
    public List<Track> tracks;

    Album(String name, List<Track> tracks) {
        this.name = name;
        this.tracks = tracks;
    }

    public static List<Album> generateAlbums() {
        List<Track> trackList1 = 
                new ArrayList<>(Arrays.asList(
                        new Track("Always in My Head",2),
                        new Track("Magic",5),
                        new Track("Ink",4),
                        new Track("True Love",3)));

        List<Track> trackList2 = 
                new ArrayList<>(Arrays.asList(
                        new Track("Things Left Unsaid",3),
                        new Track("It's What We Do",1)));

        List<Track> trackList3 = 
                new ArrayList<>(Arrays.asList(
                        new Track("Rock or Bust",5),
                        new Track("Play Ball",3),
                        new Track("Rock the Blues Away",2)));

        Album album1 = new Album("Ghost Stories",trackList1);
        Album album2 = new Album("The Endless River",trackList2);
        Album album3 = new Album("Rock or Bust",trackList3);

        return new ArrayList<>(Arrays.asList(album1, album2, album3));
    }
}
