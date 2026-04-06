package HackerRankProblems.HelpDeskTicketProcessing.classes;

import HackerRankProblems.HelpDeskTicketProcessing.interfaces.ITicket;

public class Ticket implements ITicket {
    int id;
    String name;
    Category category;
    int point;
    String assignedEmployee;
    boolean isCompleted;
    public Ticket(int id, String name, Category category, int point) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.point = point;
        this.isCompleted = false;
        this.assignedEmployee = null;
    }

    @Override
    public void setId(int id) {
        this.id=id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setName(String name) {
        this.name=name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setCategory(Category category) {
            this.category = category;
    }

    @Override
    public Category getCategory() {
        return category;
    }

    @Override
    public void setPoint(int point) {
        this.point=point;
    }

    @Override
    public int getPoint() {
        return point;
    }

    @Override
    public void setIsCompleted(boolean isCompleted) {
            this.isCompleted=isCompleted;
    }

    @Override
    public boolean getIsCompleted() {
        return isCompleted;
    }

    @Override
    public void setAssignedEmployee(String assignedEmployee) {
        this.assignedEmployee=assignedEmployee;
    }

    @Override
    public String getAssignedEmployee() {
        return assignedEmployee;
    }
}
