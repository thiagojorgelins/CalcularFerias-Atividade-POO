package controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import models.Funcionario;

public class FuncionarioControler {

    private ArrayList<Funcionario> funcionarios = new ArrayList<>();

    public void criarFuncionario(Funcionario f) {
        this.funcionarios.add(f);
    }

    public void exibirFuncionarios() {
        for (Funcionario f : funcionarios) {
            System.out.println(f.toString());
        }
    }

    public void deletarFuncionario(int id) {
        Funcionario f = buscarFuncionario(id);
        if (f != null) {
            funcionarios.remove(f);
            System.out.println("Funcionário deletado com sucesso!");
        } else {
            System.out.println("Funcionário não encontrado!");
        }
    }

    public Funcionario buscarFuncionario(int id) {
        for (Funcionario f : funcionarios) {
            if (f.getId() == id) {
                return f;
            }
        }
        return null;
    }

    public int getUltimoFuncionarioId() {
        if (funcionarios.isEmpty()) {
            return 0;
        }
        return funcionarios.get(funcionarios.size() - 1).getId();
    }

    public void calcularFerias(Funcionario f, LocalDate dataInicio, int duracao) {
        boolean direitoFerias = verificaDireitoFerias(f, duracao);

        if (dataInicio.isAfter(f.getDataAdmissao())) {
            if (direitoFerias) {
                f.setDeFerias(true);
                System.out.println("Início das férias: " + dataInicio);
                System.out.println("Fim das férias: " + dataInicio.plusDays(duracao));
            } else {
                System.out.println("Funcionário não possui direito a férias ou saldo insuficiente!");
            }
        } else {
            System.out.println("Data de início das férias inválida!");
        }
    }

    private boolean verificaDireitoFerias(Funcionario f, int duracao) {
        long qtdMeses = ChronoUnit.MONTHS.between(f.getDataAdmissao(), LocalDate.now());
        if (duracao > 30) {
            System.out.println("Duração de férias não pode ser superior a 30 dias!");
            return false;
        }
        if (qtdMeses < 12) {
            System.out.println("Funcionário não possui direito a férias!");
            return false;
        }
        return true;
    }
}