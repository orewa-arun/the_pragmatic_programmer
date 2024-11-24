package billCounter.domain;

// Singleton pattern
public class BillCounter {
    private double totalBalance;
    private static BillCounter billCounterInstance;
    
    private BillCounter(){
        totalBalance = 0;
    }

    public double getTotalBalance() {
        return totalBalance;
    }

    public static boolean add(double amount) {
        if (billCounterInstance != null) {
            billCounterInstance.totalBalance += amount;
            return true;
        }    

        return false;
    }

    public static BillCounter getBillCounter() {
        if (billCounterInstance == null) {
            billCounterInstance = new BillCounter();
        }

        return billCounterInstance;
    }
}
