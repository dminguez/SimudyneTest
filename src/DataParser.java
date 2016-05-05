import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import pojo.Policy;

import java.io.File;
import java.io.FileInputStream;
import java.util.Map;
import java.util.HashMap;

public class DataParser {

    private int numberOfColumns = 0;
    private String dataFileRoot = null;

    public DataParser(String dataFileRoot) {
        this.dataFileRoot = dataFileRoot;
    }

    public Map<Long, Policy> parseData() {

        Map<Long, Policy> policies = new HashMap<>();

        try {
            File excel = new File(dataFileRoot);
            FileInputStream fis = new FileInputStream(excel);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet ws = wb.getSheet("Sheet1");

            int rowNum = ws.getLastRowNum() + 1;
            numberOfColumns = ws.getRow(0).getLastCellNum();

            for (int i = 1; i < rowNum; i++) {
                XSSFRow row = ws.getRow(i);

                Policy policy = parsePolicyRow(row);
                policies.put(policy.getId(), policy);
            }
        }
        catch(Exception e) {
            System.out.println(e.getMessage());
        }

        return policies;
    }

    private Policy parsePolicyRow(XSSFRow row) {
        Policy policy = new Policy();

        for (int iterator = 0; iterator < numberOfColumns; iterator++) {
            XSSFCell cell = row.getCell(iterator);
            String cellValue = cell.getRawValue();

            switch (iterator) {
                case 0:
                    policy.setBreed(cell.toString());
                    break;
                case 1:
                    policy.setId(Long.valueOf(cellValue));
                    break;
                case 2:
                    policy.setAge(Integer.valueOf(cellValue));
                    break;
                case 3:
                    policy.setSocialGrade(Integer.valueOf(cellValue));
                    break;
                case 4:
                    policy.setPaymentAtPurchase(Integer.valueOf(cellValue));
                    break;
                case 5:
                    policy.setBrand(Double.valueOf(cellValue));
                    break;
                case 6:
                    policy.setPrice(Double.valueOf(cellValue));
                    break;
                case 7:
                    policy.setPromotions(Double.valueOf(cellValue));
                    break;
                case 8:
                    policy.setAutoRenew(Integer.valueOf(cellValue));
                    break;
                case 9:
                    policy.setInertiaForSwitch(Integer.valueOf(cellValue));
                    break;
            }
        }

        return policy;
    }
}
