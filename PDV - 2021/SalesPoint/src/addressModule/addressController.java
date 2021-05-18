/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressModule;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONObject;

/**
 *
 * @author MatheusCabral
 */
public class addressController {    
    private ArrayList<zipcode> cepList;
    
    public addressController() {
        this.cepList = null;
    }
    
    public void getAddressByZipcode(String cep) {
        cepList = getCEPJSON(cep);
        
        if(cepList.size() > 0) {
            for (int i = 0; i < cepList.size(); i ++){
                System.out.println("CEP: " + cepList.get(i).getZipcode());
                System.out.println("Rua: " + cepList.get(i).getStreet());
                System.out.println("Bairro: " + cepList.get(i).getNeighborhood());
                System.out.println("Cidade: " + cepList.get(i).getCity());
                System.out.println("UF: " + cepList.get(i).getUf());
                System.out.println("Complemento: " + cepList.get(i).getComplement());
            }
        }
    }
    
    private ArrayList<zipcode> getCEPJSON(String cep) {
        ArrayList<zipcode> result = new ArrayList<>();
        
        // define a url
        String url = "http://viacep.com.br/ws/" + cep + "/json/";
        
        try{
            // define os dados
            JSONObject obj = new JSONObject(getHttpGET(url));

            if (!obj.has("erro")) {
                zipcode novoCEP = new zipcode (
                    obj.getString("cep"),
                    obj.getString("logradouro"),
                    obj.getString("complemento"),
                    obj.getString("bairro"),
                    obj.getString("localidade"),
                    obj.getString("uf"),
                    obj.getString("ibge"),
                    obj.getString("gia")
                );

                // insere o novo CEP
                result.add(novoCEP);

            } else {
                System.out.println("Não foi possível encontrar o CEP");
            }
        } catch(Exception e){
            System.out.println("Error: " + e);
        }
        
        return result;
    }

    private final String getHttpGET(String urlToRead) {
        StringBuilder result = new StringBuilder();

        try {
            URL url = new URL(urlToRead);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            
        } catch (MalformedURLException | ProtocolException e) {
            System.out.println("Error: " + e);
        } catch (IOException e) {
            for (int i = 0; i < e.toString().length() - 3; i++) {
                if("400".equals(e.toString().substring(i, i + 3))) {
                    System.out.println("Verifique a sua URL");
                    i = e.toString().length();
                }
            }
            System.out.println("Error: " + e);
        }
        
        return result.toString();
    }
    
    public class zipcode {
        private String zipcode;
        private String street;
        private String complement;
        private String neighborhood;
        private String city;
        private String uf;
        private String Ibge;
        private String Gia;

        public zipcode() {
            this.street = null;
            this.complement = null;
            this.neighborhood = null;
            this.city = null;
            this.uf = null;
            this.Ibge = null;
            this.Gia = null;
        }
        
        public zipcode(String zipcode, String street, String complement, String neighborhood, String city, String uf, String Ibge, String Gia) {
            this.zipcode = zipcode;
            this.street = street;
            this.complement = complement;
            this.neighborhood = neighborhood;
            this.city = city;
            this.uf = uf;
            this.Ibge = Ibge;
            this.Gia = Gia;
        }
        
        public zipcode(String street, String city, String uf) {
            this.street = street;
            this.city = city;
            this.uf = uf;
        }

        public String getZipcode() { return zipcode; }
        public void setZipcode(String CEP) { this.zipcode = CEP; }

        public String getStreet() { return street; }
        public void setStreet(String Logradouro) { this.street = Logradouro; }

        public String getComplement() { return complement; }
        public void setComplement(String Complemento) { this.complement = Complemento; }

        public String getNeighborhood() { return neighborhood; }
        public void setNeighborhood(String Bairro) { this.neighborhood = Bairro; }

        public String getCity() { return city; }
        public void setCity(String Localidade) { this.city = Localidade; }

        public String getUf() { return uf; }
        public void setUf(String Uf) { this.uf = Uf; }

        public String getIbge() { return Ibge; }
        public void setIbge(String Ibge) { this.Ibge = Ibge; }

        public String getGia() { return Gia; }
        public void setGia(String Gia) { this.Gia = Gia; }
    }
    
}
