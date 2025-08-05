# 🚗 Projeto Garage77 - Sistema de Gestão de Estacionamento

Este é o projeto final da disciplina de **Linguagem de Programação II** com acesso a banco de dados, desenvolvido em Java utilizando **Swing** (interface gráfica) e conexão com banco **Firebird**.

O sistema simula a gestão de um estacionamento para a empresa fictícia **Garage77**, com funcionalidades de cadastro, pesquisa e controle de locações de veículos.

---

## 🛠️ Tecnologias Utilizadas

- Java (JDK 8+)
- Java Swing (GUI)
- JDBC (Driver Jaybird para Firebird)
- Banco de Dados Firebird
- IDE: NetBeans

---

## 📁 Estrutura do Projeto

Garage77-Full/
│
├── src/                            # Código-fonte do projeto
│   ├── conexao/                    # Classe de conexão com o banco de dados Firebird
│   │   └── ConexaoBD.java
│   │
│   ├── dao/                        # Data Access Object (consultas e transações com o banco)
│   │   ├── ClienteDAO.java
│   │   ├── VeiculoDAO.java
│   │   ├── VagaDAO.java
│   │   └── LocacaoDAO.java
│   │
│   ├── model/                      # Classes de modelo (entidades)
│   │   ├── Cliente.java
│   │   ├── Veiculo.java
│   │   ├── Vaga.java
│   │   └── Locacao.java
│   │
│   ├── view/                       # Telas do sistema (interface Swing)
│   │   ├── TelaPrincipal.java
│   │   ├── TelaCadastroCliente.java
│   │   ├── TelaCadastroVeiculo.java
│   │   ├── TelaCadastroVaga.java
│   │   ├── TelaCadastroLocacao.java
│   │   ├── TelaPesquisaClientes.java
│   │   ├── TelaPesquisaVeiculos.java
│   │   └── TelaFinalizarLocacao.java
│   │
│   └── util/                       # Utilitários e helpers (se houver)
│       └── ValidadorPlaca.java     # Exemplo de validação de placas duplicadas
│
├── .gitignore                      # Arquivos e pastas ignoradas pelo Git
├── README.md                       # Descrição e instruções do projeto
└── database/                       # Pasta sugerida para backup do banco Firebird
    └── garage77.fdb                # Arquivo do banco de dados (não incluído no GitHub)


yaml
Copiar
Editar

---

## 📋 Funcionalidades Implementadas

- [x] Cadastro de Clientes
- [x] Cadastro de Veículos vinculados a clientes
- [x] Cadastro de Vagas
- [x] Registro de Locações (entrada de veículos)
- [x] Finalização de Locações (cálculo de valor por tempo)
- [x] Pesquisas por cliente, veículo, ou placa
- [x] Validação de dados (como placa duplicada)
- [x] Interface gráfica intuitiva com Java Swing

---

## 🔧 Requisitos para rodar o projeto

- Java JDK 8 ou superior
- NetBeans IDE (ou outra IDE compatível)
- Firebird instalado e rodando (porta padrão 3050)
- Driver JDBC **Jaybird** (adicione à biblioteca do projeto)

---

## 📝 Observações Finais

- ✅ O projeto foi finalizado conforme os requisitos propostos pela disciplina.
- ⚠️ **Correções e melhorias futuras serão necessárias** nas seguintes telas:
  - `TelaCadastroVaga`
  - `TelaCadastroLocacao`
  - `TelaCadastroCliente`

---

## 👨‍💻 Autor

**Bruno Silva**  
📧 [https://github.com/TheDevBruno]

---

## 📷 Prints (opcional)

Adicione capturas de tela do sistema aqui, se desejar mostrar o funcionamento visual.

---

## 📌 Licença

Projeto acadêmico sem fins comerciais.
