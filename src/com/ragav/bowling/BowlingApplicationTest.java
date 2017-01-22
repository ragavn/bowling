package com.ragav.bowling;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class BowlingApplicationTest {
	
	private BowlingApplication app;
	
	@Before
	public void setUp() {
		List<Integer> input = new ArrayList<>();
		input.add(9);
		input.add(1);
		input.add(9);
		input.add(1);
		input.add(1);
		input.add(10);
		input.add(1);
		input.add(1);
		this.app = new BowlingApplication(input);
	}
	
	@Test
	public void testCalculateTotalScore() {
		this.app.calculateTotalScore();
		assertEquals(43, this.app.getTotalScore());
	}
	
	@Test
	public void testIsStrike() {
		assertTrue(this.app.isStrike(5));
	}
	
	@Test
	public void testIsSpare() {
		assertTrue(this.app.isSpare(2));
	}
	
	@Test
	public void testCalculateStrikeBonus() {
		assertEquals(2, this.app.calculateStrikeBonus(5));
	}
	
	@Test
	public void testCalculateSpareBonus() {
		assertEquals(1, this.app.calculateSpareBonus(2));
	}
}
