package splitwise;

import java.util.Map;

public class SplitManager {
    private Group group;
    private EqualBalances equalBalances;
    SplitManager(Group group)
    {
        this.group = group;
        this.equalBalances = new EqualBalances(this.group);
    }
    public void addExpense(Expense expense)
    {
        this.group.addExpense(expense);
        this.equalBalances.adjustBalances(expense);
    }
    public void showBalancesOfUser(Integer userId)
    {
        System.out.println("Balances of a user "+userId);
        Map<Integer,Integer> userBalances = this.group.getUserBalancesMapping().get(userId);
        for(Map.Entry<Integer,Integer> userBalance: userBalances.entrySet()){
            if(userBalance.getValue()>0) {
                System.out.println("   "+userBalance.getKey()+" "+userBalance.getValue());
            }
    }
    }
    public void showExpenses(Integer userId)
    {
        System.out.println("Expenses for user "+userId);
        this.group.getExpenses().stream()
                .filter((expense)->expense.getPaidBy()==userId)
                .forEach((expense -> {
                    System.out.println("   "+expense.getDescription()+" "+expense.getAmount());
                }));
    }
    public void showBalances()
    {
        this.group.getUsers().stream().forEach((user -> showBalancesOfUser(user.getId())));
    }
    public Integer totalExpense(Integer userId)
    {
        return this.group.getExpenses().stream()
                .filter((expense -> expense.getPaidBy()==userId))
                .map(expense->expense.getAmount())
                .reduce(0,(prev,curr)->prev+curr).intValue();
    }
    public Integer totalAmountGetBack(Integer userId)
    {
        int totalGetAmount = 0;
        int totalNeedToPay = 0;
        for(Map.Entry<Integer,Integer> userBalance:this.group.getUserBalancesMapping().get(userId).entrySet())
        {
            totalNeedToPay+=userBalance.getValue();
        }
        for(User user: this.group.getUsers())
        {
            if(user.getId()!=userId) {
                Map<Integer, Integer> userBalance = this.group.getUserBalancesMapping().get(user.getId());
                totalGetAmount+=userBalance.getOrDefault(userId,0);
            }
        }
        return totalGetAmount - totalNeedToPay;
    }

}
