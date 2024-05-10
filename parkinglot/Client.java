package parkinglot;
//Here I used factory Design Method
public class Client {
    public static void main(String[] args) {
        Lot carLotManager   = new CarLot(0,1,4);
        Vechile car1 = new Car(123,Color.BLACK);
        Vechile car2 = new Car(124,Color.BLACK);
        Vechile car3 = new Car(124,Color.BLACK);
        Vechile car4 = new Car(124,Color.BLACK);
        System.out.println(carLotManager.park(car1));
        //System.out.println(carLotManager.getFreeSlotsForFloor(0));
        //carLotManager.unpark(car1);
        System.out.println(carLotManager.park(car2));
        //System.out.println(carLotManager.getFreeSlotsForFloor(0));
        //carLotManager.unpark(car1);
        System.out.println(carLotManager.park(car3));
        System.out.println(carLotManager.park(car4));
        Lot truckLot = new TruckLot(3,4,4);
        Vechile truck = new Truck(11,Color.BLUE);
        System.out.println(truckLot.park(truck));
    }
}
