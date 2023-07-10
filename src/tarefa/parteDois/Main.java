package tarefa.parteDois;

import tarefa.Form;

import java.util.HashMap;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        HashMap<String, Set<String>> listaDePessoas = Form.filtrarPorGênero(Form.receberNomeEGênero());
        imprimirLista(listaDePessoas);
    }
    public static void imprimirLista(HashMap<String, Set<String>> lista) {
        for(String key : lista.keySet()) {
            System.out.println("\n" + key + ":\n");
            for(String value : lista.get(key)) {
                System.out.println(value + "\n");
            }
            System.out.println("---------------------");
        }
    }
}
