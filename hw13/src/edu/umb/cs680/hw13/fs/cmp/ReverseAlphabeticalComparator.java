package edu.umb.cs680.hw13.fs.cmp;

import java.util.Comparator;


import edu.umb.cs680.hw13.fs.FSElement;

public class ReverseAlphabeticalComparator implements Comparator<FSElement> {
    public int compare(FSElement element1, FSElement element2) {
        return element2.getName().compareTo(element1.getName());
    }
}

