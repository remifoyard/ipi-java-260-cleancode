import static org.junit.Assert.*;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class BowlingGameTest {

    BowlingGame game = new BowlingGame();

    public void rollMany(int numberRolls, int numberPins) {
        for (int i = 0; i < numberRolls; i++) {
            try {
            	game.roll(numberPins);
            } catch(BowlingException e){
            	
            }
        }
    }
    
    @Test
    public void queDesGoutieresDonne0Points() {
    	rollMany(11,0);
        assertEquals(0, game.getScore());
    }

    @Test
    public void finPartieA20True() {
    	rollMany(9,10);
        game.roll(3);
        game.roll(3);

    	assertTrue(game.getFinPartie());
    }
    
    @Test
    public void finPartieA20False() {
    	rollMany(9,10);
        game.roll(3);
        game.roll(7);

    	assertFalse(game.getFinPartie());
    }

    @Test
    public void finPartieA21True() {
    	rollMany(9,10);
        game.roll(3);
        game.roll(7);
        game.roll(7);

    	assertTrue(game.getFinPartie());
    }

    @Test
    public void finPartieA21True2() {
    	rollMany(9,10);
        game.roll(3);
        game.roll(7);
        game.roll(10);

    	assertTrue(game.getFinPartie());
    }
    
    @Test
    public void finPartieA21False() {
    	rollMany(9,10);
        game.roll(10);
        game.roll(10);

    	assertFalse(game.getFinPartie());
    }

    @Test
    public void finPartieA22True() {
    	rollMany(9,10);
        game.roll(10);
        game.roll(7);
        game.roll(3);

    	assertTrue(game.getFinPartie());
    }

    @Test
    public void finPartieA22True2() {
    	rollMany(9,10);
        game.roll(10);
        game.roll(7);
        game.roll(1);

    	assertTrue(game.getFinPartie());
    }
    
    @Test
    public void finPartieA22False() {
    	rollMany(9,10);
        game.roll(10);
        game.roll(10);

    	assertFalse(game.getFinPartie());
    }

    @Test
    public void finPartieA23True() {
    	rollMany(9,10);
        game.roll(10);
        game.roll(10);
        game.roll(1);

    	assertTrue(game.getFinPartie());
    }

    @Test
    public void finPartieA23True2() {
    	rollMany(9,10);
        game.roll(10);
        game.roll(10);
        game.roll(10);

    	assertTrue(game.getFinPartie());
    }

    @Test
    public void uneSeuleQuille(){
        game.roll(1);
        
        assertEquals(1, game.getScore());
    }
    
    @Test
    public void queDesStrikes(){
    	
    	//La partie max se fait en 12 strikes soit 300 points
    	rollMany(12,10);
        
        assertEquals(300, game.getScore());
    }

    @Test
    public void bonusDuSpare(){
        game.roll(8);
        game.roll(2);
        game.roll(1);
        
        assertEquals(12, game.getScore());
    } 

    @Test
    public void bonusDuStrike(){
        game.roll(8);
        game.roll(0);
        game.roll(10);
        game.roll(1);
        game.roll(5);
        
        assertEquals(30, game.getScore());
    } 

    @Test
    public void bonusDuStrike2Fois(){
        game.roll(8);
        game.roll(0);
        game.roll(10);
        game.roll(1);
        game.roll(5);
        game.roll(10);
        game.roll(2);
        game.roll(7);
        
        assertEquals(58, game.getScore());
    } 

    @Test
    public void bonusDeuxStrikeAlasuite(){
        game.roll(8);
        game.roll(0);
        game.roll(10);
        game.roll(10);
        game.roll(5);
        
        assertEquals(53, game.getScore());
    } 

    @Test
    public void bonusTroisStrikeAlasuite(){
        game.roll(8);
        game.roll(0);
        game.roll(10);
        game.roll(10);
        game.roll(10);
        game.roll(5);
        
        assertEquals(83, game.getScore());
    } 

    @Test
    public void jeuCompletAleatoire(){
        game.roll(8);//1
        game.roll(2);//
        
        game.roll(10);//2 = 30
        
        game.roll(3);//3
        game.roll(5);// = 46
        
        game.roll(5);//4
        game.roll(5);// = 56
        
        game.roll(5);//5
        game.roll(5);// = 71
        
        game.roll(2);//6
        game.roll(8);// = 83
        
        game.roll(10);//7 = 103
        
        game.roll(10);//8 = 123

        game.roll(10);//9 = 153
        
        //Plus de bonus sur les anciens lancer
        game.roll(10);//10 Pour 3 = 162 Pour 10 = 183 Pour 10 = 183

        game.roll(7);//11 Pour 7 = 176 Pour 3 = 189 Pour 10 = 203

        game.roll(3);//12 Pour 5 = 181 Pour 6 = 195 Pour 10 = 213
                
        assertEquals(200, game.getScore());
    }
}
