<h1 align="center">:file_cabinet: Kaikei</h1>

## :memo: Descrição
Aplicação web onde vai realizar leitura de arquivo de transação financeira para verificar se teve alguma transaçao suspeita para empresa no ramo de auditoria.

## :books: Funcionalidades
* <b>Funcionalidade 1</b>: Controle de acesso: É necessário realizar login usando e-mail cadastrado e senha.
* Protegido com google reCAPTCHA para evitar ataque de spam e bot.
  ![principal](https://github.com/Lucas-Kato/ProjetoFinalAcademia2023/assets/118133248/80039344-be2a-42d6-b25b-d5ed86d2d8b3)
  
* Quando tenta realizar o acesso sem estar logado. Vai aparecer alerta "Usuário ou senha inválido".
  ![falha de acesso](https://github.com/Lucas-Kato/ProjetoFinalAcademia2023/assets/118133248/5ec11545-2e81-49d7-949b-db152ff324c3)

* <b>Funcionalidade 2</b>: Cadastro de usuário para acesso.
* Acesso a página de cadastro está liberado para todos, conforme configuração do autorização na parte de segurança;
* Para realizar cadastro, é necessário só nome e e-mail para cadastrar;
* Protegido com google reCAPTCHA para evitar ataque de spam e bot.
  ![tela de cadastro](https://github.com/Lucas-Kato/ProjetoFinalAcademia2023/assets/118133248/adc35a80-9624-43b5-aaf3-8bba8e501bdd)

* <b>Funcionalidade 3</b> Envio de senha para acesso.
* Quando o cadastro for realizado com sucesso, vai aparecer alerta de envio de senha.
  ![envio e-mail](https://github.com/Lucas-Kato/ProjetoFinalAcademia2023/assets/118133248/222ca56b-c552-4694-827e-98a63a291d15)
  
* Vai ser encaminhado e-mail com senha gerado randomicamente.
  ![e-mail recebido](https://github.com/Lucas-Kato/ProjetoFinalAcademia2023/assets/118133248/0b2a7180-972e-4b30-b9e6-8476982651c2)

 * <b>Funcionalidade 4</b>: Importação.
 * Após sucesso no login, vai ser direcionado para página onde realiza importação do arquivos.
  ![sucesso login](https://github.com/Lucas-Kato/ProjetoFinalAcademia2023/assets/118133248/82916051-585a-4730-b156-af34afe6f069)

 * Será necessário selecionar o arquivo e clicar no ícone "importar".
  ![importação do arquivo](https://github.com/Lucas-Kato/ProjetoFinalAcademia2023/assets/118133248/8231fd3c-5a31-4bb7-844b-6b92401d3bde)

 * Se o arquivo não tiver com formato correto, vai aparececr a tela de erro. 
  ![falha ao importar](https://github.com/Lucas-Kato/ProjetoFinalAcademia2023/assets/118133248/a695e551-f074-480d-af29-7c3eef6f75ad)

 * Se o formato estiver correto, vai salvar o arquivo importado.
 * E no mesmo momento, vai ser mostrado a data da transação, importação.
  ![salva](https://github.com/Lucas-Kato/ProjetoFinalAcademia2023/assets/118133248/68809e84-5fbc-451d-96fd-7fe3edb34741)

 * Após a importação, libera a opção "detalhar", onde pode ser visualizado o conteúdo do arquivo, contendo data, nome do usuário que foi realizdo a importação, banco,conta, agência e o valor.
  ![detalhar](https://github.com/Lucas-Kato/ProjetoFinalAcademia2023/assets/118133248/0a6f5b91-88b9-4627-aa1e-54d2a37ace0a)

* <b>Funcionalidade 5</b>: Alteração dos dados cadastrais.
* Na página do cadastro, vai aparecer lista de usuários cadastrados.
  <img width="960" alt="usuários cadastrados" src="https://github.com/Lucas-Kato/ProjetoFinalAcademia2023/assets/118133248/7ec2471d-926d-40ad-94a2-0bf1edf23fe3">

*Ao clicar no ícone editar, vai possibilitar a alteração dos dados cadastrados (nome e e-mail).
  <img width="960" alt="alteração do cadastro" src="https://github.com/Lucas-Kato/ProjetoFinalAcademia2023/assets/118133248/09e264b5-d45e-44e1-a37b-37c7b631e9f7">

*Após alteração de nome ou e-mail, vai aparecer tela de sucesso.
   <img width="960" alt="alteração do sucesso" src="https://github.com/Lucas-Kato/ProjetoFinalAcademia2023/assets/118133248/d8ba8f88-c489-4097-8351-f222e1645f04">

*Após clicar no ícone de excluir, vai aparececr tela de sucesso.
  <img width="960" alt="excluido com sucesso" src="https://github.com/Lucas-Kato/ProjetoFinalAcademia2023/assets/118133248/3f4a8a6f-3410-43be-a20c-e87ee98b6add">

* <b>Funcionalidade 6</b>:Análise de dados.
* Na página de análise de transações. Seleciona o mês e o ano que deseja realizar a leitura.
  <img width="960" alt="mes e o ano" src="https://github.com/Lucas-Kato/ProjetoFinalAcademia2023/assets/118133248/82ad5cb6-ba2d-41ee-9212-fda1914b918a">

*Após selecionar e clicar em realizar análise, vai lista as transações e separar por bloco: Transações suspeitas, contas suspeitas e agência supeira.
  <img width="960" alt="analise" src="https://github.com/Lucas-Kato/ProjetoFinalAcademia2023/assets/118133248/74a05c26-60f8-4f38-b894-3df3111d13be">


## :wrench: Tecnologias utilizadas
* HTML;
* CSS;
* Thymeleaf;
* BootsTrap;
* Java 17;
* Spring Boot 3.1.0
* Spring Web;
* Java Mail Sender;
* Spring Security 6.1.0
* Google reCaPTCHA v3;
* Spring Data JPA;
* MySQL Driver;
* MySQL;
* Validation;
* Lombok;
* OpenCSV 5.7.1;
* Maven 3.9.0;

## :handshake: Colaboradores
  Lucas Satoshi Kato

## :dart: Status do projeto
  Finalizado.
