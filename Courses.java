package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Courses { // class for courses and calculations associated with them

    // Class fields
    double quizWeight = 0.20;
    double examWeight = 0.30;
    double hwWeight = 0.25;
    double projectWeight = 0.25;
    double weight;


    //public static String[] Courses = {"Math", "Accounting", "Computer Science", "English"};

    Scanner scan = new Scanner(System.in);
    //course 1
    public String course = "Math";

    //Array list for storing grades
    ArrayList<Double> Course1Grades = new ArrayList<>(); //list for first course grades


    //Method for storing grades entered by user
    protected void enterGrades(ArrayList<Double> array) {
        for (int i = 0; i < 4; i++) {
            array.add(scan.nextDouble());
        }
        System.out.println("Your grades are: ");
        System.out.println(array.toString());
    }

    //Method for printing course(s)
    public String printCourse() {
        return course;
    }

    // method for weighted grade calculation
    protected double getWeightedGrade(ArrayList<Double> array) {
        ArrayList<Double> gradeWeight2;
        gradeWeight2 = array;

        double weight = (quizWeight * gradeWeight2.get(0) + (examWeight * gradeWeight2.get(1)) + (hwWeight * gradeWeight2.get(2)) +
                (projectWeight * gradeWeight2.get(3)));
        return weight;
    }

    // method for assigning letter grade to weighted grade
    protected String assignLetterGrade(double weight) {
        if (weight > 89) {
            return "Great job!  You got an A!";
        } else if (weight > 79 && weight < 89) {
            return "Nice job!  You got a B!";
        } else if (weight > 69 && weight < 79) {
            return "Solid job!  You got a C!";
        } else if (weight > 59 && weight < 69) {
            return "This is an area for improvement.  You got a D.";
        } else {
            return "You got an F.";
        }

    }



}
