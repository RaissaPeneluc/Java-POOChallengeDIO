import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;
import br.com.dio.desafio.dominio.Conteudo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Curso> cursos = criarCursos();
        List<Mentoria> mentorias = criarMentorias();

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");

        // Adicionando cursos e mentorias diretamente ao conteúdo do bootcamp
        for (Curso curso : cursos) {
            bootcamp.getConteudos().add(curso);
        }
        for (Mentoria mentoria : mentorias) {
            bootcamp.getConteudos().add(mentoria);
        }

        Dev devCamila = new Dev();
        devCamila.setNome("Camila");
        devCamila.inscreverBootcamp(bootcamp);
        apresentarDev(devCamila);

        devCamila.progredir();
        devCamila.progredir();
        apresentarProgresso(devCamila);

        System.out.println("-------");

        Dev devJoao = new Dev();
        devJoao.setNome("Joao");
        devJoao.inscreverBootcamp(bootcamp);
        apresentarDev(devJoao);

        devJoao.progredir();
        devJoao.progredir();
        devJoao.progredir();
        apresentarProgresso(devJoao);
    }

    private static void apresentarDev(Dev dev) {
        System.out.println("Dev: " + dev.getNome());
        System.out.println("Inscrito no Bootcamp com os seguintes conteúdos:");
        for (Conteudo conteudo : dev.getConteudosInscritos()) {
            if (conteudo instanceof Curso) {
                Curso curso = (Curso) conteudo;
                System.out.println("- Curso: " + curso.getTitulo());
            } else if (conteudo instanceof Mentoria) {
                Mentoria mentoria = (Mentoria) conteudo;
                System.out.println("- Mentoria: " + mentoria.getTitulo());
            }
        }
        System.out.println();
    }

    private static void apresentarProgresso(Dev dev) {
        System.out.println("Progresso de " + dev.getNome() + ":");
        System.out.println("Conteúdos Inscritos:");
        for (Conteudo conteudo : dev.getConteudosInscritos()) {
            if (conteudo instanceof Curso) {
                Curso curso = (Curso) conteudo;
                System.out.println("- Curso: " + curso.getTitulo());
            } else if (conteudo instanceof Mentoria) {
                Mentoria mentoria = (Mentoria) conteudo;
                System.out.println("- Mentoria: " + mentoria.getTitulo());
            }
        }
        System.out.println("Conteúdos Concluídos:");
        for (Conteudo conteudo : dev.getConteudosConcluidos()) {
            if (conteudo instanceof Curso) {
                Curso curso = (Curso) conteudo;
                System.out.println("- Curso: " + curso.getTitulo());
            } else if (conteudo instanceof Mentoria) {
                Mentoria mentoria = (Mentoria) conteudo;
                System.out.println("- Mentoria: " + mentoria.getTitulo());
            }
        }
        System.out.println("XP Total: " + dev.calcularTotalXp());
        System.out.println();
    }

    private static List<Curso> criarCursos() {
        List<Curso> cursos = new ArrayList<>();

        Curso curso1 = new Curso();
        curso1.setTitulo("Curso Java");
        curso1.setDescricao("Descrição Curso Java");
        curso1.setCargaHoraria(8);
        cursos.add(curso1);

        Curso curso2 = new Curso();
        curso2.setTitulo("Curso JS");
        curso2.setDescricao("Descrição Curso JS");
        curso2.setCargaHoraria(4);
        cursos.add(curso2);

        return cursos;
    }

    private static List<Mentoria> criarMentorias() {
        List<Mentoria> mentorias = new ArrayList<>();

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Mentoria de Java");
        mentoria.setDescricao("Descrição Mentoria Java");
        mentoria.setData(LocalDate.now());
        mentorias.add(mentoria);

        return mentorias;
    }
}
