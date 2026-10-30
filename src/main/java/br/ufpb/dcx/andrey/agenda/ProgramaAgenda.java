//MODED BY ANDREY :D
// NAO TERMINEI AINDA
// APRIMOREI UMAS COISAS E ADICIONEI OUTRAS, 100% NA MÃO, CHORA CLAUDE
// o codigo esta tambem no meu github se quiser ver como esta ficando.


package br.ufpb.dcx.andrey.agenda;

import javax.swing.JOptionPane;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;


public class ProgramaAgenda {
    public static void agenda(){
        int maxContatos = 1000;
        AgendaEnderecos agenda = new AgendaEnderecos(maxContatos);
        boolean sair = false;
        while (!sair) {
            int opcao = Integer.parseInt(JOptionPane.showInputDialog(
                    "Digite uma opção:\n1.Cadastrar contato\n"
                            +"2.Pesquisa endereço\n"
                            + "3.Pesquisa número de contatos do bairro\n"
                            + "4.Apaga contato\n5.Sair\n"));
            switch(opcao) {
                case 1:
                    String nome = JOptionPane.showInputDialog("Qual o nome?");
                    String logradouro = JOptionPane.showInputDialog("Qual o logradouro (Rua, Av...)?");
                    String numero = JOptionPane.showInputDialog("Qual o número?");
                    String bairro = JOptionPane.showInputDialog("Qual o bairro?");
                    Endereco end = new Endereco(logradouro,numero,bairro,"João Pessoa","Paraíba");
                    Contato c = new Contato(nome, end);
                    agenda.cadastraContato(c);
                    break;
                case 2:
                    String nomeContato = JOptionPane.showInputDialog("Qual o nome do contato?");
                    Endereco enderecoAchado = agenda.pesquisaEndereco(nomeContato);
                    if (enderecoAchado!=null) {
                        JOptionPane.showMessageDialog(null, enderecoAchado.toString());
                    } else {
                        JOptionPane.showMessageDialog(null, "Contato não encontrado");
                    }
                    break;
                case 3:
                    String nomeBairro = JOptionPane.showInputDialog("Qual bairro?");
                    int numContatosBairro = agenda.pesquisarQuantidadeDeContatosDoBairro(nomeBairro);
                    JOptionPane.showMessageDialog(null, "Quantidade:"+numContatosBairro);
                    break;
                case 4:
                    String nomeContatoApagar = JOptionPane.showInputDialog("Qual o nome do contato?");
                    boolean apagou = agenda.apagaContato(nomeContatoApagar);
                    if (apagou) {
                        JOptionPane.showMessageDialog(null, "Contato removido com sucesso");
                    } else {
                        JOptionPane.showMessageDialog(null, "Falha: Contato não encontrado.");
                    }
                    break;
                case 5:
                    sair = true;
                    break;
            }

        }
        JOptionPane.showMessageDialog(null, "Até mais!");
    }
    public static void main(String [] args) {
        // Constantes
        int maxContacts = 1000;
        AgendaEnderecos agenda = new AgendaEnderecos(maxContacts);

        // Criando a janela
        JFrame frame = new JFrame();
        JButton listContacts = new JButton("Listar Contatos");
        JButton createContact = new JButton("Criar Contato");
        JLabel textLabel = new JLabel("Bem Vinda :D",SwingConstants.CENTER); // Cria titulo e centraliza
        textLabel.setBounds(0,0,480,30); // Tamanho do Label
        textLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // Cria borda no Label

        // Configura Botões
        createContact.setBounds(0,40,200,30);
        // Modo antigo de configurar acao de botoes, jdk8+ usa Lambda
        createContact.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                String nome = JOptionPane.showInputDialog("Digite o Nome do Contato.");
                String logradouro = JOptionPane.showInputDialog("Digite o Nome da Rua.");
                String numero = JOptionPane.showInputDialog("Digite o Número da Casa.");
                String bairro = JOptionPane.showInputDialog("Digite o Bairro.");
                String cidade = JOptionPane.showInputDialog("Digite a Cidade.");
                String estado = JOptionPane.showInputDialog("Digite o estado.");

                Endereco addr = new Endereco(logradouro,numero,bairro,cidade,estado);
                Contato c = new Contato(nome,addr);
                agenda.cadastraContato(c);

            }
        } );
        listContacts.setBounds(0,80,200,30);
        listContacts.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                ArrayList<String> nome = new ArrayList<String>();
                List<Contato> lista = agenda.listarContatos();
                for (Contato c: lista){
                    nome.add(c.getNome());
                }
                JOptionPane.showMessageDialog(null, nome, "Lista de Contatos", JOptionPane.INFORMATION_MESSAGE);
            }
        });



        // Configura Frame
        frame.setLayout(null); // Remove o gerenciador de layou padrão do JFrame
        frame.add(createContact);
        frame.add(listContacts);
        frame.add(textLabel);
        frame.setSize(500,500); // Define o tamanho do frame principal
        frame.setLocationRelativeTo(null); // Centraliza o frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Finaliza o processo ao fechar o frame
        frame.setVisible(true);

    }
}