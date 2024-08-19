package controller;

import models.Funcionario;
import java.util.Scanner;
import java.time.LocalDate;

public class UsuarioController {

    private FuncionarioControler fController = new FuncionarioControler();
    private Scanner in = new Scanner(System.in);
    
    public UsuarioController() {
        int opcao = 0;
        do {
            System.out.println("1 - Exibir funcionarios");
            System.out.println("2 - Deletar funcionario");
            System.out.println("3 - Editar funcionario");
            System.out.println("4 - Calcular férias");
            System.out.println("5 - Adicionar funcionario");
            System.out.println("6 - Sair");
            opcao = in.nextInt();
            in.nextLine();

            switch (opcao) {
                case 1:
                    exibirFuncionarios();
                    break;
                case 2:
                    deletarFuncionario();
                    break;
                case 3:
                    editarFuncionario();
                    break;
                case 4:
                    calcularFerias();
                    break;
                case 5:
                    adicionarFuncionario();
                    break;
                case 6:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 6);
    }

    public void exibirFuncionarios() {
        fController.exibirFuncionarios();
    }

    public void adicionarFuncionario() {
        System.out.print("Nome do funcionario: ");
        String nome = in.nextLine();
        System.out.print("Cargo do funcionario: ");
        String cargo = in.nextLine();
        
        int ultimoId = fController.getUltimoFuncionarioId();
        int novoId = ultimoId + 1;

        Funcionario f = new Funcionario(novoId, nome, cargo);
        fController.criarFuncionario(f);
        System.out.println("Funcionário adicionado com sucesso!");
    }

    public void deletarFuncionario() {
        System.out.print("Digite o ID do funcionário a ser deletado: ");
        int id = in.nextInt();
        in.nextLine();
        fController.deletarFuncionario(id);
    }

    public void editarFuncionario() {
        System.out.print("Digite o ID do funcionário a ser editado: ");
        int id = in.nextInt();
        in.nextLine();
        Funcionario f = fController.buscarFuncionario(id);
        if (f != null) {
            System.out.print("Digite o novo nome: ");
            String novoNome = in.nextLine();
            System.out.print("Digite o novo cargo: ");
            String novoCargo = in.nextLine();
            f.setNome(novoNome);
            f.setCargo(novoCargo);
            System.out.println("Funcionário atualizado com sucesso!");
        } else {
            System.out.println("Funcionário não encontrado!");
        }
    }

    public void calcularFerias() {
        System.out.print("Digite o ID do funcionário para cálculo de férias: ");
        int id = in.nextInt();
        in.nextLine();
        Funcionario f = fController.buscarFuncionario(id);
        if (f != null) {
            System.out.print("Digite a data de início das férias (formato: yyyy-mm-dd): ");
            LocalDate dataInicio = LocalDate.parse(in.nextLine());
            System.out.print("Digite a duração das férias em dias: ");
            int duracao = in.nextInt();
            fController.calcularFerias(f, dataInicio, duracao);
        } else {
            System.out.println("Funcionário não encontrado!");
        }
    }

}
