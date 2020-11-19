package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main { // class for main gradebook

    public static void main(String[] args) throws IOException {
        // objects
        Scanner scan = new Scanner(System.in);
        Courses course1 = new Courses();
        Student student1 = new Student("");

        // greeting
        System.out.print("Welcome to the Gradebook program!  Please enter your name here: ");
        student1.studentName = scan.nextLine();

        // classSelection = true
        // while (classSelection) {
        System.out.println("Hello " + student1.studentName + "! \n " +
                "1. Math \n 2. Accounting \n 3. Computer Science \n 4. English \n" +
                "Please type the number corresponding to your class (Only math is working right now): ");
        student1.classSelection = scan.nextInt();
        scan.nextLine();
        // Are you done selecting classes?
        // classSelection = false
        //  }
        System.out.println("Please enter grades for " + course1.printCourse() + " (Overall Quiz Grade, Overall Exam Grade, Overall HW Grade, Overall Project Grade).");
        boolean gradeEntry = true; // flag for loop
        while (gradeEntry) {
            String exitChoice;
            //input grades from student
            course1.enterGrades(course1.Course1Grades);

            System.out.println("Are you finished entering grades? (Y/N): ");
            exitChoice = scan.nextLine();
            if (exitChoice.toLowerCase().startsWith("y")) {
                gradeEntry = false; // ends the loop
            }
        }
        System.out.print("Your weighted average for " + course1.printCourse() + " is: "); //not println so it prints after colon
        System.out.println(course1.getWeightedGrade(course1.Course1Grades)); // gets weighted grade for grades entered
        course1.weight = course1.getWeightedGrade(course1.Course1Grades); // assigns weighted grade to course1.weight
        System.out.println(course1.assignLetterGrade(course1.weight));  //Prints letter grade and message
        student1.writeDataToFile(course1.weight); //calls function to put weighted grade in file
    }
}
