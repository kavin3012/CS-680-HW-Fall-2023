package edu.umb.cs680.hw17.fs;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Directory extends FSElement {

    private LinkedList<FSElement> children;

    public Directory(Directory parent, String name, int size, LocalDateTime creationTime) {
        super(parent, name, size, creationTime);
        children = new LinkedList<>();
    }

    public int countChildren() {
        return children.size();
    }

    public void appendChild(FSElement child) {
        this.children.add(child);
        child.setParent(this);
    }

    public LinkedList<FSElement> getChildren() {
        List<FSElement> children = new ArrayList<>(this.children);
        Collections.sort(children, (e1, e2) -> e1.getName().compareTo(e2.getName()));
        return new LinkedList<>(children);
    }

    public LinkedList<FSElement> getChildren(Comparator<FSElement> cmp) {
        List<FSElement> children = new ArrayList<>(this.children);
        Collections.sort(children, cmp);
        return new LinkedList<>(children);
    }

    public LinkedList<Directory> getSubDirectories() {
        LinkedList<Directory> dirs = new LinkedList<>();
        children.forEach(child -> {
            if (child instanceof Directory) {
                dirs.add((Directory) child);
            }
        });
        return dirs;
    }

    public LinkedList<Directory> getSubDirectories(Comparator<FSElement> cmp) {
        List<Directory> dirs = new ArrayList<>(getSubDirectories());
        Collections.sort(dirs, cmp);
        return new LinkedList<>(dirs);
    }

    public LinkedList<File> getFiles() {
        LinkedList<File> files = new LinkedList<>();
        children.forEach(child -> {
            if (child instanceof File) {
                files.add((File) child);
            }
        });
        return files;
    }

    public LinkedList<File> getFiles(Comparator<FSElement> cmp) {
        List<File> files = new ArrayList<>(getFiles());
        Collections.sort(files, cmp);
        return new LinkedList<>(files);
    }

    public int getTotalSize() {
        final int[] size = {0};
        children.forEach(child -> {
            if (child instanceof Directory) {
                size[0] += ((Directory) child).getTotalSize();
            } else {
                size[0] += child.getSize();
            }
        });
        return size[0];
    }

    public boolean isDirectory() {
        return true;
    }

    public void accept(FSVisitor v) {
        v.visit(this);
        children.forEach(child -> child.accept(v));
    }

}
