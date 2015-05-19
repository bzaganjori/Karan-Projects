package source;

import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class CaesarCipher extends JFrame {
	
	/**
	 * @author 	Benjamin Zaganjori
	 * @date 	03/13/2015
	 */
	
	/* Create a JFrame */
	private static final long serialVersionUID = 1L;
	static JFrame frame = new JFrame("Caesar Cipher");
	private boolean translateVal = true;
	
	/* Default class */
	public CaesarCipher() {
		main();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void main() {
		/* Create the components for the JFrame */
		JLabel label1 = new JLabel("Input:");
		JLabel label2 = new JLabel("Output:");
		JLabel label3 = new JLabel("Key value:");
		JRadioButton toggleEncrypt = new JRadioButton("Encrypt");
		JRadioButton toggleDecrypt = new JRadioButton("Decrypt");
		JComboBox combo = new JComboBox();
		JTextField field1 = new JTextField(20);
		JTextField field2 = new JTextField(20);
		JButton cipher = new JButton("Go");
		JButton copy = new JButton("Copy");
		JButton close = new JButton("Close");
		
		/* Set the LAF to that of the current system */
		try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | 
        		InstantiationException | 
        		IllegalAccessException | 
        		UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
		
		/* Action listener for "Go" button */
		cipher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int key = Integer.parseInt(combo.getSelectedItem().toString());
				String str = null;
				if (translateVal == false) str = convert(field1.getText(), key);
				else str = translate(field1.getText(), key);
				field2.setText(str);
			}
		});
		
		/* ActionListener for "Copy" button */
		copy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				Clipboard clipboard = toolkit.getSystemClipboard();
				StringSelection str = new StringSelection(field2.getText());
				clipboard.setContents(str, null);
			}
		});
		
		/* ActionListener for "Close" button */
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				System.exit(0);
			}
		});
		
		/* ActionListener for the encrypt radio button */
		toggleEncrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (translateVal == false) {
					toggleEncrypt.setSelected(false);
					translateVal = true;
				} else {
					toggleDecrypt.setSelected(false);
					translateVal = false;
				}
			}
		});
		
		/* Action Listener for the decrypt radio button */
		toggleDecrypt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (translateVal == false) {
					toggleEncrypt.setSelected(false);
					translateVal = true;
				} else {
					toggleDecrypt.setSelected(false);
					translateVal = false;
				}
			}
		});
		
		/* Set frame layout to GridLayout) */
		frame.setLayout(new GridLayout(11, 0));
		
		/* Add the all of the components to the JFrame */
		for (int i = 0; i < 26; i++) combo.addItem("" + i + "");
		frame.add(label1);
		frame.add(field1);
		frame.add(label2);
		frame.add(field2);
		frame.add(label3);
		frame.add(combo);
		frame.add(toggleEncrypt);
		frame.add(toggleDecrypt);
		frame.add(cipher);
		frame.add(copy);
		frame.add(close);

		/* Set the JFrame close, pack layout and visibility enabled options */
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.pack();
	    frame.setVisible(true);
	}
	
	/* Take string user input and offset/key. Make a wrapper for the key value if
	 * it falls off the end.
	 *  
	 * For each character in the string: 
	 * 		Check if it is a letter:
	 * 			if character is a letter: 
	 * 				if character is uppercase:
	 * 					add char to string after the wrapper algorithm
	 * 				if character is lowercase:
	 * 					add char to string after the wrapper algorithm
	 * 			if char is not a letter:
	 * 				add char to string anyway (white space or symbols)
	 * return resulting string
	 * 					 
	 * 				*/
	private String convert(String input, int keyVal) {
		String returnStr = "";
		keyVal = keyVal % 26 + 26;
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (Character.isLetter(c)) {
				if (Character.isUpperCase(c)) { 
					returnStr += (char) ('A' + (c - 'A' + keyVal) % 26);
				} else {
					returnStr += (char) ('a' + (c - 'a' + keyVal) % 26);
				}
			} else returnStr += c;
		}
		return returnStr;
	}
	
	/* Same concept, but this time, translating the encrypted message. Simply subtract
	 * the number of letters in the English alphabet by the original key value.*/
	private String translate(String input, int keyVal) {
		return convert(input, 26 - keyVal);
	}
		
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		CaesarCipher newCipher = new CaesarCipher();
	}
	
}
