# ep1-dsid
Código do desenvolvimento do EP 1 da disciplina de Desenvolvimento de Sistemas de Informações Distribuídos

PROPOSTO:

Cliente | Computador1 (2*[servidor, repositorio]) | Computador2 ([servidor, repositorio])
image.png

 * Repositorio pode ser linked-list
 
 - [Pendente] Interface Part
    - ID, automaticamente gerado pelo sistema
    - nome
    - descricao
    - list de subcomponentes (subPart, quant)
 
 - [Pendente] Objeto PartRepository
    - inserir Part
    - recuperar Part
    - return list de todas as Parts do repositório
    *Neste EP, apenas os servidores implementados por PartRepository devem ser registrados e recuperados do serviço de nomes do Java RMI.

- [Pendente] Servidor
    - poderao ocorrer várias execuções simultâneas do programa servidor
    - cada processo implementa (PartRepository, Part)
    - !cuidado, paramentros devem variar para os servidores. Add nome servidor

- [Pendente] Cliente
    - conexao com o servidor
    - com o Repository:
        - examinar o nome e peças contidas
        - listar as peças
        - buscar peças
            - return nome e descricao
            - nome do repositorio
            - return primitiva/agregada?
            - return qtd de subcomponentes diretos e primitivos da peça
            - return lista de subpeças
        - adicionar novas peças
            - !peças agregadas cujas sub-peças estejam distribuı́das por vários repositórios.


FUNCIONAMENTO:

PartRepository é um objeto distribuı́do, que será exposto por um processo servidor e que implementa um repositório de informações sobre peças. Os clientes se conectam a servidores que possuem uma instância de PartRepository. O servidor, por sua vez, implementa 2 tipos de objetos o PartRepository (que é uma interface de acesso) e Parts (vários objetos remotos armazenados no servidor).
O cliente deve poder, por exemplo, se conectar ao servidor A, pegar uma peça, se conectar ao servidor B, e inserir a referência a essa peça lá. Com isso, é possı́vel construir peças agregadas que são formadas por peças originadas em servidores diferentes. Executar os métodos nessas peças agregadas irá disparar chamadas a métodos das instâncias desses objetos que estão espalhados por todos esses servidores.

DICAS DO PROFESSOR:

Provavelmente o mais fácil é escrever um cliente com uma interface tipo linha de comando.

Uma possibilidade é um cliente “linha de comando” que mantenha três variáveis:

• O “repositório corrente”, uma referência ao repositório com o qual toda interação ocorre;

• A “peça corrente”, uma referência à peça com a qual toda interação ocorre;

• A “lista de subpeças corrente”, usada exclusivamente quando uma nova peça é adicionada
    ao repositório corrente.

Tal cliente apresentaria um prompt e ficaria esperando comandos do usuário. Ele aceitaria
comandos como:


- bind Faz o cliente se conectar a outro servidor e muda o repositório corrente. Este comando recebe o nome de um repositório e obtém do serviço de nomes uma referência para esse repositório, que passa a ser o repositório corrente.

- listp Lista as peças do repositório corrente.

- getp Busca uma peça por código. A busca é efetuada no repositório corrente. Se encontrada, a peça passa a ser a nova peça corrente.

- showp Mostra atributos da peça corrente.

- clearlist Esvazia a lista de sub-peças corrente.

- addsubpart Adiciona à lista de sub-peças corrente n unidades da peça corrente.

- addp Adiciona uma peça ao repositório corrente. A lista de sub-peças corrente é usada como

- lista de subcomponentes diretos da nova peça. (É só para isto que existe a lista de

- sub-peças corrente.)

- quit Encerra a execução do cliente.

A lista acima tem a finalidade de ilustrar como um cliente “linha de comando” poderia funcionar. Tome-a como uma sugestão (incompleta, por sinal), que pode ser seguida ou não.
Se você tiver gás para escrever um cliente com uma interface com o usuário mais elaborada e amigável (GUI), vá em frente!

