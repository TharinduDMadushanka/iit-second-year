package FileWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args){

        // create a new file

        File myFile = new File("test.txt");

        try {
            if (myFile.createNewFile()) {
//            Unhandled exception: java.io.IOException
                System.out.println("File created! " + myFile.getAbsolutePath());
            }else {
                System.out.println("File already exists!");
            }
        } catch (IOException e) {
            System.out.println("Error creating file!");
            e.printStackTrace();
        }

        // write something the file

        try {
            FileWriter fileWriter = new FileWriter("test.txt");
            fileWriter.write("Hello TDM !");
            fileWriter.close();
            System.out.println("File written!");

        } catch (IOException e) {
            System.out.println("Error writing file!");
            e.printStackTrace();
        }

    }
}