package fi.tuni.prog3.calc;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML
    private Label fieldRes;
    
    @FXML
    private Label labelRes;
    
    @FXML
    private TextField fieldOp2;
    
    @FXML
    private TextField fieldOp1;
    
    @FXML
    private Label labelOp1;
    
    @FXML
    private Button btnAdd;
    
    @FXML
    private Button btnSub;
    
    @FXML
    private Button btnMul;

    @FXML
    private Button btnDiv;
    
    
    @FXML
    private void Addition() {
        double result = Double.parseDouble(fieldOp1.getText())+
                Double.parseDouble(fieldOp2.getText());
        fieldRes.setText(Double.toString(result));
    }
    
    @FXML
    private void Subtraction() {
        double result = - Double.parseDouble(fieldOp2.getText())+
                Double.parseDouble(fieldOp1.getText());
        fieldRes.setText(Double.toString(result));
    }
    
    @FXML
    private void Multiplication() {
        double result = Double.parseDouble(fieldOp2.getText())*
                Double.parseDouble(fieldOp1.getText());
        fieldRes.setText(Double.toString(result));
    }
    
    @FXML
    private void Division() {
        double result = Double.parseDouble(fieldOp1.getText())/
                Double.parseDouble(fieldOp2.getText());
        fieldRes.setText(Double.toString(result));
    }
       
}
