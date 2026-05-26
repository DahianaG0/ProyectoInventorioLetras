
public class PruebaInventario {
    public static void main(String[] args) {

        // Creamos un inventario con la frase "Hola Mundo"
        InventarioLetras inv = new InventarioLetras("Hola mundo");

        // Prueba del método toString()
        System.out.println("Inventario de 'Hola Mundo': " + inv);

        // Prueba del método size()
        // "Hola Mundo" tiene 9 letras
        System.out.println("size: " + inv.size());

        // Prueba del método isEmpty()
        // Verdadero si el inventario tiene letras y Falso si contiene letras
        System.out.println("isEmpty: " + inv.isEmpty());

        // Prueba del método get()
        // La letra 'o' aparece 2 en "Hola Mundo"
        System.out.println("get('o'): " + inv.get('o'));

        // Prueba de encriptarCesar()
        // Con un desplazamiento de 3, la 'a' se transformara en 'd'
        System.out.println("encriptarCesar('a'): " + inv.encriptarCesar('a'));

        // Prueba de desencriptarCesar()
        // En el sentido inverso, la 'd' vuelve a ser 'a'
        System.out.println("desencriptarCesar('d'): " + inv.desencriptarCesar('d'));

        // Prueba de set()
        inv.set('a', 5);
        System.out.println("Después de set('a', 5): " + inv);
        System.out.println("get('a'): " + inv.get('a'));

        // Hacemos dos inventarios nuevos
        InventarioLetras inv1 = new InventarioLetras("Alan Turing");
        InventarioLetras inv2 = new InventarioLetras("Ada Lovelace");

        // Prueba de add()
        // Sumara las cantidades de inv1 e inv2
        InventarioLetras suma = inv1.add(inv2);
        System.out.println("inv1: " + inv1);
        System.out.println("inv2: " + inv2);
        System.out.println("suma: " + suma);


        // Probamos subtract
        // suma - inv1 debe dar algo similar a inv2
        InventarioLetras resta = suma.subtract(inv1);
        System.out.println("suma - inv1: " + resta);

        // Prueba de un resta imposible (restaLoca)
        // Si alguna cantidad queda negativa, retornara null
        InventarioLetras restaLoca = inv1.subtract(suma);
        System.out.println("inv1 - suma: " + restaLoca);

        // Manejo de excepciones en get()
        // Dado que estamos usando el alfabeto inglés, la 'ñ' no corresponde y debe lanzarse error
        try {
            inv.get('ñ');
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Manejo de excepciones en set()
        // No se permiten cantidad negativas, por lo que debe lanzarse error
        try {
            inv.set('a', -3);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
}