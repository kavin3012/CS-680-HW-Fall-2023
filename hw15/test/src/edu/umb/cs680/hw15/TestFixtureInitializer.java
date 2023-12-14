package edu.umb.cs680.hw15;

import java.time.LocalDateTime;

import edu.umb.cs680.hw15.fs.Directory;
import edu.umb.cs680.hw15.fs.File;
import edu.umb.cs680.hw15.fs.FileSystem;
import edu.umb.cs680.hw15.fs.Link;

public class TestFixtureInitializer {

    // this method create the whole file system structure giving the date for the
    // creation of dirs, files
    public static FileSystem createFS(LocalDateTime date) {
        System.out.println("called");
        Directory dir1 = new Directory(null, "repo", 0, date);
        Directory dir2 = new Directory(dir1, "src", 0, date);
        Directory dir3 = new Directory(dir1, "test", 0, date);
        Directory dir4 = new Directory(dir3, "src", 0, date);
        File f1 = new File(dir2, "A.java", 10, date);
        File f2 = new File(dir2, "B.java", 10, date);
        File f3 = new File(dir4, "ATest.java", 15, date);
        File f4 = new File(dir4, "BTest.java", 15, date);
        File f5 = new File(dir1, "readme.md", 20, date);
        Link l1 = new Link(dir4, "rm.md", 0, date, f5);

        FileSystem fs = FileSystem.getFileSystem();
        fs.clearRootDir();
        fs.appendRootDir(dir1);
        System.out.println(fs);
        return fs;
    }
}
