package br.mack.ps2;

import br.mack.ps2.entidades.Aluno;
import br.mack.ps2.persistencia.AlunoDAO;

import java.util.List;
import java.util.Scanner;

public class InterfaceUsuario {
    AlunoDAO dao;
    Scanner in;

    public InterfaceUsuario(AlunoDAO dao) {
        this.dao = dao;
        this.in = new Scanner(System.in);
    }

    public void iniciar() {
        imprimirMenu();
    }

    private void imprimirMenu() {
        int opc = 0;
        do {
            System.out.println("\n==============");
            System.out.println("==== Menu ====");
            System.out.println("==============");
            System.out.println("\t1. Create");
            System.out.println("\t2. Read");
            System.out.println("\t3. Update");
            System.out.println("\t4. Delete");
            System.out.println("\t5. sair");
            System.out.print("Escolha uma opção: ");
            opc = in.nextInt();

            //necessário para ler a quebra de linha (enter)
            in.nextLine();

            switch (opc) {
                case 1:
                    this.create();
                    break;
                case 2:
                    this.read();
                    break;
                case 3:
                    System.out.println("Não implementado");
                    break;
                case 4:
                    this.delete();
                    break;
                case 5:
                    System.out.println("tchau :)");
                    break;
                default:
                    System.out.println("Opção Inválida");
                    break;
            }

        }while (opc != 5);
    }

    private void create() {
        Aluno aluno = new Aluno();

        System.out.println("\n******************");
        System.out.println("*** Novo aluno ***");
        System.out.println("******************");
        System.out.print("\nInforme o TIA do aluno: ");
        aluno.setTia(in.nextLong());
        //necessário para ler o \n da entrada (enter)
        in.nextLine();

        System.out.print("Informe o NOME do aluno: ");
        aluno.setNome(in.nextLine());

        System.out.print("Informe o CURSO do aluno: ");
        aluno.setCurso(in.nextLine());

        if (dao.create(aluno)) {
            System.out.println("Aluno adicionado ao banco de Dados");
        } else {
            System.out.println("Ops: problema ao adicionar o aluno");
        }
    }

    private void read() {
        List<Aluno> alunos = dao.read();

        System.out.println("\n***********************************");
        System.out.println("*** Lista de Alunos Cadastrados ***");
        System.out.println("***********************************");
        for(Aluno aluno : alunos) {
            System.out.println(aluno);
        }
    }

    private void delete() {
        List<Aluno> alunos = dao.read();

        while (true) {
            System.out.println("\n***********************************");
            System.out.println("*** Lista de Alunos Cadastrados ***");
            System.out.println("***********************************");
            int i = 0;
            for (Aluno aluno : alunos) {
                System.out.println(i + " - " + aluno);
                i++;
            }
            System.out.println(i + " - Cancelar operação");

            System.out.print("Qual aluno deseja remover? ");
            int opc = in.nextInt();
            //Necessário para ler a quebra de linha (enter)
            in.nextLine();

            if (opc==i) {
                // Cancelar operação
                break;
            }

            if (opc >= alunos.size() || opc < 0) {
                System.out.println("Esta opção não é válida");
            } else {
                if (dao.delete(alunos.get(opc))) {
                    System.out.println("Aluno " + alunos.get(opc).getNome() +
                            " removido com sucesso");
                } else {
                    System.out.println("OPS: falar ao tentar remover");
                }
                //Isso para o while infinito
                break;
            }
        }
    }
}
