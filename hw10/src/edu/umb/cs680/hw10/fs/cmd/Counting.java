package edu.umb.cs680.hw10.fs.cmd;

import edu.umb.cs680.hw10.fs.FSElement;
import edu.umb.cs680.hw10.fs.util.*;

public class Counting {
    private FSElement e;

    private CountingVisitor v;

    public Counting(FSElement e) {
        this.e = e;
        v = new CountingVisitor();
    }

    public void execute() {
        e.accept(v);
    }

    public CountingVisitor getVisitor() {
        return v;
    }
}
