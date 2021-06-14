
package poosegundobim;

import classes.BTree;
import classes.BTreeb;
import java.util.Random;


public class POOSegundoBim
{
    
        public static void btree()
    {
        Random r = new  Random();
        BTree a = new BTree();
        a.inserir(1,0);
        a.inserir(4,0);
        a.inserir(7,0);
        a.inserir(10,0);
        a.inserir(17,0);
        a.inserir(21,0);
        a.inserir(31,0);
        a.inserir(25,0);
        a.inserir(19,0);
        
        //a.excluir(21);
      //a.inserir(20);
      //a.inserir(28);
      //a.inserir(42);
        
        
       // for (int i = 0; i < 10; i++)
           // a.inserir(r.nextInt(26),0);
        a.in_ordem(a.getRaiz());
    }
    
       public static void btreeb()
    {
        BTreeb a = new BTreeb();
        a.inserir(1);
        a.inserir(4);
        a.inserir(7);
        a.inserir(10);
        a.inserir(17);
        a.inserir(21);
        a.inserir(31);
        a.inserir(25);
        a.inserir(19);
      //a.inserir(20);
      //a.inserir(28);
      //a.inserir(42);

        a.exibe(a.getRaiz());
    }

    public static void main(String[] args)
    {
        btree();

    }


}
