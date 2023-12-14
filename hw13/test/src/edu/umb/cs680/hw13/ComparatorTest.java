package edu.umb.cs680.hw13;

import edu.umb.cs680.hw13.fs.*;
import edu.umb.cs680.hw13.fs.cmp.AlphabeticalComparator;
import edu.umb.cs680.hw13.fs.cmp.ReverseAlphabeticalComparator;
import edu.umb.cs680.hw13.fs.cmp.SizeComparator;
import edu.umb.cs680.hw13.fs.util.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

public class ComparatorTest {

    private static FileSystem fs;
    private static LocalDateTime date;

    @BeforeAll
    public static void setUp() {
        date = LocalDateTime.now();
        fs = TestFixtureInitializer.createFS(date);
    }

    @Test
    public void testAlphaComparator() {
        Directory dir = fs.getRootDirs().get(0).getSubDirectories().get(1);
        LinkedList<FSElement> children = dir.getChildren(new AlphabeticalComparator());
        LinkedList<Directory> files = dir.getSubDirectories();
        assertIterableEquals(files, children);
    }

    @Test
    public void testReverseAlphaComparator() {
        Directory dir = fs.getRootDirs().get(0).getSubDirectories().get(1);
        LinkedList<Directory> dirs = dir.getSubDirectories(new ReverseAlphabeticalComparator());
        LinkedList<Directory> expected = new LinkedList<>(Arrays.asList((Directory) dir.getChildren().get(0)));
        assertIterableEquals(expected, dirs);
    }

    @Test
    public void testSizeComparator() {
        Directory dir = fs.getRootDirs().get(0).getSubDirectories().get(1);
        LinkedList<File> files = dir.getFiles(new SizeComparator());
        LinkedList<File> expected = new LinkedList<>(dir.getFiles());
        assertIterableEquals(expected, files);
    }

}
