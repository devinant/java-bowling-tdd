public class Frame {
    private int firstThrow;
    private int secondThrow;

    /**
     * Default constructor. No pins are knocked down in either throw.
     */
    public Frame() {
        this(0, 0);
    }

    /**
     * A constructor for the first throw.
     * @param firstThrow    amount of knocked down in the first throw
     */
    public Frame(int firstThrow) {
        this.setFirstThrow(firstThrow);
    }

    /**
     * A constructor for both first and second throw.
     * @param firstThrow    amount of knocked down pins in the first throw
     * @param secondThrow   amount of knocked down pins in the second throw
     */
    public Frame(int firstThrow, int secondThrow) {
        this.setFirstThrow(firstThrow);
        this.setSecondThrow(secondThrow);
    }

    /**
     * Set the amount of pins knocked down in the first throw
     * @param value knocked down pins in the first throw
     */
    public void setFirstThrow(int value) {
        this.firstThrow = value;
    }

    /**
     * Set the amount of pins knocked down in the second throw
     * @param value knocked down pins in the second throw
     */
    public void setSecondThrow(int value) {
        this.secondThrow = value;
    }

    /**
     * @return  the amount of pins knocked down in the first throw
     */
    public int getFirstThrow() {
        return firstThrow;
    }

    /**
     * @return  the amount of pins knocked down in the second throw
     */
    public int getSecondThrow() {
        return secondThrow;
    }

    /**
     * @return  the sum of both scores in the frame
     */
    public int getScore() {
        return this.firstThrow + this.secondThrow;
    }

    /**
     * If the first throw is 10, then this is a strike.
     * @return true when a frame is a strike
     */
    public boolean isStrike() {
        return this.firstThrow == 10;
    }

    /**
     * Check whether a Frame is a spare or not. A frame is a spare
     * when its total score is 10. The first throw cannot be 10.
     * @return true when a frame is a spare
     */
    public boolean isSpare() {
        return !this.isStrike() && this.getScore() == 10;
    }

    @Override
    public String toString() {
        return String.format("[%d, %d]", this.firstThrow, this.secondThrow);
    }
}
