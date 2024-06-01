package hust.soict.dsai.aims.media;

import hust.soict.dsai.exception.PlayerException;

public interface Playable {
    public String play() throws PlayerException;
}
