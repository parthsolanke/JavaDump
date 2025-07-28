package core;

import java.text.DecimalFormat;

public class Dashboard {
    private OrderManager orderManager;

    public Dashboard(OrderManager orderManager) {
        this.orderManager = orderManager;
    }

    public void printDashboard() {
        DecimalFormat df = new DecimalFormat("₹#,##0.00");

        double revenue = orderManager.getTotalRevenue();
        double avgOrder = orderManager.getAvgOrerVlalue();
        int vegCount = orderManager.getTotalTypeItemsSold(Type.VEG);
        Type popular = orderManager.getMostPopularCategory();

        StringBuilder sb = new StringBuilder();
        sb.append("===============      STARBUCKS STORE DASHBOARD      ==============\n");
        sb.append("💰 Total Revenue: ").append(df.format(revenue)).append("\n");
        sb.append("🧾 Average Order Value: ").append(df.format(avgOrder)).append("\n");
        sb.append("🌿 Total Vegetarian Items Sold: ").append(vegCount).append("\n");
        sb.append("📚 Most Popular Category: ").append(getTypeLabel(popular)).append("\n");
        sb.append("==================================================================");

        System.out.println(sb.toString());
    }

    private String getTypeLabel(Type type) {
        return switch (type) {
            case VEG -> "Vegetarian";
            case NON_VEG -> "Non-Vegetarian";
            case BEVRAGE -> "Hot Beverage";
        };
    }
}