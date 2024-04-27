package hust.soict.dsai.aims.disc;
public class DigitalVideoDisc{
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    /* @Override
    public String toString() {
        return title;
    }
    */
    private static int nbDigitalVideoDisc = 0;

    private int id;

    public static int getnb(){
        return nbDigitalVideoDisc;
    }
    public String getTitle(){
        return this.title;
    }
    public String getCategory(){
        return this.category;
    }
    public String getDirector(){
        return this.director;
    }
    public int getLength(){
        return this.length;
    }
    public float getCost(){
        return this.cost;
    }
    public int getID(){
        return this.id;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    public void setCost(float cost) {
        this.cost = cost;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setID(int ID){
        this.id = ID;
    }

    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj instanceof DigitalVideoDisc){
            DigitalVideoDisc s = (DigitalVideoDisc) obj;
            return s.title == title && s.category == category && s.director == director && s.cost == cost && s.length == length && s.id == id;
        }
        return false;
    }

    public DigitalVideoDisc(String title, String category,String director,int length,float cost){
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        this.id = nbDigitalVideoDisc;
        nbDigitalVideoDisc++;
    }
    public DigitalVideoDisc(){
        super();
        nbDigitalVideoDisc++;
    }
    public DigitalVideoDisc(String title){
        super();
        this.title = title;
        this.id = nbDigitalVideoDisc;
        nbDigitalVideoDisc++;
    }
    public DigitalVideoDisc(String title,String category,float cost){
        super();
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.id = nbDigitalVideoDisc;
        nbDigitalVideoDisc++;
    }
    public DigitalVideoDisc(String director,String category,String title,float cost){
        super();
        this.title = title;
        this.category = category;
        this.director = director;
        this.cost = cost;
        this.id = nbDigitalVideoDisc;
        nbDigitalVideoDisc++;
    }

    public boolean isMatch(int id){
        if (this.id == id){
            return true;
        }
        return false;
    }

    public boolean isMatch(String title){
        if (this.title.toLowerCase().equals(title.trim().toLowerCase())){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "DVD - "+this.title+" - "+this.category+" - "+this.director+" - "+this.length+" - "+this.cost+"$";
    }
}
