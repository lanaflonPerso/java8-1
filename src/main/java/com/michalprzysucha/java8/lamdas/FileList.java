package com.michalprzysucha.java8.lamdas;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Optional;

/**
 * @author Michal Przysucha
 * @since 2015-03-19
 */
public class FileList {

    private void java7() {
        System.out.println(Arrays.asList(new File(".").listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return !pathname.isDirectory();
            }
        }))); 
        System.out.println(Arrays.asList(new File(".").listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        })));
    }

    private void java8() {
        System.out.println(Arrays.asList(new File(".").listFiles(pathname -> !pathname.isDirectory())));
        System.out.println(Arrays.asList(new File(".").listFiles(File::isDirectory)));
        Arrays.asList(new File(".").listFiles(pathname -> !pathname.isDirectory())).stream().forEach(System.out::println);
        Arrays.asList(new File(".").listFiles(pathname -> !pathname.isDirectory())).stream().map(x -> x + ", ").forEach(System.out::print);
        System.out.println();
        String result = Arrays.asList(new File(".").listFiles(pathname -> !pathname.isDirectory())).stream().map(x -> x + "").reduce("", (a, b) -> a + ", " + b);
        System.out.println(result);
        result = Arrays.asList(new File(".").listFiles(pathname -> !pathname.isDirectory())).stream().map(x -> x + "").reduce("", (a, b) -> a + (a.isEmpty() ? "" : ", ") + b);
        System.out.println(result);
        Optional<String> res2 = Arrays.asList(new File(".").listFiles(pathname -> !pathname.isDirectory())).stream().map(x -> x + "").reduce((a, b) -> a + ", " + b);
        System.out.println("File list: " + res2.get());

    }

    private void go() {
        java7();
        java8();
    }

    public static void main(String[] args) {
        new FileList().go();
    }

}
