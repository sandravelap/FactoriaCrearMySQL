package controllers.institutions;

import Pojos.Institutions;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import repositories.InstitutionsRepository;

import java.io.File;
import java.nio.file.Paths;

public class InsertInstitutions {
    public void InsertInstitutions() {
        //a partir del csv generamos el xml con la estructura que necesitamos.
        String pathCsv = "src/main/resources/CentrosCFGMyS.csv";
        CsvInstitutionsToXml csvInstitutionsToXml = new CsvInstitutionsToXml();
        csvInstitutionsToXml.csvTransform(Paths.get(pathCsv));
        //leemos el xml y lo insertamos en la base de datos
        File fileXml = new File("target/institutionsFP2.xml");

        Institutions newInstitutions = new Institutions();
        JAXBContext contexto = null;
        try {
            //objetos necesarios para poder leer el documento
            contexto = JAXBContext.newInstance(Institutions.class);
            //pasar de xml a java --> unmarshalling
            Unmarshaller unmarshaller = contexto.createUnmarshaller();
            //unmarshall me devuelve un objeto de tipo Object, por lo que tengo que castear a mi clase
            newInstitutions = (Institutions) unmarshaller.unmarshal(fileXml);
            //pasamos el array al repositorio que hacer los insert
            InstitutionsRepository.insertInstitutions(newInstitutions);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
