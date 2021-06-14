
package classes;
public class BTreeb 
{
       private NoBB raiz;
       public final int N = 4; 

    public void inserir(int info)//Arrumar
    {
        NoBB folha;
        NoBB pai;
        int pos;
        if (raiz == null)
        {
            raiz = new NoBB(info);
        } else
        {
            folha = NavegarAteFolha(info);
            pos = folha.procurarPosicao(info);
            folha.remanejar(pos);
            folha.setTl(folha.getTl()+1);
            folha.setVInfo(pos, info);
            if (folha.getTl() >= N )
            {
                pai = localizarPai(folha, info);
                split(folha, pai);
            }
        }
    }

    public void split(NoBB folha, NoBB pai)//Arrumando
    {
        int pos,i;
        NoBB cx1 = new NoBB();
        NoBB cx2 = new NoBB();
        
        for ( i = 0; i < (Math.round((N-1)/2.0)); i++)
        {
            cx1.setVInfo(i, folha.getVInfo(i));
            cx1.setVLig(i, folha.getVLig(i));
  
        }          
        cx1.setVLig((int)(Math.round((N-1)/2.0)), folha.getVLig((int)(Math.round((N-1)/2.0))));        
        cx1.setTl((int)(Math.round((N-1)/2.0)));
        
        
        for (i = (int)Math.round((N-1)/2.0); i < N; i++)
        {
            cx2.setVInfo(i -(int)Math.round((N-1)/2.0), folha.getVInfo(i));
            cx2.setVLig(i -(int)Math.round((N-1)/2.0), folha.getVLig(i));
        }
        cx2.setVLig(N-1, folha.getVLig(N-1));
        cx2.setTl(i - (int)Math.round((N-1)/2.0));
        
        cx1.setAnt(folha.getAnt());
        cx1.setProx(cx2);
        
        cx2.setAnt(cx1);
        cx2.setProx(folha.getProx());
        
        if(folha.getProx()!= null)
            folha.getProx().setAnt(cx2);
        if(folha.getAnt()!= null)
            folha.getAnt().setProx(cx1);
        folha.setAnt(null);
        folha.setProx(null);
        
        
        if (pai==folha)
        {
            folha.setVInfo(0, cx2.getVInfo(0));
            folha.setVLig(0, cx1);
            folha.setVLig(1, cx2);
            folha.setTl(1);
        }
        else
        {
            pos = pai.procurarPosicao( cx2.getVInfo(0));
            pai.remanejar(pos);
            pai.setTl(pai.getTl()+1);
            pai.setVInfo(pos, cx2.getVInfo(0));
            pai.setVLig(pos, cx1);
            pai.setVLig(pos+1, cx2);
            
            if (pai.getTl() >= N  ) 
            {
                folha = pai;
                pai = localizarPai(pai, folha.getVInfo(0));
                split(folha, pai);
            }
        }
    }
    public NoBB NavegarAteFolha(int info)//Arrumar
    {
        int i;
        NoBB p = raiz;
        while(p.getVLig(0) != null)
        {
            i = 0;
            while(i < p.getTl() && info > p.getVInfo(i))
                i++;
            p = p.getVLig(i);
        }
        
        return p;
    }
    public NoBB localizarPai(NoBB folha, int info)//Arrumar
    {
        NoBB p, pai;
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
    public void exibe(NoBB raiz)//Arrumar
    {
         NoBB aux = raiz;
        if(raiz != null)
        {
            while(aux.getVLig(0) != null)
                aux = aux.getVLig(0);
            
            if(aux.getProx() == null)
            {
                for (int i = 0; i < aux.getTl(); i++) 
                    System.out.print(aux.getVInfo(i) + " ");
                System.out.println("\t");
                aux = aux.getProx();
            }
            else
            {
                 while(aux != null)
                {
                    for (int i = 0; i < aux.getTl(); i++) 
                        System.out.print(aux.getVInfo(i) + " ");
                    System.out.print("\t");
                    aux = aux.getProx();
                
                }
            }
            
           
        }
    }
    public NoBB getRaiz()
    {
        return raiz;
    }     
}
