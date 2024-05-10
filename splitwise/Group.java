package splitwise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Group {
    private int id;
    private String name;
    private String description;

    public List<User> getUsers() {
        return users;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Map<Integer, Map<Integer, Integer>> getUserBalancesMapping() {
        return userBalancesMapping;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    private List<User> users;
    private Map<Integer, Map<Integer,Integer>> userBalancesMapping;
    private List<Expense> expenses;
    public Group(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.users = new ArrayList<>();
        this.userBalancesMapping = new HashMap<>();
        this.expenses = new ArrayList<>();
    }

    public void addUser(User user){
        if(userBalancesMapping.get(user.getId())==null)
        {
            userBalancesMapping.put(user.getId(), new HashMap<>());
            users.add(user);
        }
    }
    public void addExpense(Expense expense)
    {
        this.expenses.add(expense);
    }

}
