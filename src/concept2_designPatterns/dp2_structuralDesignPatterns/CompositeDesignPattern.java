/*
 *  Composite Design Pattern:
 *      - This pattern helps in scenarios where we have OBJECTS inside OBJECTS(Tree like structure). 
 * 
 *      - The Composite Design Pattern is a structural pattern that allows you to treat a group of objects 
 *        and individual objects uniformly by organizing them into tree structures to represent part-whole hierarchies.    
 */

import java.util.ArrayList;
import java.util.List;
import helperInterfaces.FileSystem;

class File implements FileSystem {
    String fileName;

    File(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void ls() {
        System.out.println(fileName);
    }
}

class Directory implements FileSystem {
    String directoryName;
    List<FileSystem> directoryFiles = new ArrayList<>();

    Directory(String directoryName) {
        this.directoryName = directoryName;
    }

    public void add(FileSystem fileSystem) {
        this.directoryFiles.add(fileSystem);
    }

    @Override
    public void ls() {
        System.out.println("Files under " + directoryName + ": ");
        for (FileSystem file : directoryFiles) {
            file.ls();
        }
    }
}

public class CompositeDesignPattern {
    public static void main(String[] args) {
        File f1 = new File("Test.java");
        File f2 = new File("Test.class");
        Directory javaFolder = new Directory("javaFolder");
        javaFolder.add(f1);
        javaFolder.add(f2);

        Directory rootDirectory = new Directory("root");
        rootDirectory.add(new File("tempFile1.txt"));
        rootDirectory.add(new File("tempFile2.txt"));
        rootDirectory.add(new File("tempFile3.txt"));
        rootDirectory.add(new File("tempFile4.txt"));
        rootDirectory.add(javaFolder);
        rootDirectory.ls();
    }
}
