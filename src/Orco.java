public class Orco extends Personaje{

    public Orco(String nombre, String apodo, String fecha_de_nacimiento, Integer edad, Integer velocidad, Integer destreza, Integer fuerza, Integer nivel, Integer armadura) throws Exception {
        super(nombre, apodo, fecha_de_nacimiento, edad, velocidad, destreza, fuerza, nivel, armadura);
    }

    @Override
    public void atacar(Personaje enemigo,StringBuilder reporte) {
        double danio= ((((valorAtaque()*efectividadDisparo())-enemigo.valorDefensa())/500)*100)*1.1;
        if(danio <0){
            danio=0.0;
        }
        int salud=enemigo.getSalud()-(int)danio;
        enemigo.setSalud(salud);
        String mensaje="Orco "+this.nombre+" ataca y causa "+(int)danio+" de daño a "+enemigo.getNombre();
        reporte.append(mensaje).append("\n");
        System.out.println(mensaje);
    }

    @Override
    public String toString() {
        return "Orco {" +
                "nombre='" + nombre + '\'' +
                ", apodo='" + apodo + '\'' +
                ", salud=" + salud +
                ", edad=" + edad +
                ", fuerza=" + fuerza +
                ", nivel=" + nivel +
                ", armadura=" + armadura +
                '}';
    }
}
