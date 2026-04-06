package HackerRankProblems.HelpDeskTicketProcessing.classes;

import HackerRankProblems.HelpDeskTicketProcessing.interfaces.IEmployee;
import HackerRankProblems.HelpDeskTicketProcessing.interfaces.IHelpDesk;
import HackerRankProblems.HelpDeskTicketProcessing.interfaces.ITicket;

import java.util.ArrayList;
import java.util.List;

public class HelpDesk implements IHelpDesk {
    List<IEmployee> employees;
    List<ITicket> tickets;
    public HelpDesk() {
        employees = new ArrayList<>();
        tickets = new ArrayList<>();
    }

    @Override
    public void addTicket(ITicket ticket) {
        tickets.add(ticket);
    }

    @Override
    public void addEmployee(IEmployee employee) {
        employees.add(employee);
    }

    @Override
    public void completeTicket(String employeeFullName, int ticketId) {
        IEmployee employee=null;
        for(IEmployee e:employees){
            if(e.getFullName().equals(employeeFullName)){
                employee=e;
                break;
            }
        }
        ITicket ticket=null;
        for(ITicket e:tickets){
            if(e.getId()==ticketId){
                ticket=e;
                break;
            }
        }
        if (employee == null ||  ticket == null) {
            return;
        }
        if(ticket.getIsCompleted()){
            return;
        }
        if(employee.getPointLevel()<ticket.getPoint()){
            return;
        }
        if(!employee.getAssignedCategories().contains(ticket.getCategory())){
            return;
        }
        ticket.setIsCompleted(true);
        ticket.setAssignedEmployee(employee.getFullName());
    }

    @Override
    public int getWaitingTicketCount() {
        int count=0;
        for(ITicket ticket:tickets){
            if(!ticket.getIsCompleted()){
                count++;
            }
        }
        return count;
    }

    @Override
    public int getCompletedTicketsTotalPoint() {
        int sum=0;
        for(ITicket ticket:tickets){
            if(ticket.getIsCompleted()){
                sum+=ticket.getPoint();
            }
        }
        return sum;
    }

    @Override
    public List<CategoryNode> getTicketsTotalPointByCategory() {
        List<CategoryNode> nodes=new ArrayList<>();
        for(Category category:Category.values()){
            int sum=0;
            for(ITicket ticket:tickets){
                if(ticket.getCategory().equals(category)){
                    sum+=ticket.getPoint();
                }
            }
            CategoryNode categoryNode=new CategoryNode(category,sum);
            nodes.add(categoryNode);
        }
        return nodes;
    }

    @Override
    public List<EmployeeNode> getTicketsTotalPointByEmployee() {
        List<EmployeeNode> nodes=new ArrayList<>();
        for(IEmployee employee:employees){
            int sum=0;
            for(ITicket ticket:tickets){
                if(ticket.getIsCompleted()&&employee.getFullName().equals(ticket.getAssignedEmployee())){
                    sum+=ticket.getPoint();
                }
            }
            EmployeeNode employeeNode=new EmployeeNode(employee,sum);
            nodes.add(employeeNode);
        }
        return nodes;
    }
}
