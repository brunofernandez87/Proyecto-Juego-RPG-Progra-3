public abstract class Personaje implements Atacar {
    protected  String nombre;
    protected Integer salud=100;
    protected String apodo;
    protected String fecha_de_nacimiento;
    protected Integer edad;
    protected Integer velocidad;
    protected Integer destreza;
    protected Integer fuerza;
    protected Integer nivel;
    protected Integer armadura;
    //constructor
    public Personaje(String nombre,
                     String apodo, String fecha_de_nacimiento, Integer edad,
                     Integer velocidad, Integer destreza, Integer fuerza,
                     Integer nivel, Integer armadura) throws Exception {
        this.nombre = nombre;
        this.apodo = apodo;
        this.fecha_de_nacimiento = fecha_de_nacimiento;
        if (Comprobar(edad, velocidad, destreza, fuerza, nivel, armadura)){
            this.edad =edad;
            this.velocidad = velocidad;
            this.destreza = destreza;
            this.fuerza = fuerza;
            this.nivel = nivel;
            this.armadura = armadura;
        }

    }


    public boolean Comprobar (Integer edad,Integer velocidad,Integer destreza, Integer fuerza,
                              Integer nivel, Integer armadura) throws Exception {
        if (( Rango(edad,0,300)||
                Rango(velocidad, 0, 10) ||
                Rango(destreza, 0, 5) ||
                Rango(fuerza, 0, 10) ||
                Rango(nivel, 0, 10) ||
                Rango(armadura, 0, 10))){
            throw new Exception("Una de las variables supera los parametros establecidos");
        }else{
            return true;
        }
    }
    private boolean Rango(Integer valor,Integer min,Integer max){
        if (valor<min || valor>max){
            return true;
        }else{
            return false;
        }
    }

    public Integer getSalud() {
        return salud;
    }

    public String getApodo() {
        return apodo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setSalud(Integer salud) {
        this.salud = salud;
    }

    @Override
    public Integer PD() {
        return destreza*fuerza*nivel;
    }

    @Override
    public Double efectividadDisparo() {
        int valor= (int) (Math.random() * 100)+1;
        double porcentaje=valor;
        return porcentaje/100;
    }

    @Override
    public Integer valorDefensa() {
        return armadura*velocidad;
    }

    @Override
    public Double valorAtaque() {
        return PD()*efectividadDisparo();
    }
    public abstract void atacar(Personaje enemigo);
}
