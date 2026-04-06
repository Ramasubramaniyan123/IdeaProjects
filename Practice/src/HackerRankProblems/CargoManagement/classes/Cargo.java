package HackerRankProblems.CargoManagement.classes;

import HackerRankProblems.CargoManagement.interfaces.IPackage;
import HackerRankProblems.CargoManagement.interfaces.IShipping;

import java.util.*;

public class Cargo implements IShipping {
    private List<IPackage> packages = new ArrayList<>();

    @Override
    public void addPackage(IPackage pack) {
        packages.add(pack);
    }

    @Override
    public void removePackage(int id) {
        for (IPackage p : packages) {
            if (p.getId() == id) {
                packages.remove(p);
                break;
            }
        }
    }

    @Override
    public int calculateTotalCost() {
        int cost = 0;
        for (IPackage p : packages) {
            cost += getCost(p);
        }
        return cost;
    }

    @Override
    public Map<String, Integer> categoryPrices() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Small", 0);
        map.put("Medium", 0);
        map.put("Large", 0);
        for (IPackage p : packages) {
            String category = getCategory(p);
            int cost = getCost(p);
            map.put(category, map.get(category) + cost);
        }
        return map;
    }

    @Override
    public Map<String, Integer> packageList() {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (IPackage p : packages) {
            map.put(p.getName(), map.getOrDefault(p.getName(), 0) + 1);
        }
        return map;
    }

    private int getCost(IPackage p) {
        int volume = p.getHeight() * p.getLength() * p.getWidth();
        if (volume <= 100000) return 10;
        else if (volume <= 500000) return 20;
        return 30;
    }

    private String getCategory(IPackage p) {
        if (p.getWeight() <= 1 && p.getLength() <= 30 && p.getWidth() <= 30 && p.getHeight() <= 30) {
            return "Small";
        } else if (p.getWeight() <= 3 && p.getLength() <= 60 && p.getWidth() <= 60 && p.getHeight() <= 60) {
            return "Medium";
        }
        return "Large";
    }
}
