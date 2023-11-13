# ACH2118 Introdução ao Processamento de Língua Natural 
## Relatório de Implementação do Classificador de Clareza para Respostas na Plataforma eSIC

## 1. Informações Gerais:

Este relatório apresenta os resultados da implementação de um classificador de nível de clareza para respostas publicadas na plataforma eSIC. O objetivo central do projeto foi desenvolver um modelo capaz de categorizar as respostas em três níveis de clareza, identificados como 'c1', 'c234' e 'c5'. O trabalho foi conduzido em duas partes distintas: a primeira envolveu o desenvolvimento do classificador e a apresentação dos resultados médios de acurácia utilizando validação cruzada de 10 partições sobre o conjunto de dados de treinamento. A segunda parte consistiu na geração de previsões para o conjunto de teste.

Ao longo deste processo, realizamos uma análise exploratória dos dados, aplicamos técnicas de pré-processamento, vetorização de texto e implementamos modelos de aprendizado de máquina clássicos e neurais. O relatório detalha cada etapa do desenvolvimento, desde a importação e análise dos dados até a avaliação final dos modelos no conjunto de teste.

Os algoritmos testados incluíram Naive Bayes, Support Vector Machine, Random Forest e LSTM, sendo que a otimização dos modelos foi realizada através do grid search para SVM e Random Forest. As métricas de avaliação, como acurácia média na validação cruzada e acurácia no conjunto de teste, foram registradas para cada algoritmo, proporcionando uma visão abrangente do desempenho de cada modelo.

Os resultados obtidos neste relatório são essenciais para a escolha do modelo mais adequado para a tarefa de classificação de respostas na plataforma eSIC, contribuindo para a eficácia na análise de clareza dessas respostas.

## 2. Análise Exploratória dos Dados:

Realizamos uma análise preliminar do conjunto de dados utilizando as bibliotecas pandas e matplotlib, executando as seguintes etapas:

- Importamos o dataset.
- Utilizamos funções como `describe()`, `info()`, `isna()`, `isnull()`, e `duplicates()` para entender a estrutura e qualidade dos dados.
- Com o matplotlib, identificamos as palavras mais comuns para cada rótulo e comparamos a distribuição de ocorrências.

## 3. Tratamento dos Dados:

Realizamos o seguinte pré-processamento nos dados:

- Transformação dos textos para lowercase.
- Tokenização do texto com o NLTK.
- Extração de lemmas utilizando o spacy (pt_core_news_sm).
- Remoção de caracteres cuja POS tag era punct (pontuação).
- Extração de n-gramas das sentenças (bigramas e trigramas).
- Encoding dos rótulos.

O resultado desse tratamento foi armazenado em um arquivo chamado "esic2023_cleaned.csv".

## 4. Separação do Conjunto de Dados:

Utilizamos a biblioteca sklearn para dividir o conjunto de dados em treino e teste, garantindo a ausência de vazamento de informações.

## 5. Técnicas de Vetorização de Texto:

Utilizamos técnicas clássicas de vetorização de texto, incluindo:

- TFIDF (com max_features=5000) do sklearn, tanto nas sentenças originais quanto nas lemmatizadas.

## 6. Técnicas de Word Embeddings:

Empregamos duas técnicas de word embeddings:

- BERT (base uncased portuguese) da biblioteca transformers, com hiperparâmetros específicos.
- Word2Vec do gensim, com parâmetros definidos.

## 7. Modelagem com Algoritmos Clássicos:

Testamos os seguintes algoritmos:

- Naive Bayes.
- Support Vector Machine.
- Random Forest.

## 8. Modelagem com Algoritmos Neurais:

Testamos o seguinte algoritmo:

- LSTM

## 8. Otimização dos Modelos:

Realizamos otimização utilizando grid search do sklearn nos modelos de SVM e RF.

## 9. Avaliação no Conjunto de Treinamento:

Após a otimização, avaliamos os modelos fazendo a média de um cross-validation de 10 folds.

## 10. Avaliação no Conjunto de Teste:

Finalmente, testamos a acurácia dos modelos no conjunto de teste separado no início do processo.

## Resultados:

A tabela abaixo corresponde as informações dos melhores modelos treinados usando vetorização por TFIDF:

| Algoritmo            | Hiperparâmetros              | Acurácia Média (Cross-Validation) | Acurácia no Conjunto de Teste |
|----------------------|------------------------------|-----------------------------------|---------------------------------|
| Naive Bayes          | standard                     | 54%                               | 53%                             |
| SVM                  | C=2.0, kernel=rbf            | 56.55%                            | 58%                             |
| Random Forest        | standard                     | 56%                               | 55%                             |

A tabela abaixo corresponde as informações dos melhores modelos treinados usando os Embeddings produzids pelo BERTimbau:

| Algoritmo            | Hiperparâmetros              | Acurácia Média (Cross-Validation) | Acurácia no Conjunto de Teste |
|----------------------|------------------------------|-----------------------------------|---------------------------------|
| SVM                  | C=3.0, kernel=linear         | 52%                               | 52%                             |
| Random Forest        | standard                     | 52%                               | 52%                             |
| LSTM                 | input_size=768, hidden_size=16, output_size=3                    | ---|                        52% |

## Conclusão:

Percebemos que a combinação mais promissora foi:

Vetorização usando TFIDF no texto lemmatizado, removendo pontuações. SVM usando como valores de entrada 70% dos dados vetorizados, com os seguintes hiperparametros: C=2.0, kernel=rbf.

Gerando uma média de acurácia no cross validation de 10 folds de: 56.55%

## 11. Extra: Instruções para reprodução do melhor modelo

Basta seguir as instruções presentes no arquivo main.ipynb