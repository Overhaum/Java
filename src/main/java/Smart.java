

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.Validator;
import javax.validation.constraints.*;
import java.util.Objects;
import java.util.Set;


public class Smart implements Comparable<Smart> {

    @NotNull(message = "Must be not null")
    private String brand;

    @NotNull(message = "Must be not null")
    private String model;

    @NotNull(message = "Must be not null")
    private String OS;

    @NotNull
    @Min(value = 1, message = "RAM must be more than 0")
    private int RAM;

    @NotNull
    @Min(value = 8, message = "ROM must be more than 0")
    private int ROM;


    @Min(value = 1000, message = "Battery must be more than 0")
    private int Battery;

    @NotNull
    @Min(value = 1, message = "Price must be more than 0")
    private double price;


    public Smart(String brand, String model, String OS, int RAM, int ROM, int Battery, double price) {
        this.brand = brand;
        this.model = model;
        this.RAM = RAM;
        this.ROM = ROM;
        this.Battery = Battery;
        this.price = price;
    }

    public Smart(String brand, String model, int ram, int rom, int battery, double price) {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    public int getRAM() {
        return RAM;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public int getROM() {
        return ROM;
    }

    public void setROM(int ROM){
        this.ROM = ROM;
    }


    public int getBattery() {
        return Battery;
    }

    public void setBattery(int Battery) {
        this.Battery = Battery;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Smart{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", OS='" + OS + '\'' +
                ", RAM=" + RAM + "GB" +
                ", ROM=" + ROM + "GB" +
                ", Battery=" + Battery + " mah " +
                ", Price=" + price + "$" +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Smart smart = (Smart) o;
        return RAM == smart.RAM && Battery == smart.Battery && Double.compare(smart.price, price) == 0 && brand.equals(smart.brand) && model.equals(smart.model)&& OS.equals(smart.OS) && ROM == smart.ROM;
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model,OS, RAM, ROM, Battery, price);
    }


    public int compareTo(Smart smart) {
        return Double.compare(this.price,smart.price);
//        if (this.pricePerHour == smart.pricePerHour) {
//            return 0;
//        } else if (this.pricePerHour < smart.pricePerHour) {
//            return -1;
//        } else {
//            return 1;
//        }
    }



    public static class SmartBuilder {

        private String brand;
        private String model;
        private String OS;
        private int RAM;
        private int ROM;
        private int Battery;
        private double price;

        public Smart.SmartBuilder brand(String brand) {
            this.brand = brand;
            return this;
        }

        public Smart.SmartBuilder model(String model) {
            this.model = model;
            return this;
        }
        public Smart.SmartBuilder OS(String OS) {
            this.OS = OS;
            return this;
        }
        public Smart.SmartBuilder RAM(int RAM) {
            this.RAM = RAM;
            return this;
        }

        public Smart.SmartBuilder ROM(int ROM) {
            this.ROM = ROM;
            return this;
        }

        public Smart.SmartBuilder Battery(int Battery) {
            this.Battery = Battery;
            return this;
        }

        public Smart.SmartBuilder price(double price) {
            this.price = price;
            return this;
        }

        public Smart build() throws ValidationException {
            Smart smart = new Smart(brand, model, RAM, ROM,Battery, price);
           // validateSmart(smart);
            return smart;

        }

        public Smart validateSmart(Smart smart) {

            System.out.println("Validation!!_____________________________________________________-");
            Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
            Set<ConstraintViolation<Smart>> constraintViolations = validator.validate(smart);
            for (ConstraintViolation constraintViolation : constraintViolations) {
                String fieldName = constraintViolation.getPropertyPath().toString().toUpperCase();
                System.out.println(fieldName + " " + constraintViolation.getMessage());
            }
            return smart;


        }
    }
}
