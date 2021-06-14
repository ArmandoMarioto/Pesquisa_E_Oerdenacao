
package trabdepo;

public class ListaGen 
{
    private No nodo;

    public ListaGen() 
    {
    }

    public ListaGen(No no) 
    {
        this.nodo = no;
    }

    public No getNo() 
    {
        return nodo;
    }

    public void setNo(No no) 
    {
        this.nodo = no;
    }
    
    public ListaGen CriAtomo(String info)
    {
        return new ListaGen(new atomo(info));
    }
    
    public ListaGen Construir(ListaGen h,ListaGen t)
    {
        if(t.getNo() instanceof atomo)
        {
            System.out.println("Erro");
            return null;
        }
        else
        {
            
            return new ListaGen(new lista(((lista)h.getNo()).getCabeca(),((lista)h.getNo()).getCauda()));    
        }
    }
    public boolean Nula(ListaGen no)
    {
        return no.getNo()==null;
    }
    
    public ListaGen head(ListaGen h)
    {
        if(Nula(h) || h.getNo() instanceof atomo)
        {
            System.out.println("Erro");
            return null;
        }
        else 
            return ((lista)h.getNo()).getCabeca();
    }
    
    public ListaGen tail(ListaGen t)
    {
        if(Nula(t) || t.getNo() instanceof atomo)
        {
            System.out.println("Erro");
            return null;
        }
        else 
            return ((lista)t.getNo()).getCauda();
    }
    
    public String exibe (ListaGen l)
    {
        String s="";
        if(!Nula(l))
        {
            if(l.getNo() instanceof atomo)
                s = s +((atomo)l.getNo()).getInfo();
                //System.out.println(((atomo)l.getNo()).getInfo());
            else
            {
                s = s + "[";
                System.out.println("[ ");
                
                while(!Nula(l))
                {
                    exibe(head(l));
                    l = tail(l);
                    if(!Nula(l))
                        s = s + ",";
                       // System.out.println(",");
                }
                s = s + "]";
               // System.out.println("]");
            }
        }
        return s;
    }
}
