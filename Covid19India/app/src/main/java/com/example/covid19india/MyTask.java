package com.example.covid19india;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.LinkPermission;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

public class MyTask extends AsyncTask<Void, Void, String>
{
    Context ct;
    RecyclerView rv;
    ProgressDialog pd;
    String covidURL = "https://api.covid19api.com/dayone/country/IN";

    public MyTask(MainActivity mainActivity, RecyclerView rv)
    {
        ct = mainActivity;
        this.rv = rv;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        pd = new ProgressDialog(ct);
        pd.setTitle("Fetching Data");
        pd.setMessage("Please Wait...");
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pd.show();

    }

    @Override
    protected String doInBackground(Void... voids) {

        try
        {
            URL u = new URL(covidURL);
            HttpsURLConnection connection = (HttpsURLConnection) u.openConnection();
            InputStream is = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line = "";
            StringBuilder builder = new StringBuilder();
            while((line = reader.readLine())!=null)
            {
                builder.append(line);
            }

            return builder.toString();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String s)
    {
        super.onPostExecute(s);
        pd.dismiss();
        if(s==null)
        {
            Toast.makeText(ct, "Please Check Your Internet Connection", Toast.LENGTH_LONG).show();
        }
        else
        {
            try
            {
                JSONArray countryJSONArray = new JSONArray(s);
                List<CovidCases> myCov = new ArrayList<>();
                for(int i = countryJSONArray.length()-1; i>=0; i--)
                {
                    JSONObject eachDate = countryJSONArray.getJSONObject(i);
                    String temp = eachDate.optString("Date");
                    String date = "";
                    for(int j = 0; j<temp.length(); j++)
                    {
                        if(temp.charAt(j)=='T')
                        {
                            break;
                        }
                        else
                        {
                            date+=temp.charAt(j);
                        }
                    }
                    String active = eachDate.optString("Active");
                    String death = eachDate.optString("Deaths");
                    String recovered = eachDate.optString("Recovered");
                    CovidCases cov = new CovidCases(active, death, recovered, date);
                    myCov.add(cov);
                }

                rv.setLayoutManager(new LinearLayoutManager(ct));
                MyAdapter adapter = new MyAdapter(ct, myCov);
                rv.setAdapter(adapter);

            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

    }
}
