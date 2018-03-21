DESCRIPTION =  "WiFi script to connect to router automatically"
LICENSE = "CLOSED"

SRC_URI = "file://wpa_supplicant1.conf \
		   file://wifi.sh"

S = "${WORKDIR}"

INITSCRIPT_NAME = "wifi.sh"
INITSCRIPT_PARAMS = "defaults 30" 

inherit update-rc.d

do_install() {
	install -d ${D}/${sysconfdir}
	cp ${S}/wpa_supplicant1.conf ${D}/${sysconfdir}/
	
	# install the load script and let update-rc.d create the links
    	install -d ${D}${sysconfdir}/init.d
	cp ${S}/wifi.sh ${D}/${sysconfdir}/init.d/
	install -m 0755 wifi.sh ${D}/${sysconfdir}/init.d/
}

FILES_${PN} += "/etc"
