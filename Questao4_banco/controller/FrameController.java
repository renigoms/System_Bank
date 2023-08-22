package controller;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import model.BaseDeDados;
import model.CPFExisteException;
import model.Cliente;
import view.FrameDePaineis;
import view.PainelDeCadastro;
import view.PainelDeLogin;
import view.PainelMenuView;
import view.interfaceDeUsuario.FrameDePaineisPosLogin;

public class FrameController implements ActionListener{
	@SuppressWarnings("unused")
	private FrameDePaineis frameDePaineis;
	private PainelMenuView menuView;
	private PainelDeLogin loginView; 
	private PainelDeCadastro cadastrarView;

	/**
	 * @param frameDePaineis
	 */
	public FrameController(FrameDePaineis frameDePaineis) {
		super();
		this.frameDePaineis = frameDePaineis;
		this.cadastrarView = frameDePaineis.getPainelDeCartoes().getCadastrarView();
		this.loginView = frameDePaineis.getPainelDeCartoes().getLoginView();
		this.menuView = frameDePaineis.getPainelDeCartoes().getMenuView();
		control();
	}
	
	private void control() {
		menuView.getEntrarButton().addActionListener(this);
		menuView.getCadastrarButton().addActionListener(this);
		loginView.getLoginButton().addActionListener(this);
		loginView.getVoltarButton().addActionListener(this);
		cadastrarView.getVoltarButton().addActionListener(this);
		cadastrarView.getAddButton().addActionListener(this);
	}
	
	private CardLayout getCardLayout() {
		return (CardLayout) frameDePaineis.getPainelDeCartoes().getLayout();
	}
	
	private void voltarMenu() {
		getCardLayout().show(frameDePaineis.getPainelDeCartoes(), "menu");
	}
	
	private boolean isCadasCampoVazio() {
		if(cadastrarView.getNomeField().getText().isEmpty() ||
				cadastrarView.getEmailField().getText().isEmpty()||
				cadastrarView.getFoneField().getText().equalsIgnoreCase("(  )       -    ")||
				cadastrarView.getCpfField().getText().equalsIgnoreCase("   .   .   -  "))
			return true;
		return false;
	}
	
	private void limparCamposCadas() {
		cadastrarView.getNomeField().setText("");
		cadastrarView.getCpfField().setText("");
		cadastrarView.getEmailField().setText("");
		cadastrarView.getFoneField().setText("");
	}
	
	private void limparCampoLogin() {
		loginView.getCpfField().setText("");
	}
	
	

	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton entrar = menuView.getEntrarButton();
		if(e.getSource() == entrar) {
			getCardLayout().show(frameDePaineis.getPainelDeCartoes(), "login");
		}
		
		JButton cadastrar = menuView.getCadastrarButton();
		if(e.getSource() == cadastrar) {
			getCardLayout().show(frameDePaineis.getPainelDeCartoes(), "cadastro");
		}
		
		JButton voltarLogin = loginView.getVoltarButton(); 
		if(e.getSource() == voltarLogin) {
			limparCampoLogin();
			voltarMenu();
		}
		
		JButton cadasVoltar = cadastrarView.getVoltarButton();
		if (e.getSource() == cadasVoltar) {
			limparCamposCadas();
			voltarMenu();
		}
		
		JButton loginButton = loginView.getLoginButton();
		if(e.getSource() == loginButton) {
			if(loginView.getCpfField().getText().equalsIgnoreCase("   .   .   -  ")) {
				JOptionPane.showMessageDialog(null, 
						"Digite um cpf válido!","CAMPO NÃO PREENCHIDO", 
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			
			String cpf = loginView.getCpfField().getText();
			
			if(BaseDeDados.buscarCliente(cpf)!= null) {
				Cliente cliente = BaseDeDados.buscarCliente(cpf);
				
				JOptionPane.showMessageDialog(null, "Cliente confirmado com sucesso");
				limparCampoLogin();
				try {
					FrameDePaineisPosLogin posLogin = new FrameDePaineisPosLogin(cliente, frameDePaineis);
					FrameDePaineisPosLoginController controller = new FrameDePaineisPosLoginController(posLogin);
					frameDePaineis.setVisible(false);
					return;
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			JOptionPane.showMessageDialog(null, "Cliente não encontrado ou cpf inválido", 
					"Erro", JOptionPane.WARNING_MESSAGE);
			limparCampoLogin();
		}
		
		JButton salvarCadas = cadastrarView.getAddButton();
		if(e.getSource() == salvarCadas) {
			try {
				if(isCadasCampoVazio()) {
					JOptionPane.showMessageDialog(null, "Alguns campos não foram preenchidos");
					return;
				}
				String cpf = cadastrarView.getCpfField().getText(),
						nome = cadastrarView.getNomeField().getText(),
						email = cadastrarView.getEmailField().getText(),
						fone = cadastrarView.getFoneField().getText();
						
				
				if(BaseDeDados.buscarCliente(cpf)!= null) {
					throw new CPFExisteException("CPF já cadastrado!");
				}
				
				Cliente newCliente = new Cliente(cpf, nome, fone,email);
				
				if(BaseDeDados.adicionarCliente(newCliente)) {
					JOptionPane.showMessageDialog(null, "Cadastro Efetuado");
					limparCamposCadas();
					voltarMenu();
					return;
				}
				throw new CPFExisteException("Erro ao efetuar o cadastro!");
				
			} catch (CPFExisteException e2) {
				limparCamposCadas();
			}
			
		}
		
	}
	
	
}
