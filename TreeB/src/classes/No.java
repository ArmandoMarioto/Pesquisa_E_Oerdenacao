
package classes;

public class No
{
    private int vInfo[];
    private int vPos[];
    private No vLig[];
    private int tl;
    public int N = 2;  
    
    public No()
    {
        vInfo = new int[2*N+1];
        vPos = new int[2*N+1];
        vLig = new No[2*N+2];
    }

    public No(int info, int posArq)
    {
        this();
        vInfo[0] = info;
        vPos[0] = posArq;
        tl = 1;
    }

    public int getVInfo(int p)
    {
        return vInfo[p];
    }

    public int getVPos(int p)
    {
        return vPos[p];
    }

    public No getVLig(int p)
    {
        return vLig[p];
    }

    public int getTl()
    {
        return tl;
    }
    
    
    
    public void setVInfo(int p, int info)
    {
        vInfo[p] = info;
    }

    public void setVPos(int p, int posArq)
    {
        vPos[p] = posArq;
    }

    public void setVLig(int p, No lig)
    {
        vLig[p] = lig;
    }

    public void setTl(int tl)
    {
        this.tl = tl;
    }
    public int procurarPosicao(int info)
    {
        int i;
        i = 0;
        while (i< tl && info > vInfo[i])
            i++;
        return i;
    }

    public void remanejar(int pos)
    {
        int i;
        vLig[tl+1] = vLig[tl];
        
        for (i = tl; i > pos ; i--) {
            vInfo[i] = vInfo[i-1];
            vPos[i] = vPos[i-1];
            vLig[i] = vLig[i-1];
            
        }
    }
    
    public void remanejarExclusao(int pos)
    {
        for (int i = pos; i < tl - 1; i++)
        {
            vInfo[i] = vInfo[i + 1];
            vLig[i] = vLig[i + 1];
            vPos[i] = vPos[i + 1];
        }
            vLig[tl - 1] = vLig[tl];
            tl--;
    }

    void trocaElementoSubstituto(int pos) 
    {
        No aux;
        int substituto;
        aux = vLig[pos+1];
        while(aux.getVLig(0)!= null) //pega substituto da direita 
            aux = aux.getVLig(0);
        if(aux.getTl()-1 > N)
        {
            substituto = vInfo[pos];
            vInfo[pos] = aux.vInfo[0];
            aux.vInfo[0] = substituto;
        }
        else //pega substituto da esquerda
        {
            aux = vLig[pos];
            while(aux.getVLig(aux.getTl())!= null)// nao sei se é tl ou tl+1
                aux = aux.getVLig(aux.getTl());
            if(aux.getTl()-1 > N)
            {
            substituto = vInfo[pos];
            vInfo[pos] = aux.vInfo[aux.getTl()];
            aux.vInfo[aux.getTl()] = substituto;
            }
        }
    }

    boolean redistribuir(No pai, int info,int posPai) 
    {
        No aux = pai.getVLig(posPai+1);
        if(aux.getTl()> N) // redistribuir do vizinho da direita para o NO da exclusao
        {
            setVInfo(tl, pai.getVInfo(posPai));
            tl++;
            pai.setVInfo(posPai,aux.getVInfo(0));
            aux.remanejarExclusao(0);
            return true;
        }
        else
        {
            aux = pai.getVLig(posPai);
            if(aux.getTl()> N) // redistribuir do vizinho da esquerda para o NO da exclusao
            {
                remanejar(0);
                setVInfo(0, pai.getVInfo(posPai));
                tl++;
                pai.setVInfo(posPai,aux.getVInfo(aux.getTl()));
                return true;
            }
        }
        return false;
    }

    void concatenacao(No pai, int info, int posPai,int pos) 
    {
        if(pai.getVLig(posPai).getVInfo(pos) == vInfo[pos])
        {
            
            vInfo[tl++] = pai.getVInfo(posPai);
            pai.remanejarExclusao(posPai);
            
            while(pai.getVLig(posPai+1).getTl()> 0)
            {
               vInfo[tl++] = pai.getVLig(posPai+1).getVInfo(0);
               pai.getVLig(posPai+1).remanejarExclusao(0);
            } 
        }
        else if(pai.getVLig(posPai+1).getVInfo(pos) == vInfo[pos])
        {
            remanejar(0);
            vInfo[0] = pai.getVInfo(posPai);
            pai.remanejarExclusao(posPai);
            tl++;
            
            while(pai.getVLig(posPai).getTl()> 0)
            {
               remanejar(0);
               vInfo[0] = pai.getVLig(posPai).getVInfo(pai.getTl());
               pai.getVLig(posPai).remanejarExclusao(pai.getTl());
               tl++;
            } 
        }
    }
    
}
