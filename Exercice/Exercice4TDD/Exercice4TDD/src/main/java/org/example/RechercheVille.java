package org.example;

import jdk.jshell.spi.ExecutionControl;

import java.util.List;

public class RechercheVille {
    private List<String> villes;

    public RechercheVille(List<String> villes) {
        this.villes = villes;
    }

    public List<String> recherche(String mot) {
        if(mot.equals("*")){
            return villes;
        }
        if(mot.length() < 2){
            throw new NotFoundException("less than 2 char");
        }
        return villes.stream().filter(v -> v.toLowerCase().contains(mot.toLowerCase())).toList();
    }
}
