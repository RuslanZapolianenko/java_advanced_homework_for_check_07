package homework_07.task_03;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

/*
Задание 3+
Создайте класс, используя SAXParser, в котором опишите иерархию XML файла.
Необходимо, чтобы проект создавал XML файл и строил дерево (город, название улицы, дом).
В городе используйте аттрибут(например, <city size=”big>Kiev</city>).
 */

public class Town {


    public static void main(String[] args) {
        townXml();
        outputTownXml();
    }

    public static void townXml() {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            // Получаем объект DocumentBuilder
            DocumentBuilder db = dbf.newDocumentBuilder();

            // Создаем чистый документ при помощи интерфейса Document
            Document doc = db.newDocument();

            // Возвращает объект класса Element, создаем корневой элемент - каталог
            Element rootElement = doc.createElement("catalog");
            //Обращаемся к документу, и добавляем в него наш корневой элемент.
            // Хоть команда и appendChild, но мы добавляем корневой элемент, тк. он является дочерним по отношению к документу
            doc.appendChild(rootElement);

            // book
            Element cityTeg = doc.createElement("city");
            rootElement.appendChild(cityTeg);

            Element cityNameTag = doc.createElement("cityName");
            cityNameTag.setTextContent("Киев");
            cityNameTag.setAttribute("size", "Big");
            cityTeg.appendChild(cityNameTag);

            Element streetNameTag = doc.createElement("streetName");
            streetNameTag.setTextContent("Богдана Хмельницкого");
            cityTeg.appendChild(streetNameTag);

            Element houseNumberTag = doc.createElement("houseNumber");
            houseNumberTag.setTextContent("19");
            cityTeg.appendChild(houseNumberTag);



            Element cityTeg2 = doc.createElement("city");
            rootElement.appendChild(cityTeg2);

            Element cityNameTag2 = doc.createElement("cityName");
            cityNameTag2.setTextContent("Киев _ 2");
            cityNameTag2.setAttribute("size", "Big _ 2");
            cityTeg2.appendChild(cityNameTag2);

            Element streetNameTag2 = doc.createElement("streetName");
            streetNameTag2.setTextContent("Богдана Хмельницкого _ 2");
            cityTeg2.appendChild(streetNameTag2);

            Element houseNumberTag2 = doc.createElement("houseNumber");
            houseNumberTag2.setTextContent("19 _ 2");
            cityTeg2.appendChild(houseNumberTag2);



            // save
            // Трансформеры - берут данные из одного метода, трансформируют по некоторому алгоритму и перекладывают в другой метод
            //Используя подход фабрики, создаем экземпляр TransformerFactory
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer t = tf.newTransformer();
            // Похожая иерархия на I/O
            //Работаем с документом и записываем туда содержимое
            //doc уже наполнен содержимым, которое мы туда записывали по элементам
            DOMSource source = new DOMSource(doc);
            //Открываем результирующий поток данных в xml файл
            StreamResult sr = new StreamResult(new File("output_city_task_03.xml"));

            // Трансформируем из источника в результирующий файл в виде одной строки
            //Но это можно исправить с помощью горячей комбинации автоформата Ctrl+Alt+L
            t.transform(source, sr);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void outputTownXml() {
        final String fileName = "output_city_task_03.xml";
        try {
            //Через фабрику создаем экземпляр saxParser
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            // Здесь мы определили анонимный класс, расширяющий класс DefaultHandler и переопределяем два метода под наши теги
            DefaultHandler handler = new DefaultHandler() {
                // Поле-индикатор для указания, что тэг name начался
                boolean cityName = false;
                boolean streetName = false;
                boolean houseNumber = false;

                // Метод вызывается когда SAXParser "натыкается" на начало тэга
                @Override
                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    // Если тэг имеет имя name, то мы этот момент отмечаем - начался тэг name
                    if (qName.equalsIgnoreCase("cityName") ) {

                        //флажок меняем на тру
                        cityName = true;
                    }

                    if (qName.equalsIgnoreCase("streetName") ) {
                        //флажок меняем на тру
                        streetName = true;
                    }

                    if (qName.equalsIgnoreCase("houseNumber") ) {
                        //флажок меняем на тру
                        houseNumber = true;
                    }
                }

                // Метод вызывается когда SAXParser считывает текст между тэгами
                @Override
                public void characters(char ch[], int start, int length) throws SAXException {
                    // Если перед этим мы отметили, что имя тэга name - значит нам надо текст использовать.
                    if (cityName) {
                        System.out.println("city Name: " + new String(ch, start, length));

                        cityName = false;
                    }

                    if (streetName) {
                        System.out.println("street Name: " + new String(ch, start, length));
                        streetName = false;
                    }

                    if (houseNumber) {
                        System.out.println("house Number: " + new String(ch, start, length));
                        houseNumber = false;
                    }

                }
            };
            // Стартуем разбор методом parse, которому передаем файл и наследника от DefaultHandler, который будет вызывать в нужные моменты
            // переопределенные методы
            saxParser.parse(fileName, handler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
