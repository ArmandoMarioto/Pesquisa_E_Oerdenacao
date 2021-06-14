
package classes;



public class BTree
{
    private No raiz;
    public final int N = 2; 

    public void inserir(int info, int posArq)
    {
        No folha;
        No pai;
        int pos;
        if (raiz == null)
        {
            raiz = new No(info, posArq);
        } else
        {
            folha = NavegarAteFolha(info);
            pos = folha.procurarPosicao(info);
            folha.remanejar(pos);
            folha.setTl(folha.getTl() + 1);
            folha.setVInfo(pos, info);
            folha.setVPos(pos, posArq);
            if (folha.getTl() > 2 * N)
            {
                pai = localizarPai(folha, info);
                split(folha, pai);
            }
        }
    }

    public void split(No folha, No pai)
    {
        int pos;
        No cx1 = new No();
        No cx2 = new No();
        
        for (int i = 0; i < N; i++)
        {
            cx1.setVInfo(i, folha.getVInfo(i));
            cx1.setVPos(i, folha.getVPos(i));
            cx1.setVLig(i, folha.getVLig(i));
  
        }          
        cx1.setVLig(N, folha.getVLig(N));        
        cx1.setTl(N);
        for (int i=N+1;i < 2*N+1; i++)
        {
            cx2.setVInfo(i-(N+1), folha.getVInfo(i));
            cx2.setVPos(i-(N+1), folha.getVPos(i));
            cx2.setVLig(i-(N+1), folha.getVLig(i));
        }
        cx2.setVLig(N, folha.getVLig(2*N+1));
        cx2.setTl(N);
        if (pai==folha)
        {
            folha.setVInfo(0, folha.getVInfo(N));
            folha.setVPos(0, folha.getVPos(N));
            folha.setVLig(0, cx1);
            folha.setVLig(1, cx2);
            folha.setTl(1);
        }
        else
        {
            pos = pai.procurarPosicao( folha.getVInfo(N));
            pai.remanejar(pos);
            pai.setTl(pai.getTl()+1);
            pai.setVInfo(pos, folha.getVInfo(N));
            pai.setVPos(pos, folha.getVPos(N));
            pai.setVLig(pos, cx1);
            pai.setVLig(pos+1, cx2);
            if (pai.getTl() > 2*N) 
            {
                folha = pai;
                pai = localizarPai(pai, folha.getVInfo(N));
                split(folha, pai);
            }
        }
    }
    public No NavegarAteFolha(int info)
    {
        int i;
        No aux = raiz;
        No p = raiz;
        while(p.getVLig(0) != null)
        {
            i = 0;
            while(i < p.getTl() && info > p.getVInfo(i))
                i++;
            p = p.getVLig(i);
        }
        
        return p;
    }
    public No localizarPai(No folha, int info)
    {
        No p, pai;
        int i;
        p = raiz;
        pai = p;
        while(p!=folha)
        {
            i = 0;
            while(i <p.getTl() && info >p.getVInfo(i))
            {
                i++;
            }
            pai = p;
            p = p.getVLig(i);
        }
        return pai;
    }
    public void in_ordem(No raiz)
    {
         int i;
        if(raiz != null)
        {
            for (i = 0; i < raiz.getTl(); i++) 
            {
                in_ordem(raiz.getVLig(i));
                 System.out.print(raiz.getVInfo(i) + " ");
                
            }
            in_ordem(raiz.getVLig(i));
        }
    }
    
    public boolean excluir(int info)
    {
        No no,pai;
        int pos,posPai;
        if (raiz == null)
        {
            return false;
        } else
        {
            no = procura_no_exclusao(info);//procura o NO em que o elemento esteja para excluir 
            pos = no.procurarPosicao(info); // procura a posição do elemento no NO
            if (no.getVInfo(pos) == info)   //verifica se realmente achou o NO e a posição
            {
                if(isFolha(no) && (no.getTl()-1)>= N)//Primeiro caso ,Remoção de uma chave em um nó folha,sem causar underflow 
                {
                    no.remanejarExclusao(pos);
                    return true;
                }else          
                if(!isFolha(no)) //Segundo caso, Remoção de uma chave em um nó não folha 
                {
                    no.trocaElementoSubstituto(pos);
                    return excluir(info);
                }else
                if(isFolha(no) && (no.getTl()-1) < N) //Terceiro caso ,Remoção de uma chave em um nó folha,causando underflow 
                {
                    pai = localiza_pai(no, info);
                    posPai = pai.procurarPosicao(no.getVInfo(pos));

                    if(no.redistribuir(pai,info,posPai))
                        return excluir(info);
                    else //Quarto caso ,Remoção de uma chave em um nó,causando underflow e a redistribuição não pode ser aplicada
                    {
                       no.concatenacao(pai,info,posPai,pos);
                       if(pai.getTl() < N)
                       {
                           no = pai;
                           pai = localiza_pai(no, info);
                           posPai = pai.procurarPosicao(no.getVInfo(pos));
                           if(pai.getVLig(posPai).getTl()> N)
                           {
                               no.redistribuir(pai, info, posPai);
                           }else if(pai.getVLig(posPai+1).getTl()> N)
                           {
                               pai.getVLig(posPai+1).redistribuir(pai, info, posPai);
                           }
                           else
                           {
                               no.concatenacao(pai,info,posPai,pos);
                               setRaiz(no);
                           }
                       }
                       return excluir(info);
                    }
                }

            }
        }
        return true;
    }
    
    public No localiza_pai(No folha, int info)
    {
        No aux, pai;
        int i;
        aux = raiz;
        pai = aux;
        while (aux != folha)
        {
            i = 0;
            while (i < aux.getTl() && info > aux.getVInfo(i))
            {
                i++;
            }
            pai = aux;
            aux = aux.getVLig(i);
        }
        return pai;
    }
        
    public boolean isFolha(No no)
    {
        for(int i = 0 ; i < no.getTl() ; i++)
        {
            if(no.getVLig(i) != null)
                return false;
        }
        return true;
        
    }
    
        public No procura_no_exclusao(int info)
    {
        int i;
        No aux = raiz;
        while (aux.getVLig(0) != null)
        {
            i = 0;
            while (i < aux.getTl() && info > aux.getVInfo(i))
            {
                i++;
            }
            if (info == aux.getVInfo(i))
            {
                return aux;
            }
            aux = aux.getVLig(i);

        }
        return aux;
    }
    public No getRaiz()
    {
        return raiz;
    }    

    public void setRaiz(No raiz) {
        this.raiz = raiz;
    }
    
    
}
