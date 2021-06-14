
package trabdepo;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Stack;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private Label lbPrimeiraString;
    @FXML
    private Label lbSegundaString;
    @FXML
    private TextField tfConfirmar;
    @FXML
    private Button btnConfirmar;
    private ListaGen atual;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        tfConfirmar.setText("[[[aa],bb]],[aaaaa]");
    }    

    @FXML
    private void evtConfirmar(ActionEvent event) 
    {
        String[] s = tfConfirmar.getText().split("\\[");
        int j ;
        Stack pilha = new Stack();
        
        for (int i = 0; i < s.length; i++) 
        {
            atual = new ListaGen(new lista());
            pilha.push(atual);
            j = 0;
            

            while(j < s[i].length())
            {
                if(s[i].charAt(j) == ',')
                {
                    atual.tail(new ListaGen(new lista()));
                    atual = atual.tail(atual);
                }
                else
                if(s[i].charAt(j) == ']')
                {
                    atual = (ListaGen) pilha.pop();
                }else
                {
                    if(atual.Nula(atual))
                        atual.CriAtomo((s[i].charAt(j)+""));
                    else
                    {
                        ((atomo)atual.getNo()).setInfo(((atomo)atual.getNo()).getInfo()+(s[i].charAt(j)));
                    }
                }
  
                j++;
            }
            
            System.out.println(s[i]);
            
        }
        
        lbSegundaString.setText(atual.exibe(atual));
    }
    
}
