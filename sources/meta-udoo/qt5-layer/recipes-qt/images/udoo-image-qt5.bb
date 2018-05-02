# This requires the meta-qt5 layer in your bblayers.conf !!!!

# source: http://wiki.wandboard.org/index.php/Building_Qt5_using_yocto_on_Wandboard
# If you plan to use Qt5 eglfs plugin for accelerated graphics using the framebuffer,
# you need to discard X11 and wayland so the proper graphics drivers get included.
# To achieve this add the following to your conf/local.conf :
# DISTRO_FEATURES_remove = "x11 wayland"


DESCRIPTION = "A Qt 5.5.1+ image. Tailored for the UDOO boards"

IMAGE_FEATURES += "splash ssh-server-openssh package-management debug-tweaks"

UDOO_TOOLS = " \
    ${@bb.utils.contains("MACHINE_FEATURES", "usbhost", "packagegroup-base-usbhost", "", d)} \
    i2c-tools \
    resize-rootfs \
    ${@base_conditional("ENABLE_CAN_BUS", "1", "canutils", "", d)} \
    minicom \
"

QT_TOOLS = " \
    qtbase-plugins \
    qtbase-tools \
    qtdeclarative \
    qtdeclarative-plugins \
    qtdeclarative-tools \
    qtdeclarative-qmlplugins \
    qtmultimedia \
    qtmultimedia-plugins \
    qtmultimedia-qmlplugins \
    qtsvg \
    qtsvg-plugins \
    qtsensors \
    qtimageformats-plugins \
    qtsystems \
    qtsystems-tools \
    qtsystems-qmlplugins \
    qtscript \
    qt3d \
    qt3d-qmlplugins \
    qtwebkit \
    qtwebkit-examples-examples \
    qtwebkit-qmlplugins \
    qtgraphicaleffects-qmlplugins \
    qtconnectivity-qmlplugins \
    qtlocation-plugins \
    qtlocation-qmlplugins \
    cinematicexperience \
    qt5everywheredemo \
    qtsmarthome \
    qt5ledscreen \
    qt5-env \
    qtserialbus \
"

GSTREAMER_TOOLS = " \
    packagegroup-fsl-gstreamer1.0-full \
"

REMOTE_DEBUGGING = " \
    gdbserver \
    openssh-sftp-server \
"

FSL_TOOLS = " \
    packagegroup-fsl-tools-testapps \
    packagegroup-fsl-tools-benchmark \
    packagegroup-fsl-tools-gpu \
"

IMAGE_INSTALL = "\
    packagegroup-core-boot \
    packagegroup-core-full-cmdline \
    packagegroup-base \
    ${CORE_IMAGE_EXTRA_INSTALL} \
    ${QT_TOOLS} \
    ${UDOO_TOOLS} \
    ${GSTREAMER_TOOLS} \
    ${REMOTE_DEBUGGING} \
    ${FSL_TOOLS} \
    cairo pango fontconfig freetype pulseaudio dbus \
    alsa-lib alsa-tools alsa-state fsl-alsa-plugins \
"

IMAGE_INSTALL += "evtest tslib tslib-conf tslib-tests tslib-calibrate"

IMAGE_INSTALL_append = "\
    ttf-dejavu-sans \
    ttf-dejavu-sans-mono \
    ttf-dejavu-sans-condensed \
    ttf-dejavu-serif \
    ttf-dejavu-serif-condensed \
    ttf-dejavu-common \
"
#add compiler for udooneo
IMAGE_INSTALL_append = " autoconf automake binutils binutils-symlinks cpp cpp-symlinks gcc gcc-symlinks g++ g++-symlinks gettext make libstdc++ libstdc++-dev file coreutils"

inherit core-image

# for populate_sdk to create a valid toolchain
inherit populate_sdk_qt5

