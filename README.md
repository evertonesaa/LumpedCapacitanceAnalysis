# Análise de Capacitância Agrupada (Lumped Capacitance Method)

Este projeto implementa a análise de capacitância agrupada (Lumped Capacitance Method) para modelar o resfriamento/aquecimento de um corpo em um ambiente com convecção.

## 📌 Visão Geral

O método da capacitância agrupada é uma abordagem simplificada para análise térmica transitória que assume que a temperatura do corpo é uniforme em qualquer instante (gradiente de temperatura interno desprezível). Este programa:

- Calcula a temperatura teórica ao longo do tempo usando o modelo de capacitância agrupada
- Compara com dados experimentais fornecidos pelo usuário
- Calcula métricas de qualidade do ajuste (RMSE e R²)

## 📋 Pré-requisitos

- Java JDK (versão 8 ou superior)
- Git (opcional, para clonar o repositório)

## 🚀 Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/lumped-capacitance-analysis.git
   cd lumped-capacitance-analysis
2. Compile e execute o programa:
   javac org/asces/LumpedCapacitanceAnalysis.java
   java org.asces.LumpedCapacitanceAnalysis
3. Siga as instruções no terminal para inserir os parâmetros:

        Temperatura ambiente (T_inf)

        Temperatura inicial do corpo (T_i)

        Coeficiente de convecção (h)

        Área da superfície (A)

        Volume do corpo (V)

        Densidade do material (rho)

        Calor específico (c)

        Pontos experimentais (tempo e temperatura)

📊 Saída do Programa

O programa fornecerá:

    Uma tabela comparando temperaturas experimentais e do modelo

    RMSE (Root Mean Square Error)

    Coeficiente de Determinação (R²)
