DESCRIPTION = "test it"
SECTION = "examples"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://uart.c file://spl.s file://linker.ld"

S = "${WORKDIR}"

do_compile() {
	${AS} spl.s -o spl.o
	${CC} -c uart.c -o uart.o
	${LD}  -T linker.ld uart.o spl.o -o output.elf
	${OBJCOPY} -O binary output.elf output.bin
}

do_install() {
}
