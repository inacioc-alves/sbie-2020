package javcpnwebserviceexample;

import java.io.File;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;

public class ImagePGM{
	private String id_img;
	private int w;
	private int h;
	private int max;
	private int[][] matrix;

	public ImagePGM(String fname){
		int i, j;
		String img_dir = "/src/javcpnwebserviceexample/imagens/";
		String curr_dir = System.getProperty("user.dir")+img_dir;
		//System.out.println(curr_dir);
		fname = curr_dir+fname;
		//System.out.println(fname);
		File f;
		Scanner s;

		try{
			f = new File(fname);
			s = new Scanner(f);
			id_img = s.nextLine();
			id_img.strip();

			w = s.nextInt();
			h = s.nextInt();

			max = s.nextInt();
			matrix = new int[h][w];
	
			for(i=0; i<h; i++)
				for(j=0; j<w; j++)
					matrix[i][j] = s.nextInt();
		}catch(Exception e) {e.printStackTrace();}
	}// End of Constructor
	
	public ImagePGM() {
		int i, j;
		System.out.println("Gerando \"imagem\" aleatoria");
		h = 5;
		w = 10;
		max = 255;
		matrix = new int[h][w];
		for(i=0; i<h; i++)
			for(j=0; j<w; j++) {
				matrix[i][j] = ThreadLocalRandom.current().nextInt(0,max+1);
			}
				
	}

	@Override
	public String toString(){
		int i, j;
		String s = "";
		//String s = "(\"P2\","+Integer.toString(w)+",";
		//s += Integer.toString(h)+","+Integer.toString(max)+",";
		//s+= "[";
		System.out.println("Iniciando string");
		for(i=0; i<h; i++){
			s += "[";
			for(j=0; j<w; j++){
				s+=Integer.toString(matrix[i][j]);
				if(j<w-1)
					s+= ",";
			}
			s += "]";
			if(i<h-1)
				s+=",";
		}
		s += "])";

		return s;
	}
	
	public String getHeader() {
		String s = "(\"P2\","+Integer.toString(w)+",";
		s += Integer.toString(h)+","+Integer.toString(max)+",";
		return s;
	}

	public int getH() {
		return this.h;
	}

	public String getLine(int i) {
		int j;
		String s = "[";
		if(i==0)
			s+="[";

		for(j=0; j < this.w; j++){
			s+=Integer.toString(matrix[i][j]);
			if(j < this.w - 1)
				s+= ",";
		}
		s += "]";
		if(i < this.h-1)
			s+=",";
		else
			s+="])";
		return s;
	}
}