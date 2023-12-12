package school.sptech;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);
        Conexao conexao = new Conexao();
        Menu menu = new Menu();
//        RegistroDao registro = new RegistroDao();

        JdbcTemplate con = conexao.getConexaoDoBanco();
        Integer opcao;

        con.execute("""
        CREATE TABLE IF NOT EXISTS Registro (
          idRegistro INT PRIMARY KEY AUTO_INCREMENT,
          nomeRegistro VARCHAR(255),
          valorRegitro DECIMAL(10, 2)
        )
        """);


        do {
            menu.exibirMenu();
            opcao = leitor.nextInt();

            switch (opcao) {

                case 1 -> {
                    menu.exibirMemoria();
                    con.update("INSERT INTO Registro (nomeRegistro, valorRegitro) VALUES(?,?)", "Memória em Uso", menu.getMemoriaEmUso());
                    con.update("INSERT INTO Registro (nomeRegistro, valorRegitro) VALUES(?,?)", "Porcentagem de Uso", menu.getPorcentagemDeUsoMemoria());
                }

                case 2 -> {
                    menu.exibirCpu();
                    con.update("INSERT INTO Registro (nomeRegistro, valorRegitro) VALUES(?,?)", "Frequência CPU", menu.getFrequenciaCpu());
                    con.update("INSERT INTO Registro (nomeRegistro, valorRegitro) VALUES(?,?)", "Qtd de CPUs", menu.getQuantidadeCpu());

                }
                case 3 -> {
                    menu.exibirDisco();
                    con.update("INSERT INTO Registro (nomeRegistro, valorRegitro) VALUES(?,?)", "Uso total de Disco", menu.getUsoTotalDisco());
                    con.update("INSERT INTO Registro (nomeRegistro, valorRegitro) VALUES(?,?)", "Qtd disponível de Disco", menu.getQtdDisponivelDisco());
                    con.update("INSERT INTO Registro (nomeRegistro, valorRegitro) VALUES(?,?)", "Qtd de Disco", menu.getQtdDisco());
                    con.update("INSERT INTO Registro (nomeRegistro, valorRegitro) VALUES(?,?)", "Porcentagem de uso de Disco", menu.getPorcentagemDeUsoDisco());

                }
                case 4 -> {
                    menu.exibirTodos();

                    con.update("INSERT INTO Registro (nomeRegistro, valorRegitro) VALUES(?,?)", "Memória em Uso", menu.getMemoriaEmUso());
                    con.update("INSERT INTO Registro (nomeRegistro, valorRegitro) VALUES(?,?)", "Porcentagem de Uso", menu.getPorcentagemDeUsoMemoria());

                    con.update("INSERT INTO Registro (nomeRegistro, valorRegitro) VALUES(?,?)", "Frequência CPU", menu.getFrequenciaCpu());
                    con.update("INSERT INTO Registro (nomeRegistro, valorRegitro) VALUES(?,?)", "Qtd de CPUs", menu.getQuantidadeCpu());

                    con.update("INSERT INTO Registro (nomeRegistro, valorRegitro) VALUES(?,?)", "Uso total de Disco", menu.getUsoTotalDisco());
                    con.update("INSERT INTO Registro (nomeRegistro, valorRegitro) VALUES(?,?)", "Qtd disponível de Disco", menu.getQtdDisponivelDisco());
                    con.update("INSERT INTO Registro (nomeRegistro, valorRegitro) VALUES(?,?)", "Qtd de Disco", menu.getQtdDisco());
                    con.update("INSERT INTO Registro (nomeRegistro, valorRegitro) VALUES(?,?)", "Porcentagem de uso de Disco", menu.getPorcentagemDeUsoDisco());

                }

                case 5 ->{
                    menu.exibirRegistros();

                }


            }
        } while (opcao != 6);
        System.out.println("Até mais...");
    }
}
