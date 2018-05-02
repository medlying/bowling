package com.sodacar.dojo;


import com.sodacar.dojo.texas.Hand;
import com.sodacar.dojo.texas.TexasCompare;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

/**
 * @author Hu bosong
 * @date 2018/4/23
 */
public class TexasTest {

    @Test
    public void testSort() {

        Hand handA = new Hand(asList(
                new Hand.Card(Hand.Card.Suits.FANGKUAI, Hand.Card.Point.A2),
                new Hand.Card(Hand.Card.Suits.FANGKUAI, Hand.Card.Point.A13),
                new Hand.Card(Hand.Card.Suits.FANGKUAI, Hand.Card.Point.A3),
                new Hand.Card(Hand.Card.Suits.FANGKUAI, Hand.Card.Point.A6),
                new Hand.Card(Hand.Card.Suits.FANGKUAI, Hand.Card.Point.A8)
        ));
        Hand handB = new Hand(asList(
                new Hand.Card(Hand.Card.Suits.HEITAO, Hand.Card.Point.A2),
                new Hand.Card(Hand.Card.Suits.MEIHUA, Hand.Card.Point.A2),
                new Hand.Card(Hand.Card.Suits.HONGTAO, Hand.Card.Point.A2),
                new Hand.Card(Hand.Card.Suits.FANGKUAI, Hand.Card.Point.A4),
                new Hand.Card(Hand.Card.Suits.FANGKUAI, Hand.Card.Point.A2)
        ));
        TexasCompare texasCompare = new TexasCompare();
        texasCompare.sort(handA);
        texasCompare.sort(handB);
        assertEquals(handA.getCards().get(0).getPoint().getNum(), 2);
        assertEquals(handB.getCards().get(0).getPoint().getNum(), 2);
    }

    @Test
    public void isRoyalFlush() {
        Hand hand = new Hand(asList(
                new Hand.Card(Hand.Card.Suits.FANGKUAI, Hand.Card.Point.A2),
                new Hand.Card(Hand.Card.Suits.FANGKUAI, Hand.Card.Point.A3),
                new Hand.Card(Hand.Card.Suits.FANGKUAI, Hand.Card.Point.A4),
                new Hand.Card(Hand.Card.Suits.FANGKUAI, Hand.Card.Point.A5),
                new Hand.Card(Hand.Card.Suits.FANGKUAI, Hand.Card.Point.A6)
        ));
        Hand handA = new Hand(asList(
                new Hand.Card(Hand.Card.Suits.MEIHUA, Hand.Card.Point.A2),
                new Hand.Card(Hand.Card.Suits.FANGKUAI, Hand.Card.Point.A3),
                new Hand.Card(Hand.Card.Suits.FANGKUAI, Hand.Card.Point.A4),
                new Hand.Card(Hand.Card.Suits.FANGKUAI, Hand.Card.Point.A5),
                new Hand.Card(Hand.Card.Suits.FANGKUAI, Hand.Card.Point.A6)
        ));
        Hand handB = new Hand(asList(
                new Hand.Card(Hand.Card.Suits.FANGKUAI, Hand.Card.Point.A2),
                new Hand.Card(Hand.Card.Suits.FANGKUAI, Hand.Card.Point.A3),
                new Hand.Card(Hand.Card.Suits.FANGKUAI, Hand.Card.Point.A4),
                new Hand.Card(Hand.Card.Suits.FANGKUAI, Hand.Card.Point.A5),
                new Hand.Card(Hand.Card.Suits.FANGKUAI, Hand.Card.Point.A7)
        ));

        Hand handC = new Hand(asList(
                new Hand.Card(Hand.Card.Suits.FANGKUAI, Hand.Card.Point.A12),
                new Hand.Card(Hand.Card.Suits.FANGKUAI, Hand.Card.Point.A13),
                new Hand.Card(Hand.Card.Suits.FANGKUAI, Hand.Card.Point.A14),
                new Hand.Card(Hand.Card.Suits.FANGKUAI, Hand.Card.Point.A11),
                new Hand.Card(Hand.Card.Suits.FANGKUAI, Hand.Card.Point.A10)
        ));

        TexasCompare texasCompare = new TexasCompare();
        texasCompare.sort(hand);
        texasCompare.sort(handA);
        texasCompare.sort(handB);
        texasCompare.sort(handC);
        assertEquals(texasCompare.isRoyalFlush(hand), false);
        assertEquals(texasCompare.isRoyalFlush(handA), false);
        assertEquals(texasCompare.isRoyalFlush(handB), false);
        assertEquals(texasCompare.isRoyalFlush(handC), true);
    }

    @Test
    public void testStraightFlush() {
        Hand hand = new Hand(asList(
                new Hand.Card(Hand.Card.Suits.FANGKUAI, Hand.Card.Point.A2),
                new Hand.Card(Hand.Card.Suits.FANGKUAI, Hand.Card.Point.A3),
                new Hand.Card(Hand.Card.Suits.FANGKUAI, Hand.Card.Point.A4),
                new Hand.Card(Hand.Card.Suits.FANGKUAI, Hand.Card.Point.A5),
                new Hand.Card(Hand.Card.Suits.FANGKUAI, Hand.Card.Point.A6)
        ));
        Hand handA = new Hand(asList(
                new Hand.Card(Hand.Card.Suits.FANGKUAI, Hand.Card.Point.A12),
                new Hand.Card(Hand.Card.Suits.FANGKUAI, Hand.Card.Point.A13),
                new Hand.Card(Hand.Card.Suits.FANGKUAI, Hand.Card.Point.A14),
                new Hand.Card(Hand.Card.Suits.FANGKUAI, Hand.Card.Point.A11),
                new Hand.Card(Hand.Card.Suits.FANGKUAI, Hand.Card.Point.A10)
        ));
        TexasCompare texasCompare = new TexasCompare();
        texasCompare.sort(hand);
        texasCompare.sort(handA);
        assertTrue(texasCompare.isStraightFlush(hand));
        assertTrue(texasCompare.isRoyalFlush(handA));
    }

    @Test
    public void testIsFourOfKind() {
        Hand hand = new Hand(asList(
                new Hand.Card(Hand.Card.Suits.FANGKUAI, Hand.Card.Point.A2),
                new Hand.Card(Hand.Card.Suits.MEIHUA, Hand.Card.Point.A2),
                new Hand.Card(Hand.Card.Suits.HEITAO, Hand.Card.Point.A2),
                new Hand.Card(Hand.Card.Suits.HONGTAO, Hand.Card.Point.A2),
                new Hand.Card(Hand.Card.Suits.FANGKUAI, Hand.Card.Point.A6)
        ));

        TexasCompare texasCompare = new TexasCompare();
        texasCompare.sort(hand);
        assertTrue(texasCompare.isFourOfKind(hand));
    }

    @Test
    public void testIsFullHouse() {
        Hand hand = new Hand(asList(
                new Hand.Card(Hand.Card.Suits.FANGKUAI, Hand.Card.Point.A2),
                new Hand.Card(Hand.Card.Suits.MEIHUA, Hand.Card.Point.A2),
                new Hand.Card(Hand.Card.Suits.HEITAO, Hand.Card.Point.A2),
                new Hand.Card(Hand.Card.Suits.HONGTAO, Hand.Card.Point.A4),
                new Hand.Card(Hand.Card.Suits.FANGKUAI, Hand.Card.Point.A4)
        ));

        TexasCompare texasCompare = new TexasCompare();
        texasCompare.sort(hand);
        assertTrue(texasCompare.isFullHouse(hand));
        assertFalse(texasCompare.isFourOfKind(hand));
    }

    @Test
    public void testIsFlush() {
        Hand hand = new Hand(asList(
                new Hand.Card(Hand.Card.Suits.FANGKUAI, Hand.Card.Point.A2),
                new Hand.Card(Hand.Card.Suits.FANGKUAI, Hand.Card.Point.A7),
                new Hand.Card(Hand.Card.Suits.FANGKUAI, Hand.Card.Point.A10),
                new Hand.Card(Hand.Card.Suits.FANGKUAI, Hand.Card.Point.A14),
                new Hand.Card(Hand.Card.Suits.FANGKUAI, Hand.Card.Point.A8)
        ));

        TexasCompare texasCompare = new TexasCompare();
        texasCompare.sort(hand);
        assertTrue(texasCompare.isFlush(hand));

    }

    @Test
    public void testHand() {
        Hand handA = new Hand(asList(
                new Hand.Card(Hand.Card.Suits.FANGKUAI, Hand.Card.Point.A2),
                new Hand.Card(Hand.Card.Suits.MEIHUA, Hand.Card.Point.A7),
                new Hand.Card(Hand.Card.Suits.FANGKUAI, Hand.Card.Point.A10),
                new Hand.Card(Hand.Card.Suits.FANGKUAI, Hand.Card.Point.A14),
                new Hand.Card(Hand.Card.Suits.FANGKUAI, Hand.Card.Point.A8)
        ));
        Hand handB = new Hand(asList(
                new Hand.Card(Hand.Card.Suits.FANGKUAI, Hand.Card.Point.A2),
                new Hand.Card(Hand.Card.Suits.FANGKUAI, Hand.Card.Point.A7),
                new Hand.Card(Hand.Card.Suits.FANGKUAI, Hand.Card.Point.A10),
                new Hand.Card(Hand.Card.Suits.HONGTAO, Hand.Card.Point.A13),
                new Hand.Card(Hand.Card.Suits.FANGKUAI, Hand.Card.Point.A8)
        ));
        TexasCompare texasCompare = new TexasCompare();
        texasCompare.sort(handA);
        texasCompare.sort(handB);
        assertEquals(texasCompare.compare(handA, handB), "A");
    }

    @Test
    public void testHandFourOfKind() {
        Hand handA = new Hand(asList(
                new Hand.Card(Hand.Card.Suits.FANGKUAI, Hand.Card.Point.A2),
                new Hand.Card(Hand.Card.Suits.MEIHUA, Hand.Card.Point.A2),
                new Hand.Card(Hand.Card.Suits.HONGTAO, Hand.Card.Point.A2),
                new Hand.Card(Hand.Card.Suits.HEITAO, Hand.Card.Point.A2),
                new Hand.Card(Hand.Card.Suits.FANGKUAI, Hand.Card.Point.A8)
        ));
        Hand handB = new Hand(asList(
                new Hand.Card(Hand.Card.Suits.FANGKUAI, Hand.Card.Point.A7),
                new Hand.Card(Hand.Card.Suits.HEITAO, Hand.Card.Point.A7),
                new Hand.Card(Hand.Card.Suits.MEIHUA, Hand.Card.Point.A7),
                new Hand.Card(Hand.Card.Suits.HONGTAO, Hand.Card.Point.A7),
                new Hand.Card(Hand.Card.Suits.MEIHUA, Hand.Card.Point.A8)
        ));
        TexasCompare texasCompare = new TexasCompare();
        texasCompare.sort(handA);
        texasCompare.sort(handB);
        assertEquals(texasCompare.compare(handA, handB), "B");
    }
}
