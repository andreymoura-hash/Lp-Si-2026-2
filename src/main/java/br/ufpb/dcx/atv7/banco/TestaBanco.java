package br.ufpb.dcx.atv7.banco;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.JOptionPane;


public class TestaBanco {
    public static void main(String [] args) {

        // Labels
        JLabel titleLabel = new JLabel("Test Label", SwingConstants.CENTER);
        titleLabel.setBounds(0,0,500,30);
        titleLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        // Define and formar buttons
        JButton firstButton = new JButton("Test");
        firstButton.setBounds(0,40,200,30);
        firstButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                BancoList meuBanco = new BancoList("Ayla's Bank","123/321",new ArrayList<Conta>());
                meuBanco.abrirConta("111.111.111-11", "222-2", "333-3",100);
                meuBanco.abrirConta("222.222.222-99","444-4","555-5", 200);
                meuBanco.transferir("222-2","333-3","444-4","555-5",100);
                System.out.println(meuBanco.getConta("222-2", "333-3"));
                System.out.println(meuBanco.consultarSaldoDeConta("444-4", "555-5"));
            }
        });


        // Define and format main frame.
        JFrame mainFrame = new JFrame("BancoCN");
        mainFrame.add(titleLabel);
        mainFrame.add(firstButton);
        mainFrame.setSize(500,500);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setLayout(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setVisible(true);

    }
}

