package controllers.institutions;

import Pojos.Institutions;
import Pojos.Institution;
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

public class CsvInstitutionsToXml {

    public void csvTransform(Path pathCsv){
        try {
            Institutions institutions = new Institutions();
            ArrayList<Institution> listaInstitutions = new ArrayList<>();
            Institution auxInstitution = new Institution();
            List<String> csvLines = Files.readAllLines(pathCsv);
            //cogemos del csv los campos que nos interesan para el xml

            for(String line: csvLines){
                //separamos por las comas que están rodeadas de comillas únicamente, distinguiendo de otras comas
                String[] csvArray = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                auxInstitution.setCode(csvArray[3].replace("\"","")); //
                auxInstitution.setName(csvArray[4].replace("\"",""));
                //la categoría aquí es un String con el nombre completo, lo que hay en el csv
                //al hacer el insert se convertirá en el id correspondiente
                auxInstitution.setCategory(csvArray[5].replace("\"","").strip());
                auxInstitution.setEmail(csvArray[9].replace("\"",""));
                auxInstitution.setWeb(csvArray[10].replace("\"",""));
                listaInstitutions.add(auxInstitution);
                auxInstitution =new Institution();
            }
            //borramos el primer elemento con los encabezados y guardamos la lista en el objeto mapeado para usar JAXB
            listaInstitutions.remove(0);
            institutions.setListInstitutions(listaInstitutions);
            //creamos el contexto para trabajar con nuestras clases
            JAXBContext contexto = JAXBContext.newInstance(Institutions.class, Institution.class);
            //pasar de Java a XML --> marshalling
            Marshaller marshaller = contexto.createMarshaller();
            //damos formato a la salida
            marshaller.setProperty(marshaller.JAXB_FORMATTED_OUTPUT, true);
            //escribimos el objeto en formato XML
            //marshaller.marshal(institutions, System.out);
            marshaller.marshal(institutions, new FileWriter("target/institutionsFP2.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (PropertyException e) {
            throw new RuntimeException(e);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

    }


}
