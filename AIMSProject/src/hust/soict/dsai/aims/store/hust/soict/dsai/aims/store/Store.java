package hust.soict.dsai.aims.store;
import java.util.Arrays;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
    private static DigitalVideoDisc itemInStore[] = new DigitalVideoDisc[0];
    public static int getLength(){
        return itemInStore.length;
    }
    public static void addDVD(DigitalVideoDisc dvd){
        DigitalVideoDisc temp[] = Arrays.copyOf(itemInStore, itemInStore.length + 1);
        temp[itemInStore.length] = dvd;
        itemInStore = Arrays.copyOf(temp, temp.length);
    }
    public static void removeDVD(DigitalVideoDisc dvd){
        DigitalVideoDisc temp[] = new DigitalVideoDisc[itemInStore.length - 1];
        int j = 0;
        for (int i = 0; i < itemInStore.length; i++ ){
            if(!itemInStore[i].equals(dvd)){
                temp[j] = itemInStore[i];
                j++;
            }
        }
        itemInStore = Arrays.copyOf(temp, temp.length);
    }
    public static void print(){
        for(DigitalVideoDisc i : itemInStore){
            System.out.println(i.getTitle());
        }
    }
}
