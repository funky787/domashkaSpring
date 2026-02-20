package org.sadovodBase.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class LibraryInfoService {

    private final String libraryName;
    private final int maxBooks;

    public LibraryInfoService(
            @Value("${library.name}") String libraryName,
            @Value("${library.max-books}") int maxBooks) {

        this.libraryName = libraryName;
        this.maxBooks = maxBooks;
    }

    public void printInfo() {
        System.out.println("Library name: " + libraryName);
        System.out.println("Max books allowed: " + maxBooks);
    }
}