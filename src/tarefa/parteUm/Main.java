package tarefa.parteUm;

import java.util.Set;
import java.util.TreeSet;
import tarefa.Form;

public class Main {
    public static void main(String[] args) {
        Set<String> listaDeNomes = inputToList(Form.receberNomes());
        System.out.println(listaDeNomes);
    }

    private static Set<String> inputToList(String[] array) {
        Set<String> listaDeNomes = new TreeSet<String>();

        for (int i = 0; i < array.length; i++){
            listaDeNomes.add(array[i]);
        }
        return listaDeNomes;
    }

}