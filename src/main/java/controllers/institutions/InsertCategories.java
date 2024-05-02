package controllers.institutions;

import Pojos.Category;
import repositories.CategoriesRepository;
import repositories.InstitutionsRepository;

import java.util.ArrayList;

public class InsertCategories {
    public void insertCategories(){
        ArrayList<Category> categoriesList = new ArrayList<Category>();
        Category cat1 = new Category("Instituto de Educación Secundaria", "IES");
        categoriesList.add(cat1);
        Category cat2 = new Category("Centro Privado de Formación Profesional Específica", "CFPE");
        categoriesList.add(cat2);
        Category cat3 = new Category("Centro Público Integrado de Formación Profesional", "CPIFP");
        categoriesList.add(cat3);
        Category cat4 = new Category("Centro Privado de Educación Infantil Primaria y Secundaria", "CPEPS");
        categoriesList.add(cat4);
        Category cat5 = new Category("Centro Privado de Educación Secundaria", "CPES");
        categoriesList.add(cat5);
        Category cat6 = new Category("Escuela de Capacitación Agraria","ECA");
        categoriesList.add(cat6);
        Category cat7 = new Category("Centro Docente de Formación Militar","CDFM");
        categoriesList.add(cat7);
        Category cat8 = new Category("Centro Privado Integrado de Formación Profesional", "CIFP");
        categoriesList.add(cat8);
        Category cat9 = new Category("Centro Privado de Formación Profesional", "CFP");
        categoriesList.add(cat9);
        //pasamos el array al repositorio que hacer los insert
        CategoriesRepository.insertCategories(categoriesList);
    }
}
