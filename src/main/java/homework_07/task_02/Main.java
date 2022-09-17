package homework_07.task_02;

import java.io.*;

/*
Задание
Создайте класс Animal
Опишите в нем 3 различных поля, создайте конструктор, методы.
Создайте файл и выполните сериализацию объекта Animal.

Задание 2
Необходимо осуществить десериализацию с файла предыдущего проекта(Animal) и вывести на экран содержимое.
 */

public class Main {

    public static void main(String[] args) throws IOException {
        File animalTxt;
        Animal animalObject_01;
        Animal animalObject_02;
        ObjectOutputStream oos;
        ObjectInputStream ois;

        animalTxt = new File("animal.txt");
        animalObject_01 = new Animal("Cat", "World", "mammals", new DataAnimal("Moysha", 9, 15.0));

        //OOS Записывает примитивные типы данных в OutputStream, в качестве параметра принимается поток  файл, по адресу из animalTxt
        //OIS десериализует примитивы ранее использованые в OOS
        oos = new ObjectOutputStream(new FileOutputStream(animalTxt));
        ois = new ObjectInputStream(new FileInputStream(animalTxt));

        try {
            System.out.println("Сериализуем объект Animal (animalObject_01)  в байт-код");
            oos.writeObject(animalObject_01); // Сериализуем объект Animal  в байт-код

            System.out.println("Десериализуем объект Animal с байт-кода в ( animalObject_02)");
            animalObject_02 = (Animal) ois.readObject(); // Десериализуем объект Animal с байт-кода

            System.out.println(animalObject_02);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        //_____________________________________________________________________________________________
        System.out.println("Изменим объект Animal ( animalObject_02)");
        animalObject_02 = new Animal("Собака", "Улица", "Млекопитающие", new DataAnimal("Шарик", 15, 16.0));
        System.out.println(animalObject_02);


        try {
            System.out.println("Сериализуем объект Animal (animalObject_02)  в байт-код");
            oos.writeObject(animalObject_02); // Сериализуем объект Animal  в байт-код

            System.out.println("Десериализуем объект Animal с байт-кода в ( animalObject_01)");
            animalObject_01 = (Animal) ois.readObject(); // Десериализуем объект Animal с байт-кода

            System.out.println(animalObject_01);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
