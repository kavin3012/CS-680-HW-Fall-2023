package edu.umb.cs680.hw10.fs.cmd;

import edu.umb.cs680.hw10.fs.FSElement;
import edu.umb.cs680.hw10.fs.util.*;

public class Crawling {

    private FSElement e;

    private FileCrawlingVisitor v;

    public Crawling(FSElement e) {
        this.e = e;
        v = new FileCrawlingVisitor();
    }

    public void execute() {
        e.accept(v);
    }

    public FileCrawlingVisitor getVisitor() {
        return v;
    }
    
}
