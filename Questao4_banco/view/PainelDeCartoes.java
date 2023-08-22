package view;

import java.awt.CardLayout;
import java.text.ParseException;

@SuppressWarnings("serial")
public class PainelDeCartoes extends PainelPadrao{
	
	private PainelMenuView menuView;
	private PainelDeLogin loginView; 
	private PainelDeCadastro cadastrarView;
	
	public PainelDeCartoes() throws ParseException {
		setLayout(new CardLayout());
		menuView = new PainelMenuView();
		add(menuView, "menu");
		loginView = new PainelDeLogin();
		add(loginView, "login");
		cadastrarView = new PainelDeCadastro();
		add(cadastrarView, "cadastro");
		
	}

	public PainelMenuView getMenuView() {
		return menuView;
	}

	public PainelDeLogin getLoginView() {
		return loginView;
	}

	public PainelDeCadastro getCadastrarView() {
		return cadastrarView;
	}
	
	

	

	
	
	

}
