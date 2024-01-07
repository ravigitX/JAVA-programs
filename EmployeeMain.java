import java.util.*;
import javax.swing.*;
import java.awt.event.*;


class Employee{
    String name;
    int id;
   
}
class PermanentEmployee extends Employee{
    int bpay;
    int hra;
    int da;
    int pf;
    PermanentEmployee(String name,int id,int bpay,int hra,int da,int pf){
        //super(name, id);
        this.name = name;
        this.id = id;
        this.hra = hra;
        this.bpay = bpay;
        this.da = da;
        this.pf = pf;
    }
}
class TemporaryEmployee extends Employee{
    int wages;
    int worked;
    TemporaryEmployee(String name,int id,int wages,int worked){
        //super(name, id);
        this.name = name;
        this.id = id;
        this.wages = wages;
        this.worked = worked;
    }
}

public class EmployeeMain implements ActionListener{
    JFrame f = new JFrame("Employee Management");
    JTextArea a1;
    JLabel l0,l1,l2,l3,l4,l5,l6,l7,l8;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8;
    JRadioButton rb1,rb2;
    ButtonGroup bg;
    JButton b1,b2,b3;
    JScrollPane s;
    ArrayList<PermanentEmployee> pl = new ArrayList<PermanentEmployee>();
    ArrayList<TemporaryEmployee> tl = new ArrayList<TemporaryEmployee>();


    public EmployeeMain(){
    l0 = new JLabel("EMPLOYEE SALARY LIST");
    l0.setBounds(400,50,150,30);
    f.add(l0);

    rb1 = new JRadioButton("Permanent Employee");
    rb2 = new JRadioButton("Temporary Employee");
    rb1.setBounds(10,150,150,30);
    rb2.setBounds(200,150,150,30);
    f.add(rb1); f.add(rb2);
    bg = new ButtonGroup();
    bg.add(rb1); bg.add(rb2);

    rb1.addActionListener(this);
    rb2.addActionListener(this);

    l7 = new JLabel("Enter name :");
    l8 = new JLabel("Enter ID :");
    t7 = new JTextField();
    t8 =  new JTextField();
    l7.setBounds(10, 200, 100, 30);
    t7.setBounds(200,200,100,30);
    l8.setBounds(310,200,80,30);
    t8.setBounds(390,200,100,30);
    f.add(l7); f.add(l8); f.add(t7); f.add(t8);


    
    l1 = new JLabel("Enter your Basic Pay :");
    l1.setBounds(10, 250, 150, 30);
    f.add(l1);
    t1 = new JTextField();
    t1.setBounds(200,250,100,30);
    f.add(t1);
    l1.setVisible(false);
    t1.setVisible(false);
    l2 = new JLabel("Enter your HRA percentage :");
    t2 = new JTextField();
    l2.setBounds(10, 300, 180, 30);
    t2.setBounds(200, 300, 100, 30);
    f.add(l2); f.add(t2);
    l2.setVisible(false); t2.setVisible(false);
    l3 = new JLabel("Enter your DA percentage :");
    t3 = new JTextField();
    l3.setBounds(10,350,180,30);
    t3.setBounds(200, 350, 100, 30);
    f.add(l3); f.add(t3);
    l3.setVisible(false); t3.setVisible(false);
    l4 = new JLabel("Enter your PF percentage :");
    t4 = new JTextField();
    l4.setBounds(10,400,180,30);
    t4.setBounds(200,400,100,30);
    f.add(l4); f.add(t4);
    l4.setVisible(false); t4.setVisible(false);



    l5 = new JLabel("Enter your wages/hr :");
    l5.setBounds(10, 250, 150, 30);
    t5 = new JTextField();
    t5.setBounds(200, 250, 100, 30);
    f.add(l5); f.add(t5);
    l5.setVisible(false);
    t5.setVisible(false);
    l6 = new JLabel("Enter your working hours :");
    t6 = new JTextField();
    l6.setBounds(10, 300, 180, 30);
    t6.setBounds(200, 300, 180, 30);
    f.add(l6); f.add(t6);
    l6.setVisible(false);
    t6.setVisible(false);
    

    a1 = new JTextArea();
    s = new JScrollPane(a1,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    s.setBounds(500,150,200,200);
    f.add(s);
    

    b1 = new JButton("ADD");
    b2 = new JButton("DISPLAY");
    b3 = new JButton("CALCULATE SALARY");
    b1.setBounds(500,350,200,30);
    b2.setBounds(500,400,200,30);
    b3.setBounds(500,450,200,30);
    f.add(b1); f.add(b2); f.add(b3);

    b1.addActionListener(this);
    b2.addActionListener(this);
    b3.addActionListener(this);



    f.setLayout(null);
    f.setVisible(true);
    f.setSize(1000,1000);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addpermanentemployee(String a,int b,int c,int d,int e,int f){
        pl.add(new PermanentEmployee(a, d, b, e, d, f));
    }

    public void addtemporaryemployee(String a, int b, int x, int y){
        tl.add(new TemporaryEmployee(a, b, x, y));
    }


    public void display(){
        String z="";
        for(PermanentEmployee p:pl){
            z+="\nNAME :"+p.name;
            z+="\nID :"+p.id;
            z+="\nBASIC PAY :"+p.bpay;
            z+="\nHRA :"+p.hra;
            z+="\nDA :"+p.da;
            z+="\nPF :"+p.pf;
            z+="\n-----------------\n";
        }
        a1.setText(z);
    }
    public void disp(){
        String y="";
        for(TemporaryEmployee t:tl){
            y+="\nName :"+t.name;
            y+="\nID :"+t.id;
            y+="\nHourly Wages :"+t.wages;
            y+="\nHours worked :"+t.worked;
            y+="\n====================\n";
        }
        a1.setText(y);
    }
    public void calculate1(int a,int b,int c,int d){
        String z="";
        for(PermanentEmployee p :pl){
            //System.out.println(p);
            int price = a+b+c+d;
            z+="TOTAL SALARY :"+price;
        }
        a1.setText(z);
    }
    public void calculate2(int p,int q){
        String z="";
        for(TemporaryEmployee t :tl){
            //System.out.println(t);
            int price = p*q;
            z+="Total salary :"+price;
        }
        a1.setText(z);
    }

    public void actionPerformed(ActionEvent ae){

        boolean sb = rb1.isSelected();
        boolean sb1 = rb2.isSelected();

        try{
        
            if(sb){
                l1.setVisible(true);
                l2.setVisible(true);
                l3.setVisible(true);
                l4.setVisible(true);

                t1.setVisible(true);
                t2.setVisible(true);
                t3.setVisible(true);
                t4.setVisible(true);

                l5.setVisible(false);
                l6.setVisible(false);

                t5.setVisible(false);
                t6.setVisible(false);

                if(ae.getSource()==b1){
                        if(t7.getText().isEmpty()||t8.getText().isEmpty()||t1.getText().isEmpty()||t2.getText().isEmpty()||t3.getText().isEmpty()||t4.getText().isEmpty())
                            throw new Exception("Please fill details for\npermanent employee");
                    String a = t7.getText();
                    int b = Integer.parseInt(t8.getText());
                    int c = Integer.parseInt(t1.getText());
                    int d = Integer.parseInt(t2.getText());
                    int e = Integer.parseInt(t3.getText());
                    int f = Integer.parseInt(t4.getText());
                    addpermanentemployee(a, b, c, d, e, f);
                    a1.setText("Your details are added");
                }
            }
                
            
            if(sb1){
                
                l1.setVisible(false);
                l2.setVisible(false);
                l3.setVisible(false);
                l4.setVisible(false);

                t1.setVisible(false);
                t2.setVisible(false);
                t3.setVisible(false);
                t4.setVisible(false);


                l5.setVisible(true);
                l6.setVisible(true);

                t5.setVisible(true);
                t6.setVisible(true);


                if(ae.getSource()==b1){
                    if(t5.getText().isEmpty()||t6.getText().isEmpty())
                        throw new Exception("Please fill details for\ntemporary employee");
                    String a = t7.getText();
                    int b = Integer.parseInt(t8.getText());
                    int x = Integer.parseInt(t5.getText());
                    int y = Integer.parseInt(t6.getText());
                    addtemporaryemployee(a, b, x, y);
                    a1.setText("Your details are added");
                }
            }
        }catch(Exception e){
            a1.setText(e.getMessage());
        }
        if(ae.getSource()==b2){
            if(sb){
                display();
            }
            else if(sb1){
                disp();
            }
        }
        if(ae.getSource()==b3){
            if(sb){
                calculate1(Integer.parseInt(t1.getText()), Integer.parseInt(t2.getText()), Integer.parseInt(t3.getText()),Integer.parseInt(t4.getText()) );
            }
            else if(sb1){
                calculate2(Integer.parseInt(t5.getText()),Integer.parseInt(t6.getText()));
            }
        }   

    }
    public static void main(String[] args) {
        new EmployeeMain();
    }
}

