/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import it.polito.tdp.alien.model.Dizionario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Dizionario dizionario = new Dizionario();

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML
    private Button btnInserisci;

    @FXML
    private Button btnReset;

    @FXML
    private TextField txtParola;

    @FXML
    private TextArea txtResult;

    @FXML
    void doInsert(ActionEvent event) {

    	txtResult.clear();
    	String riga = txtParola.getText().toLowerCase();
    	
    	// Controllo input
    	if(riga == null || riga.length() == 0) {
    		txtResult.setText("Inserisci una o due parole");
    		return;
    	}
    	
    	StringTokenizer st = new StringTokenizer(riga, " ");
    	// Estraggo la prima parola
    	String parolaAliena = st.nextToken();
    	
    	// Se ha più parole devo inserirla nel dizionario
    	if(st.hasMoreTokens()) {
    		
    		// Estraggo la seconda parola
        	String traduzione = st.nextToken();
        	
        	// Controllo valori
        	if(!parolaAliena.matches("[a-zA-Z]*") || !traduzione.matches("[a-zA-Z]*")) {
        		txtResult.setText("Inserisci solo caratteri alfabetici");
        		return;
        	}
        	
        	dizionario.addTraduzione(parolaAliena, traduzione);
        	txtResult.setText("Aggiunta al dizionario "+parolaAliena+" con traduzione: "+traduzione);
    		
    	} else {
    		
    		if(!parolaAliena.matches("[a-zA-Z?]*")) {
        		txtResult.setText("Inserisci solo caratteri alfabetici");
        		return;
        	}
    		
    		String traduzioni;
    		
    		if(parolaAliena.matches("[a-zA-Z?]*")&& !parolaAliena.matches("[a-zA-Z]*")) {
    			traduzioni = dizionario.getTraduzioneWildcard(parolaAliena);
    		} else
	    		traduzioni = dizionario.getTraduzione(parolaAliena);
    		
    		if(traduzioni != null)
    			txtResult.setText(traduzioni);
    		else 
    			txtResult.setText("La parola non esiste nel dizionario.");
    		
    	}
    	
    }

    @FXML
    void doReset(ActionEvent event) {

    }
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {

    	assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    	
    }

}
