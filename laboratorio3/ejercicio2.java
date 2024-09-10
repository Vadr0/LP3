public interface Forma {
    void dibujar();
}

///////////////////////////////////////////////////////////////////////////////////////////////

public class Circulo implements Forma {
    @Override
    public void dibujar() {
        System.out.println("Dibujando un círculo");
    }
}

/////////////////////////////////////////////////////////////////////////////////////////////////

public class Rectangulo implements Forma {
    @Override
    public void dibujar() {
        System.out.println("Dibujando un rectángulo");
    }
}

///////////////////////////////////////////////////////////////////////////////////////////////////

public class Triangulo implements Forma {
    @Override
    public void dibujar() {
        System.out.println("Dibujando un triángulo");
    }
}

//////////////////////////////////////////////////////////////////////////////////////////////////////
public class Main {
    public static void main(String[] args) {
        Forma circulo = new Circulo();
        Forma rectangulo = new Rectangulo();
        Forma triangulo = new Triangulo();

        circulo.dibujar();
        rectangulo.dibujar();
        triangulo.dibujar();
    }
}

////////////////////////////////////////////////////////////////////////////////////////////////////////

