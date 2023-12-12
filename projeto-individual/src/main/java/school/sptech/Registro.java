package school.sptech;

public class Registro {
    //ATRIBUTOS
        private int idRegistro;
        private String nomeRegistro;
        private double valorRegitro;

     //CONSTRUTOR
        public Registro(int idRegistro, String nomeRegistro, double valorRegitro) {
            this.idRegistro = idRegistro;
            this.nomeRegistro = nomeRegistro;
            this.valorRegitro = valorRegitro;
        }

     //GETTERS E SETTERS

    public int getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(int idRegistro) {
        this.idRegistro = idRegistro;
    }

    public String getNomeRegistro() {
        return nomeRegistro;
    }

    public void setNomeRegistro(String nomeRegistro) {
        this.nomeRegistro = nomeRegistro;
    }

    public double getValorRegitro() {
        return valorRegitro;
    }

    public void setValorRegitro(double valorRegitro) {
        this.valorRegitro = valorRegitro;
    }
}
