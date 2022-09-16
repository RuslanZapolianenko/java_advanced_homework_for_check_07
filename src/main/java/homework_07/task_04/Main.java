package homework_07.task_04;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

/*
Задание 4
Используя JAXB выполнить задание №3.
 */

public class Main {
    public static void main(String[] args) {
        //Создаем объект каталога
        Catalog catalog = new Catalog();


        catalog.add(new City("Киев _1 ","Улица _ 1",11));
        catalog.add(new City("Киев _2 ","Улица _ 2",22));
        catalog.add(new City("Киев _3 ","Улица _ 3",33));
        catalog.add(new City("Киев _4 ","Улица _ 4",44));
        try {
            // Создаем файл
            File file = new File("output_city_task_04.xml");
            // Вызываем статический метод JAXBContext для создания экземпляра класса
            JAXBContext jaxbContext = JAXBContext.newInstance(Catalog.class);
            // Возвращает объект класса Marshaller, для того чтобы трансформировать объект
            Marshaller marshaller = jaxbContext.createMarshaller();

            // Устанавливаем свойства маршалеру для читабельного форматирования
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            // Записываем в файл, marshal(из памяти, в файл)
            marshaller.marshal(catalog, file);
            // и Выводим в консоль
            marshaller.marshal(catalog, System.out);

            // Считываем из файла с помощью анмаршаллера
         //   Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            //Тк. нам возвращаются объекты, то нужно кастить к типу Catalog
          //  catalog = (Catalog) unmarshaller.unmarshal(file);
            //Выводим наши объекты при помощи toString()
          //  System.out.println(catalog);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}