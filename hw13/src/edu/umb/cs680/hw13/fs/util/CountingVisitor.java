package edu.umb.cs680.hw13.fs.util;

import edu.umb.cs680.hw13.fs.*;

public class CountingVisitor implements FSVisitor {
    
    private int dirNum = 0;
    private int fileNum = 0;
    private int linkNum = 0;

    public void visit(Link link) {
        linkNum++;
    }

    public void visit(Directory dir ){
        dirNum++;
    }

    public void visit(File file) {
        fileNum++;
    }

    public int getFileNum() {
        return fileNum;
    }

    public int getLinkNum() {
        return linkNum;
    }

    public int getDirNum() {
        return dirNum;
    }
    
}
