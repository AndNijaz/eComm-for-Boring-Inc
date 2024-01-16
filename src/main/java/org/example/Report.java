package org.example;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.FileWriter;
import java.util.*;

public class Report extends Thread {

    private String report;
    public Report(String report){this.report = report;}

    @Override
    public void run() {
        switch (report) {
            case "Revenue":
                generateRevenueReport(Calculations.getTotalRevenue());
                break;
            case "Profit":
                generateProfitReport(Calculations.getTotalProfit());
                break;
            case "ProfitPerShirtSize":
                generateProfitPerShirtSizeReport(Calculations.getTotalPerSizeProfitMap());
                break;
            default:
                System.out.println("This type of report (" + report + ") does not exist.");
        }
    }

    private static void generateRevenueReport(double totalRevenue) {
        generateReport("Revenue", "Total Revenue: " + totalRevenue + "$");
    }
    private static void generateProfitReport(double totalProfit) {
        generateReport("Profit", "Total Profit: " + totalProfit + "$");
    }
    private static void generateProfitPerShirtSizeReport(Map<String, Double> totalPricePerShirtSize) {
        List<String> sizeOrder = Arrays.asList("XS", "S", "M", "L", "XL", "2XL", "3XL");

        Map<String, Double> sortedMap = new LinkedHashMap<>();

        for (String size : sizeOrder) {
            if (totalPricePerShirtSize.containsKey(size)) {
                sortedMap.put(size, totalPricePerShirtSize.get(size));
            }
        }

        StringBuilder content = new StringBuilder("Total Profit per Shirt Size:\n");
        sortedMap.forEach((key, value) -> content.append(key).append(": ").append(value).append("$").append("\n"));

        generateReport("ProfitPerShirtSize", content.toString());
    }

    private static void generateReport(String report, String content) {
        try {
            FileWriter writer = new FileWriter(report + " Report.txt");
            writer.write(content);
            writer.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
