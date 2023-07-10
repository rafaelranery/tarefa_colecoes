package tarefa;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Form {

    public static String[] receberNomes() {
        Scanner s = new Scanner(System.in);
        System.out.println("Insira uma lista de nomes separados por vírgula: \n");

        String unparsedInput = s.nextLine();

        if (unparsedInput.matches("[^a-zA-Z, ]")) {
            return null;
        }

        String[] parsedInput = unparsedInput.split(",");

        for (int i = 0; i < parsedInput.length; i++) {
            parsedInput[i] = parsedInput[i].trim().toUpperCase();
        }

        return parsedInput;
    }

    /**
     *  Recebe input do console representando uma lista de pessoas determinadas por "Nome-Gênero" e transforma-o em Array.
     * @return Array de String contendo em cada elemento "Nome-Gênero".
     */
    public static String[] receberNomeEGênero() {
        Scanner s = new Scanner(System.in);
        System.out.println(
                "Insira uma lista de pessoas, incluindo seu nome e gênero, no formato\n" +
                "'Nome-(F/M)', separando os por vírgula:\n"
        );

        String unparsedInput = s.nextLine();
        if (unparsedInput.matches("[^a-zA-Z, -]")) {
            return null;
        }

        String[] parsedInput = unparsedInput.split(",");
        for(String input : parsedInput) {
            input = input.trim();
        }


        return parsedInput;
     }

     public static HashMap<String, Set<String>> filtrarPorGênero(String[] unparsedArr) {
        Set<String> setMasculino = new TreeSet<String>();
        Set<String> setFeminino = new TreeSet<String>();
        Set<String> errors = new TreeSet<String>();
        HashMap<String, Set<String>> mapaFiltrado = new HashMap<String, Set<String>>();

        for(String element : unparsedArr) {
            String[] nomeEGen = element.split("-");
            if (nomeEGen[1].matches("[Mm]")) {
                setMasculino.add(nomeEGen[0].trim());
            } else if (nomeEGen[1].matches("[Ff]")) {
                setFeminino.add(nomeEGen[0].trim());
            } else {
                errors.add(
                      element.trim() + " is not a valid input."
                );
            }
        }

        mapaFiltrado.put("Lista de pessoas do sexo masculino", setMasculino);
        mapaFiltrado.put("Lista de pessoas do sexo feminino", setFeminino);
        if(!errors.isEmpty()) {
            mapaFiltrado.put("Erros", errors);
        }

        return mapaFiltrado;
     }
}
