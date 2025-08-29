Para a explicação do funcionamento do código é necessário entender o que foi utilizado para sua montagem.

Foi criado dois tipos de vetores:
- Valores Ordenados (Ordenado)
- Valores Não Ordenados (NaoOrdenado)

Através desses dois vetores criados foram realizados três tipos de buscas com base:
- Busca Linear com Valores Não Ordenados 
- Busca Linear com Valores Ordenados 
- Busca Binária com Valores Ordenados

A primeira parte do código demonstra como será o funcionamento dos diferentes tipos de busca:
- Busca Linear com Valores Não Ordenados (for + if)
- Busca Linear com Valores Ordenados (for + if)
- Busca Binária com Valores Ordenados (while + if/else)
A busca é feita até a condicional do valor buscado ser igual ao valor requirido pelo sistema.

Na classe principal, é criado uma função que faz o vetor com valores não ordenados no qual não possui números repetidos, de 0 até 999.
Após isso, é clonado o vetor e ordenado para criar o vetor ordenado usado em diferentes buscas.

Os testes de quantidades de comparações foram usados valores 0, 499 e 999 para os três tipos de busca.
- É mostrado a posição do elemento e a quantidade de operações realizadas.

Mostra quais são as melhores, piores e o caso médio das diferentes tipos de buscas em relação ao vetor utilizado na atividade.
