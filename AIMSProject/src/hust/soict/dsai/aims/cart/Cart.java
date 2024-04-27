package hust.soict.dsai.aims.cart;
import java.util.ArrayList;
import java.util.Arrays;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Cart {
    public static final int MAX_NUMBER_ORDER = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBER_ORDER];
    private int qtyOrdered = 0;
    public int getqtyOrdered(){
        return qtyOrdered;
    }
    public String addDigitalVideoDisc(DigitalVideoDisc[] dvdList){
        if(dvdList.length + qtyOrdered > 20){
            return ("The list is too long");
        }
        else if(qtyOrdered == 20){
            return ("The cart is full");
        }
        else{
            int j = 0;
            for(int i = 0; i < 20; i++){
                if(itemsOrdered[i] == null && j < dvdList.length){
                    itemsOrdered[i] = dvdList[j];
                    qtyOrdered++;
                    j++;
                }
            }
            return ("The dvd list has been added");
        }
    }

    /* public String addDigitalVideoDisc(DigitalVideoDisc... dvds){
        ArrayList<DigitalVideoDisc> temp = new ArrayList<>();
        temp.addAll(Arrays.asList(dvds));
        if(!(temp.size() + qtyOrdered > 20)){
            DigitalVideoDisc temp_2[] = temp.toArray(new DigitalVideoDisc[0]);
            itemsOrdered = Arrays.copyOf(temp_2, 20);
            return ("The dvds have been added");
        }
        else if(qtyOrdered ==20){
            return ("The cart is full");
        }
        else{
            return("Too much dvds to add");
        }
    } */

    public String addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2){
        DigitalVideoDisc[] dvdList = {dvd1,dvd2};
        if(dvdList.length + qtyOrdered > 20){
            return ("The list is too long");
        }
        else if(qtyOrdered == 20){
            return ("The cart is full");
        }
        else{
            int j = 0;
            for(int i = 0; i < 20; i++){
                if(itemsOrdered[i] == null && j < dvdList.length){
                    itemsOrdered[i] = dvdList[j];
                    qtyOrdered++;
                    j++;
                }
            }
            return ("The dvd list has been added");
        }
    }

    public String addDigitalVideoDisc(DigitalVideoDisc disc){
        for(int i = 0; i < 20; i++){
            if(itemsOrdered[i] == null){
                itemsOrdered[i] = disc;
                qtyOrdered++;
                return ("\""+disc.getTitle() + "\" has been added");
            }
        }
        return ("\"The cart is full\"");
    }

    public String removeDigitalVideoDisc(DigitalVideoDisc disc){
        for(int i= 0; i < 20; i++){
            if(itemsOrdered[i].equals(disc)){
                itemsOrdered[i] = null;
                qtyOrdered--;
                return ("\""+disc.getTitle() + "\" has been deleted");
            }
        }
        return ("\"The cart is empty\"");
    }
    public float totalCost(){
        float c = 0;
        for(DigitalVideoDisc i : itemsOrdered){
            if(i != null){
                c = c + i.getCost();
            }
        }
        return c;
    }
    public void print(){
        System.out.println("*********************CART********************");
        for(int i = 0; i <20; i++){
            if(itemsOrdered[i] != null){

                System.out.println(i+1+". "+itemsOrdered[i]);
            }
        }
        System.out.println("Total cost: "+ totalCost()+"$");
        System.out.println("*********************************************");
    }

    public boolean searchCart(String title){
        for(DigitalVideoDisc i : itemsOrdered){
            if(i.isMatch(title)){
                System.out.println(i.getTitle() + " is in the cart.");
                return true;
            }
        }
        System.out.println(title + " is not in the cart.");
        return false;
    }

    public boolean searchCart(int id){
        for(DigitalVideoDisc i : itemsOrdered){
            if(i.isMatch(id)){
                System.out.println("id " + i.getID() + " is in the cart.");
                return true;
            }
        }
        System.out.println("id "+id + " is not in the cart.");
        return false;
    }
}
