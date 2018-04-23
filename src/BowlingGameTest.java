import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class BowlingGameTest {

    BowlingGame game = new BowlingGame();

    @Test
    public void queDesGoutieresDonne0Points() {
    	int i;        
        for(i=0;i<11;i++){        
            game.roll(0);
        }
        assertEquals(0, game.getScore());
    }

    @Test
    public void uneSeuleQuille(){
        game.roll(1);
        
        assertEquals(1, game.getScore());
    }
    
    @Test
    public void queDesStrikes(){
    	
    	//La partie max se fait en 11 (ou 12) strikes soit 300 points
    	int i;        
        for(i=1;i<12;i++){        
            game.roll(10);
        }
        
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

        game.roll(10);//10 = 183

        game.roll(10);//11 = 213
                
        assertEquals(213, game.getScore());
    }
}
