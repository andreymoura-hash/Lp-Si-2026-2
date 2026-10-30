//MODED BY ANDREY :D

package br.ufpb.dcx.andrey.agenda;

import java.util.ArrayList;
import java.util.List;

public class AgendaEnderecos {
    private int maxContatos;
    private List<Contato> contatos;

    public AgendaEnderecos(int maxContatos) {
        this.maxContatos = maxContatos;
        this.contatos = new ArrayList<Contato>(maxContatos);
    }
    public boolean apagaContato(String nomeContato) {
        if (nomeContato == null){
            return false;
        }
        for (int k = 0; k < contatos.size(); k++) {
            Contato c = contatos.get(k);
            if (c != null && c.getNome() != null && c.getNome().equalsIgnoreCase(nomeContato)) {
                contatos.remove(k);
                return true;
            }
        }
        return false;
    }

    public boolean cadastraContato(Contato c) {
        if (c == null || contatos.size() >= maxContatos){
            return false;
        }
        return contatos.add(c);
    }
    public Endereco pesquisaEndereco(String nomeContato) {
        if (nomeContato == null){
            return null;
        }
        for (int k=0; k<contatos.size(); k++) {
            Contato c = contatos.get(k);
            if (c != null && c.getNome() != null && c.getNome().equalsIgnoreCase(nomeContato)) {
                return c.getEndereco();
            }
        }
        return null;
    }
    public int pesquisarQuantidadeDeContatosDoBairro(String bairro) {
        int cont = 0;
        if (bairro == null){
            throw new IllegalArgumentException("O nome do bairro não pode ser nulo.");
        }
        for (int k=0; k<contatos.size(); k++) {
            Contato c = contatos.get(k);
            if (c != null && c.getEndereco() != null && c.getEndereco().getBairro() != null &&
                    c.getEndereco().getBairro().equalsIgnoreCase(bairro)) {
                cont++;
            }
        }
        return cont;
    }
    public List<Contato> listarContatos(){
        return new ArrayList<Contato>(this.contatos);
    }

}