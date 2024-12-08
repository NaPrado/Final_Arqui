import java.util.Random;
import java.util.Scanner;

public class Main {
    static Question [] questions = new Question[93];
    static void swap(int a, int b){
        Question aux=questions[a];
        questions[a]=questions[b];
        questions[b]=aux;
    }
    static boolean makeQuestion(Question q){
        System.out.println(q.getQuestion());
        q.setParam();
        boolean ret=q.match();
        System.out.println(q.getSugestion());
        if (ret){
            System.out.println("Bien");
        }else{
            System.out.println("Mal");
        }
        return ret;
    }
    public static void main(String[] args) {
        int i=0;
        questions[i++]=new Question("Al querer iniciar un programa, siempre se asigna el espacio de memoria antes que el jmp a la dirección de memoria del programa.","Falso, pues supongamos que tenemos un programa que únicamente realiza operaciones con los registros. No hace falta asignar memoria porque no se va a utilizar. Por lo tanto no siempre.",false);
        questions[i++]=new Question("La memoria de un programa está compuesta únicamente por Código, Datos, Heap y Pila.","Código: Instrucciones del programa.\n" +
                "Datos: Variables estáticas y globales que se inician al cargar el programa.\n" +
                "Heap: Memoria dinámica que se reserva y se libera en tiempo de ejecución.\n" +
                "Pila: Argumentos y variables locales a la funció\n",true);
        questions[i++]=new Question("En la sección de Datos se guardan las variables locales de una función. ","Falso, las variables locales se guardan en el stack.",false);
        questions[i++]=new Question("Tanto en Linux como en Windows, la extensión de un archivo es quien determina el tipo de archivo. ","Falso, en Linux no hay extensiones de archivos.",false);
        questions[i++]=new Question("Para llamar a funciones dentro de assembler (asumiendo arquitectura de 32 bits), es lo mismo hacer CALL  ‘función‘, que hacer push ESP -> jmp  ‘función ‘.","Falso, porque no se debe pushear el ESP sino la siguiente instrucción que se apunta por el EIP.",false);
        questions[i++]=new Question("Si tenemos un ejecutable el cual podemos correr, y cambiamos algunos bits en el .o, reemplazando quizás unas letras de un string, al volver a correr el ejecutable, estas letras estarán cambiadas en el string en cuestión.","Falso, pues se debe volver a linkeditar y crear un nuevo ejecutable.",false);
        questions[i++]=new Question("Sabemos que la comunicación entre SO y User Space está dada por las Syscalls. El SO no analiza continuamente las instrucciones que se corren, es decir, no se queda “escuchando”, sino que cuando desde el User Space se hace una syscall, el SO interrumpe sus tareas y lleva a cabo dicha syscall. ","Verdadero, porque el SO directamente no se está ejecutando. ",true);
        questions[i++]=new Question("Hay por lo menos una syscall la cual recibe un puntero a función y lo corre desde el SO.","Falso, porque implicaría un riesgo de seguridad significativo. No se quiere que el User ejecute funciones en el Kernel Space, donde está el SO.",false);
        questions[i++]=new Question("Olvidándonos de los permisos, si yo quiero acceder a una posición de memoria del stack, siempre lo único que necesito es el ESP (asumiendo 32 bits). ","Falso, porque también se necesita el SS (stack segment). Recordemos que se trabaja de a pares (agrupamiento).",false);
        questions[i++]=new Question("En un instante de tiempo siempre hay exactamente un programa ejecutándose, sin excepciones.","Verdadero, estamos en unicore por lo que sólo se ejecuta un programa a la vez.",true);
        questions[i++]=new Question("Una persona no puede hacer mov ah, 12345678h.","Verdadero, porque el registro ah es de 8 bits (en estructura de 32) y 12345678h tiene 32 bits.",true);
        questions[i++]=new Question("Existe un requisito importante para los sistemas operativos Multitarea que es tener espacio de memoria individual para cada tarea, y un espacio de memoria común para varias tareas.","Verdadero, recordemos que cuando tenemos muchos programas abiertos al mismo tiempo, en realidad no corren al mismo tiempo. Corre un poco de uno, después del otro, etc., pero lo hace tan rápido que nosotros no nos damos cuenta.",true);
        questions[i++]=new Question("De apagar la PC, al volverla a prender, en la memoria RAM, en un inicio puedo\n" +
                "asegurarme de que todos los bits estarán en 0.\n","Falso, sólo sabemos que la información no se guarda, pero los bits quedan de manera indeterminada.",false);
        questions[i++]=new Question("Es ilegal hacer mov [100h], [eax].","Verdadero, en assembler no existe el movimiento de datos de memoria a memoria en una sola instrucción.",true);
        questions[i++]=new Question("Solo contamos con las siguientes secciones: .text y .data.","Falso, hay otras como la .bss para reservar memoria sin inicializar. ",false);
        questions[i++]=new Question("Una ventaja de Linux es la portabilidad, lo que se suele cambiar es código de C y no de asm para adaptarlo a otro hardware. ","Verdadero. “The Unix operating system ensures code is transferable to any computer system because a sizable portion of it is written in the C language, and only a small portion is coded for particular hardware. Because of this, the Unix operating system is extremely portable.”",true);
        questions[i++]=new Question("La E en ESP stands for Extended, y la R en RSP stands for Requete-Extended.","Falso, la R en RSP significa register.",false);
        questions[i++]=new Question("En 32 bits, el valor de retorno de una función de C llamada desde asm siempre se guarda en eax. ","Falso, porque depende de lo que se quiera retornar:\n" +
                "Si el valor es menor a 32 bits se retorna en EAX.\n" +
                "Si es mayor retorna la parte alta en EDX y la parte baja en EAX.\n" +
                "Si es un dato más complejo (ej. Estructura de datos) retorna un puntero formado por EDX:EAX\n",false);
        questions[i++]=new Question("El canary se coloca entre el EBP y las variables locales. ","Facto",true);
        questions[i++]=new Question("La GOT se utiliza para resolver direcciones las cuales no son conocidas al momento de linkedición.","Verdadero, la Global Offset Table (GOT) se utiliza para resolver direcciones de funciones y variables globales que no son conocidas al momento de la linkedición.",true);
        questions[i++]=new Question("El tipo de memoria SRAM se suele utilizar para la caché. ","Verdadero.",true);
        questions[i++]=new Question("Las DRAM a pesar de ser no volátiles, no necesitan un refresco de memoria.","Falso porque la DRAM es volátil y sí necesitan un refresco de memoria cada n milisegundos.",false);
        questions[i++]=new Question("El Tiempo de Acceso de una memoria se compone de la latencia y la transferencia.","Verdadero. Transferencia: tiempo que tarda un bit en viajar desde el procesador a la memoria. La tasa es casi la misma en todas las computadoras porque depende del cobre. Latencia: tiempo que tarda la memoria en devolver el valor. Es lo que determina la velocidad. Esto quiere decir que una memoria sea más rápida que la otra, qué tan rápido devuelve.",true);
        questions[i++]=new Question("La patita IO/M, si vale 1 hay operaciones con periféricos, si vale 0 con la memoria. ","Verdadero, porque con 1 se accede al mapa de Entrada/Salida.",true);
        questions[i++]=new Question("En un sistema de Entrada y Salida existe el acceso directo a memoria, sin la\n" +
                "intervención de la CPU.\n","Verdadero, porque sabemos que existe la DMA (acceso directo a memoria), que permite que un periférico acceda a memoria sin pasar por la CPU.",true);
        questions[i++]=new Question("La única entrada de interrupción de hardware que hay en el micro es la INTR. ","Falso, porque la INTR es para las interrupciones enmascarables y la NMI para las no enmascarables.",false);
        questions[i++]=new Question("La instrucción sti es para habilitar las interrupciones, cli para detenerlas. ","Verdadero",true);
        questions[i++]=new Question("De estar el flag IF en 1, las interrupciones estarán habilitadas. ","Verdadero",true);
        questions[i++]=new Question("No hay un valor específico el cual el EOI le envía al PIC. ","Falso, le envía el valor 20h.",false);
        questions[i++]=new Question("En la IDT únicamente hay interrupciones de software y de hardware.","Falso, porque también están las excepciones.",false);
        questions[i++]=new Question("Sabiendo que 0FEh son los bits necesarios para habilitar únicamente la interrupción de teclado en el PIC. Para hacer esto, sin preocuparnos por detalles como perder el valor que estaba en al, una rutina de assembler posible sería: \n" +
                "mov al, 0FEh \n" +
                "Out 20h, al\n","Falso, porque para leer y escribir en el PIC se debe usar el puerto 21h.",false);
        questions[i++]=new Question("Si alguien hace cli y justo después hlt, la CPU se quedará sin hacer nada y no hay forma de ejecutar una interrupción para que se salga del hlt.","Falso, porque una interrupción que llega por la NMI, al no poder ser enmascarable, hará que el CPU salga de hlt.",false);
        questions[i++]=new Question("Una excepción la cual puede corregirse es llamada un abort.","Falso, porque las excepciones que pueden corregirse se llaman faults. El abort reporta errores severos.",false);
        questions[i++]=new OptionQuestion("¿Quién se da cuenta (lanza la excepción) de que un programa está accediendo a una zona para la cual no tiene permisos?\n" +
                "1- El micro\n" +
                "2- El SO\n" +
                "3- El PIC\n","El microprocesador, porque el sistema operativo no está corriendo (estamos en unicore). ",1);
        questions[i++]=new OptionQuestion("¿Cómo sabe el micro dónde está la IDT para acceder a la misma cuando se ejecuta una interrupción?\n" +
                "1- CR3\n" +
                "2- Está siempre en la misma posición de memoria sin importar el SO\n" +
                "3- Magia\n" +
                "4- Hay un registro IDTR especial para esto.\n","La dirección de la IDT se guarda en el registro IDTR.",4);
        questions[i++]=new Question("Se llama modo Flat a aquel que tiene la unidad de segmentación desactivada.","Falso, porque la unidad de segmentación no se puede desactivar, se puede bypassear con el modo flat. ",false);
        questions[i++]=new Question("Si empiezo mi equipo con las unidades de Segmentación y Paginación prendidas, tanto el tamaño de las páginas como el tamaño de los segmentos será siempre el mismo."," Falso, porque los segmentos son de tamaño variable.",false);
        questions[i++]=new OptionQuestion("¿Cuál de los siguientes no es un registro de segmento?\n" +
                "1- CS\n" +
                "2- GS\n" +
                "3- PS\n" +
                "4- FS\n","El que no existe es el PS. El CS es Code Segment y los otros dos también existen.",3);
        questions[i++]=new Question("Un segmento tiene 2 niveles de privilegio, 0 para Kernel Space, 1 para User Space.","Falso, porque son 2 bits y por lo tanto 4 niveles de privilegio, pero comúnmente sólo se usan 2.",false);
        questions[i++]=new OptionQuestion("Si alguien fuese a poner un 4 en el IOPL de los EFLAGS. ¿Qué pasaría?\n" +
                "1- No cambiaría mucho, normalmente está en 4.\n" +
                "2- Estaría habilitando a programas del Kernel Space y el User Space a usar instrucciones de Entrada/Salida.\n" +
                "3- Solamente el Kernel Space podría usar instrucciones de E/S.\n" +
                "4- Ni siquiera el Kernel Space podría usar instrucciones de E/S.\n"+
                "5- Ninguna de las anteriores","Un 4 no se puede poner porque son únicamente 2 bits, pero suponiendo que se refiere a 3 (nivel más alto de privilegio), lo que pasaría es que se habilita a programas del  Kernel Space y el User a usar instrucciones de Entrada/Salida.",5);
        questions[i++]=new OptionQuestion("El Task State Segment se utiliza para:\n" +
                "1- Guardar el contexto de ejecución.\n" +
                "2- Cumple una función similar a la IDT.\n" +
                "3- Tiene los descriptores de los distintos segmentos\n" +
                "4- Ninguna de las anteriores.\n","El Task State Segment (TSS) se utiliza principalmente para guardar el contexto completo de ejecución de un hilo o tarea.",1);
        questions[i++]=new Question("El GDT es quien guarda los descriptores de los distintos segmentos.","Verdadero. La GDT y la LDT se encargan de guardar los descriptores de segmento.",true);
        questions[i++]=new StrQuestion("¿Quién es el encargado de pasar una dirección virtual a física?","La Memory Management Unit (MMU) se encarga de transformar una dirección virtual a su equivalente física.","mnu");
        questions[i++]=new Question("Dos páginas en la memoria virtual de dos procesos distintos no pueden ser exactamente la misma página en la memoria física.","Falso, porque podemos tomar el caso de las librerías que están en sólo lectura.",false);
        questions[i++]=new Question("Para Caché se usa Dynamic RAM.","Falso, se usa SRAM.",false);
        questions[i++]=new Question("Utilizar el Caché es más rápido porque cuando se modifica un dato en un determinado bloque de la Caché, no va a hacer falta reemplazarlo en RAM.","Falso, porque en algún momento se debe sincronizar la información en caché y en memoria. Es más rápido porque optimiza no tener que ir a buscar instrucciones en memoria para, por ejemplo, un ciclo. ",false);
        questions[i++]=new Question("La arquitectura AMD64 no es compatible con 32 bits.","Falso, es compatible.",false);
        questions[i++]=new Question("La arquitectura se puede definir (según Intel) como la implementación de una serie de instrucciones definidas.","Verdadero. Podemos decir que una arquitectura es la misma por ejemplo si comparten cartilla ASM.",true);
        questions[i++]=new Question("La compatibilidad está definida por la Arquitectura.","Verdadero.",true);
        questions[i++]=new OptionQuestion("¿Cuándo lanzó ARM su primer micro ARM1?\n" +
                "1- 1985\n" +
                "2- 1987\n" +
                "3- 1986\n" +
                "4- 1988\n","1985.",1);
        questions[i++]=new Question("En ARM una instrucción de salto, cuando la condición es verdadera, hace que se vacíe el pipeline.","Verdadero, se vacía para no realizar operaciones de más, dado que las instrucciones siguientes no se deben fetchear.",true);
        questions[i++]=new Question("Los pipelines son siempre de 3 niveles para mejor eficiencia. ","Falso, el número de niveles en un pipeline puede variar ampliamente dependiendo de la arquitectura del procesador y del diseño específico del pipeline.",false);
        questions[i++]=new Question("El hecho de que todas las instrucciones ocupen lo mismo en ARM significa que no habrá desfases grandes entre distintos pipes.","Falso, porque no depende del tamaño de la instrucción. Siempre el decode es más rápido.",false);
        questions[i++]=new Question("Si un programa tiene varios threads, es necesario que estos se corran en núcleos distintos.","Falso, porque el Scheduler le puede ir asignando el procesador de a momentos a cada thread para ejecutarse. ",false);
        questions[i++]=new Question("El pin IO/M es controlado por las instrucciones In, OUT.","Verdadero",true);
        questions[i++]=new Question("Cuando hay una falta de página el procesador busca el puntero de la excepción en la IDT.","Verdadero, porque se genera una excepción de falta de página. Como la excepción es una interrupción, el puntero se encuentra en la IDT. Luego se busca en la GDT el puntero a la rutina de atención de interrupción.",true);
        questions[i++]=new Question("En una arquitectura de 64 los registros utilizados para el pasado de parámetros están definidos.","Verdadero, tienen un orden determinado.",true);
        questions[i++]=new Question("En el registro CR3 están indicados los permisos de quién puede acceder a la tabla de directorios.","Falso, en CR3 está la dirección de memoria del directorio de tabla de páginas.",false);
        questions[i++]=new Question("Una vez desactivada la segmentación, se puede usar sólo la paginación","Falso, porque la segmentación no se puede desactivar. Se puede en todos caso bypassear en modo flat.",false);
        questions[i++]=new Question("El timer tick es un circuito integrado que se encuentra en la mother y está conectado directamente al PIC","Verdadero, porque funciona como un periférico. Interrumpe al PIC que interrumpe al procesador.",true);
        questions[i++]=new Question("La función stack-chk-fail revisa toda la pila para verificar que nadie la haya alterado","Falso, verifica si coincide el canary.",false);
        questions[i++]=new Question("Los circuitos complejos de compuertas no son buenos para sistemas computacionales o de cálculo exacto.","Verdadero, se puede facilitar mucho con el uso de decodificadores. El tiempo de propagación puede ser más largo.",true);
        questions[i++]=new Question("Intel proporciona un mecanismo para que el SO indique en qué sectores del disco se guardó la página.","Falso, porque es el mismo sistema operativo el que se debe encargar de guardar dónde guardó la página.",false);
        questions[i++]=new Question("Los procesadores de Intel acceden a memoria con el mismo ancho del bus de datos pero usan direccionamiento de un byte.","Verdadero, lo hacen para mantener la retrocompatibilidad. ",true);
        questions[i++]=new OptionQuestion("Que es Jazelle?\n"+
                "1- Una tecnica de programcion\n" +
                "2- Una forma de ejecutar c en ARM\n" +
                "3- Una extension para ejecutar java en ARM\n"+
                "4- El nombre de un proyecto de procesador entre 32b y 64b\n","Jazelle permite ejecutar bytecode de Java a procesadores ARM. Las instrucciones que no posee pueden ser emuladas.",3);
        questions[i++]=new Question("La etapa “fetch” puede ocasionar una demora si la etapa “execute” intenta usar los mismos recursos.","Esto sucede cuando la instrucción tiene corchetes, es decir que se debe ir a buscar información a memoria. En dicho caso, la etapa fetch y la execute pueden tardar lo mismo porque realizan una acción similar, ir a memoria y traer “algo”.",true);
        questions[i++]=new OptionQuestion("Una interrupción NMI busca la rutina de atención en la posición\n" +
                "1- 10h\n" +
                "2- 20h\n" +
                "3- 21h\n" +
                "4- Ninguna de las anteriores.\n","Ninguna de las anteriores.",4);
        questions[i++]=new OptionQuestion("En un programa compilado por gcc, después de realizar un CALL, el registro ESP\n" +
                "apunta a:\n" +
                "1- El canary\n" +
                "2- Al EBP\n" +
                "3- Al ESP anterior\n" +
                "4- Ninguna de las anteriores\n","Ninguna de las anteriores. Apunta a la instrucción que se encuentra luego del call, que es donde debe retornar una vez ejecutada la función.",4);
        questions[i++]=new OptionQuestion("El procesador revisa los permisos cuando:\n" +
                "1- Accede a un segmento\n" +
                "2- Hace una interrupción\n" +
                "3- Accede una página\n" +
                "4- Todas las anteriores son Correctas\n" +
                "5- Ninguna de las anteriores\n"," Todas las opciones son correctas. ",4);
        questions[i++]=new OptionQuestion("Para la utilización de instrucciones condicionales en ARM:\n" +
                "1- Es necesario THUMB\n" +
                "2- Es necesario Jazell\n" +
                "3- Es necesario TDMI\n" +
                "4- Ninguna de las anteriores\n","Ninguna de las anteriores. Es una característica de las instrucciones en ARM, dado que al tener tamaño fijo permiten que los bits más significativos funcionen como condicional.",4);
        questions[i++]=new MultOptionQuestion("Para los procesadores multicore, las interrupciones son\n" +
                "1- Individuales en cada procesador\n" +
                "2- Centralizadas por APIC\n" +
                "3- Centralizadas por 2 PIC\n" +
                "4- Ninguna de las anteriores\n","Son individuales para cada procesador y centralizadas por APIC. Cada core tiene su apic.",new int[]{1,2});
        questions[i++]=new OptionQuestion("La cantidad de IDT máximas en un momento indicado son\n" +
                "1- Una\n" +
                "2- Dos\n" +
                "3- Tres\n" +
                "4- Ninguna de las anteriores\n","Sólo puede haber una IDT.",1);
        questions[i++]=new OptionQuestion(" En los procesadores ARM:\n" +
                "1- Todos los periféricos están mapeados en memoria y todas las operaciones\n" +
                "son condicionales.\n" +
                "2- Todos los periféricos están mapeados en memoria y algunas operaciones son condicionales.\n" +
                "3- Algunos periféricos están mapeados en memoria y algunas operaciones son condicionales.\n" +
                "4- Ninguna de las anteriores.\n","Todos los periféricos están mapeados en memoria y todas las operaciones son condicionales, pues los primeros 4 bits determinan si la condición se cumple o no.",1);
        questions[i++]=new OptionQuestion("Las RAM que se utilizan en las PC son:\n" +
                "1- DRAM\n" +
                "2- SRAM\n" +
                "3- FRAM\n" +
                "4- Ninguna de las anteriores\n","Las PC usan las DRAM (Dynamic RAM).",1);
        questions[i++]=new Question("Las rutinas de interrupción en BIOS no dejan de existir al instalarse el SO.","Verdadero, siguen existiendo y utilizándose.",true);
        questions[i++]=new Question("Frente a la falta de página se genera una interrupción.","Verdadero, porque se genera una excepción de falta de página que es una interrupción. ",true);
        questions[i++]=new Question("En 64 bits, los parámetros en C pasan tanto por los registros como la pila.","Verdadero, porque al quedarse sin registros utiliza también la pila para el pasaje de parámetros.",true);
        questions[i++]=new Question("IOPL contiene el nivel de privilegio de quien puede acceder a las instrucciones de\n" +
                "E/S.\n","Verdadero, IPOL son bits del registro EFLAGS.",true);
        questions[i++]=new Question("Con paginación habilitada, dejan de usarse las direcciones físicas por las lineales.","Falso, no dejan de usarse sino que se transforman.",false);
        questions[i++]=new Question("El timer tick es la salida de un contador en motherboard.","Verdadero, es un integrado que interrumpe al procesador cada una cantidad de tiempo.",true);
        questions[i++]=new Question("La función stack-chk-fail revisa toda la pila para verificar que nadie la haya alterado.","Falso, sólo verifica el canary, no todo el stack.",false);
        questions[i++]=new Question("Los circuitos complejos de compuertas no son buenos para sistemas\n" +
                "computacionales o de cálculo exacto.\n","Verdadero (repetido).",true);
        questions[i++]=new Question("Intel proporciona un mecanismo para que el SO indique en qué sectores del disco se guardó la página.","Falso (repetido).",false);
        questions[i++]=new Question("Los procesadores de Intel acceden a memoria con el mismo ancho del bus de datos pero usan direccionamiento de un byte.","Verdadero (repetido).",true);
        questions[i++]=new Question("Existen direcciones numéricamente iguales en mapa de memoria y mapa de E/S que habilitan dispositivos distintos.","En los procesadores hay una entrada llamada IO/M. Lo que permite hacer es duplicar el mapa de memoria, para así colocar en uno las memorias y en otro los periféricos. Por lo tanto, para una misma dirección va a depender de la entrada IO/M si se está accediendo a memoria o a un periférico.",true);
        questions[i++]=new Question("Existen 2 arquitecturas de 64 bits de Intel.","Hay dos arquitecturas:\n" +
                "Intel 64/EM64T: Extensión Intel de 64 bits, compatible con 32 bits.\n" +
                "IA-64: Tecnología Intel de 64 bits (Itanium) no compatible con 32. No lograron hacerlo funcionar, fracasó.\n",true);
        questions[i++]=new OptionQuestion("La entrada INTR del micro puede ser enmascarada con\n" +
                "1- retf\n" +
                "2- cli\n" +
                "3- sti\n" +
                "4- Ninguna de las anteriores\n","Para enmascarar la entrada INTR se utiliza cli.",2);
        questions[i++]=new OptionQuestion("Luego de realizar CALL para correr una función compilada en gcc, el registro EBP\n" +
                "1- Es igual al ESP\n" +
                "2- Apunta a la dirección de retorno\n" +
                "3- Mantiene el valor\n" +
                "4- Ninguna de las anteriores\n","Mantiene su valor, no se modifica.",3);
        questions[i++]=new OptionQuestion("El modelo de actualización que escribe en caché y RAM al mismo tiempo se llama\n" +
                "1- Write late\n" +
                "2- Write back\n" +
                "3- Write through\n" +
                "4- Ninguna de las anteriores\n","El modelo de actualización simultánea entre caché y RAM se denomina write through.",3);
        questions[i++]=new OptionQuestion("La dirección lineal puede ser\n" +
                "1- Igual a la lógica\n" +
                "2- Igual al selector\n" +
                "3- Igual a la física\n" +
                "4- Ninguna de las anteriores\n","Puede ser igual a la física si la paginación está desactivada e igual a la física si la memoria está en modo flat.",3);
        questions[i++]=new OptionQuestion("La cantidad de IDT máximas en un momento indicado son\n" +
                "1- 1\n" +
                "2- 2\n" +
                "3- 3\n" +
                "4- Ninguna de las anteriores\n","La IDT es una sola.",1);
        questions[i++]=new MultOptionQuestion("Para los procesadores multicore, las interrupciones son\n" +
                "1- Individuales en cada procesador\n" +
                "2- Centralizadas por APIC\n" +
                "3- Centralizadas por 2 PIC\n" +
                "4- Ninguna de las anteriores\n","Individuales en cada procesador y centralizadas por APIC (repetido).",new int[]{1,2});
        questions[i++]=new OptionQuestion("En un micro con 32 buses de address, si tengo un dispositivo desde FEDEF000h\n" +
                "hasta FEDEFFFFh necesito _____ decodificadores de 4 entradas\n" +
                "1- 4\n" +
                "2- 5\n" +
                "3- 6\n" +
                "4- Ninguna de las anteriores\n","Vemos que entre FEDEF000h y FEDEFFFFh van a coincidir FEDEF, que son los 20 bits más significativos. Por lo tanto, como 20/4 = 5, vamos a necesitar 5 decos de 4 entradas.",2);
        int corrects=0;
        int incorrects=0;
        for (int ii = 0; ii < questions.length; ii++) {
            Random r = new Random();
            swap(ii,ii+r.nextInt(i-ii));
            if(makeQuestion(questions[ii])){
                corrects++;
            } else {
                incorrects++;
            }
        }
        System.out.println("Correctos: "+corrects);
        System.out.println("Incorrectos: "+incorrects);
    }
}