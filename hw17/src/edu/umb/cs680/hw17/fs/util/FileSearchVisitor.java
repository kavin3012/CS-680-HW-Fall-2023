package edu.umb.cs680.hw17.fs.util;

import java.util.ArrayList;
import java.util.List;

import edu.umb.cs680.hw17.fs.*;

public class FileSearchVisitor implements FSVisitor {

    private List<File> files;

    private String fileName;

    public FileSearchVisitor(String fileName) {
        this.fileName = fileName;
        files = new ArrayList<>();
    }

    public void visit(Link link) {
        return;
    }

    public void visit(Directory dir) {
        return;
    }

    public void visit(File file) {
        if (fileName.equals(file.getName())){
            files.add(file);
        }
    }

    public List<File> getFiles() {
        return files;
    }

}
