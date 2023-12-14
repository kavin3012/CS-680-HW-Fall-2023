package edu.umb.cs680.hw15;

import org.junit.jupiter.api.Test;

import edu.umb.cs680.hw15.fs.Directory;
import edu.umb.cs680.hw15.fs.FSElement;
import edu.umb.cs680.hw15.fs.File;
import edu.umb.cs680.hw15.fs.FileSystem;

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
        LinkedList<FSElement> children = dir.getChildren((e1, e2) -> e1.getName().compareTo(e2.getName()));
        LinkedList<Directory> files = dir.getSubDirectories();
        assertIterableEquals(files, children);
    }

    @Test
    public void testReverseAlphaComparator() {
        Directory dir = fs.getRootDirs().get(0).getSubDirectories().get(1);
        LinkedList<Directory> dirs = dir.getSubDirectories((e1, e2) -> e2.getName().compareTo(e1.getName()) );
        LinkedList<Directory> expected = new LinkedList<>(Arrays.asList((Directory) dir.getChildren().get(0)));
        assertIterableEquals(expected, dirs);
    }

    @Test
    public void testSizeComparator() {
        Directory dir = fs.getRootDirs().get(0).getSubDirectories().get(1);
        LinkedList<File> files = dir.getFiles((e1, e2) -> Integer.compare(e1.getSize(), e2.getSize()));
        LinkedList<File> expected = new LinkedList<>(dir.getFiles());
        assertIterableEquals(expected, files);
    }

}
