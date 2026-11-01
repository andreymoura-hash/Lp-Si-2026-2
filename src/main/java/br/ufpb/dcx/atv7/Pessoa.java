package br.ufpb.dcx.atv7;

public class Pessoa {
    private String nome;
    private int idade;
    public Pessoa(String nome, int idade){
        if (nome == null){
            return;
        }
        this.nome = nome;
        this.idade = idade;
    }
    public Pessoa(){
        this("", 0);
    }
    public int getIdade(){
        return this.idade;
    }
    public void setIdade(int idade){
        this.idade = idade;
    }
    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public boolean ehDeMaior(){
        if(this.idade >= 18){
            return true;
        }
        return false;
    }

}
