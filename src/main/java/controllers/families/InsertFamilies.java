package controllers.families;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import repositories.FamiliesRepository;
import Pojos.Families;

import java.io.File;
import java.nio.file.Path;

public class InsertFamilies {
    public void InsertFamilies(){
        //a partir del tsv generamos el xml con los datos
        Path pathTsv = Path.of("src/main/resources/SIGLAS-CICLOS-FORMATIVOS-FP.tsv");
        TsvFamiliesToXml tsvFamiliesToXml = new TsvFamiliesToXml();
        tsvFamiliesToXml.tsvTransformFam(pathTsv);
        //leemos el xml y lo insertamos en la base de datos
        File fileXml = new File("target/familiesFP2.xml");

        Families newFamilies;
        JAXBContext contexto = null;
        try {
            //objetos necesarios para poder leer el documento
            contexto = JAXBContext.newInstance(Families.class);
            //pasar de xml a java --> unmarshalling
            Unmarshaller unmarshaller = contexto.createUnmarshaller();
            //unmarshall me devuelve un objeto de tipo Object, por lo que tengo que castear a mi clase
            newFamilies = (Families) unmarshaller.unmarshal(fileXml);
            //pasamos el array al repositorio que hacer los insert
            FamiliesRepository.insertFamilies(newFamilies);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
