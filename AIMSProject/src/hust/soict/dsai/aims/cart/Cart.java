package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.exception.PlayerException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.naming.LimitExceededException;
import javax.swing.*;
import java.util.Collections;
import java.util.Scanner;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

	public ObservableList<Media> getItemsOrdered() {
		return itemsOrdered;
	}

	public int getNumberofItemsOrdered() {
		return itemsOrdered.size();
	}

	// Add and remove media from cart
	public String addMedia(Media media) throws LimitExceededException {
		if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
			throw new LimitExceededException("ERROR: The number of media has reached its limit");
		} else if (itemsOrdered.contains(media)) {
			return(media.getTitle() + " is already in the cart!");
		} else {
			itemsOrdered.add(media);
			return (media.getTitle() + " has been added!");
		}
	}

    public boolean removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("Removed product from the cart: "+media.getTitle());
            return true;
        }
        else {
            System.out.println("Unable to remove product: "+media.getTitle()+" because the product is not in the cart");
            return false;
        }
    }

    public void removeMedia() {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Please enter the media name you want to remove");
        String title = input.nextLine();
        for (Media i : itemsOrdered){
            if (i.isMatch(title)) {
                removeMedia(i);
                return;
            }
        }
        System.out.println("Nothing has been removed. Please recheck the name you entered.");
    }

	public float totalCost() {
		float total=0;
		for (Media i : itemsOrdered) {
			total+=i.getCost();
		}
		return total;
	}

	public void print() {
		int k = 0;
		System.out.println("");
		System.out.println("***********************CART***********************");
		if (itemsOrdered.size() > 0) {
			System.out.println("Ordered Items:");
			for (Media i : itemsOrdered){
				System.out.printf("%d. %s%n", k+1, i.getDetail());
				k++;
			}
			System.out.printf("Total cost: %.2f%n", totalCost());
		}
		else {
			System.out.println("Nothing in cart here.");
		}
		System.out.println("***************************************************");
	}

	private void search(String title) {
		int k = 0; // matching flag
		System.out.println("");
		System.out.printf("Search results for '%s':%n", title);
		for (Media i : itemsOrdered){
			if (i.isMatch(title)) {
				System.out.printf("- %s%n", i.getDetail());
				k = 1; // flag triggers when there is a matching
			}
		}
		if (k == 0) { // no matching
			System.out.println("No results");
		}
		System.out.println("");
	}

	private void search(int id) {
		int k = 0; // matching flag
		System.out.println("");
		System.out.printf("Search results for '%s':%n", id);
		for (Media i : itemsOrdered){
			if (i.isMatch(id)) {
				System.out.printf("- %s%n", i.getDetail());
				k = 1; // flag triggers when there is a matching
			}
		}
		if (k == 0) { // no matching
			System.out.println("No results");
		}
		System.out.println("");
	}

	public void sortItems() {
		Scanner input = new Scanner(System.in);
		System.out.println("Type 1 if you want to sort by title.\nType 2 if you want to sort by cost.");
		int selected = input.nextInt();
		if (selected == 1) {
			Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
			System.out.println("Sorting completed.");
			print();
		}
		else {
			Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
			System.out.println("Sorting completed.");
			print();
		}
		
	}

	public void filterItems() {
		System.out.println("");
		System.out.println("Filtering options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter by id");
		System.out.println("2. Filter by title");
		System.out.println("0. Return to previous menu");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
		Scanner input = new Scanner(System.in);
		int selected = input.nextInt();
		
		if (selected == 1) {
			System.out.println("Enter the ID to filter ");
			search(input.nextInt());
		}

		else if (selected == 2) {
			System.out.println("Enter the title to filter ");
			search(input.nextLine());
		}

		else {
			return;
		}
	}

	public void empty() {
		itemsOrdered.clear();
	}

	public void playMedia() throws PlayerException {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter the media name you want to play");
		String title = input.nextLine();
		for (Media i : itemsOrdered) {
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

    public String placeOrder() {
		if (itemsOrdered.size() == 0) {
			return "Your cart is empty!";
		} else {
			itemsOrdered.clear();
			return "Order created!\n" + "Now your cart will be empty!";
		}
	}
}