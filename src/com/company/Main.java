package com.company;
import java.util.*;
import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException{
        Scanner sf = new Scanner(new File("Imports.txt"));

        int maxIndx = -1;
        String text[] = new String[1000];

        while(sf.hasNext()) {

            maxIndx++;
            text[maxIndx] = sf.nextLine();

        }

        sf.close();

        for (int j = 0; j <= maxIndx; j++){
            System.out.println(text[j]);
        }
    }
}
