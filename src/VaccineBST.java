import java.util.List;

public class VaccineBST {
    private BinarySearchTree<VaccinationEntry> bst;


    /**
     * Create a Vaccination BST and populate it with the provided data
     * @param data the parsed csv data
     */
    public VaccineBST(List<List<String>> data){
        bst = new BinarySearchTree<>();
        for(int i =0; i < data.size(); i++){
            bst.insert(new VaccinationEntry(data.get(i)));
        }
    }

    /**
     * Find number of vaccinations for an entry with the given key
     * @return the number of vaccinations or <Not Found>
     */
    public String find(String country, String date){
        VaccinationEntry query = new VaccinationEntry(country,date);
        BinaryTreeNode<VaccinationEntry> node = bst.find(query);
        if(node != null){
            return node.data.vaccinated;
        }
        return "<Not Found>";

    }

    /**
     * Find number of comparisons made for a search
     * @return the number of vomparisons made
     */
    public int findComparisons(String country, String date){
        VaccinationEntry query = new VaccinationEntry(country,date);
        bst.find(query);
        int comparisons = bst.comparisons;
        bst.comparisons = 0;
        return comparisons;

    }
}
