package edu.umb.cs680.hw13.fs.util;

import edu.umb.cs680.hw13.fs.*;

import java.util.ArrayList;
import java.util.List;

public class FileCrawlingVisitor implements FSVisitor {

    private List<File> files = new ArrayList<>();

    public void visit(Link link) {
        return;
    }

    public void visit(Directory dir ){
        return;
    }

    public void visit(File file) {
        files.add(file);
    }

    public List<File> getFiles() {
        return files;
    }
    
}
