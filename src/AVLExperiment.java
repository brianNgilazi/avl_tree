import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

public class AVLExperiment {

    public static void main(String[] args) {
        String result = run(Integer.parseInt(args[0]));

        try {
            File file = new File("results.txt");
            PrintWriter outputStream = new PrintWriter(file);
            outputStream.print(result);
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Run the AVL exeriment
     *
     * @param degree the degree of randomization
     * @return A string with the results of the experiment (to be output or written
     *         to a file)
     */
    public static String run(int degree) {
        CSVFileReader fileReader = new CSVFileReader("vaccinations.csv");
        List<List<String>> dataList = randomiseList(fileReader.getData(), degree);

        VaccineAVL vaccineAVL = new VaccineAVL();
        VaccineBST vaccineBST = new VaccineBST(dataList);

        ExperimentStats avlInsertionStats = new ExperimentStats();
        ExperimentStats avlSearchStats = new ExperimentStats();
        ExperimentStats bstStats = new ExperimentStats();

        for (List<String> list : dataList) {
            int insertions = vaccineAVL.insert(new VaccinationEntry(list));
            avlInsertionStats.record(insertions);
        }

        for (List<String> list : dataList) {
            int comparisons = vaccineAVL.findComparisons(list.get(0), list.get(1));
            avlSearchStats.record(comparisons);
            comparisons = vaccineBST.findComparisons(list.get(0), list.get(1));
            bstStats.record(comparisons);
        }

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.format("AVL Insert: %s%n",
        avlInsertionStats.toString()));

        stringBuffer.append(String.format("AVL Search: %s%n",
        avlSearchStats.toString()));
        stringBuffer.append(String.format("BST Search: %s%n",
        bstStats.toString()));

        stringBuffer.append("\n");

        return stringBuffer.toString();
    }

    /**
     * Randomise the datalist to the given degrere
     *
     * @param dataList the list to randomise
     * @param degree   the extent to which the data should be randomised. If degree
     *                 is less than 0, a value of 0 is used. If the degree is
     *                 greater than 100 a value of 100 is used. I.e `0<= degree <=`
     *                 100
     * @return A randomised list
     */
    public static List<List<String>> randomiseList(List<List<String>> dataList, int degree) {
        int randomisation = degree;
        if (randomisation > 100) {
            randomisation = 100;
        }

        int endIndex = randomisation > 0 ? dataList.size() / (100 / randomisation) : 0;

        List<List<String>> shufledSubList = dataList.subList(0, endIndex);
        Collections.shuffle(shufledSubList);
        List<List<String>> restOfList = dataList.subList(endIndex, dataList.size());

        shufledSubList.addAll(restOfList);
        return shufledSubList;
    }
}
