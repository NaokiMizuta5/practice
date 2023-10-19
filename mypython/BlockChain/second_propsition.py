import hashlib 
import time 

class Block:
    def __init__(self, index, previous_hash, timestamp, data, hash, nonce):
        self.index = index
        self.previous_hash = previous_hash 
        self.timestamp = timestamp
        self.data = data
        self.hash = hash 
        self.nonce = nonce
        # nonce stands for Number used once (ワンタイムトークン)


def calculate_hash(index, previous_hash, timestamp, data, nonce):
    return hashlib.sha256(f'{index}{previous_hash}{timestamp}{data}{nonce}'.encode('utf-8').hexdigest())

# 改ざん防止関数
# マイナーの役割を果たす
# 条件を満たすようなハッシュ値となるnonceを見つける
# 下記の場合、条件はdifficulty_stringから始まること
def proof_of_work(block, difficulty_string):
    nonce = 0
    # returnに到達しない限りループ
    while True:
        hash = calculate_hash(block.index, block.previous_hash, block.timastamp, block.data, nonce)
        if hash[:len(difficulty_string)] == difficulty_string:
            return hash, nonce
        nonce += 1        

def create_genesis_block():
    index = 0
    timestamp = time.time()
    data = "Genesis Block"
    nonce = 0
    hash = calculate_hash(index, '0', timestamp, data, nonce)
    return Block(index, '0', timestamp, data, hash, nonce)

def create_new_block(prev_block, data, difficulty="0000"):
    index = prev_block.index + 1
    timestamp = time.time()
    temp_block = Block(index, prev_block.hash, timestamp, data, '', 0)
    hash, nonce = proof_of_work(temp_block, difficulty)
    return Block(index, prev_block.hash, timestamp, data, hash, nonce)

blockchain = [create_genesis_block()]
previous_block = blockchain[0]

for i in range(1,5):
    data = f"Block #{i} data"
    new_block = create_new_block(previous_block, data)
    blockchain.append(new_block)
    previous_block = new_block
    print(f"Block #{new_block.index} has been added to the blockchain!")
    print(f"Hash: {new_block.hash} \n")