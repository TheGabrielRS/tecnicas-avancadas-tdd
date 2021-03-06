package br.edu.ufcspa.ListaDuplamenteEncadeada;

import java.lang.annotation.Documented;

/**
 * Created by GabrielRS on 03/09/2016.
 */
public class ListaDuplamenteEncadeada {

    private Nodo inicio;
    private Nodo fim;

    public ListaDuplamenteEncadeada() {
        this.inicio = null;
        this.fim = null;
    }

    /** 
    * Adiciona um Nodo ao fim da lista contendo o valor enviado na string
    * @param    dado    Informação que será adicionada ao fim da lista
    * @return           void
    */
    public void adicionaFim(String dado)
    {
        if(this.inicio != null && this.fim != null)
        {
            Nodo novoNodo = new Nodo(dado);
            novoNodo.setAnterior(this.fim);
            this.fim.setProximo(novoNodo);
            this.fim = novoNodo;
        }

        /*caso não tenha sido iniciado
          poderia ser implementado um flag na própria lista*/
        if(this.inicio == null)
            this.inicio = new Nodo(dado);
        if(this.fim == null)
            this.fim = this.inicio;
    }

    /** 
    * Adiciona um Nodo ao início da lista contendo o valor enviado na string
    * @param    dado    Informação que será adicionada no início da lista
    * @return           void
    */
    public void adicionaInicio(String dado)
    {
        if(this.inicio != null && this.fim != null)
        {
            Nodo novoNodo = new Nodo(dado);
            novoNodo.setProximo(this.inicio);
            this.inicio.setAnterior(novoNodo);
            this.inicio = novoNodo;
        }

        if(this.inicio == null)
            this.inicio = new Nodo(dado);
        if(this.fim == null)
            this.fim = this.inicio;
    }

    
    /**
    * Realiza um loop na lista para exibir os dados no console
    **/
    public void mostraLista()
    {
        Nodo atual = inicio;
        do
        {
            if(atual != null)
            {
                System.out.println(atual.getDado());
                atual = atual.getProximo();
            }
        }while(atual != null);
    }

    /**
    * Busca por um elemento na lista e informa se ele está contido na lista
    * @param    dado    Conteúdo que será procurado nos elementos da lista 
    * @return           Se há algum elemento com o conteúdo pesquisado
    **/
    public boolean buscaElemento(String dado)
    {
        Nodo atual = inicio;
        do
        {
            if(atual != null)
            {
                if(atual.getDado().equals(dado))
                    return true;
                atual = atual.getProximo();
            }
            if(atual.getProximo() == inicio)
                return false;
        }while(atual != null);
        return false;
    }

    /**
    * Adiciona um nodo na posição em uma determinada posição
    * @param    dado    Dado que deve estar dentro do nodo
    * @param    pos     Posição que o nodo deve ser inserido
    * @return           Se o elemento foi incluído com sucesso na posição solicitada
    **/
    public boolean adicionaPosicao(String dado, int pos)
    {
        Nodo atual = inicio;
        int posAtual = 0;

        do {
            if(atual != null)
            {
                if(posAtual == (pos-1)) {
                    Nodo novoNodo = new Nodo(dado);
                    novoNodo.setProximo(atual.getProximo());
                    novoNodo.setAnterior(atual);
                    atual.setProximo(novoNodo);
                    return true;
                }
                atual = atual.getProximo();
                posAtual++;
            }
        }while (atual != null);

        return false;
    }

    /**
    * Remove o nodo da posição determinada
    * @param    pos     Posição do nodo que deve ser removido
    * @return           Se o elemento foi removido com sucesso da posição solicitada
    **/
    public boolean removePosicao(int pos)
    {
        Nodo atual = inicio;
        int posAtual = 0;
        do {
            if(atual != null)
            {
                if(posAtual == (pos-1)) {
                    atual.getAnterior().setProximo(atual.getProximo());
                    atual.getProximo().setAnterior(atual.getAnterior());
                    return true;
                }
                atual = atual.getProximo();
                posAtual++;
            }
        }while (atual != null);

        return false;
    }


}
