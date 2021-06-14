/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author Armando
 */
public class ArvoreTrie 
{
    private No raiz;
    
    
    public void inserir(String palavra) 
    { 
        int i,posicao;
        
        if(raiz == null)
           raiz = new No();
        No trie = raiz; 
        for (i = 0; i < palavra.length(); i ++) // for para percorre a palavra de caracter em caracter
        { 
            posicao = palavra.charAt(i) - 'a';  // acha a posição desse caracter no vetor 
            if (trie.getvLig(posicao) == null)  //se a ligação for nula ,é pq o caracter ainda nao esta na arvore
            {
                trie.setvInfo(posicao,palavra.charAt(i)); // insere o caracter no vetor
                trie.setvLig(posicao, new No());           // cria uma ligação desse caracter
            }
            trie = trie.getvLig(posicao);   //caracter ja esta na arvore e vai para o proximo
        }
        trie.setFinalPalavra(palavra);  // palabra inteira na arvore , entao marca como ali tem um final de palavra
    } 
    
    public boolean busca(String palavra) 
    { 
        int i,posicao;
        No trie = raiz; 
       
        for (i = 0; i < palavra.length(); i++) 
        { 
            posicao = palavra.charAt(i) - 'a'; 
       
            if (trie.getvLig(posicao) == null) 
                return false; 
       
            trie = trie.getvLig(posicao); 
        } 
       
        return (trie != null && (trie.getFinalPalavra().equals(palavra))); 
    } 
    
    public No remove(No r,String palavra,int depth)
    { 
        
        if (r == null) // Se a árvore estiver vazia
            return null; 
        
        if (depth == palavra.length()) // Se o último caractere da chave estiver sendo processado
        { 
            if (!r.getFinalPalavra().isEmpty()) // Este nó não é mais o fim da palavra depois , remoção da chave fornecida
                r.setFinalPalavra("");
            
            if (vazia(r)) // Se dado não é prefixo de nenhuma outra palavra
            {
                r = null; 
            } 
            return r; 
        } 

        // Se não for o último caracter, retorne para a filho
        // obtido usando o valor ASCII
        int posicao = palavra.charAt(depth) - 'a'; 
        r.setvLig(posicao, remove(r.getvLig(posicao), palavra,depth + 1));

        // Se o root não tem nenhum filho (seu único filho obteve
        // excluído) e não é o fim de outra palavra.
        if (vazia(r) && !"".equals(r.getFinalPalavra())) 
        { 
            r = null; 
        } 

        return r; 
    }
    
    public boolean vazia(No no) 
    { 
        for (int i = 0; i < 26; i++) 
            if (no.getvLig(i)!= null) 
                return false; 
        return true; 
    }

    public No getRaiz() {
        return raiz;
    }

    public void setRaiz(No raiz) {
        this.raiz = raiz;
    }
    
    
}
