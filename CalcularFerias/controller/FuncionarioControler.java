package controller;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import models.Funcionario;

public class FuncionarioControler {

  private ArrayList<Funcionario> funcionarios = new ArrayList<>();

  public void calcularFerias(Funcionario f, LocalDate dataInicio, int duracao) {

    for (Funcionario funcionario : funcionarios) {
      System.out.println(funcionario.toString());
    }

    boolean direitoFerias = verificaDireitoFerias(f);

    if (dataInicio.isAfter(f.getDataAdmissao())){
      if(direitoFerias){
        f.setDeFerias(true);
        System.out.println("Início das férias: " + dataInicio);
        System.out.println("Fim das férias: " + duracao);
        
      }
    }
  }

  public boolean verificaDireitoFerias(Funcionario f) {
    long qtdMeses = ChronoUnit.MONTHS.between(f.getDataAdmissao(), LocalDate.now());
    if(qtdMeses < 12) {
      System.out.println("Funcionário não possui direito a férias!");
      return false;
    }
    return true;
  }

  /*
   * Adicionar saldo de ferias baseado na quantidade de meses trabalhados
   * Adicionar 30 dias caso o empregado tenha ao menos 1 ano
   * 
   */
  public void calcularSaldoFerias(Funcionario f){
    long qtdMeses = ChronoUnit.MONTHS.between(f.getDataAdmissao(), LocalDate.now());
    if (qtdMeses >= 12 && qtdMeses < 24){
      f.setSaldoFerias(30+(1.0/12)*30);
    } else if (qtdMeses >= 24){
      double acumuloFerias = qtdMeses%12;
      f.setSaldoFerias(30+(acumuloFerias/12.0)*30);
    }
  }
}
