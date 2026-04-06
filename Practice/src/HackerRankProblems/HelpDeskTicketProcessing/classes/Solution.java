package HackerRankProblems.HelpDeskTicketProcessing.classes;

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

        HelpDesk hd = new HelpDesk();

        int eCount = Integer.parseInt(reader.readLine().trim());

        for (int i = 1; i <= eCount; i++) {
            String[] a = reader.readLine().trim().split(",");
            List<Category> eCa = new ArrayList<>();
            for (String cc: a[2].split(" ")) {
                eCa.add(Category.valueOf(cc));
            }
            Employee e = new Employee(a[0], Integer.parseInt(a[1]), eCa);
            hd.addEmployee(e);
        }

        int tCount = Integer.parseInt(reader.readLine().trim());

        for (int i = 1; i <= tCount; i++) {
            String[] a = reader.readLine().trim().split(",");
            Ticket t = new Ticket(Integer.parseInt(a[0]), a[1], Category.valueOf(a[2]), Integer.parseInt(a[3]));
            hd.addTicket(t);
        }

        int pCount = Integer.parseInt(reader.readLine().trim());

        for (int i = 1; i <= pCount; i++) {
            String[] a = reader.readLine().trim().split(",");
            hd.completeTicket(a[0], Integer.parseInt(a[1]));
        }

        writer.println("WaitingTicketCount:" + hd.getWaitingTicketCount());
        writer.println("CompletedTicketsTotalPoint:" + hd.getCompletedTicketsTotalPoint());
        writer.println("TicketsTotalPointByCategory:");

        for (CategoryNode item: hd.getTicketsTotalPointByCategory()) {
            writer.println(item.category.toString() + ":" + item.totalPoint);
        }

        writer.println("TicketsTotalPointByEmployee:");

        for (EmployeeNode item: hd.getTicketsTotalPointByEmployee()) {
            writer.println(item.employee.getFullName() + ":" + item.totalPoint);
        }

        writer.close();
        reader.close();
    }
}