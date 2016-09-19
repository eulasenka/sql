/**
 * @author Eduard Ulasenka, 273173
 */

import java.awt.EventQueue;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Work extends JFrame{
	
	private static final long serialVersionUID = 1L;
	JLabel JL_order_id,JL_tourist_id,JL_order_date,JL_amount, JL_table, JL_table2, JL_table3;
	JTextField JT_order_id,JT_tourist_id,JT_order_date,JT_amount;
	JButton btn_insert,btn_update,btn_delete, btn_show_o, btn_show_t, btn_func1, btn_func2;
	public Work(){
		super("DataBaseApp");
     
     JL_order_id = new JLabel("Order_ID:");
     JL_tourist_id = new JLabel("Tourist_ID:");
     JL_order_date = new JLabel("Order_Date:");
     JL_amount = new JLabel("Amount:");
     JL_table = new JLabel("Ins/del/upd data in _Order table:");
     JL_table2 = new JLabel("Show tables:");
     JL_table3 = new JLabel("Functions to count smth:");
     JL_order_id.setBounds(20, 50, 100, 20);
     JL_tourist_id.setBounds(20, 80, 100, 20);
     JL_order_date.setBounds(20, 110, 100, 20);
     JL_amount.setBounds(20, 140, 100, 20);
     JL_table.setBounds(20, 20, 200, 20);
     JL_table2.setBounds(20, 240, 200, 20);
     JL_table3.setBounds(20, 340, 200, 20);
     
     JT_order_id = new JTextField(20);
     JT_tourist_id = new JTextField(20);
     JT_order_date = new JTextField(20);
     JT_amount = new JTextField(20);
     JT_order_id.setBounds(130,50,150,20);
     JT_tourist_id.setBounds(130, 80, 150, 20);
     JT_order_date.setBounds(130, 110, 150, 20);
     JT_amount.setBounds(130, 140, 150, 20);
     btn_insert = new JButton("Insert");
     btn_update = new JButton("Update");
     btn_delete = new JButton("Delete");
     btn_show_o = new JButton("Show Orders");
     btn_show_t = new JButton("Show Tourists");
     btn_func1 = new JButton("NoOfJakub's");
     btn_func2 = new JButton("NoOfOrders");
     
     btn_insert.setBounds(300, 80, 80, 20);
     btn_update.setBounds(300, 110, 80, 20);
     btn_delete.setBounds(300, 140, 80, 20);
     btn_show_o.setBounds(20, 270, 130, 20);
     btn_show_t.setBounds(160, 270, 130, 20);
     btn_func1.setBounds(20, 370, 130, 20);
     btn_func2.setBounds(160, 370, 130, 20);
     
    // JPanel contentPane;
  	JScrollPane scrollPane;
 	JTable table=new JTable();
 	//table.setBounds(20,200,400,200);

   //button insert
    btn_insert.addActionListener(new  ActionListener() {

         public void actionPerformed(ActionEvent e) {
         try{
             theQuery("insert into _Order (order_id, tourist_id, order_date, amount) values('"+JT_order_id.getText()+"','"+JT_tourist_id.getText()+"','"+JT_order_date.getText()+"',"+JT_amount.getText()+")");
         }
         catch(Exception ex){}
         }
     });
    
        //button update
        btn_update.addActionListener(new  ActionListener() {

         public void actionPerformed(ActionEvent e) {
         try{
         
           theQuery("update _Order set tourist_id = '"+JT_tourist_id.getText()+"',order_date = '"+JT_order_date.getText()+"', amount = "+JT_amount.getText()+" where order_id = "+JT_order_id.getText());
         }
         catch(Exception ex){}
         }
     });
       
         //button delete
        btn_delete.addActionListener(new  ActionListener() {

         public void actionPerformed(ActionEvent e) {
         try{
          
             theQuery("delete from _Order where order_id = "+JT_order_id.getText());
         }
         catch(Exception ex){}
         }
     });
        
        btn_show_o.addActionListener(new  ActionListener() {

            public void actionPerformed(ActionEvent e) {
            	try {

					List<Order> orders = getAllOrders();
					
					// create the model and update the "table"
					OrderTableModel model = new OrderTableModel(orders);
					table.setModel(model);
					
					for (Order temp : orders) {
						System.out.println(temp);
					}
			
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null,ex.getMessage());
				}
            }
        });
        
        btn_show_t.addActionListener(new  ActionListener() {

        	public void actionPerformed(ActionEvent e) {
            	try {

					List<Tourist> tourists = getAllTourists();
					
					// create the model and update the "table"
					TouristTableModel model = new TouristTableModel(tourists);
					table.setModel(model);
					
					for (Tourist temp : tourists) {
						System.out.println(temp);
					}
			
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null,ex.getMessage());
				}
            }
        });
        
        btn_func1.addActionListener(new  ActionListener() {

            public void actionPerformed(ActionEvent e) {
            try{
                func1();
            }
            catch(Exception ex){}
            }
        });
        btn_func2.addActionListener(new  ActionListener() {

            public void actionPerformed(ActionEvent e) {
            try{
                func2();
            }
            catch(Exception ex){}
            }
        });
     
     
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     setVisible(true);
     setLocationRelativeTo(null);
     setSize(1300,450);
     setResizable(false);
    
		JPanel panel = new JPanel();
		
		add(JL_order_id);
		add(JL_tourist_id);
		add(JL_order_date);
		add(JL_amount);
		add(JL_table);
		add(JL_table2);
		add(JL_table3);
		add(JT_order_id);
		add(JT_tourist_id);
		add(JT_order_date);
		add(JT_amount);
		add(btn_insert);
		add(btn_update);
		add(btn_delete);
		add(btn_show_o);
		add(btn_show_t);
		add(btn_func1);
		add(btn_func2);
		add(panel);
		
		scrollPane = new JScrollPane();
		panel.add(scrollPane);
		scrollPane.setViewportView(table);
 }
 

 //function to execute the insert update delete query
  public void theQuery(String query){
      Connection con = null;
      Statement st = null;
      try{
          con = DriverManager.getConnection("jdbc:mysql://localhost/bd","root","aO23022012*");
          st = con.createStatement();
          st.executeUpdate(query);
          JOptionPane.showMessageDialog(null,"Query Executed");
      }catch(Exception ex){
          JOptionPane.showMessageDialog(null,ex.getMessage());
      }
  }
  
  public void func1(){
      Connection con = null;
      Statement st = null;
      ResultSet myRs = null;
      int count = 0;
      try{
          con = DriverManager.getConnection("jdbc:mysql://localhost/bd","root","aO23022012*");
          st = con.createStatement();
          myRs = st.executeQuery("select * from _Tourist where name like 'Jakub'");
          while (myRs.next()) {
				count++;
			}
          JOptionPane.showMessageDialog(null,"NoOfTouristsWithName 'Jakub': "+count);
      }catch(Exception ex){
          JOptionPane.showMessageDialog(null,ex.getMessage());
      }
  }
  public void func2(){
	  int count = 0;
      Connection con = null;
      Statement st = null;
      ResultSet myRs = null;
      try{
          con = DriverManager.getConnection("jdbc:mysql://localhost/bd","root","aO23022012*");
          st = con.createStatement();
          myRs = st.executeQuery("select * from _Order");
          while (myRs.next()) {
				count++;
		  }
          JOptionPane.showMessageDialog(null,"NoOfOrders: "+count);
      }catch(Exception ex){
          JOptionPane.showMessageDialog(null,ex.getMessage());
      }
  }
  
  public List<Order> getAllOrders() throws Exception {
		List<Order> list = new ArrayList<>();
		
		Connection con = null;
	      Statement st = null;
	      ResultSet myRs = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/bd","root","aO23022012*");
	        st = con.createStatement();
	        myRs = st.executeQuery("select * from _Order");  
			
			while (myRs.next()) {
				Order tempOrder = convertRowToOrder(myRs);
				list.add(tempOrder);
			}

			return list;		
		}
		finally {
			myRs.close();
		}
	}
  
  public List<Tourist> getAllTourists() throws Exception {
		List<Tourist> list = new ArrayList<>();
		
		Connection con = null;
	      Statement st = null;
	      ResultSet myRs = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/bd","root","aO23022012*");
	        st = con.createStatement();
	        myRs = st.executeQuery("select * from _Tourist");  
			
			while (myRs.next()) {
				Tourist tempTourist = convertRowToTourist(myRs);
				list.add(tempTourist);
			}

			return list;		
		}
		finally {
			myRs.close();
		}
	}
  
  	private Order convertRowToOrder(ResultSet myRs) throws SQLException {
		
  		int order_id = myRs.getInt("order_id");
  		int tourist_id = myRs.getInt("tourist_id");
		String order_date = myRs.getString("order_date");
		int amount = myRs.getInt("amount");
		
		Order tempOrder = new Order(order_id, tourist_id, order_date, amount);
		
		return tempOrder;
  	} 
  	
  	private Tourist convertRowToTourist(ResultSet myRs) throws SQLException {
		
  		int tourist_id = myRs.getInt("tourist_id");
  		String name = myRs.getString("name");
		String surame = myRs.getString("surame");
		int clubcard_id = myRs.getInt("clubcard_id");
		int address_id = myRs.getInt("address_id");
		Tourist tempTourist = new Tourist(tourist_id, name, surame, clubcard_id, address_id);
		
		return tempTourist;
  	} 
 
     public static void main(String[] args){
    	 EventQueue.invokeLater(new Runnable() {
 			public void run() {
 				try {
 					new  Work();
 				} catch (Exception e) {
 					e.printStackTrace();
 				}
 			}
 		});
     }
     
     
}