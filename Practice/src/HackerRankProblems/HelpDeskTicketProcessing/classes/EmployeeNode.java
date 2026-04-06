package HackerRankProblems.HelpDeskTicketProcessing.classes;

import HackerRankProblems.HelpDeskTicketProcessing.interfaces.IEmployee;

public class EmployeeNode {
    IEmployee employee;
    int totalPoint;
    EmployeeNode(IEmployee employee, int totalPoint){
        this.employee = employee;
        this.totalPoint = totalPoint;
    }
}
