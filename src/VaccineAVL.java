
public class VaccineAVL {
    private AVLTree<VaccinationEntry> avlTree;

    /**
     * Create a Vaccination AVL
     */
    public VaccineAVL() {
        avlTree = new AVLTree<>();

    }

    public int insert(VaccinationEntry entry) {
        avlTree.insertComparisons = 0;
        avlTree.insert(entry);
        return avlTree.insertComparisons;
    }

    /**
     * Find number of vaccinations for an entry with the given key
     * 
     * @return the number of vaccinations or <Not Found>
     */
    public String find(String country, String date) {
        VaccinationEntry query = new VaccinationEntry(country, date);
        BinaryTreeNode<VaccinationEntry> node = avlTree.find(query);
        if (node != null) {
            return node.data.vaccinated;
        }
        return "<Not Found>";

    }

    /**
     * Find number of comparisons made for a search
     * 
     * @return the number of comparisons made
     */
    public int findComparisons(String country, String date) {
        VaccinationEntry query = new VaccinationEntry(country, date);
        avlTree.find(query);
        int comparisons = avlTree.findComparisons;
        avlTree.findComparisons = 0;
        return comparisons;

    }
}
