package fecha;

/**
 * Clase que representa una fecha con día, mes y año
 * 
 * @author Jose Manzano

 */
public class Fecha {
    private int d; // Día
    private int m; // Mes
    private int a; // Año

    /**
     * Constructor default de la clase Fecha
     */
    public Fecha() {
    }

    /**
     * Constructor que inicializa una fecha con valores pasados como parámetro
     * 
     * @param dia  Día de la fecha
     * @param mes  Mes de la fecha
     * @param anio Año de la fecha
     */
    public Fecha(int dia, int mes, int anio) {
        this.d = dia;
        this.m = mes;
        this.a = anio;
    }

    /**
     * Método que comprueba si la fecha es válida.
     * 
     * @return Devuelve 'true' si la fecha es correcta o 'false' en caso contrario.
     */
    public boolean fechaCorrecta() {
        boolean diaCorrecto, mesCorrecto, anioCorrecto;
        anioCorrecto = a > 0;
        mesCorrecto = m >= 1 && m <= 12;

        switch (m) {
            case 2:
                if (esBisiesto()) {
                    diaCorrecto = d >= 1 && d <= 29;
                } else {
                    diaCorrecto = d >= 1 && d <= 28;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                diaCorrecto = d >= 1 && d <= 30;
                break;
            default:
                diaCorrecto = d >= 1 && d <= 31;
        }
        return diaCorrecto && mesCorrecto && anioCorrecto;
    }

    /**
     * Método que determina si el año es bisiesto
     * 
     * @return Devuelve 'true' si el año es bisiesto o 'false' en caso contrario
     */
    private boolean esBisiesto() {
        return (a % 4 == 0 && a % 100 != 0) || (a % 400 == 0);
    }

    /**
     * Método que avanza la fecha al día siguiente
     */
    public void diaSiguiente() {
        d++;
        if (!fechaCorrecta()) {
            d = 1;
            m++;
            if (!fechaCorrecta()) {
                m = 1;
                a++;
            }
        }
    }

    /**
     * Método que devuelve la fecha
     * 
     * @return Cadena con la fecha formateada
     */
    @Override
    public String toString() {
        if (d < 10 && m < 10) {
            return "0" + d + "-0" + m + "-" + a;
        } else if (d < 10) {
            return "0" + d + "-" + m + "-" + a;
        } else if (m < 10) {
            return d + "-0" + m + "-" + a;
        } else {
            return d + "-" + m + "-" + a;
        }
    }
}
