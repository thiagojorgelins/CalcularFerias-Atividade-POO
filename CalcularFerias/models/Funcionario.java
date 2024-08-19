package models;

import java.time.LocalDate;

public class Funcionario {
    private int id;
    private String nome;
    private String cargo;
    private LocalDate dataAdmissao;
    private boolean deFerias;
    private double saldoFerias;

    public Funcionario(int id, String nome, String cargo, LocalDate dataAdmissao) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.dataAdmissao = dataAdmissao;
        this.deFerias = false;
    }

    public Funcionario(int id, String nome, String cargo) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.dataAdmissao = LocalDate.now();
        this.deFerias = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "{id:" + id + ", nome:" + nome + ", cargo:" + cargo + ", dataAdmissao:" + dataAdmissao
                + ", deFerias:" + deFerias + ", saldoFerias:" + saldoFerias + "}";
    }

}
