
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
        String division=fecha_de_nacimiento.split("/")[2];
        int anio=Integer.parseInt(division);
        if (Comprobar(edad, velocidad, destreza, fuerza, nivel, armadura,anio)){
            this.edad =edad;
            this.velocidad = velocidad;
            this.destreza = destreza;
            this.fuerza = fuerza;
            this.nivel = nivel;
            this.armadura = armadura;
            this.fecha_de_nacimiento = fecha_de_nacimiento;
        }
        ComprobarMaximo();

    }


    public boolean Comprobar (Integer edad,Integer velocidad,Integer destreza, Integer fuerza,
                              Integer nivel, Integer armadura,Integer anioNacimiento) throws Exception {
        if (( Rango(edad, 300)||
                Rango(velocidad, 10) ||
                Rango(destreza, 5) ||
                Rango(fuerza, 10) ||
                Rango(nivel, 10) ||
                Rango(armadura, 10)||
                Rango(anioNacimiento, 1200))){
            throw new Exception("Una de las variables supera los parametros establecidos");
        }else{
            return true;
        }
    }
    private boolean Rango(Integer valor, Integer max){
        return valor < (Integer) 0 || valor > max;
    }
    private void ComprobarMaximo() throws Exception {
        int maximo=0;
        if (velocidad == 10) maximo++;
        if (fuerza == 10) maximo++;
        if (nivel == 10) maximo++;
        if (armadura == 10) maximo++;
        if (destreza == 5) maximo++;
        if (maximo>=3){
           throw new Exception("Pusiste mas de 2 variables al maximo");
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

    public Integer getFuerza() {
        return fuerza;
    }

    public void setFuerza(Integer fuerza) {
        this.fuerza = fuerza;
    }

    public Integer getArmadura() {
        return armadura;
    }

    public void setArmadura(Integer armadura) {
        this.armadura = armadura;
    }

    public Integer getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(Integer velocidad) {
        this.velocidad = velocidad;
    }

    public Integer getDestreza() {
        return destreza;
    }

    public void setDestreza(Integer destreza) {
        this.destreza = destreza;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }

    @Override
    public Integer PD() {
        return destreza*fuerza*nivel;
    }

    @Override
    public Double efectividadDisparo() {
        int valor= (int) (Math.random() * 100)+1;
        return (double) valor /100;
    }

    @Override
    public Integer valorDefensa() {
        return armadura*velocidad;
    }

    @Override
    public Double valorAtaque() {
        return PD()*efectividadDisparo();
    }
    public abstract void atacar(Personaje enemigo,StringBuilder reporte);
}
