import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

/**
 * Class to run the Assignment 2 experiment and save the results in a text file
 */
public class Experiment {

    public static void main(String[] args) {
        CSVFileReader fileReader = new CSVFileReader("vaccinations.csv");
        List<List<String>> dataList = fileReader.getData();
        StringBuffer stringBuffer = new StringBuffer();

        // Randomise list
        Collections.shuffle(dataList);
        for (int n = 900; n <= 9000; n += 900) {
            stringBuffer.append(String.format("n = %d%n", n));
            List<List<String>> list = dataList.subList(0, n);
            ExperimentStats bstStats = new ExperimentStats();
            ExperimentStats arrayStats = new ExperimentStats();
            for (List<String> dList : list) {
                String country = dList.get(0);
                String date = dList.get(1);
                int bstComparisons = bst.findComparisons(country, date);
                bstStats.record(bstComparisons);
                int arrayComparisons = array.findComparisons(country, date);
                arrayStats.record(arrayComparisons);
            }
            ;
            stringBuffer.append(String.format("Array Search: %s%n", arrayStats.toString()));
            stringBuffer.append(String.format("BST Search: %s%n", bstStats.toString()));
            stringBuffer.append("\n");

        }

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
