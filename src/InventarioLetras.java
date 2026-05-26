// Proyecto N°1 de POO
// Profesor: Luis Canales

// Esta es una clase que guarda cuántas veces aparece cada letra del alfabeto inglés en un texto
// Ignora números, puntuación, tildes y la ñ
// Además, no distingue entre mayúsculas y minúsculas


public class InventarioLetras {

    // Arreglo de 26 posiciones que guarda la cantidad de veces que aparece cada letra
    private int[] conteos;

    // Arreglo que guarda la suma total de las letras contadas
    private int contador;

    // Arreglo que guarda cuantas letras diferentes tienen cantidad mayor que 0
    private int cantidadLetras;

    // Constructor: recibe un texto y cuenta las letras que contiene del alfabeto inglés
    public InventarioLetras(String data) {
        conteos = new int[26];  //inicializa los conteos en 0
        contador = 0;
        cantidadLetras = 0;

        data = data.toLowerCase();

        // Recorre cada carácter del String que recibe
        for (int i = 0; i < data.length(); i++) {
            char letra = data.charAt(i);

            // Solo contaremos las letras del alfabeto inglés
            if (letra >= 'a' && letra <= 'z') {
                int indice = letra - 'a';

                if (conteos[indice] == 0) {
                    cantidadLetras++;
                }
                conteos[indice]++;   // suma 1 al conteo de esa letra
                contador++;     // suma 1 al total general
            }
        }
    }
    // Método que verifica si el carácter es válido dentro del alfabeto inglés
    private boolean letraValida(char letra) {

        letra = Character.toLowerCase(letra); // convierte todo a minúscula

        return (letra >= 'a' && letra <= 'z');
    }

    // Método  que devuelve el índice en el arreglo para una letra dada
    private int obtenerIndice(char letra) {
        letra = Character.toLowerCase(letra);

        if (!letraValida(letra)) {
            throw new IllegalArgumentException("Letra no valida"); // lanza excepción si la letra no es válida
        }
        return letra - 'a';
    }

    // Devuelve la cantidad total de letras guardadas en el inventario
    public int size() {
        return contador;
    }

    // Devuelve verdadero si el inventario no tiene letras
    public boolean isEmpty() {
        return cantidadLetras == 0;
    }

    // Devuelve cuantas veces aparece una letra en el inventario
    public int get(char letra) {
        int indice = obtenerIndice(letra);
        return conteos[indice];
    }

    // Devuelve el inventario entre corchetes, en orden alfabético
    public String toString() {
        String resultado = "[";

        for (int i = 0; i < conteos.length; i++) {
            char letra = (char) (i + 'a');   // obtiene la letra que corresponde a la posición i

            for (int j =0; j < conteos[i]; j++) {     // repite la letra las veces que indique su conteo
                resultado += letra;
            }
        }
        resultado += "]";
        return resultado;
    }

    // Encripta una letra usando el cifrado Cesar, anvanza 3 posiciones en el abecedario
    public char encriptarCesar(char letra) {
        if (letra >= 'a' && letra <= 'z') {
            return (char) ('a' + (letra - 'a'+3) %26);
        }
        if (letra >= 'A' && letra <= 'Z') {
            return (char) ('A' + (letra - 'A'+3) %26);
        }
        return letra;
    }

    // Desencripta una letra usando el cifrado Cesar inverso con desplazamiento de 3 posiciones en el abecedario
    public char desencriptarCesar(char letra){
        if (letra >= 'a' && letra <= 'z') {
            return (char) ('a' + (letra - 'a'- 3 + 26) %26);
        }

        if (letra >= 'A' && letra <= 'Z') {
            return (char)  ('A' + (letra - 'A'- 3 + 26) %26);
        }
        return letra;
    }

    // Cambia manualmente l
    public void set(char letra, int valor) {
        if (valor < 0) {
            throw new IllegalArgumentException("El valor no puede ser negtivo");
        }
        int indice = obtenerIndice(letra);

        if (conteos[indice] == 0 && valor >0) {
            contador++;
        } else if (conteos[indice] >0 && valor == 0) {
            contador--;
        }
        cantidadLetras = cantidadLetras - conteos[indice] + valor;
        conteos[indice] = valor;
    }

    // Encripta un palabra completa usando el desplazamiento
    public String encriptarPalabra(String palabra, int desplazamiento) {
        String resultado = "";
        for (int i =0; i < palabra.length(); i++) {
            char letra = palabra.charAt(i);

            if (letra >= 'a' && letra <= 'z') {
                resultado += (char) ('a'+ (letra - 'a' + desplazamiento) %26);
            } else if (letra >= 'A' && letra <= 'Z') {
                resultado += (char) ('A' + (letra - 'A' + desplazamiento) %26);
            } else  {
                resultado += letra;
            }
        }
        return resultado;

    }

    // Desencripta una palabra completa usando el desplazamiento
    public String desencriptarPalabra(String palabra, int desplazamiento) {
        String resultado = "";

        // Recorre todos los caracteres de la palabra
        for (int i = 0; i < palabra.length(); i++) {
            char letra = palabra.charAt(i);

            if (letra >= 'a' && letra <= 'z') {
                // Retrocede el desplazamiento, suma 26 para evitar negativo
                resultado += (char) ('a'+ (letra - 'a' - desplazamiento) %26);
            } else if (letra >= 'A' && letra <= 'Z') {
                resultado += (char) ('A' + (letra - 'A' - desplazamiento) %26);
            } else {
                resultado += letra;
            }
        }
        return resultado;
    }

    // Suma de este inventario junto a otro y devuelve un inventario nuevo
    public InventarioLetras add(InventarioLetras inventarioExtra) {
        InventarioLetras nuevo = new InventarioLetras("");

        for (int i = 0; i < 26; i++) {
            int suma = this. conteos[i] + inventarioExtra.conteos[i];   //suma posición por posición
            char letra = (char) (i + 'a');
            nuevo.set(letra, suma);
        }
        return nuevo;
    }

    // Resta de otro inventario a este y devuelve un inventario nuevo
    public InventarioLetras subtract(InventarioLetras inventarioExtra) {
        InventarioLetras nuevo = new InventarioLetras("");

        for (int i = 0; i < 26; i++) {
            int resta = this.conteos[i] - inventarioExtra.conteos[i];
            if (resta < 0) {
                return null;   // Retornara null si la cantidad es negativa
            }
            char letra = (char) (i + 'a');
            nuevo.set(letra, resta);
        }
        return nuevo;
    }

}










