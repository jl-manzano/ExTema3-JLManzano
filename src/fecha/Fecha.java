package fecha;

/**
 * Clase que representa una fecha con día, mes y año
 * 
 * @author Jose Manzano

 */
public class Fecha {
    public static final int DIEZ = 10;
	private int dia; // Día
    private int mes; // Mes
    private int anio; // Año

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
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    /**
     * Método que comprueba si la fecha es válida.
     * 
     * @return Devuelve 'true' si la fecha es correcta o 'false' en caso contrario.
     */
    public boolean fechaCorrecta() {
        boolean diaCorrecto; 
        boolean mesCorrecto;
        boolean anioCorrecto;
        anioCorrecto = anio > 0;
        mesCorrecto = mes >= 1 && mes <= 12;

        switch (mes) {
            case 2:
                if (esBisiesto()) {
                    diaCorrecto = dia >= 1 && dia <= 29;
                } else {
                    diaCorrecto = dia >= 1 && dia <= 28;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                diaCorrecto = dia >= 1 && dia <= 30;
                break;
            default:
                diaCorrecto = dia >= 1 && dia <= 31;
        }
        return diaCorrecto && mesCorrecto && anioCorrecto;
    }

    /**
     * Método que determina si el año es bisiesto
     * 
     * @return Devuelve 'true' si el año es bisiesto o 'false' en caso contrario
     */
    private boolean esBisiesto() {
        return (anio % 4 == 0 && anio % 100 != 0) || (anio % 400 == 0);
    }

    /**
     * Método que avanza la fecha al día siguiente
     */
    public void nextDay() {
        dia++;
        if (!fechaCorrecta()) {
            dia = 1;
            mes++;
            if (!fechaCorrecta()) {
                mes = 1;
                anio++;
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
        String resultado;

        if (dia < DIEZ && mes < DIEZ) {
            resultado = "0" + dia + "-0" + mes + "-" + anio;
        } else if (dia < DIEZ) {
            resultado = "0" + dia + "-" + mes + "-" + anio;
        } else if (mes < DIEZ) {
            resultado = dia + "-0" + mes + "-" + anio;
        } else {
            resultado = dia + "-" + mes + "-" + anio;
        }

        return resultado;

    }
}
