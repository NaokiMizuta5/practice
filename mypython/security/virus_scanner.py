import hashlib

def file_hash(filename):
    """ファイルのハッシュ値計算"""
    h = hashlib.sha256

    with open(filename, 'rb') as file:
        chunk = 0
        while chunk != b'':
            chunk = file.read(1024)
            h.update(chunk)
    
    return h.hexdigest()

def check_file(filename, virus_db):
    """ファイルがウイルスデータベースにあるかどうかをチェックする"""
    filehash = file_hash(filename)
    if filehash in virus_db:
        return True
    return false

# サンプルウイルスのハッシュ値データベース
virus_db = ['123456789abcdef...', 'abcdef123456789...']

# ファイルをチェック
filename = 'example.exe'
if check_file(filename, virus_db):
    print(f"{filename} is infected.")
else:
    print(f"{filename} is clean.")