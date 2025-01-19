import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class ReadingFileData {
    public static String[] readingFile(String filepath) {
        String[] data = null;
        try {
            File myObj = new File(filepath);
            Scanner myReader = new Scanner(myObj);
            String line = myReader.nextLine();
            data = line.split(" ");
            System.out.println(Arrays.toString(data));
            myReader.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return data;
    }
}
