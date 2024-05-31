package hust.soict.dsai.aims.media;

public class Disc extends Media{
    @Override
    public int compareTo(Media other) {
        if (other instanceof Disc) {
            Disc otherDVD = (Disc) other;
            int titleComparison = this.getTitle().compareTo(otherDVD.getTitle());
            if (titleComparison != 0) {
                // Compare by title
                return titleComparison;
            } else {
                // Compare by decreasing length
                int lengthComparison = Integer.compare(otherDVD.getLength(), this.getLength());
                if (lengthComparison != 0) {
                    return lengthComparison;
                } else {
                    // Compare by cost
                    return Double.compare(this.getCost(), otherDVD.getCost());
                }
            }
        } else {
            // If the media object is not a Disc, use the default method of the Media class
            return super.compareTo(other);
        }
    }
    
    private int length;
    private String director;
    private int id;

    public Disc(int id, String title,String category,float cost,int length,String director){
        super(id, title, category, cost);
        this.director = director;
        this.length = length;
    }

    public String getDirector(){
        return this.director;
    }
    public int getLength(){
        return this.length;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Disc - "+this.getTitle()+" - "+this.getCategory()+" - "+this.director+" - "+this.getCost()+"$";
    }
}
