
import java.awt.*;
import java.util.Date;

import javax.swing.*;

public class MathWithin100 extends JFrame
{
	public MathWithin100(){
		init();
		setSize( 400,680 );
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible( true );
	}
         Timer timer;
	public void init()
	{
	
		//{{INIT_CONTROLS
		setLayout(null);
		setSize(400,400);
		timer=new Timer(1000,(e)->{
			setTitle(new java.util.Date().toString());
		});
		 timer.start();
		  
		 setLayout(null);			 
			btnNew.setLabel("Question");
			getContentPane().add(btnNew);
			btnNew.setBackground(java.awt.Color.lightGray);
			btnNew.setBounds(36,96,98,26);
			btnJudge.setLabel("Mark");
			getContentPane().add(btnJudge);
			btnJudge.setBackground(java.awt.Color.lightGray);
			btnJudge.setBounds(216,96,94,25);
			lblA.setText("1");
			getContentPane().add(lblA);
			lblA.setFont(new Font("Dialog", Font.PLAIN, 26));
			lblA.setBounds(36,24,42,36);
			lblOp.setText("+");
			getContentPane().add(lblOp);
			lblOp.setFont(new Font("Dialog", Font.PLAIN, 24));
			lblOp.setBounds(72,24,36,36);
			lblB.setText("1");
			getContentPane().add(lblB);
			lblB.setFont(new Font("Dialog", Font.PLAIN, 26));
			lblB.setBounds(108,24,42,36);
			label5.setText("=");
			getContentPane().add(label5);
			label5.setFont(new Font("Dialog", Font.PLAIN, 24));
			label5.setBounds(168,24,34,36);
			getContentPane().add(txtAnswer);
			txtAnswer.setText("2");
			txtAnswer.setFont(new Font("Dialog", Font.PLAIN, 24));
			txtAnswer.setBounds(216,24,85,42);
			listDisp.setFont(new Font("Dialog", Font.PLAIN, 16));
			getContentPane().add(listDisp);
			listDisp.setBounds(36,144,272,466);
		

		//}}
	
		//{{REGISTER_LISTENERS
		 		
		SymAction lSymAction = new SymAction();			
		  
		btnNew.addActionListener(lSymAction);		
		btnJudge.addActionListener(lSymAction);
		//}}
	}
	
	//{{DECLARE_CONTROLS
	  java.awt.Button btnNew = new java.awt.Button();
      java.awt.Button btnJudge = new java.awt.Button();
	  java.awt.Button btnStart=new java.awt.Button();
	  java.awt.Label lblA = new java.awt.Label();
	  java.awt.Label lblOp = new java.awt.Label();
	  java.awt.Label lblB = new java.awt.Label();
	  java.awt.Label label5 = new java.awt.Label();
	  java.awt.Label labelTime= new java.awt.Label();
	 
	  java.awt.TextField txtAnswer = new java.awt.TextField();
	  java.awt.List listDisp = new java.awt.List(0);
	//}}
     int count=0;
	 
	   class SymAction implements java.awt.event.ActionListener
		{
	       
		  
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			 
			Object object = event.getSource();
			 
			if (object == btnNew){
				 				 
				btnNew_ActionPerformed(event);				
				btnNew.disable(); 
				count++;		 			 
			   }
			else if (object == btnJudge){
				btnJudge_ActionPerformed(event);
			    btnNew.enable();
			}
 		   
		  }
		} 
	 
	   void btnStart_ActionPerformed(java.awt.event.ActionEvent event){
		   
		   new Timer(1000,(e)->{
				labelTime.setText(new java.util.Date().toString());
		}).start();
	   }

	   void btnNew_ActionPerformed(java.awt.event.ActionEvent event)
	  {
		 
		// to do: code goes here.
	   	     	    			
			a = (int)(Math.random()*100+1);
			b = (int)(Math.random()*100+1);
			int c = (int)(Math.random()*4);
			switch( c )
			{
			    case 0: op="+"; result=a+b; break;
			    case 1: op="-"; result=a-b; break;
			    case 2: op="*"; result=a*b;break;
			    case 3: op="/"; result=Math.round(a*1.0/b*100)/100.0;break;
			}
			lblA.setText(""+a);
			lblB.setText(""+b);
			lblOp.setText(" "+op);
			txtAnswer.setText("");
			 
			 
	}
	
	int a=1,b=1 ;  
	String op="+";
	double result=2;

	void btnJudge_ActionPerformed(java.awt.event.ActionEvent event)
	{
		String str = txtAnswer.getText();
		String disp = "" +count+"# "+ a + op + b+"="+ str +" ";
		if (str.equals("")){
			disp+= "please enter the result";
		}else{
		double d = Double.valueOf(str).doubleValue();		
		 
		   if( d == result ) disp +="right";
		   else   disp += "wrong, the result is"+" "+result;
		}
		
		    listDisp.add( disp );
	}

	public static void main(String [] args)
	{
		MathWithin100 f = new MathWithin100();
	}
		
}
	  
	  
