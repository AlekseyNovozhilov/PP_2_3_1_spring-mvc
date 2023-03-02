package web.model;

public class Car {
    private String model;
    private String color;
    private double price;

    public Car() {
    }

    private Car(String model, String color, double price) {
        this.model = model;
        this.color = color;
        this.price = price;
    }

//Фабричный метод
    public static Car getObjectCar(String model, String color, double price) {
        return new Car(model,color,price);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
