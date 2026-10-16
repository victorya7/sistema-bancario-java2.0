package entites;

public class ContaBancaria {
    private String nome;
    private double saldo;

    public ContaBancaria(String nome, double saldo) {
        this.nome = nome;
        this.saldo = saldo;
    }
    public String getNome(){
        return nome;
    }
    public double getSaldo(){
        return saldo;
    }
    public void setSaldo(double saldo){
        this.saldo = saldo;
    }
}
