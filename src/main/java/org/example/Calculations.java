package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calculations {
    private static double totalRevenue = 0.0;
    private static double totalProfit = 0.0;
    private static Map<String, Double> totalPerSizeProfitMap;

    public static void calculate(List<Order> customerOrdersList, Map<String, List<Order>> customerOrdersBySizeMap) {
        totalRevenue = calculateTotalRevenue(customerOrdersList);
        totalProfit = calculateTotalProfit(customerOrdersList);
        totalPerSizeProfitMap = calculateTotalPerSizeProfit(customerOrdersBySizeMap);
    }

    private static Map<String, Double> calculateTotalPerSizeProfit(Map<String, List<Order>> customerOrdersBySizeMap) {
        Map<String, Double> totalPerSizeProfitMap = new HashMap<>();

        customerOrdersBySizeMap.keySet().stream().forEach(key -> totalPerSizeProfitMap.put(key, calculateProfit(customerOrdersBySizeMap.get(key))));

        return totalPerSizeProfitMap;
    }

    private static Double calculateTotalProfit(List<Order> customerOrdersList){
        return calculateProfit(customerOrdersList);
    }

    private static Double calculateProfit(List<Order> customerOrdersList) {
        return Math.round(customerOrdersList.stream().map(order -> new PaymentContext(order.getPayment())
                .processTransaction(40)-(order.getWithDesign() ? 2 : 0)-(order.getWithHoodie() ? 3 : 0)-14).reduce(0.0, Double::sum)*100)/100.0;
    }

    private static Double calculateTotalRevenue(List<Order> customerOrdersList) {
        return Math.round(customerOrdersList.stream().map(order -> 40.0).reduce(0.0, Double::sum)*100)/100.0;
    }

    public static double getTotalRevenue() {
        return totalRevenue;
    }

    public static double getTotalProfit() {
        return totalProfit;
    }

    public static Map<String, Double> getTotalPerSizeProfitMap() {
        return totalPerSizeProfitMap;
    }
}
