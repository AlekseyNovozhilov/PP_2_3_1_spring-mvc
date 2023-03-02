package web.dao;

import org.springframework.stereotype.Repository;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Repository
public class CarDaoImpl implements CarDao {
    private static final List<Car> carsList = new ArrayList<>();

    static {
        carsList.add(Car.getObjectCar("Oka", "Красный", 300_000));
        carsList.add(Car.getObjectCar("Ваз2107", "Малиновый", 500_000));
        carsList.add(Car.getObjectCar("Ваз2109", "Вишнёвый", 700_000));
        carsList.add(Car.getObjectCar("Волга2104", "Чёрный", 900_000));
        carsList.add(Car.getObjectCar("Чайка", "Чёрный", 1_550_000));
    }

    @Override
    public List<Car> getCars(Integer value) {
        if (value == null || value >=5) {
            return getCarsList();
        }
        return carsList.stream().limit(value).collect(Collectors.toList());
    }

    public static List<Car> getCarsList() {
        return carsList;
    }
}
