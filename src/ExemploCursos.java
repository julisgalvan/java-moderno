import java.util.*;
import java.util.stream.Collectors;

class Curso {
        private String nome;
        private int alunos;

        public Curso(String nome, int alunos) {
            this.nome = nome;
            this.alunos = alunos;
        }

        public String getNome() {
            return nome;
        }

        public int getAlunos() {
            return alunos;
        }
    }

    public class ExemploCursos {
        public static void main(String[] args) {
            List<Curso> cursos = new ArrayList<Curso>();
            cursos.add(new Curso("Python", 45));
            cursos.add(new Curso("JavaScript", 150));
            cursos.add(new Curso("Java 8", 113));
            cursos.add(new Curso("C", 55));

            cursos.sort((Comparator.comparingInt(Curso::getAlunos)));


            OptionalDouble media = cursos.stream()
                    .filter(c -> c.getAlunos() >= 100)
                    //.forEach(c -> System.out.println(c.getNome()));
                    .mapToInt(Curso::getAlunos)
                    .average();
            //System.out.println(sum);

//            cursos.stream()
//                    .filter(c -> c.getAlunos() >= 100)
//                    .findAny()
//                    .ifPresent(c -> System.out.println(c.getNome()));

            cursos.parallelStream()
                    .filter(c -> c.getAlunos() >= 100)
                    .collect(Collectors.toMap(
                            c -> c.getNome(),
                            c -> c.getAlunos()))
                    .forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos"));

        }


}

