package com.example.usuario.android1;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    public Button boton1;
    public Button boton2;
    public TextView texto;
    public CheckBox check;
    public RadioButton radio1;
    public RadioButton radio2;
    private Spinner cmbOpciones1;
    public ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button1);
        boton1=(Button)findViewById(R.id.button1);
        boton2=(Button)findViewById(R.id.button2);
        texto=(TextView)findViewById(R.id.textView);
        check=(CheckBox)findViewById(R.id.checkBox);
        radio1=(RadioButton)findViewById(R.id.radioButton1);
        radio2=(RadioButton)findViewById(R.id.radioButton2);

        final String[] datos =
                new String[]{"Elem1","Elem2","Elem3","Elem4","Elem5"};

        ArrayAdapter<String> adaptador =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_item, datos);

        //LISTAS DESPLEGABLES
        final String[] datos1 =
                new String[]{"Elem1","Elem2","Elem3","Elem4","Elem5"};
        ArrayAdapter<String> adaptador1 =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_item, datos);
        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(this,
                        R.array.valores_array,
                        android.R.layout.simple_spinner_item);
        cmbOpciones1= (Spinner)findViewById(R.id.CmbOpciones1);
        adaptador1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cmbOpciones1.setAdapter(adaptador1);

        //LISTAS LISTVIEW
        ArrayAdapter<String> adaptador3 =
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1, datos);
        //lista=(ListView)findViewById(R.id.LstOpciones);
        //lista.setAdapter(adaptador);

        //AdaptadorTitulares adaptador3 = new AdaptadorTitulares(this, datos);

        lista = (ListView)findViewById(R.id.LstOpciones);

        lista.setAdapter(adaptador);


        //PESTAÑAS
        Resources res = getResources();
        TabHost tabs=(TabHost)findViewById(android.R.id.tabhost);
        tabs.setup();
        TabHost.TabSpec spec=tabs.newTabSpec("mitab1");
        spec.setContent(R.id.tab1);
        spec.setIndicator("",
                res.getDrawable(android.R.drawable.ic_btn_speak_now));
        tabs.addTab(spec);
        spec=tabs.newTabSpec("mitab2");
        spec.setContent(R.id.tab2);
        spec.setIndicator("TAB2",
                res.getDrawable(android.R.drawable.ic_dialog_map));
        tabs.addTab(spec);
        tabs.setCurrentTab(0);


    }

    public void cambioTexto(View v){
        if(!check.isChecked()) {
            texto.setText("BOTÓN 1 PULSADO");
        }
        else{
            texto.setText("ACTIVADO CHECK B1");
        }
    }

    public void cambioTexto1(View v){
        if(!check.isChecked()) {
            texto.setText("BOTÓN 2 PULSADO");
        }
        else{
            texto.setText("ACTIVADO CHECK B2");
        }
    }

}


class AdaptadorTitulares extends ArrayAdapter<Titular> {

    private Titular[] datos =
            new Titular[]{
                    new Titular("Título 1", "Subtítulo largo 1"),
                    new Titular("Título 2", "Subtítulo largo 2"),
                    new Titular("Título 3", "Subtítulo largo 3"),
                    new Titular("Título 4", "Subtítulo largo 4"),
                    //...
                    new Titular("Título 15", "Subtítulo largo 15")};

    public AdaptadorTitulares(Context context, Titular[] datos) {
        super(context, R.layout.listitem_titular, datos);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listitem_titular, null);

        TextView lblTitulo = (TextView)item.findViewById(R.id.LblTitulo);
        lblTitulo.setText(datos[position].getTitulo());

        TextView lblSubtitulo = (TextView)item.findViewById(R.id.LblSubTitulo);
        lblSubtitulo.setText(datos[position].getSubtitulo());

        return(item);
    }
}