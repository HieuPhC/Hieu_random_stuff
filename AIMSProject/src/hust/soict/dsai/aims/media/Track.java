package hust.soict.dsai.aims.media;

public class Track implements Playable{
    private String title;
    private int length;
    
    public void setTitle(String title){
        this.title = title;
    }
    public void setLength(int length){
        this.length = length;
    }

    public String getTitle(){
        return this.title;
    }
    public int getLength(){
        return this.length;
    }
    public Track(String title, int length){
        this.title = title;
        this.length = length;
    }
    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj instanceof Track){
            Track s = (Track) obj;
            return s.getTitle() == getTitle() && s.getLength() == getLength(); 
        }
        return false;
    }
    @Override
    public String toString() {
        return "Track - "+this.getTitle()+" - "+this.length+" min";
    }
    @Override
    public String play() {
        System.out.println("Playing Track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
        return ("Playing Track: " + this.getTitle() +"\n" + "Track length: " + this.getLength());
    }
}
