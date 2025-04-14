package car;

import java.util.List;
import java.util.Optional;

public interface CarManager {

    default List<Car> getCars(){
        return CarManagerImpl.loadCarsFromFile();
    }

    /**
     *
     */
    void printAllCars();

    /**
     *
     */
    void printElectricCars();

    /**
     *
     * @return
     */
    Optional<Car> getOldestCar();

    /**
     *
     * @return
     */
    double getAvaragePrice();

    /**
     * 
     *
     * @return
     */
    List<String> getAllBrands();

}
