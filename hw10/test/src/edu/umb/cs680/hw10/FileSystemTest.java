package edu.umb.cs680.hw10;

import edu.umb.cs680.hw10.fs.*;
import edu.umb.cs680.hw10.fs.util.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

public class FileSystemTest {

    private static FileSystem fs;
    private static LocalDateTime date;

    @BeforeAll
    public static void setUp() {
        date = LocalDateTime.now();
        fs = TestFixtureInitializer.createFS(date);
    }

    @Test
    public void singletonTest() {
        FileSystem fs1 = FileSystem.getFileSystem();
        FileSystem fs2 = FileSystem.getFileSystem();
        assertSame(fs1, fs2);
    }

    @Test
    public void notNullTest() {
        FileSystem fs1 = FileSystem.getFileSystem();
        assertNotNull(fs1);
    }

    @Test
    public void appendRootDirsTest() {
        Directory dir1 = new Directory(null, "root2", 0, LocalDateTime.now());
        fs.appendRootDir(dir1);
        
        assertEquals(2, fs.getRootDirs().size());
        setUp();
    }

    @Test
    public void clearDirsTest() {
        assertEquals(1, fs.getRootDirs().size());

        fs.clearRootDir();

        assertEquals(0, fs.getRootDirs().size());

        setUp();
    }

    @Test
    public void getRootDirsTest() {
        LinkedList<Directory> expected = fs.getRootDirs();
        Directory newRootDir = new Directory(null, "root2", 0, LocalDateTime.now());
        fs.appendRootDir(newRootDir);
        expected.add(newRootDir);

        assertIterableEquals(expected, fs.getRootDirs());

        setUp();
    }


}
