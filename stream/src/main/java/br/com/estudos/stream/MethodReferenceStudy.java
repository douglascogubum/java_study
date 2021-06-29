package br.com.estudos.stream;

import java.util.ArrayList;
import java.util.List;

public class MethodReferenceStudy {

    public static void main(String[] args) {

        List<String> palavras = new ArrayList<>();

        palavras.add("alura online");
        palavras.add("casa do código");
        palavras.add("caelum");

        // forma primitiva
        palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));

        //evoluindo a linha acima
        palavras.sort(String.CASE_INSENSITIVE_ORDER);

        palavras.forEach(System.out::println);
    }
}
