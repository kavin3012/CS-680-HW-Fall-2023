package edu.umb.cs680.hw10;

import edu.umb.cs680.hw10.fs.*;
import edu.umb.cs680.hw10.fs.util.*;
import edu.umb.cs680.hw10.fs.cmd.Counting;
import edu.umb.cs680.hw10.fs.cmd.FileSearch;
import edu.umb.cs680.hw10.fs.cmd.Crawling;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

public class FSCommandTest {

    private static FileSystem fs;
    private static LocalDateTime date;

    @BeforeAll
    public static void setUp() {
        date = LocalDateTime.now();
        fs = TestFixtureInitializer.createFS(date);
    }

    @Test
    public void fileCrawlingOnSrc() {
        Directory d = fs.getRootDirs().get(0).getSubDirectories().get(1);
        Crawling cmd = new Crawling(d);
        cmd.execute();

        LinkedList<File> expected = d.getSubDirectories().get(0).getFiles();
        FileCrawlingVisitor v = cmd.getVisitor();
        assertIterableEquals(expected, v.getFiles());
    }

    @Test
    public void fileSearchOnSrc() {
        Directory d = fs.getRootDirs().get(0).getSubDirectories().get(1);
        FileSearch cmd = new FileSearch(d, "none");
        cmd.execute();

        LinkedList<File> expected = new LinkedList<>();
        FileSearchVisitor v = cmd.getVisitor();
        assertIterableEquals(expected, v.getFiles());
    }

    @Test
    public void CountingOnSrc() {
        Directory d = fs.getRootDirs().get(0).getSubDirectories().get(1);
        Counting cmd = new Counting(d);
        cmd.execute();
        
        LinkedList<File> expected = new LinkedList<>();
        CountingVisitor v = cmd.getVisitor();
        
        assertEquals(2, v.getDirNum());
        assertEquals(2, v.getFileNum());
        assertEquals(1, v.getLinkNum());
    }

}
