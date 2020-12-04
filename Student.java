package com.company;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Student { // class for Student
    String studentName;

    // default constructor taking the studentName as a parameter
    Student() {}

    Courses course1 = new Courses();


    /**
     * Writes grades entered by user into file
     */
    protected void writeDataToFile(double weight, HashMap<String, Double> map, ArrayList<Double> array1,
                                   ArrayList<Double> array2, ArrayList<Double> array3, ArrayList<Double> array4)
            throws IOException {
        course1.weight = weight;
        course1.QuizGrades = array1;
        course1.ExamGrades = array2;
        course1.HWGrades = array3;
        course1.ProjectGrades = array4;
        HashMap<String,Double> averageGrades2;
        averageGrades2 = map;

        File studentInfo = new File("src/studentInfo.txt");

        if (!studentInfo.exists()) {
            studentInfo.createNewFile();
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(studentInfo, true));
            writer.write(studentName + "'s grades: " + "\n");
            writer.write("Final grade: " + " " + weight + "\n");
            writer.write("Quiz Grades: " + array1.toString() + "\n");
            writer.write("Average Quiz Grade: " + averageGrades2.get("Average Quiz Grade") + "\n");
            writer.write("Exam Grades: " + array2.toString() + "\n");
            writer.write("Average Exam Grade: " + averageGrades2.get("Average Exam Grade") + "\n");
            writer.write("Homework Grades: " + array3.toString() + "\n");
            writer.write("Average Homework Grade: " + averageGrades2.get("Average HW Grade") + "\n");
            writer.write("Project Grades: " + array4.toString() + "\n");
            writer.write("Average Project Grade: " + averageGrades2.get("Average Project Grade") + "\n");
            writer.write("\n");
            writer.close();
        } catch (IOException writerEX) {
            System.out.println("Cannot write to file: permission issue: " + writerEX.getStackTrace());
        }
    }

    List<String> oldGrades = new ArrayList<>();

    /**
     * Accesses data previously written to the text file and add it to the list oldGrades
     */
    protected void loadOldGrades() {
        try{
            FileReader reader = new FileReader("src/studentInfo.txt");
            BufferedReader bReader = new BufferedReader(reader);
            String line = "";
            while ((line = bReader.readLine()) != null) {
                oldGrades.add(line);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Prints data retrieved from loadOldGrades method
     */
    protected void printOldGrades() {
        if (oldGrades.size() < 1) {
            System.out.println("No previous grades stored.");
        } else {
            System.out.println("Previous Grades: ");
            for (String i : oldGrades) {
                System.out.println(i);
            }
        }
    }
}