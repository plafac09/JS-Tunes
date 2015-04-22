/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import java.util.Date;

/**
 *
 * @author Steffie
 */
public class Track 
{
    private String title;
    private String artist;
    private String album;
    private Date pub_year;
    private int title_nr;
    private String genre;
    private int length; //in seconds

    public Track(String title, String artist, String album, Date pub_year, int title_nr, String genre, int length) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.pub_year = pub_year;
        this.title_nr = title_nr;
        this.genre = genre;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public Date getPub_year() {
        return pub_year;
    }

    public void setPub_year(Date pub_year) {
        this.pub_year = pub_year;
    }

    public int getTitle_nr() {
        return title_nr;
    }

    public void setTitle_nr(int title_nr) {
        this.title_nr = title_nr;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
    
    public String getTrackInfo()
    {
        return String.format("Album Artist: \n"
                + "Album: \n"
                + "Publishing Year: \n"
                + "Title Number: \n"
                + "Genre: \n"
                + "Title Length: \n"                
                , artist, album, pub_year, title_nr, genre, length);
    }   
    
}
