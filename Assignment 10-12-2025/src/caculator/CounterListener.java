package caculator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import caculator.Caculator;

public class CounterListener implements ActionListener {
	private Caculator cal;
	public CounterListener(Caculator caculator) {
		cal = caculator;
	}
	public void actionPerformed(ActionEvent e) {
		String a = e.getActionCommand();
		if ((a.equals("0") || a.equals("1") || a.equals("2") || a.equals("3") || a.equals("4") || a.equals("5") || a.equals("6") || a.equals("7")
				|| a.equals("8") || a.equals("9") || a.equals("+") || a.equals("-") || a.equals("x") || a.equals("/"))) {
			String b = cal.textField.getText() + a;
			cal.textField.setText(b);
		}
		else if (a.equals("C")) {
			String b = cal.textField.getText();
			String c = b.substring(0, b.length() - 1);
			cal.textField.setText(c);
		}
		else {
		if (a.equals("=")) {
			cal.result();
		}
		}
	}
	
}
