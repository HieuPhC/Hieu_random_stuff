package hust.soict.dsai.aims.media;

import hust.soict.dsai.exception.PlayerException;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private ArrayList<Track> tracks;
    private static int nbCD = 0;

    public CompactDisc(String title,String category,float cost,String artist, ArrayList<Track> tracks){
        super(nbCD++, title, category, cost, 0, null);
        this.artist = artist;
        this.tracks = tracks;
    }

    public CompactDisc(String title) {
        super(nbCD++, title, null, 0, 0, null);
        this.tracks = new ArrayList<Track>();
    }

    public CompactDisc(String title, String category, String artist, float cost) {
        super(nbCD++, title, category, cost, 0, artist);
        this.tracks = new ArrayList<Track>();
    }
    
    public void setArtist(String artist){
        this.artist = artist;
    }
    public String getArtist(){
        return this.artist;
    }

    public void addTrack(Track track){
        if(!tracks.contains(track) ){
            tracks.add(track);
            System.out.println("The track has been added");
        }
        else{
            System.out.println("The track has already been added");
        }
    }

    public void removeTrack(Track track){
        if(tracks.contains(track)){
            tracks.remove(track);
            System.out.println("The track has been deleted");
        }
        else{
            System.out.println("The track does not exist");
        }
    }
    @Override
    public int getLength(){
        return tracks.size();
    }
    @Override
    public String toString() {
        return "CD - "+this.getTitle()+" - "+this.getCategory()+" - "+this.artist+" - "+this.tracks.toString()+" - "+this.getCost()+"$";
    }

    @Override
    public String play() throws PlayerException{
        String play = "";
        if(this.getLength() > 0){
            java.util.Iterator iter = tracks.iterator();
            Track nextTrack;
            while(iter.hasNext()){
                nextTrack = (Track) iter.next();
                try{
                    play += nextTrack.play();
                    play += "\n";
                }catch (PlayerException e){
                    throw e;
                }
            }
            return play;
        } else{
            throw new PlayerException("ERROR: CD's length is non positive!");
        }
    }
}
