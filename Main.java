package com.company;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    static boolean quit = false;
    static Scanner s = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<Album> albums = new ArrayList<Album>();
        Album album = new Album("mohit");
        album.addSongs("a", 4.56);
        album.addSongs("b", 3.76);
        album.addSongs("c", 3.83);
        album.addSongs("d", 4.12);
        album.addSongs("e", 5.96);
        album.addSongs("f", 6.42);
        albums.add(album);
        album = new Album("Mayank");
        album.addSongs("g", 3.78);
        album.addSongs("h", 5.78);
        album.addSongs("i", 4.48);
        album.addSongs("j", 3.35);
        albums.add(album);

        LinkedList<Song> playlist = new LinkedList<Song>();
        albums.get(0).addToPlaylist(1, playlist);
        albums.get(1).addToPlaylist(2, playlist);
        albums.get(0).addToPlaylist(2, playlist);
        albums.get(1).addToPlaylist(1, playlist);
        albums.get(0).addToPlaylist("e", playlist);
        albums.get(0).addToPlaylist("j", playlist);
        ListIterator<Song> listIterator = playlist.listIterator();
        int tracker;
        int atrac;
        printmenu();
        boolean forward = true;

    while(!quit){
        System.out.println("Enter your choice: ");
        int choice = s.nextInt();
        s.nextLine();
        switch (choice){
            case 1: printmenu();
                break;
            case 2: if(listIterator.hasNext() && forward) {
                System.out.println("Playing song " + listIterator.next().toString());
            }else if (!forward) {
                listIterator.next();
                System.out.println("Playing song " + listIterator.next().toString());
                forward = true;
            }
            else System.out.println("Reached at the end of the playlist");
                break;
            case 3: if(listIterator.hasPrevious() && !forward) {
                System.out.println("Playing song " + listIterator.previous().toString());
            }else if (forward) {
                listIterator.previous();
                forward = false;
                System.out.println("Playing song " + listIterator.previous().toString());
            }
            else
                System.out.println("At the beginning of the playlist");
                break;
            case 4:if(forward) {
                if(listIterator.hasPrevious()) {
                    System.out.println("Replaying song " + listIterator.previous().toString());
                    forward = false;
                }
                else System.out.println("At the beginning of the playlist");
            }
            else if(!forward) {
                if(listIterator.hasNext()) {
                    System.out.println("Replaying song" + listIterator.next().toString());
                forward = true;
                }
                else System.out.println("Reached at the end of the playlist");
            }
                break;

            case 5:list(playlist);
                break;
            case 6: if (playlist.size()>0) {
                listIterator.remove();
                System.out.println("Current song removed!!");
                if (listIterator.hasNext()) {
                    System.out.println("Playing" + listIterator.next().toString());
                }else if (listIterator.hasPrevious()) {
                    System.out.println("Playing" + listIterator.previous().toString());
                }
            }else System.out.println("No song to remove");
            break;
            case 7: quit = true;
            break;
            default:
                System.out.println("Enter number in the range [1-6]");
        }
    }
    }
    private static void printmenu() {
        System.out.println("Press: 1 for printing menu again \n" +
                "\t2 to play next song \n" +
                "\t3 to play previous song \n" +
                "\t4 to replay the current song \n" +
                "\t5 to list the songs in the playlist \n" +
                "\t6 to remove the current song\n" +
                "\t7 to quit");
    }
    private static void list(LinkedList<Song> playlist) {
        for (int i = 0; i < playlist.size(); i++) {
            System.out.println(playlist.get(i));
        }
    }
}