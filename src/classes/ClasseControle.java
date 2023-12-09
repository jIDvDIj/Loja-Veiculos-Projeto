package classes;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.text.DecimalFormat;

import excecoes.EmailInvalidoException;
import excecoes.NumeroInvalidoException;
import excecoes.StringNumericaException;
import excecoes.NumeroPortasInvalidoException;

public class ClasseControle implements Interface{
	
	private ArrayList <Pessoa> lista_clientes = new ArrayList<>();
	private ArrayList <Carro> lista_Carros = new ArrayList<>();
	private ArrayList <ReciboVenda> lista_recibo = new ArrayList<>();
	
	@Override
	public void cadastrarCliente(String[] dominios, int opcao) {
		Scanner sc = new Scanner(System.in);
		String nome = null, cpf = null, rua = null, bairro = null, email = null;
		int idade = 0, numero = 0; boolean result = false;
		OtherMethods om = new OtherMethods();
		
		ArrayList <ReciboVenda> lista_recibo = new ArrayList<>();
		ArrayList <String> historico_lista_carros = new ArrayList<>();
		Conta co = new Conta(lista_recibo, historico_lista_carros);
		
		try {
			System.out.println("Nome: "); nome = sc.nextLine();
			System.out.println("cpf: "); cpf = sc.nextLine();
			System.out.println("Idade: "); idade = sc.nextInt(); sc.nextLine();
			System.out.println("Rua: "); rua = sc.nextLine();
			System.out.println("Bairro: "); bairro = sc.nextLine();
			System.out.println("Numero: "); numero = sc.nextInt(); sc.nextLine();
			System.out.println("Email: "); email = sc.nextLine(); 
			
			result = om.verificarEmail(email, dominios);
			if (result == false) {
				throw new EmailInvalidoException("Email inválido");				
			}
			
			if (om.isNumeric(nome) || om.isNumeric(rua) || om.isNumeric(bairro)) {
				throw new StringNumericaException("String com valor numerico");
			}
		} catch (EmailInvalidoException ex) {
			System.out.println("Dominio do email invalido. Verifique letras maiusculas e minuscula");
			return;
		} catch (InputMismatchException ex) {
			System.out.println("Erro na entrada de dados");
			return;
		} catch (StringNumericaException ex) {
			System.out.println("Valores numericos equivocados");
			return;
		}
		
		if (opcao == 1) {
			Cliente cl = new Cliente(nome, cpf, idade, email, rua, bairro, numero, co);
			lista_clientes.add(cl);
		} else {
			ClienteEspecial cl = new ClienteEspecial(nome, cpf, idade, email, rua, bairro, numero, co, 10.0);
			lista_clientes.add(cl);
		}
		
		System.out.println("Cliente cadastrado com sucesso!");
	}
	
	
	@Override
	public void cadastrarCarro() {
		Scanner sc = new Scanner(System.in);
		String modelo = null, marca = null, cor = null; 
		int anoFabricacao = 0, numeroPortas = 0, quantidade = 0; double preco = 0;
        
		OtherMethods om = new OtherMethods();
		try{
			System.out.println("Modelo: "); modelo = sc.nextLine();
			System.out.println("Marca: "); marca = sc.nextLine();
			System.out.println("Cor: "); cor = sc.nextLine();
			System.out.println("Ano de fabricação: "); anoFabricacao = sc.nextInt();
			System.out.println("Numero de portas: "); numeroPortas = sc.nextInt();
			if (numeroPortas != 2 && numeroPortas != 3 && numeroPortas != 4) {
		        throw new NumeroPortasInvalidoException("Número de portas inválido. Deve ser 2, 3 ou 4.");
		    }
			System.out.println("Quantidade: "); quantidade = sc.nextInt();
			System.out.println("Preço: "); preco = sc.nextDouble();
			if (om.isNumeric(modelo) || om.isNumeric(marca) || om.isNumeric(cor)) {
				throw new StringNumericaException("String com valor numerico");
			}
			
		} catch (InputMismatchException ex) {
			System.out.println("Entrada de dados errada, por favor coloque um dado válido");
			return;
		} catch (StringNumericaException ex) {
			System.out.println("Valor que deveria ser em texto contendo valores numericos");
			return;
		} catch (NumeroPortasInvalidoException ex) {
			System.out.println(ex.getMessage());
			return;
		}
		
		Carro ca = new Carro(modelo, marca, anoFabricacao, cor, preco, numeroPortas, quantidade);
		lista_Carros.add(ca);
		
		System.out.println("Carro cadastrado com sucesso!");
		
	}
	
	@Override
	public void listarDados(int opcao) {
		DecimalFormat decimalFormat = new DecimalFormat("###,###,##0.00");
		int c = 1; String tipo = "";
		switch(opcao) {
		case 4:
			System.out.println("------Lista de lista_clientes------");
			for (Pessoa p: lista_clientes) {
				if (p instanceof ClienteEspecial) {
					tipo = "Especial";
				} else {
					tipo = "Comum";
				}
				System.out.println("--------Cliente "+c+"--------");
				System.out.println("Nome: " + p.getNome());
				System.out.println("CPF: " + p.getCpf());
				System.out.println("Idade: " + p.getIdade());
				System.out.println("Email: " + p.getEmail());
				System.out.println("Tipo: " + tipo);
				System.out.println("----------------------");
				c++;
			}
			
			if (c == 1) {
				System.out.println("Nenhum Cliente cadastrado\n-----------------------------");
			}
			
			break;
		case 5:
			System.out.println("------Lista de lista_carros------");
			for (Carro f: lista_Carros) {
				System.out.println("--------Carro " +c+ "---------");
				System.out.println("Modelo: " + f.getModelo());
				System.out.println("Marca: " + f.getMarca());
				System.out.println("Ano de Fabricação: " + f.getAnoFabricacao());
				System.out.println("Cor: " + f.getCor());
				System.out.println("Número de Portas: " + f.getNumeroPortas());
				System.out.println("Preço: " + decimalFormat.format(f.getPreco()));
				System.out.println("Quantidade: " + f.getQuantidade());
				System.out.println("----------------------");
				c++;
			}
			
			if (c == 1) {
				System.out.println("Nenhum Carro cadastrado\n----------------------------");
			}
			
			break;
		case 6:
			System.out.println("------lista_carros Vendidos------");
			for (ReciboVenda r: lista_recibo) {
				if (r.getVendido() == true) {
					System.out.println("----------------------");
					for (int i = 0; i<r.getCarros_vendidos().size(); i++) {
						System.out.println(r.getCarros_vendidos().get(i));					
					}
					System.out.println("Vendido para " + r.getCliente().getNome());
					System.out.println("----------------------");
					c++;
				}
			}
			
			if (c == 1) {
				System.out.println("Nenhum Carro vendido\n----------------------------");
			}
			
			break;
		case 7:
			System.out.println("---------Recibos de Venda----------");
			for (ReciboVenda r: lista_recibo) {
				System.out.println("----------------------");
				for (int i = 0; i<r.getCarros_vendidos().size(); i++) {
					System.out.println(r.toString());					
				}
				c++;
			}
		
			if (c == 1) {
				System.out.println("Nenhum carro vendido\n----------------------------");
			}
			break;
		}
		
	}
		
	@Override
	public void alterarDados(int opcao, String[] dominios) {
		Scanner sc = new Scanner(System.in);
		int c = 1, resposta = 0, dado = 0; Double verificador = null; String novo_email = null;
		OtherMethods om = new OtherMethods();
		
		switch(opcao) {
		case 9:
			if (lista_clientes.size() == 0) {
				System.out.println("Não existem lista_clientes cadastrados");
				return;
			}
			
			System.out.println("Qual o Cliente?");
			for (Pessoa p : lista_clientes) {
				System.out.println(c + " -> " + p.getNome());
				c++;
			}
			resposta = sc.nextInt(); sc.nextLine();
			try {
	            if (resposta < 0 || resposta > lista_clientes.size()) {
	                throw new NumeroInvalidoException("Numero fora do range");
	            }
	        } catch (NumeroInvalidoException ex) {
	            System.out.println("Numero fora do alcance");
	            return;
	        } catch (InputMismatchException ex) {
	            System.out.println("Tipo incorreto, digite um valor inteiro");
	            return;
	        }
			
			Pessoa cliente_escolhido = lista_clientes.get(resposta-1);
			System.out.println("O que deseja alterar?\n"
					+ "1 -> Nome\n"
					+ "2 -> CPF\n"
					+ "3 -> Idade\n"
					+ "4 -> Rua\n"
					+ "5 -> Bairro\n"
					+ "6 -> Número\n"
					+ "7 -> Email");
			
			try {
				resposta = sc.nextInt(); sc.nextLine();
				if (resposta < 1 || resposta > 7) {
					throw new NumeroInvalidoException("Numero fora do range");
				}
			} catch (NumeroInvalidoException ex) {
				System.out.println("Informe um numero que esteja dentro do menu");
				return;
			}
				
			
			System.out.println("Informe o novo dado: "); 
			try {
				if (resposta == 1) {
					cliente_escolhido.setNome(sc.nextLine());
				} else if (resposta == 2) {
					cliente_escolhido.setCpf(sc.nextLine());
				} else if (resposta == 3) {
					cliente_escolhido.setIdade(sc.nextInt());
				} else if (resposta == 4) {
					cliente_escolhido.setRua(sc.nextLine());
				} else if (resposta == 5) {
					cliente_escolhido.setBairro(sc.nextLine());
				} else if (resposta == 6){
					cliente_escolhido.setNumero(sc.nextInt());
				} else {
					novo_email = sc.nextLine();
					if (OtherMethods.verificarEmail(novo_email, dominios) == false) {
						throw new EmailInvalidoException("Email com dominio incorreto");
					}
					
					cliente_escolhido.setEmail(novo_email);
				}
				
			} catch (InputMismatchException ex) {
				System.out.println("Tipo incorreto");
				return;
			} catch (EmailInvalidoException ex) {
				System.out.println("Dominio invalido");
				return;
			}
			System.out.println("Dado alterado com sucesso!");
			break;
				
		case 10: 
			if (lista_Carros.size() == 0) {
				System.out.println("Não existem lista_Carros cadastrados");
				return;
			}
			
			System.out.println("Qual o Carro?");
			for (Carro f : lista_Carros) {
				System.out.println(c + " -> " + f.getModelo());
				c++;
			}
			
			try {
	            resposta = sc.nextInt();
	            if (resposta < 0 || resposta > lista_Carros.size()) {
	                throw new NumeroInvalidoException("Numero fora do range");
	            }
	        } catch (NumeroInvalidoException ex) {
	            System.out.println("Numero fora do alcance");
	            return;
	        } catch (InputMismatchException ex) {
	            System.out.println("Tipo incorreto, digite um valor inteiro");
	            return;
	        }
			
			Carro carro_escolhido = lista_Carros.get(resposta-1);
				
			System.out.println("O que deseja alterar?\n"
					+ "1 -> Modelo\n"
					+ "2 -> Marca\n"
					+ "3 -> Cor\n"
					+ "4 -> Ano de Fabricação\n"
					+ "5 -> Número de portas\n"
					+ "6 -> Quantidade\n"
					+ "7 -> Preço\n");
			
			try {
				resposta = sc.nextInt(); sc.nextLine();
				if (resposta < 1 || resposta > 6) {
					throw new NumeroInvalidoException("Numero fora do alcance");
				}
			} catch (NumeroInvalidoException ex) {
				System.out.println("Informe um numero que esteja dentro do menu");
				return;
			}
			if (resposta == 5) {
			    while (true) {
			        System.out.println("Informe o novo dado (número de portas): ");
			        try {
			            dado = sc.nextInt();
			            if (dado != 2 && dado != 3 && dado != 4) {
			                System.out.println("|| O número de portas deve ser igual a 2, 3 ou 4! ||\n");
			            } else {
			                break;
			            }
			        } catch (InputMismatchException ex) {
			            System.out.println("Entrada inválida. Por favor, insira um valor inteiro.");
			            sc.nextLine();
			        }
			    }
			    
			} else if (resposta == 6) {
			    while (true) {
			        System.out.println("Informe o novo dado (número de portas): ");
			        try {
			            dado = sc.nextInt();
			            if (dado < 0) {
			                System.out.println("|| A quantidade não pode se inferior a 0! ||\n");
			            } else {
			                break;
			            }
			        } catch (InputMismatchException ex) {
			            System.out.println("Entrada inválida. Por favor, insira um valor inteiro.");
			            sc.nextLine();
			        }
			    }
			    
			} else {
			    System.out.println("Informe o novo dado: ");
			}
			
			try {
				if (resposta == 1) {
					carro_escolhido.setModelo(sc.nextLine());
				} else if (resposta == 2) {
					carro_escolhido.setMarca(sc.nextLine());
				} else if (resposta == 3) {
					carro_escolhido.setCor(sc.nextLine());
				} else if (resposta == 4) {
					carro_escolhido.setAnoFabricacao(sc.nextInt());
				} else if (resposta == 5) {
					carro_escolhido.setNumeroPortas(dado);
				} else if (resposta == 6) {
					carro_escolhido.setQuantidade(dado);
				} else {
					carro_escolhido.setPreco(sc.nextDouble());
				} 
			} catch (InputMismatchException ex) {
				System.out.println("Tipo incorreto");
				return;
			}
			System.out.println("Dado alterado com sucesso!");
			break;
			}
	}
	@Override
	public void deletarDados(int opcao) {
		Scanner sc = new Scanner(System.in);
		int c = 1, resposta;
		
		switch (opcao) {
		/*excluir cliente*/
		case 11:
			if (lista_clientes.size() == 0) {
				System.out.println("Não existem lista_clientes cadastrados");
				return;
			}
			System.out.println("Qual cliente deseja deletar?");
			for (Pessoa p : lista_clientes) {
				System.out.println(c + " -> " + p.getNome());
				c++;
			}
			System.out.println("0 -> Sair");
			
			try {
	            resposta = sc.nextInt();
	            if (resposta < 0 || resposta > lista_clientes.size()) {
	                throw new NumeroInvalidoException("Numero fora do range");
	            }
	        } catch (NumeroInvalidoException ex) {
	            System.out.println("Numero fora do alcance");
	            return;
	        } catch (InputMismatchException ex) {
	            System.out.println("Tipo incorreto, digite um valor inteiro");
	            return;
	        }
			if (resposta == 0) {
				return;
			}
			
			lista_clientes.remove((resposta-1));
			System.out.println("Cliente removido com sucesso");
			break;
		
		/* excluindo carro */
		case 12:
			if (lista_Carros.size() == 0) {
				System.out.println("Não existem lista_Carros cadastrados");
				return;
			}
			System.out.println("Qual carro deseja deletar?");
			for (Carro f : lista_Carros) {
				System.out.println(c + " -> " + f.getModelo());
				c++;
			}
			System.out.println("0 -> Sair");
			
			try {
	            resposta = sc.nextInt();
	            if (resposta < 0 || resposta > lista_Carros.size()) {
	                throw new NumeroInvalidoException("Numero fora do range");
	            }
	        } catch (NumeroInvalidoException ex) {
	            System.out.println("Numero fora do alcance");
	            return;
	        } catch (InputMismatchException ex) {
	            System.out.println("Tipo incorreto, digite um valor inteiro");
	            return;
	        }
			
			if (resposta == 0) {
				return;
			}
			
			lista_Carros.remove((resposta-1));
			System.out.println("Carro removido com sucesso");
			break;
		}
	}

	public void venderCarro() throws NumeroInvalidoException{
		/*Vender Carro*/
		Scanner sc = new Scanner(System.in);
        ArrayList<String> carrosVendidos = new ArrayList<>();
        ArrayList<Integer> estoqueZerado = new ArrayList<>();
        Carro carroEscolhido = null;
        Pessoa clienteEscolhido;
        String data;
        int resposta, cont = 1;
        double precoTotal = 0;
        boolean condicao = true;
        OtherMethods om = new OtherMethods();
        ReciboVenda recibo;
        
        if (lista_clientes.size() == 0) {
			System.out.println("Não existem lista_clientes cadastrados, cadastre um cliente para começar a venda.");
			return;
		}
        System.out.println("Escolha um cliente digitando o número correspondente:");
        for (Pessoa p : lista_clientes) {
            System.out.println(cont + " -> " + p.getNome());
            cont++;
        }

        try {
            resposta = sc.nextInt();
            cont = 1;
            if (resposta <= 0 || resposta > lista_clientes.size()) {
                throw new NumeroInvalidoException("Número fora do range");
            }
        } catch (NumeroInvalidoException ex) {
            System.out.println("Número fora do alcance");
            return;
        } catch (InputMismatchException ex) {
            System.out.println("Tipo incorreto, digite um valor inteiro");
            return;
        }

        clienteEscolhido = lista_clientes.get(resposta - 1);

        try {
            if (condicao) {
                    if (lista_Carros.size() > 0) {
                    	System.out.println("Selecione um Carro");
                        for (Carro carro : lista_Carros) {
                            if (carro.getQuantidade() > 0) {
                                System.out.println(cont + " -> " + carro.getModelo());
                            } else {
                            	System.out.println(cont + " -> " + carro.getModelo() + "(ESTOQUE ZERADO!)");
                            	estoqueZerado.add(cont);
                    			continue;
                            }
                            cont++;
                        }
                        resposta = sc.nextInt();
                        try {
                            if (resposta <= 0 || resposta > lista_Carros.size()) {
                                throw new NumeroInvalidoException("Número fora do range");
                            }
                        } catch (NumeroInvalidoException ex) {
                            System.out.println("Número fora do alcance");
                            return;
                        } catch (InputMismatchException ex) {
                            System.out.println("Tipo incorreto, digite um valor inteiro");
                            return;
                        }
                        if (estoqueZerado.contains(resposta)) {
                    		System.out.println("Estoque deste carro está zerado!");
                    		condicao = false;
                        }
                    } else {
                        condicao = false;
                    }
                    carroEscolhido = lista_Carros.get(resposta - 1);
                    carrosVendidos.add(carroEscolhido.getModelo());
                    precoTotal += carroEscolhido.getPreco();

                    int quantidade = carroEscolhido.getQuantidade();
                    carroEscolhido.setQuantidade(quantidade - 1);
                    
                }

                Calendar cal = Calendar.getInstance();
                int dia = cal.get(Calendar.DAY_OF_MONTH);
                int mes = cal.get(Calendar.MONTH) + 1;
                int ano = cal.get(Calendar.YEAR);
                data = String.valueOf(dia) + "/" + String.valueOf(mes) + "/" + String.valueOf(ano);
                
                if (clienteEscolhido instanceof ClienteEspecial) {
                    precoTotal = precoTotal * (((ClienteEspecial)clienteEscolhido).getDesconto() / 100);
                }

                if (condicao) {
                    System.out.println("A venda será parcelada?\n"
                            + "1 -> Sim\n"
                            + "2 -> Não");
                    resposta = sc.nextInt();
                    if (resposta == 1) {
                    	System.out.println("Informe o número de parcelas: ");
                        int numParcelas = sc.nextInt();
                        double taxaJuros = 3.0 / 100;
                        precoTotal = precoTotal * Math.pow(1 + taxaJuros, numParcelas);
                        recibo = new ReciboVenda(clienteEscolhido, carroEscolhido ,carrosVendidos, data, precoTotal, true, numParcelas,true);

                    } else {
                        recibo = new ReciboVenda(clienteEscolhido,carroEscolhido,carrosVendidos, data, precoTotal, false, 0,true);
                    }

                    lista_recibo.add(recibo);

                    if (clienteEscolhido instanceof Cliente) {
                    	((Cliente) clienteEscolhido).getConta_cliente().getHistorico().addAll(carrosVendidos);
                        ((Cliente) clienteEscolhido).getConta_cliente().getRecibo_venda().add(recibo);
                    }
                    if (clienteEscolhido instanceof ClienteEspecial) {
                    	((ClienteEspecial) clienteEscolhido).getConta_cliente().getHistorico().addAll(carrosVendidos);
                        ((ClienteEspecial) clienteEscolhido).getConta_cliente().getRecibo_venda().add(recibo);
                    }

                    System.out.println("-----------RECIBO DE VENDA-------------");
                    System.out.println(recibo.toString());
                    System.out.println("--------------------------------------");
                } else {
                    System.out.println("Nenhum carro vendido");
                }
            } catch (IndexOutOfBoundsException e) {
            	System.out.println("Nenhum Carro Cadastrado. Realize o cadastro e continue!");
        }
    }
}