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

    boolean direitoFerias = verificaDireitoFerias(f, duracao);

    if (dataInicio.isAfter(f.getDataAdmissao())){
      if(direitoFerias){
        f.setDeFerias(true);
        System.out.println("Início das férias: " + dataInicio);
        System.out.println("Fim das férias: " + dataInicio.plusDays(duracao));
      }
    }
  }

  public boolean verificaDireitoFerias(Funcionario f, int duracao) {
    long qtdMeses = ChronoUnit.MONTHS.between(f.getDataAdmissao(), LocalDate.now());
    if(duracao > 30){
        if(f.getSaldoFerias() < duracao+f.getSaldoFerias()){
            System.out.println("Funcionário não possui saldo suficiente para tirar férias!");
            return false;
        }
        return true;
    }
    if(qtdMeses < 12) {
      System.out.println("Funcionário não possui direito a férias!");
      return false;
    }
    return true;
  }

//   public void calcularSaldoFerias(Funcionario f){
//     long qtdMeses = ChronoUnit.MONTHS.between(f.getDataAdmissao(), LocalDate.now());
//     if (qtdMeses >= 12 && qtdMeses < 24){
//       f.setSaldoFerias(30+(1.0/12)*30);
//     } else if (qtdMeses >= 24){
//       double acumuloFerias = qtdMeses%12;
//       f.setSaldoFerias(30+(acumuloFerias/12.0)*30);
//     }
//   }
}
