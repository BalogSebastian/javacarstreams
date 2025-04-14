package cars;

import car.Car;
import car.CarManager;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class CarManagerImpl implements CarManager {

    public static void main(String[] args) {
        var manager = new CarManagerImpl();
        manager.printAllCars();
        manager.printElectricCars();
        System.out.println("Oldest car: " + manager.getOldestCar());
        System.out.println("Average price: " + manager.getAvaragePrice());
        System.out.println("Brands: " + manager.getAllBrands());
    }

    // Betölti a cars.ser fájlt
    public static List<Car> loadCarsFromFile() {
        try (var in = new ObjectInputStream(
                CarManagerImpl.class.getResourceAsStream("/cars/cars.ser"))) {
            return (List<Car>) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }

    // Az összes autó kiírása
    @Override
    public void printAllCars() {
        getCars().stream()
                .forEach(System.out::println);
    }

    // Elektromos autók kiírása (példa: Tesla)
    @Override
    public void printElectricCars() {
        getCars().stream()
                .filter(car -> car.brand().toLowerCase().contains("tesla")) // pl. Tesla
                .forEach(System.out::println);
    }

    // A legöregebb autó
    @Override
    public Optional<Car> getOldestCar() {
        return getCars().stream()
                .min(Comparator.comparingInt(Car::year));
    }

    // Az autók átlagára
    @Override
    public double getAvaragePrice() {
        return getCars().stream()
                .mapToDouble(Car::price)
                .average()
                .orElse(0.0);
    }

    // Az összes autó márkája
    @Override
    public List<String> getAllBrands() {
        return getCars().stream()
                .map(Car::brand)
                .distinct()
                .sorted()
                .toList();
    }
}
