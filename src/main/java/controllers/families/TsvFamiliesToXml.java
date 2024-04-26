package controllers.families;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import Pojos.Families;
import Pojos.Family;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TsvFamiliesToXml {
    public void tsvTransformFam(Path pathTsv){
        try{
            Families families = new Families();
            //podríamos sacar todos los cursos y no sólo las familias....
            ArrayList<Family> listFamilies = new ArrayList<Family>();
            Family auxFamily;
            //creo un diccionario para almacenar solo las familias sin repeticiones
            HashMap<String, String> familiesDic = new HashMap<String, String>();
            String auxCode;
            List<String> tsvLines = Files.readAllLines(pathTsv);
            //cogemos del tsv los campos que nos interesan para el xml
            for (String line: tsvLines) {
                String[] tsvArray = line.split("\t");
                auxCode = tsvArray[2].substring(0,3);
                if (!familiesDic.containsKey(auxCode)){
                    familiesDic.put(auxCode, tsvArray[0]);
                    auxFamily = new Family();
                    auxFamily.setFamilyLaw(tsvArray[1]);
                    auxFamily.setFamilyName(tsvArray[0]);
                    auxFamily.setFamilyCode(auxCode);
                    listFamilies.add(auxFamily);
                }
            }
            families.setFamilies(listFamilies);
            //creamos el contexto para trabajar con nuestras clases
            JAXBContext contexto = JAXBContext.newInstance(Families.class, Family.class);
            //pasar de Java a XML --> marshalling
            Marshaller marshaller = contexto.createMarshaller();
            //damos formato a la salida
            marshaller.setProperty(marshaller.JAXB_FORMATTED_OUTPUT, true);
            //escribimos el objeto en formato XML
            marshaller.marshal(families, new FileWriter("target/familiesFP2.xml"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
