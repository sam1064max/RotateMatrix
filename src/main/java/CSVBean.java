import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

/**
 * Created by sushantshambharkar on 29/06/22.
 */
public class CSVBean {
    @CsvBindByName(column = "id", required = true)
    @CsvBindByPosition(position = 0)
    private String id;

    @CsvBindByName(column = "json")
    @CsvBindByPosition(position = 1)
    private String json;

    @CsvBindByName(column = "is_valid")
    private boolean is_valid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public boolean getIsValid() {
        return is_valid;
    }

    public void setIsValid(boolean is_valid) {
        this.is_valid = is_valid;
    }

    @Override
    public String toString()
    {
       return id + "," + json + "," + is_valid;
    }
}
