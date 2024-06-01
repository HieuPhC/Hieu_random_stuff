package hust.soict.dsai.aims.store;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.exception.PlayerException;

import javax.naming.LimitExceededException;
import javax.swing.*;

public class Store {
    private static ArrayList<Media> itemsInStore = new ArrayList<Media>();
    private static int qty = 0;

	public void addMedia() {
		Scanner input = new Scanner(System.in);

        System.out.println("Please enter the following information to add media.");
        System.out.println("Please enter media type (Valid input: CD - DVD - Book)");
        String type = input.nextLine();
        System.out.println("Please enter media name");
        String title = input.nextLine();
        System.out.println("Please enter media category/genre");
        String category = input.nextLine();
        System.out.println("Please enter the cost");
        float cost = input.nextFloat();
        input.nextLine();  
        if (type.equals("DVD")) {
            System.out.println("Please enter the director");
            String director = input.nextLine();
            System.out.println("Please enter the DVD length");
            int length = input.nextInt();
            DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
            addMedia(dvd);
        }

        else if (type.equals("CD")) {
            input.nextLine();
            System.out.println("Please enter the artist");
            String artist = input.nextLine();
			ArrayList<Track> tracks = new ArrayList<>();
            CompactDisc cd = new CompactDisc(title, category, cost, artist,tracks);
            addMedia(cd);
        }
    
        else if (type.equals("Book")) {
            System.out.println("Please enter the number of authors");
            int nbAuthors = input.nextInt();
            input.nextLine();

            if (nbAuthors > 1) {
                List<String> authors = new ArrayList<String>();
                System.out.println("Please enter the authors");
                while (input.hasNextLine()) {
                    authors.add(input.nextLine());
                }
                Book book = new Book(title, category, cost, authors);
                addMedia(book);
            }
            else {
                System.out.println("Please enter the author(s)");
                String author = input.nextLine();
				List<String> authors = new ArrayList<String>();
				authors.add(author);
                Book book = new Book(title, category, cost, authors);
                addMedia(book);
            }
        }
        else {
            System.out.println("Incorrect media type. Please try again.");
            addMedia();
        }
        return;
    }

	public void addToCart(Cart c) throws LimitExceededException {
		Scanner input = new Scanner(System.in);
        System.out.println("Please enter the media name you want to add");
        String title = input.nextLine();

        for (Media i : itemsInStore){
            if (i.isMatch(title)) {
                c.addMedia(i);
                System.out.println("Number of items in the cart: "+c.getNumberofItemsOrdered());
                return;
            }
        }
        System.out.println("Please recheck the name you've entered.");
    }

	public static boolean addMedia(Media media) {
        if (!itemsInStore.contains(media)) {
            itemsInStore.add(media);
            System.out.println("Added product to the store: "+media.getTitle());
			qty++;
            return true;
        }
        else {
            System.out.println("Unable to add product: "+media.getTitle()+" because the product is already in the store");
            return false;
        }
    }

    public void removeMedia() {
		Scanner input = new Scanner(System.in);
        System.out.println("Please enter the media name you want to remove");
        String title = input.nextLine();
        

        for (Media i : itemsInStore){
            if (i.isMatch(title)) {
                removeMedia(i);
                return;
            }
        }
        System.out.println("Nothing has been removed. Please recheck the name you entered.");
    }

    public static boolean removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
        qty--;
            System.out.println("Removed product from the store: "+media.getTitle());
            return true;
        }
        else {
            System.out.println("Unable to remove product: "+media.getTitle()+" because the product is not in the store");
            return false;
        }
    }

	public static void print() {
		int k = 0;
		System.out.println("");
		System.out.println("***********************CART***********************");
		if (itemsInStore.size() > 0) {
			System.out.println("Items in store:");
			for (Media i : itemsInStore){
				System.out.printf("%d. %s%n", k+1, i.getDetail());
				k++;
			}
		}
		else {
			System.out.println("Nothing in store.");
		}
		System.out.println("***************************************************");
	}

    public void update() {
        System.out.println("");
        System.out.println("Update store ");
        System.out.println("--------------------------------");
        System.out.println("1. Add media to the store");
        System.out.println("2. Remove media to the store");
        System.out.println("0. Return to main menu");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");

		Scanner input = new Scanner(System.in);
		int selected = input.nextInt();

		if (selected == 1) {
            addMedia();
		}
		else if (selected == 2) {
            removeMedia();
		}
		else {
		    System.out.println("Invalid input");
		}
    }

	public void playMedia() throws PlayerException {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the media name you want to play");
        String title = input.nextLine();
        for (Media i : itemsInStore) {
                if (i.isMatch(title)) {
                    if(i instanceof Playable){
                            ((Playable) i).play();
                    } else {
                        System.out.println("The media you entered cannot be played.");
                        return;
                    }
                }
            }
        System.out.println("Nothing has been played. Please recheck the name you entered.");
    }
    public void getDetail(Cart c) throws LimitExceededException, PlayerException {
		Scanner input = new Scanner(System.in);
        System.out.println("Please enter the media name you want to explore more");
        String title = input.nextLine();
        int selected;

        for (Media i : itemsInStore){
            System.out.println("");
            if (i.isMatch(title)) {
                System.out.println(i.getDetail());
                System.out.println("Options ");
                System.out.println("--------------------------------");
                System.out.println("1. Add media to the cart");
                if (i instanceof Disc) {
                    System.out.println("2. Play media");
                }
                System.out.println("0. Return to main menu");
                System.out.println("--------------------------------");
                System.out.println("Please choose a number: ");

                selected = input.nextInt();
                if (selected == 1) {
                    c.addMedia(i);
                    return;
                }

                else if (selected == 2 && i instanceof CompactDisc) {
                    ((CompactDisc)i).play();
                    return;
                }

                else if (selected == 2 && i instanceof DigitalVideoDisc) {
                    ((DigitalVideoDisc)i).play();
                    return;
                }

                else {
                    return;
                }
            }        
        }
        System.out.println("Please recheck the name you've entered.");
    }

    public ArrayList<Media> getItemsInStore(){
        return itemsInStore;
    }
}