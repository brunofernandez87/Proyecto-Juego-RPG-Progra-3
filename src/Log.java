import java.io.*;
import java.time.LocalDate;
public class Log {
    private static final String archivo ="partidas.txt";
    public void guardarPartida(String reporteCompleto){
        String fecha = LocalDate.now().toString();
        String encabezado = "Partida jugada - " + fecha;
        try (FileWriter file = new FileWriter(archivo, true);
             BufferedWriter bw = new BufferedWriter(file);
             PrintWriter out = new PrintWriter(bw)) {
            out.println("\n" + encabezado);
            out.println(reporteCompleto);
            out.println("___________________________________________________");
            System.out.println(" Partida guardada en el historial detallado.");

        } catch (IOException e) {
            System.err.println("Error al guardar el historial: " + e.getMessage());
        }
    }
    public void mostrarHistorial() {
        File archivo = new File(Log.archivo);
        if (!archivo.exists()) {
            System.out.println("Todavía no hay partidas guardadas.");
            return;
        }
        System.out.println("\n=== HISTORIAL DE PARTIDAS ===");
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el historial: " + e.getMessage());
        }
        System.out.println("=============================");
    }

    public void borrarHistorial() {
        File archivo = new File(Log.archivo);
        if (archivo.exists()) {
            if (archivo.delete()) {
                System.out.println("Historial borrado correctamente.");
            } else {
                System.out.println("No se pudo borrar el historial.");
            }
        } else {
            System.out.println("No existe historial para borrar.");
        }
    }
}
