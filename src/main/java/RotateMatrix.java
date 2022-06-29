import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

/**
 * Created by sushantshambharkar on 29/06/22.
 */
public class RotateMatrix {
    public static void main(String[] args) throws IOException {
        try (Reader reader = Files.newBufferedReader(Paths.get(args[0]));) {
            CsvToBean<CSVBean> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CSVBean.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            readBeansOneByOne(csvToBean);
        }
    }

    // Read and write row by row
    private static void readBeansOneByOne(CsvToBean csvToBean) {
        Iterator<CSVBean> csvBeanIterator = csvToBean.iterator();
        System.out.println("id,json,is_valid");
        csvBeanIterator.next();
        while (csvBeanIterator.hasNext()) {
            CSVBean csvBean = csvBeanIterator.next();
            csvBean.setIsValid(Utils.validateJson(csvBean.getJson()));
            if (csvBean.getIsValid()) {
                csvBean.setJson(Utils.rotateJson(csvBean.getJson()));
            } else {
                csvBean.setJson("\"[]\"");
            }
            System.out.println(csvBean);
        }
    }

}
