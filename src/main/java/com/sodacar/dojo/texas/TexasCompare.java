package com.sodacar.dojo.texas;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


/**
 * @author Hu bosong
 * @date 2018/4/23
 */
public class TexasCompare {

    public String compare(Hand handA, Hand handB) {
        sort(handA);
        sort(handB);
        int typeA = checkType(handA);
        int typeB = checkType(handB);
        if (typeA > typeB) {
            return "A";
        } else if (typeA < typeB) {
            return "B";
        } else {
            return compareSameType(typeA, handA, handB);
        }
    }

    public int checkType(Hand hand) {
        if (isRoyalFlush(hand)) {
            return 9;
        } else if (isStraightFlush(hand)) {
            return 8;
        } else if (isFourOfKind(hand)) {
            return 7;
        } else if (isFullHouse(hand)) {
            return 6;
        } else if (isFlush(hand)) {
            return 5;
        } else if (isStraight(hand)) {
            return 4;
        } else if (isThreeOfKind(hand)) {
            return 3;
        } else if (isTwoPairs(hand)) {
            return 2;
        } else if (isOnePair(hand)) {
            return 1;
        }
        return 0;
    }

    public void sort(Hand hand) {
        hand.setCards(hand.getCards().stream().sorted().collect(Collectors.toList()));
    }

    public boolean isRoyalFlush(Hand hand) {
        if (isStraightFlush(hand) && hand.getCards().get(4).getPoint() == Hand.Card.Point.A14) {
            return true;
        }
        return false;
    }

    public boolean isStraightFlush(Hand hand) {
        List<Hand.Card> cards = hand.getCards();
        for (int i = 0; i < cards.size() - 1; i++) {
            if (cards.get(i).getSuits() != cards.get(i + 1).getSuits() ||
                    cards.get(i).getPoint().getNum() - cards.get(i + 1).getPoint().getNum() != -1)
                return false;
        }
        return true;
    }

    public boolean isFourOfKind(Hand hand) {
        Map<Integer, Long> map = group(hand);
        return map.size() == 2 && map.values().stream().anyMatch(value -> value == 4);
    }

    public boolean isFullHouse(Hand hand) {
        Map<Integer, Long> map = group(hand);
        return map.size() == 2 && map.values().stream().anyMatch(value -> value == 3);
    }

    public boolean isFlush(Hand hand) {
        return hand.getCards().stream().allMatch(card -> card.getSuits() == hand.getCards().get(0).getSuits());
    }

    public boolean isStraight(Hand hand) {
        List<Integer> points = hand.getCards().stream().map(Hand.Card::getPoint).map(Hand.Card.Point::getNum).collect(Collectors.toList());
        for (int i = 0; i < points.size() - 1; i++) {
            if (points.get(i) - points.get(i + 1) != 1) {
                return false;
            }
        }
        return true;
    }

    public boolean isThreeOfKind(Hand hand) {
        Map<Integer, Long> map = group(hand);
        return map.size() == 3 && map.values().stream().anyMatch(value -> value == 3);
    }

    public boolean isTwoPairs(Hand hand) {
        Map<Integer, Long> map = group(hand);
        return map.size() == 3 && map.values().stream().anyMatch(value -> value == 2);
    }

    public boolean isOnePair(Hand hand) {
        Map<Integer, Long> map = group(hand);
        return map.size() == 4 && map.values().stream().anyMatch(value -> value == 2);
    }

    Map<Integer, Long> group(Hand hand) {
        return hand.getCards().stream().map(Hand.Card::getPoint).map(Hand.Card.Point::getNum)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public String compareSameType(int type, Hand handA, Hand handB) {
        if (type == 8 || type == 5 || type == 4 || type == 0) {
            if (handA.getCards().get(4).getPoint().getNum() > handB.getCards().get(4).getPoint().getNum()) {
                return "A";
            } else if (handA.getCards().get(4).getPoint().getNum() < handB.getCards().get(4).getPoint().getNum()) {
                return "B";
            }
        } else if (type == 7) {
            Map<Integer, Long> mapA = group(handA);
            Map<Integer, Long> mapB = group(handB);
            Integer A = mapA.entrySet().stream().filter( $ -> mapA.get($.getKey()) == 4).findFirst().get().getKey();
            Integer B = mapB.entrySet().stream().filter( $ -> mapB.get($.getKey()) == 4).findFirst().get().getKey();
            if(A > B) {
                return "A";
            } else if(A < B) {
                return "B";
            }
        } else if(type == 6 ){
            Map<Integer, Long> mapA = group(handA);
            Map<Integer, Long> mapB = group(handB);
            Integer A = mapA.entrySet().stream().filter( $ -> mapA.get($.getKey()) == 3).findFirst().get().getKey();
            Integer B = mapB.entrySet().stream().filter( $ -> mapB.get($.getKey()) == 3).findFirst().get().getKey();
            if(A > B) {
                return "A";
            } else if(A < B) {
                return "B";
            }
        } else if(type == 3 ){
            Map<Integer, Long> mapA = group(handA);
            Map<Integer, Long> mapB = group(handB);
            Integer A = mapA.entrySet().stream().filter( $ -> mapA.get($.getKey()) == 3).findFirst().get().getKey();
            Integer B = mapB.entrySet().stream().filter( $ -> mapB.get($.getKey()) == 3).findFirst().get().getKey();
            if(A > B) {
                return "A";
            } else if(A < B) {
                return "B";
            }
        } else if(type == 1) {
            Map<Integer, Long> mapA = group(handA);
            Map<Integer, Long> mapB = group(handB);
            Integer A = mapA.entrySet().stream().filter( $ -> mapA.get($.getKey()) == 2).findFirst().get().getKey();
            Integer B = mapB.entrySet().stream().filter( $ -> mapB.get($.getKey()) == 2).findFirst().get().getKey();
            if(A > B) {
                return "A";
            } else if(A < B) {
                return "B";
            }
        } else if(type == 2) {
            Map<Integer, Long> mapA = group(handA);
            Map<Integer, Long> mapB = group(handB);
            List<Map.Entry<Integer, Long>> listA = mapA.entrySet().stream().filter($ -> mapA.get($.getKey()) == 2).sorted().collect(Collectors.toList());
            List<Map.Entry<Integer, Long>> listB = mapB.entrySet().stream().filter($ -> mapA.get($.getKey()) == 2).sorted().collect(Collectors.toList());
            for (int i = 0; i < listA.size(); i++) {
                if(listA.get(i).getKey() > listB.get(i).getKey()) {
                    return "A";
                } else if(listA.get(i).getKey() < listB.get(i).getKey()) {
                    return "B";
                }
            }
            Integer A = mapA.entrySet().stream().filter( $ -> mapA.get($.getKey()) == 1).findFirst().get().getKey();
            Integer B = mapB.entrySet().stream().filter( $ -> mapB.get($.getKey()) == 1).findFirst().get().getKey();
            if(A > B) {
                return "A";
            } else if(A < B) {
                return "B";
            }
        }
        return "";
    }
}
