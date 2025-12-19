package caculator;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
public class Caculator extends JFrame {
	public JTextField textField = new JTextField();
	public Caculator () {	
		this.setTitle("Caculator");
		this.setSize(300,500);
		
		JPanel panel_Show = new JPanel();
		panel_Show.setLayout(new BorderLayout());
		panel_Show.add(textField, BorderLayout.CENTER);
		
		JPanel panel_Button = new JPanel();
		GridLayout gridLayout = new GridLayout(4,4,5,5);
		panel_Button.setLayout(gridLayout);
		
		ActionListener acl = new CounterListener(this);
		
		JButton button1 = new JButton("7");
		button1.addActionListener(acl);
		JButton button2 = new JButton("8");
		button2.addActionListener(acl);
		JButton button3 = new JButton("9");
		button3.addActionListener(acl);
		JButton button4 = new JButton("+");
		button4.addActionListener(acl);
		JButton button5 = new JButton("4");
		button5.addActionListener(acl);
		JButton button6 = new JButton("5");
		button6.addActionListener(acl);
		JButton button7 = new JButton("6");
		button7.addActionListener(acl);
		JButton button8 = new JButton("-");
		button8.addActionListener(acl);
		JButton button9 = new JButton("1");
		button9.addActionListener(acl);
		JButton button0 = new JButton("2");
		button0.addActionListener(acl);
		JButton button_Plus = new JButton("3");
		button_Plus.addActionListener(acl);
		JButton button_Minus = new JButton("x");
		button_Minus.addActionListener(acl);
		JButton button_Multiple = new JButton("C");
		button_Multiple.addActionListener(acl);
		JButton button_Divide = new JButton("0");
		button_Divide.addActionListener(acl);
		JButton button_Result = new JButton("=");
		button_Result.addActionListener(acl);
		JButton button_Delete = new JButton("/");
		button_Delete.addActionListener(acl);
		
		panel_Button.add(button1);
		panel_Button.add(button2);
		panel_Button.add(button3);
		panel_Button.add(button4);
		panel_Button.add(button5);
		panel_Button.add(button6);
		panel_Button.add(button7);
		panel_Button.add(button8);
		panel_Button.add(button9);
		panel_Button.add(button0);
		panel_Button.add(button_Plus);
		panel_Button.add(button_Minus);
		panel_Button.add(button_Multiple);
		panel_Button.add(button_Divide);
		panel_Button.add(button_Result);
		panel_Button.add(button_Delete);
		
		this.setLayout(new BorderLayout());
		this.add(panel_Show, BorderLayout.NORTH);
		this.add(panel_Button, BorderLayout.CENTER);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public void result() {
		String text = textField.getText() + "";
		CaculatorFunction caculator = new CaculatorFunction();
		try {textField.setText(caculator.calculate(text) + "");}
		catch (ArithmeticException e) {
            textField.setText("Lỗi");
        } catch (Exception e) {
            textField.setText("Lỗi");;
        }
	}
	
}
