package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws IOException {

        String text = new String(Files.readAllBytes(Paths.get("/Users/Vladyslav/Desktop/Harry.txt")));

        String cleanText = text
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

        // System.out.println(cleanText);

        // Find the longest word in the text above. First variant.

        String words[] = text.split("[^a-zA-Z]");

        int i, size = words.length;
        int iMax = -1, iMaxLength = -1;

        for (i = 0; i < size; ++i)
            if (!"".equals(words[i]) && words[i].length() > iMaxLength) {
                iMax = i;
                iMaxLength = words[i].length();
            }

        if (iMax == -1)
            System.err.println("String does not contains words");
        else
            System.out.println("Word index = " + iMax + ";\tMax: " + words[iMax]);

        // Finding the longest word in the text above. Second variant.

        String longest = "";

        for (int l = 0; l < words.length; l++) {
            if (words[l].length() > longest.length()) {
                longest = words[l];
            }
        }

        System.out.println("Max: " + longest);

        // Count lines where the word "Harry" is met.

        String[] lines = text.split("\\n");

        int counter = 0;

        for (int x = 0; x < lines.length; x++) {
            if (lines[x].contains("Harry")) {
                counter++;
            }
        }

        System.out.println("The word Harry occurs in " + counter + " lines in the book.");

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
                    counterHash++;
                }
            }
        }

        System.out.println("Same hashes counter = " + counterHash);

        if (counterHash == 0)
            System.out.println("No same hashes");
        else {
            System.out.println("Same hashes found");
        }
    }
}