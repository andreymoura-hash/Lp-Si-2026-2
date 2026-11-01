package br.ufpb.dcx.atv7.banco;

import java.util.ArrayList;
import java.util.Scanner;

public class BancoList {
    private String nome;
    private String cnpj;
    private ArrayList<Conta> contas;

    public BancoList(String nome, String cnpj, ArrayList<Conta> contas) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.contas = contas;
    }

    public String toString() {
        return "Banco " + this.nome + " de CNPJ " + this.cnpj + " e que tem " + this.contas.size() + " contas";
    }

    public void transferir(String numContaO, String numAgO, String numContaD, String numAgenciaD, double valor) {
        for(Conta c: contas) {
            if (c.getNumeroConta().equals(numContaO) && c.getNumeroAgencia().equals(numAgO) && c.getSaldo()>=valor) {
                c.debitar(valor);
            }
            if(c.getNumeroConta().equals(numContaD) && c.getNumeroAgencia().equals(numAgenciaD)){
                c.creditar(valor);
            }
        }
    }

    public void abrirConta(String cpfTitular, String numConta, String numAgencia, double saldoInicial) {
        Conta c = new Conta(cpfTitular, numConta, numAgencia, saldoInicial);
        contas.add(c);
    }

    public ArrayList<Conta> pesquisarContasComSaldoNegativo() {
        ArrayList<Conta> contanegativa = new ArrayList<Conta>();
        for (Conta c: contas){
            if (c.getSaldo()<0.0){
                contanegativa.add(c);
            }
        }
        return contanegativa;
    }

    public double consultarSaldoDeConta(String numConta, String numAgencia) {
        double saldo = 0;
        for (Conta c : this.contas) {
            if (c.getNumeroConta().equals(numConta) && c.getNumeroAgencia().equals(numAgencia)) {
                saldo = c.getSaldo();
            }
        }
        return saldo;
    }// ...

    public double sacarDeConta(String numConta, String numAgencia, double valor) {
        double saldo = 0;
        for(Conta c: contas){
            if (c.getNumeroConta().equals(numConta)&& c.getNumeroAgencia().equals(numAgencia)){
                c.debitar(valor);
                saldo = c.getSaldo();
            }
        }
        return saldo;
    }

    public double depositarEmConta(String numConta, String numAgencia, double valor) {
        double saldo = 0;
        for (Conta c: contas){
            if(c.getNumeroConta().equals(numConta) && c.getNumeroAgencia().equals(numAgencia)){
                c.creditar(valor);
                saldo = c.getSaldo();
            }
        }
        return saldo;
    }

    public ArrayList<Conta> pesquisarContasDoCliente(String cpf) {
        ArrayList<Conta> contasCliente = new ArrayList<Conta>();
        for(Conta c: contas){
            if(c.getCpfTitular().equals(cpf)){
                contasCliente.add(c);
            }
        }
        return contasCliente;
    }
}
