package DataLoad;

import Pojos.Entities;
import Pojos.Entity;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.PropertyException;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CsvToXml {
    public static void csvTransform(Path pathCsv){
        try {
            Entities entities = new Entities();
            ArrayList<Entity> listaEntities = new ArrayList<Entity>();
            Entity auxEntity = new Entity();
            List<String> csvLines = Files.readAllLines(pathCsv);

            //cogemos del csv los campos que nos interesan para el xml
            for(String line: csvLines){
                String[] csvArray = line.split(",");
                auxEntity.setCode(csvArray[3]); //
                auxEntity.setName(csvArray[4]);
                auxEntity.setEmail(csvArray[10]);
                auxEntity.setWeb(csvArray[11]);
                listaEntities.add(auxEntity);
                auxEntity=new Entity();
            }
            //borramos el primer elemento con los encabezados y guardamos la lista en el objeto mapeado para usar JAXB
            listaEntities.remove(0);
            entities.setListEntities(listaEntities);
            //creamos el contexto para trabajar con nuestras clases
            JAXBContext contexto = JAXBContext.newInstance(Entities.class, Entity.class);
            //pasar de Java a XML --> marshalling
            Marshaller marshaller = contexto.createMarshaller();
            //damos formato a la salida
            marshaller.setProperty(marshaller.JAXB_FORMATTED_OUTPUT, true);
            //escribimos el objeto en formato XML
            marshaller.marshal(entities, System.out);
            marshaller.marshal(entities, new FileWriter("target/entitiesFP2.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (PropertyException e) {
            throw new RuntimeException(e);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

    }
}
