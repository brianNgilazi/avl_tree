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

        int randomisation = 50;
        if (randomisation > 100) {
            randomisation = 100;
        }
        if (randomisation < 0) {
            randomisation = 0;
        }
        int endIndex = dataList.size() / (100 / randomisation);

        List<List<String>> shufledSubList = dataList.subList(0, endIndex);
        Collections.shuffle(shufledSubList);
        List<List<String>> restOfList = dataList.subList(endIndex, dataList.size());

        shufledSubList.addAll(restOfList);
        for (List<String> list : shufledSubList) {
            stringBuffer.append(list.toString()).append("\n");
        }
        try {
            File file = new File("experiment-data.txt");
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
