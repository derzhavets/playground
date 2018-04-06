package com.derzhavets.playground.headfirst.collections.jukeBoxApp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;


public class JukeBox {
	private ArrayList<Song> songList = new ArrayList<Song>();
	
	public static void main(String[] args) {
		new JukeBox().go();
	}
	
	public void go() {
		getSongs();
		System.out.println(" ---------- Simple sort with Collections.sort()  ---------- ");
		System.out.println(songList);
		Collections.sort(songList);
		System.out.println(songList);
		
		System.out.println(" ---------- Sort with Comparator ---------- ");
		Collections.sort(songList, new ArtistCompare());
		System.out.println(songList);
		
		System.out.println(" ---------- HashSet ---------- ");
		HashSet<Song> hashSet = new HashSet<Song>();
		hashSet.addAll(songList);
		System.out.println(hashSet);
		
		System.out.println(" ---------- Tree Set  ---------- ");
		TreeSet<Song> treeSet1 = new TreeSet<Song>();
		for (Song song : songList) {
			treeSet1.add(song);
		}
		System.out.println(treeSet1);
		
		System.out.println(" ---------- HashMap  ---------- ");
		HashMap<String, String> hashMap = new HashMap<String, String>();
		for (Song song : songList) {
			hashMap.put(song.getTitle(), song.getArtist());
		}
		System.out.println(hashMap);
	}
	
	private class ArtistCompare implements Comparator<Song> {
		@Override
		public int compare(Song o1, Song o2) {
			return o1.getArtist().compareTo(o2.getArtist());
		}
	}
	
	private void getSongs() {
		File file = new File("SongList.txt");
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null) {
				addSong(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void addSong(String line) {
		String[] output = line.split("/");
		Song song = new Song(output[0], output[1], output[2], output[3]);
		songList.add(song);
	}
}
