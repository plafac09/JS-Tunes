/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

/**
 *
 * @author Steffie
 */
import javax.sound.sampled.*;
import java.io.*;


public class TrackController extends Thread
{
    private SourceDataLine line = null;
    private AudioInputStream din = null;
    private boolean inter = false;
    private String filename = "";

    @Override
    public void run() 
    {
        playTrack();
    }
    
    
    
    /*
    To get MP3 information (such as channels, sampling rate, and 
    other metadata), you need to call the AudioSystem.getAudioFileFormat(file) 
    static method from AudioSystem. It will return an instance of MpegAudioFileFormat, 
    from which you can get audio properties. Note that the AudioSystem class acts 
    as the entry point to the sampled-audio system resources.
    
    
    To play MP3, you need first to call AudioSystem.getAudioInputStream(file) 
    to get an AudioInputStream from an MP3 file, select the target format 
    (i.e., PCM) according to input MP3 channels and sampling rate, and 
    finally get an AudioInputStream with the target format. If JavaSound 
    doesn't find a matching SPI implementation supporting the 
    MP3-to-PCM conversion, then it will throw an exception.
    */
   
    public void playTrack() 
    {
        try 
        {
            File file = new File(filename);
            AudioInputStream in = AudioSystem.getAudioInputStream(file);
            AudioFormat baseFormat = in.getFormat();
            AudioFormat decodedFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,
                    baseFormat.getSampleRate(),
                    16,
                    baseFormat.getChannels(),
                    baseFormat.getChannels() * 2,
                    baseFormat.getSampleRate(),
                    false);
            din = AudioSystem.getAudioInputStream(decodedFormat, in);
            // Play now. 
            rawplay(decodedFormat);
            in.close();
        } 
        catch (Exception e) 
        {
            //Handle exception.
            System.out.println("Exception in TrackController: playTrack: "+e.toString());
        }
    }
    
    public void setInter(boolean inter) 
    {
        this.inter = inter;
    }
    
    public void setAudioFilePath(String filename) 
    {
        this.filename = filename;
    }
    
    /*Second, you have to send the decoded PCM data to a SourceDataLine. 
    This means you have to load PCM data from the decoded AudioInputStream 
    into the SourceDataLine buffer until the end of file is reached. 
    JavaSound will send this data to the sound card. Once the 
    file is exhausted, the line resources must be closed.*/
    
    private void rawplay(AudioFormat targetFormat) throws IOException, LineUnavailableException 
    {
        byte[] data = new byte[4096];
        line = getLine(targetFormat);
        if (line != null) 
        {
            // Start
            line.start();
            int nBytesRead = 0, nBytesWritten = 0;
            while (nBytesRead != -1) 
            {
                if(inter)
                {
                    break;
                }
                nBytesRead = din.read(data, 0, data.length);
                if (nBytesRead != -1) 
                {
                    nBytesWritten = line.write(data, 0, nBytesRead);
                }

            }
            line.drain();
            line.stop();
            line.close();
            din.close();
        }
    }
    
    //method for getting DataLine Info
    private SourceDataLine getLine(AudioFormat audioFormat) throws LineUnavailableException 
    {
        SourceDataLine res = null;
        DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
        res = (SourceDataLine) AudioSystem.getLine(info);
        res.open(audioFormat);
        return res;
    }

    
    
}

