package psjoon87SmonWar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public enum Properties {
		Fire("Fire"), 
		Water("Water"), 
		Wind("Wind"), 
		Light("Light"), 
		Dark("Dark");
		
		private String url;
		
		Properties(String property){
			url = "http://summonerswar.wikia.com/wiki/"+property+"_Monsters";
		}
		
		public String getUrl(){
			return url;
		}
	}

	public void getHtml(){
		HttpURLConnection conn;
		BufferedReader br;
		
		String htmlLine = "";
		
		List htmlLineArrayList = new ArrayList();
		
		try{
			for(Properties propertyUrl : Properties.values()){
				URL url = new URL(propertyUrl.getUrl());
				
				conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				
				br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				
				String chk1 = "<td style=\"text-align:center;\"><a href=\"/wiki";
				String chk2 = "class=\"image image-thumbnail link-internal\"";
				
				String[] htmlLineSplit;
				
				
				while((htmlLine = br.readLine()) != null){
					if(htmlLine.indexOf(chk1) != -1 && htmlLine.indexOf(chk2) != -1) {
						htmlLineSplit = htmlLine.split("\"");
						
						htmlLineArrayList.add(htmlLineSplit[3]);
					}
				}
			}
			
			int count = 0;
			for(int i=0 ; i<htmlLineArrayList.size() ; i++){
				System.out.println(htmlLineArrayList.get(i));
				count++;
			}
			System.out.println("몬스터 수 : " + count);
			
//			URL urlWind = new URL("http://summonerswar.wikia.com/wiki/Wind_Monsters");		//가져오고자 하는 웹페이지의 url
//			URL urlFire = new URL("http://summonerswar.wikia.com/wiki/Fire_Monsters");
//			URL urlWater = new URL("http://summonerswar.wikia.com/wiki/Water_Monsters");
//			URL urlLight = new URL("http://summonerswar.wikia.com/wiki/Light_Monsters");
//			URL urlDark = new URL("http://summonerswar.wikia.com/wiki/Dark_Monsters");
//			
//			conn = (HttpURLConnection) urlWind.openConnection();						//java에서 입력한 url에 접속합니다.
//			conn = (HttpURLConnection) urlFire.openConnection();
//			conn = (HttpURLConnection) urlWater.openConnection();
//			conn = (HttpURLConnection) urlLight.openConnection();
//			conn = (HttpURLConnection) urlDark.openConnection();
//			conn.setRequestMethod("GET");											//HttpUrlConnection 방식 : Get or Post
//			
//			br = new BufferedReader(new InputStreamReader(conn.getInputStream()));	//BufferedReader 객체에 라인 단위로 데이터를 담아줍니다.
//			
//			String chk1 = "<td style=\"text-align:center;\"><a href=\"/wiki";
//			String chk2 = "class=\"image image-thumbnail link-internal\"";
//			
//			String[] htmlLineSplit;
//			
//			List htmlLineArrayList = new ArrayList();
//			while((htmlLine = br.readLine()) != null){
//				if(htmlLine.indexOf(chk1) != -1 && htmlLine.indexOf(chk2) != -1) {
//					htmlLineSplit = htmlLine.split("\"");
//					
//					htmlLineArrayList.add(htmlLineSplit[3]);
//				}
//			}
//			
//			int count = 0;
//			for(int i=0 ; i<htmlLineArrayList.size() ; i++){
//				System.out.println(htmlLineArrayList.get(i));
//				count++;
//			}
//			System.out.println("몬스터 수 : " + count);
		}catch(IOException e) {
	        e.printStackTrace();
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		main.getHtml();
	}
}


