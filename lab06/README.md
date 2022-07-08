# Projeto `<B-Side Dungeon>`

# Descrição

B-Side Dungeon é um jogo linear no qual o mundo a ser explorado é composto por salas,
e o jogador deve resolver puzzles para prosseguir entre tais salas;

Cada sala do mundo real está ligada a uma sala do "mundo invertido", adicionando a mecânica na qual
o protagonista tem a habilidade de “inverter o mundo”, permitindo que explore e atinja regiões antes inacessíveis;

A cooperação entre as ações realizadas nas salas normais e "invertidas" são essenciais para a resolução dos puzzles,
sendo o objetivo final: passar por todas as salas se libertando da Dungeon.

# Equipe
* `Guilherme Buzzetti De Souza` - `235883`
* `Paulo Vitor Rodrigues Nogueira` - `247309`

# Arquivo Executável do Jogo

[Executável](start.jar)

# Estrutura de Arquivos e pastas

~~~
├── README.md          <- apresentação do projeto
│
├── data               <- dados usados pelo jogo
│
│
├── images             <- imagens auxiliares para a apresentação 
│   
│
├── bin                <- arquivos em bytecode (.class)
│   └── game     
│
├── src                <- arquivos-fonte do projeto (.java)
│   └── game     
│
└── assets             <- mídias usadas no projeto
~~~


# Slides do Projeto

## Slides da Prévia

[Slides](slide.pdf)

# Instrucoes de instalacao

    git clone https://github.com/KernelPointers/mc322-projects #Clone o repositorio
    cd lab06 #Entre no diretorio do jogo
    java -jar start.jar #Execute o arquivo .jar

# Como jogar

## Controles

* `w` - move o personagem para frente 

* `a` - move o personagem para esquerda

* `s` - move o personagem para baixo

* `d` - move o personagem para direita

* `e` - interage com items

* `c` - coleta a chave

* `i` - inverte o mundo


# Diagramas

## Diagrama Geral da Arquitetura do Jogo

![Diagrama Geral de Componentes](images/diagrama_componentes.png)

# Arquitetura

## Componentes

![World](images/diagram_world.png)
    
![Body](images/diagram_body.png)
    
![Controller](images/diagram_controller.png)
    
![Builder](images/diagram_builder.png)
    
![GraphicView](images/diagram_graphicView.png)

# Design Patterns

## Factory
...
    
## Observer
...

# Destaques de Codigo

## Mecanicas

### Vetor de Orientacao

O personagem possui um vetor que indica a posicao para onde esta encarando, 
isso nos permite saber com qual celula o player pretende interagir ou coletar
e modificar o seu sprite de acordo com sua direcao

~~~java
    public class Player extends Body implements IPlayer {
    …
    private int[] ori = new int[2]; // vetor de orientacao
    …

        public void changeVectorOrientation(char dir){
            this.dir = dir;

            if (dir == 'u'){
                ori[0] = 0;
                ori[1] = -1;
                this.spriteIndex = (3);
            } else if (dir == 'd'){
                ori[0] = 0;
                ori[1] = 1;
                this.spriteIndex = (2);
            } else if (dir == 'r'){
                ori[0] = 1;
                ori[1] = 0;
                this.spriteIndex = (0);
            } else if (dir == 'l'){
                ori[0] = - 1;
                ori[1] = 0;
                this.spriteIndex = (1);
            } 

        

            this.currentImg = img[spriteIndex];

            this.room.notifyObserver(this.i, this.j, this.currentImg, 'p');
            this.updateNextPos();
        }

        public void interact(){
            this.updateNextPos();

            char nextId = this.room.getId(nextI, nextJ);

            if (this.isLinked)
                this.unlink();
            else {
                switch(nextId){
                    case 'b' : 
                        this.linkBody(this.room.getBody(nextI, nextJ)); break;
                    case 'k' :
                        this.linkBody(this.room.getBody(nextI, nextJ)); break;
                    case 'd':
                        this.unlock();
                }
            }
        }

    …

    }
~~~

|![alt](images/direita.png) |![alt](images/frente.png)|
|-|-|
|![alt](images/esquerda.png) | ![alt](images/tras.png)

