package platform;

import java.util.Random;

public class user {

    int id;
    String name;
    String password;
    int type;           // 0 Admin company usser, 1 company regular user , 2 client , 3 bot, 4 box

    public user(int id, String name, String password, int type) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.type = type;
    }

    public void setPasw(){
            int leftLimit = 48; // numeral '0'
            int rightLimit = 122; // letter 'z'
            int targetStringLength = 10;
            Random random = new Random();

            String generatedString = random.ints(leftLimit, rightLimit + 1)
                    .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                    .limit(targetStringLength)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();

            System.out.println("The password: "+generatedString+" has ben assigned to user: "+id+"\n");
            password = generatedString;
    }

    public void setRandType(){

        //  GENERAMOS TYPOS ADICIONALES PARA USUARIOS DE PRUEBA
        Random rand = new Random(); //instance of random class
        int upperbound = 5;
        //generate random values from 0-4
        int int_random = rand.nextInt(upperbound);
        type = int_random;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", name=" + name +
                ", password=" + password +
                ", type=" + type +
                '}';
    }
}
