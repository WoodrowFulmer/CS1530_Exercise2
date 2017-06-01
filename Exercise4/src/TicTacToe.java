import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;

public class TicTacToe {
    JFrame _frame = new JFrame("Tic-Tac-Toe");
	JButton[] _buttons = new JButton[9];
	JButton reset;
	static boolean flop;

	public TicTacToe()
	{
		_frame.setSize(400, 400);
		_frame.setVisible(true);
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		JPanel _ttt = new JPanel();
		JPanel _newPanel = new JPanel();
		_ttt.setLayout(new GridLayout(3, 3));
		_newPanel.setLayout(new FlowLayout());
		_frame.add(_ttt, BorderLayout.NORTH);
		_frame.add(_newPanel, BorderLayout.SOUTH);
		for (int j=0; j<9; j++) 
		{
			// Make a new button in the array location with text "_"
			_buttons[j] = new JButton("_");
			// Associate a new ButtonListener to the button (see below)
			ActionListener buttonListener = new ButtonListener();
			_buttons[j].addActionListener(buttonListener);
			// Set the font on the button
			_buttons[j].setFont(new Font("Courier", Font.PLAIN, 48));
			// Add this button to the _ttt panel
			_ttt.add(_buttons[j]);
		}
		reset = new JButton("Reset");
		ActionListener resetListener = new ResetListener();
		reset.addActionListener(resetListener);
		reset.setFont(new Font("Courier", Font.PLAIN, 48));
		_newPanel.add(reset);
	   // Refresh window - otherwise we will not be able to see it
		// THIS IS A COMMON SOURCE OF BUGS!
		_frame.setVisible(true);
	}
	
    public static void main(String[] args) {
		flop = false;
		new TicTacToe();
    }
	
	private class ButtonListener implements ActionListener {
		// Every time we click the button, it will perform
		// the following action.
		public void actionPerformed(ActionEvent e) {

			JButton source = (JButton) e.getSource();
			String currentText = source.getText();
			if (currentText.equals("_")) 
			{
				if(flop)
					source.setText("O");
				else
					source.setText("X");
				flop = !flop;
				source.removeActionListener(source.getActionListeners()[0]);
			} 
			else 
				source.setText("_");
		}
	}
	
	private class ResetListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JButton source = (JButton) e.getSource();
			for(JButton b: _buttons)
			{
				b.setText("_");
				ActionListener listeners[] = b.getActionListeners();
				for(ActionListener l: listeners)
					b.removeActionListener(l);
				b.addActionListener(new ButtonListener());
			}
		}
	}
}