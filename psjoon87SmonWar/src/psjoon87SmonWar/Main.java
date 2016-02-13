package psjoon87SmonWar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		main.getHtml();
	}
	
	public void getHtml(){
		URL url;
		HttpURLConnection conn;
		BufferedReader br;
		
		String htmlLine = "";
		
		try{
			url = new URL("http://summonerswar.wikia.com/wiki/Wind_Monsters");		//가져오고자 하는 웹페이지의 url
			conn = (HttpURLConnection) url.openConnection();						//java에서 입력한 url에 접속합니다.
			conn.setRequestMethod("GET");											//HttpUrlConnection 방식 : Get or Post
			
			br = new BufferedReader(new InputStreamReader(conn.getInputStream()));	//BufferedReader 객체에 라인 단위로 데이터를 담아줍니다.
			
			String chk1 = "<td style=\"text-align:center;\"><a href=\"/wiki";
			String chk2 = "class=\"image image-thumbnail link-internal\"";
			while((htmlLine = br.readLine()) != null){
				if(htmlLine.indexOf(chk1) != -1 && htmlLine.indexOf(chk2) != -1)
				System.out.println(htmlLine);
			}
		}catch(IOException e) {
	        e.printStackTrace();
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	}
}


