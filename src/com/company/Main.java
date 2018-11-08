package com.company;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sf = new Scanner(new File("Imports.txt"));
        int maxIndx = -1;
        String text[] = new String[100000];


        String firstName[] = new String[50];
        String lastName[] = new String[50];
        int average[] = new int[50];
        int absences[] = new int[50];

        Scanner sf2;
        sf.nextLine();
        while (sf.hasNext()) {
            maxIndx++;
            text[maxIndx] = sf.useDelimiter("\\t").nextLine() + "\t";
            text[maxIndx] = text[maxIndx].replace("%", "");
        }
        for (int i = 0; i < maxIndx + 1; i++) {
            sf2 = new Scanner(text[i]);
            sf2.useDelimiter("\\t");
            firstName[i] = sf2.next();
            lastName[i] = sf2.next();
            average[i] = Integer.parseInt(sf2.next());
            absences[i] = Integer.parseInt(sf2.next());
        }
        int a = 0, b = 0, c = 0, d = 0, f = 0;
        for (int j = 0; j < firstName.length; j++) {
            if (average[j] >= 90)
                a++;
            else if (average[j] >= 80)
                b++;
            else if (average[j] >= 70)
                c++;
            else if (average[j] >= 60)
                d++;
            else if (average[j] >= 50)
                f++;
        }

        boolean nameGone = false;

        Scanner kbInput = new Scanner(System.in);

        String first = "";
        String last = "";

        int placeInArray = -1;
        System.out.println("Class Grades");
        System.out.println(a + " A's");
        System.out.println(b + " B's");
        System.out.println(c + " C's");
        System.out.println(d + " D's");
        System.out.println(f + " F's");
        boolean myGuy = false;
        while (myGuy == false) {
            do {

                System.out.println("Please input the first name of the student you would like to find");
                first = kbInput.nextLine();
                System.out.println("Enter the last name");
                last = kbInput.nextLine();

                for (int i = 0; i < firstName.length; i++) {
                    if (Objects.equals(firstName[i], first) && (Objects.equals(lastName[i], last))) {
                        placeInArray = i;
                    }
                }

                if (placeInArray == -1) {
                    System.out.println("\n Name not found...Try again");
                    nameGone = false;
                } else {
                    System.out.println("\nStudent: " + firstName[placeInArray] + " " + lastName[placeInArray]);
                    System.out.println("Average Grade: " + average[placeInArray] + "%");
                    System.out.println("Absences: " + absences[placeInArray]);
                    if (absences[placeInArray] >= 5 && average[placeInArray] < 70)
                        System.out.println("**Warning: Student's absences may be hurting their grade**");
                    placeInArray = -1;
                }
            } while (nameGone = false);
            System.out.println("\nType Exit to stop");

            if (Objects.equals(kbInput.nextLine().toLowerCase(), "exit"))
                myGuy = true;
        }

    }
}