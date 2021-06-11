package com.example.mismascotas;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Contacto extends AppCompatActivity {
    EditText correo, nombre, mensaje;
    Button boton;
    String email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);


        correo = findViewById(R.id.TextCorreo);
        nombre = findViewById(R.id.TextNombre);
        mensaje = findViewById(R.id.TextMensaje);
        boton = findViewById(R.id.TextButton);

        email = "reparacionespc91@gmail.com";
        password = "unodostres123";

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Properties properties = new Properties();
                properties.put("mail.smtp.auth","true");
                properties.put("mail.smtp.ssl.enable","true");
                properties.put("mail.smtp.host","smtp.gmail.com");
                properties.put("mail.smtp.port","587");

                Session session = Session.getInstance(properties, new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(email,password);
                    }
                });

                try {
                    Message message = new MimeMessage(session);
                    message.setFrom(new InternetAddress(email));
                    message.setRecipients(Message.RecipientType.TO,
                            InternetAddress.parse(correo.getText().toString().trim()));
                    message.setSubject(nombre.getText().toString().trim());
                    message.setText(mensaje.getText().toString().trim());
                    new SendMail().execute(message);
                } catch (MessagingException e) {
                    e.printStackTrace();
                }

            }
        });
    }

    private class SendMail extends AsyncTask<Message,String,String> {
        private ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(Contacto.this
                    , "Por Favor Espere", "Enviando Mensaje", true, false);
        }

        @Override
        protected String doInBackground(Message... messages) {
            try {
                Transport.send(messages[0]);
                return  "Success";
            } catch (MessagingException e) {
                e.printStackTrace();
                return "Error";
            }

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            progressDialog.dismiss();
            if(s.equals("Success")){
                AlertDialog.Builder builder = new AlertDialog.Builder(Contacto.this);
                builder.setCancelable(false);
                builder.setTitle(Html.fromHtml("<font color='#509324'>Sucess</font>"));
                builder.setMessage("Mail send sucessfully.");
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        correo.setText("");
                        nombre.setText("");
                        mensaje.setText("");
                    }
                });
                builder.show();
            }else{
                Toast.makeText(getApplicationContext(),"Something went wrong ?", Toast.LENGTH_SHORT);
            }
        }
    }
}