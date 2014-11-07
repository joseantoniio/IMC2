package com.example.indicedemasacorporal;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private static final String LOGTAG="MainActivity";
	
	private IndiceMasaCorporal imc;
	EditText editPeso;
	EditText editAltura;
	TextView textViewResultado;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		editPeso = (EditText) findViewById(R.id.editPeso);
		editPeso.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				editPeso.setBackgroundColor(Color.WHITE);
			}
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {}
			@Override
			public void afterTextChanged(Editable s) {}
		});
		editAltura = (EditText) findViewById(R.id.editAltura);
		editAltura.addTextChangedListener(new TextWatcher() {

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {}
			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				editAltura.setBackgroundColor(Color.WHITE);
			}
			@Override
			public void afterTextChanged(Editable s) {}
		});
		textViewResultado = (TextView) findViewById(R.id.textViewResultado);

	}

	/**
	 * onButtonClickCalcularIMC
	 */
	public void onButtonClickCalcularIMC(View v) {

		String peso;
		String altura;
		String resultado;
		try {

			peso = editPeso.getText().toString();
			altura = editAltura.getText().toString();

			imc = new IndiceMasaCorporal(peso, altura);
			
			resultado = "Valor IMC = " + imc.valorIndiceMasaCorporal() + " - ";
			resultado = resultado.concat(imc.clasificacionOMS());
			textViewResultado.setText(resultado);
			Log.e(LOGTAG, imc.toString());
			
		} catch (IndiceMasaCorporalException e) {
			if (e.isErrorPeso()) 
				editPeso.setBackgroundColor(Color.LTGRAY);
			if (e.isErrorAltura())
				editAltura.setBackgroundColor(Color.LTGRAY);
			Toast.makeText(getApplicationContext(), e.getMessage(), 
					Toast.LENGTH_SHORT).show();
		} catch (Exception e) {
			Log.e(LOGTAG, e.getMessage());
		}
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
