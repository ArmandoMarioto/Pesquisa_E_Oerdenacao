
package arquivopo;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Registro 
{
    public final int tf = 20;//variavel do tipo "final" é constante
    private int codigo, tl = tf, idade;
    private char nome[] = new char[tf];

    public Registro()
    {
    }

    public Registro(int codigo, String Snome, int idade)
    {
        this.codigo = codigo; //this é variavel de estancia
        this.idade = idade;
        this.tl = Snome.length();
        for (int i = 0; i < Snome.length(); i++)
        {
            nome[i] = Snome.charAt(i);
        }
    }

    public int getCodigo()
    {
        return (codigo);
    }

    public String getNome()
    {
        String Snome = new String(nome);
        return (Snome);
    }

    public void gravaNoArq(RandomAccessFile arquivo)
    {
        try
        {
            arquivo.writeInt(codigo);
            arquivo.writeInt(idade);
            arquivo.writeInt(tl);
            for (int i = 0; i < tf; i++)
            {
                arquivo.writeChar(nome[i]);
            }
        } catch (IOException e)
        { }
    }

    public void leDoArq(RandomAccessFile arquivo)
    {
        try
        {
            this.codigo = arquivo.readInt();
            this.idade = arquivo.readInt();
            this.tl = arquivo.readInt();
            for (int i = 0; i < this.tf; i++)
                this.nome[i] = arquivo.readChar();
            for (int i = tl; i < tf; i++)
                this.nome[i] = ' ';
        } catch (IOException e)
        { }
    }

    public void exibirReg()
    {
        int i;
        System.out.print("codigo....." + this.codigo);
        System.out.print(" nome.......");
        String Snome = new String(nome);
        System.out.print(Snome);
        System.out.println(" idade......." + this.idade);
        System.out.println("----------------------------------");
    }

    static int length()
    {
        return (52); //int codigo, tl=20, idade; ------------> 12 bytes
        //private char nome[] = new char[20]; --> 40 bytes
        //------------------------------------------------- +
        //                      Total : 40 + 12 = 52 bytes
    }
}
