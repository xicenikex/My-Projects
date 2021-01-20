import javafx.application.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.geometry.*;

@SuppressWarnings("restriction")

public class InterestTableGUI extends Application {

	private Button button1, button2, button3;
	private TextArea tA;
	private TextField principle, rate;
	private double years;

	@Override
	public void start(Stage firstStage) throws Exception {
		int sceneWidth = 650, sceneHeight = 650;
		int spaceBetweenNodes = 8;
		int paneBorderTop = 20, paneBorderRight = 20;
		int paneBorderBottom = 20, paneBorderLeft = 20;
		int verSpaceBetweenNodes = 8, horSpaceBetweenNodes = 8;
		
		VBox pane = new VBox(spaceBetweenNodes);
		pane.setPadding(new Insets(paneBorderTop, paneBorderRight, 
				paneBorderBottom, paneBorderLeft));
		
		tA = new TextArea();
		tA.setPrefSize(600, 100);
		tA.setWrapText(true);
		ScrollPane scrollPane = new ScrollPane(tA);

		FlowPane flowPane = new FlowPane();
		flowPane.setHgap(horSpaceBetweenNodes);
		flowPane.setVgap(verSpaceBetweenNodes);
		flowPane.setPadding(new Insets(paneBorderTop, paneBorderRight, 
				paneBorderBottom, paneBorderLeft));
		
		FlowPane flowpane2 = new FlowPane();
		flowpane2.setHgap(horSpaceBetweenNodes);
		flowpane2.setVgap(verSpaceBetweenNodes);
		flowpane2.setPadding(new Insets(paneBorderTop, paneBorderRight, 
				paneBorderBottom, paneBorderLeft));
		
		Label principleLabel = new Label("Principle: ");
		principle = new TextField();
		flowPane.getChildren().addAll(principleLabel, principle);

		Label rateLabel = new Label("Rate (Percentage): ");
		rate = new TextField(); 
		flowPane.getChildren().addAll(rateLabel, rate);
		
		pane.getChildren().add(scrollPane);
		pane.getChildren().addAll(flowPane);

		Slider horizontalSlider = new Slider();
		horizontalSlider.setMin(1);
		horizontalSlider.setMax(25);
		horizontalSlider.setValue(1);
		horizontalSlider.setMajorTickUnit(4);
		horizontalSlider.setShowTickMarks(true);
		horizontalSlider.setShowTickLabels(true);
		horizontalSlider.valueProperty().addListener(e -> { years = horizontalSlider.getValue();});
		pane.getChildren().addAll(horizontalSlider);

		button1 = new Button("SimpleInterest");
		button2 = new Button("CompoundInterest");
		button3 = new Button("BothInterest");
		
		button2.setOnAction((EventHandler<ActionEvent>) new ButtonHandler());
		
		flowpane2.getChildren().addAll(button1, button2, button3);
		pane.getChildren().addAll(flowpane2);
		
		button1.setOnAction(e -> {
		double principleValue = Double.parseDouble(principle.getText());
		double rateValue = Double.parseDouble(rate.getText());
			tA.setText(Calculations.computeSimpleInterest(principleValue, rateValue, years));
		});
		 
		button3.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				double principleValue = Double.parseDouble(principle.getText());
				double rateValue = Double.parseDouble(rate.getText());
				
				tA.setText(Calculations.bothStrings(principleValue, rateValue, years));
			}
		});

		Scene scene = new Scene(pane, sceneWidth, sceneHeight);
		firstStage.setTitle("Payment Computation");
		firstStage.setScene(scene);
		
		firstStage.show();
	}
	
	private class ButtonHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			double principleValue = Double.parseDouble(principle.getText()); 
			double rateValue = Double.parseDouble(rate.getText()); 
			tA.setText(Calculations.computeCompoundInterest(principleValue, rateValue, years));
					}			
	};
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}
