volatile unsigned char * const UART0_PTR = (unsigned char *)0x0101f1000;
void display(const char *string){
    while(*string != '\0'){
        *UART0_PTR = *string;
        string++;
    }
}
 
int my_init(){
    display("Hello Open World\n");
}

