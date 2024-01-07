import java.util.*;
import javax.swing.*;
import java.awt.event.*;

//To collecting user data's
class Passenger_details{
    String name;
    String dob;
    int age;
    String type;
    String gender;

    Passenger_details(String name,String dob,int age,String type,String gender){
        this.name = name;
        this.age = age;
        this.dob = dob;
        this.type = type;
        this.gender =  gender;

    }
 }

 //Creating a separate class for label movement
 class Graphics extends Thread{
    JLabel l1;
    Graphics(JLabel l1){
        this.l1 = l1;
    }
    public void run(){
        while(true){
            try{
                l1.setBounds(10,50,200,30);
                Thread.sleep(500);

                l1.setBounds(100,50,200,30);
                Thread.sleep(500);

                l1.setBounds(200,50,200,30);
                Thread.sleep(500);
                
                l1.setBounds(300,50,200,30);
                Thread.sleep(500);

                l1.setBounds(300,50,200,30);
                Thread.sleep(500);

                l1.setBounds(400,50,200,30);
                Thread.sleep(500);
                
                l1.setBounds(500,50,200,30);
                Thread.sleep(500);

            }catch(Exception e){
                System.out.println("Thread Inturrupted");
            }
        }    
    }
 }

public class ReserveMain implements ActionListener{
    JFrame f = new JFrame("INDIAN RAILWAYS");
    JLabel l1,l2,l3,l4,l5;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JTextArea a1;
    JButton b1,b2;
    JComboBox<String> c1;
    JRadioButton rb1,rb2;

    ArrayList<Passenger_details> al = new ArrayList<Passenger_details>();

    public ReserveMain(){

        //Animation of the label "BOOKING TRIN TICKETS"
        
        l1 = new JLabel("BOOKING TRAIN TICKETS");
        Graphics g = new Graphics(l1);
        f.add(l1);
        g.start();
        

        l2 = new JLabel("Enter your name :");
        l2.setBounds(10,100,150,30);
        t2 = new JTextField();
        t2.setBounds(200,100,150,30);
        l3 = new JLabel("Enter your DOB :");
        l3.setBounds(10,150,150,30);
        t3 = new JTextField("");
        t3.setBounds(200,150,150,30);
        t3.addActionListener(this);
        l4 = new JLabel("Enter age :");
        l4.setBounds(10,200,150,30);
        t4 = new JTextField();
        t4.setBounds(200,200,150,30);
        f.add(l2); f.add(l3); f.add(l4);
        f.add(t2); f.add(t3); f.add(t4);

        rb1 = new JRadioButton("MALE");
        rb2 = new JRadioButton("FEMALE");
        ButtonGroup bg = new ButtonGroup();
        bg.add(rb1); bg.add(rb2);

        rb1.setBounds(10,300,80,30);
        rb2.setBounds(100,300,80,30);
        f.add(rb1); f.add(rb2);
        t6 = new JTextField();
        t6.setBounds(200,300,100,30);
        f.add(t6);
        rb1.addActionListener(this);
        rb2.addActionListener(this);

        t7 = new JTextField("search");
        t7.setBounds(200,350,100,30);
        f.add(t7);
        
        a1 = new JTextArea();
        JScrollPane j = new JScrollPane(a1,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        j.setBounds(400,100,200,180);
        f.add(j);
        
        b1 = new JButton("SUBMIT");
        b1.setBounds(400,300,200,30);
        f.add(b1);
        b1.addActionListener(this);

        b2 = new JButton("SEARCH");
        b2.setBounds(400,350,200,30);
        f.add(b2);
        b2.addActionListener(this);


        //CREATING A COMBO BOX FOR SHOWING THE BERTH TYPE
        String berth[] ={"Select berth type","UPPER BERTH","MIDDLE BERTH","LOWER BERTH"}; 
        c1 = new JComboBox<String>(berth);
        c1.setBounds(10,250,150,30);
        t5 = new JTextField();
        t5.setBounds(200,250,150,30);
        f.add(c1); f.add(t5);
        c1.addActionListener(this);


        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(800,800);
        f.setLayout(null);
        f.setVisible(true);
        
    }
    public void addpassenger(String a, String b,int c, String d,String e){
        al.add(new Passenger_details(a, b, c, d,e));
    }

    //THIS METHOOD IS USED TO SEARCHING THE PASSENGER
    public void search(String s){
        String x="";
        for(Passenger_details d : al){
        if(d.name.equals(s)){
                x+="\nNAME :"+d.name;
                x+="\nDOB :"+d.dob;
                x+="\nAGE :"+d.age;
                x+="\nGENDER :"+d.gender;
                x+="\nBERTH TYPE :"+d.type;
                //display(); 
                //IF WE USE DISPLAY METHOOD IT WILL SHOW THE ENTIRE ARRAYLIST
            }
            else a1.setText("NOT FOUND");
        }
        a1.setText(x);
        t7.setText("");
    }
    

    public void display(){
        String x="";
        //USING FO EACH LOOP TO DILAPY THE DETAILS ONE BY ONE THE ON ARRAY LIST
        for(Passenger_details d:al){
            x+="\nNAME : "+d.name;
            x+="\nDOB : "+d.dob;
            //TO CHECK IF THE AGE IS ENTERED CORRECTLY AND COMPARED TO DOB
            try {
                int year = 2023;
                String parts[] = d.dob.split("/");
                if (parts.length == 3) {
                    int birthYear = Integer.parseInt(parts[2]);
    
                    int calculatedAge = year - birthYear;
                    System.out.println(birthYear);
                    System.out.println(calculatedAge);
                    System.out.println(d.age);
                    if (calculatedAge != d.age) {
                        x+=("Age mismatch error");
                        throw new Exception("Age is entered incorrectly");
                    }
                }
            } catch (Exception e) {
               a1.setText(e.getMessage()); 
            }
            //CHECKING THE AGE FOR GIVING ADDITIONAL HELP
            x+="\nAGE :"+d.age;
            if(d.age>=60){
                x+="  YOU'RE A SENIOR CITIZEN\nCONTACT 108108\nIF ANY HELP IS NEEDED";
            }
            x+="\nGender :"+d.gender;
            x+="\nBerth Type :"+d.type;
            x+="\nNext passenger\n";
        }
        //PASSING THE STRING TO TEXT AREA
        a1.setText(x);
    }

    public void actionPerformed(ActionEvent ae){
        try{

            boolean s1 = rb1.isSelected();
            boolean s2 = rb2.isSelected();
            if(s1) t6.setText("Male");
            if(s2) t6.setText("Female");

            //C1 IS COMBO BOX OBJECT STORING SELECTED ITEM IN S AND PASSED TO TEXTFIELD
            if(ae.getSource()==c1){
                String s = c1.getSelectedItem().toString();
                
                t5.setText(s);
            }

            //B1 TO ADD THE PASSENGER
            if(ae.getSource()==b1){
                if(t2.getText().isEmpty()||t2.getText().isEmpty()||t2.getText().isEmpty()||t4.getText().isEmpty()||t5.getText().isEmpty())
                    throw new Exception("Please fill the details ");
                String a =t2.getText();//NAME
                String b = t3.getText();//DOB
                int c = Integer.parseInt(t4.getText());//AGE
                String d = t5.getText();//BERTH TYPE
                String e = t6.getText();//GENDER
                addpassenger(a,b,c,d,e);//CALLING ADDPASSENGER METHOOD TO STORE THE DETAILS IN ARRAYLIST
                display();//CALLING DISPLAY METHOOD TO DISPLAY THE STORED ELEMENTS
            }
        
            //B2 TO SEARCH THE PASSENGER
            if(ae.getSource()==b2){
                if(t7.getText().isEmpty())
                    throw new Exception("Pleas enter name for searching");
                search(t7.getText());
            }
        }catch(Exception e){
            //a1.setText(e.getMessage());
            JOptionPane.showMessageDialog(f, e.getMessage(),"ERROR 404",JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        new ReserveMain();    
    }
}