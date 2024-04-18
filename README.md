# desafio2-controledelivery-fev24

#### Desafio 2 - Controle de Delivery

Seja bem vindo!

Este é um sistema simples idealizado para o controle de delivery de um restaurante.

### Sumário:

Desafio 2 - Controle de Delivery

Sobre - Instalação

Segurança

1. BE - Cria Novo Usuario
2. BE - Autenticação
3. BE - Busca Usuario ID

Cliente
4. BE - Cria Novo Cliente
5. BE - Consulta Cliente
6. BE - Altera Cliente
7. BE - Deleta Cliente

Pedido
8. BE - Cria Novo Pedido
9. BE - Consulta Pedido
10. BE - Lista Pedidos
11. BE - Altera Pedido
12. BE - Deleta Pedido

Entrega

13. BE - Cria Nova Entrega
14. BE - Consulta Entrega
15. BE - Altera Dados Entrega
16. BE - Deleta Entrega

Mudar Status

17. BE - Muda Status Pedido Enviado
18. BE - Muda Status Pedido Entregue
19. BE - Muda Status Pedido Cancelado

### Sobre

O propósito desse projeto é apresentar a estrutura de um desafio técnico solicitado pela Wakanda Academy. Ele foi feito com o intuito de armazenar dados de clientes, pedidos e entregas a serem feitas em restaurantes no geral.

### Instalação

Utilize o git bash para criar uma cópia deste projeto em sua máquina através do código abaixo (ou um terminal de preferência com o git instalado). Insira dentro de uma pasta de sua preferência.
git clone https://github.com/gutoagain/desafio2-controledelivery-fev24.git

Logo abaixo estarei fornecendo o endereço das APIs criadas. Forneci um arquivo json no caminho ‘scr/main/resources/postman_collection’ para ser importado e utilizado no Postman (Swagger foi utilizado aqui para importar os caminhos corretos). 

Inicie o projeto na IDE de sua preferência. Esse é caminho padrão de todas as API’s abaixo:
http://localhost:8080/controledelivery/api
São ao todo 19 API’s para utilização, e estarei explicando elas abaixo.

### Segurança

Permite o cadastro de usuários e login com autenticação via BearerToken. Os métodos das APIs abaixo só poderão ser executados caso o usuário estiver logado.

#### 1. BE - Cria Novo Usuario
Caminho: ‘/public/v1/usuario’

Esta API irá criar um novo usuário. Ela requer um corpo que necessita de um email e uma senha para ser criada.

#### 2. BE - Autenticação
Caminho: ‘/public/v1/autenticacao’

Esta API irá fazer um login e gerar uma autenticação para o usuário criado. Ela requer um corpo que necessita de um email e uma senha para gerar um token. Guarde esse token para ser utilizado nas próximas aplicações.

#### 3. BE - Busca Usuario ID
Caminho: ‘/public/v1/usuario/{idUsuario}’

Esta API irá procurar o usuário criado no banco de dados e mostrar informações sobre ele.


### Cliente

Permite o cadastro, alteração, deleção e consulta de clientes.

#### 4. BE - Cria Novo Cliente
Caminho: ‘/v1/cliente’

Esta API irá criar um novo cliente. Ela requer um corpo que necessita do nome do cliente, do email do cliente e do id do usuario que está criando o mesmo.
Para funcionar, insira o token do seu usuario na aba Authorization. Tipo de autorização: Bearer Token. 

#### 5. BE - Consulta Cliente
Caminho: ‘/v1/cliente/{idCliente}’

Esta API irá procurar o cliente criado no banco de dados e mostrar informações sobre ele. Caso não exista cliente, será retornada a mensagem "Cliente não encontrado!".
Para funcionar, insira o token do seu usuario na aba Authorization. Tipo de autorização: Bearer Token.

#### 6. BE - Altera Cliente
Caminho: ‘/v1/cliente/alteraCliente/{idCliente}’

Esta API irá alterar um cliente já existente. Ela requer um corpo que altera o nome e o email do cliente. Você pode alterar os dois ao mesmo tempo ou apenas um dado por vez, sem precisar alterar o outro. Caso não exista cliente, será retornada a mensagem "Cliente não encontrado!".
Para funcionar, insira o token do seu usuario na aba Authorization. Tipo de autorização: Bearer Token.

#### 7. BE - Deleta Cliente
Caminho: ‘v1/cliente/deletaCliente/{idCliente}’

Esta API irá deletar um cliente existente. Caso não exista cliente, será retornada a mensagem "Cliente não encontrado!".
Caso cliente for deletado, todos os pedidos e entregas vinculados a ele serão deletados também.
Para funcionar, insira o token do seu usuario na aba Authorization. Tipo de autorização: Bearer Token.

### Pedido

Permite o cadastro, alteração, deleção e consulta de pedidos. Caso criado, o pedido obrigatoriamente terá um cliente. Um cliente pode ter vários pedidos.

#### 8. BE - Cria Novo Pedido
Caminho: ‘/v1/pedido’

Esta API irá criar um novo pedido. Ela requer um corpo que necessita do nome do produto que será pedido e do id do cliente que está solicitando o pedido. O pedido será vinculado apenas ao cliente que solicitou.
Para funcionar, insira o token do seu usuario na aba Authorization. Tipo de autorização: Bearer Token. 

#### 9. BE - Consulta Pedido
Caminho: ‘/v1/pedido/{idPedido}’

Esta API irá procurar o pedido criado no banco de dados e mostrar informações sobre ele. Necessita o id do pedido. Caso não exista pedido, será retornada a mensagem "Pedido não encontrado!".
Para funcionar, insira o token do seu usuario na aba Authorization. Tipo de autorização: Bearer Token.

#### 10. BE - Lista Pedidos
Caminho: ‘/v1/pedido/listaPedidos/{idCliente}’

Esta API irá listar todos os pedidos de um cliente pela ordem de criação. Necessita o id do cliente. Caso não exista cliente, será retornada a mensagem "Cliente não encontrado!".
Para funcionar, insira o token do seu usuario na aba Authorization. Tipo de autorização: Bearer Token.

#### 11. BE - Altera Pedido
Caminho: ‘/v1/pedido/alteraPedido/{idPedido}’

Esta API irá alterar um pedido já existente. Ela requer um corpo que necessita do nome do produto para ser alterado. Caso não exista pedido, será retornada a mensagem "Pedido não encontrado!".
Para funcionar, insira o token do seu usuario na aba Authorization. Tipo de autorização: Bearer Token.

#### 12. BE - Deleta Pedido
Caminho: ‘v1/pedido/deletaPedido/{idPedido}’

Esta API irá deletar um pedido existente. Caso não exista pedido, será retornada a mensagem "Pedido não encontrado!". Se pedido for deletado, a entrega (caso existir) também é deletada.
Para funcionar, insira o token do seu usuario na aba Authorization. Tipo de autorização: Bearer Token.

### Entrega

Permite o cadastro, alteração, deleção e consulta de entregas. Caso criada, a entrega estará obrigatoriamente vinculada a um pedido.

#### 13. BE - Cria Nova Entrega
Caminho: ‘/v1/entrega’

Esta API irá criar uma nova entrega. Ela requer um corpo que necessita do endereço de entrega e do id do pedido que está solicitando a entrega. O pedido será vinculado apenas ao cliente que solicitou. 
Quando crio entrega, o pedido muda status para confirmado. Um pedido não pode haver mais de uma entrega. Se o pedido já tiver uma entrega, vai ser jogada uma mensagem “pedido já possui uma entrega”.
Para funcionar, insira o token do seu usuario na aba Authorization. Tipo de autorização: Bearer Token. 

#### 14. BE - Consulta Entrega
Caminho: ‘/v1/entrega/{idEntrega}’

Esta API irá procurar a entrega criada no banco de dados e mostrar informações sobre ela. Necessita o id da entrega. Caso não exista entrega, será retornada a mensagem "Entrega não encontrada!".
Para funcionar, insira o token do seu usuario na aba Authorization. Tipo de autorização: Bearer Token.

#### 15. BE - Altera Dados Entrega
Caminho: ‘/v1/entrega/alteraDadosEntrega/{idEntrega}’

Esta API irá alterar uma entrega já existente. Ela requer um corpo que necessita do novo endereço a ser alterado. Caso não exista entrega, será retornada a mensagem "Entrega não encontrada!".
Para funcionar, insira o token do seu usuario na aba Authorization. Tipo de autorização: Bearer Token.

#### 16. BE - Deleta Entrega
Caminho: ‘v1/entrega/deletaEntrega/{idEntrega}’

Esta API irá deletar uma entrega existente. Caso não exista entrega, será retornada a mensagem "Entrega não encontrada!".
Para funcionar, insira o token do seu usuario na aba Authorization. Tipo de autorização: Bearer Token.

### Mudar Status

Permite mudança dos status de entregas e pedidos.

#### 17. BE - Muda Status Pedido Enviado
Caminho: ‘/v1/pedido/enviado/{idPedido}’

Esta API irá mudar o status do pedido para enviado. Quando Pedido mudar status para ‘enviado’, a entrega (caso existir) irá mudar status para ‘em andamento’.
Para funcionar, insira o token do seu usuario na aba Authorization. Tipo de autorização: Bearer Token. 

#### 18. BE - Muda Status Pedido Entregue
Caminho: ‘/v1/pedido/entregue/{idPedido}’

Esta API irá mudar o status do pedido para entregue. Quando Pedido for alterado para ‘entregue’, a entrega (caso existir) irá mudar status para ‘‘concluida’.
Para funcionar, insira o token do seu usuario na aba Authorization. Tipo de autorização: Bearer Token. 

#### 19. BE - Muda Status Pedido Cancelado
Caminho: ‘/v1/pedido/cancelado/{idPedido}’

Esta API irá mudar o status do pedido para cancelado. Quando Pedido for alterado para ‘cancelado’, a entrega (caso existir) irá mudar status para ‘nao realizada’’.
Para funcionar, insira o token do seu usuario na aba Authorization. Tipo de autorização: Bearer Token. 
