package br.ufpb.ru;

import java.util.Scanner;
public class Teste3 {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        System.out.println("Quantas refeições foram servidas hoje?");
        int quantidadeRefeicoes = Integer.parseInt(leitor.nextLine());
        RefeicaoRealizada [] refeicoes = new RefeicaoRealizada[quantidadeRefeicoes];
        for (int k = 0; k < quantidadeRefeicoes; k++) {
            System.out.println("Matrícula do(a) aluno(a) [" + (k + 1) + "]");
            String matricula = leitor.nextLine();
            System.out.println("Qual o tipo de refeição? CAFÉ, ALMOÇO ou JANTAR"); String tipoRefeicao = leitor.nextLine();
            refeicoes[k] = new RefeicaoRealizada(matricula, tipoRefeicao);
            System.out.printf("%s\n", refeicoes[k].toString());
        }
// TODO: Código a acrescentar
        int quantidadeDeAlmoco = 0;
        boolean teveCafe;
        for(int i=0; i<refeicoes.length; i++){
            if(refeicoes[i].getTipoRefeicao().equalsIgnoreCase("almoco")
                    || refeicoes[i].getTipoRefeicao().equalsIgnoreCase("almoço")){
                quantidadeDeAlmoco++;
            } else if (refeicoes[i].getTipoRefeicao().equalsIgnoreCase("cafe")
                    || refeicoes[i].getTipoRefeicao().equalsIgnoreCase("café")) {
                teveCafe = true;
            }
        }

        System.out.println("Quantidade de almoços foi: "+ quantidadeDeAlmoco);
        if(teveCafe = true){
            System.out.println("SIM");
        } else{
            System.out.println("NÃO");
        }
        System.out.printf("FIM DO PROGRAMA");
        leitor.close();
    }// fim do main
} // fim da classe Teste 3
