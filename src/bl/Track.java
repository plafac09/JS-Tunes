/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Steffie
 */
public class Track extends File
{

    //Main Attributes
    private String title;
    private String artist;
    private String album;
    private Date pub_year;
    private int title_nr;
    private String genre;
    private String path;
    private int length; //in seconds
    
    private SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");


    public Track(String pathname)
    {
        super(pathname);
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getArtist()
    {
        return artist;
    }

    public void setArtist(String artist)
    {
        this.artist = artist;
    }

    public String getAlbum()
    {
        return album;
    }

    public void setAlbum(String album)
    {
        this.album = album;
    }

    public Date getPub_year()
    {
        return pub_year;
    }

    public void setPub_year(String year) throws ParseException
    {
        this.pub_year = sdf.parse(year);
    }

    public int getTitle_nr()
    {
        return title_nr;
    }

    public void setTitle_nr(int title_nr)
    {
        this.title_nr = title_nr;
    }

    public String getGenre()
    {
        return genre;
    }

    public void setGenre(String genre)
    {
        this.genre = genre;
    }

    public int getLength()
    {
        return length;
    }

    public void setLength(int length)
    {
        this.length = length;
    }

    public String getTrackInfo()
    {
        return String.format("Album Artist: \n"
                + "Album: \n"
                + "Publishing Year: \n"
                + "Title Number: \n"
                + "Genre: \n"
                + "Title Length: \n", artist, album, pub_year, title_nr, genre, length);
    }

    @Override
    public String toString()
    {
        return String.format("%2d - %s | %d:%d", title_nr, title, length / 60, length % 60);
    }

}
