package hust.soict.dsai.aims.media;

import java.util.Comparator;

public abstract class Media implements Comparable<Media>{
    @Override
    public int compareTo(Media other) {
        int titleComparison = this.getTitle().compareTo(other.getTitle());
        if (titleComparison != 0) {
            return titleComparison;
        } else {
            return Double.compare(this.getCost(), other.getCost());
        }
    }

    public String playGUI(){
        return "Playing media";
    }
    
    private int id;
    private String title;
    private String category;
    private float cost;
    
    public void setID(int id){
    this.id = id;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setCost(float cost){
        this.cost = cost;
    }
    public void setCategory(String category){
        this.category = category;
    }

    public int getID(){
        return this.id;
    }
    public String getTitle(){
        return this.title;
    }
    public float getCost(){
        return this.cost;
    }
    public String getCategory(){
        return this.category;
    }

    public boolean isMatch(int id){
        if (this.getID() == id){
            return true;
        }
        return false;
    }

    public boolean isMatch(String title){
        if (this.getTitle().toLowerCase().equals(title.trim().toLowerCase())){
            return true;
        }
        return false;
    }

    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj instanceof Media){
            Media s = (Media) obj;
            return s.getTitle() == getTitle();
        }
        return false;
    }

    public Media(int id,String title,String category,float cost){
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }
    
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();

    public String getDetail(){
		if (this instanceof DigitalVideoDisc) {
			return String.format("DVD - %s - %s - %s - %d minutes: %.2f $", this.getTitle(),this.getCategory(), ((Disc)this).getDirector(), ((Disc)this).getLength(), this.getCost());
		}

		else if (this instanceof CompactDisc) {
			return String.format("CD - %s - %s - %d minutes: %.2f $", this.getTitle(),this.getCategory(), ((Disc)this).getLength(), this.getCost());
		}

		else {
			return String.format("Book - %s - %s - %s: %.2f $", this.getTitle(), ((Book)this).getAuthors(), this.getCategory(), this.getCost());
		}
	}
}
