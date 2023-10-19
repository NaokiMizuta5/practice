import hashlib
import time

class Block:
    def __init__(self, index, previous_hash, timestamp, data,hash ):
        # pythonのコンストラクタはselfで定義
        self.index = index
        self.previous_hash = previous_hash 
        self.timestamp = timestamp
        self.data = data
        # ブロックごとに一意のハッシュを持つ
        self.hash = hash 

# ブロックの属性からハッシュ値を計算する関数
def calculate_hash(index, previous_hash, timestamp, data):
    # hashlib.アルゴリズム名(バイナリデータ).hexdigest()
    # すなわちsha256で{中身}を16進数へ変換し、出力
    return hashlib.sha256(f'{index}{previous_hash}{timestamp}{data}'.encode('utf-8')).hexdigest()

# ジェネシスブロックは始まりのブロック
def create_genesis_block():
    return Block(0, '0', time.time(), 'Genesis Block', calculate_hash(0,'0',time.time(), 'Genesis Block'))

def create_new_block(prev_block, data):
    index = prev_block.index + 1
    timestamp = time.time()
    hash = calculate_hash(index, prev_block.hash, timestamp, data)
    return Block(index, prev_block.hash, timestamp, data, hash)

# ブロックチェーンの初期化
blockchain = [create_genesis_block()]
previous_block = blockchain[0]

# 新しいブロックを追加
for i in range(1, 10):
    new_data = f"Block #{i} data"
    new_block = create_new_block(previous_block, new_data)
    blockchain.append(new_block)
    previous_block = new_block
    print(f"Block #{new_block.index} has been added to the blockchain!")
    print(f"Hash: {new_block.hash}\n")



