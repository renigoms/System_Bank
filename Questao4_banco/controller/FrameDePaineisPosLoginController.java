package controller;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import model.Banco;
import model.Conta;
import view.interfaceDeUsuario.AcessarConta;
import view.interfaceDeUsuario.CriarConta;
import view.interfaceDeUsuario.DepositarView;
import view.interfaceDeUsuario.FrameDePaineisPosLogin;
import view.interfaceDeUsuario.InformacoesCliente;
import view.interfaceDeUsuario.InformacoesConta;
import view.interfaceDeUsuario.sacarView;

public class FrameDePaineisPosLoginController implements ActionListener{
	
	private WindowHandler windowHandler;
	
	private FrameDePaineisPosLogin posLogin;
	
	private InformacoesCliente dadosCliente;
	private AcessarConta acessarConta;
	private CriarConta criarConta;
	private InformacoesConta dadosConta;
	private sacarView sacarView;
	private DepositarView depositarView;
	
	
	
	
	
	/**
	 * @param posLogin
	 */
	public FrameDePaineisPosLoginController(FrameDePaineisPosLogin posLogin){
		super();
		this.posLogin = posLogin;
		windowHandler = new WindowHandler();
		dadosCliente = posLogin.getPanelCardContanier().
				getPainelDadosCliente();
		acessarConta = posLogin.getPanelCardContanier().
				getAcessarConta();
		
		criarConta = posLogin.getPanelCardContanier().getCriarConta();
		
		dadosConta = posLogin.getPanelCardContanier().getInforConta();
		
		sacarView = posLogin.getPanelCardContanier().getSacarView();
		
		depositarView = posLogin.getPanelCardContanier().getDepositarView();
		
		control();
		
	}
	
	private void control() {
		posLogin.addWindowListener(windowHandler);
//		voltarButton se comporta como acessar conta
		dadosCliente.getVoltarButton().addActionListener(this);
		dadosCliente.getAddButton().addActionListener(this);
		acessarConta.getVoltarButton().addActionListener(this);
		acessarConta.getLoginButton().addActionListener(this);
		criarConta.getAddButton().addActionListener(this);
		criarConta.getVoltarButton().addActionListener(this);
		dadosConta.getVoltarButton().addActionListener(this);
		dadosConta.getAddButton().addActionListener(this);
		dadosConta.getDepositarButton().addActionListener(this);
		this.sacarView.getVoltarButton().addActionListener(this);
		this.depositarView.getVoltarButton().addActionListener(this);
		sacarView.getLoginButton().addActionListener(this);
		depositarView.getLoginButton().addActionListener(this);
		
		
	}

	private class WindowHandler extends WindowAdapter{

		@Override
		public void windowClosing(WindowEvent e) {
			posLogin.getFrameMenu().setVisible(true);
		}
		
	}

	private CardLayout getCardLayout() {
		return (CardLayout) posLogin.getPanelCardContanier().getLayout();
	}
	
	private void limparCriarConta() {
		criarConta.getNomeField().setText("");
		criarConta.getSenhaField().setText("");
		criarConta.getSalarioField().setText("");
		criarConta.getEmailField().setText("");
		criarConta.getConfirSenhField().setText("");
	
	}
	private void limparAcessarConta() {
		acessarConta.getNumField().setText("");
		acessarConta.getAgenField().setText("");
		acessarConta.getSenhaField().setText("");
	}
	
	private boolean isCampoVazioCriarConta() {
		if(criarConta.getNomeField().getText().isEmpty()||
			criarConta.getEmailField().getText().isEmpty()||
			criarConta.getSalarioField().getText().isEmpty()||
			criarConta.getSenhaField().getText().isEmpty()||
			criarConta.getConfirSenhField().getText().isEmpty())
			return true;
		return false;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton criarConta = dadosCliente.getAddButton();
		if(e.getSource() == criarConta)
			getCardLayout().show(posLogin.getPanelCardContanier(), "criarConta");
		
		JButton acessarConta = posLogin.getPanelCardContanier().
				getPainelDadosCliente().getVoltarButton();
		if (e.getSource() == acessarConta)
			getCardLayout().show(posLogin.getPanelCardContanier(), "acessarConta");
		
		JButton voltarAcessarConta = this.acessarConta.getVoltarButton();
		if(e.getSource() == voltarAcessarConta)
			getCardLayout().show(posLogin.getPanelCardContanier(), "dadosCliente");
		
		JButton acessarButton = this.acessarConta.getLoginButton();
		if(e.getSource() == acessarButton) {
			if(new String(this.acessarConta.getSenhaField().getPassword()).isEmpty() ||
					this.acessarConta.getAgenField().getText().isEmpty()||
					this.acessarConta.getNumField().getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Alguns campos estão vazios");
				return;
			}
			
			try {
				String senha = new String(this.acessarConta.getSenhaField().getPassword());
				int agencia = Integer.parseInt(this.acessarConta.getAgenField().getText()),
						numero = Integer.parseInt(this.acessarConta.getNumField().getText());
				
				
				Conta busConta = this.acessarConta.getCliente().buscarConta(agencia, numero, senha);
				if(busConta != null) {
//					ESSA PARTE SERÁ ALTERADA DEPOIS
					JOptionPane.showMessageDialog(null, "Conta encontrada!");
					limparAcessarConta();

//					TROCANDO PAINEL
					posLogin.getPanelCardContanier().getInforConta().setConta(busConta);
					getCardLayout().show(posLogin.getPanelCardContanier(), "inforConta");
					return;
				}
			} catch (NumberFormatException e2) {
				JOptionPane.showMessageDialog(null, "Agência e número só aceitam valores numericos!");
				
			}
			
			JOptionPane.showMessageDialog(null, "Esse cliente não tem essa conta");
			limparAcessarConta();
		}
		
		JButton voltarCriarConta = this.criarConta.getVoltarButton();
		if(e.getSource() == voltarCriarConta) {
			getCardLayout().show(posLogin.getPanelCardContanier(), "dadosCliente");
			limparCriarConta();
		}
		JButton salvarDadosConta = this.criarConta.getAddButton();
		if(e.getSource() == salvarDadosConta) {
			if(isCampoVazioCriarConta()) {
				JOptionPane.showMessageDialog(null,"Alguns Campos estão vazios");
				return;
			}
			
			if(!(this.criarConta.getSenhaField().getText().
					equals(this.criarConta.getConfirSenhField().getText()))) {
				JOptionPane.showMessageDialog(null, "A senha está diferente da "
						+ "confirmação de senha!");
				return;
			}
			int agencia = 0, numero = 0;
			double salario = 0.0;
			
			try {
				 agencia = Integer.parseInt(this.criarConta.getNomeField().getText());
				 numero = Integer.parseInt(this.criarConta.getEmailField().getText());
				 salario = Double.valueOf(this.criarConta.getSalarioField().getText());
			} catch (NumberFormatException e2) {
				e2.printStackTrace();
				JOptionPane.showMessageDialog(null, "Agência,número e salário só aceitam valores numericos!");
				return;
			}
			
			String senha = this.criarConta.getSenhaField().getText();
			
			new Conta(agencia, numero, salario, 
					senha, this.criarConta.getCliente());
			
			if(this.criarConta.getCliente().buscarConta(agencia, numero, senha)!=null) {
				JOptionPane.showMessageDialog(null, "Conta criada com sucesso");
				limparCriarConta();
				return;
			}
			JOptionPane.showMessageDialog(null, "Erro ao salvar a conta!", 
					"Aviso", JOptionPane.WARNING_MESSAGE);
			limparCriarConta();
		}
		
		JButton voltarInforConta = dadosConta.getVoltarButton();
		if(e.getSource() == voltarInforConta) 
			getCardLayout().show(posLogin.getPanelCardContanier(), "acessarConta");
		
		
		JButton depositarButton = dadosConta.getDepositarButton();
		if(e.getSource() == depositarButton) {
//			ADICIONANDO O PAINEL AO CARDLAYOUT
			Conta conta = posLogin.getPanelCardContanier().getInforConta().getConta();
			//				ABRINDO PAINEL DEPOSITAR
			posLogin.getPanelCardContanier().getDepositarView().setConta(conta);
			getCardLayout().show(posLogin.getPanelCardContanier(), "depositar");
		}
		
		JButton sacarButton = dadosConta.getAddButton();
		if(e.getSource() == sacarButton) {
			Conta conta = posLogin.getPanelCardContanier().getInforConta().getConta();
			posLogin.getPanelCardContanier().getSacarView().setConta(conta);
			getCardLayout().show(posLogin.getPanelCardContanier(), "sacar");
		}
		
		JButton voltarSacar = this.sacarView.getVoltarButton();
		if(e.getSource() == voltarSacar)
			getCardLayout().show(posLogin.getPanelCardContanier(), "inforConta");
			
		JButton voltarDepositar = this.depositarView.getVoltarButton();
		if(e.getSource() == voltarDepositar)
			getCardLayout().show(posLogin.getPanelCardContanier(), "inforConta");
		
		JButton realizarSaque = sacarView.getLoginButton();
		if(e.getSource() == realizarSaque) {
			if(sacarView.getValorField().getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Coloque um valor para saque");
				return;
			}
			try {
				Double valor = Double.valueOf(sacarView.getValorField().getText());
				if(Banco.sacar(valor, dadosConta.getConta())) {
					JOptionPane.showMessageDialog(null, "Saque realizado!");
					sacarView.getValorField().setText("");
					return;
				}
				JOptionPane.showMessageDialog(null, "Erro de saque!");
				sacarView.getValorField().setText("");
				
				
				
			} catch (NumberFormatException e2) {
				JOptionPane.showMessageDialog(null, "Apenas valores númericos");
				return;
			}
			
		}
		JButton realizarDeposito = depositarView.getLoginButton();
		if(e.getSource() == realizarDeposito) {
			if(depositarView.getValorField().getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Coloque um valor para saque");
				return;
			}
			try {
				Double valor = Double.valueOf(depositarView.getValorField().getText());
				if(Banco.depositar(valor, dadosConta.getConta())) {
					JOptionPane.showMessageDialog(null, "Deposito realizado!");
					depositarView.getValorField().setText("");
					return;
				}
				JOptionPane.showMessageDialog(null, "Erro de deposito!");
				depositarView.getValorField().setText("");
			} catch (NumberFormatException e2) {
				JOptionPane.showMessageDialog(null, "Apenas valores númericos");
				return;
			}
		}
			
		
		
	}
	
}
