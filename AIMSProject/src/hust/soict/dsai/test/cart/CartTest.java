package hust.soict.dsai.test.cart;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.sound.midi.spi.MidiFileWriter;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();
        List<String> authors = new ArrayList<String>();
        authors.add("J.K Rowling");

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King","Animation",
        "Roger Allers",87,19.95f);

        Book book1 = new Book("Harry Porter", "Magic", 29.95f,authors);

        ArrayList<Track> tracks = new ArrayList<>();
        Track track = new Track("Send me a podcast", 3);
        tracks.add(track);
        CompactDisc cd1 = new CompactDisc("Radio songs", "Road listening", 20.95f, "null", tracks);

        List<Media> al = new ArrayList<>();

        al.add(cd1);
        al.add(book1);
        al.add(dvd1);


        // cart.addMedia(dvd1);
        // cart.addMedia(book1);
        // cart.addMedia(cd1);

        // List<Media> mediae = new ArrayList<Media>();
        // mediae.add(cd2);
        // mediae.add(dvd1);
        // mediae.add(book1);
        
        // for(Media m : mediae){
        //     System.out.println(m.toString());;
        // }

        //Test the print method
        //cart.print();
        //Test the search methods
        //cart.search(1);
        Iterator<Media> custIterator = al.iterator();

        System.out.println("Before Sorting:\n");
 
        while (custIterator.hasNext()) {
 
            // Iterating using next() method
            System.out.println(custIterator.next());
        }
 
        //Collections.sort(al,Media.COMPARE_BY_COST_TITLE);
        Collections.sort(al,Media.COMPARE_BY_TITLE_COST);
 
        System.out.println("\n\nAfter Sorting:\n");
 
        for (Media customer : al) {
            System.out.println(customer);
        }
    }
}
