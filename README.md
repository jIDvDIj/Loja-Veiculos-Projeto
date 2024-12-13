Projeto: Sistema de Gerenciamento de Loja de Carros

Descrição

Este é um projeto em Java desenvolvido para o gerenciamento de uma loja de carros. Ele inclui funcionalidades como cadastro de clientes, controle de vendas e emissão de recibos, entre outras. O código está estruturado em múltiplas classes que representam as entidades e funcionalidades principais do sistema.

Estrutura do Projeto

Classes Principais

Carro.java

Representa os dados de um carro, incluindo atributos como modelo, marca, preço, entre outros.

ClasseControle.java

Centraliza a lógica de negócio e gerencia as operações do sistema, como vendas e cadastro de carros.

Cliente.java

Representa os clientes regulares da loja, contendo informações como nome, CPF e histórico de compras.

ClienteEspecial.java

Uma extensão da classe Cliente, adicionando funcionalidades ou vantagens exclusivas para clientes especiais.

Conta.java

Gerencia as informações financeiras relacionadas à loja, como contas bancárias ou faturas.

Interface.java

Define os métodos necessários para interação com o usuário ou outras partes do sistema.

Main.java

O ponto de entrada do programa. Responsável por inicializar o sistema e gerenciar o fluxo principal da aplicação.

OtherMethods.java

Contém métodos auxiliares utilizados em diferentes partes do sistema, como validação de dados ou cálculos.

Pessoa.java

Representa informações gerais de uma pessoa, como nome e idade, servindo como classe base para Cliente e ClienteEspecial.

ReciboVenda.java

Gera recibos para as vendas realizadas, armazenando informações como detalhes do carro vendido, cliente e valor.

Funcionalidades

Cadastro e gerenciamento de carros no estoque.

Registro de clientes, incluindo clientes regulares e especiais.

Realização de vendas, com emissão de recibos detalhados.
