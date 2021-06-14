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
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        String palavra[] = {"bssa", "assas", "assasada", "answer", "any", 
                         "by", "bye", "their"}; 
       
        String output[] = {"Not present in trie", "Present in trie"}; 
       
       
       ArvoreTrie arv = new ArvoreTrie();
        // Construindo trie 
        int i; 
        for (i = 0; i < palavra.length ; i++) 
            arv.inserir(palavra[i]); 
       
        // busca por chaves diferentes
        if(arv.busca("bssa") == true) 
            System.out.println("bssa --- " + output[1]); 
        else System.out.println("bssa --- " + output[0]); 
        
        arv.remove(arv.getRaiz(), "bssa",0); 

          
        if(arv.busca("assas") == true) 
            System.out.println("assas --- " + output[1]); 
        else System.out.println("assas --- " + output[0]); 
          
        if(arv.busca("assasada") == true) 
            System.out.println("assasada --- " + output[1]); 
        else System.out.println("assasada --- " + output[0]); 
          
        if(arv.busca("thaw") == true) 
            System.out.println("thaw --- " + output[1]); 
        else System.out.println("thaw --- " + output[0]); 
        
                if(arv.busca("bssa") == true) 
            System.out.println("bssa --- " + output[1]); 
        else System.out.println("bssa --- " + output[0]); 
                        if(arv.busca("assas") == true) 
            System.out.println("assas --- " + output[1]); 
        else System.out.println("assas --- " + output[0]); 
          
        if(arv.busca("assasada") == true) 
            System.out.println("assasada --- " + output[1]); 
        else System.out.println("assasada --- " + output[0]); 
          
    }
    
}
