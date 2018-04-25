import java.util.Scanner;

public class BowlingConsole {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		BowlingGame bowlingGame = new BowlingGame();
		String tableauLancer[] = new String[26];
	
		for(int j=0; j<tableauLancer.length; j++){
			tableauLancer[j] =  " ";
		}
		
		for(int i=1;i<24;i++){
			
			System.out.println("Frame Lancer " + i);
			String lancer1 = scanner.nextLine();
			

            try {
    			Integer lancer1Int = Integer.parseInt(lancer1);
            	bowlingGame.roll(lancer1Int);
    			tableauLancer[i] = bowlingGame.getTableauLancerUnique(i).toString();
    			System.out.println("--------------------------------------------------------");
    			System.out.println("|1   |2   |3   |4   |5   |6   |7   |8   |9   |10    |");
    			System.out.println("|" + tableauLancer[1] + " " + tableauLancer[2] + "|" + tableauLancer[3] + " " + tableauLancer[4] + "|" + tableauLancer[5] + " " + tableauLancer[6] + "|" + tableauLancer[7] + " " + tableauLancer[8] + "|" + tableauLancer[9] + " " + tableauLancer[10] + "|" + tableauLancer[11] + " " + tableauLancer[12] + "|" + tableauLancer[13] + " " + tableauLancer[14] + "|" + tableauLancer[15] + " " + tableauLancer[16] + "|" + tableauLancer[17] + " " + tableauLancer[18] + "|" + tableauLancer[19] + " " + tableauLancer[20] + " " + tableauLancer[21] + " " + tableauLancer[22] + " " + tableauLancer[23] + "|" );
    			System.out.println();
    			System.out.println("Score = " + bowlingGame.getScore());
    			System.out.println("--------------------------------------------------------");
    			
    			if(lancer1Int == 10 && (i %2 == 1)){
    				i++;
    			}
    			
    			if(bowlingGame.getFinPartie() == true){
    				break;
    			}
            } catch(BowlingException e){
    			System.out.println(e);
    			i--;

            } catch(NumberFormatException e2){
    			System.out.println("Saisie incorrecte (saisir un chiffre entre 0 et 10)");
    			i--;

            }
            
			
		}
		System.out.println("------------PARTIE TERMINE-------------------");

	}

}
