package view.interfaceDeUsuario;

import java.text.ParseException;

import model.Cliente;
import view.FrameDePaineis;

@SuppressWarnings("serial")
public class FrameDePaineisPosLogin extends FrameDePaineis{
	private PainelDeCartoes2 panelCardContanier;
	private FrameDePaineis frameMenu;
	
	/**
	 * @param frameMenu
	 * @throws ParseException
	 */
	@SuppressWarnings("unused")
	public FrameDePaineisPosLogin(Cliente cliente, FrameDePaineis frameMenu) throws ParseException {
		super();
		this.frameMenu = frameMenu;
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		remove(getPainelDeCartoes());
		panelCardContanier = new PainelDeCartoes2(cliente);
		add(panelCardContanier);
	}

	public FrameDePaineisPosLogin(Cliente cliente) throws ParseException {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		remove(getPainelDeCartoes());
		panelCardContanier = new PainelDeCartoes2(cliente);
		add(panelCardContanier);
		
	}

	public FrameDePaineis getFrameMenu() {
		return frameMenu;
	}

	public PainelDeCartoes2 getPanelCardContanier() {
		return panelCardContanier;
	}
	
	
	
	

}
