package lab9;

/**
 *  @author Rakkan Tiasakul 5810546013
 * @version This is a UI class for converter program.
 */

/*
 * Import parts, use for importing .awt / .swing
 */
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/*
 * This UI extends JFrame
 */
public class ConverterUI extends JFrame{
	/*
	 * Constructer as global variables
	 */
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField2;
	private JButton convertButton;
	private JButton clearButton;
	private UnitConverter unitconverter;
	private JComboBox comboBox;
	private JComboBox comboBox_2;
	private JRadioButton leftToRight;
	private JRadioButton rightToLeft;


	public static void main(String[] args) {
		/*
		 * For running program.
		 */
		UnitConverter uc = new UnitConverter();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConverterUI frame = new ConverterUI(uc);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public  ConverterUI(UnitConverter uc){
		/*
		 * to call method initComponents.
		 * The window of Ui is named as Length Converter.
		 */
		this.unitconverter = uc;
		this.setTitle ("Length Converter");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initComponents();
	}

	private void initComponents(){
		/*
		 * The window's height is 100 and width is 600.
		 * To variable ActionListener and KeyListener in these lines.
		 */
		setBounds(100, 100, 600, 100);
		ActionListener convert = new ConvertButtonListener();
		ActionListener clear = new ClearButtonListener();
		ActionListener Left = new ChooseLeftToRight();
		ActionListener Right = new ChooseRightToLeft();
		KeyListener convertEnter = new ConvertButtonListener();


		/*
		 * JPanel which called contentPane, uses FlowLayout for locating every JButton, JTextField and JLabel to be flow. 
		 */
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER,5,5));
		
		/*
		 * This sets the first JTextFied and calling ActionListener for method ConvertButtonListener.
		 */
		textField = new JTextField();
		contentPane.add(textField);
		textField.setColumns(10);
		textField.addActionListener(convert);
		
		/*
		 * This sets the first JComboBox. It gets the units from Unit class (which calls Length class). Then add the Item into the comboBox.
		 * Call ActionListener for method ConvertButtonListener but press the Enter button on Keyboard instead og clicking on UI window.
		 */
		comboBox = new JComboBox<Unit>();
		Unit[] lengths = unitconverter.getUnits();
		for (Unit u : lengths) comboBox.addItem(u);
		comboBox.addKeyListener(convertEnter);
		contentPane.add(comboBox);
		
		/*
		 * This sets JLabel as "=".
		 */
		JLabel label = new JLabel("=");
		contentPane.add(label);
		
		/*
		 * This sets the second JTextFied and calling ActionListener for method ConvertButtonListener.
		 */
		textField2 = new JTextField();
		contentPane.add(textField2);
		textField2.setColumns(10);
		textField2.addActionListener(convert);
		
		/*
		 * This sets the second JComboBox. It gets the units from Unit class (which calls Length class). Then add the Item into the comboBox.
		 * Call ActionListener for method ConvertButtonListener but press the Enter button on Keyboard instead og clicking on UI window.
		 */
		
		comboBox_2 = new JComboBox<Unit>();
		Unit[] lengths2 = unitconverter.getUnits();
		for (Unit a : lengths) comboBox_2.addItem(a);
		comboBox_2.addKeyListener(convertEnter);
		contentPane.add(comboBox_2);
		
		/*
		 * This sets convert button. Clicking on this button would get the value after the program has converted. 
		 * It adds ActionListener for method ConvertButtonListener.
		 */
		convertButton = new JButton("Convert!");
		convertButton.addActionListener(convert);
		contentPane.add(convertButton);
		
		/*
		 * This sets clear button. Clicking on this button would make the textField and textField2 be empty space.
		 * It adds ActionListener for method ClearButtonListener.
		 */
		clearButton = new JButton("Clear");
		clearButton.addActionListener(clear);
		contentPane.add(clearButton);

		/*
		 * This sets Left->Right radio-button. Clicking on this button would set the textField2 be not editable, but show the value after converting instead.
		 * It adds ActionListener for method ChooseLeftToRight.
		 * When we running the program first time, this radio-button would be set as selected.
		 */
		leftToRight = new JRadioButton("Left -> Right");
		leftToRight.addActionListener(Left);
		leftToRight.setSelected(true);
		contentPane.add(leftToRight);

		/*
		 * This sets Right->Left radio-button. Clicking on this button would set the textField be not editable, but show the value after converting instead.
		 * It adds ActionListener for method ChooseRightToLeft.
		 */
		rightToLeft = new JRadioButton("Right -> Left");
		rightToLeft.addActionListener(Right);
		contentPane.add(rightToLeft);

	}


	class ChooseLeftToRight implements ActionListener {
		/*
		 * (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 * @version This method implements ActionListener. Using for clicking on Left to Right button
		 * after clicking on that button textField would be editable while textField2 would not. 
		 * But the value after converting will be showed in textField2 instead.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			textField.setEditable(true);
			textField2.setEditable(false);	
			leftToRight.setSelected(true);
			rightToLeft.setSelected(false);
		}
	}
	class ChooseRightToLeft implements ActionListener {
		/*
		 * (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 *  @version This method implements ActionListener. Using for clicking on Right to Left button
		 * after clicking on that button textField2 would be editable while textField would not. 
		 * But the value after converting will be showed in textField instead.
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			textField2.setEditable(true);
			textField.setEditable(false);	
			rightToLeft.setSelected(true);
			leftToRight.setSelected(false);
		}
	}
	class ConvertButtonListener implements ActionListener, KeyListener{
		/*
		 * the action to perform action when convert button on UI or  the enter button on keyboard is pressed.
		 * This implements both ActionListener and KeyListener.
		 */
		public void convert(){
			/*
			 * This is a method for converting the unit.
			 * @exception to throw the exception if the input is not a number.
			 */
			String s = textField.getText().trim();
			String u = textField2.getText().trim();
			System.out.println("actionPerformed : input = " +s);
			System.out.println("actionPerformed : input = " +u);
			if (s.length() > 0 || u.length() > 0){
				try{
					Unit temp1 =  (Unit)comboBox.getSelectedItem();
					Unit temp2 = (Unit)comboBox_2.getSelectedItem();
					if(leftToRight.isSelected()){
						double value = Double.valueOf(s);
						textField2.setText(Double.toString(unitconverter.convert(value, temp1, temp2)));
					}
					else{
						double value = Double.valueOf(u);
						textField.setText(Double.toString(unitconverter.convert(value, temp2, temp1)));
					}
				}catch (NumberFormatException e){
					e.printStackTrace();
				}
			}
		}

		/*
		 * (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 * to call convert() method.
		 */
		public void actionPerformed (ActionEvent evt){
			this.convert();
		}
		/*
		 * (non-Javadoc)
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
		 * These three interface belong to KeyListener.
		 * In this case, we only need to press the Enter button on a keyboard for converting instead of clicking Convert button on UI
		 * So we write the condition in KeyPressed only and at the value of Enter button in KeyCode, then we call the method convert();
		 * 
		 */
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			/*
			 * Do nothing.
			 */
		}
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_ENTER){
				this.convert();
			}
		}
		@Override
		public void keyReleased(KeyEvent e) {
			/*
			 * Do nothing.
			 */
		}
	}


	class ClearButtonListener implements ActionListener{
		/*
		 * @version  This method implements ActionListener, use for set textField to be ""
		 * after clicking on clear button.
		 */
		public void actionPerformed (ActionEvent evt){
			textField.setText("");
			textField2.setText("");
		}
	}
}
