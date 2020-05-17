import speedtest as st


def get_speeds():
    try:
        speed_test = st.Speedtest()
        speed_test.get_best_server()
        download = speed_test.download()
        download_mbps = round(download / (10 ** 6), 2)
        print(download_mbps)
    except:
        print(0)


get_speeds()
