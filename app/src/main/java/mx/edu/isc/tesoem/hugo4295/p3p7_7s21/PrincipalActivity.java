package mx.edu.isc.tesoem.hugo4295.p3p7_7s21;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import Concentrado.Peticiones;
import DTO.DatosDTO;

public class PrincipalActivity extends AppCompatActivity {

    GridView gvdatos;
    List<DatosDTO> ldatos = new ArrayList<>();
    List<String> sdatos = new ArrayList<>();
    EditText txtid, txtnombre, txtedad, txtcorreo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        txtid = findViewById(R.id.txtid);
        txtnombre = findViewById(R.id.txtnombre);
        txtedad = findViewById(R.id.txtedad);
        txtcorreo = findViewById(R.id.txtcorreo);

        gvdatos = findViewById(R.id.gvDatos);
        Peticiones peticionweb = new Peticiones(this);
        peticionweb.regilla(gvdatos);
        peticionweb.CargarDatos();
        ldatos = peticionweb.getLdatos();
        sdatos = peticionweb.getSdatos();
        //peticionweb.cargarRegistroact("5");
        //peticionweb.RegistraNuevo("Prueba6","6","prueba6");
        //peticionweb.ActualizaRegistro("17","pru 6", "66", "pru6@prue6.com");
        //peticionweb.EliminarRegistro("17");

        gvdatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int celda, long l) {
                if ((celda>1) && ((celda % 2)==0)){
                    for (DatosDTO dato:ldatos) {
                        if (dato.getId() == Integer.parseInt(sdatos.get(celda))){
                            txtid.setText(String.valueOf(dato.getId()));
                            txtnombre.setText(dato.getNombre());
                            txtedad.setText(String.valueOf(dato.getEdad()));
                            txtcorreo.setText(dato.getCorreo());
                        }
                    }
                }
            }
        });
    }


}