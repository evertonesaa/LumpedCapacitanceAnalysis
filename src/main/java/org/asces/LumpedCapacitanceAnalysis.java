package org.asces;

import java.util.*;
import java.io.FileWriter;
import java.io.IOException;


public class LumpedCapacitanceAnalysis {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Entrada de dados (mantido igual)
        System.out.print("Informe a temperatura ambiente (T_inf) em °C: ");
        double T_inf = sc.nextDouble();

        System.out.print("Informe a temperatura inicial do corpo (T_i) em °C: ");
        double T_i = sc.nextDouble();

        System.out.print("Informe o coeficiente de convecção (h) em W/m²K: ");
        double h = sc.nextDouble();

        System.out.print("Informe a área da superfície (A) em m²: ");
        double A = sc.nextDouble();

        System.out.print("Informe o volume do corpo (V) em m³: ");
        double V = sc.nextDouble();

        System.out.print("Informe a densidade do material (rho) em kg/m³: ");
        double rho = sc.nextDouble();

        System.out.print("Informe o calor específico (c) em J/kg.K: ");
        double c = sc.nextDouble();

        System.out.print("Quantos pontos experimentais você deseja inserir? ");
        int n = sc.nextInt();

        double[] t = new double[n];
        double[] T_exp = new double[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Tempo (s) [" + (i + 1) + "]: ");
            t[i] = sc.nextDouble();
            System.out.print("Temperatura Experimental (°C) [" + (i + 1) + "]: ");
            T_exp[i] = sc.nextDouble();
        }

        // Cálculos (mantido igual)
        double m = rho * V;
        double tau = (m * c) / (h * A);

        double[] T_teo = new double[n];
        for (int i = 0; i < n; i++) {
            T_teo[i] = T_inf + (T_i - T_inf) * Math.exp(-t[i] / tau);
        }

        // Cálculo das métricas
        double rmse = 0, ss_tot = 0, ss_res = 0;
        double media_exp = Arrays.stream(T_exp).average().getAsDouble();

        for (int i = 0; i < n; i++) {
            rmse += Math.pow(T_teo[i] - T_exp[i], 2);
            ss_res += Math.pow(T_exp[i] - T_teo[i], 2);
            ss_tot += Math.pow(T_exp[i] - media_exp, 2);
        }

        rmse = Math.sqrt(rmse / n);
        double r2 = 1 - (ss_res / ss_tot);

        // Saída no console (mantido igual)
        System.out.println("\nResultados:");
        System.out.println("Tempo (s)\tT_Exp (°C)\tT_Modelo (°C)");
        for (int i = 0; i < n; i++) {
            System.out.printf("%.2f\t\t%.2f\t\t%.2f%n", t[i], T_exp[i], T_teo[i]);
        }

        System.out.printf("\nRMSE: %.4f °C%n", rmse);
        System.out.printf("Coeficiente de Determinação (R²): %.4f%n", r2);

        // Geração dos arquivos CSV
        String dataFile = "data.csv";
        String rmseFile = "rmse.csv";
        String r2File = "r2.csv";

        try {
            // Arquivo com dados de temperatura
            FileWriter dataWriter = new FileWriter(dataFile);
            dataWriter.write("Tempo (s),Temperatura Experimental (°C),Temperatura Modelo (°C)\n");
            for (int i = 0; i < n; i++) {
                dataWriter.write(String.format(Locale.US, "%.2f,%.2f,%.2f\n", t[i], T_exp[i], T_teo[i]));
            }
            dataWriter.close();
            System.out.println("\nArquivo '" + dataFile + "' gerado com sucesso!");

            // Arquivo com RMSE
            FileWriter rmseWriter = new FileWriter(rmseFile);
            rmseWriter.write("Metrica,Valor\n");
            rmseWriter.write(String.format(Locale.US, "RMSE,%.4f\n", rmse));
            rmseWriter.close();
            System.out.println("Arquivo '" + rmseFile + "' gerado com sucesso!");

            // Arquivo com R²
            FileWriter r2Writer = new FileWriter(r2File);
            r2Writer.write("Metrica,Valor\n");
            r2Writer.write(String.format(Locale.US, "R2,%.4f\n", r2));
            r2Writer.close();
            System.out.println("Arquivo '" + r2File + "' gerado com sucesso!");

        } catch (IOException e) {
            System.err.println("Erro ao gerar arquivos: " + e.getMessage());
        }

        sc.close();
    }
}