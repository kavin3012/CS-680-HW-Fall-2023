package edu.umb.cs680.hw07;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;


public class FileTest {
    private static FileSystem fs;
    private static LocalDateTime date;

    @BeforeAll
    public static void setUp() {
        date = LocalDateTime.now();
        fs = TestFixtureInitializer.createFS(date);
    }

    public static String[] fileToStringArray(File f) {
        String[] stringArray = new String[4];
        stringArray[0] = f.getName();
        stringArray[1] = Integer.toString(f.getSize());
        stringArray[2] = f.getParent() == null ? "null" : f.getParent().getName();
        stringArray[3] = f.getCreationTime().toString();
        return stringArray;
    }

    @Test
    public void verifyFileEqualityA() {
        File f = fs.getRootDirs().getFirst().getSubDirectories().get(0).getFiles().get(0);
        String[] expected = {"A.java", "10", "src", date.toString()};
        assertArrayEquals(expected,fileToStringArray(f));
    }

    @Test
    public void verifyFileEqualityB() {
        File f = fs.getRootDirs().getFirst().getSubDirectories().get(0).getFiles().get(1);
        String[] expected = {"B.java", "10", "src", date.toString()};
        assertArrayEquals(expected,fileToStringArray(f));
    }

    @Test
    public void verifyFileEqualityATest() {
        File f = fs.getRootDirs().getFirst().getSubDirectories().get(1).getSubDirectories().get(0).getFiles().get(0);
        String[] expected = {"ATest.java", "15", "src", date.toString()};
        assertArrayEquals(expected,fileToStringArray(f));
    }

    @Test
    public void verifyFileEqualityBTest() {
        File f = fs.getRootDirs().getFirst().getSubDirectories().get(1).getSubDirectories().get(0).getFiles().get(1);
        String[] expected = {"BTest.java", "15", "src", date.toString()};
        assertArrayEquals(expected,fileToStringArray(f));
    }

    @Test
    public void verifyFileEqualityReadme() {
        File f = fs.getRootDirs().getFirst().getFiles().get(0);
        String[] expected = {"readme.md", "20", "repo", date.toString()};
        assertArrayEquals(expected,fileToStringArray(f));
    }

    @Test
    public void getNameTest() {
        File f = fs.getRootDirs().getFirst().getFiles().get(0);
        assertEquals("readme.md" ,f.getName());
    }

    @Test
    public void getCreationTimeTest() {
        File f = fs.getRootDirs().getFirst().getFiles().get(0);
        assertEquals(date.toString() ,f.getCreationTime().toString());
    }

    @Test
    public void getParentTest() {
        File f = fs.getRootDirs().getFirst().getFiles().get(0);
        Directory expected = fs.getRootDirs().getFirst();
        assertSame(expected ,f.getParent());
    }

    @Test
    public void getSizeTest() {
        File f = fs.getRootDirs().getFirst().getFiles().get(0);
        assertEquals(20 ,f.getSize());
    }

    @Test
    public void isDirectoryTest() {
        File f = fs.getRootDirs().getFirst().getFiles().get(0);
        assertFalse(f.isDirectory());
    }

}
