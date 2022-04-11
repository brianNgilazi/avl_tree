import java.util.List;

/**
 * Class representing a Vaccination entry
 */
public class VaccinationEntry implements Comparable<VaccinationEntry> {
    /**
     * The name of the country
     */
    public String country;

    /**
     * The date in the format yyy-mm-dd
     */
    public String date;
    /**
     * The numbr of people vaccinated
     */
    public String vaccinated;

    /**
     * The key to identify the entry.
     * The key is a combination of the country and date i.e country + date
     */
    public String key;

    /**
     * Create a Vaccination entry from the provided data.
     * The first and second elements of the list must be the country and date
     * respectively.
     * The third element should be the number of people vaccinated in that country
     * on the given date. If not provided vaccinated is set to "No Data"
     *
     * @param data
     */
    public VaccinationEntry(List<String> data) {
        this(data.get(0), data.get(1));
        if (data.size() == 3) {
            vaccinated = data.get(2);
        }

    }

    public VaccinationEntry(String country, String date) {
        this.country = country;
        this.date = date;
        key = country + date;
        this.vaccinated = "No Data";
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", country, date, vaccinated);
    }



    @Override
    public int compareTo(VaccinationEntry o) {
        return this.key.compareTo(o.key);
    }
}
