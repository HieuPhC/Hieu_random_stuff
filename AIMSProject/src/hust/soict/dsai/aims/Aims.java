package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.*;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.*;
import java.util.*;

public class Aims {
	static Store aStore = new Store();
	static Cart anOrder = new Cart();
	static Scanner input = new Scanner(System.in);

	public static void showMenu() {
		System.out.println("");
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
		int selected = input.nextInt();

		if (selected == 1) {
			aStore.print();
			storeMenu();
			showMenu();
		}
		else if (selected == 2) {
			aStore.update();
			showMenu();
		}
		else if (selected == 3) {
			anOrder.print();
			cartMenu();
			showMenu();
		}
		else {
			return;
		}
	}

	public static void storeMenu() {
		System.out.println("");
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media's details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");

		int selected = input.nextInt();
		if (selected == 1) {
			aStore.getDetail(anOrder);
			storeMenu();
		}
		else if (selected == 2) {
			aStore.addToCart(anOrder);
			storeMenu();
		}
		else if (selected == 3) {
			aStore.playMedia();
			storeMenu();
		}
		else if (selected == 4) {
			anOrder.print();
			cartMenu();
			storeMenu();
		}
		else {
			return;
		}
	}

	public static void cartMenu() {
		System.out.println("");
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");

		int selected = input.nextInt();
		if (selected == 1) {
			anOrder.filterItems();
			cartMenu();
		}
		else if (selected == 2) {
			anOrder.sortItems();
			cartMenu();
		}
		else if (selected == 3) {
			anOrder.removeMedia();
			cartMenu();
		}
		else if (selected == 4) {
			anOrder.playMedia();
			cartMenu();
		}
		else if (selected == 5) {
			System.out.println("An order has been created. The cart will now be emptied.");
			anOrder.empty();
			cartMenu();
		}
		else {
			return;
		}
	}

	public static void main(String[] args) { // preadded 3 products to the store
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King","Animation",
        "Roger Allers",87,19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars","Science Fiction",
        "George Lucas",87,24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin","Animation",18.99f);
        Store.addMedia(dvd3);
        Store.addMedia(dvd2);
        Store.addMedia(dvd1);
		showMenu();
		input.close();
	}
}