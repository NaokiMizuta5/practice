import socket
import struct 

def create_socket():
    """Rawソケットを作成し、IPヘッダーを受信するように設定"""
    try:
        s = socket.socket(socket.AF_INET, socket.SOCK_RAW, socket.IPPROTO_IP)
    except socket.error as msg:
        print('Socket could not be created. Error Code : '+str(msg[0])+ ' Message ' + msg[1])
        return None 
    
    return s

def start_firewall():
    """ファイアウォールを開始"""
    host = socket.gethostbyname(socket.gethostname())
    s = create_socket()
    if s is None:
        return 

    s.bind((host, 0))
    s.setsockeopt(socket.IPPROTO_IP, socket.IP_HDRINCL, 1)
    s.iocrl(socket.STO_RCVALL, socket.RCVALL_ON)

    print("FIrewall is runnning...")

    try:
        while True:
            packet = s.recvfrom(65565)

            # パケットの解析
            packet = packet[0]
            ip_header = packet[0:20]
            iph = struct.unpack('!BBHHHBBH4s4s', ip_header)

            version_ihl = iph[0]
            version = version_ihl >> 4
            ihl = version_ihl & 0xF
            iph_length = ihl * 4

            ttl = iph[5]
            protocol = iph[6]
            s_addr = socket.inet_ntoa(iph[8]);
            d_addr = socket.inet_ntoa(iph[9]);

            # ここでフィルタリングルールを設定(例: 特定のIPアドレスをブロック)
            if s_addr == '特定のIPアドレス' or d_addr == '特定のIPアドレス':
                print('BLocked IP:',s_addr, d_addr)
                continue

            print('Allowed IP:',s_addr, d_addr)
    except KeyboardInterrupt:
        s.ioctl(socket.SIO_RCVALL, socket.RCVALL_OFF)
        print("Firewall stopped.")

if __name__ == "__main__":
    start_firewall()
