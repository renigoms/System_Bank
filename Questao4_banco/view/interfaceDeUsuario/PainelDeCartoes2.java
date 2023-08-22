package view.interfaceDeUsuario;

import java.awt.CardLayout;
import java.text.ParseException;

import model.Cliente;
import view.PainelPadrao;

@SuppressWarnings("serial")
public class PainelDeCartoes2 extends PainelPadrao{
	private AcessarConta acessarConta;
	private InformacoesCliente painelDadosCliente;
	private CriarConta criarConta;
	private InformacoesConta inforConta;
	private DepositarView depositarView;
	private sacarView sacarView; 
	
	public PainelDeCartoes2(Cliente cliente) throws ParseException {
		setLayout(new CardLayout());
		painelDadosCliente = new InformacoesCliente(cliente);
		add(painelDadosCliente, "dadosCliente");
		
		acessarConta = new AcessarConta(cliente);
		add(acessarConta, "acessarConta");
		
		criarConta = new CriarConta(cliente);
		add(criarConta, "criarConta");
		
		
//		ADICIONANDO O PAINEL DE INFORMAÇÕES DA CONTA NO CARDLAYOUT
		inforConta = new InformacoesConta();
		add(inforConta, "inforConta");
		
		depositarView = new DepositarView();
		add(depositarView, "depositar");
		
		
		sacarView = new sacarView();
		add(sacarView, "sacar");
		
	}

	public AcessarConta getAcessarConta() {
		return acessarConta;
	}

	public InformacoesCliente getPainelDadosCliente() {
		return painelDadosCliente;
	}

	public CriarConta getCriarConta() {
		return criarConta;
	}

	public InformacoesConta getInforConta() {
		return inforConta;
	}

	public DepositarView getDepositarView() {
		return depositarView;
	}

	public sacarView getSacarView() {
		return sacarView;
	}
	
	
	
	
	
	
	
	
	
	
	

}
