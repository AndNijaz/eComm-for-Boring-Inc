package org.example;

import javax.sound.midi.Soundbank;
import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Order> customerOrdersList = new ArrayList<>();
        Map<String, List<Order>> customerOrdersBySizeMap = new HashMap<>();

        customerOrdersList = readCustomerOrdersFile("C:\\Users\\andel\\Desktop\\Assigment3\\eCommBoringInc\\src\\main\\java\\customer_orders.csv");
        customerOrdersBySizeMap = parseOrdersBySize(customerOrdersList);

        Calculations.calculate(customerOrdersList, customerOrdersBySizeMap);

        Report revenueReport = new Report("Revenue");
        Report profitReport = new Report("Profit");
        Report profitPerShirtSizeReport = new Report("ProfitPerShirtSize");

        revenueReport.start();
        profitReport.start();
        profitPerShirtSizeReport.start();

        try {
            revenueReport.join();
            profitReport.join();
            profitPerShirtSizeReport.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }

    private static Map<String, List<Order>> parseOrdersBySize(List<Order> customerOrdersList) {
       return customerOrdersList.stream().collect(Collectors.groupingBy(Order::getShirtSize));
    }

    private static ArrayList<Order> readCustomerOrdersFile(String filePath) {
        ArrayList<Order> customerOrdersList = new ArrayList<>();

        File customerOrders = new File(filePath);

        try {
            Scanner s = new Scanner(customerOrders);

            if(s.hasNextLine()) s.nextLine();

            while(s.hasNextLine()){
                String line = s.nextLine();
                String[] lineParts = line.split(",");
                customerOrdersList.add(new Order(lineParts[0], lineParts[1], Boolean.parseBoolean(lineParts[2]), Boolean.parseBoolean(lineParts[3]), lineParts[4]));
            }
        } catch(Exception e){
            e.printStackTrace();
        }

        return customerOrdersList;
    }
}