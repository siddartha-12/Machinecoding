package splitwise;

import java.util.List;

public class Client {
    public static void main(String[] args) {


        Group group = new Group(1, "Coorg", "Coorg expenses");
        User user1 = new User("siddhu", 1, "29864984", "po@gamil.com");
        User user2 = new User("siddhu", 2, "29864984", "po@gamil.com");
        User user3 = new User("siddhu", 3, "29864984", "po@gamil.com");
        group.addUser(user1);
        group.addUser(user2);
        group.addUser(user3);
        SplitManager splitManager = new SplitManager(group);
        Expense expense1 = new Expense(1,"Food",30,1, List.of(1,2,3));
        splitManager.addExpense(expense1);
        //splitManager.showBalances();
        System.out.println("");
        Expense expense2 = new Expense(2,"Juice",30,1, List.of(2,1));
        splitManager.addExpense(expense2);
        //splitManager.showBalances();
        System.out.println("");
        Expense expense3 = new Expense(3,"clothes",20,3, List.of(1,2));
        splitManager.addExpense(expense3);
        splitManager.showBalances();
        //splitManager.showExpenses(user1.getId());
        //System.out.println(splitManager.totalExpense(user1.getId()));
        System.out.println(splitManager.totalAmountGetBack(user1.getId()));
    }
}
