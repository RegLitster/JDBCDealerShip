package com.pluralsight.data;

import com.pluralsight.models.Vehicle;
import java.util.List;

public interface VehicleDao {

    List<Vehicle> findAll();

    List<Vehicle> findByPrice(double min, double max);

    List<Vehicle> findByMakeModel(String make, String model);

    List<Vehicle> findByYearRange(int minYear, int maxYear);

    List<Vehicle> findByColor(String color);

    List<Vehicle> findByMileageRange(int min, int max);

    List<Vehicle> findByType(String type);

    void addVehicle(Vehicle vehicle);

    void deleteVehicle(int vin);
}
