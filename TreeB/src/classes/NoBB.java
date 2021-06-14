
package classes;

public class NoBB 
{
    private int vInfo[];
    private NoBB vLig[];
    private NoBB ant,prox;
    private int tl;
    public int N = 4;
    
        public NoBB()
    {
        vInfo = new int[N];
        vLig = new NoBB[N+1];
        ant = prox = null;
        
    }

    public NoBB(int info)
    {
        this();
        vInfo[0] = info;
        tl = 1;
    }

    public int getVInfo(int p)
    {
        return vInfo[p];
    }


    public NoBB getVLig(int p)
    {
        return vLig[p];
    }

    public int getTl()
    {
        return tl;
    }

    public NoBB getAnt() {
        return ant;
    }

    public void setAnt(NoBB ant) {
        this.ant = ant;
    }

    public NoBB getProx() {
        return prox;
    }

    public void setProx(NoBB prox) {
        this.prox = prox;
    }
    
    
    
    public void setVInfo(int p, int info)
    {
        vInfo[p] = info;
    }


    public void setVLig(int p, NoBB lig)
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
        vLig[tl+1] = vLig[tl];
        
        for (int i = tl; i > pos ; i--) 
        {
            vInfo[i] = vInfo[i-1];
            vLig[i] = vLig[i-1];
            
        }
    }
}
