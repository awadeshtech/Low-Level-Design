package com.lld.designproject.patterns.CompositeDesignPattern;

public class Orchestrator {
    public static void main(String[] args) {
     Directory directory = new Directory("dir1");
     FileSystem file1 = new File("dir1_file1");
     directory.addFile(file1);

     Directory directory12 = new Directory("dir1_dir12");
     FileSystem file12 = new File("dir1_dir12_file1");
     directory12.addFile(file12);
     directory.addFile(directory12);
     directory.ls();
    }
}
