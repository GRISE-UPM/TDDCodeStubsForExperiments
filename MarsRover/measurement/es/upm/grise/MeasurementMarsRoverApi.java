package es.upm.grise;


import static es.upm.grise.Commons.generateCommand;
import static es.upm.grise.Commons.generateObstacleInPosition;
import static es.upm.grise.Commons.goToBottomRightCornerFromNorth;
import static es.upm.grise.Commons.goToBottomRightCornerFromWestBackwards;
import static es.upm.grise.Commons.goToMiddleBottomBorderFromEast;
import static es.upm.grise.Commons.goToMiddleBottomBorderFromEastBackwards;
import static es.upm.grise.Commons.goToMiddleBottomBorderFromNorth;
import static es.upm.grise.Commons.goToMiddleBottomBorderFromNorthBackwards;
import static es.upm.grise.Commons.goToMiddleBottomBorderFromWest;
import static es.upm.grise.Commons.goToMiddleBottomBorderFromWestBackwards;
import static es.upm.grise.Commons.goToMiddleLeftBorderCommandFromEast;
import static es.upm.grise.Commons.goToMiddleLeftBorderCommandFromEastBackwards;
import static es.upm.grise.Commons.goToMiddleLeftBorderCommandFromSouthBackwards;
import static es.upm.grise.Commons.goToMiddleOfPlanetFromEast;
import static es.upm.grise.Commons.goToMiddleOfPlanetFromNorth;
import static es.upm.grise.Commons.goToMiddleOfPlanetFromNorthBackwards;
import static es.upm.grise.Commons.goToMiddleOfPlanetFromSouth;
import static es.upm.grise.Commons.goToMiddleOfPlanetFromSouthBackwards;
import static es.upm.grise.Commons.goToMiddleOfPlanetFromWest;
import static es.upm.grise.Commons.goToMiddleRightBorderFromWest;
import static es.upm.grise.Commons.goToMiddleRightBorderFromWestBackwards;
import static es.upm.grise.Commons.goToMiddleTopBorderFromEast;
import static es.upm.grise.Commons.goToMiddleTopBorderFromSouth;
import static es.upm.grise.Commons.goToMiddleTopBorderFromSouthBackwards;
import static es.upm.grise.Commons.goToMiddleTopBorderFromWest;
import static es.upm.grise.Commons.goToMiddleTopBorderFromWestBackwards;
import static es.upm.grise.Commons.goToTopLeftCornerFromEast;
import static es.upm.grise.Commons.goToTopLeftCornerFromSouth;
import static es.upm.grise.Commons.goToTopLeftCornerFromSouthBackwards;
import static es.upm.grise.Commons.goToTopRightCornerFromSouth;
import static es.upm.grise.Commons.goToTopRightCornerFromWestBackwards;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;

public class MeasurementMarsRoverApi {
	MarsRover rover;
/*	String goToMiddleOfGridCommand;
	String goToMiddleLeftBorderCommand;
	String goToTopLeftCornerCommand;
	String goToMiddleTopBorderCommand;
	String goToTopRightCornerCommand;
	String goToMiddleRightBorderCommand;
	String goToBottomRightCornerCommand;
	String goToMiddleBottomBorderCommand;*/

	@Before
	public void setup(){
		this.rover = new MarsRover(100, 100, "");
	/*	this.goToMiddleOfGridCommand = goToTheMiddleOfTheGridCommand();
		this.goToMiddleLeftBorderCommand = goToMiddleLeftBorderCommand();
		this.goToTopLeftCornerCommand = goToTopLeftCorner();
		this.goToMiddleTopBorderCommand = goToMiddleTopBorder();
		this.goToTopRightCornerCommand = goToTopRightCorner();
		this.goToMiddleRightBorderCommand = goToMiddleRightBorder();
		this.goToBottomRightCornerCommand = goToBottomRightCorner();
		this.goToMiddleBottomBorderCommand = goToMiddleBottomBorder();*/
	}
	
	

	@Test
	public void theRoverStaysAtOriginOnceLandedAndExecutedAnEmptyCommand() {
		assertThat("(0,0,N)", is(equalToIgnoringCase(this.rover.executeCommand(""))));
		
	}
	
	/*@Test
	public void theRoverMovesAt01OnceLandingAndExecutingAForwardCommand() {
		assertThat("(0,1,N)", is(equalToIgnoringCase(this.rover.executeCommand("f"))));
	}
	
	
	@Test
	public void theRoverMovesNOnceLandingAndExecutingA3ForwardCommand() {
		assertThat("(0,3,N)", is(equalToIgnoringCase(this.rover.executeCommand("fff"))));
	}
	
	@Test
	public void theRoverMovesAtTheEdgeOfTheGridOnceLandingAndExecutingA100ForwardCommand() {
		String command = generateCommand(99, "f");
		assertThat("(0,99,N)", is(equalToIgnoringCase( this.rover.executeCommand(command))));
	}
	
	@Test
	public void theRoverMovesToTheNextSquareNFromARandomPosition() {
		String command= generateCommand(26, "f") + "r" + generateCommand(56, "f") + "l";
		command += "f";
		assertThat("(56,27,N)", is(equalToIgnoringCase( this.rover.executeCommand(command))));
	}


	@Test
	public void theRoverShouldChangeFacingTWhenGivenATurnCommandAfterLanding(){
		assertThat("(0,0,E)", is(equalToIgnoringCase( this.rover.executeCommand("l"))));
		assertThat("(0,0,W)", is(equalToIgnoringCase( this.rover.executeCommand("r"))));
	}
	
	@Test
	public void theRoverFacesSouthAfterLandingAndExecutingATurnCommandToTimesInARow(){
		assertThat("(0,0,S)", is(equalToIgnoringCase( this.rover.executeCommand("rr"))));
		assertThat("(0,0,S)", is(equalToIgnoringCase( this.rover.executeCommand("ll"))));
	}
	
	@Test
	public void theRoverFacesWestAfterLandingAndExecutingALeftCommandThreeTimesInARow(){
		assertThat("(0,0,W)", is(equalToIgnoringCase(this.rover.executeCommand("lll"))));	
	}
	
	@Test
	public void theRoverFacesEastAfterLandingAndExecutingARightCommandThreeTimesInARow(){
		assertThat("(0,0,E)", is(equalToIgnoringCase(this.rover.executeCommand("rrr"))));	
	}
	
	@Test
	public void theRoverIsFacingTheSameDirectionAfterExecutingFourTimesTheSameTurnCommand(){
		assertThat("(0,0,N)", is(equalToIgnoringCase(this.rover.executeCommand("llll"))));
		assertThat("(0,0,N)", is(equalToIgnoringCase(this.rover.executeCommand("rrrr"))));
	}
	
	
	@Test
	public void theRoverShouldChangeFacingWhenGivenATurnCommandInTheMiddleOfTheGrid(){
		assertThat("(12,34,E)", is(equalToIgnoringCase( this.rover.executeCommand(goToMiddleOfGridCommand+"l"))));
		assertThat("(12,34,W)", is(equalToIgnoringCase( this.rover.executeCommand(goToMiddleOfGridCommand+"r"))));
	}

	
	@Test
	public void theRoverFacesSouthExecutingATurnCommandToTimesInARowInTheMiddleOfTheGrid(){
		assertThat("(12,34,S)", is(equalToIgnoringCase( this.rover.executeCommand(goToMiddleOfGridCommand+"rr"))));
		assertThat("(12,34,S)", is(equalToIgnoringCase( this.rover.executeCommand(goToMiddleOfGridCommand+"ll"))));
	}
	
	@Test
	public void theRoverFacesWestAfterExecutingALeftCommandThreeTimesInARowInTheMiddleOfTheGrid(){
		assertThat("(12,34,W)", is(equalToIgnoringCase(this.rover.executeCommand(goToMiddleOfGridCommand+"lll"))));	
	}

	@Test
	public void theRoverFacesEastAfterExecutingARightCommandThreeTimesInARowInTheMiddleOfTheGrid(){
		assertThat("(12,34,E)", is(equalToIgnoringCase(this.rover.executeCommand(goToMiddleOfGridCommand+"rrr"))));	
	}
	
	@Test
	public void theRoverIsFacingTheSameDirectionAfterExecutingFourTimesTheSameTurnCommandInTheMiddleOfTheGrid(){
		assertThat("(12,34,N)", is(equalToIgnoringCase(this.rover.executeCommand(goToMiddleOfGridCommand+"llll"))));
		assertThat("(12,34,N)", is(equalToIgnoringCase(this.rover.executeCommand(goToMiddleOfGridCommand+"rrrr"))));
	}
	
	
	@Test
	public void theRoverShouldChangeFacingWhenGivenATurnCommandInTheMiddleLeftBorderTurningLeft(){
		assertThat("(0,50,W)", is(equalToIgnoringCase( this.rover.executeCommand(goToMiddleLeftBorderCommand+"l"))));
		
	}
	
	@Test
	public void theRoverShouldChangeFacingWhenGivenATurnCommandInTheMiddleLeftBorderTurningRight(){
		
		assertThat("(0,50,E)", is(equalToIgnoringCase( this.rover.executeCommand(goToMiddleLeftBorderCommand+"r"))));
	}


	
	@Test
	public void theRoverFacesSouthExecutingATurnCommandToTimesInARowInTheMiddleOfLeftBorderTurningRight(){
		assertThat("(0,50,S)", is(equalToIgnoringCase( this.rover.executeCommand(goToMiddleLeftBorderCommand+"rr"))));
		
	}
	
	@Test
	public void theRoverFacesSouthExecutingATurnCommandToTimesInARowInTheMiddleOfLeftBorderTurningLeft(){
		assertThat("(0,50,S)", is(equalToIgnoringCase(this.rover.executeCommand(goToMiddleLeftBorderCommand+"ll"))));
	}
	
	@Test
	public void theRoverFacesEastAfterExecutingALeftCommandThreeTimesInARowInTheMiddleLeftBorder(){
		assertThat("(0,50,E)", is(equalToIgnoringCase(this.rover.executeCommand(goToMiddleLeftBorderCommand+"lll"))));	
	}
	
	@Test
	public void theRoverFacesWestAfterExecutingARightCommandThreeTimesInARowInTheMiddleLeftBorder(){
		assertThat("(0,50,W)", is(equalToIgnoringCase( this.rover.executeCommand(goToMiddleLeftBorderCommand+"rrr"))));	
	}
	
	@Test
	public void theRoverIsFacingTheSameDirectionAfterExecutingFourTimesTheSameTurnCommandInTheMiddleLeftBorderTurningLeft(){
		assertThat("(0,50,N)", is(equalToIgnoringCase(this.rover.executeCommand(goToMiddleLeftBorderCommand+"llll"))));

	}
	
	@Test
	public void theRoverIsFacingTheSameDirectionAfterExecutingFourTimesTheSameTurnCommandInTheMiddleLeftBorderTurningRight(){
	
		assertThat("(0,50,N)", is(equalToIgnoringCase(this.rover.executeCommand(goToMiddleLeftBorderCommand+"rrrr"))));
	}
	
	@Test
	public void theRoverShouldChangeFacingWhenGivenATurnCommandInTheTopLeftCornerTurningLeft(){
		assertThat("(0,99,W)", is(equalToIgnoringCase( this.rover.executeCommand(goToTopLeftCornerCommand+"l"))));
		
	}
	
	@Test
	public void theRoverShouldChangeFacingWhenGivenATurnCommandInTheTopLeftCornerTurningRight(){
		assertThat("(0,99,E)", is(equalToIgnoringCase( this.rover.executeCommand(goToTopLeftCornerCommand+"r"))));
	}


	
	@Test
	public void theRoverFacesSouthExecutingATurnCommandToTimesInARowInTheTopLeftCornerTurningRight(){
		assertThat("(0,99,S)", is(equalToIgnoringCase( this.rover.executeCommand(goToTopLeftCornerCommand+"rr"))));
	}
	
	
	@Test
	public void theRoverFacesSouthExecutingATurnCommandToTimesInARowInTheTopLeftCornerTurningLeft(){
		assertThat("(0,99,S)", is(equalToIgnoringCase( this.rover.executeCommand(goToTopLeftCornerCommand+"ll"))));
	}
	@Test
	public void theRoverFacesWestAfterExecutingALeftCommandThreeTimesInARowInTheTopLeftCorner(){
		assertThat("(0,99,E)", is(equalToIgnoringCase(this.rover.executeCommand(goToTopLeftCornerCommand+"lll"))));	
	}
	
	@Test
	public void theRoverFacesEastAfterExecutingARightCommandThreeTimesInARowInTheTopLeftCorner(){
		assertThat("(0,99,W)", is(equalToIgnoringCase(this.rover.executeCommand(goToTopLeftCornerCommand+"rrr"))));	
	}
	
	@Test
	public void theRoverIsFacingTheSameDirectionAfterExecutingFourTimesTheSameTurnCommandInTheTopLeftCornerTurningLeft(){
		assertThat("(0,99,N)", is(equalToIgnoringCase(this.rover.executeCommand(goToTopLeftCornerCommand+"llll"))));
	}
	
	
	@Test
	public void theRoverIsFacingTheSameDirectionAfterExecutingFourTimesTheSameTurnCommandInTheTopLeftCornerTurningRight(){
		assertThat("(0,99,N)", is(equalToIgnoringCase(this.rover.executeCommand(goToTopLeftCornerCommand+"rrrr"))));
	}
	
	
	@Test
	public void theRoverShouldChangeFacingWhenGivenATurnCommandInTheMiddleTopBorderTurningLeft(){
		assertThat("(50,99,W)", is(equalToIgnoringCase( this.rover.executeCommand(goToMiddleTopBorderCommand+"l"))));
	}
	
	@Test
	public void theRoverShouldChangeFacingWhenGivenATurnCommandInTheMiddleTopBorderTurningRight(){
		assertThat("(50,99,E)", is(equalToIgnoringCase( this.rover.executeCommand(goToMiddleTopBorderCommand+"r"))));
	}


	
	@Test
	public void theRoverFacesSouthExecutingATurnCommandToTimesInARowInTheMiddleTopBorderTurningRight(){
		assertThat("(50,99,S)", is(equalToIgnoringCase(this.rover.executeCommand(goToMiddleTopBorderCommand+"rr"))));
	}
	
	
	@Test
	public void theRoverFacesSouthExecutingATurnCommandToTimesInARowInTheMiddleTopBorderTurningLeft(){
		assertThat("(50,99,S)", is(equalToIgnoringCase(this.rover.executeCommand(goToMiddleTopBorderCommand+"ll"))));
	}
	
	@Test
	public void theRoverFacesWestAfterExecutingALeftCommandThreeTimesInARowInTheMiddleTopBorder(){
		assertThat("(50,99,E)", is(equalToIgnoringCase(this.rover.executeCommand(goToMiddleTopBorderCommand+"lll"))));	
	}
	
	@Test
	public void theRoverFacesEastAfterExecutingARightCommandThreeTimesInARowInTheMiddleTopBorder(){
		assertThat("(50,99,W)", is(equalToIgnoringCase(this.rover.executeCommand(goToMiddleTopBorderCommand+"rrr"))));	
	}
	
	@Test
	public void theRoverIsFacingTheSameDirectionAfterExecutingFourTimesTheSameTurnCommandInTheMiddleTopBorderTurningLeft(){
		assertThat("(50,99,N)", is(equalToIgnoringCase(this.rover.executeCommand(goToMiddleTopBorderCommand+"llll"))));
	}
	
	@Test
	public void theRoverIsFacingTheSameDirectionAfterExecutingFourTimesTheSameTurnCommandInTheMiddleTopBorderTurningRight(){
		assertThat("(50,99,N)", is(equalToIgnoringCase(this.rover.executeCommand(goToMiddleTopBorderCommand+"rrrr"))));
	}
	
	@Test
	public void theRoverShouldChangeFacingWhenGivenATurnCommandInTheTopRightCornerTurningLeft(){
		assertThat("(99,99,W)", is(equalToIgnoringCase(this.rover.executeCommand(goToTopRightCornerCommand+"l"))));

	}
	
	@Test
	public void theRoverShouldChangeFacingWhenGivenATurnCommandInTheTopRightCornerTurningRight(){
		assertThat("(99,99,E)", is(equalToIgnoringCase(this.rover.executeCommand(goToTopRightCornerCommand+"r"))));
	}
	

	@Test
	public void theRoverFacesSouthExecutingATurnCommandToTimesInARowInTheTopRightCornerTurningRight(){
		assertThat("(99,99,S)", is(equalToIgnoringCase(this.rover.executeCommand(goToTopRightCornerCommand+"rr"))));
	}
	
	@Test
	public void theRoverFacesSouthExecutingATurnCommandToTimesInARowInTheTopRightCornerTurningLeft(){
		assertThat("(99,99,S)", is(equalToIgnoringCase(this.rover.executeCommand(goToTopRightCornerCommand+"ll"))));
	}
	@Test
	public void theRoverFacesWestAfterExecutingALeftCommandThreeTimesInARowInTheTopRightCorner(){
		assertThat("(99,99,E)", is(equalToIgnoringCase(this.rover.executeCommand(goToTopRightCornerCommand+"lll"))));	
	}
	
	@Test
	public void theRoverFacesEastAfterExecutingARightCommandThreeTimesInARowInTheTopRightCorner(){
		assertThat("(99,99,W)", is(equalToIgnoringCase(this.rover.executeCommand(goToTopRightCornerCommand+"rrr"))));	
	}
	
	@Test
	public void theRoverIsFacingTheSameDirectionAfterExecutingFourTimesTheSameTurnCommandInTheTopRightCornerTurningLeft(){
		assertThat("(99,99,N)", is(equalToIgnoringCase(this.rover.executeCommand(goToTopRightCornerCommand+"llll"))));
	}
	
	@Test
	public void theRoverIsFacingTheSameDirectionAfterExecutingFourTimesTheSameTurnCommandInTheTopRightCornerTurningRight(){
		assertThat("(99,99,N)", is(equalToIgnoringCase(this.rover.executeCommand(goToTopRightCornerCommand+"rrrr"))));
	}
	
	
	
	@Test
	public void theRoverShouldChangeFacingWhenGivenATurnCommandInTheMiddleRightBorderTurningLeft(){
		assertThat("(99,50,W)", is(equalToIgnoringCase( this.rover.executeCommand(goToMiddleRightBorderCommand+"l"))));
	}

	
	@Test
	public void theRoverShouldChangeFacingWhenGivenATurnCommandInTheMiddleRightBorderTurningRight(){
		assertThat("(99,50,E)", is(equalToIgnoringCase( this.rover.executeCommand(goToMiddleRightBorderCommand+"r"))));
	}
	
	@Test
	public void theRoverFacesSouthExecutingATurnCommandToTimesInARowInTheMiddleRightBorderTurningRight(){
		assertThat("(99,50,S)", is(equalToIgnoringCase( this.rover.executeCommand(goToMiddleRightBorderCommand+"rr"))));
	}
	
	
	@Test
	public void theRoverFacesSouthExecutingATurnCommandToTimesInARowInTheMiddleRightBorderTurningLeft(){
		assertThat("(99,50,S)", is(equalToIgnoringCase( this.rover.executeCommand(goToMiddleRightBorderCommand+"ll"))));
	}
	
	
	@Test
	public void theRoverFacesWestAfterExecutingALeftCommandThreeTimesInARowInTheMiddleRightBorder(){
		assertThat("(99,50,E)", is(equalToIgnoringCase(this.rover.executeCommand(goToMiddleRightBorderCommand+"lll"))));	
	}
	
	@Test
	public void theRoverFacesEastAfterExecutingARightCommandThreeTimesInARowInTheMiddleRightBorder(){
		assertThat("(99,50,W)", is(equalToIgnoringCase(this.rover.executeCommand(goToMiddleRightBorderCommand+"rrr"))));	
	}
	
	@Test
	public void theRoverrIsFacingTheSameDirectionAfterExecutingFourTimesTheSameTurnCommandInMiddleRightBorderTurningLeft(){
		assertThat("(99,50,N)", is(equalToIgnoringCase(this.rover.executeCommand(goToMiddleRightBorderCommand+"llll"))));
	}
	
	@Test
	public void theRoverIsFacingTheSameDirectionAfterExecutingFourTimesTheSameTurnCommandInMiddleRightBorderTurningRight(){
		assertThat("(99,50,N)", is(equalToIgnoringCase(this.rover.executeCommand(goToMiddleRightBorderCommand+"rrrr"))));
	}
	
	
	
	
	@Test
	public void theRoverShouldChangeFacingWhenGivenATurnCommandInTheBottomRightCornerTurningLeft(){
		assertThat("(99,0,W)", is(equalToIgnoringCase( this.rover.executeCommand(goToBottomRightCornerCommand+"l"))));
	}

	@Test
	public void theRoverShouldChangeFacingWhenGivenATurnCommandInTheBottomRightCornerTurningRight(){
		assertThat("(99,0,E)", is(equalToIgnoringCase( this.rover.executeCommand(goToBottomRightCornerCommand+"r"))));
	}

	
	@Test
	public void theRoverFacesSouthExecutingATurnCommandToTimesInARowInTheBottomRightCornerTurningRight(){
		assertThat("(99,0,S)", is(equalToIgnoringCase( this.rover.executeCommand(goToBottomRightCornerCommand+"rr"))));
	}
	
	
	@Test
	public void theRoverFacesSouthExecutingATurnCommandToTimesInARowInTheBottomRightCornerTurningLeft(){
		assertThat("(99,0,S)", is(equalToIgnoringCase( this.rover.executeCommand(goToBottomRightCornerCommand+"ll"))));
	}
	
	@Test
	public void theRoverFacesWestAfterExecutingALeftCommandThreeTimesInARowInThBottomRightCorner(){
		assertThat("(99,0,E)", is(equalToIgnoringCase(this.rover.executeCommand(goToBottomRightCornerCommand+"lll"))));	
	}
	
	@Test
	public void theRoverFacesEastAfterExecutingARightCommandThreeTimesInARowInTheBottomRightCorner(){
		assertThat("(99,0,W)", is(equalToIgnoringCase(this.rover.executeCommand(goToBottomRightCornerCommand+"rrr"))));	
	}
	
	@Test
	public void theRoverIsFacingTheSameDirectionAfterExecutingFourTimesTheSameTurnCommandInBottomRightCornerTurningLeft(){
		assertThat("(99,0,N)", is(equalToIgnoringCase(this.rover.executeCommand(goToBottomRightCornerCommand+"llll"))));
	}
	
	
	@Test
	public void theRoverIsFacingTheSameDirectionAfterExecutingFourTimesTheSameTurnCommandInBottomRightCornerTurningRight(){
		assertThat("(99,0,N)", is(equalToIgnoringCase(this.rover.executeCommand(goToBottomRightCornerCommand+"rrrr"))));
	}
	
	
	@Test
	public void theRoverShouldChangeFacingWhenGivenATurnCommandInTheMiddleBottomBorderTurningLeft(){
		assertThat("(50,0,W)", is(equalToIgnoringCase( this.rover.executeCommand(goToMiddleBottomBorderCommand+"l"))));
	}
	
	@Test
	public void theRoverShouldChangeFacingWhenGivenATurnCommandInTheMiddleBottomBorderTurningRight(){
		assertThat("(50,0,E)", is(equalToIgnoringCase (this.rover.executeCommand(goToMiddleBottomBorderCommand+"r"))));
	}

	
	@Test
	public void theRoverFacesSouthExecutingATurnCommandToTimesInARowInTheMiddleBottomBorderTurningRight(){
		assertThat("(50,0,S)", is(equalToIgnoringCase( this.rover.executeCommand(goToMiddleBottomBorderCommand+"rr"))));
	}
	
	@Test
	public void theRoverFacesSouthExecutingATurnCommandToTimesInARowInTheMiddleBottomBorderTurningLeft(){
		assertThat("(50,0,S)", is(equalToIgnoringCase( this.rover.executeCommand(goToMiddleBottomBorderCommand+"ll"))));
	}
	
	@Test
	public void theRoverFacesWestAfterExecutingALeftCommandThreeTimesInARowInTheMiddleBottomBorder(){
		assertThat("(50,0,E)", is(equalToIgnoringCase(this.rover.executeCommand(goToMiddleBottomBorderCommand+"lll"))));	
	}
	
	@Test
	public void theRoverFacesEastAfterExecutingARightCommandThreeTimesInARowInTheMiddleBottomBorder(){
		assertThat("(50,0,W)", is(equalToIgnoringCase(this.rover.executeCommand(goToMiddleBottomBorderCommand+"rrr"))));	
	}
	
	@Test
	public void theRoverIsFacingTheSameDirectionAfterExecutingFourTimesTheSameTurnCommandInMiddleBottomBorderTurningLeft(){
		assertThat("(50,0,N)", is(equalToIgnoringCase(this.rover.executeCommand(goToMiddleBottomBorderCommand+"llll"))));
	}
	
	@Test
	public void theRoverIsFacingTheSameDirectionAfterExecutingFourTimesTheSameTurnCommandInMiddleBottomBorderTurningRight(){
		assertThat("(50,0,N)", is(equalToIgnoringCase(this.rover.executeCommand(goToMiddleBottomBorderCommand+"rrrr"))));
	}
	
	@Test
	public void roverCanMoveFromLandingPositionRightDirection(){
		assertThat("(1,0,E)", is(equalToIgnoringCase(this.rover.executeCommand("rf"))));
	}
	@Test
	public void roverCanMoveFromLandingPositionLeftDirection(){
		assertThat("(1,0,W)", is(equalToIgnoringCase(this.rover.executeCommand("lb"))));
	}
	@Test
	public void roverCanMoveFromLandingPositionForwardDirection(){
		assertThat("(0,1,N)", is(equalToIgnoringCase(this.rover.executeCommand("f"))));
	}
	@Test
	public void roverCanMoveFromLandingPositionBackwardDirection(){
		assertThat("(0,1,S)", is(equalToIgnoringCase(this.rover.executeCommand("llb"))));
	}
	
	@Test
	public void roverCanMoveFromMiddleLeftBorder(){
		assertThat("(0,49,N)", is(equalToIgnoringCase(this.rover.executeCommand(goToMiddleLeftBorderCommand+"b"))));
		assertThat("(0,51,N)", is(equalToIgnoringCase(this.rover.executeCommand(goToMiddleLeftBorderCommand+"f"))));
		assertThat("(1,50,E)", is(equalToIgnoringCase(this.rover.executeCommand(goToMiddleLeftBorderCommand+"rf"))));
		
		assertThat("(0,49,S)", is(equalToIgnoringCase(this.rover.executeCommand(goToMiddleLeftBorderCommand+"llf"))));
		assertThat("(0,51,S)", is(equalToIgnoringCase(this.rover.executeCommand(goToMiddleLeftBorderCommand+"llb"))));
		assertThat("(1,50,W)", is(equalToIgnoringCase(this.rover.executeCommand(goToMiddleLeftBorderCommand+"lb"))));
	}
	
	@Test
	public void roverCanMoveFromTopLeftCorner(){
		assertThat("(0,98,N)", is(equalToIgnoringCase(this.rover.executeCommand(goToTopLeftCornerCommand+"b"))));
		assertThat("(1,99,E)", is(equalToIgnoringCase(this.rover.executeCommand(goToTopLeftCornerCommand+"rf"))));
		
		assertThat("(0,98,S)", is(equalToIgnoringCase(this.rover.executeCommand(goToTopLeftCornerCommand+"llf"))));
		assertThat("(1,99,W)", is(equalToIgnoringCase(this.rover.executeCommand(goToTopLeftCornerCommand+"lb"))));
	}
	
	@Test
	public void roverCanMoveFromMiddleTopBorder(){
		assertThat("(50,98,N)", is(equalToIgnoringCase(this.rover.executeCommand(goToMiddleTopBorderCommand+"b"))));
		assertThat("(49,99,W)", is(equalToIgnoringCase(this.rover.executeCommand(goToMiddleTopBorderCommand+"lf"))));
		assertThat("(51,99,E)", is(equalToIgnoringCase(this.rover.executeCommand(goToMiddleTopBorderCommand+"rf"))));
		assertThat("(50,98,S)", is(equalToIgnoringCase(this.rover.executeCommand(goToMiddleTopBorderCommand+"llb"))));
		assertThat("(49,99,E)", is(equalToIgnoringCase(this.rover.executeCommand(goToMiddleTopBorderCommand+"rb"))));
		assertThat("(51,99,W)", is(equalToIgnoringCase(this.rover.executeCommand(goToMiddleTopBorderCommand+"lb"))));
	}
	
	
	@Test
	public void roverCanMoveFromTopRightCorner(){
		assertThat("(99,98,N)", is(equalToIgnoringCase(this.rover.executeCommand(goToTopRightCornerCommand+"b"))));
		assertThat("(98,99,W)", is(equalToIgnoringCase(this.rover.executeCommand(goToTopRightCornerCommand+"lf"))));
		
		assertThat("(99,98,S)", is(equalToIgnoringCase(this.rover.executeCommand(goToTopRightCornerCommand+"llf"))));
		assertThat("(98,99,E)", is(equalToIgnoringCase(this.rover.executeCommand(goToTopRightCornerCommand+"rb"))));
	}
	
	@Test
	public void roverCanMoveFromMiddleRightBorder(){
		assertThat("(99,51,N)", is(equalToIgnoringCase(this.rover.executeCommand(goToMiddleRightBorderCommand+"f"))));
		assertThat("(99,49,N)", is(equalToIgnoringCase(this.rover.executeCommand(goToMiddleRightBorderCommand+"b"))));
		assertThat("(98,50,W)", is(equalToIgnoringCase(this.rover.executeCommand(goToMiddleRightBorderCommand+"lf"))));
		
		assertThat("(99,51,S)", is(equalToIgnoringCase(this.rover.executeCommand(goToMiddleRightBorderCommand+"llb"))));
		assertThat("(99,49,S)", is(equalToIgnoringCase(this.rover.executeCommand(goToMiddleRightBorderCommand+"llf"))));
		assertThat("(98,50,E)", is(equalToIgnoringCase(this.rover.executeCommand(goToMiddleRightBorderCommand+"rb"))));
	}
	
	@Test
	public void roverCanMoveFromBottomRightCorner(){
		assertThat("(99,1,N)", is(equalToIgnoringCase(this.rover.executeCommand(goToBottomRightCornerCommand+"f"))));
		assertThat("(98,0,W)", is(equalToIgnoringCase(this.rover.executeCommand(goToBottomRightCornerCommand+"lf"))));
		
		assertThat("(99,1,S)", is(equalToIgnoringCase(this.rover.executeCommand(goToBottomRightCornerCommand+"llb"))));
		assertThat("(98,0,E)",is(equalToIgnoringCase(this.rover.executeCommand(goToBottomRightCornerCommand+"rb"))));
	}
	
	@Test
	public void roverCanMoveFromMiddleBottomBorder(){
		assertThat("(51,0,E)", is(equalToIgnoringCase(this.rover.executeCommand(goToMiddleBottomBorderCommand+"rf"))));
		assertThat("(49,0,W)", is(equalToIgnoringCase(this.rover.executeCommand(goToMiddleBottomBorderCommand+"lf"))));
		assertThat("(50,1,N)", is(equalToIgnoringCase(this.rover.executeCommand(goToMiddleBottomBorderCommand+"f"))));
		
		assertThat("(51,0,W)", is(equalToIgnoringCase(this.rover.executeCommand(goToMiddleBottomBorderCommand+"lb"))));
		assertThat("(49,0,E)", is(equalToIgnoringCase(this.rover.executeCommand(goToMiddleBottomBorderCommand+"rb"))));
		assertThat("(50,1,S)", is(equalToIgnoringCase(this.rover.executeCommand(goToMiddleBottomBorderCommand+"llb"))));
	}
	
	@Test
	public void roverCanMoveFromMiddleOfTheGrid(){
		assertThat("(12,35,N)", is(equalToIgnoringCase(this.rover.executeCommand(goToMiddleOfGridCommand+"f"))));
		assertThat("(12,33,N)", is(equalToIgnoringCase(this.rover.executeCommand(goToMiddleOfGridCommand+"b"))));
		assertThat("(11,34,W)", is(equalToIgnoringCase(this.rover.executeCommand(goToMiddleOfGridCommand+"lf"))));
		assertThat("(13,34,E)", is(equalToIgnoringCase(this.rover.executeCommand(goToMiddleOfGridCommand+"rf"))));
		
		assertThat("(12,35,S)", is(equalToIgnoringCase(this.rover.executeCommand(goToMiddleOfGridCommand+"llb"))));
		assertThat("(12,33,S)", is(equalToIgnoringCase(this.rover.executeCommand(goToMiddleOfGridCommand+"rrf"))));
		assertThat("(11,34,E)", is(equalToIgnoringCase(this.rover.executeCommand(goToMiddleOfGridCommand+"rb"))));
		assertThat("(13,34,W)", is(equalToIgnoringCase(this.rover.executeCommand(goToMiddleOfGridCommand+"lb"))));
	}
	
	private String goToMiddleBottomBorder(){
		String command = "r" + generateCommand(50, "f") + "l";
		return command;
	}
	private String goToMiddleRightBorder(){
		String command = generateCommand(50, "f") + "r" + generateCommand(99, "f") + "l";
		return command;
	}	
	private String goToBottomRightCorner(){
		String command =  "r" + generateCommand(99, "f") + "l";
		return command;
	}
	private String goToTopLeftCorner(){
		String command = generateCommand(99, "f");
		return command;
	}
	private String goToMiddleTopBorder(){
		String command = generateCommand(99, "f") + "r" + generateCommand(50, "f") + "l";
		return command;
	}
	private String goToTopRightCorner(){
		String command = generateCommand(99, "f") + "r" + generateCommand(99, "f") + "l";
		return command;
	}
	private String goToTheMiddleOfTheGridCommand() {
		String command = generateCommand(34, "f") + "r" + generateCommand(12, "f") + "l";
		return command;
	}
	private String generateCommand(int times,String symbol) {
		String command  = "";
		for (int i = 0; i < times; i++) {
			 command += symbol;
		}
		return command;
	}
	private String goToMiddleLeftBorderCommand(){
		String command = generateCommand(50, "f");
		return command;
	}
*/
	
	@Test
	public void theRoverMovesForwardOnceLanding() {
		assertThat("(0,1,N)", is(equalToIgnoringCase(this.rover.executeCommand("f"))));
		assertThat("(0,2,N)", is(equalToIgnoringCase(this.rover.executeCommand("f"))));
	}
	
	@Test
	public void theRoverMovesBackwardsnceLanding() {
		this.rover.executeCommand("f");
		assertThat("(0,0,N)", is(equalToIgnoringCase(this.rover.executeCommand("b"))));
	}
	
	@Test
	public void theRoverShouldChangeFacingTWhenGivenATurnCommandAfterLanding(){
		assertThat("(0,0,W)", is(equalToIgnoringCase( this.rover.executeCommand("l"))));
		assertThat("(0,0,E)", is(equalToIgnoringCase( this.rover.executeCommand("rr"))));
	}
	
	@Test
	public void theRoverFacesSouthAfterLandingAndExecutingATurnCommandToTimesInARow(){
		assertThat("(0,0,S)", is(equalToIgnoringCase( this.rover.executeCommand("rr"))));
		assertThat("(0,0,N)", is(equalToIgnoringCase( this.rover.executeCommand("ll"))));
	}
	
	@Test
	public void theRoverFacesWestAfterLandingAndExecutingALeftCommandThreeTimesInARow(){
		assertThat("(0,0,E)", is(equalToIgnoringCase(this.rover.executeCommand("lll"))));	
	}
	
	@Test
	public void theRoverFacesEastAfterLandingAndExecutingARightCommandThreeTimesInARow(){
		assertThat("(0,0,W)", is(equalToIgnoringCase(this.rover.executeCommand("rrr"))));	
	}
	
	@Test
	public void theRoverIsFacingTheSameDirectionAfterExecutingFourTimesTheSameTurnCommand(){
		assertThat("(0,0,N)", is(equalToIgnoringCase(this.rover.executeCommand("llll"))));
		assertThat("(0,0,N)", is(equalToIgnoringCase(this.rover.executeCommand("rrrr"))));
	}
	
	@Test
	public void theRoverMovesForwardNorthBoundedOnceLanding() {
		String command = generateCommand(10, "f");
		assertThat("(0,10,N)", is(equalToIgnoringCase(this.rover.executeCommand(command))));
		assertThat("(0,11,N)", is(equalToIgnoringCase(this.rover.executeCommand("f"))));
	}
	
	@Test
	public void theRoverMovesForwardSouthBoundedOnceLanding() {
		String command = generateCommand(10, "f");
		 this.rover.executeCommand(command);
		 this.rover.executeCommand("ll");
		 assertThat("(0,5,S)", is(equalToIgnoringCase( this.rover.executeCommand("fffff"))));
		 assertThat("(0,4,S)", is(equalToIgnoringCase( this.rover.executeCommand("f"))));
	}
	
	@Test
	public void theRoverMovesForwardWestBoundedOnceLanding() {
		String command = generateCommand(10, "f");
		 this.rover.executeCommand(command);
		 this.rover.executeCommand("r");
		 this.rover.executeCommand("fffff");
		 this.rover.executeCommand("ll");
		 //this.rover.executeCommand("ff");
		 assertThat("(3,10,W)", is(equalToIgnoringCase( this.rover.executeCommand("ff"))));
		 assertThat("(2,10,W)", is(equalToIgnoringCase( this.rover.executeCommand("f"))));
	}
	
	@Test
	public void theRoverMovesForwardEastBoundedOnceLanding() {
		String command = generateCommand(10, "f");
		 this.rover.executeCommand(command);
		 this.rover.executeCommand("r");
		this.rover.executeCommand("fffff");
		 assertThat("(10,10,E)", is(equalToIgnoringCase( this.rover.executeCommand("fffff"))));
		 assertThat("(11,10,E)", is(equalToIgnoringCase( this.rover.executeCommand("f"))));
	}
	
	@Test
	public void theRoverMovesBackwardNorthBoundedOnceLanding() {
		String command = generateCommand(10, "f");
		this.rover.executeCommand(command);
		this.rover.executeCommand("b");
		assertThat("(0,6,N)", is(equalToIgnoringCase( this.rover.executeCommand("bbb"))));
		assertThat("(0,5,N)", is(equalToIgnoringCase( this.rover.executeCommand("b"))));
	}
	
	@Test
	public void theRoverMovesBackwardSouthBoundedOnceLanding() {
		String command = generateCommand(10, "f");
		 this.rover.executeCommand(command);
		 this.rover.executeCommand("ll");
		 assertThat("(0,15,S)", is(equalToIgnoringCase( this.rover.executeCommand("bbbbb"))));
		 assertThat("(0,16,S)", is(equalToIgnoringCase( this.rover.executeCommand("b"))));
	}
	
	@Test
	public void theRoverMovesBackwardWestBoundedOnceLanding() {
		String command = generateCommand(10, "f");
		 this.rover.executeCommand(command);
		 this.rover.executeCommand("l");
		 assertThat("(3,10,W)", is(equalToIgnoringCase( this.rover.executeCommand("bbb"))));
	}
	
	@Test
	public void theRoverMovesBackwardEastBoundedOnceLanding() {
		String command = generateCommand(10, "f");
		 this.rover.executeCommand(command);
		 this.rover.executeCommand("r");
		 this.rover.executeCommand("fffff");
		 assertThat("(2,10,E)", is(equalToIgnoringCase( this.rover.executeCommand("bbb"))));
		 assertThat("(1,10,E)", is(equalToIgnoringCase( this.rover.executeCommand("b"))));
	}
	
	@Test
	public void moveLeftInsideGridOnClearPathNorthBounded() {
		this.rover.executeCommand("fffffrffffffffff");
		this.rover.executeCommand("ll");
		assertThat("(9,5,W)", is(equalToIgnoringCase( this.rover.executeCommand("f"))));
		assertThat("(10,5,W)", is(equalToIgnoringCase( this.rover.executeCommand("b"))));	
	}
	@Test
	public void moveLeftInsideGridOnClearPathSouthBounded() {
		this.rover.executeCommand("fffffrffffffffff");
		this.rover.executeCommand("rr");
		assertThat("(9,5,W)", is(equalToIgnoringCase( this.rover.executeCommand("f"))));
		assertThat("(10,5,W)", is(equalToIgnoringCase( this.rover.executeCommand("b"))));	
	}
	
	@Test
	public void moveRightInsideGridOnClearPathNorthBounded() {
		this.rover.executeCommand("fffffr");
		assertThat("(5,5,E)", is(equalToIgnoringCase( this.rover.executeCommand("fffff"))));
		assertThat("(4,5,E)", is(equalToIgnoringCase( this.rover.executeCommand("b"))));	
	}
	@Test
	public void moveRightInsideGridOnClearPathSouthBounded() {
		this.rover.executeCommand("fffffrffffffffff");
		this.rover.executeCommand("rf");
		this.rover.executeCommand("l");
		assertThat("(11,4,E)", is(equalToIgnoringCase( this.rover.executeCommand("f"))));
		assertThat("(10,4,E)", is(equalToIgnoringCase( this.rover.executeCommand("b"))));	
	}
	
	@Test
	public void theRoverShouldSpawnOnTheBottomSideWhenCrossingNorth(){
		MarsRover rover  = new MarsRover(100,100,"");
		rover.executeCommand(generateCommand(99, "f"));
		assertThat("(0,0,N)", is(equalToIgnoringCase( rover.executeCommand("f"))));
	}
	@Test
	public void roverShouldSpawnOnThebottomWhenCrossingNorthBackwards(){
		MarsRover rover2  = new MarsRover(100,100,"");
		rover2.executeCommand(generateCommand(99, "f"));
		rover2.executeCommand("ll");
		assertThat("(0,0,S)", is(equalToIgnoringCase( rover2.executeCommand("b"))));
		
	}
	
	private String generateCommand(int times,String symbol) {
		String command  = "";
		for (int i = 0; i < times; i++) {
			command += symbol;
		}
		return command;
	}
	@Test
	public void theRoverShouldSpawnOnTheNorthSideWhenCrossingSouth(){
		MarsRover rover  = new MarsRover(100,100,"");
		rover.executeCommand("ll");
		assertThat("(0,99,S)", is(equalToIgnoringCase( rover.executeCommand("f"))));
	}
	@Test
	public void theRoverShouldSpawnOnTheNorthSideWhenCrossingSouthBackwards(){
		MarsRover rover2  = new MarsRover(100,100,"");
		assertThat("(0,99,N)", is(equalToIgnoringCase( rover2.executeCommand("b"))));
	}
	
	@Test
	public void theRoverShouldSpawnOnTheRightSideWhenCrossingLeft(){
		MarsRover rover = new MarsRover(100, 100, "");
		rover.executeCommand("l");
		assertThat("(99,0,W)", is(equalToIgnoringCase( rover.executeCommand("f"))));
	}
	@Test
	public void theRoverShouldSpawnOnTheRightSideWhenCrossingLeftBackward(){
		MarsRover rover2 = new MarsRover(100, 100,"");
		rover2.executeCommand("r");
		assertThat("(99,0,E)", is(equalToIgnoringCase( rover2.executeCommand("b"))));
	}
	@Test
	public void theRoverShouldSpawnOnTheLeftSideWhenCrossingRight(){
		MarsRover rover = new MarsRover(100, 100, "");
		rover.executeCommand("r");
		rover.executeCommand(Commons.generateCommand(99, "f"));
		assertThat("(0,0,E)", is(equalToIgnoringCase(rover.executeCommand("f"))));
	}
	@Test
	public void theRoverShouldSpawnOnTheLeftSideWhenCrossingRightBackwards(){
		MarsRover rover2 = new MarsRover(100, 100, "");
		rover2.executeCommand("r");
		rover2.executeCommand(Commons.generateCommand(99, "f"));
		rover2.executeCommand("ll");
		assertThat("(0,0,W)", is(equalToIgnoringCase(rover2.executeCommand("b"))));
	}
	
//	@Test
//	public void theRoverEncountersAnObstacleOnTheEdgesOfThePlanetWhileMovingForwardLeft(){
//		String leftEdgeObstacle = generateObstacleInPosition(0, 50);
//
//		MarsRover roverL = new MarsRover(100, 100, leftEdgeObstacle);
//		assertThat("(0,49,N)(0,50)", is(equalToIgnoringCase( roverL.executeCommand(goToMiddleLeftBorderCommandFromSouth()))));
//		assertThat("(0,51,N)(0,50)", is(equalToIgnoringCase( roverL.executeCommand(goToMiddleLeftBorderCommandNorth()))));
//	//	assertThat("(1,50,N)(0,50)", is(equalToIgnoringCase( roverL.executeCommand(goToMiddleLeftBorderCommandFromEast()))));
//		}
	
//	@Test
//	public void theRoverEncountersAnObstacleOnTheEdgesOfThePlanetWhileMovingForwardRight(){
//		String rightEdgeObstacle = generateObstacleInPosition(99, 50);
//		MarsRover roverR = new MarsRover(100, 100, rightEdgeObstacle);
//		//assertThat("(98,50,N)(99,50)", is(equalToIgnoringCase( roverR.executeCommand(goToMiddleRightBorderFromWest()))));
//		assertThat("(99,51,N)(99,50)", is(equalToIgnoringCase( roverR.executeCommand(goToMiddleRightBorderFromNorth()))));
//		assertThat("(99,41,N)(99,50)", is(equalToIgnoringCase( roverR.executeCommand(goToMiddleRightBorderFromSouth()))));
//	
//	}
	// Changed by Oscar
	@Test
	public void theRoverEncountersAnObstacleOnTheEdgesOfThePlanetWhileMovingForward(){
		String topEdgeObstacle = generateObstacleInPosition(50, 99);

		MarsRover roverT = new MarsRover(100, 100, topEdgeObstacle);
		//assertThat("(49,99,N)(50,99)", is(equalToIgnoringCase( roverT.executeCommand(goToMiddleTopBorderFromWest()))));
		//assertThat("(51,99,N)(50,99)", is(equalToIgnoringCase( roverT.executeCommand(goToMiddleTopBorderFromEast()))));
		assertThat("(50,98,N)(50,99)", is(equalToIgnoringCase( roverT.executeCommand(goToMiddleTopBorderFromSouth()))));

		String bottomEdgeObstacle = generateObstacleInPosition(50, 0);
		MarsRover roverB = new MarsRover(100, 100, bottomEdgeObstacle);
		//assertThat("(49,0,N)(50,0)", is(equalToIgnoringCase( roverB.executeCommand(goToMiddleBottomBorderFromWest()))));
		//assertThat("(51,0,N)(50,0)", is(equalToIgnoringCase( roverB.executeCommand(goToMiddleBottomBorderFromEast()))));
		assertThat(roverB.executeCommand(goToMiddleBottomBorderFromNorth()), anyOf(equalToIgnoringCase("(50,1,N)(50,0)"), equalToIgnoringCase("(50,1,S)(50,0)")));
	}
	
	
	@Test
	public void theRoverEncountersAnObstacleOnTheCornersOfThePlanetWhileMovingForward(){
		String topLeftCornerObstacle = generateObstacleInPosition(0, 99);

		MarsRover roverL = new MarsRover(100, 100, topLeftCornerObstacle);
		assertThat("(0,98,N)(0,99)", is(equalToIgnoringCase( roverL.executeCommand(goToTopLeftCornerFromSouth()))));
		//assertThat("(1,99,W)(0,99)", is(equalToIgnoringCase( roverL.executeCommand(goToTopLeftCornerFromEast()))));

		String topRightCornerObstacle = generateObstacleInPosition(99, 99);
		MarsRover roverR = new MarsRover(100, 100, topRightCornerObstacle);
		//assertThat("(98,99,E)(99,99)", is(equalToIgnoringCase( roverR.executeCommand(goToTopRightCornerFromWest()))));
		assertThat("(99,98,N)(99,99)", is(equalToIgnoringCase( roverR.executeCommand(goToTopRightCornerFromSouth()))));

		String bottomRightCornerObstacle = generateObstacleInPosition(99, 0);
		MarsRover roverT = new MarsRover(100, 100, bottomRightCornerObstacle);
		//assertThat("(98,0,E)(99,0)", is(equalToIgnoringCase( roverT.executeCommand(goToBottomRightCornerFromWest()))));
		assertThat("(99,1,S)(99,0)", is(equalToIgnoringCase( roverT.executeCommand(goToBottomRightCornerFromNorth()))));

	}
	
	@Test
	public void theRoverEncountersAnObstacleInTheMiddleOfThePlanetWhileMovingForward(){
		String middleObstacle = generateObstacleInPosition(50, 50);
		MarsRover rover = new MarsRover(100, 100, middleObstacle);
		MarsRover rover2 = new MarsRover(100, 100, middleObstacle);
		MarsRover rover3 = new MarsRover(100, 100, middleObstacle);
		MarsRover rover4 = new MarsRover(100, 100, middleObstacle);
		assertThat("(49,50,E)(50,50)", is(equalToIgnoringCase( rover.executeCommand(goToMiddleOfPlanetFromWest()))));
		assertThat("(50,51,S)(50,50)", is(equalToIgnoringCase( rover2.executeCommand(goToMiddleOfPlanetFromNorth()))));
		assertThat("(51,50,W)(50,50)", is(equalToIgnoringCase( rover3.executeCommand(goToMiddleOfPlanetFromEast()))));
		assertThat("(50,49,N)(50,50)", is(equalToIgnoringCase( rover4.executeCommand(goToMiddleOfPlanetFromSouth()))));
	}
	// Changed by Oscar
	@Test 
	public void theRoverEncounters2ObstaclesInARowFromLanding(){
		String firstObstacle = generateObstacleInPosition(0, 1);
		String secondObstacle = generateObstacleInPosition(1,0);

		MarsRover rover = new MarsRover(100, 100, firstObstacle+secondObstacle);
		assertThat(rover.executeCommand("frfl"), anyOf(equalToIgnoringCase("(0,0,N)(0,1)(1,0)"), equalToIgnoringCase("(0,0,N)(0,1)")));
	}

	// Changed by Oscar
	@Test
	public void theRoverEncounters2ObstaclesInARow(){
		String firstHorizontalObstacle = generateObstacleInPosition(1, 1);
		String secondHorizontalObstacle = generateObstacleInPosition(3, 1);
		String firstVerticalObstacle = generateObstacleInPosition(1, 0);
		String secondVerticalObstacle = generateObstacleInPosition(1, 2);

		MarsRover roverH = new MarsRover(100, 100, firstHorizontalObstacle+secondHorizontalObstacle);
		assertThat(roverH.executeCommand("rflfrflfrflf"), anyOf(equalToIgnoringCase("(2,2,N)(1,1)(3,1)"), equalToIgnoringCase("(1,0,N)(1,1)")));

		MarsRover roverV = new MarsRover(100, 100, firstVerticalObstacle+secondVerticalObstacle);
		assertThat(roverV.executeCommand("rflfrflfrfl"), anyOf(equalToIgnoringCase("(2,1,N)(1,0)(1,2)"), equalToIgnoringCase("(0,0,E)(1,0)")));
	}

	// Changed by Oscar
	@Test
	public void theRoverEncounters3ObstaclesInARow(){
		String obstacle11 = Commons.generateObstacleInPosition(1, 1);
		String obstacle22 = Commons.generateObstacleInPosition(2, 2);
		String obstacle31 = Commons.generateObstacleInPosition(3, 1);
		String obstacle20 = Commons.generateObstacleInPosition(2, 0);

		MarsRover rover1 = new MarsRover(100, 100, obstacle11+obstacle22 + obstacle31);
		assertThat(rover1.executeCommand("rfflfrflflfr"), anyOf(equalToIgnoringCase("(2,1,N)(3,1)(2,2)(1,1)"), equalToIgnoringCase("(2,1,E)(3,1)")));

		MarsRover rover2 = new MarsRover(100, 100, obstacle20+obstacle22 + obstacle31);
		assertThat(rover2.executeCommand("rflfrfrflflf"), anyOf(equalToIgnoringCase("(2,1,N)(2,0)(3,1)(2,2)"), equalToIgnoringCase("(2,1,S)(2,0)")));

		MarsRover rover3 = new MarsRover(100, 100, obstacle11+obstacle20 + obstacle31);
		assertThat(rover3.executeCommand("ffrffrfrflflfl"), anyOf(equalToIgnoringCase("(2,1,N)(1,1)(2,0)(3,1)"), equalToIgnoringCase("(2,1,W)(1,1)")));
	}

//	@Test
//	public void theRoverEncountersSevenObstaclesOnATourAroundThePlanet(){
//		String obstacle1 = Commons.generateObstacleInPosition(0, 50);
//		String obstacle2 = Commons.generateObstacleInPosition(0, 99);
//		String obstacle3 = Commons.generateObstacleInPosition(50,99);
//		String obstacle4 = Commons.generateObstacleInPosition(99, 99);
//		String obstacle5 = Commons.generateObstacleInPosition(99, 50);
//		String obstacle6 = Commons.generateObstacleInPosition(99, 0);
//		String obstacle7 = Commons.generateObstacleInPosition(50, 0);
//
//		MarsRover rover = new MarsRover(100, 100, obstacle1+obstacle2+obstacle3+obstacle4+obstacle5+obstacle6+obstacle7);
//		assertThat("(0,0,N)(0,50)(0,99)(50,99)(99,99)(99,50)(99,0)(50,0)", is(equalToIgnoringCase( rover.executeCommand(
//				Commons.goToMiddleLeftBorderCommandFromSouth() + "rflfflfr" + Commons.generateCommand(50, "f") +
//				"rflfr" + Commons.generateCommand(50, "f") + "rflfflfr" + Commons.generateCommand(50, "f") +
//				"rflfr" + Commons.generateCommand(50, "f") + "rflfflfr" + Commons.generateCommand(50, "f") +
//				"rflfr" + Commons.generateCommand(50, "f") + "rflfflfr" + Commons.generateCommand(50, "f") + "r"
//				))));
//
////		String obstacle1 = Commons.generateObstacleInPosition(0, 50);
////		String obstacle2 = Commons.generateObstacleInPosition(0, 99);
////		String obstacle3 = Commons.generateObstacleInPosition(50,99);
////		String obstacle4 = Commons.generateObstacleInPosition(99, 99);
////		String obstacle5 = Commons.generateObstacleInPosition(99, 50);
////		String obstacle6 = Commons.generateObstacleInPosition(99, 0);
////		String obstacle7 = Commons.generateObstacleInPosition(50, 0);
//
//		MarsRover rover2 = new MarsRover(100, 100, obstacle7+obstacle6+obstacle5+obstacle4+obstacle3+obstacle2+obstacle1);
//		assertThat("(0,0,N)(50,0)(99,0)(99,50)(99,99)(50,99)(0.99)(0,50)", is(equalToIgnoringCase(rover2.executeCommand(Commons.goToMiddleBottomBorderFromWest() +
//				"lfrffrfl" + Commons.generateCommand(50, "f") + "lfrfl" + Commons.generateCommand(50, "f") + "lfrffrfl" + Commons.generateCommand(50, "f") +
//				"lfrfl" + Commons.generateCommand(50, "f") + "lfrffrfl" + Commons.generateCommand(50, "f") + "lfrfl" + Commons.generateCommand(50, "f") +
//				"lfrffrfl" + Commons.generateCommand(50, "f") + "rr"
//				))));
//	}

	@Test
	public void theRoverEncountersAnObstacleOnTheCornersOfThePlanetWhileMovingBackwardsLeft(){
		String topLeftCornerObstacle = generateObstacleInPosition(0, 99);
		MarsRover roverL = new MarsRover(100, 100, topLeftCornerObstacle);
		assertThat("(0,98,S)(0,99)", is(equalToIgnoringCase( roverL.executeCommand(goToTopLeftCornerFromSouthBackwards()))));
		MarsRover roverR = new MarsRover(100, 100, topLeftCornerObstacle);
		assertThat("(1,99,E)(0,99)",is( roverR.executeCommand(goToTopRightCornerFromSouth()+"r" + generateCommand(99, "b"))));
	}
	
//	@Test
//	public void theRoverEncountersAnObstacleOnTheCornersOfThePlanetWhileMovingBackwardsRight(){
//		String topRightCornerObstacle = generateObstacleInPosition(99, 99);
//		String bottomRightCornerObstacle = generateObstacleInPosition(99, 0);
//
//		MarsRover roverR = new MarsRover(100, 100, topRightCornerObstacle);
//		//assertThat("(98,99,W)(99,99)", is(equalToIgnoringCase( roverR.executeCommand(goToTopRightCornerFromWestBackwards()))));
//		assertThat("(99,98,S)(99,99)", is(equalToIgnoringCase( roverR.executeCommand(goToTopRightCornerFromSouthBackwards()))));
//		MarsRover roverT = new MarsRover(100, 100, bottomRightCornerObstacle);
//		//assertThat("(98,0,W)(99,0)", is(equalToIgnoringCase( roverT.executeCommand(goToBottomRightCornerFromWestBackwards()))));
//		assertThat("(99,1,N)(99,0)", is(equalToIgnoringCase( roverT.executeCommand(goToBottomRightCornerFromNorthBackwards()))));
//
//	}
	
//	@Test
//	public void theRoverEncountersAnObstacleOnTheEdgesOfThePlanetWhileMovingBackwardLeft(){
//		String leftEdgeObstacle = generateObstacleInPosition(0, 50);
//		
//
//		MarsRover roverL = new MarsRover(100, 100, leftEdgeObstacle);
//		assertThat("(0,49,S)(0,50)", is(equalToIgnoringCase( roverL.executeCommand(goToMiddleLeftBorderCommandFromSouthBackwards()))));
//		assertThat("(0,51,N)(0,50)", is(equalToIgnoringCase( roverL.executeCommand(goToMiddleLeftBorderCommandNorthBackwards()))));
//		//assertThat("(1,50,E)(0,50)", is(equalToIgnoringCase( roverL.executeCommand(goToMiddleLeftBorderCommandFromEastBackwards()))));
//
//		
//	}
//	
//	@Test
//	public void theRoverEncountersAnObstacleOnTheEdgesOfThePlanetWhileMovingBackwardRight(){
//		String rightEdgeObstacle = generateObstacleInPosition(99, 50);
//
//		MarsRover roverR = new MarsRover(100, 100, rightEdgeObstacle);
//		//assertThat("(98,50,W)(99,50)", is(equalToIgnoringCase( roverR.executeCommand(goToMiddleRightBorderFromWestBackwards()))));
//		assertThat("(99,51,N)(99,50)", is(equalToIgnoringCase( roverR.executeCommand(goToMiddleRightBorderFromNorthBackwards()))));
//		assertThat("(99,41,N)(99,50)", is(equalToIgnoringCase( roverR.executeCommand(goToMiddleRightBorderFromSouthBackwards()))));
//
//	}
	@Test
	public void theRoverEncountersAnObstacleOnTheEdgesOfThePlanetWhileMovingBackwardRighTop(){
		String topEdgeObstacle = generateObstacleInPosition(50, 99);
		MarsRover roverT = new MarsRover(100, 100, topEdgeObstacle);
		//assertThat("(49,99,W)(50,99)", is(equalToIgnoringCase( roverT.executeCommand(goToMiddleTopBorderFromWestBackwards()))));
		//assertThat("(51,99,E)(50,99)", is(equalToIgnoringCase( roverT.executeCommand(goToMiddleTopBorderFromEastBackwards()))));
		assertThat("(50,98,S)(50,99)", is(equalToIgnoringCase( roverT.executeCommand(goToMiddleTopBorderFromSouthBackwards()))));

		String bottomEdgeObstacle = generateObstacleInPosition(50, 0);
		MarsRover roverB = new MarsRover(100, 100, bottomEdgeObstacle);
		//assertThat("(49,0,W)(50,0)", is(equalToIgnoringCase( roverB.executeCommand(goToMiddleBottomBorderFromWestBackwards()))));
		//assertThat("(51,0,E)(50,0)", is(equalToIgnoringCase( roverB.executeCommand(goToMiddleBottomBorderFromEastBackwards()))));
		assertThat("(50,1,N)(50,0)", is(equalToIgnoringCase( roverB.executeCommand(goToMiddleBottomBorderFromNorthBackwards()))));
	}
	// Changed by Oscar
	// Why is this test case now uncommented??
	//
	// Was wrong --> In the 2nd assertion, the rover did not roll back to (0,0,N) before moving
	@Test
	public void theRoverEncountersAnObstacleInTheMiddleOfThePlanetWhileMovingBackward(){
		String middleObstacle = generateObstacleInPosition(50, 50);
		MarsRover rover1 = new MarsRover(100, 100, middleObstacle);
		MarsRover rover2 = new MarsRover(100, 100, middleObstacle);

		//assertThat("(49,50,W)(50,50)", is(equalToIgnoringCase( rover.executeCommand(goToMiddleOfPlanetFromWestBackwards()))));
		assertThat("(50,51,N)(50,50)", is(equalToIgnoringCase( rover1.executeCommand(goToMiddleOfPlanetFromNorthBackwards()))));
		//assertThat("(51,50,E)(50,50)", is(equalToIgnoringCase( rover.executeCommand(goToMiddleOfPlanetFromEastBackwards()))));
		assertThat("(50,49,S)(50,50)", is(equalToIgnoringCase( rover2.executeCommand(goToMiddleOfPlanetFromSouthBackwards()))));
	}

	// Changed by Oscar
	@Test
	public void theRoverEncountersSevenObstaclesOnATourAroundThePlanet(){
		String obstacle1 = generateObstacleInPosition(0, 50);
		String obstacle2 = generateObstacleInPosition(0, 99);
		String obstacle3 = generateObstacleInPosition(50,99);
		String obstacle4 = generateObstacleInPosition(99, 99);
		String obstacle5 = generateObstacleInPosition(99, 50);
		String obstacle6 = generateObstacleInPosition(99, 0);
		String obstacle7 = generateObstacleInPosition(50, 0);
		MarsRover rover3 = new MarsRover(100, 100, obstacle1+obstacle2+obstacle3+obstacle4+obstacle5+obstacle6+obstacle7);
		assertThat(rover3.executeCommand(
				goToMiddleLeftBorderCommandFromSouthBackwards() + "rblbblbr" + generateCommand(50, "b") +
				"rblbr" + generateCommand(50, "b") + "rblbblbr" + generateCommand(50, "b") + "rblbr" + generateCommand(50, "b") +
				"rblbblbr" + generateCommand(50, "b") + "rblbr" + generateCommand(50, "b") + "rblbblbr" + generateCommand(50, "b") + "l"),
				anyOf(equalToIgnoringCase("(0,0,N)(0,50)(0,99)(50,99)(99,99)(99,50)(99,0)(50,0)"), equalToIgnoringCase("(0,49,S)(0,50)")));
//		String obstacle1 = generateObstacleInPosition(0, 50);
//		String obstacle2 = generateObstacleInPosition(0, 99);
//		String obstacle3 = generateObstacleInPosition(50,99);
//		String obstacle4 = generateObstacleInPosition(99, 99);
//		String obstacle5 = generateObstacleInPosition(99, 50);
//		String obstacle6 = generateObstacleInPosition(99, 0);
//		String obstacle7 = generateObstacleInPosition(50, 0);
		MarsRover rover4 = new MarsRover(100, 100, obstacle7+obstacle6+obstacle5+obstacle4+obstacle3+obstacle2+obstacle1);
		assertThat(rover4.executeCommand(goToMiddleBottomBorderFromWestBackwards() + "lbrbbrbl" + generateCommand(50, "b") +
				"lbrbl" + generateCommand(50, "b") + "lbrbbrbl" + generateCommand(50, "b") + "lbrbl" + generateCommand(50, "b") +
				"lbrbbrbl" + generateCommand(50, "b") + "lbrbl" + generateCommand(50, "b") + "lbrbbrbl" + generateCommand(50, "b")),
				anyOf(equalToIgnoringCase("(0,0,N)(50,0)(99,0)(99,50)(99,99)(50,99)(0,99)(0,50)"), equalToIgnoringCase("(49,0,W)(50,0)")));
	}
	
	// Changed by Oscar
	@Test
	public void theRoverEncountersAnObstacleOnTheEdgesOfThePlanetWhileMovingForwardRight(){
		String rightEdgeObstacle = generateObstacleInPosition(99, 50);
		MarsRover roverR = new MarsRover(100, 100, rightEdgeObstacle);
		assertThat(roverR.executeCommand(goToMiddleRightBorderFromWest()), anyOf(equalToIgnoringCase("(98,50,N)(99,50)"), equalToIgnoringCase("(98,50,E)(99,50)")));
	
		String topEdgeObstacle = generateObstacleInPosition(50, 99);
		MarsRover roverT = new MarsRover(100, 100, topEdgeObstacle);
		assertThat(roverT.executeCommand(goToMiddleTopBorderFromWest()), anyOf(equalToIgnoringCase("(49,99,N)(50,99)"), equalToIgnoringCase("(49,99,E)(50,99)")));

	
		String bottomEdgeObstacle = generateObstacleInPosition(50, 0);
		MarsRover roverB = new MarsRover(100, 100, bottomEdgeObstacle);
		assertThat(roverB.executeCommand(goToMiddleBottomBorderFromWest()), anyOf(equalToIgnoringCase("(49,0,N)(50,0)"), equalToIgnoringCase("(49,0,E)(50,0)")));
	}
	
//	@Test
//	public void theRoverEncountersAnObstacleOnTheCornersOfThePlanetWhileMovingForwardLeft(){
//		String topRightCornerObstacle = generateObstacleInPosition(99, 99);
//		MarsRover roverR = new MarsRover(100, 100, topRightCornerObstacle);
//		assertThat("(98,99,E)(99,99)", is(equalToIgnoringCase( roverR.executeCommand(goToTopRightCornerFromWest()))));
//	
//
//		String bottomRightCornerObstacle = generateObstacleInPosition(99, 0);
//		MarsRover roverT = new MarsRover(100, 100, bottomRightCornerObstacle);
//		assertThat("(98,0,E)(99,0)", is(equalToIgnoringCase( roverT.executeCommand(goToBottomRightCornerFromWest()))));
//
//	}
	
	@Test
	public void theRoverEncountersAnObstacleOnTheCornersOfThePlanetWhileMovingBackwardsRight(){
		String topRightCornerObstacle = generateObstacleInPosition(99, 99);
		String bottomRightCornerObstacle = generateObstacleInPosition(99, 0);

		MarsRover roverR = new MarsRover(100, 100, topRightCornerObstacle);
		assertThat("(98,99,W)(99,99)", is(equalToIgnoringCase( roverR.executeCommand(goToTopRightCornerFromWestBackwards()))));

		MarsRover roverT = new MarsRover(100, 100, bottomRightCornerObstacle);
		assertThat("(98,0,W)(99,0)", is(equalToIgnoringCase( roverT.executeCommand(goToBottomRightCornerFromWestBackwards()))));

	}
	
	@Test
	public void theRoverEncountersAnObstacleOnTheEdgesOfThePlanetWhileMovingBackwardRight(){
		String rightEdgeObstacle = generateObstacleInPosition(99, 50);

		MarsRover roverR = new MarsRover(100, 100, rightEdgeObstacle);
		assertThat("(98,50,W)(99,50)", is(equalToIgnoringCase( roverR.executeCommand(goToMiddleRightBorderFromWestBackwards()))));

		String topEdgeObstacle = generateObstacleInPosition(50, 99);
		MarsRover roverT = new MarsRover(100, 100, topEdgeObstacle);
		assertThat("(49,99,W)(50,99)", is(equalToIgnoringCase( roverT.executeCommand(goToMiddleTopBorderFromWestBackwards()))));


		String bottomEdgeObstacle = generateObstacleInPosition(50, 0);
		MarsRover roverB = new MarsRover(100, 100, bottomEdgeObstacle);
		assertThat("(49,0,W)(50,0)", is(equalToIgnoringCase( roverB.executeCommand(goToMiddleBottomBorderFromWestBackwards()))));

	}
//	@Test
//	public void theRoverEncountersAnObstacleInTheMiddleOfThePlanetWhileMovingBackward(){
//		String middleObstacle = generateObstacleInPosition(50, 50);
//		MarsRover rover = new MarsRover(100, 100, middleObstacle);
//
//		assertThat("(49,50,W)(50,50)", is(equalToIgnoringCase( rover.executeCommand(goToMiddleOfPlanetFromWestBackwards()))));
//		
//	}
	
	// Changed by Oscar
	@Test
	public void theRoverEncountersAnObstacleOnTheEdgesOfThePlanetWhileMovingForwardLeft(){
		String leftEdgeObstacle = generateObstacleInPosition(0, 50);
		MarsRover roverL = new MarsRover(100, 100, leftEdgeObstacle);
		assertThat(roverL.executeCommand(goToMiddleLeftBorderCommandFromEast()), anyOf(equalToIgnoringCase("(1,50,N)(0,50)"), equalToIgnoringCase("(1,50,W)(0,50)")));
		
		String topEdgeObstacle = generateObstacleInPosition(50, 99);
		MarsRover roverT = new MarsRover(100, 100, topEdgeObstacle);
		assertThat(roverT.executeCommand(goToMiddleTopBorderFromEast()), anyOf(equalToIgnoringCase("(51,99,N)(50,99)"), equalToIgnoringCase("(51,99,W)(50,99)")));

		String bottomEdgeObstacle = generateObstacleInPosition(50, 0);
		MarsRover roverB = new MarsRover(100, 100, bottomEdgeObstacle);
		assertThat(roverB.executeCommand(goToMiddleBottomBorderFromEast()), anyOf(equalToIgnoringCase("(51,0,N)(50,0)"), equalToIgnoringCase("(51,0,W)(50,0)")));
	}
	
	@Test
	public void theRoverEncountersAnObstacleOnTheCornersOfThePlanetWhileMovingForwardLeft(){
		String topLeftCornerObstacle = generateObstacleInPosition(0, 99);
		
		MarsRover roverL = new MarsRover(100, 100, topLeftCornerObstacle);
		assertThat("(1,99,W)(0,99)", is(equalToIgnoringCase( roverL.executeCommand(goToTopLeftCornerFromEast()))));

	}
	
	@Test
	public void theRoverEncountersAnObstacleOnTheEdgesOfThePlanetWhileMovingBackwardLeft(){
		String leftEdgeObstacle = generateObstacleInPosition(0, 50);
		MarsRover roverL = new MarsRover(100, 100, leftEdgeObstacle);
		assertThat("(1,50,E)(0,50)", is(equalToIgnoringCase( roverL.executeCommand(goToMiddleLeftBorderCommandFromEastBackwards()))));

		String topEdgeObstacle = generateObstacleInPosition(50, 99);
		MarsRover roverT = new MarsRover(100, 100, topEdgeObstacle);
		assertThat("(51,99,E)(50,99)", is(equalToIgnoringCase( roverT.executeCommand(goToTopRightCornerFromSouth() +"r" + generateCommand(50, "b")))));

		String bottomEdgeObstacle = generateObstacleInPosition(50, 0);
		MarsRover roverB = new MarsRover(100, 100, bottomEdgeObstacle);
		assertThat("(51,0,E)(50,0)", is(equalToIgnoringCase( roverB.executeCommand(goToMiddleBottomBorderFromEastBackwards()))));

	}
	
//	@Test
//	public void theRoverEncountersAnObstacleInTheMiddleOfThePlanetWhileMovingBackward(){
//		String middleObstacle = generateObstacleInPosition(50, 50);
//		MarsRover rover = new MarsRover(100, 100, middleObstacle);
//		assertThat("(51,50,E)(50,50)", is(equalToIgnoringCase( rover.executeCommand(goToMiddleOfPlanetFromEastBackwards()))));
//
//	}
	
	@Test
	public void roverEncountersAnObstacleWhenTriesToSpawnNorthWhileGoingForward(){
		MarsRover rover = new MarsRover(100, 100, "(0,99)");

		assertThat("(0,0,S)(0,99)", is(equalToIgnoringCase(( rover.executeCommand("llf")))));
	}
	@Test
	public void roverEncountersAnObstacleWhenTriesToSpawnSouthWhileGoingForward(){
		MarsRover rover = new MarsRover(100, 100, "(1,0)");
		rover.executeCommand(goToTopLeftCornerFromSouth());
		rover.executeCommand("rfl");
		assertThat("(1,99,N)(1,0)", is(equalToIgnoringCase(( rover.executeCommand("f")))));

	}
	
	@Test
	public void roverEncountersAnObstacleWhenTriesToSpawnNorthWhileGoingBackward(){
		MarsRover rover = new MarsRover(100, 100, "(0,99)");
		assertThat("(0,0,N)(0,99)", is(equalToIgnoringCase(( rover.executeCommand("b")))));
	}
	@Test
	public void roverEncountersAnObstacleWhenTriesToSpawnSouthWhileGoingBackward(){
		MarsRover rover = new MarsRover(100, 100, "(1,0)");
		rover.executeCommand(goToTopLeftCornerFromSouth());
		rover.executeCommand("rfl");
		assertThat("(1,99,S)(1,0)", is(equalToIgnoringCase(( rover.executeCommand("llb")))));
	}
	@Test
	public void roverEncountersAnObstacleWhenTriesToSpawnWestGoingForward(){
		MarsRover rover = new MarsRover(100, 100, "(0,30)");
		rover.executeCommand("r");
		rover.executeCommand(generateCommand(99, "f"));
		rover.executeCommand("l");
		rover.executeCommand(generateCommand(30, "f"));
		rover.executeCommand("r");
		assertThat("(99,30,E)(0,30)", is(equalToIgnoringCase(( rover.executeCommand("f")))));
		//assertThat("(99,30,W)(0,30)()", is(equalToIgnoringCase(( rover.executeCommand("llb")))));

	}
	
	@Test
	public void roverEncountersAnObstacleWhenTriesToSpawnWestGoingBackward(){
		MarsRover rover = new MarsRover(100, 100, "(0,30)");
		rover.executeCommand("r");
		rover.executeCommand(generateCommand(99, "f"));
		rover.executeCommand("l");
		rover.executeCommand(generateCommand(30, "f"));
		rover.executeCommand("r");
		assertThat("(99,30,W)(0,30)", is(equalToIgnoringCase(( rover.executeCommand("llb")))));
	}
	@Test
	public void roverEncountersAnObstacleWhenTriesToSpawnEastGoingForward(){
		MarsRover rover = new MarsRover(100, 100, "(99,30)");
		rover.executeCommand(generateCommand(30, "f"));
		rover.executeCommand("l");
		assertThat("(0,30,W)(99,30)", is(equalToIgnoringCase( rover.executeCommand("f"))));

	}
	@Test
	public void roverEncountersAnObstacleWhenTriesToSpawnEastGoingBackward(){
		MarsRover rover = new MarsRover(100, 100, "(99,30)");
		rover.executeCommand(generateCommand(30, "f"));
		rover.executeCommand("l");
		assertThat("(0,30,E)(99,30)", is(equalToIgnoringCase( rover.executeCommand("llb"))));
	}

//	@Test
//	public void roverEncountersAnObstacleWhenTriesToSpawnWestGoingForward(){
//		MarsRover rover = new MarsRover(100, 100, "(0,30)");
//		rover.executeCommand("r");
//		rover.executeCommand(generateCommand(99, "f"));
//		rover.executeCommand("l");
//		rover.executeCommand(generateCommand(29, "f"));
//		rover.executeCommand("r");
//		assertThat("(99,30, E)(0,30)", is(equalToIgnoringCase(( rover.executeCommand("f")))));
//		assertThat("(99,30,W)(0,30)", is(equalToIgnoringCase(( rover.executeCommand("llb")))));
//	}
//	
//	@Test
//	public void roverEncountersAnObstacleWhenTriesToSpawnEastGoingForward(){
//		MarsRover rover = new MarsRover(100, 100, "(99,30)");
//		rover.executeCommand(generateCommand(29, "f"));
//		rover.executeCommand("l");
//		assertThat("(0,30, W)(99,30)", is(equalToIgnoringCase( rover.executeCommand("f"))));
//
//	}

}
