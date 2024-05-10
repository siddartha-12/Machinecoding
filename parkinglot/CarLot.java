package parkinglot;

import java.util.HashMap;
import java.util.Map;

public class CarLot implements Lot{
    private int startSlot;
    private int endSlot;
    private int totalFloors;
    private Vechile[][] lot;
    private int occupiedSlots;
    private int[] totalOccupedSlotsForFloor;
    private Map<Vechile,Position> vechileMapping;
    public CarLot(int startSlot, int endSlot, int totalFloors) {
        this.startSlot = startSlot;
        this.endSlot = endSlot;
        this.totalFloors = totalFloors;
        this.lot = new Vechile[totalFloors][endSlot-startSlot+1];
        this.occupiedSlots = 0;
        this.totalOccupedSlotsForFloor = new int[totalFloors];
        this.vechileMapping = new HashMap<>();
    }

    @Override
    public int getTotalEmptySlots() {
        return this.occupiedSlots;
    }

    @Override
    public void printFreeSlotsForFloor(int floor) {
        System.out.println("Free slots in floor "+floor);
        for(int i=0;i< endSlot-startSlot+1;i++)
        {
            if(this.lot[floor][i]==null)
                System.out.print(startSlot+i);
        }
    }

    @Override
    public void printOccupiedSlotsForFloor(int floor) {
        System.out.println("Occupied slots in floor "+floor);
        for(int i=0;i< endSlot-startSlot+1;i++)
        {
            if(this.lot[floor][i]!=null)
                System.out.print(startSlot+i);
        }

    }

    @Override
    public int getFreeSlotsForFloor(int floor) {
        return this.totalOccupedSlotsForFloor[floor];
    }

    @Override
    public Position park(Vechile vechile) {
        for(int floor=0;floor<totalFloors;floor++)
        {
            if(this.totalOccupedSlotsForFloor[floor] < (endSlot-startSlot+1))
            {
                    for(int slot = 0; slot< (endSlot-startSlot+1); slot++)
                    {
                        if(this.lot[floor][slot]==null)
                        {
                            this.lot[floor][slot] = vechile;
                            Position position = new Position(floor, startSlot+slot);
                            this.vechileMapping.put(vechile,position);
                            this.totalOccupedSlotsForFloor[floor]+=1;
                            this.occupiedSlots+=1;
                            return position;
                        }
                    }
            }
        }
        return null;
    }

    @Override
    public void unpark(Vechile vechile) {
        Position position = vechileMapping.get(vechile);
        if(position==null)
             return;
        this.lot[position.getI()][position.getJ()-startSlot] = null;
        this.totalOccupedSlotsForFloor[position.getI()]-=1;
        this.vechileMapping.remove(vechile);
        this.occupiedSlots-=1;

    }
}
