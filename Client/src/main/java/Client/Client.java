package Client;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

// Client class
public class Client
{
    InetAddress ip;
    Socket s;
    int id;

    public Socket getSocket()
    {
        return s;
    }
    public void setSocket(Socket socket){
        s = socket;

    }
    public Client(InetAddress ip) {
        this.ip = ip;
    }

    public InetAddress getIp() {
        return ip;
    }

    public void setIp(InetAddress ip) {
        this.ip = ip;
    }

    /*public connection OpenConnection(int socket){
        connection con = new connection();
        try{
            s = new Socket(ip, socket);
            con.setS(s);
            DataInputStream dis = new DataInputStream(s.getInputStream());
            con.setInput(dis);
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());
            con.setOutput(dos);
        }catch (Exception e){
            con.setE(e);
        }
        return con;
    }*/

    public void protocol(connection con)
    {
        try
        {
            Scanner scn = new Scanner(System.in);


            while (true)
            {
                System.out.println(con.getInput().readUTF());
                String tosend = scn.nextLine();
                con.getOutput().writeUTF(tosend);

                // If client sends exit,close this connection
                // and then break from the while loop
                if(tosend.equals("Exit"))
                {
                    System.out.println("Closing this connection : " + s);
                    s.close();
                    System.out.println("Connection closed");
                    break;
                }

                // printing date or time as requested by client
                String received = con.getInput().readUTF();
                System.out.println(received);
            }

            // closing resources
            scn.close();
            //dis.close();
            //dos.close();
        }catch(Exception e){

            //e.printStackTrace();
            String msg = e.getMessage();
            if(msg.equalsIgnoreCase("Connection refused: connect"))
                System.out.println("conection fail true");

        }
    }
}