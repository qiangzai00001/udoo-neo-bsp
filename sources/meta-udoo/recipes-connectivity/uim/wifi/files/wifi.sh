killall wpa_supplicant
sleep 1
ifconfig wlan0 up
ifconfig wlan0 up
sleep 2
wpa_supplicant -Dnl80211 -iwlan0 -c/etc/wpa_supplicant1.conf -B
sleep 4
udhcpc -i wlan0 -b -t 10
