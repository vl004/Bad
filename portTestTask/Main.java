package portTestTask;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Component;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.swing.JScrollPane;

public class Main {

	private JFrame frmMohylevetsVladPort;
	private JTextField txtA;
	private JButton btnNewButton;
	private JTextPane txtpnTheTaoGave;
	private JTextArea textArea;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmMohylevetsVladPort.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMohylevetsVladPort = new JFrame();
		frmMohylevetsVladPort.setTitle("Mohylevets Vlad Porta One BaD Test Task");
		frmMohylevetsVladPort.setBounds(100, 100, 847, 452);
		frmMohylevetsVladPort.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMohylevetsVladPort.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 38, 561, 356);
		frmMohylevetsVladPort.getContentPane().add(scrollPane);
		
		txtpnTheTaoGave = new JTextPane();
		scrollPane.setViewportView(txtpnTheTaoGave);
		txtpnTheTaoGave.setText("The Tao gave birth to machine language.  Machine language gave birth\r\nto the assembler.\r\nThe assembler gave birth to the compiler.  Now there are ten thousand\r\nlanguages.\r\nEach language has its purpose, however humble.  Each language\r\nexpresses the Yin and Yang of software.  Each language has its place within\r\nthe Tao.\r\nBut do not program in COBOL if you can avoid it.\r\n        -- Geoffrey James, \"The Tao of Programming\"");
		
		JLabel lblNewLabel = new JLabel("Enter ur text here:");
		lblNewLabel.setBounds(10, 11, 104, 14);
		frmMohylevetsVladPort.getContentPane().add(lblNewLabel);
		
		btnNewButton = new JButton("Calculate");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String initText = txtpnTheTaoGave.getText();
				List<String> words = new ArrayList<>(Arrays.asList( initText.split("[\\[\\]\\(\\)\\'\\\"\\s\\.\\,\\/:;_-]") ));
				List<Character> firstLetters = new ArrayList<>();
				
				for (int i = 0; i < words.size(); i++) {
					String word = words.get(i);
					if (word.length() > 0) {
						char firstLetter = '\0';
						
						for (int j = 0; j < word.length(); j++) {
							char currentLetter = word.charAt(j);
							
							int lenghtWithoutCurrent = 
									word.length() - 
									word.replaceAll( 
											String.valueOf(currentLetter), "" 
									).length();
							
							
							if (lenghtWithoutCurrent == 1) {
								firstLetter = currentLetter;
								break;
							}
						}
						
						firstLetters.add(firstLetter);
					}
				}
				
				textArea.setText("");
				textArea.append(firstLetters.toString());
				
				char result = '\0';
				for (int i = 0; i < firstLetters.size(); i++) {
					char currentLetter = firstLetters.get(i);
					
					boolean unique = true;
					for (int j = i+1; j < firstLetters.size(); j++) {
						if (firstLetters.get(j) == currentLetter) {
							unique = false;
							break;
						}
					}
					
					if (unique) {
						result = currentLetter;
						break;
					}
				}
				txtA.setText(String.valueOf(result));
			}
		});
		btnNewButton.setBounds(581, 43, 89, 23);
		frmMohylevetsVladPort.getContentPane().add(btnNewButton);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(581, 119, 240, 146);
		frmMohylevetsVladPort.getContentPane().add(scrollPane_1);
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		scrollPane_1.setViewportView(textArea);
		textArea.setEditable(false);
		
		JLabel lblTheFirstCharacter = new JLabel("The first character which is no \r\n");
		lblTheFirstCharacter.setBounds(581, 77, 176, 23);
		frmMohylevetsVladPort.getContentPane().add(lblTheFirstCharacter);
		
		JLabel lblLongerRepeatedIn = new JLabel("longer repeated in the word:");
		lblLongerRepeatedIn.setBounds(581, 95, 176, 23);
		frmMohylevetsVladPort.getContentPane().add(lblLongerRepeatedIn);
		
		JLabel lblNewLabel_1 = new JLabel("The first unique character from the set above:");
		lblNewLabel_1.setBounds(581, 276, 240, 14);
		frmMohylevetsVladPort.getContentPane().add(lblNewLabel_1);
		
		txtA = new JTextField();
		txtA.setHorizontalAlignment(SwingConstants.CENTER);
		txtA.setFont(new Font("Tahoma", Font.PLAIN, 26));
		txtA.setBounds(581, 301, 39, 41);
		frmMohylevetsVladPort.getContentPane().add(txtA);
		txtA.setColumns(10);
	}
	public JButton getBtnNewButton() {
		return btnNewButton;
	}
	public JTextPane getTxtpnTheTaoGave() {
		return txtpnTheTaoGave;
	}
	public JTextField getTxtA() {
		return txtA;
	}
	public JTextArea getTextArea() {
		return textArea;
	}
}
