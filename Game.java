import java.util.*;

/**
 * The game class calculates scores using {@link Frame} class. It does not
 * keep track of the state of the game.
 */
public class Game {
    private List<Frame> frames;
    private Frame bonus;

    public Game() {
        this.frames = new ArrayList<Frame>();
    }


    /**
     * Adds a normal frame to the game. If the number exceeds 10, no new
     * frames will be added.
     *
     * @param frame the frame to add
     */
    public void addFrame(Frame frame) {
        if (this.size() < 10) {
            this.frames.add(frame);
        }
    }

    /**
     * Adds a bonus frame to the game. The bonus frame cannot be
     * reset once its already set.
     *
     * @param frame the bonus frame
     */
    public void addBonusFrame(Frame frame) {
        if (this.bonus == null) {
            this.bonus = frame;
        }
    }


    /**
     * Computes the score of a game based on the iterator by looking back
     * on the previous value.
     * @param it    the iterator containing all the current frames
     * @return a number for the score
     */
    private int computeSequenceScore(ListIterator<Frame> it) {
        if (it.hasPrevious() && it.hasNext()) {
            Frame previousFrame = this.frames.get(it.previousIndex());
            Frame nextFrame = this.frames.get(it.nextIndex());

            if (previousFrame.isStrike()) {
                if (nextFrame.isStrike()) {
                    try {
                        // Attempt to calculate the value of the first, second
                        // and a third frame. This occurs when there are multiple
                        // strikes
                        return nextFrame.getScore() + this.frames.get(it.nextIndex() + 1).getFirstThrow();
                    } catch(IndexOutOfBoundsException e) {
                        // If the exception is raised, then this is the last
                        // frame (probably a bonus throw). The value is
                        // strike * 2 (since both prev. and next equals 10)
                        return nextFrame.getScore() * 2;
                    }
                }

                // Sum of the next throws
                return nextFrame.getScore();
            } else if (previousFrame.isSpare()) {
                return nextFrame.getFirstThrow();
            }
        }

        return 0;
    }


    /**
     * Computes the bonus score of a game only if the last frame
     * is a strike or a spare and the bonus score is set.
     *
     * @param lastFrame the last frame that was played
     * @return 0 if the last frame was not a strike or spare.
     */
    private int computeBonusScore(Frame lastFrame) {
        if (lastFrame != null && (lastFrame.isSpare() || lastFrame.isStrike())) {
            return this.bonus == null ? 0 : this.bonus.getScore();
        }

        return 0;
    }


    /**
     * @return the total score of a game
     */
    public int getScore() {
        int score = 0;
        Frame lastFrame = null;
        ListIterator<Frame> it = this.frames.listIterator();

        while(it.hasNext()) {
            lastFrame = it.next();
            score += lastFrame.getScore() + this.computeSequenceScore(it);
        }

        return score + this.computeBonusScore(lastFrame);
    }


    /**
     * @return  the amount of frames in a game.
     */
    public int size() {
        return this.frames.size();
    }
}
