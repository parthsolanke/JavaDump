package app.splitwise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Splitwise {
    private HashMap<String, Float> spending;

    public Splitwise(String name, float amount) {
        this.spending = new HashMap<>();
        this.spending.put(name, amount);
    }

    public void addSpending(String name, float amount) {
        float currAmount = this.spending.getOrDefault(name, 0.0f);
        this.spending.put(name, currAmount + amount);
    }

    public String showSpending() {
        StringBuilder result = new StringBuilder();
        for (String name: spending.keySet()) {
            float amount = spending.get(name);
            result
            .append(name)
            .append(": ")
            .append(String.format("%.2f", amount))
            .append("\n");
        }
        return result.toString();
    }

    private HashMap<String, Float> computeNet() {
        float total = 0.0f;
        for (float amount : spending.values()) {
            total += amount;
        }

        int n = spending.size();
        float share = total / n;
        HashMap<String, Float> net = new HashMap<>();
        for (Map.Entry<String, Float> entry: spending.entrySet()) {
            String name = entry.getKey();
            float amount = entry.getValue();
            net.put(name, (Math.round((amount - share) * 100.0f) / 100.0f));
        }

        return net;
    }

    private Map<String, List<PersonAmount>> getCreditorsDebitors() {
        HashMap<String, Float> net = computeNet();

        List<PersonAmount> creditors = new ArrayList<>();
        List<PersonAmount> debitors = new ArrayList<>();

        for (Map.Entry<String, Float> entry: net.entrySet()) {
            String name = entry.getKey();
            float amount = entry.getValue();

            if (amount > 0) {
                creditors.add(new PersonAmount(name, amount));
            } else if ( amount < 0) {
                debitors.add(new PersonAmount(name, -amount));
            }
        }

        Map<String, List<PersonAmount>> result = new HashMap<>();
        result.put("creditors", creditors);
        result.put("debitors", debitors);

        return result;

    }

    public List<String> getSettlements() {
        Map<String, List<PersonAmount>> netParties = getCreditorsDebitors();
        List<PersonAmount> creditors = netParties.get("creditors");
        List<PersonAmount> debitors = netParties.get("debitors");

        List<String> settlements = new ArrayList<>();
        int i = 0, j = 0; // cred idx (i), deb idx (j)
        while (i < creditors.size() && j < debitors.size()) {
            PersonAmount creditor = creditors.get(i);
            PersonAmount debitor = debitors.get(j);

            float amountToSettle = Math.min(creditor.amount, debitor.amount);
            settlements.add(String.format("%s -> %s: %.2f", debitor.name, creditor.name, amountToSettle));

            creditor.amount -= amountToSettle;
            debitor.amount -= amountToSettle;

            if (Math.abs(debitor.amount) < 0.001) {
                j++;
            }
            if (Math.abs(creditor.amount) < 0.001) {
                i++;
            }

        }
        
        return settlements;
    }
    
}