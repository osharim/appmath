package com.example.appmath;
 
import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

	private EditText master;
	private operate operation = new operate() ;
	private ArrayList data; 
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		  master = (EditText)findViewById(R.id.master);
		  data = new ArrayList(2);

 
 
		 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	// operar
	/*-----------------------------------------------------------------*/
	public void sumar(View view){
		storeData(getData());
		data.add(1,3);
		
		master.setText("");
		
	}
	/*-----------------------------------------------------------------*/
	public void restar(View view){
		
		storeData(getData());
		data.add(1,2);
		
		master.setText(""); 
		
	}
	/*-----------------------------------------------------------------*/
	public void dividir(View view){ 
		
		storeData(getData());
		data.add(1,1);
		
		master.setText("");
		
	}
	/*-----------------------------------------------------------------*/
	public void multiplicar(View view){
		
		storeData(getData());
		data.add(1,0);
		
		master.setText("");
	}
	/*-----------------------------------------------------------------*/
	public int  getData(){
	
	 
		return Integer.parseInt(master.getText().toString());
 
	}
	/*-----------------------------------------------------------------*/
	
	
	public void storeData(int value){
		
		data.add(0,value);
	
 
	}
	/*-----------------------------------------------------------------*/
	
	
	public void responseData(int value){
	 
		master.setText(String.valueOf(value));
 
	}
	/*-----------------------------------------------------------------*/
	
	public  int result( View view){ 
		 
		if ( data.size() < 2 && master.getText().toString() == null){
			
			 AlertDialog.Builder builder = new AlertDialog.Builder(this);
		        builder.setTitle("Importante");
		        builder.setMessage("Hay "+data.size()+" digitos, Debes Ingresar al menos 2 digitos");
		        builder.setPositiveButton("Entendio , soy tronco",null);
		        builder.create();
		        builder.show(); 
 
		}else{
			
			switch(Integer.parseInt( String.valueOf(data.get(1)))){
			
			case 0 : {
				
				int response = Integer.parseInt( String.valueOf(data.get(0))) * getData();
				 
				responseData(response);
				
				storeData( response );
				
				
			}break;
			
		case 1 : {
			int response = Integer.parseInt( String.valueOf(data.get(0))) / getData();
			 
			responseData(response);
			
			storeData( response );
			
				
			}break;
		case 2 : {
			int response = Integer.parseInt( String.valueOf(data.get(0))) - getData();
			 
			responseData(response);
			
			storeData( response );
			
			
		}break;
		case 3 : {
			int response = Integer.parseInt( String.valueOf(data.get(0))) + getData();
			 
			responseData(response);
			
			storeData( response );
			
			
		}break;
			
			}
			
			
		
			
		}
		
	
		
		
		
		return 1;
	
	
	
	}
	
	
}
