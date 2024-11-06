package BufferedWriter;

import java.io.*;

public class BufferedWriteEx {
    public static void main(String[] args) {

        String fileName = "buffer.txt";

        try {

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName));
            bufferedWriter.write("Hello World \n");
            bufferedWriter.write("Hi \n");
            bufferedWriter.close();

            System.out.println("Content written successfully");

        } catch (IOException e) {
            System.out.println("Error writing to file");
            e.printStackTrace();
        }

        try {
            FileReader myFileReader = new FileReader(fileName);

            BufferedReader bufferedReader = new BufferedReader(myFileReader);

            String line = bufferedReader.readLine();

            while (line != null){
                System.out.println(line);
                break;
            }

            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
