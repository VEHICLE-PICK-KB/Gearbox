package fi.msan.gearbox_api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Gearbox {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    private String model;
    private String type;
    private int gears;
    private String manufacturer;
    private int manufyear;

public Gearbox() {

}

public Gearbox(String model, String type, int gears, String manufacturer, int manufyear) {
        this.model = model;
        this.type = type;
        this.gears = gears;
        this.manufacturer = manufacturer;
        this.manufyear = manufyear;
    }

public Long getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getType() {
        return type;
    }

    public int getGears() {
        return gears;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getManufyear() {
        return manufyear;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setGears(int gears) {
        this.gears = gears;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setManufyear(int year) {
        this.manufyear = year;
    }

}


