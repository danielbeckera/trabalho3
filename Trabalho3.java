import javax.swing.JOptionPane;
import java.io.*;

public class Trabalho3 {
	static class Art {	
		String compartimento;
		int numeroVezes;
		String musica;	
		String artista;
	}

	static final int TAMANHO = 12;
	static final String NOME_ARQUIVO = "numeroVezes.txt";
	static BufferedWriter arquivo = null;
	static BufferedReader leitura;
	static Art[] art = new Art[TAMANHO];
	static String mensagem;
	static String musicaMaisTocada;
	
	public static void initialize() {
		for(int i = 0; i < TAMANHO; i++) {
			art[i] = new Art();
		}

		art[0].compartimento = "101";	art[0].musica = "Wolves";			art[0].artista = "Kanye West";	
		art[1].compartimento = "102";	art[1].musica = "Stronger";			art[1].artista = "Kanye West";
		art[2].compartimento = "103";	art[2].musica = "POWER";			art[2].artista = "Kanye West";
		art[3].compartimento = "201";	art[3].musica = "Amen Omen";		art[3].artista = "Ben Harper";
		art[4].compartimento = "202";	art[4].musica = "Forever";			art[4].artista = "Ben Harper";
		art[5].compartimento = "203";	art[5].musica = "Good People";		art[5].artista = "Jack Johnson";
		art[6].compartimento = "301";	art[6].musica = "Do You Remember";	art[6].artista = "Jack Johnson";
		art[7].compartimento = "302";	art[7].musica = "ABC";				art[7].artista = "The Jackson 5";
		art[8].compartimento = "303";	art[8].musica = "Snowed In";		art[8].artista = "Big Data";
		art[9].compartimento = "401";	art[9].musica = "Dangerous";		art[9].artista = "Big Data"; 
		art[10].compartimento = "402";	art[10].musica = "Breezeblocks";	art[10].artista = "alt-J";
		art[11].compartimento = "403";	art[11].musica = "Intro";			art[11].artista = "alt-J";

	}
	
	
//  1) (PROCEDIMENTO e passagem de parâmetro por REFERÊNCIA) Solicite ao usuário o número
//	de vezes que a música foi pedida(TOCADA), a mensagem que aparece para o usuário deve
//	seguir o seguinte modelo: 
	public static void questao1() {
		try{
			arquivo = new BufferedWriter(new FileWriter(new File(NOME_ARQUIVO)));
		
			String quantidade;
			for(int i = 0; i<TAMANHO; i++) {
				quantidade = JOptionPane.showInputDialog("Insira o número de vezes que a música " + art[i].musica + " do artista " + art[i].artista + " foi pedida.");
				arquivo.write(quantidade);
				arquivo.newLine();
			}

			arquivo.close();
		}
		catch(IOException e ){
			JOptionPane.showMessageDialog(null, "Desculpe, não foi possível abrir o arquivo.");
		}
	}
	
//	2) (FUNÇÃO e passagem de parâmetro por VALOR) Solicite ao usuário que informe um nome
//	de um dos artista (STRING) e utilizando PESQUISA LINEAR mostre o número de músicas que
//	este artista possui cadastrado no sistema da JUKEBOX. 
	public static int questao2(String escolha) {
		int counter = 0;
		for(int i = 0; i < TAMANHO; i++) {
			if(art[i].artista.equalsIgnoreCase(escolha)) {
				counter++;
			}
		}
		return counter;
	}
	
//	3) (FUNÇÃO e passagem de parâmetro por VALOR) Mostre quantas vezes a máquina tocou
//	músicas. Como cada música custa a moeda de R$ 1,00 , o dono deseja saber quantos reais tem
//	em caixa. 
	public static int questao3() {
		int totalMusicas = 0;

		try{
			leitura = new BufferedReader(new FileReader(new File(NOME_ARQUIVO)));

			for(int i = 0; i < TAMANHO; i++) {
				totalMusicas += Integer.parseInt(leitura.readLine());
			}

			leitura.close();
		}
		catch(IOException e) {
			JOptionPane.showMessageDialog(null, "Desculpe, não foi possível abrir o arquivo para a leitura.");
		}
		return totalMusicas;
	}

//	4) (FUNÇÃO e passagem de parâmetro por VALOR) Mostre o nome do artista, o número do
//	compartimento e a música MAIS PEDIDA.
	public static String questao4() {
		int maisTocada = 0;
		Art valores = new Art();

		try{
			leitura = new BufferedReader(new FileReader(new File(NOME_ARQUIVO)));

			int atual;
			for(int i = 0; i < TAMANHO; i++) {
				atual = Integer.parseInt(leitura.readLine());
				if(atual > maisTocada) {
					maisTocada = atual;
					valores = art[i];
				}
			}

			leitura.close();
		}
		catch(IOException e) {
			JOptionPane.showMessageDialog(null, "Desculpe, não foi possível abrir o arquivo para a leitura.");
		}

		return "O nome do artista é: " + valores.artista
			+ "\nO número do compartimento é: " + valores.compartimento
			+ "\nE a música mais pedida é: " + valores.musica;
	}
	
//	5) (FUNÇÃO e passagem de parâmetro por VALOR) Mostre o número do
//	compartimento e o nome do artista da música MENOS pedida.
	public static String questao5() {
		int menosTocada = 9999;
		Art valores = new Art();

		try{
			leitura = new BufferedReader(new FileReader(new File(NOME_ARQUIVO)));

			int atual;
			for(int i = 0; i < TAMANHO; i++) {
				atual = Integer.parseInt(leitura.readLine());
				if(atual < menosTocada) {
					menosTocada = atual;
					valores = art[i];
				}
			}

			leitura.close();
		}
		catch(IOException e) {
			JOptionPane.showMessageDialog(null, "Desculpe, não foi possível abrir o arquivo para a leitura.");
		}

		return "O nome do artista é: " + valores.artista
			+ "\nO número do compartimento é: " + valores.compartimento
			+ "\nE a música menos pedida é: " + valores.musica;
	}

//	6) (FUNÇÃO e passagem de parâmetro por VALOR) Solicite que o usuário informe um número
//	do compartimento(STRING), mostre o nome do artista, nome da música e número de vezes
//	que tocou. 
	public static String questao6(String escolha) {
		Art valores = new Art();
		String quantidade = "";

		try{
			leitura = new BufferedReader(new FileReader(new File(NOME_ARQUIVO)));

			String atual;
			for(int i = 0; i < TAMANHO; i++) {
				atual = leitura.readLine();
				if(art[i].compartimento.equals(escolha)) {
					valores = art[i];
					quantidade = atual;
				}
			}

			leitura.close();
		}
		catch(IOException e) {
			JOptionPane.showMessageDialog(null, "Desculpe, não foi possível abrir o arquivo para a leitura.");
		}

		return "Este compartimento correspende à: " 
			+ "\nArtista: " + valores.artista
			+ "\nMúsica: " + valores.musica
			+ "\nNúmero de vezes que tocou: " + quantidade;
	}

//	7) (PROCEDIMENTO e passagem de parâmetro por REFERÊNCIA)Mostre as 10 músicas mais
//	tocadas.
	public static void questao7() {
		int[] repeticoes = new int[TAMANHO];
		int replace1;
		Art[] valores = new Art[TAMANHO];
		Art replace2 = new Art();
		mensagem = "";

		try{
			leitura = new BufferedReader(new FileReader(new File(NOME_ARQUIVO)));

			for(int i = 0; i < TAMANHO; i++) {
				valores[i] = art[i];
				repeticoes[i] = Integer.parseInt(leitura.readLine());
			}

			leitura.close();
		}
		catch(IOException e) {
			JOptionPane.showMessageDialog(null, "Desculpe, não foi possível abrir o arquivo para a leitura.");
		}

		int fim = TAMANHO-1;
		boolean flag;
		do{
			flag = true;
			for(int i = 0; i < fim; i++) {
				if(repeticoes[i] > repeticoes[i+1]) {
					replace1 = repeticoes[i+1];
					repeticoes[i+1] = repeticoes[i];
					repeticoes[i] = replace1;

					replace2 = valores[i+1];
					valores[i+1] = valores[i];
					valores[i] = replace2;
					flag = false;
				}
			}
			fim--;
		}while(flag == false);

		// APAGA ESSA PORRA
		for(int i = 0; i < TAMANHO; i++) {
			System.out.println(repeticoes[i] + "\t" + valores[i].musica);
		}

		int n = 1;
		for(int i = 11; i > 1; i--) {
			mensagem += "\n" + n + ". " + valores[i].musica;
			n++;
		}
	}

//	8) (PROCEDIMENTO e passagem de parâmetro por REFERÊNCIA)Mostre o número de músicas
//	que tocaram mais vezes que a média de músicas tocadas.
	public static void questao8() {
		double media = questao3()/TAMANHO;
		int counter = 0;

		try{
			leitura = new BufferedReader(new FileReader(new File(NOME_ARQUIVO)));

			for(int i = 0; i < TAMANHO; i++) {
				if(Integer.parseInt(leitura.readLine()) > media) {
					counter++;
			}
		}

			leitura.close();
		}
		catch(IOException e) {
			JOptionPane.showMessageDialog(null, "Desculpe, não foi possível abrir o arquivo para a leitura.");
		}

		JOptionPane.showMessageDialog(null, counter + " músicas tocaram mais que a média de "
									+ media + " repetições por música.");
	}

//	9) (FUNÇÃO e passagem de parâmetro por VALOR) Solicite que o usuário informe o nome de
//	um artista, mostre o número de vezes que este ARTISTA foi tocado nesta JUKEBOX, incluindo a
//	soma de todas as músicas.
	public static int questao9(String escolha) {
		int somaMusicas = 0;

		try{
			leitura = new BufferedReader(new FileReader(new File(NOME_ARQUIVO)));

			int atual;
			for(int i = 0; i < TAMANHO; i++) {
				atual = Integer.parseInt(leitura.readLine());
				if(art[i].artista.equalsIgnoreCase(escolha)) {
					somaMusicas += atual;
				}
			}

			leitura.close();
		}
		catch(IOException e) {
			JOptionPane.showMessageDialog(null, "Desculpe, não foi possível abrir o arquivo para a leitura.");
		}

		return somaMusicas;
	}

//	10) (PROCEDIMENTO e passagem de parâmetro por REFERÊNCIA)Considerando os
//	compartimentos com final 2 (102,202,302,402), mostre o nome do música mais tocada.
	public static void questao10() {
		int maisTocada = 0;

		try{
			leitura = new BufferedReader(new FileReader(new File(NOME_ARQUIVO)));

			int atual;
			for(int i = 0; i < TAMANHO; i++) {
				atual = Integer.parseInt(leitura.readLine());
				if(Integer.parseInt(art[i].compartimento)%2 == 0) {
					if(atual > maisTocada) {
						maisTocada = atual;
						musicaMaisTocada = art[i].musica;
					}
				}
			}

			leitura.close();
		}
		catch(IOException e) {
			JOptionPane.showMessageDialog(null, "Desculpe, não foi possível abrir o arquivo para a leitura.");
		}
	}

	public static void main(String[] args) {
		initialize();

		questao1();

		int choice = 0;
		do {
			choice = Integer.parseInt(JOptionPane.showInputDialog("Selecione a operação: "

					+ "\n\n1 - Solicite ao usuário que informe um nome de um dos artista (STRING) e utilizando"
					+ "\nPESQUISA LINEAR mostre o número de músicas que este artista possui "
					+ "\ncadastrado no sistema da JUKEBOX."
	
					+ "\n\n2 - Mostre quantas vezes a máquina tocou músicas. Como cada música custa a moeda"
					+  "\nde R$ 1,00, o dono deseja saber quantos reais tem em caixa."
	
					+ "\n\n3 - Mostre o nome do artista, o número do compartimento e a música MAIS PEDIDA."
	
					+ "\n\n4 - Mostre o número do compartimento e o nome do artista da música MENOS pedida."
	
					+ "\n\n5 - Solicite que o usuário informe um número do compartimento(STRING), mostre o nome"
					+ "\ndo artista, nome da música e número de vezes que tocou."
	
					+ "\n\n6 - Mostre as 10 músicas mais tocadas."
	
					+ "\n\n7 - Mostre o número de músicas que tocaram mais vezes que a média de músicas tocadas."
	
					+ "\n\n8 - Solicite que o usuário informe o nome de um artista, mostre o número de vezes que"
					+ "\neste ARTISTA foi tocado nesta JUKEBOX, incluindo a soma de todas as músicas."
	
					+ "\n\n9 - Considerando os compartimentos com final 2 (102,202,302,402), mostre o nome"
					+  "\ndo música mais tocada. "

					+ "\n\n0 - SAIR"
					));

			switch(choice) {
				case 1:
					String escolha = JOptionPane.showInputDialog("Informe um artista para saber quantas"
					+ " músicas ele possui na jukebox:");

					JOptionPane.showMessageDialog(null, "O artista possui " + questao2(escolha)
					+ " músicas nesta jukebox.");
				break;

				case 2:
					JOptionPane.showMessageDialog(null, "A jukebox tocou " + questao3()
					+ " músicas, portanto possui R$" + questao3() + " em caixa.");
				break;

				case 3:
					JOptionPane.showMessageDialog(null, questao4());
				break;

				case 4:
					JOptionPane.showMessageDialog(null, questao5());
				break;

				case 5:
					escolha = JOptionPane.showInputDialog("Informe o compartimento desejado:");
					JOptionPane.showMessageDialog(null, questao6(escolha));
				break;

				case 6:
					questao7();
					JOptionPane.showMessageDialog(null, "As 10 músicas mais tocadas são: " + mensagem);
				break;

				case 7:
					questao8();
				break;

				case 8:
					escolha = JOptionPane.showInputDialog("Digite o nome de um artista para saber quantas"
					+ " vezes ele foi tocado:");

					JOptionPane.showMessageDialog(null, "O artista solicitado tocou " + questao9(escolha)
					+ " músicas ao todo, sendo que a Jukebox tocou " + questao3() + ".");
				break;

				case 9:
					questao10();
					JOptionPane.showMessageDialog(null, "Dentre os compartimentos com final 2," 
					+ " a música mais tocada é " + musicaMaisTocada);
				break;

				case 0: 
				break;

				default:
					JOptionPane.showMessageDialog(null, "Operação inválida.");
				break;
			}
		}while(choice != 0);

	}
}