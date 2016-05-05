import pojo.Policy;
import pojo.ProcessResult;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private static Map<Long, Policy> policies = new HashMap<>();

    private static final Integer yearsToProcess = 15;
    private static final Double brandFactor = 0.9;
    private static final String dataFileRoot = "E:\\Descargas\\AgentTest.xlsx";
    private static final String fileToPrintResultsRoot = "agents.csv";

    public static void main(String [ ] args) {
        /*
         * 1. Parse the input data and store it in memory
         */

        DataParser dataParser = new DataParser(dataFileRoot);
        policies = dataParser.parseData();

        /*
         * 2. Process the data
         */

        Processor processor = new Processor(yearsToProcess, brandFactor);
        ProcessResult result = processor.processData(policies);

        /*
         * 3. Display the final results
         */

        System.out.println(result.toString());
        printPoliciesToExternalFile();
    }

    private static void printPoliciesToExternalFile() {
        try {
            PrintWriter writer = new PrintWriter(fileToPrintResultsRoot, "UTF-8");

            writer.println("Agent_Breed,Policy_ID,Age,Social_Grade,Payment_at_Purchase,Attribute_Brand," +
                    "Attribute_Price,Attribute_Promotions,Auto_Renew,Inertia_for_Switch");

            for (Policy policy : policies.values()) {
                writer.println(policy.toString());
            }

            writer.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
