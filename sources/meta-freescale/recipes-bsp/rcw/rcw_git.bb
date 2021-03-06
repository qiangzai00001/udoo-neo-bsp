SUMMARY = "Reset Configuration Word"
DESCRIPTION = "Reset Configuration Word - hardware boot-time parameters for the QorIQ targets"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=3775480a712fc46a69647678acb234cb"

DEPENDS += "change-file-endianess-native tcl-native"

inherit deploy

SRC_URI = "git://source.codeaurora.org/external/qoriq/qoriq-yocto-sdk/rcw;nobranch=1"
SRCREV = "7bd43d920065171a8d805a3d02fa4c0b39885664"

S = "${WORKDIR}/git"

export PYTHON = "${USRBINPATH}/python2"

EXTRA_OEMAKE = "BOARDS=${@d.getVar('MACHINE', True).replace('-64b','').replace('-32b','')} DESTDIR=${D}/boot/rcw/"

do_install () {
    oe_runmake install
    for f in `find ${D}/boot/rcw/ -name "*qspiboot*"`;do
        if echo $f |grep -q "qspiboot_sben"; then
            continue
        fi
        f_swap=`echo $f |sed -e 's/qspiboot/qspiboot_swap/'`
        tclsh ${STAGING_BINDIR_NATIVE}/byte_swap.tcl $f $f_swap 8
        mv -f $f_swap $f
    done
}

do_deploy () {
    install -d ${DEPLOYDIR}/rcw
    cp -r ${D}/boot/rcw/* ${DEPLOYDIR}/rcw/
}
addtask deploy after do_install

PACKAGES += "${PN}-image"
FILES_${PN}-image += "/boot"

COMPATIBLE_MACHINE = "(qoriq)"
PACKAGE_ARCH = "${MACHINE_ARCH}"
