from cryptography.fernet import Fernet 

# キーの生成
def generate_key():
    return Fernet.generate_key()

# 暗号化関数
def encrypto_file(filename, key):
    fernet = Fernet(key)
    with open(filename, 'rb') as file:
        original = file.read()

    encrypted = fernet.encrypt(original)

    with open(filename + '.enc', ' wb') as enc_file:
        enc_file.write(encrypted)

# 複合化関数
def decrypt_file(filename, key):
    fernet = Fernet(key)
    with open(filename, 'rb') as enc_file:
        encrypted = enc_file.read()

    decrypted = fernet.decrypt(encrypted)
    return decrypted

# 実行部分
key = generate_key()

# ここでファイル名を設定
filename = 'test.txt'

encrypt_file(filename, key)
print("File encrypted")

decrypted_data = decrypt_file(filename + '.enc', key)
print("decrypted content:")
print(decrypted_data.decode())