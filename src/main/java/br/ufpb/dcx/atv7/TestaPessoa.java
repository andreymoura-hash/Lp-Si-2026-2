package br.ufpb.dcx.atv7;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
public class TestaPessoa {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        ArrayList<Pessoa> listaPessoas = new ArrayList<Pessoa>();
        int i = 0;
        while(i<5){
            System.out.println("Digite o nome de uma pessoa.");
            String nome = scan.nextLine();
            System.out.println("Digite a idade da pessoa.");
            int idade = Integer.parseInt(scan.nextLine());
            Pessoa p = new Pessoa(nome,idade);
            listaPessoas.add(p);
            i++;
        }
        for (Pessoa p: listaPessoas){
            if (p.ehDeMaior()){
                System.out.println(p.getNome()+"é de maior");
            }else{
                System.out.println(p.getNome()+"é de menor");
            }
        }
        scan.close();
    }
}
