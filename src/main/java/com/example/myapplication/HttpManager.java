package com.example.myapplication;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpManager extends AsyncTask<String, Void, String> {

    private URL url;
    private HttpURLConnection connection;
    private InputStreamReader inputStreamReader;
    private InputStream inputStream;
    private BufferedReader bufferedReader;


    /*  Nu-mi merge json-ul si nu mai am timp sa vad ce-i pot face, dar las codul sa vad cum il pot repara */
    /*  Am sters butonul care facea legatura cu json-ul    */

    @Override
    protected String doInBackground(String... strings) {

        StringBuilder result= new StringBuilder();
        try{
            url = new URL(strings[0]);
            connection = (HttpURLConnection) url.openConnection();
            inputStream = connection.getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String linie;


            while ((linie= bufferedReader.readLine())!=null)

                result.append(linie);
        }

        catch (MalformedURLException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        finally {
            try{

                bufferedReader.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
            try{
                inputStreamReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try{
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            connection.disconnect();
        }



        return result.toString();
        }



    }

