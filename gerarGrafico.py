import pandas as pd
import matplotlib.pyplot as plt

data = pd.read_csv("data.csv")
rmse = pd.read_csv("rmse.csv")
r2 = pd.read_csv("r2.csv")

rmse_value = rmse.iloc[0,1]  
r2_value = r2.iloc[0,1] 

plt.figure(figsize=(10,5), dpi=200)

plt.scatter(data['Tempo (s)'],data['Temperatura Experimental (°C)'],  color='red', label='Experimental',zorder=3)
plt.plot(data['Tempo (s)'], data['Temperatura Modelo (°C)'], 
         color='blue', linewidth=2,
         label=f'Modelo Teórico (R² = {r2_value}, RMSE = {rmse_value})')

plt.ylabel("Temperatura (°C)")
plt.xlabel("Tempo (s)")
plt.title("Análise de Resfriameno de Material")

plt.legend()
plt.tight_layout()


plt.savefig('grafico.png', dpi=300)
plt.show()