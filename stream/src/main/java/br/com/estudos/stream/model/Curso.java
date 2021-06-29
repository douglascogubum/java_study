package br.com.estudos.stream.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class Curso {

    private final String nome;
    private final Integer alunos;
}
