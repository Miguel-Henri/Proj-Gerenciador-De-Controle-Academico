import java.util.Scanner;

public class ClientCode {
    public static void main(String[] args) {
        Usuario clienteUsuario = null;
        int escolhaGeral;
        Scanner leitor = new Scanner(System.in);
        Sistema.AdicionarAdm();

        // Exemplo de criação de algumas turmas para teste
        Disciplina disciplinaMatematica = new Disciplina("Matematica", "MAT101", "Ementa de Matematica", 60, 30);
        Professor professor1 = new Professor("prof1", "senha", "12345", "Prof. A", "01/01/1980");
        Turma turmaMatematica = new Turma("TURMA1", disciplinaMatematica, professor1);
        Sistema.getTurma().add(turmaMatematica);

        do {
            System.out.println("[1] Efetuar Login");
            System.out.println("[2] Sair do Sistema");
            escolhaGeral = leitor.nextInt();

            switch (escolhaGeral) {
                case 1:
                    clienteUsuario = Sistema.Login();
                    break;
                case 2:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Selecione uma opção valida");
            }

            if (clienteUsuario != null) {
                if (clienteUsuario instanceof Administrador) {
                } else if (clienteUsuario instanceof Aluno) {
                    int escolhaAluno;
                    do {
                        System.out.println("[1] Matricular em uma turma");
                        System.out.println("[2] Consultar rendimento");
                        System.out.println("[3] Sair da conta");
                        escolhaAluno = leitor.nextInt();

                        switch (escolhaAluno) {
                            case 1:
                                System.out.println("Escolha uma turma para se matricular:");
                                for (int i = 0; i < Sistema.getTurma().size(); i++) {
                                    System.out.println("[" + i + "] " + Sistema.getTurma().get(i).getCodigoTurma());
                                }
                                int escolhaTurma = leitor.nextInt();
                                Turma turmaEscolhida = Sistema.getTurma().get(escolhaTurma);
                                ((Aluno) clienteUsuario).matricularTurma(turmaEscolhida);
                                break;

                            case 2:
                                ((Aluno) clienteUsuario).consultarRendimento();
                                break;

                            case 3:
                                clienteUsuario = null;
                                break;
                        }
                    } while (escolhaAluno != 3);

                } else if (clienteUsuario instanceof Professor) {
                }
            }
        } while (escolhaGeral != 2);

        leitor.close();
    }
}
