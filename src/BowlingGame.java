public class BowlingGame {

	private int numLance = 0;
    private int score = 0;
    
    private int strikePrevPrev = 0;
    private int strikePrev = 0;
    
    private int prevScorePrecedent = 0;
    private int prevLancer1 = 0;
    private int prevLancer2 = 0;

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Boolean checkSparePrev(){
		if(getPrevLancer1() < 10 && (getPrevLancer1() + getPrevLancer2()) == 10 ){
			return true;
		}
		else return false;
	}
	
	public Boolean checkStrikePrev(){
		if(getStrikePrev() == 10){
			return true;
		}
		else return false;
	}

	public Boolean checkStrikePrevPrev(){
		if(getStrikePrevPrev() == 10){
			return true;
		}
		else return false;
	}
	
	public void roll(int numberPins) {
		
		setNumLance(getNumLance() + 1);

		
		//Si impair c'est le premier lancé sur les deux
		if(getNumLance() % 2 == 1){
			//Si 2 strike avant alors on multiplie par 3 le nombre de quille actuel
			if(checkStrikePrevPrev() == true && checkStrikePrev() == true){
				setScore(getScore() + (numberPins * 3));
			}
			//Si 1 strike ou SPARE avant alors on multiplie par 2 le nombre de quille actuel
			else if(checkSparePrev() == true || checkStrikePrev() == true){
				setScore(getScore() + (numberPins * 2));
			}
			else{				
				setScore(getScore() + numberPins);
			}

			
			
			setPrevLancer1(numberPins);
			

			
			//Si on a fait un strike il n'y a pas de 2eme lancé donc on incrémente de 1 le compteur de lancé
			if(numberPins == 10){
				setNumLance(getNumLance() + 1);
				
				//Si strike précédent déja a 10 On sauvegarde un strike précédent précédent a 10
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
		//Sinon si pair c'est le deuxieme lancé
		else{
			
			if(checkStrikePrev() == true){
				setScore(getScore() + (numberPins * 2));
				setStrikePrevPrev(0);
				setStrikePrev(0);
			}
			else{
				setScore(getScore() + numberPins);
			}
			setPrevLancer2(numberPins);
		}
		
    }

    public void rollMany(int numberRolls, int numberPins) {
        for (int i = 0; i < numberRolls; i++) {
            roll(numberPins);
        }
    }

	public int getPrevScorePrecedent() {
		return prevScorePrecedent;
	}

	public void setPrevScorePrecedent(int prevScorePrecedent) {
		this.prevScorePrecedent = prevScorePrecedent;
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
}
