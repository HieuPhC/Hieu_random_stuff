package hust.soict.dsai.test.disc;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class TestPassingParameter {
    public static void main(String[] args) {
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        swap(jungleDVD, cinderellaDVD);
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("Cinderella dvd title: " + cinderellaDVD.getTitle());

        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
    }
    public static void swap(Object o1, Object o2){
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }
    /* public static void swap(DigitalVideoDisc o1, DigitalVideoDisc o2){
        String title1 = o1.getTitle();
        String category1 = o1.getCategory();
        String director1 = o1.getDirector();
        int length1 = o1.getLength();
        float cost1 = o1.getCost();

        o1.setTitle(o2.getTitle());
        o1.setCategory(o2.getCategory());
        o1.setDirector(o2.getDirector());
        o1.setLength(o2.getLength());
        o1.setCost(o2.getCost());
        
        o2.setTitle(title1);
        o2.setCategory(category1);
        o2.setDirector(director1);
        o2.setLength(length1);
        o2.setCost(cost1);
    } */
    public static void changeTitle(DigitalVideoDisc dvd, String title){
        String oldTitle =  dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }
}
