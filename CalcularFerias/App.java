import java.time.LocalDate;

import controller.FuncionarioControler;
import models.Funcionario;

public class App {
  public static void main(String[] args) {

    Funcionario f = new Funcionario("Thiago", "DEV", LocalDate.of(2023, 1, 13));

    FuncionarioControler fControler = new FuncionarioControler();
    fControler.calcularFerias(f, LocalDate.of(2024, 10, 13), 30);

    System.out.println(f.toString());
  }
}
