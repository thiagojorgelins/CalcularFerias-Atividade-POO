package models;

import java.time.LocalDate;

public class Funcionario {
  private String nome;
  private String cargo;
  private LocalDate dataAdmissao;
  private boolean deFerias;
  private double saldoFerias;

  public Funcionario(String nome, String cargo, LocalDate dataAdmissao) {
    this.nome = nome;
    this.cargo = cargo;
    this.dataAdmissao = dataAdmissao;
    this.deFerias = false;
  }

  public Funcionario(String nome, String cargo) {
    this.nome = nome;
    this.cargo = cargo;
    this.dataAdmissao = LocalDate.now();
    this.deFerias = false;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCargo() {
    return cargo;
  }

  public void setCargo(String cargo) {
    this.cargo = cargo;
  }

  public LocalDate getDataAdmissao() {
    return dataAdmissao;
  }

  public void setDataAdmissao(LocalDate dataAdmissao) {
    this.dataAdmissao = dataAdmissao;
  }

  public double getSaldoFerias() {
    return saldoFerias;
  }

  public void setSaldoFerias(double saldoFerias) {
    this.saldoFerias = saldoFerias;
  }

  public boolean isDeFerias() {
    return deFerias;
  }

  public void setDeFerias(boolean deFerias) {
    this.deFerias = deFerias;
  }

  @Override
  public String toString() {
    return "Funcionario [nome=" + nome + ", cargo=" + cargo + ", dataAdmissao=" + dataAdmissao + ", saldoFerias="
        + saldoFerias + "]";
  }

}
