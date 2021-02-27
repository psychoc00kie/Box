package platform;

import java.sql.*;
import java.util.LinkedList;

public class mainPlatform {


    public static void main(String[] args) throws SQLException {

        /*
         * Dejamos un espacio para crear el codigo del servidor y su ejecucion
         *
         * */

        // CREAMOS LAS TABLAS DE LA BASE DE DATOS

        LinkedList<client> bddClientes = new LinkedList<client>();
        LinkedList<user> bddUsuarios = new LinkedList<user>();
        LinkedList<product> bddProductos = new LinkedList<product>();
        LinkedList<bot> bddBot = new LinkedList<bot>();
        LinkedList<box> bddBox = new LinkedList<box>();
        LinkedList<shipment> bddEnvios = new LinkedList<shipment>();
        LinkedList<purchase> bddVentas = new LinkedList<purchase>();

        init(bddClientes, bddUsuarios, bddProductos, bddBot, bddBox, bddEnvios, bddVentas);

        compra(bddVentas, bddProductos, 1, 1, 3);


    }

    public static void init(LinkedList<client> bddClientes, LinkedList<user> bddUsuarios, LinkedList<product> bddProductos, LinkedList<bot> bddBot, LinkedList<box> bddBox, LinkedList<shipment> bddEnvios, LinkedList<purchase> bddVentas) throws SQLException {

        /*
        LLENAMOS LAS TABLAS CON EL CONTENIDO DE LAS BASES DE DATOS
         */
        // create our mysql database connection

        String myUrl = "jdbc:mysql://localhost/platform";

        Connection conn = DriverManager.getConnection(myUrl, "root", "root");

        // Import Products.
        try {
            // our SQL SELECT query.
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "SELECT * FROM products";

            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("Product Name");
                Double price = (rs.getDouble("Sale Price") / 100);
                int stock = rs.getInt("stock");

                product _product = new product(id, name, price, stock);
                bddProductos.add(_product);
                // print the results
                System.out.format("id: %d name: %s price: %f units in Stock: %d \n", _product.getId(), _product.getName(), _product.getPrice(), _product.getStock());
            }
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }

        // IMPORT CLIENTS

        try {
            // our SQL SELECT query.
            // if you only need a few columns, specify them by name instead of using "*"
            String query = "SELECT * FROM users";

            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java resultset
            ResultSet rs = st.executeQuery(query);

            // iterate through the java resultset
            int max_users = 1000;
            int count = 0;
            while (rs.next() && count < max_users) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String pass = rs.getString("password");
                int type = rs.getInt("type");

                user _user = new user(id, name, pass, type);
                //_user.setRandType();
                // _user.setPasw();
                /*
                 * La funcion de Rand Type y la de pass se utilizan solo para generar las primeros usuarios
                 * a modo de rellenar las tablas y por otro lado la funcion pass se puede utilizar como
                 * contraseña inicial para aquellos usuarios que no añadan contraseña, directamente ofrecer una
                 * contraseña fuerte. */

                // print the results
                System.out.format("ID: %d Name: %s Pass: %s Type: %d  \n", _user.id, _user.name, _user.password, _user.type);
                bddUsuarios.add(_user);
                count++;
            }
            st.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }

        // ELIMINAR UNA VEZ CARGADA LA TABLA
        /*
       for (int i= 0; i<bddUsuarios.size();i++) {
           try {
               // our SQL SELECT query.
               // if you only need a few columns, specify them by name instead of using "*"

               // PARA AÑADIR TIPO
               //String query = "UPDATE users SET type='" + Integer.toString(bddUsuarios.get(i).getType()) + "' WHERE id= " + Integer.toString(bddUsuarios.get(i).getId()) + ";";

              // PARA AÑADIR LA PASS
              // String query = "UPDATE users SET password='" + bddUsuarios.get(i).getPassword()+ "' WHERE id= " + Integer.toString(bddUsuarios.get(i).getId()) + ";";

               System.out.println(query);
               // create the java statement

               Statement st = conn.createStatement();

               // execute the query, and get a java resultset
               //ResultSet rs = st.executeUpdate(query);
               st.executeUpdate(query);

               st.close();
           } catch (Exception e) {
               System.err.println("Got an exception! ");
               System.err.println(e.getMessage());
           }
       }
        */

        // VISTA DE BOTS, BOX, CLIENTES , Y RESTO

        System.out.println("*******************");
        System.out.println("****CLIENTES*******");
        System.out.println("*******************");

        // Clientes
        for (int i = 0; i < bddUsuarios.size(); i++) {
            int id = bddUsuarios.get(i).getType();
            if (id == 2) {
                System.out.println(bddUsuarios.get(i).toString());
                user u = bddUsuarios.get(i);
                client aux = new client(u.id, u.name, u.password, bddClientes.size());
                bddClientes.add(aux);
            }
        }
        /*      IMPRESION DE TABLA CLIENTES CONSOLA
        for(int i = 0; i<bddClientes.size();i++)
            System.out.println(bddClientes.get(i).toString()+"\n");

         */

        System.out.println("*******************");
        System.out.println("********BOTS*******");
        System.out.println("*******************");

        // Bots
        for (int i = 0; i < bddUsuarios.size(); i++) {
            int id = bddUsuarios.get(i).getType();
            if (id == 3) {
                System.out.println(bddUsuarios.get(i).toString());
                user u = bddUsuarios.get(i);
                bot aux = new bot(u.id, u.name, u.password, u.type, bddBot.size(), 0);
                bddBot.add(aux);
            }
        }

        System.out.println("*******************");
        System.out.println("*********BOX*******");
        System.out.println("*******************");

        // BOX
        for (int i = 0; i < bddUsuarios.size(); i++) {
            int id = bddUsuarios.get(i).getType();
            if (id == 4) {
                System.out.println(bddUsuarios.get(i).toString());
                user u = bddUsuarios.get(i);
                box aux = new box(u.id, u.name, u.password, u.type, bddBot.size(), 0, 0);
                bddBox.add(aux);
            }
        }
    }

    public static void compra(LinkedList<purchase> bddVentas, LinkedList<product> bddProductos, int idProd, int idClient, int cant) {
        for (int i = 0; i < bddProductos.size(); i++) {
            if (bddProductos.get(i).getId() == idProd) {
                double total_price = bddProductos.get(i).getPrice() * cant;
                purchase compra = new purchase(bddVentas.size(), idClient, idProd, cant, total_price);
                bddVentas.add(compra);

                System.out.println(compra.toString());
            }
        }
    }
}

