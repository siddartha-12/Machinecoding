package parkinglot;

public class LotManager {
    private Lot lot;
    LotManager(Lot lot){
        this.lot = lot;
    }
    public Position parkVechile(Vechile vechile){
        return this.lot.park(vechile);
    }
    public void unparkVechile(Vechile vechile){
        this.lot.unpark(vechile);
    }
    public int getTotalOccupiedSlotsPerFloor(int floor)
    {
        return this.lot.getFreeSlotsForFloor(floor);
    }
    public void printEmptySlots(int floor)
    {
        lot.printFreeSlotsForFloor(floor);
    }
    public void printOccupiesSlots(int floor)
    {
        lot.printOccupiedSlotsForFloor(floor);
    }
}
