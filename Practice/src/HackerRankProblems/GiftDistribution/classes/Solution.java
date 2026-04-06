package HackerRankProblems.GiftDistribution.classes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.getenv("OUTPUT_PATH"), "UTF-8");
        List<Gift> gifts = new ArrayList<>();
        List<Employee> employees = new ArrayList<>();
        Company company = new Company();

        int n = Integer.parseInt(reader.readLine().trim());

        for (int i = 0; i < n; i++) {
            String[] a = reader.readLine().trim().split(" ");
            if (a[0].equals("1")) {
                gifts.add(new Laptop(a[1]));
            } else if (a[0].equals("2")) {
                gifts.add(new MobilePhone(a[1]));
            } else if (a[0].equals("3")) {
                gifts.add(new ShoppingGiftCard(a[1]));
            }
        }

        for (Gift item : gifts) {
            company.addGift(item);
        }

        int employeeCount = Integer.parseInt(reader.readLine().trim());

        for (int i = 0; i < employeeCount; i++) {
            employees.add(new Employee(reader.readLine().trim()));
        }

        boolean giftsAvailable = true;
        int p = 0;
        do {
            Gift g = company.giveaway();
            if (g == null) {
                giftsAvailable = false;
            }
            employees.get(p % employees.size()).winGift(g);
            p++;
        } while (giftsAvailable);

        writer.println("Laptop:" + company.getLaptopCount());
        writer.println("MobilePhone:" + company.getMobilePhoneCount());
        writer.println("ShoppingGiftCard:" + company.getShoppingGiftCardCount());

        for (Employee item : employees) {
            writer.println(item.getName());
            for (String g : item.getOwnedGiftNames()) {
                writer.println(g);
            }
        }

        writer.close();
    }
}
