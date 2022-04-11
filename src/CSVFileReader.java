import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class to Read files and access the file data as strings
 */
public class CSVFileReader {

    private List<List<String>> data;
    public CSVFileReader(String fileName){
        data = readFile(fileName);
    }

    /**
     * Reads each line of a csv and adds it to an array
     * @param fileName the name of the file to read
     * @return
     */
    private List<List<String>> readFile(String fileName){
        String delimiter = ",";
        String line;
        List<List<String>> lines = new ArrayList<>();
         try (BufferedReader br =
                      new BufferedReader(new FileReader(fileName))) {
             while((line = br.readLine()) != null){
                 List<String> values = Arrays.asList(line.split(delimiter));
                 lines.add(values);
             }
            //  lines.forEach(l -> System.out.println(l));
         } catch (Exception e){
             System.out.println(e);
         }
        return lines;
    }

    /**
     * Get the data read from a file.
     * @return
     */
    public List<List<String>> getData() {
        return data;
    }
}
