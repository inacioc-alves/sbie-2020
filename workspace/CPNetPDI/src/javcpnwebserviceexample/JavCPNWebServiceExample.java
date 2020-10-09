package javcpnwebserviceexample; 

import javcpnwebserviceexample.EncodeDecode;
import javcpnwebserviceexample.ImagePGM;
//import EncodeDecode;


public class JavCPNWebServiceExample {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) throws Exception {
		int port = 9000;
		JavaCPN conn = new JavaCPN();
		
		String from = "";
		int line;

		while(true) {
			// listen on port and accept connection
			conn.accept(port);
			//		while (true) {
			System.out.println("Recebendo nome do arquivo");
			from = EncodeDecode.decodeString(conn.receive());
			System.out.println("Arquivo:"+from);

			System.out.println("Obtendo dados da imagem");
			//ImagePGM i = new ImagePGM(from);
			ImagePGM i = new ImagePGM(from);
			System.out.println("Dados recebidos");
			System.out.println(i.getHeader());

			conn.receive();
			System.out.println("Enviando cabeçalho da imagem");
			conn.send(EncodeDecode.encode(i.getHeader()));

			conn.receive();
			System.out.println("Enviando quantidade de linhas da imagem");
			conn.send(EncodeDecode.encode(Integer.toString(i.getH())));

			for(line=0; line < i.getH(); line++) {
				conn.send(EncodeDecode.encode(i.getLine(line)));
			}
			//conn.send(EncodeDecode.encode(i.toString()));
			//		}
			conn.disconnect();
		}
	}// End of main

}
//