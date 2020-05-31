package com.company;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLOutput;

public class Main {

    public static void main(String[] args) throws IOException {

        String text = new String(Files.readAllBytes(Paths.get("/Users/Vladyslav/Desktop/Harry.txt")));

        String cleanerText = text
                .toLowerCase()
                .replaceAll("\\.", "")
                .replaceAll(",", "")
                .replaceAll("\"", "")
                .replaceAll("!", "")
                .replaceAll(";", "")
                .replaceAll(":", "")
                .replaceAll("\\(", "")
                .replaceAll("\\)", "")
                .replaceAll("\\?", "");

        // System.out.println(cleanerText);

        // Finding the longest word in the above text. First variant.

        String words[] = text.split("[^a-zA-Z]");
        int i, size = words.length;
        int iMax = -1, iMaxLength = -1;
        for (i = 0; i < size; ++i)
            if (!"".equals(words[i]) && words[i].length() > iMaxLength) {
                iMax = i;
                iMaxLength = words[i].length();
            }

        if (iMax == -1)
            System.err.println("String has no contains words");
        else
            System.out.println("Word index = " + iMax + ";\tMax: " + words[iMax]);

        // Finding the longest word in the above text. Second variant.

        String longest = "";

        for (int l=0; l < words.length; l++) {
            if ( words[l].length() > longest.length() ) {
                longest = words[l];
            }
        }

        System.out.println("Max: " + longest);

        // Count the lines where the word "Harry" is met.

        String[] harryLines = text.split("\\n");

        int harry = 0;
        for (int x = 0; x < harryLines.length; x++) {
            if (harryLines[x].contains("Harry")) {
                harry++;
            }
        }

        System.out.println("The word Harry occurs in " + harry + " lines in the book.");

        // Take array of distinct words from Harry Potter. Create an array of hashes.

        String distinktString = " ";

        for (int j = 0; j < words.length; j++) {
            if (!distinktString.contains(words[j])) {
                distinktString += words[j] + " ";
            }
        }
        String[] distrinctArray = distinktString.split(" ");
        for (int j = 0; j < distrinctArray.length; j++) {
            System.out.println(distrinctArray[j].hashCode());
        }

        // Count the intersections.

        int counterHash = 0;
        for (int s = 0; s < distrinctArray.length; s++) {
            for (int z = s + 1; z < distrinctArray.length; z++) {
                if (distrinctArray[s].equals(distrinctArray[z])) {
                    counterHash ++;
                }
            }
        }
        System.out.println("Кількість однакових хешів = " + counterHash);
        if ( counterHash == 0 )
            System.out.println("Серед хешів збігів не виявлено");
        else {
            System.out.println("Серед хешів виявлено збіги");
        }
    }
}