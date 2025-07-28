package model;

import java.util.Objects;

public class Member implements Comparable<Member> {
    private long idCounter = 0;
    private long id;
    private String name;
    private double reputationScore;

    public Member(long id, String name, double reputationScore) {
        this.id = ++idCounter;
        this.name = name;
        this.reputationScore = reputationScore;
    }

    public void increaseReputation() {
        this.reputationScore += 1;
    }

    public long getIdCounter() {
        return idCounter;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getReputationScore() {
        return reputationScore;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return id == member.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public int compareTo(Member o) {
        return Double.compare(this.reputationScore, o.reputationScore);
    }
}