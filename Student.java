package com.company;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Student { // class for Student
    String studentName;
    int classSelection;

    // default constructor taking the studentName as a parameter
    Student(String name) {}



    // Function writing to the list (if it doesn't exit, make the file)
    protected void writeDataToFile(double weight) throws IOException {
        File studentInfo = new File("src/studentInfo.txt");
        if (!studentInfo.exists()) {
            studentInfo.createNewFile();
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(studentInfo, true));
            writer.write(studentName + "'s weighted grade: " + " " + weight + "\n");
            writer.close();
        } catch (IOException writerEX) {
            System.out.println("Cannot write to file: permission issue: " + writerEX.getStackTrace());
        }
    }


    }



