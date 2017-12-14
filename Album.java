package com.company;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
   private Songlist songs;

    public Album(String name) {
        this.name = name;
        this.songs = new Songlist();
    }

    public void addSongs(String name, double duration) {
        this.songs.add(name, duration);
    }

    public void addToPlaylist(String name, LinkedList<Song> playlist) {
        Song song = songs.findSong(name);
        if (song != null) {
            playlist.add(song);
            System.out.println(song.toString() + "added");
        }else System.out.println(name + " song does not exists");
    }

    public void addToPlaylist(int tracker, LinkedList<Song> playlist) {
        Song song = songs.findSong(tracker);
        if (song != null) {
            playlist.add(song);
            System.out.println(song.toString() + " added.");
        } else System.out.println("No song exists with this tracker!!");
    }

    private class Songlist {
        private ArrayList<Song> songs;

        public Songlist() {
            this.songs = new ArrayList<Song>();
        }

        public void add(String name, double duration) {
            this.songs.add(new Song(name, duration));
        }

        private Song findSong(String name) {
            for (int i = 0; i < songs.size(); i++) {
                if (name.equals(songs.get(i).getName())) {
                    return songs.get(i);
                }
            }
            return null;
        }

        private Song findSong(int tracker) {
            if (tracker > 0 && tracker <= songs.size())
            return songs.get(tracker-1);
            else
                return null;
        }
    }
}


