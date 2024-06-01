package hust.soict.dsai.aims.media;

import hust.soict.dsai.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable{
    private String director;
    private int length;
    private static int nbDVD = 0;

    public DigitalVideoDisc(String title, String category,String director,int length,float cost){
        super(nbDVD++, title, category, cost, length, director);
    }
    public DigitalVideoDisc(){
        this(null,null,null,0,0);
    }
    public DigitalVideoDisc(String title){
        this(title,null,null,0,0);
    }
    public DigitalVideoDisc(String title,String category,float cost){
        this(title,category,null,0,cost);
    }
    public DigitalVideoDisc(String director,String category,String title,float cost){
        this(title,category,director,0,cost);
    }
    @Override
    public String toString() {
        return "DVD - "+this.getTitle()+" - "+this.getCategory()+" - "+this.getDirector()+" - "+this.getLength()+" - "+this.getCost()+"$";
    }
    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj instanceof DigitalVideoDisc){
            DigitalVideoDisc s = (DigitalVideoDisc) obj;
            return s.getTitle() == getTitle() && s.getCategory() == getCategory() && s.getCost() == getCost() && s.getID() == getID();
        }
        return false;
    }
    @Override
    public String play() throws PlayerException {
        if (Integer.compare(this.getLength(), 0) <= 0) {
            throw new PlayerException("ERROR: DVD length is non-positive!");
        }
        System.out.println("Playing DVD: "+this.getTitle());
        System.out.println("DVD length: "+this.getLength());
        return "Playing DVD: " + this.getTitle() + "\n" + "DVD length: " + this.getLength();
    }
}
