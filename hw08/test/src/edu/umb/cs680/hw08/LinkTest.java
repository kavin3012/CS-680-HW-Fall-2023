package edu.umb.cs680.hw08;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

public class LinkTest {

    private static FileSystem fs;
    private static LocalDateTime date;

    @BeforeAll
    public static void setUp() {
        date = LocalDateTime.now();
        fs = TestFixtureInitializer.createFS(date);
    }

    @Test
    public void getNameTest() {
        Link f = (Link) fs.getRootDirs().getFirst().getSubDirectories().get(1).getSubDirectories().get(0).getChildren().get(2);
        assertEquals("rm.md", f.getName());
    }

    @Test
    public void getCreationTimeTest() {
        Link f = (Link) fs.getRootDirs().getFirst().getSubDirectories().get(1).getSubDirectories().get(0).getChildren().get(2);
        assertEquals(date.toString(), f.getCreationTime().toString());
    }

    @Test
    public void getParentTest() {
        Link f = (Link) fs.getRootDirs().getFirst().getSubDirectories().get(1).getSubDirectories().get(0).getChildren().get(2);
        Directory expected = fs.getRootDirs().getFirst().getSubDirectories().get(1).getSubDirectories().get(0);
        assertSame(expected, f.getParent());
    }

    @Test
    public void getSizeTest() {
        Link f = (Link) fs.getRootDirs().getFirst().getSubDirectories().get(1).getSubDirectories().get(0).getChildren().get(2);
        assertEquals(0, f.getSize());
    }

    @Test
    public void isDirectoryTest() {
        Link f = (Link) fs.getRootDirs().getFirst().getSubDirectories().get(1).getSubDirectories().get(0).getChildren().get(2);
        assertFalse(f.isDirectory());
    }

    @Test
    public void getTarget() {
        Link f = (Link) fs.getRootDirs().getFirst().getSubDirectories().get(1).getSubDirectories().get(0).getChildren().get(2);
        FSElement expected = fs.getRootDirs().getFirst().getFiles().getLast();
        assertSame(expected, f.getTarget());
    }

}
