package classes;

import java.util.ArrayList;

import excecoes.EmailInvalidoException;

public interface Interface {

	void cadastrarCliente(String [] dominios, int opcao);
	void cadastrarCarro();
	void listarDados(int opcao);
	void alterarDados(int opcao, String [] dominios) ;
	void deletarDados(int opcao);

}