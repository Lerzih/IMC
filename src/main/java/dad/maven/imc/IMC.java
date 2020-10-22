package dad.maven.imc;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.converter.NumberStringConverter;

public class IMC extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		primaryStage.setTitle("IMC");
		
		DoubleProperty pesoB = new SimpleDoubleProperty(0);
		DoubleProperty alturaB = new SimpleDoubleProperty(0);
		DoubleProperty resultado = new SimpleDoubleProperty(0);
		
		// Containers 
		
		Text weight = new Text("Peso:");
		TextField peso = new TextField();
		peso.setMaxWidth(70);
		Text kg = new Text("kg");
		
		HBox hbox1 = new HBox();
		hbox1.getChildren().addAll(weight, peso, kg);
		
		Text height = new Text("Altura:");
		TextField altura = new TextField();
		altura.setMaxWidth(70);
		Text cm = new Text("cm");
		
		HBox hbox2 = new HBox();
		hbox2.getChildren().addAll(height, altura, cm);
		
		Text imc = new Text("IMC: ");
		Text res = new Text("(peso * altura^2)");
		
		HBox hbox3 = new HBox();
		hbox3.getChildren().addAll(imc, res);
		
		Text estado = new Text("Bajo peso | Normal | Sobrepeso | Obeso");
		HBox hbox4 = new HBox(estado);
		
		VBox vbox = new VBox();
		vbox.getChildren().addAll(hbox1, hbox2, hbox3, hbox4);
		vbox.setSpacing(5);
		vbox.setFillWidth(false);
		vbox.setAlignment(Pos.CENTER);
		
		// Operaciones
		
		pesoB.textProperty().bind
		altura.textProperty().bindBidirectional(alturaB, new NumberStringConverter());
		
		NumberBinding metros = alturaB.valueProperty().multiply(0.10);
		
		// Escena
		
		Scene scene = new Scene(vbox, 400, 250);
	    primaryStage.setScene(scene);
		primaryStage.show();

	}
	
	public static void main(String[] args) {
		
		launch(args);
	}

}
