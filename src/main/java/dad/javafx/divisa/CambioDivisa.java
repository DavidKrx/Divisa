package dad.javafx.divisa;

import javafx.application.Application; 

import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField; 
import javafx.stage.Stage; 
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CambioDivisa extends Application {   
	Divisa euro = new Divisa("Euro", 1.0);
	Divisa libra = new Divisa("Libra", 0.8873);
	Divisa dolar = new Divisa("Dolar", 1.2007);
	Divisa yen = new Divisa("Yen", 133.59);
	Divisa origen = yen;
	Divisa destino = dolar; 
	Double cantidad = 2000.0; 
private TextField origenText;
   private TextField destinoText;
   private ComboBox<Divisa> origenCombo;
   private ComboBox<Divisa> destinoCombo;
   private Button cambiarButton;
   
   private Divisa [] divisas= {euro, libra, dolar, yen};
	   @Override 
	   public void start(Stage stage) {       
		    
		   	origenText = new TextField("0");
	        origenText.setPrefColumnCount(4);
	       
	        origenCombo = new ComboBox<>();
	        origenCombo.getItems().addAll(divisas);
	        origenCombo.getSelectionModel().select(euro);
	       
	        HBox origenHBox = new HBox();
	        origenHBox.setAlignment(Pos.BASELINE_CENTER);
	        origenHBox.setSpacing(5);
	        origenHBox.getChildren().addAll(origenText, origenCombo);
	        
	        destinoText = new TextField("0");
	        destinoText.setPrefColumnCount(4); 

	        destinoCombo = new ComboBox<>();
	        destinoCombo.getItems().addAll(divisas);
	        destinoCombo.getSelectionModel().select(libra);	
	        
	        HBox destinoHBox = new HBox();
	        destinoHBox.setAlignment(Pos.BASELINE_CENTER);
	        destinoHBox.setSpacing(5);
	        destinoHBox.getChildren().addAll(destinoText, destinoCombo);
	        
	        cambiarButton = new Button("Cambiar");
	        cambiarButton.setOnAction(e-> onCambiarAction(e));
	       
	        VBox root = new VBox();
	        root.setSpacing(5);
	        root.setAlignment(Pos.CENTER);
	        root.getChildren().addAll(origenHBox, destinoHBox, cambiarButton);
	        
	        
	        Scene scene = new Scene(root, 320, 200);
	        stage.setTitle("CambioDivisa");
	        stage.setScene(scene);
	        stage.show();
	  
	   } 
   private void onCambiarAction(ActionEvent e) {
		Double cantidadOrigen= Double.parseDouble(origenText.getText());
		Divisa divisaOrigen= origenCombo.getSelectionModel().getSelectedItem();
		Divisa divisaDestino= destinoCombo.getSelectionModel().getSelectedItem();
		
		Double enEuros= divisaOrigen.toEuro(cantidadOrigen);
		Double cantidadDestino=divisaDestino.fromEuro(enEuros);
		
		destinoText.setText(""+cantidadDestino);
	}
public static void main(String args[]){ 
      launch(args); 
   } 
}
