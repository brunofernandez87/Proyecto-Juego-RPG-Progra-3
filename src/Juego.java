import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Juego {
    protected List<Personaje> jugador1 = new ArrayList<>();
    protected List<Personaje> jugador2 = new ArrayList<>();
    public void Menu(){
        int opcion=0;
        Scanner scanner = new Scanner(System.in);
        do{
        System.out.println("Bienvenido al menu:");
        System.out.println("1 jugar");
        System.out.println("2 ver partidas anteriores");
        System.out.println("3 como jugar");
        System.out.println("0 salir");
        System.out.println("Ingrese una opcion");
            if (scanner.hasNextInt()) {
                opcion = scanner.nextInt();
                scanner.nextLine();
                opciones(opcion, scanner);
            } else {
                System.out.println("Por favor ingrese un numero valido.");
                scanner.next();
            }
        }while(opcion != 0);
        scanner.close();
    }
    public void opciones(int opcion,Scanner scanner){
            if (opcion != 0){
                switch (opcion){
                    case 1:
                        jugador1.clear();
                        jugador2.clear();
                        System.out.println("¿Desea crear los personajes usted?");
                        String opcion2= scanner.nextLine();
                        if (opcion2.equals("si")){
                            crearPersonajes(1, scanner);
                            crearPersonajes(2, scanner);
                        }
                        else{
                            crearPersonajesRandom(1);
                            crearPersonajesRandom(2);
                        }
                        System.out.println("Esto son los personajes del jugador 1");
                        Recorrer_personajes(jugador1);
                        System.out.println("Estos son los personajes del jugador 2");
                        Recorrer_personajes(jugador2);
                        Partida();
                        break;
                    case 2:
                        System.out.println("Cargando partidas anteriores");
                        break;
                    case 3:
                        System.out.println("Las reglas del juego son:");
                        break;
                    default:
                        System.out.println("Opcion no valida intente nuevamente");
                        break;
                }
            }
            else {
                System.out.println("Saliendo del juego");
            }


    }
    //comprobar que no todo este al maximo nadie es dios
    //tirar un excepcion en caso de que todo este al maximo
    //usar excepcions en caso de superar el limite de rango de edad,velocidad,etc..
    // Sistema de puntos para crear personajes o limite de 2 stats al maximo
    private void crearPersonajes(int jugador, Scanner scanner){
        int i=0;
       while (i < 3){
           System.out.println("Creando el personaje numero "+(i+1)+"para el jugador "+jugador);
            Personaje personaje=null;
           try {
            System.out.println("creando el personaje"+i);
            System.out.println("Escriba su nombre");
            String nombre= scanner.nextLine();
            System.out.println("Escriba su apodo");
            String apodo=scanner.nextLine();
            System.out.println("Escriba su fecha de nacimiento");
            String nacimiento= scanner.nextLine();
            System.out.println("Escriba su edad");
            System.out.println("Entre 0 y 300");
            int edad= Integer.parseInt(scanner.nextLine());
            System.out.println("Escriba su velocidad");
            System.out.println("Min 1 y Maximo 10");
            int velocidad = Integer.parseInt(scanner.nextLine());
            System.out.println("Escriba su destreza");
            System.out.println("Min 1 y Maximo 5");
            int destreza = Integer.parseInt(scanner.nextLine());
            System.out.println("Escriba su fuerza");
            System.out.println("Min 1 y Maximo 10");
            int fuerza =Integer.parseInt(scanner.nextLine());
            System.out.println("Escriba su nivel");
            System.out.println("Min 1 y Maximo 10");
            int nivel= Integer.parseInt(scanner.nextLine());
            System.out.println("Escriba su armadura");
            System.out.println("Min 1 y Maximo 10");
            int armadura=Integer.parseInt(scanner.nextLine());
            System.out.println("Eliga una raza:");
            System.out.println("Humano, Elfo u Orco");
            String raza=scanner.nextLine();
                switch(raza.toLowerCase()) {
                    case "humano":
                        personaje = new Humano(
                                nombre,apodo,nacimiento,edad,velocidad,destreza,fuerza,nivel,armadura
                        );
                        break;
                    case "elfo":
                        personaje = new Elfo(
                                nombre,apodo,nacimiento,edad,velocidad,destreza,fuerza,nivel,armadura
                        );
                        break;
                    case"orco":
                        personaje = new Orco(
                                nombre,apodo,nacimiento,edad,velocidad,destreza,fuerza,nivel,armadura
                        );
                        break;
                    default:
                        System.out.println("No selecciono ninguna opcion");
                        continue;
                }

            }catch (Exception e){
                System.out.println(e);
            }
            if(personaje!=null){
                System.out.println("Este es su personaje");
                System.out.println(personaje.toString());
                System.out.println("Desea borrarlo y crearlo de nuevo?");
                String opcion2= scanner.nextLine();
                if (opcion2.equalsIgnoreCase("no")){
                    if (jugador==1){
                        jugador1.add(personaje);
                    }else {
                        jugador2.add(personaje);
                    }
                    i++;
                    System.out.println("Okey creando siguiente personaje");
                }else {
                    System.out.println("Creando devuelta el personaje");
                }
            }

        }
    }
    private  void crearPersonajesRandom(int jugador){
        for (int i=1; i<=3;i++){
            String nombre= "Generico";//Reemplaza cn api
            String apodo= "Generico";
            String nacimiento="8/7/2002";
            int edad= (int)(Math.random()*300)+1;
            int velocidad=(int)(Math.random()*10)+1;
            int destreza=(int)(Math.random()*5)+1;
            int fuerza=(int)(Math.random()*10)+1;
            int nivel=(int)(Math.random()*10)+1;
            int armadura=(int)(Math.random()*10)+1;
            Personaje personaje = null;
            int raza=(int)(Math.random()*3)+1;
            try{
                switch (raza){
                    case 1:
                        personaje=new Humano(nombre,apodo,
                                nacimiento,edad,velocidad,destreza,fuerza,nivel,armadura);
                        System.out.println("Creando Humano para jugador "+jugador);

                        break;
                    case 2:
                        personaje=new Elfo(nombre,apodo,
                                nacimiento,edad,velocidad,destreza,fuerza,nivel,armadura);
                        System.out.println("Creando Elfo para jugador "+jugador);

                        break;
                    case 3:
                        personaje=new Orco(nombre,apodo,
                                nacimiento,edad,velocidad,destreza,fuerza,nivel,armadura);
                        System.out.println("Creando orco para jugador "+jugador);

                        break;
                    case 4:
                        System.out.println("Hubo un error el numero es:"+raza);
                        break;

                }
                if(personaje!=null){
                    if (jugador == 1){
                        jugador1.add(personaje);
                    }else{
                        jugador2.add(personaje);
                    }
                }else {
                    i--;
                }

            }catch (Exception e){
                System.out.println(e);
                i=i-1;
            }
        }
    }
    public void Partida(){
        System.out.println("Creando Partida");
        do {
            int turnos=0;
            int tamaño1=(jugador1.size());
            int tamaño2=(jugador2.size());
            int posicion1 = (int) (Math.random() * tamaño1);
            int posicion2 = (int) (Math.random() * tamaño2);
            Personaje personaje1 = jugador1.get(posicion1);
            Personaje personaje2 = jugador2.get(posicion2);
            System.out.println("Luchador del jugador 1 es "+personaje1.getNombre()+"'"+personaje1.getApodo()+" vs "
                    +"luchador del jugador 2  "+personaje2.getNombre()+"'"+personaje2.getApodo());
            do {
                if (personaje1.getSalud()>0) {
                    personaje1.atacar(personaje2);
                }
                if (personaje2.getSalud()>0){
                    personaje2.atacar(personaje1);
                }
                turnos++;
            } while (personaje1.getSalud() > 0 && personaje2.getSalud() > 0 && turnos < 7);
            if (personaje1.getSalud() <= 0) {
                System.out.println("Murio "+ personaje1.getNombre()+" del jugador 1");
                jugador1.remove(personaje1);
            }
            if (personaje2.getSalud() <= 0) {
                System.out.println("Murio "+ personaje2.getNombre()+" del jugador 2");
                jugador2.remove(personaje2);
            }
        }while(!jugador1.isEmpty() && !jugador2.isEmpty());
        if (jugador1.isEmpty()){
            System.out.println("Jugador 2 gana");
        }else{
            System.out.println("Jugador 1 gana");
        }
    }
    public void Recorrer_personajes(List<Personaje>jugador){
        for (int i=0;i< jugador.size();i++){
            Personaje personaje=jugador.get(i);
            System.out.println("Este es el personaje numero "+ (i+1));
            System.out.println(personaje.toString());
        }
    }
}
