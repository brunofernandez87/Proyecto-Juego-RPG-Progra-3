import java.util.ArrayList;

public class Nombres {
    private String[] nombresHumanos={"Aldric","Kaelen","Vanya","Gareth","Elara","Thorne","Isolde"};
    private String[] nombresElfos = {"Sylvaris", "Liriel", "Thalor", "Aeris", "Faenor", "Elowen", "Galadriel"};
    private String[] nombresOrcos = {"Gorak", "Thruk", "Urzoth", "Zog", "Krash", "Durash", "Mogor"};
    private String[] apodos = {"El Grande", "Destructor", "El Sabio", "Sombra", "Martillo", "Veloz", "El Bravo"};
    public String getNombreHumano() {
        int numero=(int)(Math.random()*nombresHumanos.length);
        return nombresHumanos[numero];
    }

    public String getNombreElfo() {
        int numero=(int)(Math.random()*nombresElfos.length);
        return nombresElfos[numero];
    }

    public String getNombreOrco() {
        int numero=(int)(Math.random()*nombresOrcos.length);
        return nombresOrcos[numero];
    }

    public String getApodo() {
        int numero=(int)(Math.random()*apodos.length);
        return apodos[numero];
    }
}
