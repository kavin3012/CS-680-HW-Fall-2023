package edu.umb.cs680.hw10;

import edu.umb.cs680.hw10.fs.*;
import edu.umb.cs680.hw10.fs.util.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

public class DirectoryTest {
    private static FileSystem fs;
    private static LocalDateTime date;

    @BeforeAll
    public static void setUp() {
        date = LocalDateTime.now();
        fs = TestFixtureInitializer.createFS(date);
    }

    public static String[] dirToStringArray(Directory dir) {
        String[] stringArray = new String[4];
        stringArray[0] = dir.getName();
        stringArray[1] = Integer.toString(dir.getSize());
        stringArray[2] = dir.getParent() == null ? "null" : dir.getParent().getName();
        stringArray[3] = dir.getCreationTime().toString();
        return stringArray;
    }

    @Test
    public void verifyDirEqualityRepo() {
        Directory dir = fs.getRootDirs().getLast();
        String[] expected = { "repo", "0", "null", date.toString() };
        assertArrayEquals(expected, dirToStringArray(dir));
    }

    @Test
    public void verifyDirEqualitySrc() {
        Directory dir = fs.getRootDirs().get(0).getSubDirectories().get(0);
        String[] expected = { "src", "0", "repo", date.toString() };
        assertArrayEquals(expected, dirToStringArray(dir));
    }

    @Test
    public void verifyDirEqualityTest() {
        Directory dir = fs.getRootDirs().get(0).getSubDirectories().get(1);
        String[] expected = { "test", "0", "repo", date.toString() };
        assertArrayEquals(expected, dirToStringArray(dir));
    }

    @Test
    public void verifyDirEqualityTestSrc() {
        Directory dir = fs.getRootDirs().get(0).getSubDirectories().get(1).getSubDirectories().get(0);
        String[] expected = { "src", "0", "test", date.toString() };
        assertArrayEquals(expected, dirToStringArray(dir));
    }

    @Test
    public void getNameTest() {
        Directory dir = fs.getRootDirs().get(0).getSubDirectories().get(0);
        assertEquals("src", dir.getName());
    }

    @Test
    public void getCreationTimeTest() {
        Directory dir = fs.getRootDirs().get(0).getSubDirectories().get(0);
        assertEquals(date.toString(), dir.getCreationTime().toString());
    }

    @Test
    public void getParentTest() {
        Directory dir = fs.getRootDirs().get(0).getSubDirectories().get(0);
        Directory expected = fs.getRootDirs().getFirst();
        assertSame(expected, dir.getParent());
    }

    @Test
    public void getSizeTest() {
        Directory dir = fs.getRootDirs().get(0).getSubDirectories().get(0);
        assertEquals(0, dir.getSize());
    }

    @Test
    public void isDirectoryTest() {
        Directory dir = fs.getRootDirs().get(0).getSubDirectories().get(0);
        assert (dir.isDirectory());
    }

    @Test
    public void countChildrenTest() {
        Directory dir = fs.getRootDirs().get(0).getSubDirectories().get(0);
        assertEquals(2, dir.countChildren());
    }

    @Test
    public void getChildrenTest() {
        Directory dir = fs.getRootDirs().get(0);
        List<FSElement> expected = dir.getChildren();
        Directory dir2 = new Directory(dir, "new", 0, date);

        expected.add(dir2);

        assertIterableEquals(expected, dir.getChildren());
        setUp();
    }

    @Test
    public void getSubDirectories() {
        Directory dir = fs.getRootDirs().get(0).getSubDirectories().get(0);
        List<Directory> expected = new ArrayList<>();

        assertIterableEquals(expected, dir.getSubDirectories());
    }

    @Test
    public void getFiles() {
        Directory dir = fs.getRootDirs().get(0).getSubDirectories().get(0);
        List<File> expected = new ArrayList<>();
        expected.add((File) dir.getChildren().get(0));
        expected.add((File) dir.getChildren().get(1));
        assertIterableEquals(expected, dir.getFiles());
    }

}
