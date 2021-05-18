package es.upm.grise;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;


public class MeasurementBowlingScoreKeeper {

	@Test
	public void testEmptyFrameIsCreated() {
		Frame f = new Frame();
		assertNotNull(f);
	}

	@Test
	public void testFrameWithScoreIsCreated() throws InvalidInput {
		Frame f = new Frame(1,2);
		assertNotNull(f);
	}
	
	@Test
	public void testFrameIsCreatedWithCorrectName(){
		Frame f  = new Frame();
		assertEquals("Frame", f.getClass().getSimpleName());
	}
	
	@Test
	public void testFrameScore() throws InvalidInput  {
		Frame f = new Frame(2,4);
		assertEquals(6, f.score());
		
		f = new Frame(0,0);
		assertEquals(0, f.score());
	}
	@Test
	public void testAllPinsFrameScore() throws InvalidInput {
		Frame f = new Frame(10,0);
		assertEquals(10, f.score());
	}
	
	// Commented by Oscar
	// Exceptions are not taught neither enforced in the experiment
	@Ignore
	@Test
	public void testExceptionMoreThan10PinsPerFrame() throws InvalidInput {
		Frame f = new Frame(12,12);
		f.score();
	}
	
	@Test
	public void testGameWithFramesIsCreated() throws InvalidInput{
		BowlingGame game = new BowlingGame();
		for (int i = 1; i < 11; i++) {
			game.addFrame(new Frame(i,i));
		}
		
		assertNotNull(game);
	}
	
	@Test
	public void testEmptyGameIsCreated(){
		BowlingGame game = new BowlingGame();
		assertNotNull(game);
	}
	
	// Commented by Oscar
	// Class name is irrelevant in the context of our experiment
	@Ignore
	@Test 
	public void testGameObjectIsCreated(){
		BowlingGame game = new BowlingGame();
		assertEquals("BowlingGame", game.getClass().getSimpleName());
	
	}
	
	@Test
	public void testAddFrame() throws InvalidInput  {
		BowlingGame game = new BowlingGame();
		Frame frame1 = new Frame(1, 0);
		game.addFrame(frame1);
		
		Frame frameTest = new Frame(frame1.getThrow1(), frame1.getThrow2());
	
		assertEquals(frame1.getThrow1(), frameTest.getThrow1());
		assertEquals(frame1.getThrow2(), frameTest.getThrow2());
	}

	@Test
	public void testGetFrame() throws InvalidInput {
		BowlingGame game = new BowlingGame();
		Frame frame1 = new Frame(1, 2);
		Frame frame2 = new Frame(5, 4);
		Frame frame3 = new Frame(4, 3);
		game.addFrame(frame1);
		game.addFrame(frame2);
		game.addFrame(frame3);
		assertEquals(frame1.getThrow1(), new Frame(frame1.getThrow1(), frame1.getThrow2()).getThrow1());
		assertEquals(frame1.getThrow2(), new Frame(frame1.getThrow1(), frame1.getThrow2()).getThrow2());
		
		assertEquals(frame2.getThrow1(), new Frame(frame2.getThrow1(), frame2.getThrow2()).getThrow1());
		assertEquals(frame2.getThrow2(), new Frame(frame2.getThrow1(), frame2.getThrow2()).getThrow2());
		
		assertEquals(frame3.getThrow1(), new Frame(frame3.getThrow1(), frame3.getThrow2()).getThrow1());
		assertEquals(frame3.getThrow2(), new Frame(frame3.getThrow1(), frame3.getThrow2()).getThrow2());
	}
	
	// Commented by Oscar
	// No reason for the try-catch block. I'd remove it
	@Test
	public void testGameScore() throws InvalidInput, BowlingException{
		BowlingGame game = new BowlingGame();
		
		try {
			game.addFrame(new Frame(1, 2));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		assertEquals(3, game.score());
		
		game.addFrame(new Frame(2, 3));
		assertEquals(8, game.score());
		
		game.addFrame(new Frame(5, 4));
		assertEquals(17, game.score());
	}
	
	@Test
	public void testStartWithAStrikeForm() throws InvalidInput, BowlingException {
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(10,0));
		game.addFrame(new Frame(2,0));
		game.addFrame(new Frame(0,0));
		game.addFrame(new Frame(4,2));
		game.addFrame(new Frame(8,0));
		game.addFrame(new Frame(2,3));
		game.addFrame(new Frame(1,3));
		game.addFrame(new Frame(1,6));
		game.addFrame(new Frame(2,0));
		game.addFrame(new Frame(5,1));
		
		assertEquals(52, game.score());
	}
	@Test
	public void testStartWithAStrikeContent() throws InvalidInput, BowlingException {
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(10,0));
		game.addFrame(new Frame(2,5));
		game.addFrame(new Frame(0,0));
		game.addFrame(new Frame(4,2));
		game.addFrame(new Frame(8,0));
		game.addFrame(new Frame(2,3));
		game.addFrame(new Frame(1,3));
		game.addFrame(new Frame(1,6));
		game.addFrame(new Frame(2,0));
		game.addFrame(new Frame(5,1));
		
		assertEquals(62, game.score());
	}
	@Test
	public void testStrikeInTheMiddleForm() throws InvalidInput, BowlingException {
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(4,5));
		game.addFrame(new Frame(2,4));
		game.addFrame(new Frame(10,0));
		game.addFrame(new Frame(1,8));
		game.addFrame(new Frame(0,5));
		game.addFrame(new Frame(2,3));
		game.addFrame(new Frame(1,3));
		game.addFrame(new Frame(1,6));
		game.addFrame(new Frame(2,0));
		game.addFrame(new Frame(5,1));
		
		assertEquals(72, game.score());
	}
	@Test
	public void testStrikeInTheMiddleContent() throws InvalidInput, BowlingException   {
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(5,1));
		game.addFrame(new Frame(7,2));
		game.addFrame(new Frame(10,0));
		game.addFrame(new Frame(9,0));
		game.addFrame(new Frame(0,5));
		game.addFrame(new Frame(2,3));
		game.addFrame(new Frame(1,3));
		game.addFrame(new Frame(1,6));
		game.addFrame(new Frame(2,0));
		game.addFrame(new Frame(5,1));
		
		assertEquals(72, game.score());
	}
	@Test
	public void testSingleStrikeZeroContentsForm() throws InvalidInput, BowlingException  {
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(10,0));
		game.addFrame(new Frame(0,0));
		game.addFrame(new Frame(0,0));
		game.addFrame(new Frame(4,2));
		game.addFrame(new Frame(8,0));
		game.addFrame(new Frame(2,3));
		game.addFrame(new Frame(1,3));
		game.addFrame(new Frame(1,6));
		game.addFrame(new Frame(2,0));
		game.addFrame(new Frame(5,1));
		
		assertEquals(48, game.score());
	}
	
	@Test
	public void testStartWithASpareForm() throws InvalidInput, BowlingException   {
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(5,5));
		game.addFrame(new Frame(2,5));
		game.addFrame(new Frame(1,1));
		game.addFrame(new Frame(4,2));
		game.addFrame(new Frame(8,0));
		game.addFrame(new Frame(2,3));
		game.addFrame(new Frame(1,3));
		game.addFrame(new Frame(1,6));
		game.addFrame(new Frame(2,0));
		game.addFrame(new Frame(5,1));
		
		assertEquals(59, game.score());
	}
	@Test
	public void testStartWithASpareContent() throws InvalidInput, BowlingException   {
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(4,6));
		game.addFrame(new Frame(2,5));
		game.addFrame(new Frame(0,0));
		game.addFrame(new Frame(4,2));
		game.addFrame(new Frame(8,0));
		game.addFrame(new Frame(2,3));
		game.addFrame(new Frame(1,3));
		game.addFrame(new Frame(1,6));
		game.addFrame(new Frame(2,0));
		game.addFrame(new Frame(5,1));
		
		assertEquals(57, game.score());
	}
	@Test
	public void testSpareWithFirstThrowZeroForm() throws InvalidInput, BowlingException   {
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(0,10));
		game.addFrame(new Frame(2,4));
		game.addFrame(new Frame(5,5));
		game.addFrame(new Frame(1,8));
		game.addFrame(new Frame(0,5));
		game.addFrame(new Frame(2,3));
		game.addFrame(new Frame(1,3));
		game.addFrame(new Frame(1,6));
		game.addFrame(new Frame(2,0));
		game.addFrame(new Frame(5,1));
		
		assertEquals(67, game.score());
	}
	@Test
	public void testSpareInTheMiddleForm() throws InvalidInput, BowlingException   {
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(4,5));
		game.addFrame(new Frame(2,4));
		game.addFrame(new Frame(5,5));
		game.addFrame(new Frame(1,8));
		game.addFrame(new Frame(0,5));
		game.addFrame(new Frame(2,3));
		game.addFrame(new Frame(1,3));
		game.addFrame(new Frame(1,6));
		game.addFrame(new Frame(2,0));
		game.addFrame(new Frame(5,1));
	
		assertEquals(64, game.score());
	}
	@Test
	public void testSpareInTheMiddleContent() throws InvalidInput, BowlingException   {
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(5,1));
		game.addFrame(new Frame(7,2));
		game.addFrame(new Frame(0,10));
		game.addFrame(new Frame(0,1));
		game.addFrame(new Frame(0,5));
		game.addFrame(new Frame(2,3));
		game.addFrame(new Frame(1,3));
		game.addFrame(new Frame(1,6));
		game.addFrame(new Frame(2,0));
		game.addFrame(new Frame(5,1));
		
		assertEquals(55, game.score());
	}

	@Test
	public void testSingleSpareZeroBonusForm() throws InvalidInput, BowlingException   {
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(5,5));
		game.addFrame(new Frame(0,0));
		game.addFrame(new Frame(1,1));
		game.addFrame(new Frame(4,2));
		game.addFrame(new Frame(8,0));
		game.addFrame(new Frame(2,3));
		game.addFrame(new Frame(1,3));
		game.addFrame(new Frame(1,6));
		game.addFrame(new Frame(2,0));
		game.addFrame(new Frame(5,1));
		
		assertEquals(50, game.score());
	}
	
	@Test
	public void testSpareAfterStrikeAtTheBeginningForm() throws InvalidInput, BowlingException   {
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(10,0));
		game.addFrame(new Frame(2,8));
		game.addFrame(new Frame(1,0));
		game.addFrame(new Frame(4,2));
		game.addFrame(new Frame(8,0));
		game.addFrame(new Frame(2,3));
		game.addFrame(new Frame(1,3));
		game.addFrame(new Frame(1,6));
		game.addFrame(new Frame(2,0));
		game.addFrame(new Frame(5,1));
	
		assertEquals(70, game.score());
	}
	@Test
	public void testSpareAfterStrikeAtTheBeginningContent() throws InvalidInput, BowlingException  {
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(10,0));
		game.addFrame(new Frame(0,10));
		game.addFrame(new Frame(1,2));
		game.addFrame(new Frame(4,2));
		game.addFrame(new Frame(8,0));
		game.addFrame(new Frame(2,3));
		game.addFrame(new Frame(1,3));
		game.addFrame(new Frame(1,6));
		game.addFrame(new Frame(2,0));
		game.addFrame(new Frame(5,1));
		
		assertEquals(72, game.score());
	}
	@Test
	public void testSpareAfterStrikeInTheMiddleForm() throws InvalidInput, BowlingException   {
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(4,5));
		game.addFrame(new Frame(10,0));
		game.addFrame(new Frame(10,0));
		game.addFrame(new Frame(1,9));
		game.addFrame(new Frame(3,7));
		game.addFrame(new Frame(2,3));
		game.addFrame(new Frame(1,3));
		game.addFrame(new Frame(1,6));
		game.addFrame(new Frame(2,0));
		game.addFrame(new Frame(5,1));
		
		assertEquals(99, game.score());
	}
	@Test
	public void testSpareAfterStrikeInTheMiddleContent() throws InvalidInput, BowlingException   {
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(3,5));
		game.addFrame(new Frame(10,0));
		game.addFrame(new Frame(10,0));
		game.addFrame(new Frame(1,9));
		game.addFrame(new Frame(2,5));
		game.addFrame(new Frame(2,3));
		game.addFrame(new Frame(1,3));
		game.addFrame(new Frame(1,6));
		game.addFrame(new Frame(2,0));
		game.addFrame(new Frame(5,1));
		
		assertEquals(92, game.score());
	}
	@Test
	public void testSpareAfterStrikeInTheMiddleZeroBoniForm() throws InvalidInput, BowlingException   {
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(1,5));
		game.addFrame(new Frame(10,0));
		game.addFrame(new Frame(2,8));
		game.addFrame(new Frame(0,0));
		game.addFrame(new Frame(0,0));
		game.addFrame(new Frame(0,0));
		game.addFrame(new Frame(1,3));
		game.addFrame(new Frame(1,6));
		game.addFrame(new Frame(2,0));
		game.addFrame(new Frame(5,1));

		assertEquals(55, game.score());
	}
	@Test
	public void testSpareAfterStrikeInTheMiddleZeroBoniContent() throws InvalidInput, BowlingException   {
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(1,5));
		game.addFrame(new Frame(10,0));
		game.addFrame(new Frame(1,9));
		game.addFrame(new Frame(0,0));
		game.addFrame(new Frame(0,0));
		game.addFrame(new Frame(1,4));
		game.addFrame(new Frame(1,3));
		game.addFrame(new Frame(1,6));
		game.addFrame(new Frame(2,0));
		game.addFrame(new Frame(5,1));
		
		assertEquals(60, game.score());
	}
	@Test
	public void testSpareAfterStrikeAtTheBeginningZeroBoniContent() throws InvalidInput, BowlingException   {
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(10,0));
		game.addFrame(new Frame(2,8));
		game.addFrame(new Frame(0,0));
		game.addFrame(new Frame(4,2));
		game.addFrame(new Frame(8,0));
		game.addFrame(new Frame(2,3));
		game.addFrame(new Frame(1,3));
		game.addFrame(new Frame(1,6));
		game.addFrame(new Frame(2,0));
		game.addFrame(new Frame(5,1));
		
		assertEquals(68, game.score());
	}

	@Test
	public void testDoubleStrikeDoubleSpareForm() throws InvalidInput, BowlingException   {
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(10,0));
		game.addFrame(new Frame(10,0));
		game.addFrame(new Frame(0,10));
		game.addFrame(new Frame(2,8));
		game.addFrame(new Frame(1,3));
		game.addFrame(new Frame(2,3));
		game.addFrame(new Frame(1,3));
		game.addFrame(new Frame(1,6));
		game.addFrame(new Frame(2,0));
		game.addFrame(new Frame(5,1));
		
		assertEquals(91, game.score());
	}
	
	public void testStrikeAfterSpareAtTheBeginningForm() throws InvalidInput, BowlingException   {
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(2,8));
		game.addFrame(new Frame(10,0));
		game.addFrame(new Frame(1,0));
		game.addFrame(new Frame(4,2));
		game.addFrame(new Frame(8,0));
		game.addFrame(new Frame(2,3));
		game.addFrame(new Frame(1,3));
		game.addFrame(new Frame(1,6));
		game.addFrame(new Frame(2,0));
		game.addFrame(new Frame(5,1));
		
		assertEquals(70, game.score());
	}

	public void testStrikeAfterSpareAtTheBeginningContent() throws InvalidInput, BowlingException   {
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(0,10));
		game.addFrame(new Frame(10,0));
		game.addFrame(new Frame(1,2));
		game.addFrame(new Frame(4,2));
		game.addFrame(new Frame(8,0));
		game.addFrame(new Frame(2,3));
		game.addFrame(new Frame(1,3));
		game.addFrame(new Frame(1,6));
		game.addFrame(new Frame(2,0));
		game.addFrame(new Frame(5,1));
		
		assertEquals(74, game.score());
	}
	
	public void testStrikeAfterSpareInTheMiddleForm() throws InvalidInput, BowlingException   {
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(4,5));
		game.addFrame(new Frame(2,4));
		game.addFrame(new Frame(3,7));
		game.addFrame(new Frame(10,0));
		game.addFrame(new Frame(2,6));
		game.addFrame(new Frame(2,3));
		game.addFrame(new Frame(1,3));
		game.addFrame(new Frame(1,6));
		game.addFrame(new Frame(2,0));
		game.addFrame(new Frame(5,1));
		
		assertEquals(85, game.score());
	}
	
	public void testStrikeAfterSpareInTheMiddleContent() throws InvalidInput, BowlingException   {
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(5,1));
		game.addFrame(new Frame(7,2));
		game.addFrame(new Frame(1,7));
		game.addFrame(new Frame(1,9));
		game.addFrame(new Frame(10,0));
		game.addFrame(new Frame(2,3));
		game.addFrame(new Frame(1,3));
		game.addFrame(new Frame(1,6));
		game.addFrame(new Frame(2,0));
		game.addFrame(new Frame(5,1));
		
		assertEquals(82, game.score());
	}

	public void testStrikeAfterSpareAtTheBeginningZeroBoniContent() throws InvalidInput, BowlingException   {
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(2,8));
		game.addFrame(new Frame(10,0));
		game.addFrame(new Frame(0,0));
		game.addFrame(new Frame(4,2));
		game.addFrame(new Frame(8,0));
		game.addFrame(new Frame(2,3));
		game.addFrame(new Frame(1,3));
		game.addFrame(new Frame(1,6));
		game.addFrame(new Frame(2,0));
		game.addFrame(new Frame(5,1));
		
		assertEquals(68, game.score());
	}

	public void testStrikeAfterSpareAtTheBeginningZeroBoniForm() throws InvalidInput, BowlingException   {
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(1,9));
		game.addFrame(new Frame(10,0));
		game.addFrame(new Frame(0,0));
		game.addFrame(new Frame(4,2));
		game.addFrame(new Frame(8,0));
		game.addFrame(new Frame(2,3));
		game.addFrame(new Frame(1,3));
		game.addFrame(new Frame(1,6));
		game.addFrame(new Frame(2,0));
		game.addFrame(new Frame(5,1));
		
		assertEquals(68, game.score());
		
	}
	
	public void testDoubleSpareDoubleStrikeForm() throws InvalidInput, BowlingException   {
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(1,9));
		game.addFrame(new Frame(2,8));
		game.addFrame(new Frame(10,0));
		game.addFrame(new Frame(10,0));
		game.addFrame(new Frame(1,0));
		game.addFrame(new Frame(2,3));
		game.addFrame(new Frame(1,3));
		game.addFrame(new Frame(1,6));
		game.addFrame(new Frame(2,0));
		game.addFrame(new Frame(5,1));
		
		assertEquals(89, game.score());
	}

	public void testDoubleSpareDoubleStrikeContent() throws InvalidInput, BowlingException   {
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(1,9));
		game.addFrame(new Frame(2,8));
		game.addFrame(new Frame(10,0));
		game.addFrame(new Frame(10,0));
		game.addFrame(new Frame(1,3));
		game.addFrame(new Frame(2,3));
		game.addFrame(new Frame(1,3));
		game.addFrame(new Frame(1,6));
		game.addFrame(new Frame(2,0));
		game.addFrame(new Frame(5,1));
		
		assertEquals(95, game.score());
	}
	
	@Test
	public void testStartWithAMultipleStrikesForm() throws InvalidInput, BowlingException   {
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(10,0)); //1
		game.addFrame(new Frame(10,0)); //2
		game.addFrame(new Frame(0,0)); //3
		game.addFrame(new Frame(4,2)); //4
		game.addFrame(new Frame(8,0)); //5
		game.addFrame(new Frame(2,3)); //6
		game.addFrame(new Frame(1,3)); //7
		game.addFrame(new Frame(1,6)); //8
		game.addFrame(new Frame(2,0)); //9
		game.addFrame(new Frame(5,1)); //10
		assertEquals(68	,game.score());
	}
	
	// Commented by Oscar
	// FIXED (the score was 74 instead of the correct 75)
	@Test
	public void testStartWithAMultipleStrikesContent() throws InvalidInput, BowlingException   {
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(10,0)); //1
		game.addFrame(new Frame(10,0)); //2
		game.addFrame(new Frame(1,2)); //3
		game.addFrame(new Frame(4,2)); //4
		game.addFrame(new Frame(8,0)); //5
		game.addFrame(new Frame(2,3)); //6
		game.addFrame(new Frame(1,3)); //7
		game.addFrame(new Frame(1,6)); //8
		game.addFrame(new Frame(2,0)); //9
		game.addFrame(new Frame(5,1)); //10
		
		assertEquals(75, game.score());
	}
	@Test
	public void testMultipleStrikesInTheMiddleForm() throws InvalidInput, BowlingException   {
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(4,5)); //1
		game.addFrame(new Frame(2,4)); //2
		game.addFrame(new Frame(10,0)); //3
		game.addFrame(new Frame(10,0)); //4
		game.addFrame(new Frame(10,0)); //5
		game.addFrame(new Frame(2,3)); //6
		game.addFrame(new Frame(1,3)); //7
		game.addFrame(new Frame(1,6)); //8
		game.addFrame(new Frame(2,0)); //9
		game.addFrame(new Frame(5,1)); //10
	
		assertEquals(106, game.score());
	}
	@Test
	public void testMultipleStrikeInTheMiddleContent() throws InvalidInput, BowlingException   {
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(5,1)); //1
		game.addFrame(new Frame(7,2)); //2
		game.addFrame(new Frame(10,0)); //3
		game.addFrame(new Frame(10,0)); //4
		game.addFrame(new Frame(10,0)); //5
		game.addFrame(new Frame(2,3)); //6
		game.addFrame(new Frame(1,3)); //7
		game.addFrame(new Frame(1,6)); //8
		game.addFrame(new Frame(2,0)); //9
		game.addFrame(new Frame(5,1)); //10
		assertEquals(106, game.score());
	}
	@Test
	public void testMultipleStrikeInTheMiddleZeroBoniForm() throws InvalidInput, BowlingException   {
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(1,5)); //1
		game.addFrame(new Frame(1,4)); //2
		game.addFrame(new Frame(10,0)); //3
		game.addFrame(new Frame(10,0)); //4
		game.addFrame(new Frame(10,0)); //5
		game.addFrame(new Frame(0,0)); //6
		game.addFrame(new Frame(1,3)); //7
		game.addFrame(new Frame(1,6)); //8
		game.addFrame(new Frame(2,0)); //9
		game.addFrame(new Frame(5,1)); //10
		
		assertEquals(90, game.score()); //80
	}
	
	@Test
	public void testStartWithMultipleSpareForm() throws InvalidInput, BowlingException   {
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(5, 5)); //1
		game.addFrame(new Frame(1, 9)); //2
		game.addFrame(new Frame(1, 1)); //3
		game.addFrame(new Frame(4, 2)); //4
		game.addFrame(new Frame(8, 0)); //5
		game.addFrame(new Frame(2, 3)); //6
		game.addFrame(new Frame(1, 3)); //7
		game.addFrame(new Frame(1, 6)); //8
		game.addFrame(new Frame(2, 0)); //9
		game.addFrame(new Frame(5, 1)); //10
		
		assertEquals(62, game.score());
	}
	@Test
	public void testStartWithMultipleSpareContent() throws InvalidInput, BowlingException   {
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(4, 6)); //1
		game.addFrame(new Frame(3, 7)); //2
		game.addFrame(new Frame(0, 10)); //3
		game.addFrame(new Frame(4, 2)); //4
		game.addFrame(new Frame(8, 0)); //5
		game.addFrame(new Frame(2, 3)); //6
		game.addFrame(new Frame(1, 3)); //7
		game.addFrame(new Frame(1, 6)); //8
		game.addFrame(new Frame(2, 0)); //9
		game.addFrame(new Frame(5, 1)); //10
		
		assertEquals(75, game.score());
	}
	@Test
	public void testMultipleSpareInTheMiddle() throws InvalidInput, BowlingException   {
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(1, 5)); //1
		game.addFrame(new Frame(1, 4)); //2
		game.addFrame(new Frame(4, 6)); //3
		game.addFrame(new Frame(4, 6)); //4
		game.addFrame(new Frame(0, 10)); //5
		game.addFrame(new Frame(1, 9)); //6
		game.addFrame(new Frame(1, 3)); //7
		game.addFrame(new Frame(1, 6)); //8
		game.addFrame(new Frame(2, 0)); //9
		game.addFrame(new Frame(5, 1)); //10
		
		assertEquals(76, game.score());
	}
	@Test
	public void testMultipleSpareInTheMiddleForm() throws InvalidInput, BowlingException   {
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(5, 5)); //1
		game.addFrame(new Frame(1, 9)); //2
		game.addFrame(new Frame(1, 1)); //3
		game.addFrame(new Frame(4, 2)); //4
		game.addFrame(new Frame(8, 0)); //5
		game.addFrame(new Frame(2, 3)); //6
		game.addFrame(new Frame(1, 3)); //7
		game.addFrame(new Frame(1, 6)); //8
		game.addFrame(new Frame(2, 0)); //9
		game.addFrame(new Frame(5, 1)); //10
		
		assertEquals(62, game.score());
	}
	@Test
	public void testMultipleSpareInTheMiddleContent() throws InvalidInput, BowlingException   {
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(5, 1)); //1
		game.addFrame(new Frame(7, 2)); //2
		game.addFrame(new Frame(0, 10)); //3
		game.addFrame(new Frame(4, 6)); //4
		game.addFrame(new Frame(0, 5)); //5
		game.addFrame(new Frame(2, 3)); //6
		game.addFrame(new Frame(1, 3)); //7
		game.addFrame(new Frame(1, 6)); //8
		game.addFrame(new Frame(2, 0)); //9
		game.addFrame(new Frame(5, 1)); //10
		
		assertEquals(68, game.score());
	}
	
	// Commented by Oscar
	// This test is wrong according to the specification because the bonus is not a frame
	// If we admit there are 2 possible ways to set the bonus, the following code
	// will be preferable
	// FIXED (bonus throws can be set using either addFrame and setBonus)
	@Test
	public void testLastSpareForm() throws InvalidInput, BowlingException   {
		BowlingGame game1 = new BowlingGame();
		BowlingGame game2 = new BowlingGame();
		
		game1.addFrame(new Frame(1, 5)); //1
		game1.addFrame(new Frame(2, 5)); //2
		game1.addFrame(new Frame(1, 1)); //3
		game1.addFrame(new Frame(4, 2)); //4
		game1.addFrame(new Frame(8, 0)); //5
		game1.addFrame(new Frame(2, 3)); //6
		game1.addFrame(new Frame(1, 3)); //7
		game1.addFrame(new Frame(1, 6)); //8
		game1.addFrame(new Frame(2, 0)); //9
		game1.addFrame(new Frame(5,5));
		game1.addFrame(new Frame(4,0));
		
		game2.addFrame(new Frame(1, 5)); //1
		game2.addFrame(new Frame(2, 5)); //2
		game2.addFrame(new Frame(1, 1)); //3
		game2.addFrame(new Frame(4, 2)); //4
		game2.addFrame(new Frame(8, 0)); //5
		game2.addFrame(new Frame(2, 3)); //6
		game2.addFrame(new Frame(1, 3)); //7
		game2.addFrame(new Frame(1, 6)); //8
		game2.addFrame(new Frame(2, 0)); //9
		game2.addFrame(new Frame(5,5));
		
		game2.setBonus(4,0);
		
		if(game1.score() == 61 || game2.score() == 61)
			assertTrue(true);
		else
			fail();
	}
	
	// Commented by Oscar
	// We are not enforcing throwing any exception on invalid input.
	// Moreover, this tests is not testing than a exception is raised
	@Ignore
	@Test
	public void testLastSpareBonusForm() throws InvalidInput, BowlingException   {
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(1, 5)); //1
		game.addFrame(new Frame(2, 5)); //2
		game.addFrame(new Frame(1, 1)); //3
		game.addFrame(new Frame(4, 2)); //4
		game.addFrame(new Frame(8, 0)); //5
		game.addFrame(new Frame(2, 3)); //6
		game.addFrame(new Frame(1, 3)); //7
		game.addFrame(new Frame(1, 6)); //8
		game.addFrame(new Frame(2, 0)); //9
		game.addFrame(new Frame(5,5));
		game.addFrame(new Frame(4,4));
		//game.setBonusFrame(new Frame(4,4));
		
		

		assertEquals(61, game.score());
	}
	
	// Commented by Oscar
	// This test does the same than testLastSpareBonusForm or testLastSpareBonusContent, 
	// depending on the interpretation
	@Ignore
	@Test
	public void testLastSpareZeroBonus() throws InvalidInput, BowlingException   {
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(1, 5)); //1
		game.addFrame(new Frame(2, 5)); //2
		game.addFrame(new Frame(1, 1)); //3
		game.addFrame(new Frame(4, 2)); //4
		game.addFrame(new Frame(8, 0)); //5
		game.addFrame(new Frame(2, 3)); //6
		game.addFrame(new Frame(1, 3)); //7
		game.addFrame(new Frame(1, 6)); //8
		game.addFrame(new Frame(2, 0)); //9
		game.addFrame(new Frame(5,5));
		game.addFrame(new Frame(0,0));

		//game.setBonusFrame(new Frame(0,0));

	
		assertEquals(57, game.score());
	}
	
	// Commented by Oscar
	// This test is wrong according to the specification because the bonus is not a frame
	// If we admit there are 2 possible ways to set the bonus, the following code
	// will be preferable
	// FIXED (bonus throws can be set using either addFrame and setBonus)
	@Test
	public void testLastSpareZeroBonusContent() throws InvalidInput, BowlingException   {
		BowlingGame game1 = new BowlingGame();
		BowlingGame game2 = new BowlingGame();
		
		game1.addFrame(new Frame(1, 5)); //1
		game1.addFrame(new Frame(2, 5)); //2
		game1.addFrame(new Frame(1, 1)); //3
		game1.addFrame(new Frame(4, 2)); //4
		game1.addFrame(new Frame(8, 0)); //5
		game1.addFrame(new Frame(2, 3)); //6
		game1.addFrame(new Frame(1, 3)); //7
		game1.addFrame(new Frame(1, 6)); //8
		game1.addFrame(new Frame(2, 0)); //9
		game1.addFrame( new Frame(4,6));
		game1.addFrame(new Frame(0,0));
		
		game2.addFrame(new Frame(1, 5)); //1
		game2.addFrame(new Frame(2, 5)); //2
		game2.addFrame(new Frame(1, 1)); //3
		game2.addFrame(new Frame(4, 2)); //4
		game2.addFrame(new Frame(8, 0)); //5
		game2.addFrame(new Frame(2, 3)); //6
		game2.addFrame(new Frame(1, 3)); //7
		game2.addFrame(new Frame(1, 6)); //8
		game2.addFrame(new Frame(2, 0)); //9
		game2.addFrame( new Frame(4,6));

		game2.setBonus(0,0);

		if(game1.score() == 57 || game2.score() == 57)
			assertTrue(true);
		else
			fail();
	}
	
	// Commented by Oscar
	// We are not enforcing throwing any exception on invalid input.
	// Moreover, this tests is not testing than a exception is raised
	@Ignore
	@Test
	public void testLastSpareZeroBonusForm() throws InvalidInput, BowlingException   {
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(1, 5)); //1
		game.addFrame(new Frame(2, 5)); //2
		game.addFrame(new Frame(1, 1)); //3
		game.addFrame(new Frame(4, 2)); //4
		game.addFrame(new Frame(8, 0)); //5
		game.addFrame(new Frame(2, 3)); //6
		game.addFrame(new Frame(1, 3)); //7
		game.addFrame(new Frame(1, 6)); //8
		game.addFrame(new Frame(2, 0)); //9
		game.addFrame( new Frame(3,7));
		game.addFrame(new Frame(0,0));

		//game.setBonusFrame(new Frame(0,0));


		assertEquals(57, game.score());
	}
	
	// Commented by Oscar
	// We are not enforcing throwing any exception on invalid input.
	// Moreover, this tests is not testing than a exception is raised
	// Wrong --> score is 65 not 75
	// FIXED (set score to 65 instead of 75)
	@Ignore
	@Test
	public void testLastStrikeForm() throws InvalidInput, BowlingException   {
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(1,5));
		game.addFrame(new Frame(2, 5)); //2
		game.addFrame(new Frame(1, 1)); //3
		game.addFrame(new Frame(4, 2)); //4
		game.addFrame(new Frame(8, 0)); //5
		game.addFrame(new Frame(2, 3)); //6
		game.addFrame(new Frame(1, 3)); //7
		game.addFrame(new Frame(1, 6)); //8
		game.addFrame(new Frame(2, 0)); //9
		game.addFrame(new Frame(10,0));
		game.addFrame(new Frame(4,4));

		//game.setBonusFrame(new Frame(4,4));
	
		


		assertEquals(65,  game.score());
	}
	
	// Commented by Oscar
	// This test is wrong according to the specification because the bonus is not a frame
	// If we admit there are 2 possible ways to set the bonus, the following code
	// will be preferable
	// Additionally, the final score should be 65 not 66
	// FIXED (bonus throws can be set using either addFrame and setBonus, and the final score should be 65 instead of 66)
	@Test
	public void testLastStrikeContent() throws InvalidInput, BowlingException   {
		BowlingGame game1 = new BowlingGame();
		BowlingGame game2 = new BowlingGame();
		
		game1.addFrame(new Frame(1,5));
		game1.addFrame(new Frame(2, 5)); //2
		game1.addFrame(new Frame(1, 1)); //3
		game1.addFrame(new Frame(4, 2)); //4
		game1.addFrame(new Frame(8, 0)); //5
		game1.addFrame(new Frame(2, 3)); //6
		game1.addFrame(new Frame(1, 3)); //7
		game1.addFrame(new Frame(1, 6)); //8
		game1.addFrame(new Frame(2, 0)); //9
		game1.addFrame( new Frame(10,0));
		game1.addFrame(new Frame(4,4));

		game2.addFrame(new Frame(1,5));
		game2.addFrame(new Frame(2, 5)); //2
		game2.addFrame(new Frame(1, 1)); //3
		game2.addFrame(new Frame(4, 2)); //4
		game2.addFrame(new Frame(8, 0)); //5
		game2.addFrame(new Frame(2, 3)); //6
		game2.addFrame(new Frame(1, 3)); //7
		game2.addFrame(new Frame(1, 6)); //8
		game2.addFrame(new Frame(2, 0)); //9
		game2.addFrame( new Frame(10,0));

		game2.setBonus(4, 4);
			
		if(game1.score() == 65 || game2.score() == 65)
			assertTrue(true);
		else
			fail();
	}

	// Commented by Oscar
	// This test is wrong according to the specification because the bonus is not a frame
	// If we admit there are 2 possible ways to set the bonus, the following code
	// will be preferable
	// FIXED (bonus throws can be set using either addFrame and setBonus)
	@Test
	public void testLastStrikeZeroBonus() throws InvalidInput, BowlingException   {
		BowlingGame game1 = new BowlingGame();
		BowlingGame game2 = new BowlingGame();
		
		game1.addFrame(new Frame(1,5));
		game1.addFrame(new Frame(2, 5)); //2
		game1.addFrame(new Frame(1, 1)); //3
		game1.addFrame(new Frame(4, 2)); //4
		game1.addFrame(new Frame(8, 0)); //5
		game1.addFrame(new Frame(2, 3)); //6
		game1.addFrame(new Frame(1, 3)); //7
		game1.addFrame(new Frame(1, 6)); //8
		game1.addFrame(new Frame(2, 0)); //9
		game1.addFrame( new Frame(10,0));
		game1.addFrame(new Frame(0,0));

		game2.addFrame(new Frame(1,5));
		game2.addFrame(new Frame(2, 5)); //2
		game2.addFrame(new Frame(1, 1)); //3
		game2.addFrame(new Frame(4, 2)); //4
		game2.addFrame(new Frame(8, 0)); //5
		game2.addFrame(new Frame(2, 3)); //6
		game2.addFrame(new Frame(1, 3)); //7
		game2.addFrame(new Frame(1, 6)); //8
		game2.addFrame(new Frame(2, 0)); //9
		game2.addFrame( new Frame(10,0));
		
		game2.setBonus(0,0);
		
		if(game1.score() == 57 || game2.score() == 57)
			assertTrue(true);
		else
			fail();
	}
	
	// Commented by Oscar
	// Missing @Test here...I add the @Test
	// We are not enforcing throwing any exception on invalid input.
	// Moreover, this tests is not testing than a exception is raised
	// Wrong --> score is 57 not 66
	// FIXED (set score to 57 instead of 66)
	@Ignore
	@Test
	public void testLastStrikeZeroBonusForm() throws InvalidInput, BowlingException   {
		BowlingGame game = new BowlingGame();
		game.addFrame(new Frame(1,5));
		game.addFrame(new Frame(2, 5)); //2
		game.addFrame(new Frame(1, 1)); //3
		game.addFrame(new Frame(4, 2)); //4
		game.addFrame(new Frame(8, 0)); //5
		game.addFrame(new Frame(2, 3)); //6
		game.addFrame(new Frame(1, 3)); //7
		game.addFrame(new Frame(1, 6)); //8
		game.addFrame(new Frame(2, 0)); //9
		game.addFrame( new Frame(10,0));
		game.addFrame(new Frame(0,0));

		//game.setBonusFrame(new Frame(0,0));
		
		
		assertEquals(57, game.score());
	}
	
	// Commented by Oscar
	// We are not enforcing throwing any exception on invalid input.
	// Moreover, this test is not testing than a exception is raised
	@Ignore
	@Test
	public void testBonusIsStrikeFormWhenLastIsSpareForm() throws InvalidInput, BowlingException   {
		BowlingGame game = new BowlingGame();
		Frame f1 = new Frame(1,5);
		Frame f2 = new Frame(2,5);
		Frame f3 = new Frame(1,1);
		Frame f4 = new Frame(4,2);
		Frame f5 = new Frame(8,0);
		Frame f6 = new Frame(2,3);
		Frame f7 = new Frame(1,3);
		Frame f8 = new Frame(1,6);
		Frame f9 = new Frame(2,0);
		Frame f10 = new Frame(5,5);
	

		game.addFrame(f1);
		game.addFrame(f2);
		game.addFrame(f3);
		game.addFrame(f4);
		game.addFrame(f5);
		game.addFrame(f6);
		game.addFrame(f7);
		game.addFrame(f8);
		game.addFrame(f9);
	
		game.addFrame(f10);
		game.addFrame(new Frame(10,0));

		//game.setBonusFrame(new Frame(10,0));


		
		assertEquals(67, game.score());
	}
	
	// Commented by Oscar
	// This test is wrong according to the specification because the bonus is not a frame
	// If we admit there are 2 possible ways to set the bonus, the following code
	// will be preferable
	// FIXED (bonus throws can be set using either addFrame and setBonus)
	@Test
	public void testBonusIsStrikeWhenLastIsSpareContent() throws InvalidInput, BowlingException   {
		BowlingGame game1 = new BowlingGame();
		BowlingGame game2 = new BowlingGame();
		
		Frame f1 = new Frame(1,5);
		Frame f2 = new Frame(2,5);
		Frame f3 = new Frame(1,1);
		Frame f4 = new Frame(4,2);
		Frame f5 = new Frame(8,0);
		Frame f6 = new Frame(2,3);
		Frame f7 = new Frame(1,3);
		Frame f8 = new Frame(1,6);
		Frame f9 = new Frame(2,0);
		Frame f10 = new Frame(4,6);
		
		game1.addFrame(f1);
		game1.addFrame(f2);
		game1.addFrame(f3);
		game1.addFrame(f4);
		game1.addFrame(f5);
		game1.addFrame(f6);
		game1.addFrame(f7);
		game1.addFrame(f8);
		game1.addFrame(f9);
		game1.addFrame(new Frame(4,6));
		game1.addFrame(new Frame(10,0));

		game2.addFrame(f1);
		game2.addFrame(f2);
		game2.addFrame(f3);
		game2.addFrame(f4);
		game2.addFrame(f5);
		game2.addFrame(f6);
		game2.addFrame(f7);
		game2.addFrame(f8);
		game2.addFrame(f9);
		game2.addFrame(new Frame(4,6));
		game2.setBonus(10, 0);

		if(game1.score() == 67 || game2.score() == 67)
			assertTrue(true);
		else
			fail();	
	}

	// Commented by Oscar
	// This test IS THE SAME than testBonusIsStrikeWhenLastIsStrikeContent
	// Wrong --> score is 67 not 77
	@Ignore
	@Test
	public void testBonusIsStrikeWhenLastIsStrike() throws InvalidInput, BowlingException   {
		BowlingGame game = new BowlingGame();
		
		Frame f1= new Frame(1, 5); //1
		Frame f2= new Frame(2, 5); //2
		Frame f3= new Frame(1, 1); //3
		Frame f4= new Frame(4, 2); //4
		Frame f5= new Frame(8, 0); //5
		Frame f6= new Frame(2, 3); //6
		Frame f7= new Frame(1, 3); //7
		Frame f8= new Frame(1, 6); //8
		Frame f9= new Frame(2, 0); //9
		Frame f10= new Frame(10,0);//,10,0); //10
		game.addFrame(f1);
		game.addFrame(f2);
		game.addFrame(f3);
		game.addFrame(f4);
		game.addFrame(f5);
		game.addFrame(f6);
		game.addFrame(f7);
		game.addFrame(f8);
		game.addFrame(f9);
		
	
		game.addFrame(new Frame(10,0));
		game.addFrame(new Frame(10,0));

		//game.setBonusFrame(new Frame(10,0));
	
		
	
		assertEquals(67, game.score());
	}
	
	// Commented by Oscar
	// This test is wrong according to the specification because the bonus is not a frame
	// If we admit there are 2 possible ways to set the bonus, the following code
	// will be preferable
	// Wrong --> score is 67 not 77
	// FIXED (bonus throws can be set using either addFrame and setBonus and score is set to 67 instead of 77)
	@Test
	public void testBonusIsStrikeWhenLastIsStrikeContent() throws InvalidInput, BowlingException   {
		
		BowlingGame game1 = new BowlingGame();
		BowlingGame game2 = new BowlingGame();
		
		Frame f1 = new Frame(1, 5); //1
		Frame f2 = new Frame(2, 5); //2
		Frame f3 = new Frame(1, 1); //3
		Frame f4 = new Frame(4, 2); //4
		Frame f5 = new Frame(8, 0); //5
		Frame f6 = new Frame(2, 3); //6
		Frame f7 = new Frame(1, 3); //7
		Frame f8 = new Frame(1, 6); //8
		Frame f9 = new Frame(2, 0); //9
		Frame f10 = new Frame(10,0);//,10,0); //10
		game1.addFrame(f1);
		game1.addFrame(f2);
		game1.addFrame(f3);
		game1.addFrame(f4);
		game1.addFrame(f5);
		game1.addFrame(f6);
		game1.addFrame(f7);
		game1.addFrame(f8);
		game1.addFrame(f9);
		game1.addFrame(new Frame(10,0));
		game1.addFrame(new Frame(10,0));
		
		game2.addFrame(f1);
		game2.addFrame(f2);
		game2.addFrame(f3);
		game2.addFrame(f4);
		game2.addFrame(f5);
		game2.addFrame(f6);
		game2.addFrame(f7);
		game2.addFrame(f8);
		game2.addFrame(f9);
		game2.addFrame(new Frame(10,0));
		game2.setBonus(10, 0);
	
		if(game1.score() == 67 || game2.score() == 67)
			assertTrue(true);
		else
			fail();	
	}
	
	// Commented by Oscar
	// We are not enforcing throwing any exception on invalid input.
	// Moreover, this tests is not testing than a exception is raised
	//
	// However, this is a good test in the sense that checks if the subject's code considers the 11th frame part of the 
	// game or an additional throw. The 1st case is wrong, but the 2nd is correct.
	//
	// The test case could be 
	@Test
	public void testBonusIsStrikeWhenLastIsStrike_PlusAdditionalFrame_WithoutBonusThrows() throws InvalidInput, BowlingException   {
		BowlingGame game = new BowlingGame();
		Frame f1 = new Frame(1, 5); //1
		Frame f2 = new Frame(2, 5); //2
		Frame f3 = new Frame(1, 1); //3
		Frame f4 = new Frame(4, 2); //4
		Frame f5 = new Frame(8, 0); //5
		Frame f6 = new Frame(2, 3); //6
		Frame f7 = new Frame(1, 3); //7
		Frame f8 = new Frame(1, 6); //8
		Frame f9 = new Frame(2, 0); //9
		Frame f10 = new Frame(10,0);//,10,0); //10
		game.addFrame(f1);
		game.addFrame(f2);
		game.addFrame(f3);
		game.addFrame(f4);
		game.addFrame(f5);
		game.addFrame(f6);
		game.addFrame(f7);
		game.addFrame(f8);
		game.addFrame(f9);


		game.addFrame(new Frame(10,0));
		game.addFrame(new Frame(10,0));
				
		assertThat(game.score(), anyOf(equalTo(57), equalTo(67))); 
	}
	
	// Commented by Oscar
	// This test is wrong according to the specification because the bonus is not a frame
	// If we admit there are 2 possible ways to set the bonus, the following code
	// will be preferable
	//
	// FIXED (bonus throws can be set using either addFrame)
	@Test
	public void testBestScoresAllSparesContent() throws InvalidInput, BowlingException   {
		BowlingGame game1 = new BowlingGame();
		BowlingGame game2 = new BowlingGame();
		
		Frame f1 = new Frame(9, 1); //1
		Frame f2 = new Frame(9, 1); //2
		Frame f3 = new Frame(9, 1); //3
		Frame f4 = new Frame(9, 1); //4
		Frame f5 = new Frame(9, 1); //5
		Frame f6 = new Frame(9, 1); //6
		Frame f7 = new Frame(9, 1); //7
		Frame f8 = new Frame(9, 1); //8
		Frame f9 = new Frame(9, 1); //9
		Frame f10 = new Frame(9, 1);//,10,0); //10
		
		game1.addFrame(f1);
		game1.addFrame(f2);
		game1.addFrame(f3);
		game1.addFrame(f4);
		game1.addFrame(f5);
		game1.addFrame(f6);
		game1.addFrame(f7);
		game1.addFrame(f8);
		game1.addFrame(f9);
		game1.addFrame( new Frame(9,1));
		game1.addFrame(new Frame(10,0));

		game2.addFrame(f1);
		game2.addFrame(f2);
		game2.addFrame(f3);
		game2.addFrame(f4);
		game2.addFrame(f5);
		game2.addFrame(f6);
		game2.addFrame(f7);
		game2.addFrame(f8);
		game2.addFrame(f9);
		game2.addFrame( new Frame(9,1));
		game2.setBonus(10,0);
		
		if(game1.score() == 191 || game2.score() == 191)
			assertTrue(true);
		else
			fail();
	}
	
	// Commented by Oscar
	// This test is wrong according to the specification because the bonus is not a frame
	// If we admit there are 2 possible ways to set the bonus, the following code
	// will be preferable
	//
	//// FIXED (bonus throws can be set using either addFrame)
	@Test
	public void testBestScoresAllStrikesContent() throws InvalidInput, BowlingException   {
		BowlingGame game1 = new BowlingGame();
		BowlingGame game2 = new BowlingGame();
		
		Frame f1 = new Frame(10,0); //1
		Frame f2 = new Frame(10,0); //2
		Frame f3 = new Frame(10,0); //3
		Frame f4 = new Frame(10,0); //4
		Frame f5 = new Frame(10,0); //5
		Frame f6 = new Frame(10,0); //6
		Frame f7 = new Frame(10,0); //7
		Frame f8 = new Frame(10,0); //8
		Frame f9 = new Frame(10,0); //9
		Frame f10 = new Frame(10,0);//, 10,0); //10
		
		game1.addFrame(f1);
		game1.addFrame(f2);
		game1.addFrame(f3);
		game1.addFrame(f4);
		game1.addFrame(f5);
		game1.addFrame(f6);
		game1.addFrame(f7);
		game1.addFrame(f8);
		game1.addFrame(f9);

		game1.addFrame(new Frame(10,0));
		game1.addFrame(new Frame(10,10));
		
		game2.addFrame(f1);
		game2.addFrame(f2);
		game2.addFrame(f3);
		game2.addFrame(f4);
		game2.addFrame(f5);
		game2.addFrame(f6);
		game2.addFrame(f7);
		game2.addFrame(f8);
		game2.addFrame(f9);

		game2.addFrame(new Frame(10,0));
		
		game2.setBonus(10,10);
		
		if(game1.score() == 300 || game2.score() == 300)
			assertTrue(true);
		else
			fail();
	}
}
