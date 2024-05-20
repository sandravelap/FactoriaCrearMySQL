package controllers.projects;

import Pojos.Project;
import Pojos.Projects;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TsvProjectsToXml {
    public void tsvProjectsTransform(Path pathCsv){
        Projects projects = new Projects();
        ArrayList<Projects> listProjects = new ArrayList<>();
        Project auxProject = new Project();
        String auxCatInst;
        try {
            List<String> tsvLines = Files.readAllLines(pathCsv);
            for (String line : tsvLines){
                //separamos por las comas que están rodeadas de comillas únicamente, distinguiendo de otras comas
                String[] tsvArray = line.split("\t");
                auxCatInst = tsvArray[0].split(" ")[0];
                System.out.println(auxCatInst);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
