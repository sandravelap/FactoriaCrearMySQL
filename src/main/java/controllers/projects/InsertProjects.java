package controllers.projects;

import libs.CheckFiles;

import java.nio.file.Path;
import java.nio.file.Paths;

public class InsertProjects {
    //a partir del csv generamos los xml con la estructura que necesitamos.
    String pathCsv = "src/main/resources/ProyectosFP.tsv";
    private CheckFiles checkFiles = new CheckFiles();
    public void InsertProjects(){
        if (checkFiles.ficheroLegible(Path.of(pathCsv))) {
            TsvProjectsToXml tsvProjectsToXml = new TsvProjectsToXml();
            tsvProjectsToXml.tsvProjectsTransform(Paths.get(pathCsv));
            //leemos el xml y lo insertamos en la base de datos
            //File fileXml = new File("target/institutionsFP2.xml");
        }
    }
}
