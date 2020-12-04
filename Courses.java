package com.company;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Courses { // class for courses and calculations associated with them

    // Class fields/objects
    double quizWeight = 0.20;
    double examWeight = 0.30;
    double hwWeight = 0.25;
    double projectWeight = 0.25;
    double weight;
    Scanner scan = new Scanner(System.in);


    //Array list for storing quiz grades
    ArrayList<Double> QuizGrades = new ArrayList<>();

    //Array list for storing exam grades
    ArrayList<Double> ExamGrades = new ArrayList<>();

    //Array list for storing hw grades
    ArrayList<Double> HWGrades = new ArrayList<>();

    //Array list for storing project grades
    ArrayList<Double> ProjectGrades = new ArrayList<>();


    /**
     * Method that takes inputs from user and stores them as grades in different ArrayList depending on type of grade
     * @param array1 used to store quiz grades
     * @param array2 used to store exam grades
     * @param array3 used to store homework grades
     * @param array4 used to store project grades
     */
    protected void enterGrades(ArrayList<Double> array1, ArrayList<Double> array2, ArrayList<Double> array3, ArrayList<Double> array4) {
        boolean quizEntry = true; // flag to loop through quiz entry portion
        while (quizEntry) {
            int numQuizzes;
            System.out.print("Enter how many quiz grades you will be inputting: ");
            numQuizzes = scan.nextInt();
            scan.nextLine();
            System.out.println("Enter quiz grades below: ");
            for (int i = 0; i < numQuizzes; i++) {
                System.out.print("Quiz " + (i + 1) + ": ");
                array1.add(scan.nextDouble());
            }
            System.out.print("Your quiz grades are: " + array1.toString() + "\n");
            System.out.println("Are you finished entering quiz grades? (Y/N): ");
            scan.nextLine(); //so it doesn't skip input
            String quizContinue = scan.nextLine();
            if (quizContinue.toLowerCase().startsWith("y")) {
                quizEntry = false;
            }
        }
        boolean examEntry = true; // flag to loop through exam entry portion
        while (examEntry) {
            int numExams;
            System.out.println("Enter how many exam grades you will be inputting: ");
            numExams = scan.nextInt();
            scan.nextLine();
            System.out.println("Enter exam grades below: ");
            for (int i = 0; i < numExams; i++) {
                System.out.print("Exam " + (i + 1) + ": ");
                array2.add(scan.nextDouble());
            }
            System.out.println("Your exam grades are: " + array2.toString() + "\n");
            System.out.println("Are you finished entering exam grades? (Y/N): ");
            scan.nextLine(); //so it doesn't skip input
            String examContinue = scan.nextLine();
            if (examContinue.toLowerCase().startsWith("y")) {
                examEntry = false;
            }
        }
        boolean hwEntry = true; // flag to loop through hw entry portion
        while (hwEntry) {
            int numHWGrades;
            System.out.println("Enter how many homework grades you will be inputting: ");
            numHWGrades = scan.nextInt();
            scan.nextLine();
            System.out.println("Enter homework grades below: ");
            for (int i = 0; i < numHWGrades; i++) {
                System.out.print("Homework " + (i + 1) + ": ");
                array3.add(scan.nextDouble());
            }
            System.out.print("Your homework grades are: " + array3.toString() + "\n");
            System.out.println("Are you finished entering homework grades? (Y/N): ");
            scan.nextLine(); //so it doesn't skip input
            String hwContinue = scan.nextLine();
            if (hwContinue.toLowerCase().startsWith("y")) {
                hwEntry = false;
            }
        }
        boolean projectEntry = true; // flag to loop through project entry portion
        while (projectEntry) {
            int numProjects;
            System.out.println("Enter how many project grades you will be inputting: ");
            numProjects = scan.nextInt();
            scan.nextLine();
            System.out.println("Enter project grades below: ");
            for (int i = 0; i < numProjects; i++) {
                System.out.print("Project " + (i + 1) + ": ");
                array4.add(scan.nextDouble());
            }
            System.out.println("Your project grades are: " + array4.toString() + "\n");
            System.out.println("Are you finished entering project grades? (Y/N): ");
            scan.nextLine(); //so it doesn't skip input
            String projectContinue = scan.nextLine();
            if (projectContinue.toLowerCase().startsWith("y")) {
                projectEntry = false;
            }
        }
    }


    /**
     * calculates average grade from grades previously entered by user
     * @param array is the list of grades previous entered that we are taking the average of
     * @return the average grade
     */
    protected double getGradeAverage(ArrayList<Double> array) {
       double sum = 0.0;
       for (double value : array) {
           sum += value;
       }
       return sum/array.size();
    }


    /**
     * Assigns letter grade to number grade previously calculated
     * @param weight holds the number grade
     * @return A message based on the letter grade earned
     */
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

    // HashMap to store average grades based on type of grade
    HashMap<String, Double> averageGrades = new HashMap<>();


    /**
     * Stores average grades in HashMap averageGrades
     * @param map allows us to pass in the HashMap averageGrades
     */
    protected void putAverageGradesInMap(HashMap<String, Double> map) {
        map.put("Average Quiz Grade", getGradeAverage(QuizGrades));
        map.put("Average Exam Grade", getGradeAverage(ExamGrades));
        map.put("Average HW Grade", getGradeAverage(HWGrades));
        map.put("Average Project Grade", getGradeAverage(ProjectGrades));
    }


    /**
     * Calculates weighted grade
     * @param map passes in the averageGrades HashMap
     * @return the calculated weighted grade
     */
    protected double getFinalGrade(HashMap<String, Double> map) {
        HashMap<String,Double> gradeWeight;
        gradeWeight = map;

        double weightedGrade = (quizWeight * gradeWeight.get("Average Quiz Grade")) + (examWeight *
                gradeWeight.get("Average Exam Grade"))
                + (hwWeight * gradeWeight.get("Average HW Grade")) +
                (projectWeight * gradeWeight.get("Average Project Grade"));
        return weightedGrade;
    }
}