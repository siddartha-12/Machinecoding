package parkinglot;

public interface Lot {
    public int getTotalEmptySlots();
    public void printFreeSlotsForFloor(int floor);
    public void printOccupiedSlotsForFloor(int floor);
    public int getFreeSlotsForFloor(int floor);
    public Position park(Vechile vechile);
    public void unpark(Vechile vechile);
}
