package edu.umb.cs680.hw10.fs.cmd;

import edu.umb.cs680.hw10.fs.FSElement;
import edu.umb.cs680.hw10.fs.util.FileSearchVisitor;
import edu.umb.cs680.hw10.fs.FSCommand;

public class FileSearch implements FSCommand {

    private FSElement e;

    private FileSearchVisitor v;

    public FileSearch(FSElement e, String fileName) {
        this.e = e;
        this.v = new FileSearchVisitor(fileName);
    }

    public void execute() {
        e.accept(v);
    }

    public FileSearchVisitor getVisitor() {
        return v;
    }

}
