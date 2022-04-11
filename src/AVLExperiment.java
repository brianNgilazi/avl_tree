import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

public class AVLExperiment {

    public static void main(String[] args) {
        CSVFileReader fileReader = new CSVFileReader("vaccinations.csv");
        List<List<String>> dataList = fileReader.getData();
        StringBuffer stringBuffer = new StringBuffer();

        // Randomise list
        Collections.shuffle(dataList);

        try {
            File file = new File("experiment-results.txt");
            PrintWriter outputStream = new PrintWriter(file);
            for (String line : stringBuffer.toString().split("\n")) {
                outputStream.println(line);
            }
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
