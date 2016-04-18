import org.junit.Test;

import static org.junit.Assert.*;
public class GameTest {
    @Test
    public void singleFrame() {
        Frame frame = new Frame(2, 4);
        assertEquals("The first throw should equal 2", 2, frame.getFirstThrow());
        assertEquals("The second throw should equal 4", 4, frame.getSecondThrow());
    }

    @Test
    public void singleFrameScore() {
        Frame frame1 = new Frame(2, 6);
        Frame frame2 = new Frame(0, 9);
        assertEquals("The first frame should have a score of 8", 8, frame1.getScore());
        assertEquals("The second frame should have a score of 9", 9, frame2.getScore());
    }

    @Test
    public void gameAmount() {
        Game game = new Game();

        game.addFrame(new Frame(1, 5));
        game.addFrame(new Frame(3, 6));
        game.addFrame(new Frame(7, 2));
        game.addFrame(new Frame(3, 6));
        game.addFrame(new Frame(4, 4));
        game.addFrame(new Frame(5, 3));
        game.addFrame(new Frame(3, 3));
        game.addFrame(new Frame(4, 5));
        game.addFrame(new Frame(8, 1));
        game.addFrame(new Frame(2, 6));

        assertEquals("The game should have 10 frames", 10, game.size());

        // Add a few more frames.
        game.addFrame(new Frame(10));
        game.addFrame(new Frame(10));
        game.addFrame(new Frame(10));

        assertEquals("Adding more than 10 frames should still return 10", 10, game.size());
    }

    @Test
    public void gameScore() {
        Game game = new Game();

        game.addFrame(new Frame(1, 5));
        game.addFrame(new Frame(3, 6));
        game.addFrame(new Frame(7, 2));
        game.addFrame(new Frame(3, 6));
        game.addFrame(new Frame(4, 4));
        game.addFrame(new Frame(5, 3));
        game.addFrame(new Frame(3, 3));
        game.addFrame(new Frame(4, 5));
        game.addFrame(new Frame(8, 1));
        game.addFrame(new Frame(2, 6));

        assertEquals("The game should have a score of 81", 81, game.getScore());
    }

    @Test
    public void strikeFrame() {
        Frame frame = new Frame(10, 5);
        assertTrue("isStrike() should return true", frame.isStrike());
    }

    public void strikeFrameScore() {
        Frame frame = new Frame(10, 5);

        assertEquals("The first score should equal 10", 10, frame.getFirstThrow());
        assertEquals("The second score should equal 0", 0, frame.getSecondThrow());
        assertEquals("getScore() should return 10", 10, frame.getScore());
    }

    @Test
    public void singleStrikeGameScore() {
        Game game = new Game();

        game.addFrame(new Frame(10));
        game.addFrame(new Frame(3, 6));
        game.addFrame(new Frame(7, 2));
        game.addFrame(new Frame(3, 6));
        game.addFrame(new Frame(4, 4));
        game.addFrame(new Frame(5, 3));
        game.addFrame(new Frame(3, 3));
        game.addFrame(new Frame(4, 5));
        game.addFrame(new Frame(8, 1));
        game.addFrame(new Frame(2, 6));

        assertEquals("getScore() should return 94", 94, game.getScore());
    }

    @Test
    public void spareFrame() {
        Frame frame = new Frame(1, 9);
        assertTrue("isSpare() should return true", frame.isSpare());
    }

    @Test
    public void spareFrameScore() {
        Frame frame = new Frame(1, 9);
        assertEquals("getScore() should return 10", 10, frame.getScore());
    }

    @Test
    public void singleSpareGame() {
        Game game = new Game();

        game.addFrame(new Frame(1, 9));
        game.addFrame(new Frame(3, 6));
        game.addFrame(new Frame(7, 2));
        game.addFrame(new Frame(3, 6));
        game.addFrame(new Frame(4, 4));
        game.addFrame(new Frame(5, 3));
        game.addFrame(new Frame(3, 3));
        game.addFrame(new Frame(4, 5));
        game.addFrame(new Frame(8, 1));
        game.addFrame(new Frame(2, 6));

        assertEquals("getScore() should return 88", 88, game.getScore());
    }

    @Test
    public void strikeSpare() {
        Game game = new Game();

        game.addFrame(new Frame(10));
        game.addFrame(new Frame(4, 6));
        game.addFrame(new Frame(7, 2));
        game.addFrame(new Frame(3, 6));
        game.addFrame(new Frame(4, 4));
        game.addFrame(new Frame(5, 3));
        game.addFrame(new Frame(3, 3));
        game.addFrame(new Frame(4, 5));
        game.addFrame(new Frame(8, 1));
        game.addFrame(new Frame(2, 6));

        assertEquals("getScore() should return 103", 103, game.getScore());
    }

    @Test
    public void multipleStrikes() {
        Game game = new Game();

        game.addFrame(new Frame(10));
        game.addFrame(new Frame(10));
        game.addFrame(new Frame(7, 2));
        game.addFrame(new Frame(3, 6));
        game.addFrame(new Frame(4, 4));
        game.addFrame(new Frame(5, 3));
        game.addFrame(new Frame(3, 3));
        game.addFrame(new Frame(4, 5));
        game.addFrame(new Frame(8, 1));
        game.addFrame(new Frame(2, 6));

        assertEquals("getScore() should return 112", 112, game.getScore());
    }

    @Test
    public void multipleSpares() {
        Game game = new Game();

        game.addFrame(new Frame(8, 2));
        game.addFrame(new Frame(5, 5));
        game.addFrame(new Frame(7, 2));
        game.addFrame(new Frame(3, 6));
        game.addFrame(new Frame(4, 4));
        game.addFrame(new Frame(5, 3));
        game.addFrame(new Frame(3, 3));
        game.addFrame(new Frame(4, 5));
        game.addFrame(new Frame(8, 1));
        game.addFrame(new Frame(2, 6));

        assertEquals("getScore() should return 98", 98, game.getScore());
    }

    @Test
    public void lastSpareFrame() {
        Game game = new Game();

        game.addFrame(new Frame(1, 5));
        game.addFrame(new Frame(3, 6));
        game.addFrame(new Frame(7, 2));
        game.addFrame(new Frame(3, 6));
        game.addFrame(new Frame(4, 4));
        game.addFrame(new Frame(5, 3));
        game.addFrame(new Frame(3, 3));
        game.addFrame(new Frame(4, 5));
        game.addFrame(new Frame(8, 1));
        game.addFrame(new Frame(2, 8));

        game.addBonusFrame(new Frame(7));

        assertEquals("getScore() should return 90", 90, game.getScore());
    }

    @Test
    public void lastStrikeFrame() {
        Game game = new Game();

        game.addFrame(new Frame(1, 5));
        game.addFrame(new Frame(3, 6));
        game.addFrame(new Frame(7, 2));
        game.addFrame(new Frame(3, 6));
        game.addFrame(new Frame(4, 4));
        game.addFrame(new Frame(5, 3));
        game.addFrame(new Frame(3, 3));
        game.addFrame(new Frame(4, 5));
        game.addFrame(new Frame(8, 1));
        game.addFrame(new Frame(10));

        game.addBonusFrame(new Frame(7, 2));

        assertEquals("getScore() should return 92", 92, game.getScore());
    }

    @Test
    public void bonusIsAStrike() {
        Game game = new Game();

        game.addFrame(new Frame(1, 5));
        game.addFrame(new Frame(3, 6));
        game.addFrame(new Frame(7, 2));
        game.addFrame(new Frame(3, 6));
        game.addFrame(new Frame(4, 4));
        game.addFrame(new Frame(5, 3));
        game.addFrame(new Frame(3, 3));
        game.addFrame(new Frame(4, 5));
        game.addFrame(new Frame(8, 1));
        game.addFrame(new Frame(2, 8));

        game.addBonusFrame(new Frame(10));

        assertEquals("getScore() should return 93", 93, game.getScore());

        // Resetting of the bonus frame
        game.addBonusFrame(new Frame(1,1));

        assertEquals("Resetting the bonus frame should stil return 93", 93, game.getScore());
    }

    @Test
    public void bestScore() {
        Game game = new Game();

        for (int i = 0; i < 10; i++) {
            game.addFrame(new Frame(10));
        }

        game.addBonusFrame(new Frame(10, 10));
        assertEquals("getScore() should return 300", 300, game.getScore());
    }

    @Test
    public void realGame() {
        Game game = new Game();

        game.addFrame(new Frame(6, 3));
        game.addFrame(new Frame(7, 1));
        game.addFrame(new Frame(8, 2));
        game.addFrame(new Frame(7, 2));
        game.addFrame(new Frame(10));
        game.addFrame(new Frame(6, 2));
        game.addFrame(new Frame(7, 3));
        game.addFrame(new Frame(10));
        game.addFrame(new Frame(8, 0));
        game.addFrame(new Frame(7, 3));

        game.addBonusFrame(new Frame(10));
        assertEquals("getScore() should return 135", 135, game.getScore());
    }
}