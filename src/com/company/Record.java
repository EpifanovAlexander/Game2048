package com.company;

public class Record {
    private final long idPlayer;
    private final String namePlayer;
    private final long score;

    public Record(long idPlayer, String namePlayer, long score){
        this.idPlayer = idPlayer;
        this.namePlayer = namePlayer;
        this.score = score;
    }

    public long getId(){
        return idPlayer;
    }

    public String getName(){
        return namePlayer;
    }

    public long getScore(){
        return score;
    }

    @Override
    public String toString() {
        return "Record{" +
                "idPlayer=" + idPlayer +
                ", namePlayer='" + namePlayer + '\'' +
                ", score=" + score +
                '}';
    }
}
