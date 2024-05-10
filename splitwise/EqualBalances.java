package splitwise;
import java.util.Map;

public class EqualBalances {
    public EqualBalances(Group group) {
        this.group = group;
    }

    Group group;
    public void adjustBalances(Expense expense){
        int equalAmount = expense.getAmount()/(expense.getUsersToBeIncluded().size());
        Map<Integer,Integer> paidByUserBalances = this.group.getUserBalancesMapping().get(expense.getPaidBy());
        for(Integer userId : expense.getUsersToBeIncluded())
        {
            if(userId == expense.getPaidBy())
                continue;
            Map<Integer,Integer>  userBalances = this.group.getUserBalancesMapping().get(userId);
            if(paidByUserBalances.get(userId) != null)
            {
                int amountToBePaid = paidByUserBalances.get(userId);
                if(amountToBePaid==0)
                {
                    if(userBalances.get(expense.getPaidBy()) == null)
                    {
                        userBalances.put(expense.getPaidBy(),0);
                    }
                    userBalances.put(expense.getPaidBy(),userBalances.get(expense.getPaidBy())+equalAmount);
                }
                else if(amountToBePaid==equalAmount)
                {
                    paidByUserBalances.put(userId,0);
                }
                else if(amountToBePaid< equalAmount)
                {
                    int remainingAmount = equalAmount-amountToBePaid;
                    paidByUserBalances.put(userId,0);
                    if(userBalances.get(expense.getPaidBy()) == null)
                    {
                        userBalances.put(expense.getPaidBy(),0);
                    }
                    userBalances.put(expense.getPaidBy(),userBalances.get(expense.getPaidBy())+remainingAmount);
                }
                else
                {
                    int remainingAmount = amountToBePaid - equalAmount;
                    paidByUserBalances.put(userId,remainingAmount);
                }

            }
            else {
                if(userBalances.get(expense.getPaidBy()) == null)
                {
                    userBalances.put(expense.getPaidBy(),0);
                }
                userBalances.put(expense.getPaidBy(),userBalances.get(expense.getPaidBy())+equalAmount);
            }

        }

    }

}
