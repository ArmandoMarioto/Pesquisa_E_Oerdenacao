package arquivopo;


public class Main 
{

    //método principal
    public static void main(String args[])
    {
        Arquivo_Java a = new Arquivo_Java("c:\\arquivo.dat");
        a.leArq();
        a.exibirArq();
    }   
    
}
