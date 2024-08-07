import java.awt.*;
import java.awt.event.*;

class Calculator extends WindowAdapter implements ActionListener
{
    public Frame mainframe;
    public Button b1, b2, b3, b4;
    public TextField t1, t2;
    public Label lobj;
    public Label sign;
    Float no1, no2;

    public Calculator(int width, int height, String title)
    {
        mainframe = new Frame(title);
        mainframe.setSize(width, height);
        mainframe.addWindowListener(this);

        b1 = new Button("ADD");
        b2 = new Button("SUB");
        b3 = new Button("MULT");
        b4 = new Button("DIV");

        t1 = new TextField();
        t2 = new TextField();

        Font textFieldFont = new Font("Arial", Font.PLAIN, 15);
        t1.setFont(textFieldFont);
        t2.setFont(textFieldFont);

        // x, y, width, height
        b1.setBounds(10, 280, 80, 40);
        b2.setBounds(100, 280, 80, 40);
        b3.setBounds(190, 280, 80, 40);
        b4.setBounds(280, 280, 80, 40);

        t1.setBounds(70, 100, 100, 40);
        t2.setBounds(220, 100, 100, 40);

        mainframe.add(b1);
        mainframe.add(b2);
        mainframe.add(b3);
        mainframe.add(b4);

        mainframe.add(t1);
        mainframe.add(t2);

        lobj = new Label();
        lobj.setBounds(100, 180, 300, 100);

        Font resultFont = new Font("Arial", Font.PLAIN, 18);
        lobj.setFont(resultFont);

        sign = new Label();
        sign.setBounds(190, 100, 40, 40);

        Font signFont = new Font("Arial", Font.PLAIN, 24);
        sign.setFont(signFont);

        mainframe.add(lobj);
        mainframe.add(sign);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);

        mainframe.setLayout(null);
        mainframe.setVisible(true);
    }

    public void windowClosing(WindowEvent obj)
    {
        System.exit(0);
    }

    public void actionPerformed(ActionEvent aobj)
    {
        try
        {
            no1 = Float.parseFloat(t1.getText());
            no2 = Float.parseFloat(t2.getText());

            if (aobj.getSource() == b1)
            {
                lobj.setText("Addition is : " + (no1 + no2));
                sign.setText("+");
            }
            else if (aobj.getSource() == b2)
            {
                lobj.setText("Subtraction is : " + (no1 - no2));
                sign.setText("-");
            }
            else if (aobj.getSource() == b3)
            {
                lobj.setText("Multiplication is : " + (no1 * no2));
                sign.setText("*");
            }
            else if (aobj.getSource() == b4)
            {
                if (no2 != 0)
                {
                    lobj.setText("Division is : " + (no1 / no2));
                    sign.setText("/");
                }
                else
                {
                    lobj.setText("Cannot divide by zero");
                    sign.setText("/");
                }
            }
        }
        catch (Exception obj)
        {
            lobj.setText("Invalid input");
            sign.setText("");
        }
    }
}

class MarvellousCalculator
{
    public static void main(String Arg[])
    {
        Calculator cobj = new Calculator(400, 400, "Marvellous PPA");
    }
}