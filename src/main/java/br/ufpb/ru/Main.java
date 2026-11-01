package br.ufpb.ru;

import java.util.Scanner;
public class Main {
    public static void main(String [] args){
        double precoTotal = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite a quantidade de almoços: ");
        int N = Integer.parseInt(scan.nextLine());
        for (int i=0; i<N; i++) {
            System.out.println("Digite o preço do almoço: ");
            double preco = Double.parseDouble(scan.nextLine());
            precoTotal+=preco;
        }
        System.out.println("Preço total gasto com almoço: "+ precoTotal);
        scan.close();
    }
}
