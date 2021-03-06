package MVC;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Cars.CarFactory;
import Main.*;

public class CarModel<A extends Vehicle> {
    Map<String, Point> pointMap = new HashMap<String, Point>();
    Map<String, Double> speedMap = new HashMap<String, Double>();
    ArrayList<Vehicle> vehicles=new ArrayList<>();
    void moveit(int x, int y, A vehicle){
        if(pointMap.containsKey(vehicle.getModelName())){
            pointMap.get(vehicle.getModelName()).x = x;
            pointMap.get(vehicle.getModelName()).y = y;
        }
    }

    void stopAllEngines(){
        for(Vehicle car : vehicles)
            car.stopEngine();
    }

    void startAllEngines(){
        for(Vehicle car : vehicles)
            car.startEngine();
    }

    void turboOnSaab(){
        for(Vehicle car : vehicles){
            if(car.getModelName().contains("Saab95"))
                ((Cars.Saab95) car).setTurboOn();
        }
    }

    void turboOffSaab(){
        for(Vehicle car : vehicles){
            if(car.getModelName().contains("Saab95"))
                ((Cars.Saab95) car).setTurboOff();
        }
    }

    void liftflak(int amount){
        for(Vehicle vehicle:vehicles){
            if(vehicle.getModelName().contains("Scania"))
                ((Cars.Scania) vehicle).liftFlak(amount);
        }
    }

    void lowerflak(int amount){
        for(Vehicle vehicle:vehicles){
            if(vehicle.getModelName().contains("Scania"))
                ((Cars.Scania) vehicle).lowerFlak(amount);
        }
    }

    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle vehicle : vehicles) {
            vehicle.gas(gas);
        }
    }

    void brake(int amount){
        double brake=((double) amount)/100;
        for(Vehicle vehicle: vehicles){
            vehicle.brake(brake);
        }
    }

    void addCar(){
        if(vehicles.size()<10) {
            vehicles.add(CarFactory.createSaab95());
        }
        else
            throw new IndexOutOfBoundsException("Du kan inte lägga till fler än 10 bilar miss");

    }

    void removeCar(){
        if(!vehicles.isEmpty())
            vehicles.remove(vehicles.size()-1);
        else
            throw new IndexOutOfBoundsException("Finns inga bilar att ta bort lady");

    }
}