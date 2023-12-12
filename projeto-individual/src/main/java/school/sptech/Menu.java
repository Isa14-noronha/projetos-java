package school.sptech;

import com.github.britooo.looca.api.core.Looca;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class Menu {
//ATRIBUTOS
    private double memoriaTotal = 0.0;
    private double memoriaEmUso = 0.0;
    private double porcentagemDeUsoMemoria = 0.0;
    private double frequenciaCpu = 0.0;
    private double quantidadeCpu = 0.0;
    private double usoTotalDisco = 0.0;
    private double qtdDisponivelDisco = 0.0;
    private double qtdDisco = 0.0;
    private double porcentagemDeUsoDisco = 0.0;

    Looca looca = new Looca();
    Conexao conexao = new Conexao();

    JdbcTemplate con = conexao.getConexaoDoBanco();


// MÉTODOS
        public void exibirMenu() {
            System.out.println("""
                   
                    _-_-_-_-_-_-_-_ BEM-VINDO _-_-_-_-_-_-_-_
                    Escolha quais componentes gostaria de vi-
                    sualizar 
                                    
                    1 - Memória
                    2 - CPU
                    3 - Disco
                    4 - Todos
                    5 - Exibir Registros
                    6 - Sair
                                    
                    _-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_
                    """);
        }


        public void exibirMemoria () {

            System.out.println("Lendo Memória...");
             memoriaTotal = looca.getMemoria().getTotal() / 100000000.0;
             memoriaEmUso = looca.getMemoria().getEmUso() / 100000000.0;
            porcentagemDeUsoMemoria = memoriaEmUso * 100.0 / memoriaTotal;

            System.out.println("""
                    Memória total: %.2f
                    Memória sendo usada: %.2f
                    Porcentagem do uso da memória: %.2f%%
                    """.formatted(memoriaTotal, memoriaEmUso, porcentagemDeUsoMemoria));


        }

        public void exibirCpu () {

            System.out.println("Lendo Cpu...");
            frequenciaCpu = looca.getProcessador().getFrequencia() / 1000000000.0;
            quantidadeCpu = looca.getProcessador().getNumeroCpusFisicas();

            System.out.println("""
                    Frequência da CPU: %.2f Hz 
                    Quantidade de CPUs Físicas: %.2f
                    """.formatted(frequenciaCpu, quantidadeCpu));


        }


        public void exibirDisco () {


            System.out.println("Lendo Disco...");
            usoTotalDisco = looca.getGrupoDeDiscos().getVolumes().get(0).getTotal() / 1000000000;
            qtdDisponivelDisco = looca.getGrupoDeDiscos().getVolumes().get(0).getDisponivel() / 1000000000;
            qtdDisco = looca.getGrupoDeDiscos().getQuantidadeDeDiscos();
            porcentagemDeUsoDisco = (usoTotalDisco - qtdDisponivelDisco) * 100.0 / usoTotalDisco;

            System.out.println("""
                    Cpacidade total de Disco: %.2f 
                    Cpacidade disponível de Disco: %.2f
                    Quantidade de Discos: %.2f
                    Porcentagem de uso Discos: %.2f%%
                    """.formatted(usoTotalDisco, qtdDisponivelDisco, qtdDisco, porcentagemDeUsoDisco));


        }

    public void exibirRegistros() {
        List<Registro> registros = con.query("SELECT * FROM Registro", new RegistroRowMapper());

        if (registros.isEmpty()) {
            System.out.println("Não há registros no banco de dados.");
        } else {
            System.out.println("Registros no banco de dados:");
            for (Registro registro : registros) {
                System.out.println("ID: " + registro.getIdRegistro() +
                        ", Nome: " + registro.getNomeRegistro() +
                        ", Valor: " + registro.getValorRegitro());
            }
        }
    }


        public void exibirTodos () {
            exibirMemoria();
            exibirDisco();
            exibirCpu();

        }



        //GETTERS E SETTERS
    public double getMemoriaTotal() {
        return memoriaTotal;
    }

    public void setMemoriaTotal(double memoriaTotal) {
        this.memoriaTotal = memoriaTotal;
    }

    public double getMemoriaEmUso() {
        return memoriaEmUso;
    }

    public void setMemoriaEmUso(double memoriaEmUso) {
        this.memoriaEmUso = memoriaEmUso;
    }

    public double getPorcentagemDeUsoMemoria() {
        return porcentagemDeUsoMemoria;
    }

    public void setPorcentagemDeUsoMemoria(double porcentagemDeUsoMemoria) {
        this.porcentagemDeUsoMemoria = porcentagemDeUsoMemoria;
    }

    public double getFrequenciaCpu() {
        return frequenciaCpu;
    }

    public void setFrequenciaCpu(double frequenciaCpu) {
        this.frequenciaCpu = frequenciaCpu;
    }

    public double getQuantidadeCpu() {
        return quantidadeCpu;
    }

    public void setQuantidadeCpu(double quantidadeCpu) {
        this.quantidadeCpu = quantidadeCpu;
    }

    public double getUsoTotalDisco() {
        return usoTotalDisco;
    }

    public void setUsoTotalDisco(double usoTotalDisco) {
        this.usoTotalDisco = usoTotalDisco;
    }

    public double getQtdDisponivelDisco() {
        return qtdDisponivelDisco;
    }

    public void setQtdDisponivelDisco(double qtdDisponivelDisco) {
        this.qtdDisponivelDisco = qtdDisponivelDisco;
    }

    public double getQtdDisco() {
        return qtdDisco;
    }

    public void setQtdDisco(double qtdDisco) {
        this.qtdDisco = qtdDisco;
    }

    public double getPorcentagemDeUsoDisco() {
        return porcentagemDeUsoDisco;
    }

    public void setPorcentagemDeUsoDisco(double porcentagemDeUsoDisco) {
        this.porcentagemDeUsoDisco = porcentagemDeUsoDisco;
    }

}
