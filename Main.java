package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main { // class for main gradebook


    public static void overTheTopGreeting() {
        System.out.println("~~~~~~~~~~~~~~~~~");
        System.out.println("*               *");
        System.out.println("* ~~~Welcome~~~ *");
        System.out.println("*               *");
        System.out.println("~~~~~~~~~~~~~~~~~");
    }

    public static void displayMenu() {
        System.out.println("~~~~~Menu~~~~~");
        System.out.println("1. Enter Grades");
        System.out.println("2. Access previous grades");
        System.out.println("Enter '0' to exit program");
    }


    public static void main(String[] args) throws IOException {
        // objects
        Scanner scan = new Scanner(System.in);
        Courses course1 = new Courses();
        Student student1 = new Student();


        overTheTopGreeting();
        System.out.print("Welcome to the Gradebook program!  Please enter your name here: ");
        student1.studentName = scan.nextLine();
        System.out.print("Alright " + student1.studentName + ", let's get started! \n");

        // as long as flag does not equal zero, goes back to menu
        int flag = 5;
        while (flag != 0) {
            displayMenu();
            System.out.print("Enter the number that corresponds to the feature you would like to use here: ");
            int menuChoice = scan.nextInt();
            scan.nextLine();
            switch (menuChoice) {
                // exits program
                case 0 -> System.out.println("Are you sure you want to quit?");
                // enter grades from student portion
                case 1 -> {
                    course1.enterGrades(course1.QuizGrades, course1.ExamGrades, course1.HWGrades, course1.ProjectGrades);
                    course1.putAverageGradesInMap(course1.averageGrades);
                    System.out.println("Your overall grade" + " is: " + course1.getFinalGrade(course1.averageGrades));
                    course1.weight = course1.getFinalGrade(course1.averageGrades); //assigns weighted grade to course1.weight
                    System.out.println(course1.assignLetterGrade(course1.weight));  //Prints letter grade and message
                    student1.writeDataToFile(course1.weight, course1.averageGrades, course1.QuizGrades,
                            course1.ExamGrades, course1.HWGrades, course1.ProjectGrades); //calls function to put weighted grade in file
                }
                // retrieve old grades portion
                case 2 -> {
                    student1.loadOldGrades();
                    student1.printOldGrades();
                }
                default -> System.out.println("Invalid choice. Please enter either 0, 1, or 2.");
            }

            System.out.print("Type 0 to quit, or any other key to go back to menu.  Enter choice here: ");
            flag = scan.nextInt();
            scan.nextLine();
        }
        System.out.println("Exiting...");
    }
}
