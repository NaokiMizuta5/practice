import pandas as pd
import pandas_datareader.data as web
import matplotlib.pyplot as plt
import datetime

# データ取得
start = datetime.datetime(2020, 1,1)
end = datetime.datetime.now()
# ticker_simbol = str(input("input ticker code"))
ticker_simbol = 'AAPL'
# source = str(input("input data source"))
source = 'google'
print(type(web.DataReader('AAPL','google')))

# data = web.DataReader(ticker_simbol, source, start,end)

# # 移動平均を計算
# data['SMA50'] = data['Close'].rolling(window = 50).mean()
# data['SMA200'] = data['Close'].rolling(window = 200).mean()

# # シグナルを生成
# # data['Signal'] = 0.0
# # data['Signal'][data['SMA50'] > data['SMA200']] = 1.0
# # data['Postion'] = data['Signal'].diff()

# # 株価と移動平均をプロット
# plt.figure(figsize=(12,6))
# plt.plot(data['Close'],label='Close Price')
# plt.plot(data['SMA50'],label='50 day SMA',color='orange')
# plt.plot(data['SMA200'],label='200 day SMA', color='red')
# plt.legend(loc='upper left')
# plt.title('Apple Inc Close Price with Moving Averages')
# plt.show()




