import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Buffs {
    private final String [] buffs={"Mas salud","Mas armadura","Revivir al primer personaje que murio","Mas fuerza"};
    public void AplicarBuffs(Personaje personaje,
                             List<Personaje> jugador, List<Personaje> muertosJugador, Scanner scanner) {
        List<String> buffsObtenidos=new ArrayList<>();
        do{
            int numero=(int)(Math.random()*buffs.length);
            String posibleBuff=buffs[numero];
            if (posibleBuff.equals("Revivir al primer personaje que murio") && muertosJugador.isEmpty()) {
                continue;
            }
            if(!buffsObtenidos.contains(posibleBuff) ){
                buffsObtenidos.add(posibleBuff);
            }

        }while(buffsObtenidos.size()<3);
        String buff="";
        System.out.println("Tu personaje actualmente termino asi: "+personaje);
        System.out.println("Selecciona uno de los siguientes buffs: ");
        System.out.println("Opcion 1"+buffsObtenidos.get(0));
        System.out.println("Opcion 2"+buffsObtenidos.get(1));
        System.out.println("Opcion 3"+buffsObtenidos.get(2));
        int opcion;
        try{
            opcion = Integer.parseInt(scanner.nextLine());
        }catch(Exception e){
            opcion = 1;
            System.out.println("Entrada inválida, se seleccionó opción 1 por defecto");
        }

        switch(opcion){
            case 1:
                buff=buffsObtenidos.get(0);
                break;
            case 2:
                buff=buffsObtenidos.get(1);
                break;
            case 3:
                buff=buffsObtenidos.get(2);
                break;
        }
        switch(buff){
            case "Mas salud":
                personaje.setSalud(personaje.getSalud()+30);
                System.out.println("Se aumento la salud en 30");
                break;
            case "Mas armadura":
                personaje.setArmadura(personaje.getArmadura()+5);
                System.out.println("Se aumento la armadura en 5");
                break;
            case "Revivir al primer personaje que murio":
                if (muertosJugador.isEmpty()){
                    System.out.println("No tienes personajes muertos");
                }else{
                    Personaje muerto=muertosJugador.get(0);
                    muerto.setSalud(muerto.getSalud()+50);
                    jugador.add(muerto);
                    muertosJugador.remove(muerto);
                    System.out.println("Se revivio a "+muerto.getNombre()+"'"+muerto.getApodo()+"con 50 de vida");
                }
                break;
            case "Mas fuerza":
                personaje.setFuerza(personaje.getFuerza()+5);
                System.out.println("Se aumento la fuerza de tu personaje en 5");
                break;

        }

    }
}
