<h1 align="center"> Teste técnico </h1>


# Índice 


* [📚 Informações do documento](#📚-Informações-do-documento)

* [📁 Case](#📁-Case)
* [🎯 Coding Part](#🎯-Coding-part)
* [🛠️ Abrir e rodar o projeto](#🛠️-Abrir-e-rodar-o-projeto)
* [✔️ Técnicas e tecnologias utilizadas](#✔️-Técnicas-e-tecnologias-utilizadas)


# 📚 Informações do documento

Este documento é composto por três seções:

- **Documento**:
    - `README.md`
        - Nele contém todas as explicações necessárias sobre o programa. 
        
- **db1Sotre**:
    - Nele contém o código backend.
    

- **front**:
    - Nele contem parte do código front, que não dei continuidade devido erro no Node.js 
            

# 📁 Case
Requisitos:
- Cadastro de produtos:
    -  Produto deve ter nome, preço, quantidade e foto(s)
    - O usuário poderá editá-los ou exclui-los
    - Uma listagem mostrando os produtos cadastrados
- Carrinho de compras:
    - Usuário deve ser capaz de adicionar e remover produtos
    - O usuário deve ser capaz de modificar a quantidade de itens
    - Deve ser calculado o valor total dos produtos do carrinho, atualizando-a de acordo com a quantidade que o usuário informar
    - O botão “Finalizar” deve concluir a compra e levar a uma tela com a compra finalizada, persistindo os dados no banco.

- Validações
    - Cadastro de produtos deve ter campos obrigatórios(nome, preço,
quantidade)
    - Carrinho de compras deve validar as quantidades de produto,
impedindo que o usuário compre mais do que o estoque do mesmo.

- Stack
    - Java(Spring Boot)
    - React
    - SQL(PostgreSQL, Oracle, MySQL)

- Diferenciais:
    - [Controle de versão(Git)](https://github.com/carolinacorvettogit/Db1Store.git"GitHub")
    - Docker

# 🎯 Coding Part

Os próximos tópicos são referentes a aplicação implementada.

# 🔨 Funcionalidade do projeto

- `Funcionalidade`: O programa deve ter uma interface para cadastrar, excluir e editar produtos. Nele também deve ser possível realizar a simulação de uma compra em uma interface e-commerce.

# 📁 Acesso ao projeto


# 🛠️ Abrir e rodar o projeto

**IMPORTANTE** : Antes de rodar o projeto verifique se possui o Java instalado em sua máquina, caso não possua faça o [Download](https://www.java.com/pt-BR/ "Download Java") e realiza a instalação.
    

1. Via **Editor de Código** 

    Na implementação foi utilizado o [Eclipice](https://www.eclipse.org "Eclipse"), mas você pode utilizar outros Editores de Código que são capazes de rodar arquivos Java, como [Notepad++](https://notepad-plus-plus.org/downloads/ "Notepad++"), [Visual Studio](https://visualstudio.microsoft.com   "Visual Studio"), dentro outros... 

    - Faça o download do **Editor de Código** desejado para executar o programa java.
    - Abra a pasta importando em modo maven.
    - Execute a classe Db1StoreApplication.java
    - Pronto! O programa irá rodar na porta padrão, basta acessar 
        - http://127.0.0.1:8080/ para visualizar o e-commerce
        - http://127.0.0.1:8000/admin para verificar a área administrativa de produtos




# ✔️ Técnicas e tecnologias utilizadas

- ``Java(Spring Boot)``
- ``SQL(MySQL)``
- ``Markdown``
- ``Html``
- ``bootstrap``



