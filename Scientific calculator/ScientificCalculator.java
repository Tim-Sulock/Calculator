import java.awt.*;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.event.*;

public class ScientificCalculator extends JFrame
{
   private JPanel panel;
   private JButton zerob, multb, oneb, twob, threeb, fourb, fiveb, sixb, sevenb, eightb, nineb, clearb, decimalb, addb, divideb, subb, rootb, factorialb, squareb, lastb, equalsb; 
   int l = 525, w = 350;
   private JTextField textfield;
   private JLabel lab2; 
   private ImageIcon im;
   
   public ScientificCalculator()
   {
      setTitle("Scientific Calculator");
      setLocation(500,200);
      setSize(w,l);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      textfield = new JTextField(16);
      im = new ImageIcon("goldenRamLogo.png");
      zerob=new JButton("0");
      oneb=new JButton("11");
      twob=new JButton("2");
      threeb=new JButton("3");
      fourb=new JButton("4");
      fiveb=new JButton("5");
      sixb=new JButton("6");
      sevenb=new JButton("7");
      eightb=new JButton("8");
      nineb=new JButton("9");
      clearb=new JButton("clear");
      decimalb=new JButton(".");
      addb=new JButton("+");
      multb=new JButton("*");
      divideb=new JButton("/");
      subb=new JButton("-");
      rootb=new JButton("√");
      factorialb=new JButton("!");
      squareb=new JButton("x^2");
      lastb=new JButton("1/x");
      equalsb=new JButton("=");
      lab2= new JLabel(im);
      lab2.setIcon(im);
      
      panel = new JPanel();
      panel.add(textfield);
      panel.add(clearb);
      panel.add(decimalb);
      panel.add(addb);
      panel.add(multb);
      panel.add(divideb);
      panel.add(equalsb);
      panel.add(rootb);
      panel.add(subb);
      panel.add(zerob);
      panel.add(oneb);
      panel.add(twob);
      panel.add(threeb);
      panel.add(fourb);
      panel.add(fiveb);
      panel.add(sixb);
      panel.add(sevenb);
      panel.add(eightb);
      panel.add(nineb);
      panel.add(factorialb);
      panel.add(squareb);
      panel.add(lastb);
      panel.add(lab2);
      panel.setBackground(Color.black);
      add(panel);
      setVisible(true);
      
      zerob.addActionListener(new ButtonClickListener());
      oneb.addActionListener(new ButtonClickListener());
      twob.addActionListener(new ButtonClickListener());
      threeb.addActionListener(new ButtonClickListener());
      fourb.addActionListener(new ButtonClickListener());
      fiveb.addActionListener(new ButtonClickListener());
      sixb.addActionListener(new ButtonClickListener());
      sevenb.addActionListener(new ButtonClickListener());
      eightb.addActionListener(new ButtonClickListener());
      nineb.addActionListener(new ButtonClickListener());
      clearb.addActionListener(new clearbListener());
      decimalb.addActionListener(new decimalbListener());
      addb.addActionListener(new addbListener());
      divideb.addActionListener(new dividebListener());
      subb.addActionListener(new subbListener());
      rootb.addActionListener(new rootbListener());
      factorialb.addActionListener(new factorialbListener());
      squareb.addActionListener(new squarebListener());
      lastb.addActionListener(new lastbListener());
      multb.addActionListener(new multbListener());
      equalsb.addActionListener(new equalsbListener());
   }
      
   
   class ButtonClickListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         JButton source = (JButton) e.getSource();
         String buttonText = source.getText();
         updateDisplay(buttonText);
      }
   
   }
   class clearbListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         textfield.setText("");
      }
   } 
   class decimalbListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         updateDisplay(".");
      }
   } 
   class addbListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         updateDisplay("+");
      }
   } 
   class dividebListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         updateDisplay("/");
      }
   } 
   class subbListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         updateDisplay("-");
      }
   } 
   class rootbListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         updateDisplay("√");
      }
   } 
   class factorialbListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         updateDisplay("!");
      }
   } 
   class squarebListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         updateDisplay("^2");
      }
   } 
   class lastbListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         updateDisplay("1/");
      }
   }
   class multbListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         updateDisplay("*");
      }
   } 
   class equalsbListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         evaluateExpression();
      }
   }
   
   public void updateDisplay(String text) {
      String currentText = textfield.getText();
      textfield.setText(currentText + text);
   }

   public void evaluateExpression() {
      String currentText = textfield.getText();
    try {
        // Evaluating the expression
        String[] parts = currentText.split("\\s+"); // Splitting by whitespace
        int operand1 = Integer.parseInt(parts[0]);
        String operator = parts[1];
        int operand2 = Integer.parseInt(parts[2]);
        
        int result;
        switch (operator) {
            case "+":
                result = operand1 + operand2;
                break;
            case "-":
                result = operand1 - operand2;
                break;
            case "*":
                result = operand1 * operand2;
                break;
            case "/":
                result = operand1 / operand2;
                break;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
        
        textfield.setText(Integer.toString(result));
    } catch (NumberFormatException | ArrayIndexOutOfBoundsException | ArithmeticException e) {
        textfield.setText("error");
    }
}
   

   
   
   public static void main(String args[]){
      ScientificCalculator tt = new ScientificCalculator();
   }  
}