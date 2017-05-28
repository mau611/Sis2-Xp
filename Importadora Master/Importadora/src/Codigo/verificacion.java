package Codigo;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class verificacion{
    String nombre;
    String direccion;
    String ci;
    String telefono;
    String ID;
    String contrasenia;
    Calendar fecha = new GregorianCalendar();
    public verificacion(){
        nombre="";
        direccion="";
        String ci="";
        String ID="";
        String contrasenia="";   
    }
    public String getNombre(){
        return nombre;
    }
    public String getDireccion(){
        return direccion;
    }
    public String getCI(){
        return ci;
    }
    public String getTelefono(){
        return telefono;
    }
    public String getID(){
        return ci;
    }
    public String getContrasenia(){
        return contrasenia;
    }
    public void setNombre(String nombre){
         this.nombre=nombre;
    }
    public void setDireccion(String direccion){
        this.direccion=direccion;
    }
    public void setCI(String ci){
        this.ci=ci;    }
    public void setTelefono(String telefono){
        this.telefono=telefono;
    }
    public void setID(String id){
        ID=id;
    }
    public void setContrasenia(String password){
        contrasenia=password;
    }
    public boolean validarNombre(String texto){
        int contador=0;
        boolean bandera=false;
        for(int i=0;i<texto.length();i++){
         if(letras(texto.charAt(i))==true){
          contador++;
         }
        }
        if(contador==texto.length()){
            bandera=true;
        }else{
            bandera=false;
        }
        return bandera;
    }
    public boolean validarTextoyNumeros(String texto){
        int contador=0;
        boolean bandera=false;
        for(int i=0;i<texto.length();i++){
         if(letrasyNumeros(texto.charAt(i))==true){
          contador++;
         }
        }
        if(contador==texto.length()){
            bandera=true;
        }else{
            bandera=false;
        }
        return bandera;
    }
    public boolean letras(char caracter){
        boolean bandera=false;
        if(' '==caracter || ' '==caracter){bandera=true;}
        if('a'==caracter || 'A'==caracter){bandera=true;}
        if('b'==caracter || 'B'==caracter){bandera=true;}
        if('c'==caracter || 'C'==caracter){bandera=true;}
        if('d'==caracter || 'D'==caracter){bandera=true;}
        if('e'==caracter || 'E'==caracter){bandera=true;}
        if('f'==caracter || 'F'==caracter){bandera=true;}
        if('g'==caracter || 'G'==caracter){bandera=true;}
        if('h'==caracter || 'H'==caracter){bandera=true;}
        if('i'==caracter || 'I'==caracter){bandera=true;}
        if('j'==caracter || 'J'==caracter){bandera=true;}
        if('k'==caracter || 'K'==caracter){bandera=true;}
        if('l'==caracter || 'L'==caracter){bandera=true;}
        if('m'==caracter || 'M'==caracter){bandera=true;}
        if('n'==caracter || 'N'==caracter){bandera=true;}
        if('o'==caracter || 'O'==caracter){bandera=true;}
        if('p'==caracter || 'P'==caracter){bandera=true;}
        if('q'==caracter || 'Q'==caracter){bandera=true;}
        if('r'==caracter || 'R'==caracter){bandera=true;}
        if('s'==caracter || 'S'==caracter){bandera=true;}
        if('t'==caracter || 'T'==caracter){bandera=true;}
        if('u'==caracter || 'U'==caracter){bandera=true;}
        if('v'==caracter || 'V'==caracter){bandera=true;}
        if('w'==caracter || 'W'==caracter){bandera=true;}
        if('x'==caracter || 'X'==caracter){bandera=true;}
        if('y'==caracter || 'Y'==caracter){bandera=true;}
        if('z'==caracter || 'Z'==caracter){bandera=true;}
        return bandera;
    }
       public boolean numeros(char caracter){
        boolean bandera=false;
        if('0'==caracter){bandera=true;}
        if('1'==caracter){bandera=true;}
        if('2'==caracter){bandera=true;}
        if('3'==caracter){bandera=true;}
        if('4'==caracter){bandera=true;}
        if('5'==caracter){bandera=true;}
        if('6'==caracter){bandera=true;}
        if('7'==caracter){bandera=true;}
        if('8'==caracter){bandera=true;}
        if('9'==caracter){bandera=true;}
        return bandera;
    }
    public boolean validarTelyCi(String texto){
        int contador=0;
        boolean bandera=false;
        for(int i=0;i<texto.length();i++){
         if(numeros(texto.charAt(i))==true){
          contador++;
         }
        }
        if(contador==texto.length()){
            bandera=true;
        }else{
            bandera=false;
        }
        return bandera;
    }
     public boolean letrasyNumeros(char caracter){
        boolean bandera=false;
        if(' '==caracter || ' '==caracter){bandera=true;}
        if('a'==caracter || 'A'==caracter){bandera=true;}
        if('b'==caracter || 'B'==caracter){bandera=true;}
        if('c'==caracter || 'C'==caracter){bandera=true;}
        if('d'==caracter || 'D'==caracter){bandera=true;}
        if('e'==caracter || 'E'==caracter){bandera=true;}
        if('f'==caracter || 'F'==caracter){bandera=true;}
        if('g'==caracter || 'G'==caracter){bandera=true;}
        if('h'==caracter || 'H'==caracter){bandera=true;}
        if('i'==caracter || 'I'==caracter){bandera=true;}
        if('j'==caracter || 'J'==caracter){bandera=true;}
        if('k'==caracter || 'K'==caracter){bandera=true;}
        if('l'==caracter || 'L'==caracter){bandera=true;}
        if('m'==caracter || 'M'==caracter){bandera=true;}
        if('n'==caracter || 'N'==caracter){bandera=true;}
        if('o'==caracter || 'O'==caracter){bandera=true;}
        if('p'==caracter || 'P'==caracter){bandera=true;}
        if('q'==caracter || 'Q'==caracter){bandera=true;}
        if('r'==caracter || 'R'==caracter){bandera=true;}
        if('s'==caracter || 'S'==caracter){bandera=true;}
        if('t'==caracter || 'T'==caracter){bandera=true;}
        if('u'==caracter || 'U'==caracter){bandera=true;}
        if('v'==caracter || 'V'==caracter){bandera=true;}
        if('w'==caracter || 'W'==caracter){bandera=true;}
        if('x'==caracter || 'X'==caracter){bandera=true;}
        if('y'==caracter || 'Y'==caracter){bandera=true;}
        if('z'==caracter || 'Z'==caracter){bandera=true;}
        if('0'==caracter){bandera=true;}
        if('1'==caracter){bandera=true;}
        if('2'==caracter){bandera=true;}
        if('3'==caracter){bandera=true;}
        if('4'==caracter){bandera=true;}
        if('5'==caracter){bandera=true;}
        if('6'==caracter){bandera=true;}
        if('7'==caracter){bandera=true;}
        if('8'==caracter){bandera=true;}
        if('9'==caracter){bandera=true;}
        return bandera;
     }
     public String fechaGuardar(){
         String año=Integer.toString(fecha.get(Calendar.YEAR));
         String mes=Integer.toString( fecha.get(Calendar.MONTH)+1);
         String dia=Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
         String fecha;
        if(mes.length()==1&&dia.length()==1){
            fecha=0+dia+"-"+0+mes+"-"+año;
        }else{
            if(mes.length()==1){
                fecha=año+"-"+0+mes+"-"+dia;
            }else{
                if(dia.length()==1){
                 fecha=año+"-"+mes+"-"+0+dia;
                }else{
                 fecha=año+"-"+mes+"-"+dia;
                }
            }
        }
        return fecha;
    }
    public String fechaMostrar(){
         String año=Integer.toString(fecha.get(Calendar.YEAR));
         String mes=Integer.toString( fecha.get(Calendar.MONTH)+1);
         String dia=Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
         String fecha;
        if(mes.length()==1&&dia.length()==1){
            fecha=0+dia+"/"+0+mes+"/"+año;
        }else{
            if(mes.length()==1){
                fecha=dia+"/"+0+mes+"/"+año;
            }else{
                if(dia.length()==1){
                 fecha=0+dia+"/"+mes+"/"+año;
                }else{
                 fecha=dia+"/"+mes+"/"+año;
                }
            }
        }
        return fecha;
    }     
}