
package guia5part2extra3;

class Libro {
    private String titulo;
    private String autor;
    private int numEjemplares;
    private int numEjemplaresPrestados;

    public Libro(String titulo, String autor, int numEjemplares) {
        this.titulo = titulo;
        this.autor = autor;
        this.numEjemplares = numEjemplares;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getNumEjemplares() {
        return numEjemplares;
    }

    public int getNumEjemplaresPrestados() {
        return numEjemplaresPrestados;
    }

    public void prestamo() {
        if (numEjemplares - numEjemplaresPrestados > 0) {
            numEjemplaresPrestados++;
            System.out.println("Préstamo realizado correctamente.");
        } else {
            System.out.println("No hay ejemplares disponibles para prestar.");
        }
    }

    public void devolucion() {
        if (numEjemplaresPrestados > 0) {
            numEjemplaresPrestados--;
            System.out.println("Devolución realizada correctamente.");
        } else {
            System.out.println("No hay ejemplares prestados para devolver.");
        }
    }

    @Override
    public String toString() {
        return "Título: " + titulo + ", Autor: " + autor + ", Ejemplares disponibles: " + (numEjemplares - numEjemplaresPrestados);
    }
}
