public class BowlingGame {

	private int numLance = 0;
    private int score = 0;    
    private int strikePrevPrev = 0;
    private int strikePrev = 0;
    private int prevLancer1 = 0;
    private int prevLancer2 = 0;
    private Integer tableauLancer[] = new Integer[25];
    private Boolean finPartie = false;

	//Check si c'est un spare retourne true
	public Boolean checkSparePrev(){
		if(getPrevLancer1() < 10 && (getPrevLancer1() + getPrevLancer2()) == 10 ){
			return true;
		}
		else return false;
	}

	//SI Lancer 19 et 20 < 10 alors fin de la partie au lancer 20
	public void checkFinA20(Integer numberPins){
		if(getPrevLancer1() + numberPins < 10 ){
			setFinPartie(true);
		}
	}
	
	//SI Lancer 19 et 20 = spare alors fin de la partie au lancer 21
	public void checkFinA21(Integer numberPins){
		if(getPrevLancer1() + getPrevLancer2() == 10){
			setFinPartie(true);
		}
	}

	//SI Lancer 20 < 10 alors fin de la partie au lancer 22
	public void checkFinA22(Integer numberPins){
		if(getPrevLancer1() < 10){
			setFinPartie(true);
		}
	}

	//SI Lancer 23 alors fin de la partie au lancer 23
	public void checkFinA23(){
		if(getNumLance() == 23){
			setFinPartie(true);
		}
	}
		
	public void roll(Integer numberPins) throws BowlingException {
		//Si la parti n'est pas finit
		if(getFinPartie() == false){
			//Incrémente le compteur de lancer de 1
			setNumLance(getNumLance() + 1);
			
			//Si impair c'est le premier lancer sur les deux
			if(getNumLance() % 2 == 1){
				
				//Au premier lancer on lance une exception si plus de 10 quilles saisies
				if(numberPins > 10){
					setNumLance(getNumLance() - 1);
					throw new BowlingException("Le nombre de quilles saisie dépasse le maximum de 10 autorisé par frame !");
				}
				else{
					
					tableauLancer[getNumLance()] = numberPins;
				
					//Si 2 strike avant alors on multiplie par 3 le nombre de quille actuel
					if(getStrikePrevPrev() == 10 && getStrikePrev() == 10){
						//Jusqu'au dixieme lancer on prend en compte le score du lancer actuel + les bonus
						if(getNumLance() < 21){
							setScore(getScore() + (numberPins * 3));
						}
						//Au onzieme lancer on prend en compte que les bonus des 2 lancer précédents
						else if(getNumLance() == 21){
							setScore(getScore() + (numberPins * 2));
						}
						//Au douzieme lancer on ne prend en compte que le bonus du 10eme lancer
						else if(getNumLance() == 23){
							setScore(getScore() + numberPins);
						}
					}
					//Si 1 strike ou SPARE avant alors on multiplie par 2 le nombre de quille actuel
					else if((checkSparePrev() == true || getStrikePrev() == 10)){
						//Jusqu'au dixieme lancé on prend en compte le score du lancer actuel + le bonus du lancer précédent
						if(getNumLance() < 21){
							setScore(getScore() + (numberPins * 2));
						}
						//Au 11 eme lancer on ne prend pas en compte le lancer actuel
						else if(getNumLance() == 21){
							setScore(getScore() + numberPins);
						}
					}
					else{
						setScore(getScore() + numberPins);
					}
					
					//On vérifie si c'est la fin de la partie
					if(getNumLance() == 21){
						checkFinA21(numberPins);
					}
					else if(getNumLance() == 23){
						checkFinA23();
					}	
					
					//On sauvegarde le lancer actuel
					setPrevLancer1(numberPins);		

					
					//Si on a fait un strike il n'y a pas de 2eme lancé donc on incrémente de 1 le compteur de lancé
					if(numberPins == 10){
						setNumLance(getNumLance() + 1);
						if((getNumLance() + 1) < 25){
							tableauLancer[getNumLance() + 1] = 11;						
						}
						setPrevLancer2(11);
						
						//Si strike précédent déja a 10 On sauvegarde un autre strike précédent précédent a 10
						if(getStrikePrev() == 10){
							setStrikePrevPrev(10);
						}
						//On sauvegarde le strike actuel comme précédent
						else {
							//On sauvegarde le strike
							setStrikePrev(numberPins);
						}
					}
	
				}
				
			}
			//Sinon si pair c'est le deuxieme lancer
			else{
				
				//Au deuxieme lancer on lance une exception si plus de 10 quilles saisies
				if((numberPins + getPrevLancer1()) > 10){
					setNumLance(getNumLance() - 1);
					throw new BowlingException("Le nombre de quilles saisie dépasse le maximum de 10 autorisé par frame Lancer 2 !");
				}
				else{
					
					tableauLancer[getNumLance()] = numberPins;
				
					//Si le lancer précédent était strike
					//On multiplie par 2 le lancer actuel
					//et on remet a 0 les strikes précédents
					if(getStrikePrev() == 10){
						if(getNumLance() < 22){
							setScore(getScore() + (numberPins * 2));
						}
						//Au 11 eme lancer on ne prend pas en compte le lancer actuel
						else if(getNumLance() == 22){
							setScore(getScore() + numberPins);
						}
						setStrikePrevPrev(0);
						setStrikePrev(0);
					}
					else{
						setScore(getScore() + numberPins);
					}
					
					//On vérifie si c'est la fin de la partie
					if(getNumLance() == 20){
						checkFinA20(numberPins);
					}
					else if(getNumLance() == 22){
						checkFinA22(numberPins);
					}

					//Sauvegarde le deuieme lancer
					setPrevLancer2(numberPins);
				}
			}
		}
		
    }


    public Boolean getFinPartie() {
		return finPartie;
	}

	public void setFinPartie(Boolean finPartie) {
		this.finPartie = finPartie;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public int getPrevLancer1() {
		return prevLancer1;
	}

	public void setPrevLancer1(int prevLancer1) {
		this.prevLancer1 = prevLancer1;
	}

	public int getPrevLancer2() {
		return prevLancer2;
	}

	public void setPrevLancer2(int prevLancer2) {
		this.prevLancer2 = prevLancer2;
	}

	public int getNumLance() {
		return numLance;
	}

	public void setNumLance(int numLance) {
		this.numLance = numLance;
	}

	public int getStrikePrevPrev() {
		return strikePrevPrev;
	}

	public void setStrikePrevPrev(int strikePrevPrev) {
		this.strikePrevPrev = strikePrevPrev;
	}

	public int getStrikePrev() {
		return strikePrev;
	}

	public void setStrikePrev(int strikePrev) {
		this.strikePrev = strikePrev;
	}

	public Integer[] getTableauLancer() {
		return tableauLancer;
	}

	public Integer getTableauLancerUnique(int number) {
		return tableauLancer[number];
	}
}
