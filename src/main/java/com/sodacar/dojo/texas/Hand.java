package com.sodacar.dojo.texas;

import java.util.List;

/**
 * @author Hu bosong
 * @date 2018/4/23
 */
public class Hand {

    private List<Card> cards;

    public static class Card implements Comparable<Card>{

        private Suits suits;

        private Point point;

        public Card(Suits suits, Point point) {
            this.suits = suits;
            this.point = point;
        }

        public Suits getSuits() {
            return suits;
        }

        public void setSuits(Suits suits) {
            this.suits = suits;
        }

        public Point getPoint() {
            return point;
        }

        public void setPoint(Point point) {
            this.point = point;
        }

        @Override
        public int compareTo(Card o) {
            if(o.point.num > this.point.num)
                return -1;
            if(o.point.num < this.point.num)
                return 1;
            return 0;
        }

        public enum Suits {
            MEIHUA,
            HONGTAO,
            FANGKUAI,
            HEITAO
        }

        public enum Point {
            A2(2),
            A3(3),
            A4(4),
            A5(5),
            A6(6),
            A7(7),
            A8(8),
            A9(9),
            A10(10),
            A11(11),
            A12(12),
            A13(13),
            A14(14);

            private int num;

            Point(int num) {
                this.num = num;
            }

            public int getNum() {
                return num;
            }

            public void setNum(int num) {
                this.num = num;
            }
        }
    }

    public Hand(List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

}
