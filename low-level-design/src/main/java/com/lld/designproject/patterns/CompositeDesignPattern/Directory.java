package com.lld.designproject.patterns.CompositeDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystem {
    String directoryName;
    List<FileSystem> fileSystemList;

    public Directory(String name) {
        directoryName = name;
        fileSystemList = new ArrayList<>();
    }

    public void addFile(FileSystem fileSystem) {
        fileSystemList.add(fileSystem);
    }

    @Override
    public void ls() {
        System.out.println("dir name -" + directoryName);
        for (FileSystem fileSystem : fileSystemList) {
            fileSystem.ls();
        }

    }
}
