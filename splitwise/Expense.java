package splitwise;

import java.util.List;

public class Expense {
    private int id;
    private  String description;

    public Expense(int id, String description, int amount, Integer paidBy, List<Integer> usersToBeIncluded) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.paidBy = paidBy;
        this.usersToBeIncluded = usersToBeIncluded;
    }

    private int amount;
    private Integer paidBy;
     private List<Integer> usersToBeIncluded;

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public int getAmount() {
        return amount;
    }

    public Integer getPaidBy() {
        return paidBy;
    }

    public List<Integer> getUsersToBeIncluded() {
        return usersToBeIncluded;
    }
}
