
package trabdepo;

public class lista extends No
{
    private ListaGen cabeca;
    private ListaGen cauda;

    public lista() 
    {
    }

    public lista(ListaGen cabeca, ListaGen cauda) {
        this.cabeca = cabeca;
        this.cauda = cauda;
    }

    public ListaGen getCabeca() {
        return cabeca;
    }

    public void setCabeca(ListaGen cabeca) {
        this.cabeca = cabeca;
    }

    public ListaGen getCauda() {
        return cauda;
    }

    public void setCauda(ListaGen cauda) {
        this.cauda = cauda;
    }


    
    
}
