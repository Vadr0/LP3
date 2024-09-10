public interface Imprimible {
    void imprimir();
}

//////////////////////////////////////////////////////////////////////////////////////////////////////

public interface Escaneable {
    void escanear();
}

/////////////////////////////////////////////////////////////////////////////////////////////////////

public class Impresora implements Imprimible {
    @Override
    public void imprimir() {
        System.out.println("Imprimiendo documento...");
    }
}

//////////////////////////////////////////////////////////////////////////////////////////////////////

public class ImpresoraMultifuncional implements Imprimible, Escaneable {
    @Override
    public void imprimir() {
        System.out.println("Imprimiendo documento...");
    }

    @Override
    public void escanear() {
        System.out.println("Escaneando documento...");
    }
}

///////////////////////////////////////////////////////////////////////////////////////////////////////

public class Main {
    public static void main(String[] args) {
        Imprimible impresora = new Impresora();
        Imprimible impresoraMultifuncional = new ImpresoraMultifuncional();
        Escaneable escaneador = new ImpresoraMultifuncional();

        usarImpresora(impresora);
        usarImpresora(impresoraMultifuncional);
        usarEscaneador(escaneador);
    }

    public static void usarImpresora(Imprimible imprimible) {
        imprimible.imprimir();
    }

    public static void usarEscaneador(Escaneable escaneable) {
        escaneable.escanear();
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////
