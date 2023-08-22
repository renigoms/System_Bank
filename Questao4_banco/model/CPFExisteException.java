package model;

import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class CPFExisteException extends Exception {
	
	public CPFExisteException() {}
	
	public CPFExisteException(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Erro", JOptionPane.WARNING_MESSAGE);
	}

}
