public class Elfo extends Personaje{
    public Elfo(String nombre, String apodo, String fecha_de_nacimiento, Integer edad, Integer velocidad, Integer destreza, Integer fuerza, Integer nivel, Integer armadura) throws Exception {
        super(nombre, apodo, fecha_de_nacimiento, edad, velocidad, destreza, fuerza, nivel, armadura);
    }

    @Override
    public void atacar(Personaje enemigo,StringBuilder reporte) {
        String mensaje;
        Double ED = this.efectividadDisparo();
        Double VA = this.PD() * ED;
        double danio=((((VA*ED)-enemigo.valorDefensa())/500)*100)*1.05;
        if(danio <0){
            danio=0.0;
        }
        int salud=enemigo.getSalud()-(int)danio;
        enemigo.setSalud(salud);
        if  (danio==0.0){
            mensaje="Elfo "+this.nombre+" ataca y falla al querer hacerle daño a "+enemigo.getNombre();
        }else {
            mensaje="Elfo "+this.nombre+" ataca y causa "+(int)danio+" de daño a " +enemigo.getNombre();
            if (enemigo.getSalud()<=0){
                mensaje+=" haciendo que muera";
            }else {
                mensaje+=" dejandolo a "+enemigo.getSalud()+" de salud";
            }
        }
        reporte.append(mensaje).append("\n");
        System.out.println(mensaje);
    }

    @Override
    public String toString() {
        return"\n-------------------------------\n" +
                "   Nombre: " + nombre + "\n" +
                "   Raza: " + "Elfo"+ "\n" +
                "   Apodo: " + apodo + "\n" +
                "   Nacimiento: " + fecha_de_nacimiento + "\n" +
                "   Edad: " + edad + "\n" +
                "   velocidad: " + velocidad + "\n" +
                "   destreza: " + destreza + "\n" +
                "   fuerza: " + fuerza + "\n" +
                "   nivel: " + nivel + "\n" +
                "   armadura: " + armadura + "\n" +
                "   Salud: " + salud + "\n" +
                "-------------------------------";
    }
}
