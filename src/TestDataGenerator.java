import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class TestDataGenerator {
    public static void main(String[] args) {
        CSVFileReader fileReader = new CSVFileReader("vaccinations.csv");
        List<List<String>> dataList = fileReader.getData();
        List<String> countries = new ArrayList<>();
        for (int i = 1; i < 4; i++) {
            try {
                File file = new File(String.format("test-data/test%d.txt", i));
                file.getParentFile().mkdirs();
                PrintWriter outputStream = new PrintWriter(file);
                String date = "2022-02-0"+i;
                outputStream.println(date);
                int index = 0;
                int total = i * 5;
                while (countries.size() < (total - 1)) {
                    String countryName = dataList.get(index).get(0);
                    if (countries.contains(countryName)) {
                        index++;
                        continue;
                    }
                    countries.add(countryName);
                }
                countries.add("Anti-Vaxxers");
                for (String country : countries) {
                    outputStream.println(country);
                }
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            countries.clear();

        }


    }
}
