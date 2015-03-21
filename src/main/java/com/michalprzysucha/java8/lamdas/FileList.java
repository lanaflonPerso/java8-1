package com.michalprzysucha.java8.lamdas;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;

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
    }

    private void go() {
        java7();
        java8();
    }

    public static void main(String[] args) {
        new FileList().go();
    }

}
