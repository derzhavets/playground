package collections;

public class Song implements Comparable<Song> {
	private String title;
	private String artist;
	private String rating;
	private String bpm;
	
	public Song(String title, String artist, String rating, String bpm) {
		super();
		this.title = title;
		this.artist = artist;
		this.rating = rating;
		this.bpm = bpm;
	}
	
	public String getTitle() {
		return title;
	}
	public String getArtist() {
		return artist;
	}
	public String getRating() {
		return rating;
	}
	public String getBpm() {
		return bpm;
	}
	
	@Override
	public boolean equals(Object o) {
		Song s = (Song) o;
		return title.equals(s.getTitle());
	}
	
	@Override
	public int hashCode() {
		return title.hashCode();
	}

	@Override
	public int compareTo(Song o) {
		return title.compareTo(o.getTitle());
	}
	
	@Override
	public String toString() {
		return title + "-" + artist;
	}
}
