package com.java.www;

public class Car {
    private int id;
    private String model;

    // 构造器
    public Car() {}

    public Car(int id, String model) {
        this.id = id;
        this.model = model;
    }

    // 方法
    public String toString() {
        return "Car{ " +
                " id=" + id +
                ", model='" + model + '\'' +
                " }";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (id != car.id) return false;
        return model != null ? model.equals(car.model) : car.model == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}