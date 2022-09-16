package homework_07.task_04;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// Объекты класса city, будут трансформироватся в xml элементы с названием city
//Корневым элементов данного класса будет city
@XmlRootElement(name = "city")
public class City {
    //Создаем элементы
    private String cityName;
    private String streetName;
    private int houseNumber;

    //Создаем конструкторы без параметров и с 3 параметрами
    public City() {
    }

    public City(String cityName, String streetName, int  houseNumber) {
        this.cityName = cityName;
        this.streetName = streetName;
        this.houseNumber = houseNumber;
    }

//    @Override
//    public String toString() {
//        return "[" + cityName + ", " + streetName + ", " + houseNumber + "]";
//    }

    // Если в аннотации в качестве параметра не передаем поле name,
    // то аннотации в xml файле будут соответствовать полям класса
    @XmlElement
    public void setHouseNumber(int  houseNumber) {
        this.houseNumber = houseNumber;
    }

    @XmlElement
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @XmlElement
    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetName() {
        return streetName;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public String getCityName() {
        return cityName;
    }


}

