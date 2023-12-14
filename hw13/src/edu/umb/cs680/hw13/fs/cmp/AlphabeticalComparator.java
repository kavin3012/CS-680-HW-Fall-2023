package edu.umb.cs680.hw13.fs.cmp;

import java.util.Comparator;

import edu.umb.cs680.hw13.fs.FSElement;

public class AlphabeticalComparator implements Comparator<FSElement> {
    public int compare(FSElement element1, FSElement element2) {
        return element1.getName().compareTo(element2.getName());
    }
}