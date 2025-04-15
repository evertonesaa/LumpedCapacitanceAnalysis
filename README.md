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
