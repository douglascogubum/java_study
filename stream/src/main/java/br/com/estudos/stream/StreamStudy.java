package br.com.estudos.stream;

import br.com.estudos.stream.model.Curso;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class StreamStudy {

    public static void main(String[] args) {
        List<Curso> cursos = new ArrayList<>();
        cursos.add(new Curso("Python", 45));
        cursos.add(new Curso("JavaScript", 150));
        cursos.add(new Curso("Java 8", 113));
        cursos.add(new Curso("C", 55));

        cursos.sort(Comparator.comparing(Curso::getAlunos));

        cursos.stream()
            .filter(curso -> curso.getAlunos() >= 100)
            .map(Curso::getAlunos)
            .forEach(System.out::println);

        cursos.stream()
            .filter(curso -> curso.getAlunos() > 50)
            .forEach(curso -> System.out.println(curso.getNome()));

        /*
        * Retorna uma stream de String contendo cada nome do curso,
        * conforme filtro
        * */
        Stream<String> nomes = cursos.stream()
            .filter(curso -> curso.getAlunos() > 50)
            .map(Curso::getNome);
        nomes.findFirst().ifPresent(System.out::println);

        /*
        * Method References para o map/forEach,
        * O map retornará os nomes dos cursos
        * No forEach faremos a impressão dos nomes dos cursos
        * */
        cursos.stream()
            .filter(curso -> curso.getAlunos() > 50)
            .map(Curso::getNome)
            .forEach(System.out::println);

        Optional<Curso> optionalCurso = cursos.stream()
            .filter(curso -> curso.getAlunos() >= 100)
            .findAny();

        var course = optionalCurso.orElse(null);
       if(Objects.nonNull(course)) {
           System.out.println(course.getNome());
       }

       OptionalDouble average = cursos.stream()
           .mapToDouble(Curso::getAlunos)
           .average();
       average.ifPresent(av -> System.out.println("Average is: " + av));


        cursos.stream()
            .filter(curso -> curso.getAlunos() >= 1000)
            .findAny()
            .ifPresent(c -> System.out.println(c.getNome()));

        cursos = cursos.stream()
            .filter(curso -> curso.getAlunos() >= 100)
            .collect(Collectors.toList());

        cursos.stream()
            .forEach(System.out::println);

        cursos.parallelStream()
            .filter( curso -> curso.getAlunos() >= 100)
            .collect(Collectors.toMap(
                Curso::getNome,
                Curso::getAlunos))
            .forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos."));

        cursos.stream()
            .filter(curso -> curso.getAlunos() > 50)
            .findFirst()
            .ifPresent(curso -> System.out.println(curso.getNome()));
    }
}
