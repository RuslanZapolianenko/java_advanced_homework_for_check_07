package homework_07.task_04;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Класс помечен как корневой элемент с именем catalog
@XmlRootElement(name = "catalog")
public class Catalog {
    // Список city и при помощи аннотации будет сгенерирован элемен city
    //citys будут относится к xml тегу city
    @XmlElement(name = "city")
    private List<City> citys = new ArrayList<>();

    //Метод, который принимает city и добавляет ее в ArrayList
    public void add(City city) {
        citys.add(city);
    }

    //Выводим полное содержимое коллекции, которое сконвертировали в массив toArray
    @Override
    public String toString() {
        return Arrays.deepToString(citys.toArray());
    }
}

